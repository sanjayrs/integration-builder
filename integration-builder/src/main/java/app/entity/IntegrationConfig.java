package app.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "integration_config")
public class IntegrationConfig {
	@Id
	private Long id;

	private String name;
	private String baseUrl;
	private String userEndpoint;
	private String authType;

	@Column(length = 2000)
	private String authToken;

	public IntegrationConfig() {
	}

	private String paginationStyle;
	private String paginationParam;
	private String pageSizeParam;
	private Boolean active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getUserEndpoint() {
		return userEndpoint;
	}

	public void setUserEndpoint(String userEndpoint) {
		this.userEndpoint = userEndpoint;
	}

	public String getAuthType() {
		return authType;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getPaginationStyle() {
		return paginationStyle;
	}

	public void setPaginationStyle(String paginationStyle) {
		this.paginationStyle = paginationStyle;
	}

	public String getPaginationParam() {
		return paginationParam;
	}

	public void setPaginationParam(String paginationParam) {
		this.paginationParam = paginationParam;
	}

	public String getPageSizeParam() {
		return pageSizeParam;
	}

	public void setPageSizeParam(String pageSizeParam) {
		this.pageSizeParam = pageSizeParam;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((authToken == null) ? 0 : authToken.hashCode());
		result = prime * result + ((authType == null) ? 0 : authType.hashCode());
		result = prime * result + ((baseUrl == null) ? 0 : baseUrl.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pageSizeParam == null) ? 0 : pageSizeParam.hashCode());
		result = prime * result + ((paginationParam == null) ? 0 : paginationParam.hashCode());
		result = prime * result + ((paginationStyle == null) ? 0 : paginationStyle.hashCode());
		result = prime * result + ((userEndpoint == null) ? 0 : userEndpoint.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IntegrationConfig other = (IntegrationConfig) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (authToken == null) {
			if (other.authToken != null)
				return false;
		} else if (!authToken.equals(other.authToken))
			return false;
		if (authType == null) {
			if (other.authType != null)
				return false;
		} else if (!authType.equals(other.authType))
			return false;
		if (baseUrl == null) {
			if (other.baseUrl != null)
				return false;
		} else if (!baseUrl.equals(other.baseUrl))
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
		if (pageSizeParam == null) {
			if (other.pageSizeParam != null)
				return false;
		} else if (!pageSizeParam.equals(other.pageSizeParam))
			return false;
		if (paginationParam == null) {
			if (other.paginationParam != null)
				return false;
		} else if (!paginationParam.equals(other.paginationParam))
			return false;
		if (paginationStyle == null) {
			if (other.paginationStyle != null)
				return false;
		} else if (!paginationStyle.equals(other.paginationStyle))
			return false;
		if (userEndpoint == null) {
			if (other.userEndpoint != null)
				return false;
		} else if (!userEndpoint.equals(other.userEndpoint))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "IntegrationConfig [id=" + id + ", name=" + name + ", baseUrl=" + baseUrl + ", userEndpoint="
				+ userEndpoint + ", authType=" + authType + ", authToken=" + authToken + ", paginationStyle="
				+ paginationStyle + ", paginationParam=" + paginationParam + ", pageSizeParam=" + pageSizeParam
				+ ", active=" + active + "]";
	}

	public IntegrationConfig(Long id, String name, String baseUrl, String userEndpoint, String authType,
			String authToken, String paginationStyle, String paginationParam, String pageSizeParam, Boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.baseUrl = baseUrl;
		this.userEndpoint = userEndpoint;
		this.authType = authType;
		this.authToken = authToken;
		this.paginationStyle = paginationStyle;
		this.paginationParam = paginationParam;
		this.pageSizeParam = pageSizeParam;
		this.active = active;
	}

}
