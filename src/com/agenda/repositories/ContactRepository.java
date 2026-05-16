package com.agenda.repositories;

import java.util.ArrayList;
import java.util.List;

import com.agenda.entities.Contact;
import com.agenda.exceptions.ContactNotFoundException;

public class ContactRepository {

	private List<Contact> contacts = new ArrayList<>();

	public void save(Contact contact) {
		contacts.add(contact);
		System.out.println("Contact saved with success");
	}

	public void delete(Long id) {

		Contact contactFound = findById(id);

		if (contactFound != null) {
			contacts.remove(contactFound);
			System.out.println("Contact removed with success");
			return;
		}
		throw new ContactNotFoundException();
	}

	public Contact findById(Long id) {
		for (Contact contact : contacts) {
			if (contact.getId() == id) {
				return contact;
			}
		}
		throw new ContactNotFoundException();
	}

	public List<Contact> findAll() {
		return new ArrayList<>(contacts);
	}
}
