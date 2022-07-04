import java.io.IOException;
import java.util.*;

public class Buyer {
	static Scanner s = new Scanner(System.in);

	private String name;
	private String id;
	private List<List<Integer>> lottoLines = new ArrayList<>();

	public Buyer(String name, String id) {
		this.name = name;
		this.id = id;
	}

	public List<List<Integer>> getLottoLines() {
		return lottoLines;
	}

	public void setLottoLines(List<List<Integer>> lottoNum) {
		this.lottoLines = lottoNum;
	}
	
	// 로또 번호 추가 메소드 (중요)
	public void addLottoLines(List<List<Integer>> lottoNum) {
		for (int i = 0; i < lottoNum.size(); i++) {
			lottoLines.add(lottoNum.get(i)) ;
		}
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
