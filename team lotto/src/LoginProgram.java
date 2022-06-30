import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class LoginProgram extends JFrame {
	private Map<String, char[]> members = new HashMap<>();
	
	@SuppressWarnings("null")
	public LoginProgram() {
		super("로그인 프로그램");
		// 제일 바깥 패널 (화면 전환 가능)
		CardLayout layout = new CardLayout();
		JPanel center = new JPanel(layout);
		
		// 화면 2개 (메인, 가입창)
		JPanel pnlMain = new JPanel();
		JPanel pnlRegi = new JPanel();
		
		// 메인창에 들어갈 컴포넌트
		JLabel text1 = new JLabel("ID");
		JLabel text2 = new JLabel("PW");
		JTextField tfMain = new JTextField(10);
		JPasswordField pfMain = new JPasswordField(10);
		JButton btnLogin = new JButton("로그인");
		JButton btnRegi = new JButton("회원가입");
		
		SpringLayout sl_pnlMain = new SpringLayout();
		sl_pnlMain.putConstraint(SpringLayout.WEST, tfMain, 108, SpringLayout.WEST, pnlMain);
		sl_pnlMain.putConstraint(SpringLayout.EAST, text1, -33, SpringLayout.WEST, tfMain);
		sl_pnlMain.putConstraint(SpringLayout.NORTH, text2, 3, SpringLayout.NORTH, pfMain);
		sl_pnlMain.putConstraint(SpringLayout.WEST, text2, 0, SpringLayout.WEST, text1);
		sl_pnlMain.putConstraint(SpringLayout.NORTH, text1, 3, SpringLayout.NORTH, tfMain);
		sl_pnlMain.putConstraint(SpringLayout.NORTH, btnRegi, -1, SpringLayout.NORTH, pfMain);
		sl_pnlMain.putConstraint(SpringLayout.WEST, btnRegi, 0, SpringLayout.WEST, btnLogin);
		sl_pnlMain.putConstraint(SpringLayout.NORTH, btnLogin, -1, SpringLayout.NORTH, tfMain);
		sl_pnlMain.putConstraint(SpringLayout.WEST, btnLogin, 71, SpringLayout.EAST, tfMain);
		sl_pnlMain.putConstraint(SpringLayout.NORTH, pfMain, 27, SpringLayout.SOUTH, tfMain);
		sl_pnlMain.putConstraint(SpringLayout.EAST, pfMain, 0, SpringLayout.EAST, tfMain);
		sl_pnlMain.putConstraint(SpringLayout.NORTH, tfMain, 40, SpringLayout.NORTH, pnlMain);
		pnlMain.setLayout(sl_pnlMain);
		
		pnlMain.add(text1);
		pnlMain.add(tfMain);
		pnlMain.add(text2);
		pnlMain.add(pfMain);
		pnlMain.add(btnLogin);
		pnlMain.add(btnRegi);
		
		// 가입창에 들어갈 컴포넌트
		JLabel text3 = new JLabel("ID");
		JLabel text4 = new JLabel("아이디 입력해주세요 (4자이상 12자 이하)");
		JLabel text5 = new JLabel("PW");
		JLabel text6 = new JLabel("비밀번호를 입력해주세요 (4자이상 12자 이하)");
		JLabel text7 = new JLabel("PW 확인");
		JTextField tfID = new JTextField(10);
		JPasswordField pfPW = new JPasswordField(10);
		JPasswordField pfPW2 = new JPasswordField(10);
		JButton btnCheck = new JButton("가입");
		JButton btnReturn = new JButton("돌아가기");
		
		SpringLayout sl_pnlRegi = new SpringLayout();
		sl_pnlRegi.putConstraint(SpringLayout.NORTH, btnReturn, -4, SpringLayout.NORTH, text7);
		sl_pnlRegi.putConstraint(SpringLayout.WEST, btnReturn, 19, SpringLayout.EAST, btnCheck);
		sl_pnlRegi.putConstraint(SpringLayout.NORTH, btnCheck, -4, SpringLayout.NORTH, text7);
		sl_pnlRegi.putConstraint(SpringLayout.WEST, btnCheck, 0, SpringLayout.WEST, text4);
		sl_pnlRegi.putConstraint(SpringLayout.EAST, text3, -13, SpringLayout.WEST, tfID);
		sl_pnlRegi.putConstraint(SpringLayout.NORTH, text7, 3, SpringLayout.NORTH, pfPW2);
		sl_pnlRegi.putConstraint(SpringLayout.EAST, text7, 0, SpringLayout.EAST, text3);
		sl_pnlRegi.putConstraint(SpringLayout.NORTH, pfPW2, 18, SpringLayout.SOUTH, pfPW);
		sl_pnlRegi.putConstraint(SpringLayout.EAST, pfPW2, 0, SpringLayout.EAST, tfID);
		sl_pnlRegi.putConstraint(SpringLayout.NORTH, text5, 3, SpringLayout.NORTH, pfPW);
		sl_pnlRegi.putConstraint(SpringLayout.EAST, text5, 0, SpringLayout.EAST, text3);
		sl_pnlRegi.putConstraint(SpringLayout.NORTH, text4, 22, SpringLayout.NORTH, pnlRegi);
		sl_pnlRegi.putConstraint(SpringLayout.NORTH, tfID, 19, SpringLayout.NORTH, pnlRegi);
		sl_pnlRegi.putConstraint(SpringLayout.NORTH, text3, 3, SpringLayout.NORTH, tfID);
		sl_pnlRegi.putConstraint(SpringLayout.NORTH, text6, 3, SpringLayout.NORTH, pfPW);
		sl_pnlRegi.putConstraint(SpringLayout.WEST, text6, 0, SpringLayout.WEST, text4);
		sl_pnlRegi.putConstraint(SpringLayout.NORTH, pfPW, 18, SpringLayout.SOUTH, tfID);
		sl_pnlRegi.putConstraint(SpringLayout.WEST, pfPW, 0, SpringLayout.WEST, tfID);
		sl_pnlRegi.putConstraint(SpringLayout.WEST, text4, 6, SpringLayout.EAST, tfID);
		sl_pnlRegi.putConstraint(SpringLayout.EAST, tfID, -299, SpringLayout.EAST, pnlRegi);
		pnlRegi.setLayout(sl_pnlRegi);
		
		pnlRegi.add(text3);
		pnlRegi.add(tfID);
		pnlRegi.add(text4);
		pnlRegi.add(text5);
		pnlRegi.add(pfPW);
		pnlRegi.add(text6);
		pnlRegi.add(text7);
		pnlRegi.add(pfPW2);
		pnlRegi.add(btnCheck);
		pnlRegi.add(btnReturn);
		
		// 메인창, 가입창 center에 등록
		center.add(pnlMain, "M");
		center.add(pnlRegi, "R");
		
		JPasswordField txtpw = new JPasswordField();
		txtpw.setColumns(10);
		txtpw.setEchoChar('*');
		txtpw.setBounds(100, 121, 195, 30);
	
		Container signupPanel = txtpw;
		
						
		JCheckBox chckbxUpPw  = new JCheckBox("비밀번호 보기");
		chckbxUpPw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxUpPw.isSelected()) {
					txtpw.setEchoChar((char)0);
				}else {
					txtpw.setEchoChar('*');
				}
			}
		});
		chckbxUpPw.setBounds(100, 153, 115, 20);
		pnlMain.add(chckbxUpPw);
		
		// 로그인 시스템
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!(members.get(tfMain.getText()) == null)) {
					char[] pw = members.get(tfMain.getText());
					if (Arrays.equals(pw, pfMain.getPassword())) {
						JOptionPane.showMessageDialog(null, "로그인 성공");
						tfMain.setText("");
						pfMain.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.");
						pfMain.setText("");
					}
				} else {
					JOptionPane.showMessageDialog(null, "등록되지 않은 ID입니다.");
					tfMain.setText("");
					pfMain.setText("");
				}
			}
		};
		btnLogin.addActionListener(action);
		
		// (로그인창) 비밀번호 입력 후 엔터키하면 로그인 버튼 클릭 효과주기
		pfMain.addActionListener(action);
		
		// (회원가입 버튼 클릭시) 가입창 전환
		btnRegi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layout.show(center, "R");
			}
		});
		
		
		// 메인메뉴로 전환
		btnReturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layout.show(center, "M");
			}
		});
		
		// 회원등록 시스템
		// 1. 비밀번호 같은지 확인 (틀리면 팝업창 표기 후 초기화) / 2.ID 비밀번호 Map에 등록 / 3.메인창으로 전환
		btnCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 0. 중복 ID 확인
				if (members.containsKey(tfID.getText())) {
					JOptionPane.showMessageDialog(null, "이미 있는 ID입니다.");
					tfID.setText("");
					pfPW.setText("");
					pfPW2.setText("");
				} 
				// 1. 비밀번호 확인
				else if (!(Arrays.equals(pfPW.getPassword(), pfPW2.getPassword()))) {
					JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다.");
					pfPW.setText("");
					pfPW2.setText("");
				}
				// 2. ID, PW 길이 확인 (4자 이상, 12자 이하)
				else if (!(lengthCk(tfID.getText(), pfPW.getPassword()))) {
					JOptionPane.showMessageDialog(null, "글자수를 지켜주세요. (4자 이상, 12자 이하)");
					tfID.setText("");
					pfPW.setText("");
					pfPW2.setText("");
				} 
				// 3. 회원정보 map에 등록
				else {
					members.put(tfID.getText(), pfPW.getPassword());
					JOptionPane.showMessageDialog(null, "회원가입 되었습니다");
						
					tfID.setText("");
					pfPW.setText("");
					pfPW2.setText("");
						
					// 4. 메인창으로 전환
					layout.show(center, "M");
				}
			}
		});
		
		getContentPane().add(center);
		
		setSize(500, 192);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	// 글자 길이 체크
	public boolean lengthCk(String s, char[] c) {
		if ((s.length() >=4 && s.length() <= 12) && (c.length >=4 && c.length <= 12)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		new LoginProgram().setVisible(true);
	}
}
