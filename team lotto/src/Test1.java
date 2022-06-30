import java.io.IOException;

public class Test1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Buyer[] people = new Buyer[10000];
		Buyer person1 = new Buyer("상우", "ksw");
		Buyer person2 = new Buyer("진혁", "choibaksa");
		Buyer person3 = new Buyer("박로", "baksa");
		
		Lotto lottoProgram = new Lotto();
		
		
//		LottoNumber price = lottoProgram.winningNumber();
		LottoNumber lotto1 = lottoProgram.autoNum1();
		LottoNumber lotto2 = lottoProgram.semiAuto1();
		LottoNumber lotto3 = lottoProgram.manual1();
		
		person1.getLottoNum().add(lotto1);
		person2.getLottoNum().add(lotto2);
		person3.getLottoNum().add(lotto3);
	
	}
}
