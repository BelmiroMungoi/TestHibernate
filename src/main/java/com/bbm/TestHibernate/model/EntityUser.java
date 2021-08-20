package com.bbm.TestHibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({

		@NamedQuery(name = "EntityUser.findAll", query = "select u from EntityUser u"),
		@NamedQuery(name = "EntityUser.findAllByName", 
		query = "select u from EntityUser u where u.firstName = :firstName") 
})
public class EntityUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUser;
	private String firstName;
	private String lastName;
	private String email;
	private String userName;
	private String password;

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "EntityUser [idUser=" + idUser + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", userName=" + userName + ", password=" + password + "]";
	}

}
