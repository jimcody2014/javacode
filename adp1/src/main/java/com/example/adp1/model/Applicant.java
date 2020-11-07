package com.example.adp1.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "applicant")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Applicant implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "applicant_Sequence")
    @SequenceGenerator(name = "applicant_Sequence", sequenceName = "APPLICANT_SEQ", initialValue = 1000, allocationSize = 1)
    private Long applicantid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "applicantstatusid", nullable = false, insertable = false, updatable = false)
    private ApplicantStatus applicantStatus;
    
	@NotNull
	@JsonIgnore
    @Column(name = "applicantstatusid")
    private Long applicantstatusid;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private Users user;
    
    @NotNull
    @Column(name = "userid")
    private Long userid;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "officeid", nullable = false, insertable = false, updatable = false)
    private Office office;
    
    @NotNull
    @JsonIgnore
    @Column(name = "officeid")
    private Long officeid;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "everifyid", nullable = true, insertable = false, updatable = false)
    @JsonIgnore
    private EVerify eVerfiy;
    
    @Column(name = "everifyid")
    private Long everifyid;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewerid", nullable = true, insertable = false, updatable = false)
    @JsonIgnore
    private Reviewer reviewer;
    
    @Column(name = "reviewerid")
    private Long reviewerid;
    
    @NotNull
    @Size(max = 100)
    private String applicantlastname;
    
    @NotNull
    @Size(max = 100)
    private String applicantfirstname;
    
    @NotNull
    @Size(max = 1)
    @Column(name = "applicantmi", columnDefinition = "char")
    private String applicantmi;
    
    @NotNull
    @Size(max = 100)
    private String applicantstreet;
    
    @Size(max = 20)
    private String applicantaptnumber;
    
    @NotNull
    @Size(max = 100)
    private String applicantcity;
    
    @NotNull
    @Size(max = 2)
    @Column(name = "applicantstate", columnDefinition = "char")
    private String applicantstate;
    
    @NotNull
    @Size(max = 5)
    private String applicantzip;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "applicantbirthdate", nullable = false)
    private Date applicantbirthdate;
    
    @NotNull
    @Size(max = 9)
    @Column(name = "applicantssn", columnDefinition = "char")
    private String applicantssn;
    
    @NotNull
    @Size(max = 100)
    private String applicantemail;
    
    @NotNull
    @Size(max = 50)
    private String applicantphone;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "applicanthiredate", nullable = false)
    private Date applicanthiredate;
    
    
    // Getters and Setters
    
    @JsonIgnore
	public Long getapplicantstatusid() {
		return applicantstatusid;
	}
    
    @JsonProperty
	public void setapplicantstatusid(Long applicantstatusid) {
    	this.applicantstatusid = applicantstatusid;
	}

	public Long getuserid() {
		return userid;
	}

	public void setuserid(Long userid) {
		this.userid = userid;
	}

	@JsonIgnore
	public Long getofficeid() {
		return officeid;
	}

	@JsonProperty
	public void setofficeid(Long officeid) {
		this.officeid = officeid;
	}

	public Long geteverifyid() {
		return everifyid;
	}

	public void seteverifyid(Long everifyid) {
		this.everifyid = everifyid;
	}

	public Long getreviewerid() {
		return reviewerid;
	}

	public void setreviewerid(Long reviewerid) {
		this.reviewerid = reviewerid;
	}

	public String getapplicantlastname() {
		return applicantlastname;
	}

	public void setapplicantlastname(String applicantlastname) {
		this.applicantlastname = applicantlastname;
	}

	public String getapplicantfirstname() {
		return applicantfirstname;
	}

	public void setapplicantfirstname(String applicantfirstname) {
		this.applicantfirstname = applicantfirstname;
	}

	public String getapplicantmi() {
		return applicantmi;
	}

	public void setapplicantmi(String applicantmi) {
		this.applicantmi = applicantmi;
	}

	public String getapplicantstreet() {
		return applicantstreet;
	}

	public void setapplicantstreet(String applicantstreet) {
		this.applicantstreet = applicantstreet;
	}

	public String getapplicantaptnumber() {
		return applicantaptnumber;
	}

	public void setapplicantaptnumber(String applicantaptnumber) {
		this.applicantaptnumber = applicantaptnumber;
	}

	public String getapplicantcity() {
		return applicantcity;
	}

	public void setapplicantcity(String applicantcity) {
		this.applicantcity = applicantcity;
	}

	public String getapplicantstate() {
		return applicantstate;
	}

	public void setapplicantstate(String applicantstate) {
		this.applicantstate = applicantstate;
	}

	public String getapplicantzip() {
		return applicantzip;
	}

	public void setapplicantzip(String applicantzip) {
		this.applicantzip = applicantzip;
	}

	public Date getapplicantbirthdate() {
		return applicantbirthdate;
	}

	public void setapplicantbirthdate(Date applicantbirthdate) {
		this.applicantbirthdate = applicantbirthdate;
	}

	public String getapplicantssn() {
		return applicantssn;
	}

	public void setapplicantssn(String applicantssn) {
		this.applicantssn = applicantssn;
	}

	public String getapplicantemail() {
		return applicantemail;
	}

	public void setapplicantemail(String applicantemail) {
		this.applicantemail = applicantemail;
	}

	public String getapplicantphone() {
		return applicantphone;
	}

	public void setapplicantphone(String applicantphone) {
		this.applicantphone = applicantphone;
	}

	public Date getapplicanthiredate() {
		return applicanthiredate;
	}

	public void setapplicanthiredate(Date applicanthiredate) {
		this.applicanthiredate = applicanthiredate;
	}

	public Long getapplicantid() {
		return applicantid;
	}

	public void setapplicantid(Long applicantid) {
		this.applicantid = applicantid;
	}

	public ApplicantStatus getApplicantStatus() {
		return applicantStatus;
	}

	public Users getUser() {
		return user;
	}

	public Office getOffice() {
		return office;
	}

	public EVerify geteVerfiy() {
		return eVerfiy;
	}

	public Reviewer getReviewer() {
		return reviewer;
	}
}