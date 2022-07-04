import java.util.ArrayList;
import java.util.List;

public class Members {
	private List<Buyer> member = new ArrayList<>();
	
//_______________________________________________id, name 인자값 변경 ___________________________________________
	public static Buyer signUp( Buyer id, Buyer Name ) {
		Buyer a = new Buyer("id","Name");
	return a;
	}

//	public static Buyer signUp(Buyer name, Buyer id) {
//		Buyer a = new Buyer("name", "id");
//		return a;
//	}

	public List<Buyer> getMember() {
		return member;
	}

	public void setMember(List<Buyer> member) {
		this.member = member;
	}

	public void addIdName(String name, String id) {
		member.add(new Buyer(name, id));
	}
	
	public int getIndex(String id) {
		int index = 0;
		for (int i = 0; i < member.size(); i++) {
			if(member.get(i).getId().equals(id)) {
				index = i;
			}
		}
		return index;
	}
	
	@Override
	public String toString() {
		return "Members [member=" + member + "]";
	}

	public void addMember(String id, String Name) {
		member.add(new Buyer(id, Name));
	}
}
