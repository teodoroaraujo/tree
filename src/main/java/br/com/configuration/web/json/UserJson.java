package br.com.configuration.web.json;

import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class UserJson {

	private Long cdUser;

	private String username;

	private String email;

	public Long getCdUser() {
		return cdUser;
	}

	public void setCdUser(Long cdUser) {
		this.cdUser = cdUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
