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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class BuyLotto extends JDialog {
	private List<Integer> oneLotto;
	private List<List<Integer>> fiveLotto;
	private int buyCnt;
	// 수정필요
	private JLabel[] lblNums = new JLabel[6];
	private List<JLabel[]> moons;
	private JButton[][] toolBtns;

	public int getBuyCnt() {
		return buyCnt;
	}

	public void setBuyCnt(int buyCnt) {
		this.buyCnt = buyCnt;
	}

	public List<JLabel[]> getMoons() {
		return moons;
	}

	public void setMoons(List<JLabel[]> moons) {
		this.moons = moons;
	}

	public BuyLotto(JFrame owner) {
		super(owner, true);

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

		// 나중에 메소드로 owner의 count값 전달받을 예정.
		buyCnt = 3;

		// 그림 생성 -> 나중에 text값만 바꿔주면 됨.
		moons = ImgLines(buyCnt, moonLight, moonGray);
		JPanel[] pnlFive = fivePanel();
		JPanel packFive = new JPanel();
		packFive.setLayout(new BoxLayout(packFive, BoxLayout.Y_AXIS));

		for (int i = 0; i < pnlFive.length; i++) {
			for (int j = 0; j < moons.get(i).length; j++) {
				pnlFive[i].add(moons.get(i)[j]);
				packFive.add(pnlFive[i]);
			}
		}

		// 오토 버튼클릭시 이벤트 발생
		ActionListener auto = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("오토입니다~");
			}
		};

		// 수동버튼 클릭시 번호선택창 띄우기
		ActionListener manual = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SelectNumber dialog = new SelectNumber(BuyLotto.this);
				dialog.setIndex(0);
				dialog.setVisible(true);
			}
		};

		// 번호 수정 버튼 (넘 힘들었다...)
		ActionListener edit = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (oneLotto.isEmpty()) {
					JOptionPane.showMessageDialog(null, "번호를 선택해주세요.");
				} else {
					LottoEdit dialog = new LottoEdit(BuyLotto.this);
					dialog.setVisible(true);
				}
			}
		};

		// 버튼 구매 개수에 따라 생성하기
		JPanel packFive2 = new JPanel();
		JPanel[] pnlCnt = makePanel(buyCnt);
		packFive2.setLayout(new BoxLayout(packFive2, BoxLayout.Y_AXIS));

		// 방법선택(auto, 수동&반자동, edit, reset) 들어갈 panel -> 이거 6개 만들어야 되서 메소드로 나중에 만들기
		toolBtns = new JButton[buyCnt][3];
		for (int i = 0; i < buyCnt; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					toolBtns[i][j] = new JButton("Auto");
					toolBtns[i][j].addActionListener(auto);
				} else if (j == 1) {
					toolBtns[i][j] = new JButton("수동 & 반자동");
					toolBtns[i][j].addActionListener(manual(i));
				} else {
					toolBtns[i][j] = new JButton("Edit");
					toolBtns[i][j].addActionListener(edit);
				}
			}
		}

		for (int i = 0; i < pnlCnt.length; i++) {
			for (int j = 0; j < toolBtns[i].length; j++) {
				pnlCnt[i].add(toolBtns[i][j]);
				packFive2.add(pnlCnt[i]);
			}
		}

		pnl.add(btnBuy);
		pnl.add(packFive);
		pnl.add(packFive2);
		pnlTotal.add(pnl);

		add(pnlTotal);

		setModal(true);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	// auto버튼
	public ActionListener auto(int index) {
		ActionListener temp = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SelectNumber dialog = new SelectNumber(BuyLotto.this);
				dialog.setIndex(index);
				dialog.setVisible(true);
			}
		};
		return temp;
	}

	// 수동버튼
	public ActionListener manual(int index) {
		ActionListener temp = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SelectNumber dialog = new SelectNumber(BuyLotto.this);
				dialog.setIndex(index);
				dialog.setVisible(true);
			}
		};
		return temp;
	}
	
	// edit버튼
	public ActionListener edit(int index) {
		ActionListener temp = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (fiveLotto.get(index).isEmpty()) {
					JOptionPane.showMessageDialog(null, "번호를 선택해주세요.");
				} else {
					LottoEdit dialog = new LottoEdit(BuyLotto.this);
					dialog.setIndex(index);
					dialog.setVisible(true);
				}
			}
		};
		return temp;
	}

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
	public void setList(List<Integer> list, JLabel[] lbls) {
		this.oneLotto = list;
		// 수정 필요
		for (int i = 0; i < oneLotto.size(); i++) {
			lbls[i].setText(String.valueOf(oneLotto.get(i)));
		}
	}

	// 5줄에 값 넣기
	public void addList(List<Integer> list) {
		fiveLotto.add(oneLotto);
	}

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
//				pnlSelected.add(labels[i]);
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
}
