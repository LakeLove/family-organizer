package io.github.lakelove.familyorganizer.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


@Table(name = "BasicInfo")
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@Entity
public class  BasicInfo {

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

}