import javax.swing.JDialog;
import javax.swing.JPanel;

public class LottoResult extends JDialog {
	private int[] winNumber = {1, 2, 3, 4, 5, 6};
	
	public LottoResult() {
		setTitle("당첨 결과");
		JPanel main = new JPanel();
		
		JPanel winNum = new JPanel();
		JPanel reward = new JPanel();
		JPanel memberResult = new JPanel();
		
		main.add(winNum);
		main.add(reward);
		main.add(memberResult);
		
		add(main);
		setModal(true);
		setSize(500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
