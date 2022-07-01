import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JFrame {
	private int roundNum = 1000;
	private String[] lottoCnt = {"1", "2", "3", "4", "5(최대)"};
	private BuyLotto buyFrame;
	private LottoResult lottoResult;
	
	public MainMenu() {
		super("로또 프로그램");
		JPanel total = new JPanel();
		JPanel top = new JPanel();
		JPanel bottom = new JPanel();
		JPanel buttons = new JPanel();
		
		// top & 메인 배너
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		URL url = MainMenu.class.getClassLoader().getResource("images/로또로고.png"); 
		Image img1 = kit.getImage(url);
		Image logoImg = img1.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		JLabel logo = new JLabel(new ImageIcon(logoImg));
		JLabel round = new JLabel(roundNum + " 회");
		
		top.add(logo);
		top.add(round);
		
		// 구매 장수 선택 
		JLabel lblCnt = new JLabel("구매 장수 선택");
		JComboBox combo = new JComboBox(lottoCnt);
		bottom.add(lblCnt);
		bottom.add(combo);
		
		// 여러 버튼들
		JButton btnSign = new JButton("회원가입");
		JButton btnBuy = new JButton("구매하기");
		JButton btnEnd = new JButton("결과확인");
		
		// 회원가입 버튼 연결
		btnSign.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignUp signUp = new SignUp(MainMenu.this);
				signUp.setVisible(true);
			}
		});
		
		// 구매하기 버튼 연결
		btnBuy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buyFrame = new BuyLotto();
				buyFrame.setVisible(true);
			}
		});
		
		// 당첨 결과 버튼 연결
		btnEnd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lottoResult = new LottoResult();
				lottoResult.setVisible(true);
			}
		});
		
		buttons.add(btnSign);
		buttons.add(btnBuy);
		buttons.add(btnEnd);
		
		total.add(top);
		total.add(bottom);
		total.add(buttons);
		add(total);
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MainMenu().setVisible(true);
	}
}
