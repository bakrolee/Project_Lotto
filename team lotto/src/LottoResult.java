import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class LottoResult extends JDialog {
	private List<Integer> winningNum = new ArrayList<>();
	private JTable table;
	public static StringBuilder sb = new StringBuilder();
	public LottoResult() {
		setTitle("당첨 결과");
		JPanel main = new JPanel();
		main.setBackground(Color.WHITE);
		

		// 당첨번호를 numbers 배열에 각각 넣을
		int[] numbers = new int[7];
		for (int i = 0; i < numbers.length; i++) {
			winningNum.add(i + 10); // 임시로 뒀음. 나중에 로또 당첨번호랑 연결할 거
			numbers[i] = winningNum.get(i);
		}
		
		for(int i = 0 ; i <= 5; i++) {
			sb.append(numbers[i]).append("  "); //앞 6개자리는 정규번호 .
		}
		sb.append("  +  "); //보너스번호를 이어줄 +기호
		sb.append(numbers[6]);//당첨 번호 맨 마지막 번호(보너스 번호) 추가
	
		JLabel printWinNum = new JLabel(sb.toString());
		printWinNum.setFont(new Font("HY울릉도M", Font.BOLD, 13));
		main.add(printWinNum);
		

		List<JLabel> memberInfo = new ArrayList<>();
		List<JButton> btnDetail = new ArrayList<>();
		int memberCnt = 4;  //  메인메뉴에서 회원정보(인원) 받아서 인원수만큼 리스트(or 배열) 만들거임 + 회원 정보를 연결시킬 수 있
		for (int i = 0; i < memberCnt; i++) {
			String s = (i + 1) + "번 회원의 당첨등수 ~~";
			memberInfo.add(new JLabel(s));
		
			// 상세보기 버튼도 추가로 달 생각인데, 인덱스에 따라서 해당 회원정보 보게끔 할 예정
			btnDetail.add(new JButton("상세보기"));
		
		}
		SpringLayout sl_main = new SpringLayout();
		sl_main.putConstraint(SpringLayout.EAST, printWinNum, 356, SpringLayout.WEST, main);
		main.setLayout(sl_main);
		
		JLabel lblNewLabel = new JLabel("당첨 결과");
		sl_main.putConstraint(SpringLayout.NORTH, printWinNum, 18, SpringLayout.SOUTH, lblNewLabel);
		sl_main.putConstraint(SpringLayout.WEST, printWinNum, 0, SpringLayout.WEST, lblNewLabel);
		sl_main.putConstraint(SpringLayout.NORTH, lblNewLabel, 36, SpringLayout.NORTH, main);
		sl_main.putConstraint(SpringLayout.WEST, lblNewLabel, 123, SpringLayout.WEST, main);
		sl_main.putConstraint(SpringLayout.EAST, lblNewLabel, 345, SpringLayout.WEST, main);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("휴먼고딕", Font.BOLD, 23));
		main.add(lblNewLabel);

		getContentPane().add(main);
		

		
		
		String[ ] headings = new String[] {"이름", "ID", "총 당첨금액", "상세보기"}; //테이블 열
		Object[][] data = new Object[][] { //테이블 행
			{"최진혁", "chlwlsgur000", "5000"," 클릭 "},
			{"김상우", "ksw1233", "50000"," 클릭 "},
			{"김창희", "kch1431", "10000"," 클릭 "},
			{"이박로", "bakro124", "100000"," 클릭 "},
			{"김창희", "kch1431", "10000"," 클릭 "},
			{"김창희", "kch1431", "10000"," 클릭 "},
			{"김창희", "kch1431", "10000"," 클릭 "},
			{"김창희", "kch1431", "10000"," 클릭 "},
			{"김창희", "kch1431", "10000"," 클릭 "},
			{"김창희", "kch1431", "10000"," 클릭 "},
			{"김창희", "kch1431", "10000"," 클릭 "},
			{"김창희", "kch1431", "10000"," 클릭 "},
			{"김창희", "kch1431", "10000"," 클릭 "},
			
		};
		
		JTable table_1 = new JTable(data, headings);
		table_1.setPreferredScrollableViewportSize(new Dimension(200,200)); //테이블 크기
		table_1.setFillsViewportHeight(true);
		
		
		JScrollPane scrollPane = new JScrollPane(table_1);
		sl_main.putConstraint(SpringLayout.SOUTH, scrollPane, 382, SpringLayout.NORTH, main);
		sl_main.putConstraint(SpringLayout.EAST, scrollPane, -29, SpringLayout.EAST, main);
		main.add(scrollPane);
		
		//for문으로 해보려고했지만 실패함 
		JLabel reward1 = new JLabel("1등 총 상금 : 00원  /  1등 당첨 명 수 : 00 명 /  1인당 당첨 금액 : 00원"); //1등이 안나오면 다음 회차에 이월됨
		sl_main.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, reward1);
		sl_main.putConstraint(SpringLayout.NORTH, reward1, 75, SpringLayout.SOUTH, lblNewLabel);
		sl_main.putConstraint(SpringLayout.WEST, reward1, 33, SpringLayout.WEST, main);
		main.add(reward1);
		JLabel reward2 = new JLabel("2등 총 상금 : 00원  /  2등 당첨 명 수 : 00 명 /  1인당 당첨 금액 : 00원"); //2등이 없을 시 2등 당첨금액은 1등 당첨금액에 더해짐
		sl_main.putConstraint(SpringLayout.NORTH, reward2, 6, SpringLayout.SOUTH, reward1);
		sl_main.putConstraint(SpringLayout.WEST, reward2, 32, SpringLayout.WEST, main);
		sl_main.putConstraint(SpringLayout.EAST, reward2, -49, SpringLayout.EAST, main);
		sl_main.putConstraint(SpringLayout.EAST, reward1, 0, SpringLayout.EAST, reward2);
		main.add(reward2);
		JLabel reward3 = new JLabel("3등 총 상금 : 00원  /  3등 당첨 명 수 : 00 명 /  1인당 당첨 금액 : 00원"); //3등이 없을 시 3등 당첨금액은 1등 당첨금액에 더해짐
		sl_main.putConstraint(SpringLayout.NORTH, reward3, 6, SpringLayout.SOUTH, reward2);
		sl_main.putConstraint(SpringLayout.WEST, reward3, 32, SpringLayout.WEST, main);
		sl_main.putConstraint(SpringLayout.EAST, reward3, -49, SpringLayout.EAST, main);
		main.add(reward3);
		
		JLabel reward4 = new JLabel("4등 총 상금 : 00원  /  4등 당첨 명 수 : 00 명 /  1인당 당첨 금액 : 50,000원");
		sl_main.putConstraint(SpringLayout.NORTH, reward4, 6, SpringLayout.SOUTH, reward3);
		sl_main.putConstraint(SpringLayout.WEST, reward4, 32, SpringLayout.WEST, main);
		sl_main.putConstraint(SpringLayout.EAST, reward4, -49, SpringLayout.EAST, main);
		main.add(reward4);
		
		JLabel reward5 = new JLabel("5등 총 상금 : 00원  /  5등 당첨 명 수 : 00 명 /  1인당 당첨 금액 : 5,000원");
		sl_main.putConstraint(SpringLayout.NORTH, scrollPane, 23, SpringLayout.SOUTH, reward5);
		sl_main.putConstraint(SpringLayout.NORTH, reward5, 6, SpringLayout.SOUTH, reward4);
		sl_main.putConstraint(SpringLayout.WEST, reward5, 32, SpringLayout.WEST, main);
		sl_main.putConstraint(SpringLayout.EAST, reward5, -49, SpringLayout.EAST, main);
		main.add(reward5);
		
		table_1.getColumnModel().getColumn(3).setCellRenderer(new TableCell());
		table_1.getColumnModel().getColumn(3).setCellEditor(new TableCell());
		
		JButton gotoMain = new JButton("메인 화면으로");
		sl_main.putConstraint(SpringLayout.NORTH, gotoMain, 26, SpringLayout.SOUTH, scrollPane);
		sl_main.putConstraint(SpringLayout.EAST, gotoMain, 0, SpringLayout.EAST, scrollPane);
		main.add(gotoMain);
		
		gotoMain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Main화면으로 이동.
				dispose();
			}
		
	
		});
		setSize(500, 500);
		setLocationRelativeTo(null); //화면 가운데로
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	
	
	
	// 임시로 만들었어... 메인메뉴가 실행이 에러떠서 (여기서 바로 실행하면 이 창 보일거야)
	public static void main(String[] args) {
		new LottoResult().setVisible(true);
	}
	
	
}

class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{
	JButton jb;
	
	public TableCell() {
		jb = new JButton("버튼");
		
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new WindowTwo();
				
			}
		
	
		});
		
	}

	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		return jb;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
			int column) {
		// TODO Auto-generated method stub
		return jb;
	}
}

class WindowTwo extends JFrame{
	public WindowTwo() {
		setTitle("000회원님의 상세보기");
		setSize(300, 300);
		setVisible(true);
		
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		JLabel sentence = new JLabel("회원님의 로또 결과");
		panel.add(sentence);
		// 여기 이제 회원이 뽑은 로또 번호를 출력하고 밑에 맞춘 번호 출력해야함.
		setLocationRelativeTo(null); //화면 가운데로
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}