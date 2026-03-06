package com.proj1.proj1;
import jakarta.persistence.*;

@Entity
@Table(name="employees")
public class Employee {

	@Id//Annotation to represent Primary Key
	@Column(name="EmpID")//Changing the Column name
    private int id;
	@Column
    private String name; //Column names same as variable names since we are not changing
	@Column
    private String email;
	@Column
    private String mobile;
	
	//Just for retrieving 
	public Employee() {}
    
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + "]";
	}

	public Employee(int id, String name, String email, String mobile) 
	{
		super();
		this.id = id;
		this.name = name;
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


	public String getName() 
	{
		return name;
	}


	public void setName(String name) 
	{
		this.name = name;
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
