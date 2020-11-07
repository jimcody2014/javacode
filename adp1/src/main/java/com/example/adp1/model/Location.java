package com.example.adp1.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.io.Serializable;

@Entity
@Table(name = "location")
public class Location implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "location_Sequence")
    @SequenceGenerator(name = "location_Sequence", sequenceName = "location_SEQ")
    private Long locationid;
    
    @NotBlank
    @Size(max = 100)
    private String locationname;
    
    @Transient
    private String regionname;
    
    // Getters and Setters

	public Long getlocationid() {
		return locationid;
	}

	public void setlocationid(Long locationid) {
		this.locationid = locationid;
	}

	public String getlocationname() {
		return locationname;
	}

	public void setlocationname(String locationname) {
		this.locationname = locationname;
	}
	
	@GeneratedValue
	public String getregionname() {
		return regionname;
	}	
	@GeneratedValue
	public void setregionname(String regionname) {
		this.regionname = regionname;
	}	

}