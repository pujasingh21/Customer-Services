package com.customerApi.api.modals;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id	
	@GeneratedValue
	private int id;
	
	@NotNull
	@Size(min=2, message="First Name should have atleast 2 characters")
	private String firstName;
	
	@NotNull
	@Size(min=2, message="Last Name should have atleast 2 characters")
	private String lastName;
	
	@NotNull
	@Size(min=4, message="User Name should have atleast 2 characters")
	private String username;
	
	@NotNull
	@Size(min=8, message="Password should have atleast 8 characters")
	private String password;
	
	private String address;
	
	@NotBlank
	@Size(min=10, max=11, message="Please enter valid Contact number")
	private String contact;
	
	
	public Customer()
	{
		
	}
	public Customer(int id,String fname, String lname, String uname, String pswd, String address, String contact)
	{
		this.id=id;
		this.firstName=fname;
		this.lastName=lname;
		this.username=uname;
		this.address=address;
		this.password=pswd;
		this.contact=contact;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", address=" + address + ", contact=" + contact + "]";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	

}
