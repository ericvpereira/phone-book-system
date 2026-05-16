package com.agenda.application;

import java.util.List;
import java.util.Scanner;

import com.agenda.entities.Address;
import com.agenda.entities.Contact;
import com.agenda.enums.ContactType;
import com.agenda.repositories.ContactRepository;
import com.agenda.services.ContactService;

public class Program {

	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		ContactRepository repository = new ContactRepository();
		ContactService service = new ContactService(repository);

		int option;

		do {

			showMenu();
			option = readInt("Choose an option: ");

			switch (option) {

			case 1:
				addContact(service);
				break;

			case 2:
				listContacts(service);
				break;

			case 3:
				findContact(service);
				break;

			case 4:
				updateContact(service);
				break;

			case 5:
				removeContact(service);
				break;

			case 0:
				System.out.println("Program closed");
				break;

			default:
				System.out.println("Invalid option");
			}

		} while (option != 0);

		sc.close();

	}

	// ================= MENU =================

	public static void showMenu() {

		System.out.println("\n===== PHONE AGENDA =====");
		System.out.println("1 - Add Contact");
		System.out.println("2 - List contacts");
		System.out.println("3 - Find contact by name");
		System.out.println("4 - Update contact");
		System.out.println("5 - Remove contact");
		System.out.println("0 - Exit");
	}

	// ================= ADD =================

	public static void addContact(ContactService service) {

		System.out.println("\n=== ADD CONTACT ===");

		long id = readLong("Id: ");

		System.out.print("Name: ");
		String name = sc.nextLine();

		System.out.print("Phone: ");
		String phone = sc.nextLine();

		System.out.print("Email: ");
		String email = sc.nextLine();

		ContactType type = chooseType();

		Address address = createAddress();

		Contact contact = new Contact(id, name, phone, email, type);
		contact.setAddress(address);

		service.addContact(contact);

		System.out.println("Contact added successfully");

	}

	// ================= LIST =================

	public static void listContacts(ContactService service) {

		System.out.println("\n=== CONTACT LIST ===");

		List<Contact> contacts = service.listAll();

		if (contacts.isEmpty()) {
			System.out.println("No contacts found");
			return;
		}

		for (Contact contact : contacts) {
			System.out.println(contact);
		}
	}

	// ================= FIND =================

	public static void findContact(ContactService service) {

		System.out.print("\nContact name: ");
		String name = sc.nextLine();

		try {

			Contact contact = service.findByName(name);

			System.out.println(contact);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// ================= UPDATE =================

	public static void updateContact(ContactService service) {

		System.out.println("\n==== UPDATE CONTACT ===");

		long id = readLong("Contact id: ");

		System.out.print("New name: ");
		String name = sc.nextLine();

		System.out.print("New phone: ");
		String phone = sc.nextLine();

		System.out.print("New email: ");
		String email = sc.nextLine();

		ContactType type = chooseType();

		Address address = createAddress();

		Contact updatedContact = new Contact(id, name, phone, email, type);
		updatedContact.setAddress(address);

		try {

			service.updateContact(updatedContact);

			System.out.println("Contact updated successfully");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// ================= REMOVE =================

	public static void removeContact(ContactService service) {

		long id = readLong("\nContact id: ");

		try {

			service.removeContact(id);

			System.out.println("Contact removed");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// ================= ADDRESS =================

	public static Address createAddress() {

		System.out.println("\n=== ADDRESS ===");

		System.out.print("Street: ");
		String street = sc.nextLine();

		System.out.print("City: ");
		String city = sc.nextLine();

		System.out.print("State: ");
		String state = sc.nextLine();

		System.out.print("Zip code: ");
		String zipCode = sc.nextLine();

		return new Address(street, city, state, zipCode);
	}

	// ================= ENUM =================

	public static ContactType chooseType() {

		System.out.println("\nContact Type:");
		System.out.println("1 - FAMILY");
		System.out.println("2 - FRIEND");
		System.out.println("3 - WORK");
		System.out.println("4 - OTHER");

		int option = readInt("Option: ");

		switch (option) {

		case 1:
			return ContactType.FAMILY;

		case 2:
			return ContactType.FRIEND;

		case 3:
			return ContactType.WORK;

		default:
			return ContactType.OTHER;
		}
	}

	// ================= INPUTS =================

	public static int readInt(String message) {

		System.out.print(message);

		int value = Integer.parseInt(sc.nextLine());

		return value;
	}

	public static long readLong(String message) {

		System.out.print(message);

		long value = Long.parseLong(sc.nextLine());

		return value;
	}

}
