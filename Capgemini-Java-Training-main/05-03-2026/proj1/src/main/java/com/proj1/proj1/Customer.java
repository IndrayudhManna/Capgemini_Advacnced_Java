package com.proj1.proj1;
import jakarta.persistence.*;

@Entity
@Table(name="customers")
public class Customer {

	@Id//Annotation to represent Primary Key
	@Column(name="ID")//Changing the Column name
    private int id;
	@Column
    private String name; //Column names same as variable names since we are not changing
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_details")
	private CustomerDetails cust_det;
	//Just for retrieving 
	public Customer() {}

	public CustomerDetails getCust_det() {
		return cust_det;
	}

	public void setCust_det(CustomerDetails cust_det) {
		this.cust_det = cust_det;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}

	public Customer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
    
}