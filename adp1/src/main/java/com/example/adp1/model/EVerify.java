package com.example.adp1.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "everify")
public class EVerify implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "eVerify_Sequence")
    @SequenceGenerator(name = "eVerify_Sequence", sequenceName = "eVerify_SEQ")
    private Long everifyid;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "rundate", nullable = false)
    private Date rundate;
    
    @Column(name="initiatedbyuserid")
    Integer initiatedbyuserid;
    
    // Getters and Setters

	public Long geteverifyid() {
		return everifyid;
	}

	public void seteverifyid(Long everifyid) {
		this.everifyid = everifyid;
	}

	public Date getrundate() {
		return rundate;
	}

	public void setrundate(Date rundate) {
		this.rundate = rundate;
	}

	public Integer getinitiatedbyuserid() {
		return initiatedbyuserid;
	}

	public void setinitiatedbyuserid(Integer initiatedbyuserid) {
		this.initiatedbyuserid = initiatedbyuserid;
	}
}