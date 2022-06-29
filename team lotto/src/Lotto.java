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
	public static LottoNumber[ ]  numbers = new LottoNumber[10];
	public static int selectNumber = 0;
	public static int buyCnt = 0; // 구매할줄갯수
	public static Set<Integer>set = new HashSet<Integer>();
	public static StringTokenizer st;
	public static char alphabet = 65;
	
	public Lotto() throws NumberFormatException, IOException {
			run();
	}

	public void run() throws NumberFormatException, IOException {

		while(true) {
			System.out.println("                                                  ");
			System.out.println("=====================목록=========================");
			System.out.println("1. 자동");
			System.out.println("2. 반자동");
			System.out.println("3. 수동");
			System.out.println("4. 현재까지 발권된 로또번호 보기.");
			System.out.println("5. 당첨번호 확인 및 맞은갯수로 정렬.");
			System.out.println("=================================================");
			System.out.println("                                                  ");
			
			selectNumber = Integer.parseInt(getData("번호를 입력하세요."));
			System.out.println();

			if (selectNumber == 1) {
				buyCnt = Integer.parseInt(getData("로또 몇줄을 사시겠습니까?")); 
				autoNum();
			} else if (selectNumber == 2) {
				buyCnt = Integer.parseInt(getData("로또 몇줄을 사시겠습니까?")); 
				semiAuto();
			} else if (selectNumber == 3) {
				buyCnt = Integer.parseInt(getData("로또몇줄을 사시겠습니까?"));
				manual();
			} else if (selectNumber == 4) {
				showNumber();
			} else if (selectNumber == 5) {
				winningNumber();
			}

       
		}
	}

	public static void autoNum() throws IOException {
		while(buyCnt-- >0) {
			for(int i = 0 ; i < 10 ; i++) {
				if(numbers[i] == null) {
					numbers[i] = new LottoNumber(alphabet, "자동 " ,lottoNumbers());
					break;
				}
			}
			alphabet = (char)(alphabet + 1);
		}
	}

	public static void semiAuto() throws IOException {
		while(buyCnt-- > 0) {
			

			for(int i = 0 ; i < 10 ; i++) {
				if(numbers[i] == null) {
					numbers[i] = new LottoNumber(alphabet, "반자동" ,lottoNumbers());
							break;
				}
			}
			alphabet = (char)(alphabet + 1);
		}
	}

	public static void manual() throws NumberFormatException, IOException {
		
		// 만약 체크박스에 체크가되면 set에추가하고, 체크를풀면 set에서 없어지게구현해야함.
		while(buyCnt-- >0) {
			System.out.println("6개의 숫자를 입력하세요.");
			 st = new StringTokenizer(bf.readLine(), " ");
			while(st.hasMoreTokens()) 
			{
				set.add(Integer.parseInt(st.nextToken()));
			}
			
			List<Integer> list = new ArrayList<Integer>(set);
			set.clear();


					for(int i = 0 ; i < 10 ; i++) {
						if(numbers[i] == null) {
							numbers[i] = new LottoNumber(alphabet, "수동 " , list);
									break;
						}
					}
					alphabet = (char)(alphabet + 1);
		}
	}


	public static void showNumber() {
		for(int i = 0 ; i < 10 ; i++) {
			if(numbers[i] != null) {
				System.out.println(numbers[i].getAlphabet()+ " | " + numbers[i].getCategory() + " | " +numbers[i].getNumbers());
			}
		}

	}

	public static void winningNumber() throws IOException {
		List<Integer> winningList = new ArrayList<>();
		winningList.addAll(lottoNumbers());
		int bonusNum = 0 ;
		
		System.out.println("< 당첨번호>");
			for(int i = 0 ; i < 7  ; i++) {
				if(i == 6) {
					bonusNum =  winningList.get(i);
					System.out.println(" + " + bonusNum);
				}else {
					System.out.print(winningList.get(i) + " | ");
				}
			}
			System.out.println();

		for(int i = 0 ; i < 10 ; i++) {
			int cnt = 0;
			if(numbers[i] != null) {
				for(int j = 0 ; j < 6 ; j++) {
					if(winningList.contains(numbers[i].numbers[j])) {
						cnt++;
					}
				}

			switch(cnt) { 
				case 6:
					if(!numbers[i].getNumbers().contains(String.valueOf(bonusNum))) {
						System.out.println(numbers[i].getAlphabet() + " | " + " 1등 당첨  |" +numbers[i].getNumbers());
					}
					else if(numbers[i].getNumbers().contains(String.valueOf(bonusNum))){
						System.out.println(numbers[i].getAlphabet() + " | " + " 2등 당첨  |" +numbers[i].getNumbers() );
					}
					break;
				case 5:
					System.out.println(numbers[i].getAlphabet() + " | " + " 3등 당첨  |" +numbers[i].getNumbers());
					break;
				case 4: 
					System.out.println(numbers[i].getAlphabet() + " | " + " 4등 당첨  |" +numbers[i].getNumbers() );
					break;
				case 3: 
					System.out.println(numbers[i].getAlphabet() + " | " + " 5등 당첨  |" +numbers[i].getNumbers() );
					break;
				default:
					System.out.println(numbers[i].getAlphabet() + " | " + "  낙  첨  |" + numbers[i].getNumbers() );
					break;
			}
			cnt = 0 ;
			}
		}			
	}

    public static List<Integer> lottoNumbers() throws IOException {
    	
    	int setSize = 0;
    	
    	StackTraceElement[] stacks = new Throwable().getStackTrace();
    	StackTraceElement beforeStack = stacks[1];
    	if(beforeStack.getMethodName().equals("winningNumber")) {
    		setSize = 7;
    	}else if(beforeStack.getMethodName().equals("semiAuto")) {
    		System.out.println("수동으로 뽑을 N개의 수를 공백을 기준으로 한 줄 입력하십시오. (N은 5이하)");
    		st = new StringTokenizer(bf.readLine(), " ");
    		while(st.hasMoreTokens()) {
    			set.add(Integer.parseInt(st.nextToken()));
    		}
    		setSize = 6;
    	}else setSize = 6;
    		
    		
    		
        while(set.size() != setSize){
            set.add((int)(Math.random() * 45 + 1));
        }
        
        List<Integer> list = new ArrayList<Integer>(set);
      set.clear();
      
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