
public class quesContent {
	public int id;
	public String title;
	public String content;
	public String credate;
	public int userId;
	
	public quesContent() {
		super();
	}
	public quesContent(int id, String title, String content, String credate, int userId) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.credate = credate;
		this.userId = userId;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCredate() {
		return credate;
	}
	public void setCredate(String credate) {
		this.credate = credate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	
	
	
}
