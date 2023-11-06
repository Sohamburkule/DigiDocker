package com.DigiDocker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Documents {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(length=2000)
	private String FileTitle;
	
	@Lob
	private byte[] FileData;
	
	@Column(length=5000)
	private String FileDescription;
	
	@ManyToOne
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileTitle() {
		return FileTitle;
	}

	public void setFileTitle(String fileTitle) {
		FileTitle = fileTitle;
	}

	public byte[] getFileData() {
		return FileData;
	}

	public void setFileData(byte[] fileData) {
		FileData = fileData;
	}

	public String getFileDescription() {
		return FileDescription;
	}

	public void setFileDescription(String fileDescription) {
		FileDescription = fileDescription;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
	
}
