package di_1.none;

public class User {

	private int no;
	private String name;
	private String email;
	
	public User() {}
	public User(int no, String name, String email) {
		this.no = no;
		this.name = name;
		this.email = email;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
