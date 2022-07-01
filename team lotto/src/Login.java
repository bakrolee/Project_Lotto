import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class Login extends JFrame implements MouseListener{
	private JTextField jt;
	public Login() {
		
		super("Login");
		JPanel pnl = new JPanel();
		jt = new JTextField("ID를 입력하세요");
		jt.addMouseListener(this);
		JLabel jb = new JLabel("ID :");
		JButton btn = new JButton("로그인");
		JButton btn1 = new JButton("회원가입"); // 누르면 회원가입창 뜨게 ㄱㄱ
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignUp dialog = new SignUp(Login.this);
				dialog.show();
			}
		});
		SpringLayout sl_pnl = new SpringLayout();
		sl_pnl.putConstraint(SpringLayout.EAST, btn1, 0, SpringLayout.EAST, jt);
		sl_pnl.putConstraint(SpringLayout.NORTH, btn, 17, SpringLayout.SOUTH, jt);
		sl_pnl.putConstraint(SpringLayout.SOUTH, btn, -34, SpringLayout.SOUTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, btn1, 11, SpringLayout.EAST, btn);
		sl_pnl.putConstraint(SpringLayout.WEST, btn, 0, SpringLayout.WEST, jb);
		sl_pnl.putConstraint(SpringLayout.EAST, btn, -177, SpringLayout.EAST, pnl);
		sl_pnl.putConstraint(SpringLayout.NORTH, btn1, 17, SpringLayout.SOUTH, jt);
		sl_pnl.putConstraint(SpringLayout.SOUTH, btn1, -34, SpringLayout.SOUTH, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, jt, -80, SpringLayout.SOUTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, jb, 42, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.NORTH, jt, 32, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.NORTH, jb, 7, SpringLayout.NORTH, jt);
		sl_pnl.putConstraint(SpringLayout.WEST, jt, 67, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, jt, -51, SpringLayout.EAST, pnl);
		pnl.setLayout(sl_pnl);
		
		pnl.add(jt);
		pnl.add(btn);
		pnl.add(btn1);
		pnl.add(jb);
		getContentPane().add(pnl);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(350, 180);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			jt.setText("");
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}

	public static void main(String[] args) {
		new Login().setVisible(true);
	}
}