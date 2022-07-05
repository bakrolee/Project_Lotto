import java.io.IOException;
import java.util.*;

public class Buyer {
	static Scanner s = new Scanner(System.in);

	private String name;
	private String id;
	private List<List<Integer>> lottoLines = new ArrayList<>();
	private List<LottoNumber> oneLottoNums = new ArrayList<>();
	private int reward;
	
	public List<LottoNumber> getOneLottoNums() {
		return oneLottoNums;
	}

	public void setOneLottoNums(List<LottoNumber> oneLottoNums) {
		this.oneLottoNums = oneLottoNums;
	}

	public void linesToOne() {
		for (int i = 0; i < lottoLines.size(); i++) {
			oneLottoNums.add(new LottoNumber(lottoLines.get(i)));
		}
//		System.out.println(oneLottoNums.toString());
	}
	
	public int getReward() {
		for (int i = 0; i < oneLottoNums.size(); i++) {
			reward += oneLottoNums.get(i).getPrice();
		}
		return reward;
	}
	public void setReward(int reward) {
		this.reward = reward;
	}

	public Buyer(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	//________상우 수정 (로또 1줄로 다 쪼개서 반환하는 메소드) -> 별 필요는 없어짐...ㅜㅜ
	public List<Integer> getDividedLotto() {
		List<Integer> temp = new ArrayList<>();
		for (int i = 0; i < lottoLines.size(); i++) {
			temp.addAll(lottoLines.get(i));
		}
		return temp;
	}
	//______________________

	public List<List<Integer>> getLottoLines() {
		return lottoLines;
	}

	public void setLottoLines(List<List<Integer>> lottoNum) {
		this.lottoLines = lottoNum;
	}
	
	// 로또 번호 추가 메소드 (중요)  _________수정
	public void addLottoLines(List<Integer> lottoNum) {
		List<Integer> temp = lottoNum;
		lottoLines.add(temp);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Buyer [name=" + name + ", id=" + id + ", lottoNum=" + lottoLines + "]";
	}
}
