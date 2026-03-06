package com.proj1.proj1;
import jakarta.persistence.*;

@Entity
@Table(name="customer_details")
public class CustomerDetails {

	@Id//Annotation to represent Primary Key
	@Column(name="ID")//Changing the Column name
    private int id;
	@Column
    private String address; //Column names same as variable names since we are not changing
	@Column
    private String email;
	@Column
    private String mobile;
	
	@OneToOne(mappedBy="cust_det")
	private Customer customer;
	//Just for retrieving 
	public CustomerDetails() {}
    
	@Override
	public String toString() {
		return "Customer_details [id=" + id + ", address=" + address + ", email=" + email + ", mobile=" + mobile + "]";
	}

	public CustomerDetails(int id, String address, String email, String mobile) 
	{
		super();
		this.id = id;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
	}


	public int getId()
	{
		return id;
	}


	public void setId(int id)
	{
		this.id = id;
	}


	public String getAddress() 
	{
		return address;
	}


	public void setAddress(String address) 
	{
		this.address = address;
	}


	public String getEmail() 
	{
		return email;
	}


	public void setEmail(String email) 
	{
		this.email = email;
	}


	public String getMobile() 
	{
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}