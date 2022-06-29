import java.io.IOException;

public class Test1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Buyer person1 = new Buyer("상우", "kwu111");
		Lotto lottoProgram = new Lotto();
		
		LottoNumber lotto1 = lottoProgram.autoNum();
		
		person1.getLottoNum().add(lotto1);
	
		System.out.println(person1);
	}
}
