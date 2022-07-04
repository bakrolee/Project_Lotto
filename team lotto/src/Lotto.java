import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Lotto {
	public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	public static StringTokenizer st;

	public static List<Integer> winningList = new ArrayList<>(); // 당첨번호리스트 사이즈7
	public static Set<Integer> set = new HashSet<Integer>();

	public static LottoNumber[] lottoLine = new LottoNumber[40000];

	public static char alphabet = 65; // 'A' 의 아스키 코드

	public static int selectNumber = 0; // 목록 선택 번호
	public static int buyCnt = 0; // 구매할줄갯수
	public static int PPL = 1000; // 로또 한 줄당 가격
	public static int totalCnt = 0;
	public static int reward = (totalCnt * 100_000 / 2); // 총 당첨금액.
	public static int totalFifth = 0;
	public static int totalFourth = 0;
	public static int thirdPerN = 0;
	public static int secondPerN = 0;
	public static int firstPerN = 0;
	public static int bonusNum = 0; // 보너슨넘버 초기화
	public static int rank[] = new int[6]; // 각 등수에 해당하는 사람 수\
	public static int firstPrice = (int) ((reward - (totalFifth + totalFourth)) * 0.75); // 1등 총 당첨금액
	public static int secondPrice = ((int) ((reward - (totalFifth + totalFourth)) * 0.125)); // 2등 총 당첨금액
	public static int thirdPrice = ((int) ((reward - (totalFifth + totalFourth)) * 0.125)); // 3등 총 당첨금액
	public static int idx;
	
	

	public void run() throws NumberFormatException, IOException {

		while (true) {
			System.out.println("                                                  ");
			System.out.println("=====================목록=========================");
			System.out.println("1. 자동(여러줄 구매)");
			System.out.println("2. 자동(한줄 구매)");
			System.out.println("3. 반자동 and 수동");

			System.out.println("4. 현재까지 발권된 로또번호 보기.");
			System.out.println("5. 당첨번호 확인 및 맞은갯수로 정렬.");
			System.out.println("=================================================");
			System.out.println("                                                  ");

			selectNumber = Integer.parseInt(getData("번호를 입력하세요."));
			System.out.println();

			if (selectNumber == 1) {
				buyCnt = Integer.parseInt(getData("로또 몇줄을 사시겠습니까?"));
				totalCnt += buyCnt;
				autoNum();
			} else if(selectNumber == 2) {
				totalCnt += 1;
				autoNum1();
			} else if (selectNumber == 3) {
			
				totalCnt += 1;
				manualAndSemiAuto1();
		 
//				else if (selectNumber == 3) {
//				buyCnt = Integer.parseInt(getData("로또몇줄을 사시겠습니까?"));
//				totalCnt += buyCnt;
//				manual();
			} else if (selectNumber == 4) {
				showNumber();
			} else if (selectNumber == 5) {
				winningNumber(); // 이바닥 드릅다
			}

			System.out.println("전체 판매액 " + totalCnt * PPL + " / 총 당첨금  " + totalCnt * PPL / 2);
		}

	}

	public static List<Integer> autoNum1() throws IOException { //자동으로 한 줄만 만들어줌
		return lottoNumbers();
//		List<Integer> num6 = new ArrayList<Integer>();
//		for (int i = 0; i < lottoLine.length; i++) {
//			if (lottoLine[i] == null) {
//				lottoLine[i] = new LottoNumber(alphabet, "자동 ", lottoNumbers());
//				break;
//			}
//		}
//		alphabet = (char) (alphabet + 1);
	}
	

	public static List<Integer> manualAndSemiAuto1() throws IOException { //반자동으로 한 줄만 만들어줌
		List<Integer> num6 = new ArrayList<Integer>();
		for ( idx = 0; idx < lottoLine.length; idx++) {
			if (lottoLine[idx] == null) {
				num6 = lottoNumbers();
				break;
			}
		}
		return num6;
//		alphabet = (char) (alphabet + 1);
	}
	
	public List<Integer> editNum1(List<Integer> list) {
		return list;
	} 
	
	//수정 메소드, 리스트의 사이즈가 6일 때 , 6 - 리스트사이즈 만큼 난수 자동 생성

//	public static LottoNumber manual1() throws IOException { //수동으로 한 줄만 만들어줌.
//		System.out.println("6개의 숫자를 입력하세요.");
//		st = new StringTokenizer(bf.readLine(), " ");
//		while (st.hasMoreTokens()) {
//			set.add(Integer.parseInt(st.nextToken()));
//		}
//
//		List<Integer> list = new ArrayList<Integer>(set);
//		LottoNumber number1 = new LottoNumber(alphabet, "수동", list);
//
//		return number1;
//	}

	public static void autoNum() throws IOException {
		List<Integer> num6 = new ArrayList<Integer>();
		while (buyCnt-- > 0) {
			for (int i = 0; i < lottoLine.length; i++) {
				if (lottoLine[i] == null) {
					lottoLine[i] = new LottoNumber(alphabet, "자동 ", lottoNumbers());
					break;
				}
			}
//			alphabet = (char) (alphabet + 1);
		}
	}

//	public static void manualAndSemiAuto() throws IOException {
//		while (buyCnt-- > 0) {
//
//			for (int i = 0; i < lottoLine.length; i++) {
//				if (lottoLine[i] == null) {
//					lottoLine[i] = new LottoNumber(alphabet, "반자동", lottoNumbers());
//					break;
//					
//				}
//			}
//			alphabet = (char) (alphabet + 1);
//		}
//	}

//	public static void manual() throws NumberFormatException, IOException {
//
//		// 만약 체크박스에 체크가되면 set에추가하고, 체크를풀면 set에서 없어지게구현해야함.
//		while (buyCnt-- > 0) {
//			System.out.println("6개의 숫자를 입력하세요.");
//			st = new StringTokenizer(bf.readLine(), " ");
//			while (st.hasMoreTokens()) {
//				set.add(Integer.parseInt(st.nextToken()));
//			}
//
//			List<Integer> list = new ArrayList<Integer>(set);
//			set.clear();
//
//			for (int i = 0; i < lottoLine.length; i++) {
//				if (lottoLine[i] == null) {
//					lottoLine[i] = new LottoNumber(alphabet, "수동 ", list);
//					break;
//				}
//			}
//			alphabet = (char) (alphabet + 1);
//		}
//	}

	public static void showNumber() {
		for (int i = 0; i < lottoLine.length; i++) {
			if (lottoLine[i] != null) {
				System.out.println(lottoLine[i].getAlphabet() + " | " + lottoLine[i].getCategory() + " | "
						+ lottoLine[i].getNumbers());
			} 
		}

	}

	public static void winningNumber() throws IOException {

	

	}

	public static void printSameNumbers() { // 맞힌 번호 출력 메소드!!!!
		for (int i = 0; i < lottoLine.length; i++) {
			if (lottoLine[i] != null) {
				for (int j = 0; j < 6; j++) {
					if (winningList.contains(lottoLine[i].numbers.get(j))) {
						sb.append(lottoLine[i].numbers.get(j)).append(" ");
					}
				}
				switch (lottoLine[i].getCnt()) {
				case 6:
					if (!lottoLine[i].getNumbers().contains(String.valueOf(bonusNum))) {
						System.out.println(lottoLine[i].getAlphabet() + " | " + " 1등 당첨  |" + lottoLine[i].getNumbers()
								+ "당첨 금액 : " + lottoLine[i].getPrice());
						System.out.println("맞은 번호 " + sb);
						break;
					} else if (lottoLine[i].getNumbers().contains(String.valueOf(bonusNum))) {
						System.out.println(lottoLine[i].getAlphabet() + " | " + "2등 당첨  |" + lottoLine[i].getNumbers()
								+ "당첨 금액 : " + lottoLine[i].getPrice());
						System.out.println("맞은 번호 " + sb);
						break;
					}
				case 5:
					if (!lottoLine[i].getNumbers().contains(String.valueOf(bonusNum))) {
						System.out.println(lottoLine[i].getAlphabet() + " | " + " 3등 당첨  |" + lottoLine[i].getNumbers()
								+ "당첨 금액 : " + lottoLine[i].getPrice());
						System.out.println("맞은 번호 " + sb);
						break;
					} else if (lottoLine[i].getNumbers().contains(String.valueOf(bonusNum))) {
						System.out.println(lottoLine[i].getAlphabet() + " | " + "4등 당첨  |" + lottoLine[i].getNumbers()
								+ "당첨 금액 : " + lottoLine[i].getPrice());
						System.out.println("맞은 번호 " + sb);
						break;
					}
				case 4:
					if (!lottoLine[i].getNumbers().contains(String.valueOf(bonusNum))) {
						System.out.println(lottoLine[i].getAlphabet() + " | " + " 4등 당첨  |" + lottoLine[i].getNumbers()
								+ "당첨 금액 : " + lottoLine[i].getPrice());
						System.out.println("맞은 번호 " + sb);
						break;
					} else if (lottoLine[i].getNumbers().contains(String.valueOf(bonusNum))) {
						System.out.println(lottoLine[i].getAlphabet() + " | " + "5등 당첨  |" + lottoLine[i].getNumbers()
								+ "당첨 금액 : " + lottoLine[i].getPrice());
						System.out.println("맞은 번호 " + sb);
						break;
					}
				case 3:
					if (!lottoLine[i].getNumbers().contains(String.valueOf(bonusNum))) {
						System.out.println(lottoLine[i].getAlphabet() + " | " + " 5등 당첨  |" + lottoLine[i].getNumbers()
								+ "당첨 금액 : " + lottoLine[i].getPrice());
						System.out.println("맞은 번호 " + sb);
						break;
					}
				default:
					System.out.println(lottoLine[i].getAlphabet() + " | " + " 낙첨  |" + lottoLine[i].getNumbers()
							+ "당첨 금액 : " + lottoLine[i].getPrice());
					System.out.println("맞은 번호 " + sb);

					break;
				}
				sb.setLength(0);
				System.out.println();
			}

		}
	}

	public static void showMeTheMoney() {

		if (rank[2] == 0) { // 만약 2등 당첨자가 없을시 2등 당첨금액이 1등 당첨금액으로 넘어감.
			firstPrice += secondPrice;
			secondPrice = 0;
		}

		if (rank[3] == 0) { // 만약 3등 당첨자가 없을 시 3등 당첨금액이 1등 당첨금액으로 넘어감.
			firstPrice += thirdPrice;
			thirdPrice = 0;
		}

		totalFifth = 5000 * rank[5]; // 총 5등의 상금
		totalFourth = 50_000 * rank[4]; // 총 4등의 상금

		try {
			thirdPerN = ((int) (thirdPrice) / rank[3]); // 1인당 3등의 상금
		} catch (Exception a) {
		}
		try {
			secondPerN = ((int) (secondPrice) / rank[2]); // 1인당 2등의 상금
		} catch (Exception b) {
		}
		try {
			firstPerN = (int) (firstPrice / rank[1]); // 1인당 1등의 상금.
		} catch (Exception c) {
		}

		for (int i = 0; i < lottoLine.length; i++) {
			if (lottoLine[i] != null) {
				switch (lottoLine[i].getCnt()) {
				case 6:
					if (!lottoLine[i].getNumbers().contains(String.valueOf(bonusNum))) {
						lottoLine[i].setPrice(firstPerN);
						break;
					} else if (lottoLine[i].getNumbers().contains(String.valueOf(bonusNum))) {
						lottoLine[i].setPrice(secondPerN);
						break; // 1등과 2등
					}
				case 5:
					if (!lottoLine[i].getNumbers().contains(String.valueOf(bonusNum))) {
						lottoLine[i].setPrice(thirdPerN);
						break; // 정규번호만 5개 맞힌 경우 = 3등

					} else {
						lottoLine[i].setPrice(50000);
						break; // 정규번호만 4개 + 보너스번호 1개 맞힌 경우 = 4등
					}
				case 4:
					if (!lottoLine[i].getNumbers().contains(String.valueOf(bonusNum))) {
						lottoLine[i].setPrice(50000); // 정규번호만 4개 맞힌 경우 = 4등
						break;
					} else {
						lottoLine[i].setPrice(5000);
						break; // 정규번호만 3개 + 보너스번호 1개 맞힌 경우 = 5등
					}
				case 3:
					if (!lottoLine[i].getNumbers().contains(String.valueOf(bonusNum))) {
						lottoLine[i].setPrice(5000); // 5등
						break;
					} else {
						System.out.println("보너스 번호 포함 3개를 맞춰서 낙첨입니다.");
					}
				default:
					lottoLine[i].setPrice(0);
					break; // 나가리
				}
			}
		}
	}

	public static void ranking() {
		for (int i = 0; i < lottoLine.length; i++) {
			int cnt = 0; // 일치하는 번호의 개수

			if (lottoLine[i] != null) {
				for (int j = 0; j < 6; j++) { // cnt 갯수를 세는 반복문
					if (winningList.contains(lottoLine[i].numbers.get(j))) {
						sb.append(lottoLine[i].numbers.get(j)).append(" ");
						cnt++;
					}
				}

				switch (cnt) { // 일치하는 cnt 값에 따라서 등수 배정하는 switch 문
				case 6:
					if (!lottoLine[i].getNumbers().contains(String.valueOf(bonusNum))) {
						lottoLine[i].setCnt(cnt);
						rank[1]++;
					} else if (lottoLine[i].getNumbers().contains(String.valueOf(bonusNum))) {
						lottoLine[i].setCnt(cnt);
						rank[2]++;
					}
					break;
				case 5:
					if (!lottoLine[i].getNumbers().contains(String.valueOf(bonusNum))) {
						lottoLine[i].setCnt(cnt);
						rank[3]++;
					} else {
						lottoLine[i].setCnt(cnt);
						rank[4]++;
					}
					break;
				case 4:
					if (!lottoLine[i].getNumbers().contains(String.valueOf(bonusNum))) {
						lottoLine[i].setCnt(cnt);
						rank[4]++;
					} else {
						lottoLine[i].setCnt(cnt);
						rank[5]++;
					}
					break;
				case 3:
					if (!lottoLine[i].getNumbers().contains(String.valueOf(bonusNum))) {
						lottoLine[i].setCnt(cnt);
						rank[5]++;
					}
					break;
				default:
					lottoLine[i].setCnt(cnt);
					break;

				}

				sb.setLength(0);

			}
		}
	}

	public static void chosenNumber() throws IOException { // 당첨번호 7자리 생성 메소드
		winningList.addAll(lottoNumbers()); // 당첨번호 넣기

		System.out.println("< 당첨번호>");
		for (int i = 0; i < 7; i++) { // 당첨번호 출력
			if (i == 6) {
				bonusNum = winningList.get(i);
				System.out.println(" + " + bonusNum);
			} else {
				System.out.print(winningList.get(i) + " | ");
			}
		}

	}

	public static List<Integer> lottoNumbers() throws IOException {

		int setSize = 0;
		String tempSentence = "";
		StackTraceElement[] stacks = new Throwable().getStackTrace();
		StackTraceElement beforeStack = stacks[1];
		if (beforeStack.getMethodName().equals("winningNumber")) {
			setSize = 7;
		} else if (beforeStack.getMethodName().equals("manualAndSemiAuto1")) {
			System.out.println("6개 다입력시 - 수동,  5개 이하 입력시 - 반자동");
			st = new StringTokenizer(bf.readLine(), " ");
			while (st.hasMoreTokens()) {
				set.add(Integer.parseInt(st.nextToken()));
			}
			
			if(set.size() == 6) {
				tempSentence = "수동";
			}else tempSentence = "반자동";
			setSize = 6;
		} else
			setSize = 6;

		while (set.size() != setSize) {
			set.add((int) (Math.random() * 45 + 1));
		}
		List<Integer> list = new ArrayList<Integer>(set);
		set.clear();
		
		
		if (beforeStack.getMethodName().equals("manualAndSemiAuto1")) {
			lottoLine[idx] = new LottoNumber(alphabet, tempSentence, list);
			
		}

		return list;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		new Lotto();

	}

	public static String getData(String message) throws IOException {
		System.out.println(message);
		return bf.readLine();
	}
}