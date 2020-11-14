package mncompany.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;


@MappedSuperclass
public abstract class BaseEntity implements Serializable {
	
	@Column(name = "created_at")
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	protected LocalDateTime createdAt;
	
	@Column(name = "update_at")
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	protected LocalDateTime updateAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = LocalDateTime.now();
	}
	
	@PrePersist
	protected void onUpdate() {
		this.createdAt = LocalDateTime.now();
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdateAt() {
		return this.updateAt == null ? getCreatedAt() : this.updateAt;
	}

}
