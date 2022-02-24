package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(unique = true)
	@NotBlank(message = "Title is required.")
	private String title;

	@NotBlank(message = "Photo is required.")
	@URL(message = "Not a valid url.")
	private String photo;

	@NotNull
	@Size(min = 5, message = "Short description must have at lest 5 character")
	private String shortDescription;

	@NotNull
	@Size(min = 10, message = "Long description must have at lest 10 character")
	@Column(columnDefinition = "Text")
	private String longDescription;

	@Column(columnDefinition = "date")
	private String date;

	@ManyToOne(/* cascade = CascadeType.ALL, */ /* targetEntity = Author.class */)
	@JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
	@JsonManagedReference
	private Author author;

	// for one to many
//	@Column(name="author_id", nullable = false)
//	private int authorId;

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
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

//	public int getAuthor() {
//		return authorId;
//	}
//
//	public void setAuthor(int authorId) {
//		this.authorId = authorId;
//	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + /* ", authorId=" + authorId + */ ", photo=" + photo
				+ ", shortDescription=" + shortDescription + ", longDescription=" + longDescription + ", date=" + date
				+ "]";
	}
}
