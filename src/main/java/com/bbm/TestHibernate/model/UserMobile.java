package com.bbm.TestHibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserMobile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String type;

	@Column(nullable = false)
	private String phoneNumber;

	@ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private EntityUser entityUser;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public EntityUser getEntityUser() {
		return entityUser;
	}

	public void setEntityUser(EntityUser entityUser) {
		this.entityUser = entityUser;
	}

	@Override
	public String toString() {
		return "UserMobile [id=" + id + ", type=" + type + ", phoneNumber=" + phoneNumber + ", entityUser="
				+ entityUser;
	}

}
