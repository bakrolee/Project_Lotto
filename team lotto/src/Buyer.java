import java.io.IOException;
import java.util.*;

public class Buyer {
//	static Scanner s = new Scanner(System.in);

	private String name;
	private String id;
	private List<List<Integer>> lottoLines = new ArrayList<>();
	private List<LottoNumber> oneLottoNums = new ArrayList<>();
//	private List<LottoNumber> oneLottoNums2 = new ArrayList<>();
	private int reward;
	
	public List<LottoNumber> getOneLottoNums() {
		return oneLottoNums;
	}
	
//	public List<LottoNumber> getOneLottoNums2() {
//		return oneLottoNums2;
//	}

	public void setOneLottoNums(List<LottoNumber> oneLottoNums) {
		this.oneLottoNums = oneLottoNums;
	}

	public void linesToOne() {
		for (int i = 0; i < lottoLines.size(); i++) {
			oneLottoNums.add(new LottoNumber(lottoLines.get(i)));
		}
//		System.out.println(oneLottoNums.toString());
	}
	
//	public void linesToOne2() {
//		for (int i = 0; i < lottoLines.size(); i++) {
//			oneLottoNums2.add(new LottoNumber(lottoLines.get(i)));
//		}
////		System.out.println(oneLottoNums.toString());
//	}
	
	public int getReward() {
		for (int i = 0; i < oneLottoNums.size(); i++) {
			reward += oneLottoNums.get(i).getPrice();
		}
		return reward;
	}
	
//	public int getReward2() {
//		for (int i = 0; i < oneLottoNums2.size(); i++) {
//			System.out.println(i + "복권 금액" + oneLottoNums2.get(i).getPrice());
//			reward += oneLottoNums2.get(i).getPrice();
//			System.out.println("종합: " + reward);
//		}
//		return reward;
//	}
	
	public void setReward(int reward) {
		this.reward = reward;
	}

	public Buyer(String id, String name) { //________________ 박로 수정(7.6)
		this.id = id;
		this.name = name;
	}
	
	//________상우 수정 (로또 1줄로 다 쪼개서 반환하는 메소드) -> 별 필요는 없어짐...ㅜㅜ
	public List<Integer> getDividedLotto() {
		List<Integer> temp = new ArrayList<>();
		for (int i = 0; i < lottoLines.size(); i++) {
			temp.addAll(lottoLines.get(i));
		}
		return temp;
	}

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
		return "Buyer [id=" + id + ", name=" + name + ", lottoNum=" + lottoLines + "]";
	}
}
