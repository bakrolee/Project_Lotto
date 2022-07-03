import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class SignUp extends JDialog {
	private JButton jb1;
	private JTextField jf;
	private JTextField jf2;

	public SignUp(JFrame owner) {
		super(owner, true);

		setTitle("Signup");
		JPanel pnl = new JPanel();
		JLabel jl = new JLabel("ID: ");
		JLabel jl2 = new JLabel("Name: ");

		JTextField jf = new JTextField();
		JTextField jf2 = new JTextField();
		JButton btnSign = new JButton("가입완료");
		JButton jb1 = new JButton("돌아가기");
		
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnSign.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (getOwner() instanceof JFrame) {
					if (e.getSource() == btnSign) {
					MainMenu menu = (MainMenu) getOwner();
					menu.getMembers().addMember(jf2.getText(), jf.getText());
					}
				
				dispose();
				}
			}
		});
		
		SpringLayout sl_pnl = new SpringLayout();
		sl_pnl.putConstraint(SpringLayout.EAST, jl, -245, SpringLayout.EAST, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, jf2, -56, SpringLayout.EAST, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, jf, 98, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, jf, -56, SpringLayout.EAST, pnl);
		sl_pnl.putConstraint(SpringLayout.NORTH, jl2, 3, SpringLayout.NORTH, jf);
		sl_pnl.putConstraint(SpringLayout.EAST, jl2, 0, SpringLayout.EAST, jl);
		sl_pnl.putConstraint(SpringLayout.NORTH, jl, 3, SpringLayout.NORTH, jf2);
		sl_pnl.putConstraint(SpringLayout.NORTH, jf2, 53, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, jf2, -187, SpringLayout.SOUTH, pnl);
		sl_pnl.putConstraint(SpringLayout.NORTH, jf, 26, SpringLayout.SOUTH, jf2);
		sl_pnl.putConstraint(SpringLayout.WEST, jf2, 98, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.NORTH, btnSign, 161, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, jb1, 170, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, jb1, -56, SpringLayout.EAST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, btnSign, -69, SpringLayout.SOUTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, btnSign, 50, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, btnSign, -12, SpringLayout.WEST, jb1);
		sl_pnl.putConstraint(SpringLayout.NORTH, jb1, 0, SpringLayout.NORTH, btnSign);
		sl_pnl.putConstraint(SpringLayout.SOUTH, jb1, -69, SpringLayout.SOUTH, pnl);
		pnl.setLayout(sl_pnl);
		pnl.add(jl);
		pnl.add(jl2);
		pnl.add(jf);
		pnl.add(jf2);
		pnl.add(btnSign);
		pnl.add(jb1);

		getContentPane().add(pnl);

		setSize(350, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
}
