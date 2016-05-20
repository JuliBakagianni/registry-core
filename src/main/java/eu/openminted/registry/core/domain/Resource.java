package domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name="Resource")
public class Resource {
	
	@Id
	@Column(name = "id", nullable = false)
	private String id;	
	
	@Size(min=3, max=50)
    @Column(name = "resourceType", nullable = false)
	private String resourceType;
	
	@Size(min=3, max=50)
    @Column(name = "version", nullable = false)
	private String version;
	
	@Size(min=3, max=10000)
    @Column(name = "payload", nullable = false)
	private String payload;
	
	@Size(min=3, max=200)
    @Column(name = "payloadUrl", nullable = false)
	private String payloadUrl;
	
	@Size(min=3, max=30)
    @Column(name = "payloadFormat", nullable = false)
	private String payloadFormat;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", nullable = false, updatable=false)
	private Date creationDate;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modification_date", nullable = false)
	private Date modificationDate;
	
	
	public Resource(int id, String resourceType,String version,String payload,String payloadFormat) {
		this.resourceType = resourceType;
		this.version = version;
		this.payload = payload;
		this.payloadFormat = payloadFormat;
	}
	
	public Resource(){
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String string) {
		this.id = string;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	public String getPayloadFormat() {
		return payloadFormat;
	}
	public void setPayloadFormat(String payloadFormat) {
		this.payloadFormat = payloadFormat;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	
	

	public String getPayloadUrl() {
		return payloadUrl;
	}

	public void setPayloadUrl(String payloadUrl) {
		this.payloadUrl = payloadUrl;
	}

	@PrePersist
	protected void onCreate() {
		modificationDate = creationDate = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
	   modificationDate = new Date();
	}

	
	@PrePersist
	private void ensureId(){
	    this.setId(UUID.randomUUID().toString());
	}

}