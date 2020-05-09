package com.project.ht.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@EntityScan
@Document(collection="listUser")
public class Welcome {
	
	@Id
	public String id;
	@NotEmpty(message = "Please provide a user-name")
	private String name;
	
	@Email(message = "Please provide a valid e-mail")
	@NotEmpty(message = "Please provide an e-mail")
	private String email;
	@NotEmpty(message = "Please provide a phone-no")
	private String phoneno;
	
	public Welcome(String name, String email, String phoneno) {
		super();
		this.name = name;
		this.email = email;
		this.phoneno=phoneno;
	}

	public Welcome() {
		super();
	}

	 public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }
	    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	

}
