package com.example.adp1.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.io.Serializable;

@Entity
@Table(name = "role")
public class Role implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "role_Sequence")
    @SequenceGenerator(name = "role_Sequence", sequenceName = "role_SEQ")
    private Long roleid;
    
    @NotBlank
    @Size(max = 100)
    private String rolename;
    
    // Getters and Setters

	public Long getroleid() {
		return roleid;
	}

	public void setroleid(Long roleid) {
		this.roleid = roleid;
	}

	public String getrolename() {
		return rolename;
	}

	public void setrolename(String rolename) {
		this.rolename = rolename;
	}

}