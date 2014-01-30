package ua.pp.constantine.testtask.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {
	private Long id;

	private String username;

	private String passwordHash;

	public User() {
	}

	public User(String username, String passwordHash) {
		this.username = username;
		this.passwordHash = passwordHash;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "ID", nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "USERNAME", unique = true, length = 32, nullable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD_HASH", length = 60, nullable = false)
	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

}
