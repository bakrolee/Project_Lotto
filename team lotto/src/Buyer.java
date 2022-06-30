import java.io.IOException;
import java.util.*;

public class Buyer {
	static Scanner s = new Scanner(System.in);

	private String name;
	private String id;
	private Set<LottoNumber> lottoNum = new HashSet<LottoNumber>(6);
	private Set<LottoNumber> price ;
	
	public Buyer(String name, String id) {
		this.name = name;
		this.id = id;
	}
	

	public Set<LottoNumber> getPrice() {
		return price;
	}

	public void setPrice(Set<LottoNumber> price) {
		this.price = price;
	}

	public Set<LottoNumber> getLottoNum() {
		return lottoNum;
	}

	public void setLottoNum(Set<LottoNumber> lottoNum) {
		this.lottoNum = lottoNum;
	}

	public void setLottonum(Set<LottoNumber> lottonum) {
		this.lottoNum = lottonum;
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
		return "Buyer [name=" + name + ", id=" + id + ", lottoNum=" + lottoNum + "]";
	}

	// 로또 번호 수정 메소드
	public void editLottoNum() {
		List<LottoNumber> list = new ArrayList<LottoNumber>(lottoNum);
		Iterator it = list.iterator();
		System.out.println("삭제 할 번호를 입력 해 주세요");
		int a = s.nextInt();
		while (it.hasNext()) {
			int n = (Integer) it.next();
			if (n == a) {
				it.remove();
			}
		}
		System.out.println("해당 번호가 삭제되었습니다.");
		while (true) {
			System.out.println(" 새 번호를 추가 해 주세요" + list);
			int newa = s.nextInt();
			if (newa <= 45 && !list.contains(newa)) {
				System.out.println("해당 번호를 몇번째 자리에 입력하시겠습니까?");
				int index = s.nextInt();
//				list.add(index - 1, newa);
				System.out.println(list);
				break;
			} else {
				System.out.println("번호를 잘못 입력했습니다. 다시 입력 해 주세요");
			}

		}
	}

	public static void main(String[] args) {
		System.out.println("이름과 ID를 입력하세요");
		Buyer b = new Buyer(s.nextLine(), s.nextLine());
		System.out.println(b.name + "\n" + b.id);

	}

}
