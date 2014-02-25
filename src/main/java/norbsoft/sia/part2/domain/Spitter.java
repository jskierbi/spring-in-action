package norbsoft.sia.part2.domain;

public class Spitter {

	private long id;
	private String username;
	private String password;
	private String fullName;
	private String email;
	private boolean isUpdatedByEmail;

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

	public String getFullName() {

		return fullName;
	}

	public void setFullName(String fullName) {

		this.fullName = fullName;
	}

	public long getId() {

		return id;
	}

	public void setId(long id) {

		this.id = id;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public boolean isUpdatedByEmail() {

		return isUpdatedByEmail;
	}

	public void setUpdatedByEmail(boolean isUpdatedByEmail) {

		this.isUpdatedByEmail = isUpdatedByEmail;
	}
}
