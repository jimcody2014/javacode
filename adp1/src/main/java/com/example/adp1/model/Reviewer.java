package com.example.adp1.model;
import javax.persistence.*;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;

@Entity
@Table(name = "reviewer")
public class Reviewer implements Serializable 
{

// Getters and Setters omitted for brevity

private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "reviewer_Sequence")
    @SequenceGenerator(name = "reviewer_Sequence", sequenceName = "reviewer_SEQ", initialValue  = 1000, allocationSize = 50)
    private Long reviewerid;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private Users user;
    
    @NotNull
    @JsonIgnore
    @Column(name = "userid")
    private Long userid;
    
    @NotNull
    @Size(max = 100)
    private String reviewerlastname;
    
    @NotNull
    @Size(max = 100)
    private String reviewerfirstname;
    
    @NotNull
    @Size(max = 100)
    private String reviewercity;
    
    @NotNull
    @Size(max = 2)
    @Column(name = "reviewerstate", columnDefinition = "char")
    private String reviewerstate;
    
    @NotNull
    @Size(max = 5)
    private String reviewerzip;

    
    //getters and setters
	public Long getreviewerid() {
		return reviewerid;
	}

	public void setreviewerid(Long reviewerid) {
		this.reviewerid = reviewerid;
	}

	public Users getuser() {
		return user;
	}

	public void setuser(Users user) {
		this.user = user;
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

   

	@JsonIgnore
    public Long getuserid() {
		return userid;
	}

	@JsonProperty
	public void setuserid(Long userid) {
		this.userid = userid;
	}
         
}
