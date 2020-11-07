package com.example.adp1.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.io.Serializable;

@Entity
@Table(name = "applicantstatus")
public class ApplicantStatus implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "applicantStatus_Sequence")
    @SequenceGenerator(name = "applicantStatus_Sequence", sequenceName = "APPLICANTSTATUS_SEQ")
    private Long applicantstatusid;
    
    @NotBlank
    @Size(max = 100)
    private String applicantstatusdescription;

	public Long getapplicantstatusid() {
		return applicantstatusid;
	}

	public void setapplicantstatusid(Long applicantstatusid) {
		this.applicantstatusid = applicantstatusid;
	}

	public String getapplicantstatusdescription() {
		return applicantstatusdescription;
	}

	public void setapplicantstatusdescription(String applicantstatusdescription) {
		this.applicantstatusdescription = applicantstatusdescription;
	}
    
}