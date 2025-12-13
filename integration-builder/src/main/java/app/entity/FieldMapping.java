package app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name = "field_mapping")
public class FieldMapping {
	@Id
	private Long id;

	private Long integrationId;
	private String externalField;
	private String internalField;

	public FieldMapping() {
	}

	public FieldMapping(Long id, Long integrationId, String externalField, String internalField) {
		this.id = id;
		this.integrationId = integrationId;
		this.externalField = externalField;
		this.internalField = internalField;
	}

	public Long getId() {
		return id;
	}

	public Long getIntegrationId() {
		return integrationId;
	}

	public String getExternalField() {
		return externalField;
	}

	public String getInternalField() {
		return internalField;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setIntegrationId(Long integrationId) {
		this.integrationId = integrationId;
	}

	public void setExternalField(String externalField) {
		this.externalField = externalField;
	}

	public void setInternalField(String internalField) {
		this.internalField = internalField;
	}
}
