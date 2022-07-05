import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Detail extends JDialog{
	private int index;
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Detail(JDialog owner) {
		super(owner, true);
		LottoResult lottoResult = (LottoResult) getOwner();
//		index = lottoResult.getIndex();
		
		setTitle("회원 상세보기");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		JLabel sentence = new JLabel("회원님의 로또 결과");
		
		
		String ID = lottoResult.getID(index);
		String Name = lottoResult.getName(index);
		int Reward = lottoResult.getReward(index);
		
		JLabel lblID = new JLabel(ID);
		JLabel lblName = new JLabel(Name);
		JLabel lblReward = new JLabel(String.valueOf(Reward + "원"));
		
		// 구매한 복권들, 각 복권별 맞힌 개수
		StringBuilder sb = new StringBuilder();
		
		JLabel lblTotal = new JLabel();
		MainMenu menu = lottoResult.getMenu();
		Buyer buyer = menu.getMembers().getMember().get(index);
		buyer.linesToOne();
		
		for (int i = 0; i < buyer.getOneLottoNums().size(); i++) {
			buyer.getOneLottoNums().get(i).compareTo(lottoResult.getWinningNum());
			sb.append((i + 1) + "번 복권");
			for (int j = 0; j < 6; j++) {
				sb.append(buyer.getOneLottoNums().get(i).getNumbers2().get(j));
				sb.append(" ");
				
			}
			sb.append(" \n 맞힌번호 : " );
			for (int j = 0; j < buyer.getOneLottoNums().get(i).getGuessNumber().size(); j++) {
				sb.append(buyer.getOneLottoNums().get(i).getGuessNumber().get(j));
				sb.append(" ");
			}
			sb.append("등수: ");
			sb.append(buyer.getOneLottoNums().get(i).getRank());
			sb.append(" \n");
		}
		
		lblTotal.setText(sb.toString());
		
		panel.add(sentence);
		panel.add(lblID);
		panel.add(lblName);
		panel.add(lblReward);
		
		panel.add(lblTotal);
		add(panel);

		setSize(300, 300);
		setLocationRelativeTo(null); //화면 가운데로
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}