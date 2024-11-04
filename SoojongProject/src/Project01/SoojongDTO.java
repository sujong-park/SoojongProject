package Project01;

public class SoojongDTO {
	
	int id;
	String name;
	String email;
	String password;
	
	String title;        // 게시물 제목
    String content;      // 게시물 내용
    String author;       // 작성자 이름
    String createdAt;    // 작성 날짜 (날짜 형식을 String으로 설정)
	
	public SoojongDTO(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public SoojongDTO(int id, String name, String email, String password) {
	    this.id = id;
	    this.name = name;
	    this.email = email;
	    this.password = password;
	}

	public SoojongDTO(int id, String title, String author) {
	    this.id = id;
	    this.title = title;
	    this.author = author;
	    // createdAt 필드의 경우 기본값을 설정하거나 추가적인 값을 받을 수 있습니다.
	    this.createdAt = "기본 날짜"; // 예시로 기본값 설정
	}
	
	public SoojongDTO(String title, String postCon) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.content = content;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	public String toPostString() {
		return "id=" + id + ", title=" + title + ", author=" + author + ", createdAt=" + createdAt + "]";
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
