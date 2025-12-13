package app.entity;

import javax.persistence.*;

@Entity
@Table(name = "temp_user")
public class TempUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TempUser() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rawJson == null) ? 0 : rawJson.hashCode());
		return result;
	}

	public TempUser(Long id, String name, String email, String rawJson) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.rawJson = rawJson;
	}

	@Override
	public String toString() {
		return "TempUser [id=" + id + ", name=" + name + ", email=" + email + ", rawJson=" + rawJson + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TempUser other = (TempUser) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rawJson == null) {
			if (other.rawJson != null)
				return false;
		} else if (!rawJson.equals(other.rawJson))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRawJson() {
		return rawJson;
	}

	public void setRawJson(String rawJson) {
		this.rawJson = rawJson;
	}

// raw payload for debugging
	@Lob
	private String rawJson;
}
