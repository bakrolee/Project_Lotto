import java.util.ArrayList;
import java.util.List;

public class Members {
	private List<Buyer> member = new ArrayList<>();
	
	public static Buyer signUp( Buyer name, Buyer id ) {
		Buyer a = new Buyer("name","id");
	 return a;
	}
	
//	public List<Buyer> addBuyer () {
//		
//	}

	public List<Buyer> getMember() {
		return member;
	}

	public void setMember(List<Buyer> member) {
		this.member = member;
	}
	
	public void addMember(String name, String id) {
		member.add(new Buyer(name, id));
	}
}
