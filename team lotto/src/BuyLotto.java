import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class SelectNumber extends JDialog implements ActionListener {
	private JCheckBox[] cbNumbers = new JCheckBox[45];
	private int count = 0;
	private List<Integer> list = new ArrayList();
	private List<JLabel> lblSelNums = new ArrayList();
	private JButton btnOK;

	public SelectNumber(JDialog owner) {
		super(owner, "번호 선택창", true);
		JPanel pnl = new JPanel();
		JPanel pnlNumbers = new JPanel();

		ItemListener item = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				JCheckBox cb = (JCheckBox) e.getSource();

				if (e.getStateChange() == ItemEvent.SELECTED) {
					int num = Integer.valueOf(selectNum(cb));
					lblSelNums.get(count).setText(String.format("%02d", num));
					count++;
				} else {
					int index = list.indexOf(Integer.valueOf(cb.getText()));
					cancelNum(cb);
					pnlNumbers.remove(lblSelNums.get(index));
					lblSelNums.remove(index);
					pnlNumbers.revalidate();
					pnlNumbers.repaint();
					lblSelNums.add(new JLabel());
					int lastIndex = lblSelNums.size() - 1;
					pnlNumbers.add(lblSelNums.get(lastIndex));
					count--;
				}

				if (count == 6) {
					disableCB();
				} else if (count < 6) {
					enableCB();
				}
			}
		};

		JPanel checks = new JPanel(new GridLayout(5, 9));

		for (int i = 0; i < cbNumbers.length; i++) {
			int num = 1 + i;
			cbNumbers[i] = new JCheckBox(String.valueOf(num));
			cbNumbers[i].addItemListener(item);

			checks.add(cbNumbers[i]);
		}
		pnl.add(checks);

		// 레이블을 패널에 추가하기
		for (int i = 0; i < 6; i++) {
			lblSelNums.add(new JLabel());
			pnlNumbers.add(lblSelNums.get(i));
		}

		pnl.add(pnlNumbers);

		btnOK = new JButton("선택 완료");
		JButton btnBack = new JButton("돌아가기");

		btnOK.addActionListener(this);

		pnl.add(btnOK);
		pnl.add(btnBack);

		add(pnl);
		setSize(400, 400);

	}

	// 체크 비활성화 메소드
	public void disableCB() {
		for (int i = 0; i < cbNumbers.length; i++) {
			if (!cbNumbers[i].isSelected()) {
				cbNumbers[i].setSelected(false);
				cbNumbers[i].setEnabled(false);
			}
		}
	}

	// 체크 활성화 메소드
	public void enableCB() {
		for (int i = 0; i < cbNumbers.length; i++) {
			cbNumbers[i].setEnabled(true);
		}
	}

	// 로또 번호 선택(추가)
	public String selectNum(JCheckBox cb) {
		list.add(Integer.valueOf(cb.getText()));
		System.out.println(list.toString());
		return cb.getText();
	}

	// 로또 번호 취소
	public void cancelNum(JCheckBox cb) {
		list.remove(Integer.valueOf(cb.getText()));
		System.out.println(list.toString());
	}

	// (선택완료 버튼 눌렀을 때) 값 반환하는 메소드
	public List<Integer> compleList() {
		return list;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (getOwner() instanceof BuyLotto) {
			if (e.getSource() == btnOK) {
				BuyLotto lotto = (BuyLotto) getOwner();
				lotto.setList(list);
			}
		}
		dispose();
	}
}

public class BuyLotto extends JDialog {
	private List<Integer> oneLotto;
	private List<List<Integer>> fiveLotto;
	// 수정필요
	private JLabel[] labels = new JLabel[6];

	public List<List<Integer>> getFiveLotto() {
		return fiveLotto;
	}

	public void setFiveLotto(List<List<Integer>> fiveLotto) {
		this.fiveLotto = fiveLotto;
	}

	public List<Integer> getList() {
		return oneLotto;
	}

	// 선택완료 버튼과 소통 (with dialog) -> 수정필요 : edit로 했을때 값은 들어가는데, 레이블에 안 들어가는문제!
	public void setList(List<Integer> list) {
		this.oneLotto = list;
		// 수정 필요
		for (int i = 0; i < oneLotto.size(); i++) {
			labels[i].setText(String.valueOf(oneLotto.get(i)));
		}
	}

	// 지금 할 것
	// 1. 패널 5줄을 만들기
	// 2. 패널에 들어갈 로또이미지 5줄 (밝은 달)
	// 3. 패널에 들어갈 쟃빛달 5줄
	// 4. 조건문 걸어서 구매수량(-> 매개변수로 받음)에 따라서 밝은 달 이미지 넣고 or 보이게 하기
	// 나머지(=5 - 구매수량)만큼은 쟃빛달 이미지 넣기 or 보이게 하기
	// 5. 그다음에 로또 생성 버튼 누르면 값을 레이블에 넣으면 됨.

	public JPanel[] fivePanel() {
		JPanel[] pnls = new JPanel[5];
		for (int i = 0; i < 5; i++) {
			pnls[i] = new JPanel();
		}
		return pnls;
	}

