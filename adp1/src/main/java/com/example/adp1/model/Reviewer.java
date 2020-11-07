package com.example.adp1.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

@Entity
@Table(name = "reviewer")
public class Reviewer implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "reviewer_Sequence")
    @SequenceGenerator(name = "reviewer_Sequence", sequenceName = "reviewer_SEQ")
    private Long reviewerid;
	
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnore
    private Users user;
    
    @NotBlank
    @Size(max = 100)
    private String reviewertitle;
    
    @NotBlank
    @Size(max = 100)
    private String reviewerlastname;
    
    @NotBlank
    @Size(max = 100)
    private String reviewerfirstname;
    
    @NotBlank
    @Size(max = 100)
    private String reviewerbusiness;
    
    @NotBlank
    @Size(max = 100)
    private String revieweraddress;
    
    @NotBlank
    @Size(max = 100)
    private String reviewercity;
    
    @NotBlank
    @Size(max = 2)
    @Column(name = "reviewerstate", columnDefinition = "char")
    private String reviewerstate;
    
    @NotBlank
    @Size(max = 5)
    private String reviewerzip;
    
    // Getters and Setters

	public Long getreviewerid() {
		return reviewerid;
	}

	public void setreviewerid(Long reviewerid) {
		this.reviewerid = reviewerid;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getreviewertitle() {
		return reviewertitle;
	}

	public void setreviewertitle(String reviewertitle) {
		this.reviewertitle = reviewertitle;
	}

	public String getreviewerlastname() {
		return reviewerlastname;
	}

	public void setreviewerlastname(String reviewerlastname) {
		this.reviewerlastname = reviewerlastname;
	}

	public String getreviewerfirstname() {
		return reviewerfirstname;
	}

	public void setreviewerfirstname(String reviewerfirstname) {
		this.reviewerfirstname = reviewerfirstname;
	}

	public String getreviewerbusiness() {
		return reviewerbusiness;
	}

	public void setreviewerbusiness(String reviewerbusiness) {
		this.reviewerbusiness = reviewerbusiness;
	}

	public String getrevieweraddress() {
		return revieweraddress;
	}

	public void setrevieweraddress(String revieweraddress) {
		this.revieweraddress = revieweraddress;
	}

	public String getreviewercity() {
		return reviewercity;
	}

	public void setreviewercity(String reviewercity) {
		this.reviewercity = reviewercity;
	}

	public String getreviewerstate() {
		return reviewerstate;
	}

	public void setreviewerstate(String reviewerstate) {
		this.reviewerstate = reviewerstate;
	}

	public String getreviewerzip() {
		return reviewerzip;
	}

	public void setreviewerzip(String reviewerzip) {
		this.reviewerzip = reviewerzip;
	}
}