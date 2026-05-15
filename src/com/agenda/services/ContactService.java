package com.agenda.services;

import java.util.List;

import com.agenda.entities.Contact;
import com.agenda.exceptions.ContactNotFoundException;
import com.agenda.repositories.ContactRepository;

public class ContactService {

	private ContactRepository repository;

	public ContactService() {
	}

	public ContactService(ContactRepository repository) {
		this.repository = repository;
	}

	public void addContact(Contact contact) {
		repository.save(contact);
	}

	public void removeContact(Long id) {
		repository.delete(id);
	}

	public void updateContact(Contact contact) {

		Contact existingContact = repository.findById(contact.getId());

		if (existingContact != null) {

			existingContact.setName(contact.getName());
			existingContact.setPhone(contact.getPhone());
			existingContact.setEmail(contact.getEmail());
			existingContact.setType(contact.getType());
			existingContact.setAddress(contact.getAddress());

			System.out.println("Contact updated successfully");
			return;
		}

		throw new ContactNotFoundException();

	}

	public Contact findByName(String name) {
		for (Contact contact : repository.findAll()) {
			if (contact.getName().equalsIgnoreCase(name)) {
				return contact;
			}
		}
		throw new ContactNotFoundException();
	}

	public List<Contact> listAll() {
		return repository.findAll();
	}
}
