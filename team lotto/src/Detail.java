import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.SpringLayout;
import java.awt.Color;



public class Detail extends JDialog {
	private int index;
	private JTable table;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Detail(JDialog owner) {
		super(owner, true);
		LottoResult lottoResult = (LottoResult) getOwner();
		index = lottoResult.getIndex();

		setTitle("회원 상세보기");

		JPanel panel = new JPanel();
		getContentPane().add(panel);


		String ID = lottoResult.getID(index);
		String Name = lottoResult.getName(index);
		int Reward = lottoResult.getReward(index);
		
		JLabel title = new JLabel(ID + "(" + Name + ") 님의 로또 결과");
//		JLabel infoName = new JLabel(Name + "이름");

		// 구매한 복권들, 각 복권별 맞힌 개수
		StringBuilder sb = new StringBuilder();
		MainMenu menu = lottoResult.getMenu();
		Buyer buyer = menu.getMembers().getMember().get(index);
		buyer.linesToOne();

		for (int i = 0; i < buyer.getOneLottoNums().size(); i++) {
			buyer.getOneLottoNums().get(i).compareTo(lottoResult.getWinningNum());
//			sb.append((i + 1) + "번 복권");
//			for (int j = 0; j < 6; j++) {
//				sb.append(buyer.getOneLottoNums().get(i).getNumbers2().get(j));
//				sb.append(" ");
//			}
//			sb.append(" \n 맞힌번호 : ");
//			for (int j = 0; j < buyer.getOneLottoNums().get(i).getGuessNumber().size(); j++) {
//				sb.append(buyer.getOneLottoNums().get(i).getGuessNumber().get(j));
//				sb.append(" ");
//			}
//			sb.append("등수: ");
//			sb.append(buyer.getOneLottoNums().get(i).getRank());
//			sb.append(" \n");
		}

		String[] headings = new String[] { "로또 번호", "맞은 번호", "등수", "당청금" }; // 테이블 열

		Object[][] data = new Object[buyer.getOneLottoNums().size()][4];

		for (int i = 0; i < buyer.getOneLottoNums().size(); i++) {
			data[i][0] = buyer.getOneLottoNums().get(i).getNumbers2().toString();
			data[i][1] = buyer.getOneLottoNums().get(i).getGuessNumber().toString();
			data[i][2] = buyer.getOneLottoNums().get(i).getRank();
			data[i][3] = buyer.getOneLottoNums().get(i).getPrice();
		}
		
		table = new JTable(data, headings);
		JScrollPane scrollPane = new JScrollPane(table);
		
		SpringLayout sl_panel = new SpringLayout();
		sl_panel.putConstraint(SpringLayout.NORTH, scrollPane, 19, SpringLayout.SOUTH, title);
		sl_panel.putConstraint(SpringLayout.NORTH, title, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, title, 261, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, scrollPane, 21, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, scrollPane, 614, SpringLayout.WEST, panel);
		panel.setLayout(sl_panel);
		panel.add(title);
		
		sl_panel.putConstraint(SpringLayout.NORTH, table, 31, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, table, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, table, -9, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, table, -10, SpringLayout.EAST, panel);
		table.setBackground(Color.WHITE);
		table.setPreferredScrollableViewportSize(new Dimension(200,200)); //테이블 크기
		table.setFillsViewportHeight(true);
		
		
		panel.add(scrollPane);
		getContentPane().add(panel);
		
		JButton btnBack = new JButton("돌아가기");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buyer.getOneLottoNums().clear();
				dispose();
			}
		});
		
		sl_panel.putConstraint(SpringLayout.SOUTH, btnBack, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnBack, -10, SpringLayout.EAST, panel);
		panel.add(btnBack);

		setSize(657, 357);
		setLocationRelativeTo(null); // 화면 가운데로
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
}