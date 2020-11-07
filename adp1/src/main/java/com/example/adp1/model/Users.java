package com.example.adp1.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@Entity
@Table(name = "users")
public class Users implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "user_Sequence")
    @SequenceGenerator(name = "user_Sequence", sequenceName = "user_SEQ")
    private Long userid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleid", nullable = false, insertable = false, updatable = false)
    private Role role;
    
	@NotNull
	@JsonIgnore
    @Column(name = "roleid")
    private Long roleid;
    
    @NotBlank
    @Size(max = 15)
    private String username;
    
    @NotBlank
    @Size(max = 15)
    private String pw;
    
    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "user")
    private Reviewer reviewer;
    
    // Getters and Setters

	public Long getuserid() {
		return userid;
	}

	public void setuserid(Long userid) {
		this.userid = userid;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getpw() {
		return pw;
	}

	public void setpw(String pw) {
		this.pw = pw;
	}
	
	@JsonIgnore
	public Long getroleid() {
		return roleid;
	}
	
	@JsonProperty
	public void setroleid(Long roleid) {
		this.roleid = roleid;
	}
}