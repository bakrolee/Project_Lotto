import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class Login extends JDialog {
	private Map<String, String> members = new HashMap<>();
	private JButton btnLogin;
	private JTextField inputID;
	
	public Login() {
		setTitle("로그인");
		JPanel pnl = new JPanel();
		inputID = new JTextField("ID를 입력하세요");
		inputID.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					inputID.setText("");
				}
			}
		});
		JLabel jb = new JLabel("ID :");
		
		btnLogin = new JButton("로그인");
		JButton btnSignUp = new JButton("회원가입"); // 누르면 회원가입창 뜨게 ㄱㄱ
		
//		btnLogin.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String key = inputID.getText();
//				members.containsKey(key);
//				if (!members.containsKey(key)) {
//					JOptionPane.showMessageDialog(null, "로그인 성공");
//					inputID.setText("");
//					BuyLotto buylotto = new BuyLotto();
//					buylotto.setVisible(true);
//				} else {
//					JOptionPane.showMessageDialog(null, "등록되지 않은 ID입니다.");
//					inputID.setText("");
//				}
//			}
//		});
		
		btnSignUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignUp dialog = new SignUp();
				dialog.setVisible(true);
			}
		});
		SpringLayout sl_pnl = new SpringLayout();
		sl_pnl.putConstraint(SpringLayout.EAST, btnSignUp, 0, SpringLayout.EAST, inputID);
		sl_pnl.putConstraint(SpringLayout.NORTH, btnLogin, 17, SpringLayout.SOUTH, inputID);
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnLogin, -34, SpringLayout.SOUTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, btnSignUp, 11, SpringLayout.EAST, btnLogin);
		sl_pnl.putConstraint(SpringLayout.WEST, btnLogin, 0, SpringLayout.WEST, jb);
		sl_pnl.putConstraint(SpringLayout.EAST, btnLogin, -177, SpringLayout.EAST, pnl);
		sl_pnl.putConstraint(SpringLayout.NORTH, btnSignUp, 17, SpringLayout.SOUTH, inputID);
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnSignUp, -34, SpringLayout.SOUTH, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, inputID, -80, SpringLayout.SOUTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, jb, 42, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.NORTH, inputID, 32, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.NORTH, jb, 7, SpringLayout.NORTH, inputID);
		sl_pnl.putConstraint(SpringLayout.WEST, inputID, 67, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, inputID, -51, SpringLayout.EAST, pnl);
		pnl.setLayout(sl_pnl);
		
		pnl.add(inputID);
		pnl.add(btnLogin);
		pnl.add(btnSignUp);
		pnl.add(jb);
		getContentPane().add(pnl);
		
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(350, 180);
	}
	
	public BuyLotto makeBuyLotto(BuyLotto buylotto) {
//		BuyLotto temp = new BuyLotto();
//		buylotto = temp;
		buylotto = new BuyLotto();
		buylotto.setVisible(true);
		return buylotto;
	}
	
	public void compleLogin(BuyLotto buylotto) {
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String key = inputID.getText();
				members.containsKey(key);
				if (!members.containsKey(key) ) {
					JOptionPane.showMessageDialog(null, "로그인 성공");
					inputID.setText("");
					makeBuyLotto(buylotto);
				} else {
					JOptionPane.showMessageDialog(null, "등록되지 않은 ID입니다.");
					inputID.setText("");
				}
			}
		});
	}
}