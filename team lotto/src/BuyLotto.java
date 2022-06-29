import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class SelectNumber extends JDialog {
	private JCheckBox[] cbNumbers = new JCheckBox[45];
	private int count = 0;
	
	public SelectNumber(JFrame owner) {
		super(owner, "번호 선택창", true);
		JPanel pnl = new JPanel();
		
		ItemListener item = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (count == 6) {
					for (int i = 0; i < cbNumbers.length; i++) {
						if (!cbNumbers[i].isSelected()) {
							cbNumbers[i].setSelected(false);
							cbNumbers[i].setEnabled(false);
						}
					} 
				} else {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						count++;
						System.out.println(count);
					} else {
						count--;
					}
				}
			}
		};
		
		for (int i = 0; i < cbNumbers.length; i++) {
			int num = 1 + i;
			cbNumbers[i] = new JCheckBox(String.valueOf(num));
			cbNumbers[i].addItemListener(item);
			
			pnl.add(cbNumbers[i]);
		}
		
		if (count == 6) {
			for (int i = 0; i < cbNumbers.length; i++) {
				if (!cbNumbers[i].isSelected()) {
					cbNumbers[i].setSelected(false);
				}
			}
		}
		
//		cbNum.enable(false);
		
		add(pnl);
		setSize(400, 400);
	}
	
//	// 체크박스 몇개 선택됐는지 카운트
//	public int countCb(JCheckBox[] cb) {
//		int count = 0;
//		for (int i = 0; i < cb.length; i++) {
//			if (cb[i].isSelected()) {
//				count++;
//			} 
//		}
//		return count;
//	}
//	
//	// 체크박스 카운트 제한 (3개이면 true)
//	public boolean isChecked() {
//		return countCb(cbNumbers) == 6;
//	}
	
	// 수정 -> action이벤트? 로 넣어야함.
	public void disableCB() {
		if (count == 6) {
			for (int i = 0; i < cbNumbers.length; i++) {
				if (!cbNumbers[i].isSelected()) {
					cbNumbers[i].setEnabled(false);
				}
			}
		}
	}
	
	//
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
//				dialog.disableCB();
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
