package ua.pp.constantine.testtask.web.model;

import org.hibernate.validator.constraints.NotBlank;

public class PlainUser {
	@NotBlank
//	@Size(min=3, max=32)
//	@Pattern(regexp="^([\\w]+)$")
    private String username;

    private String password;

	public PlainUser() {
	}

	public PlainUser(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
