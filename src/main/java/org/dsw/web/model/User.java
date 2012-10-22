package org.dsw.web.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "User" database table.
 * 
 */
@Entity
@Table(name="\"User\"")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"UserID\"")
	private Integer userID;

	@Column(name="\"Password\"")
	private String password;

	@Column(name="\"UserName\"")
	private String userName;

    public User() {
    }

	public Integer getUserID() {
		return this.userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}