	// 패널 만드는 메소드
	public JPanel[] makePanel(int num) {
		JPanel[] pnls = new JPanel[num];
		for (int i = 0; i < pnls.length; i++) {
			pnls[i] = new JPanel();
		}
		return pnls;
	}

	// 이미지 담긴 레이블(size 6) 만드는 메소드
	public JLabel[] makeImgLbl(Image img) {
		JLabel[] lbls = new JLabel[6];
		for (int i = 0; i < lbls.length; i++) {
			lbls[i] = new JLabel("", new ImageIcon(img), JLabel.CENTER);
			lbls[i].setHorizontalTextPosition(JLabel.CENTER);
//			pnlSelected.add(labels[i]);
		}
		return lbls;
	}

	// 이미지레이블 배열을 담을 List를 만드는 메소드
	public List<JLabel[]> ImgLines(int buyCnt, Image Light, Image Gray) {
		List<JLabel[]> list = new ArrayList<>();
		switch (buyCnt) {
		case 1:
			for (int i = 0; i < buyCnt; i++) {
				list.add(makeImgLbl(Light));
			}
			for (int i = 0; i < 5 - buyCnt; i++) {
				list.add(makeImgLbl(Gray));
			}
			return list;
		case 2:
			for (int i = 0; i < buyCnt; i++) {
				list.add(makeImgLbl(Light));
			}
			for (int i = 0; i < 5 - buyCnt; i++) {
				list.add(makeImgLbl(Gray));
			}
			return list;
		case 3:
			for (int i = 0; i < buyCnt; i++) {
				list.add(makeImgLbl(Light));
			}
			for (int i = 0; i < 5 - buyCnt; i++) {
				list.add(makeImgLbl(Gray));
			}
			return list;
		case 4:
			for (int i = 0; i < buyCnt; i++) {
				list.add(makeImgLbl(Light));
			}
			for (int i = 0; i < 5 - buyCnt; i++) {
				list.add(makeImgLbl(Gray));
			}
			return list;
		case 5:
			for (int i = 0; i < buyCnt; i++) {
				list.add(makeImgLbl(Light));
			}
			for (int i = 0; i < 5 - buyCnt; i++) {
				list.add(makeImgLbl(Gray));
			}
			return list;
		}
		return list;
	}

	//

	public BuyLotto() {
		JPanel pnlTotal = new JPanel();
		JPanel pnl = new JPanel();
		JButton btnBuy = new JButton("구매완료");

		// 숫자 6개 (그림, 숫자) 들어갈 panel -> 이거 6개 만들어야 되서 메소드로 나중에 만들기
//		JPanel pnlSelected = new JPanel();

		Toolkit kit = Toolkit.getDefaultToolkit();
		URL url = BuyLotto.class.getClassLoader().getResource("images/보름달.png");
		Image img1 = kit.getImage(url);
		Image moonLight = img1.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		URL url2 = BuyLotto.class.getClassLoader().getResource("images/잿빛달.png");
		Image img2 = kit.getImage(url2);
		Image moonGray = img2.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		int buyCnt = 3;
		List<JLabel[]> moons = ImgLines(buyCnt, moonLight, moonGray);
		JPanel[] pnlFive = fivePanel();
		JPanel packFive = new JPanel();
		packFive.setLayout(new BoxLayout(packFive, BoxLayout.Y_AXIS));

		for (int i = 0; i < pnlFive.length; i++) {
			for (int j = 0; j < moons.get(i).length; j++) {
				pnlFive[i].add(moons.get(i)[j]);
				packFive.add(pnlFive[i]);
			}
		}

		// 버튼 구매 개수에 따라 생성하기
		JPanel packFive2 = new JPanel();
		packFive2.setLayout(new BoxLayout(packFive2, BoxLayout.Y_AXIS));

		// 오토 버튼클릭시 이벤트 발생
		ActionListener auto = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		};

		// 수동버튼 클릭시 번호선택창 띄우기
		ActionListener manual = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SelectNumber dialog = new SelectNumber(BuyLotto.this);
				dialog.setVisible(true);
			}
		};

		// 번호 수정 버튼 (넘 힘들었다...)
		ActionListener edit = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LottoEdit dialog = new LottoEdit(BuyLotto.this);
				dialog.setVisible(true);
			}
		};

		// 방법선택(auto, 수동&반자동, edit, reset) 들어갈 panel -> 이거 6개 만들어야 되서 메소드로 나중에 만들기
		JPanel pnlWay = new JPanel();
		JRadioButton btnAuto = new JRadioButton("Auto");
		JRadioButton btnManual = new JRadioButton("수동 & 반자동");
		JRadioButton btnEdit = new JRadioButton("수정");
		ButtonGroup group = new ButtonGroup();
		group.add(btnAuto);
		group.add(btnManual);
		group.add(btnEdit);

		pnlWay.add(btnAuto);
		pnlWay.add(btnManual);
		pnlWay.add(btnEdit);

		//
		pnl.add(btnBuy);
		pnl.add(packFive);
		pnl.add(packFive2);
//		pnl.add(pnlSelected);
		pnl.add(pnlWay);
		pnlTotal.add(pnl);

		add(pnlTotal);

		setModal(true);
		setSize(500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
