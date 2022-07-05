import java.util.ArrayList;
import java.util.List;

public class LottoNumber {

	public List<Integer> numbers = new ArrayList<>(6);
	private String category;
	private Character alphabet;
	private int price;  // 상금은 나중에 세터써서 바꾸는 걸로 (1~3등)
	private String correctNumber;
	private List<Integer> guessNumber = new ArrayList<Integer>();
	private String rank;
	
	

	// 로또 등수검사 메소드
	public void compareTo(List<Integer> winningNum) {
		int cnt = 0; // 일치하는 번호의 개수
		int bonus = Lotto.bonusNum;

		for (int i = 0; i < 6; i++) { // cnt 갯수를 세는 반복문
			if (winningNum.contains(numbers.get(i))) {
				guessNumber.add(numbers.get(i));
				cnt++;
			}
		}

		switch (cnt) { // 일치하는 cnt 값에 따라서 등수 배정하는 switch 문
		case 6:
			if (!numbers.contains(String.valueOf(bonus))) {
				rank = "1등";
				price = 1000000000; // 10억
			} else {
				rank = "2등";
				price = 100000000; // 1억
			}
			break;
		case 5:
			if (!numbers.contains(String.valueOf(bonus))) {
				rank = "3등";
				price = 10000000; // 1000만
			} else {
				rank = "4등";
				price = 50000; 
			}
			break;
		case 4:
			if (!numbers.contains(String.valueOf(bonus))) {
				rank = "4등";
				price = 50000; 
			} else {
				rank = "5등";
				price = 5000; 
			}
			break;
		case 3:
			if (!numbers.contains(String.valueOf(bonus))) {
				rank = "5등";
			}
			break;
		default:
			rank = "꽝";
			break;
		}
	}
	
	public String getRank() {
		return rank;
	}
	
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	public void setCorrectNumber(String correctNumber) {
		this.correctNumber = correctNumber;
	}
	
	public String getCorrectNumber() {
		return correctNumber;
	}

	public LottoNumber(List<Integer> list) {
		for (int i = 0; i <= 5; i++) {
			this.numbers.add(list.get(i));
		}
	}

	public List<Integer> getGuessNumber() {
		return guessNumber;
	}

	public void setGuessNumber(List<Integer> guessNumber) {
		this.guessNumber = guessNumber;
	}

	private int cnt; // 번호 맞춘 개수

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LottoNumber(char alphabet, String category, List<Integer> numbers) {
		this.alphabet = alphabet;
		this.category = category;
		for (int i = 0; i <= 5; i++) {
			this.numbers.add(numbers.get(i));
		}
	}

	public Character getAlphabet() { // 코딩판 떠난다
		return alphabet;
	}

	public void setAlphabet(Character alphabet) {
		this.alphabet = alphabet;
	}

	public String getNumbers() {
		StringBuilder sb = new StringBuilder();
		for (int a : numbers) {
			sb.append(a).append(" ");
		}
		return sb.toString();
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public List<Integer> getNumbers2() {
		return numbers;
	}

}
