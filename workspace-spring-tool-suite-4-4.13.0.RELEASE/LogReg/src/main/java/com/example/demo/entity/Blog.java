package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name="blogs")
public class Blog {
	
	@Id
	@GeneratedValue(strategy=  GenerationType.IDENTITY)
	private long id;
	
//	@OneToMany(mappedBy = "")
//	@NotBlank(message = "Author Name Should Not be Blanked.....")
//	@Size(min = 2, max = 40, message = "Min 2 and Max 40 Character Required.....")
	@Column(name="author")
	private String author;
	
//	@NotBlank(message = "Title Should Not be Blanked.....")
//	@Size(min = 2, max = 40, message = "Min 2 and Max 40 Character Required.....")
	@Column(name="title")
	private String title;
	
//	@NotBlank(message = "Text Should Not be Blanked.....")
//	@Size(min = 10, max = 10000, message = "Min 10 and Max 10000 Character Required.....")
	@Column(name="text")
	private String text;
	
	@Column(name="image")
	private String image;
	
	@ManyToOne
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Transient
	private MultipartFile file;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
