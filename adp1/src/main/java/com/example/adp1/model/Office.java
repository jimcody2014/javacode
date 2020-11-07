package com.example.adp1.model;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;

@Entity
@Table(name = "office")
public class Office implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "office_Sequence")
    @SequenceGenerator(name = "office_Sequence", sequenceName = "office_SEQ")
    private Long officeid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "locationid", nullable = false)
    private Location location;
    
    @NotNull
    @Size(max = 100)
    private String officename;
    
    @Size(max = 50)
    private String officeaddress;
    
    @Size(max = 50)
    private String officecity;
    
    @NotNull
    @Size(max = 2)
    @Column(name = "officestate", columnDefinition = "char")
    private String officestate;
    
    @NotNull
    @Size(max = 5)
    @Column(name = "officezip", columnDefinition = "char")
    private String officezip;
    
    @Size(max = 15)
    private String officephone;
    
    // Getters and Setters

	public Long getofficeid() {
		return officeid;
	}

	public void setofficeid(Long officeid) {
		this.officeid = officeid;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getofficename() {
		return officename;
	}

	public void setofficename(String officename) {
		this.officename = officename;
	}

	public String getofficeaddress() {
		return officeaddress;
	}

	public void setofficeaddress(String officeaddress) {
		this.officeaddress = officeaddress;
	}

	public String getofficecity() {
		return officecity;
	}

	public void setofficecity(String officecity) {
		this.officecity = officecity;
	}

	public String getofficestate() {
		return officestate;
	}

	public void setofficestate(String officestate) {
		this.officestate = officestate;
	}

	public String getofficezip() {
		return officezip;
	}

	public void setofficezip(String officezip) {
		this.officezip = officezip;
	}

	public String getofficephone() {
		return officephone;
	}

	public void setofficephone(String officephone) {
		this.officephone = officephone;
	}
}