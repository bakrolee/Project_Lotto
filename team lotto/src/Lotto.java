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
	public static int buyCnt = 0; // �������ٰ���
	public static Set<Integer>set = new HashSet<Integer>();
	public static StringTokenizer st;
	public static char alphabet = 65;
	
	public Lotto() throws NumberFormatException, IOException {
			run();
	}

	public void run() throws NumberFormatException, IOException {

		while(true) {
			System.out.println("                                                  ");
			System.out.println("=====================���=========================");
			System.out.println("1. �ڵ�");
			System.out.println("2. ���ڵ�");
			System.out.println("3. ����");
			System.out.println("4. ������� �߱ǵ� �ζǹ�ȣ ����.");
			System.out.println("5. ��÷��ȣ Ȯ�� �� ���������� ����.");
			System.out.println("=================================================");
			System.out.println("                                                  ");
			
			selectNumber = Integer.parseInt(getData("��ȣ�� �Է��ϼ���."));
			System.out.println();

			if (selectNumber == 1) {
				buyCnt = Integer.parseInt(getData("�ζ� ������ ��ðڽ��ϱ�?")); 
				autoNum();
			} else if (selectNumber == 2) {
				buyCnt = Integer.parseInt(getData("�ζ� ������ ��ðڽ��ϱ�?")); 
				semiAuto();
			} else if (selectNumber == 3) {
				buyCnt = Integer.parseInt(getData("�ζǸ����� ��ðڽ��ϱ�?"));
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
					numbers[i] = new LottoNumber(alphabet, "�ڵ� " ,lottoNumbers());
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
					numbers[i] = new LottoNumber(alphabet, "���ڵ�" ,lottoNumbers());
							break;
				}
			}
			alphabet = (char)(alphabet + 1);
		}
	}

	public static void manual() throws NumberFormatException, IOException {
		
		// ���� üũ�ڽ��� üũ���Ǹ� set���߰��ϰ�, üũ��Ǯ�� set���� �������Ա����ؾ���.
		while(buyCnt-- >0) {
			System.out.println("6���� ���ڸ� �Է��ϼ���.");
			 st = new StringTokenizer(bf.readLine(), " ");
			while(st.hasMoreTokens()) 
			{
				set.add(Integer.parseInt(st.nextToken()));
			}
			
			List<Integer> list = new ArrayList<Integer>(set);
			set.clear();


					for(int i = 0 ; i < 10 ; i++) {
						if(numbers[i] == null) {
							numbers[i] = new LottoNumber(alphabet, "���� " , list);
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
		
		System.out.println("< ��÷��ȣ>");
			for(int i = 0 ; i < 7  ; i++) {
				if(i == 6) {
					bonusNum =  winningList.get(i);
					System.out.println(" + " + bonusNum);
				}else {
					System.out.print(winningList.get(i) + " | ");
				}
			}

		for(int i = 0 ; i < 10 ; i++) {
			int cnt = 0;
			if(numbers[i] != null) {
				for(int j = 0 ; j < 6 ; j++) {
					if(winningList.contains(numbers[i].numbers[j])) {
						cnt++;
					}
				}

				System.out.println(numbers[i].getCategory() + " | " +numbers[i].getNumbers() + "   ��������:" + cnt);
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
    		System.out.println("�������� ���� N���� ���� ������ �������� �� �� �Է��Ͻʽÿ�. (N�� 5����)");
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