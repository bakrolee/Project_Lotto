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
	private boolean loginPass;
	
	
	public Login() {
		setModal(true);
		setTitle("로그인");
		JPanel pnl = new JPanel();
		inputID = new JTextField("");
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
		
		btnSignUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String key = inputID.getText();
				
				if (SignUp.getIdForLogin().contains(key) ) {
					JOptionPane.showMessageDialog(null, "로그인 성공");
					inputID.setText("");
					loginPass = true;
				
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "등록되지 않은 ID입니다.");
					inputID.setText("");
				}
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
		
		setLocationRelativeTo(null);
		setSize(350, 180);
	}


	public boolean  isLoginPass() {
		
	
		return loginPass;
	}


	public void setLoginPass(boolean loginPass) {
		this.loginPass = loginPass;
	}
}