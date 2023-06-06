

public class user {
	private int id;
	private	String name;
	private	String birthday;
	private	String username;
	private String password;
	private	String email;
	private	int phone;
	
	public user() {
		super();
	}
	public user(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public user(int id, String name, String birthday, String username, String password, String email, int phone) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	public user(int id, String username, String password, String email, int phone, String name, String birthday) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.name = name;
		this.birthday = birthday;
	}
	public user(String username, String password, String email, int phone, String name, String birthday) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.name = name;
		this.birthday = birthday;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int sdt) {
		this.phone = phone;
	}
	
	
	
	
	
}
