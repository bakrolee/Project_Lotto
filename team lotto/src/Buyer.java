import java.util.*;

public class Buyer {
	static Scanner s = new Scanner(System.in);
	private String name;
	private String id;
	private Set<Integer> lottoNum = new HashSet<Integer>();

	public String getLottonum() {
		List<Integer> list = new ArrayList<Integer>(lottoNum);
		return list.toString();
	}

	public void setLottonum(Set<Integer> lottonum) {
		this.lottoNum = lottonum;
	}

	public Buyer(String name, String id) {
		this.name = name;
		this.id = id;
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

	public void printInfromation() {
		System.out.println("이름 = " + getName() + "\n" + "ID = " + getId());
		System.out.println("로또 번호 : ");
		Random random = new Random();

		for (int i = 0; i < 6; i++) {
			int a = random.nextInt(45) + 1;
			lottoNum.add(a);
		}
		System.out.println(getLottonum());
	}

	public void editlLottoNum() {
		List<Integer> list = new ArrayList<Integer>(lottoNum);
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
				list.add(index - 1, newa);
				System.out.println(list);
				break;
			} else {
				System.out.println("값을 잘못 입력했습니다. 다시 입력 해 주세요");
			}

		}
	}

	public static void main(String[] args) {
		System.out.println("이름과 ID를 입력하세요");
		Buyer b = new Buyer(s.nextLine(), s.nextLine());
		b.printInfromation();
		b.editlLottoNum();

	}

}
