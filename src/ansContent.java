
public class ansContent {
	public int id;
	public String content;
	public String credate;
	public int userId;
	public int quesId;
	
	public ansContent() {
		super();
	}
	public ansContent(int id, String content, String credate, int userId, int quesId) {
		this.id = id;
		this.content = content;
		this.credate = credate;
		this.userId = userId;
		this.quesId = quesId;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getQuesId() {
		return quesId;
	}

	public void setQuesId(int quesId) {
		this.quesId = quesId;
	}
	
}
