import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class SelectNumber extends JDialog {
	private JCheckBox[] cbNumbers = new JCheckBox[45];
	private int count = 0;
	private List<Integer> list = new LinkedList();
	private JLabel[] lblSelNums = new JLabel[6];
	
	public SelectNumber(JFrame owner) {
		super(owner, "번호 선택창", true);
		JPanel pnl = new JPanel();
		
		for (int i = 0; i < 6; i++) {
			lblSelNums[i] = new JLabel();
		}
		
		ItemListener item = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				JCheckBox cb = (JCheckBox) e.getSource();
				int index = 0;
				
					if (e.getStateChange() == ItemEvent.SELECTED) {
						selectNum(cb);
						index = list.indexOf(Integer.valueOf(cb.getText()));
						lblSelNums[index].setText(cb.getText());
						count++;
						System.out.println("증가" + count);
					} else {
						index = list.indexOf(Integer.valueOf(cb.getText()));
						cancelNum(cb);
						lblSelNums[index].setText("");
						count--;
						System.out.println("감소" + count);
					}
				 if (count == 6) {
					disableCB();
				} else if (count < 6) {
					enableCB();
				}
				System.out.println("전체" + count);
			}
		};
		
		for (int i = 0; i < cbNumbers.length; i++) {
			int num = 1 + i;
			cbNumbers[i] = new JCheckBox(String.valueOf(num));
			cbNumbers[i].addItemListener(item);
			
			pnl.add(cbNumbers[i]);
		}
		
		for (int i = 0; i < 6; i++) {
			pnl.add(lblSelNums[i]);
		}
	
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
	
	// 체크박스 선택번호 불러오기
	public void selectNum(JCheckBox cb) {
		list.add(Integer.valueOf(cb.getText()));
		System.out.println(list.toString());
	}
	
	public void cancelNum(JCheckBox cb) {
		list.remove(Integer.valueOf(cb.getText()));
		System.out.println(list.toString());
	}
}

public class BuyLotto extends JFrame {
	public BuyLotto() {
		JPanel pnl = new JPanel();
		JButton btnBuy = new JButton("구매완료");
		
		// 숫자 6개 (그림, 숫자) 들어갈 panel -> 이거 6개 만들어야 되서 메소드로 나중에 만들기
		JPanel pnlSelected = new JPanel();
		JLabel lblNum = new JLabel("당첨 숫자1");
		pnlSelected.add(lblNum);
		
		// 방법선택(auto, 수동&반자동, edit, reset) 들어갈 panel -> 이거 6개 만들어야 되서 메소드로 나중에 만들기
		JPanel pnlWay = new JPanel();
		JLabel lblAuto = new JLabel("Auto");
		JLabel lblManual = new JLabel("수동 & 반자동");
		pnlWay.add(lblAuto);
		pnlWay.add(lblManual);
		
		// 수동 클릭시 번호선택창 띄우기
		MouseListener mouse = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SelectNumber dialog = new SelectNumber(BuyLotto.this);
//				dialog.addNumbers();
				dialog.setVisible(true);
				
			}
		};
		
		lblManual.addMouseListener(mouse);
		
		// 
		pnl.add(btnBuy);
		pnl.add(pnlSelected);
		pnl.add(pnlWay);
		
		add(pnl);
		
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new BuyLotto().setVisible(true);
	}
}
