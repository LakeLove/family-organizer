package io.github.lakelove.familyorganizer.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Objects;

@AllArgsConstructor
@Builder(builderClassName = "Builder", toBuilder = true)
@Entity
@Getter
@NoArgsConstructor
@Setter
@Table(name = "BasicInfo")
@ToString
public class BasicInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String middleName;
	private String lastName;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdatedDate;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true; if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		BasicInfo basicInfo = (BasicInfo) o; return id != null && Objects.equals(id, basicInfo.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}