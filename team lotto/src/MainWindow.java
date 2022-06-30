import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.SpringLayout;

public class MainWindow extends JFrame  {
	private String[] number = {"           ���ż���" , "1ȸ" , "2ȸ" , "3ȸ" , "4ȸ" , "5ȸ\t(�ִ�)"};
	public void size(Graphics g) {	
	}
	public MainWindow() {		
		setTitle("Lotto"); 
		JPanel pnl = new JPanel();
		JButton btn3 = new JButton("���Ȯ��");
		JLabel jb = new JLabel("                 �� ?? ȸ"  );
		jb.setOpaque(true); // �� ������ �����ϱ���������
		jb.setBackground(Color.LIGHT_GRAY);
		JComboBox jc = new JComboBox(number); // �迭 ����Ʈ�׸����
		
		Toolkit kit = Toolkit.getDefaultToolkit(); // �̹��� ������ ��������
		
		URL url = MainWindow.class.getClassLoader().getResource("image/�ζǷΰ�.png"); // �̹����� ã���ִ�Ŭ����
		Image image = kit.getImage(url);
		
		image = image.getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		ImageIcon icon = new ImageIcon(image);
		SpringLayout sl_pnl = new SpringLayout();
		sl_pnl.putConstraint(SpringLayout.WEST, jb, 129, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, jb, 92, SpringLayout.EAST, jc);
		sl_pnl.putConstraint(SpringLayout.NORTH, jc, 292, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, jc, 37, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, jc, -140, SpringLayout.SOUTH, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, btn3, -39, SpringLayout.SOUTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, btn3, -41, SpringLayout.EAST, pnl);
		pnl.setLayout(sl_pnl);
		
		JLabel lbl = new JLabel(icon);
		sl_pnl.putConstraint(SpringLayout.NORTH, jb, 6, SpringLayout.SOUTH, lbl);
		sl_pnl.putConstraint(SpringLayout.WEST, lbl, 10, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.NORTH, lbl, 0, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.SOUTH, lbl, 230, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, lbl, 0, SpringLayout.EAST, pnl);
		pnl.add(lbl);
		
		pnl.setBackground(Color.white);
		pnl.add(btn3);
		
		JButton btn1 = new JButton("�����ϱ�");
		sl_pnl.putConstraint(SpringLayout.WEST, btn1, 223, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, btn1, -41, SpringLayout.EAST, pnl);
		sl_pnl.putConstraint(SpringLayout.NORTH, btn3, 21, SpringLayout.SOUTH, btn1);
		sl_pnl.putConstraint(SpringLayout.WEST, btn3, 0, SpringLayout.WEST, btn1);
		//btn1.setBounds(50, 170, 122, 50);
		pnl.add(btn1);
		JButton btn2 = new JButton("ȸ������");
		sl_pnl.putConstraint(SpringLayout.SOUTH, jb, -27, SpringLayout.NORTH, btn2);
		sl_pnl.putConstraint(SpringLayout.EAST, jc, -41, SpringLayout.WEST, btn2);
		sl_pnl.putConstraint(SpringLayout.NORTH, btn2, 0, SpringLayout.NORTH, jc);
		sl_pnl.putConstraint(SpringLayout.WEST, btn2, 223, SpringLayout.WEST, pnl);
		sl_pnl.putConstraint(SpringLayout.EAST, btn2, -41, SpringLayout.EAST, pnl);
		
		pnl.add(btn2);
		
		JLayeredPane layeredPane = new JLayeredPane();
		sl_pnl.putConstraint(SpringLayout.SOUTH, btn2, 0, SpringLayout.NORTH, layeredPane);
		sl_pnl.putConstraint(SpringLayout.NORTH, btn1, 21, SpringLayout.SOUTH, layeredPane);
		sl_pnl.putConstraint(SpringLayout.SOUTH, btn1, 50, SpringLayout.SOUTH, layeredPane);
		sl_pnl.putConstraint(SpringLayout.NORTH, layeredPane, 321, SpringLayout.NORTH, pnl);
		sl_pnl.putConstraint(SpringLayout.WEST, layeredPane, 282, SpringLayout.WEST, pnl);
		pnl.add(layeredPane);
		pnl.add(jb);
		pnl.add(jc);
		getContentPane().add(pnl);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(425, 500);
	}

	public static void main(String[] args) {
		new MainWindow().setVisible(true);
	}

}