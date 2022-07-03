import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class BuyLotto2 extends JDialog{
	private List<Integer> oneLotto;
	private List<List<Integer>> fiveLotto;
	private JLabel[] labels = new JLabel[6];

	public List<Integer> getList() {
		return oneLotto;
	}

	// 선택완료 버튼과 소통 (with dialog) -> 수정필요 : edit로 했을때 값은 들어가는데, 레이블에 안 들어가는문제!
	public void setList(List<Integer> list) {
		this.oneLotto = list;
		System.out.println(oneLotto.get(0));
		for (int i = 0; i < oneLotto.size(); i++) {
			labels[i].setText(String.valueOf(oneLotto.get(i)));
		}
	}

	public BuyLotto2()  {
		JPanel pnlTotal = new JPanel();
		JPanel pnl = new JPanel();
		JButton btnBuy = new JButton("구매완료");
		
		// 숫자 6개 (그림, 숫자) 들어갈 panel -> 이거 6개 만들어야 되서 메소드로 나중에 만들기
		JPanel pnlSelected = new JPanel();
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		URL url = BuyLotto.class.getClassLoader().getResource("images/보름달.png");
		Image img1 = kit.getImage(url);
		Image moonImg = img1.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		JLabel lbl1 = new JLabel(new ImageIcon(moonImg));
		
		for (int i = 0; i < 6; i++) {
			labels[i] = new JLabel("", new ImageIcon(moonImg), JLabel.CENTER);
			labels[i].setHorizontalTextPosition(JLabel.CENTER);
			pnlSelected.add(labels[i]);
		}
		
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
		
		
		// 수동 클릭시 번호선택창 띄우기
		btnManual.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SelectNumber dialog = new SelectNumber(BuyLotto2.this);
				dialog.setVisible(true);
			}
		});

		// 번호 수정 버튼 (넘 힘들었다...)
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LottoEdit dialog = new LottoEdit(BuyLotto2.this);
				dialog.setVisible(true);
			}
		});
		
		// 
		pnl.add(btnBuy);
		pnl.add(pnlSelected);
		pnl.add(pnlWay);
		pnlTotal.add(pnl);
		
		add(pnlTotal);
		
		setModal(true);
		setSize(500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
