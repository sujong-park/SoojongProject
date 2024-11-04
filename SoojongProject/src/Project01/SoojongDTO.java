package Project01;

import java.util.Date;

public class SoojongDTO {
	
	int id;
	String name;
	String email;
	String password;
	
	private String title;
    private String content;
    private String author;
    private Date createdAt;
	
    public SoojongDTO(String title, String content, String author, Date createdAt) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
    }
	
	public SoojongDTO(int id, String name, String email, String password) {
	    this.id = id;
	    this.name = name;
	    this.email = email;
	    this.password = password;
	}
	
	public SoojongDTO(int id, String title, String author, Date createdAt) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.createdAt = createdAt;
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
	
	public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
