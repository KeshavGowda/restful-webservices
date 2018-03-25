package com.keshav.webservice.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Details of User model")
@Entity
public class User {
	@Id
	@GeneratedValue
	private int userId;
	
	@ApiModelProperty(notes="Name must be atleast 2 chars long")
	@Size(min=2, message="Name should be atleast 2 chars")
	private String userName;
	
	@ApiModelProperty(notes="DOB cannot be a future date")
	@Past(message="DOB cannot be a future date")
	private Date dob;
	
	@OneToMany(mappedBy="user")
	private List<Post> posts;
	
	public User() {
		super();
	}
	
	public User(int userId, String userName, Date dob) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.dob = dob;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
}
