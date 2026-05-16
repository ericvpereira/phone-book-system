package com.agenda.exceptions;

public class ContactNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ContactNotFoundException() {
		super("Contact not found");
	}
}
