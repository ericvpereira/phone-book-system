package com.agenda.entities;

import com.agenda.enums.ContactType;

public class Contact {

	private long id;
	private String name;
	private String phone;
	private String email;
	private ContactType type;
	private Address address;

	public Contact() {
	}

	public Contact(long id, String name, String phone, String email, ContactType type) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ContactType getType() {
		return type;
	}

	public void setType(ContactType type) {
		this.type = type;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", type=" + type
				+ ", address=" + address + "]";
	}

}
