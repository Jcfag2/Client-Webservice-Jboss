package fr.gtm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fr.gtm.bo.ClientsContactsService;
import fr.gtm.bo.Contact;

public class TestsClientsContactsService {

	@Test
	public void testGetAllContacts() {
		List<Contact> contacts = ClientsContactsService.getAllContacts();
		assertNotNull(contacts);
		assertTrue(contacts.size()>0);
	}

	@Test
	public void testAddDeleteContact() {
		//Test de l'ajout
		Contact c = new Contact("M", "Tajiri", "Satoshi");
		Contact c2 = ClientsContactsService.addContact("M", "Tajiri", "Satoshi");
		c.setId(c2.getId());
		assertEquals(c, c2);
		
		//Test de la suppression
		List<Contact> contacts1 = ClientsContactsService.getAllContacts();
		ClientsContactsService.delContact(c2.getId());
		List<Contact> contacts2 = ClientsContactsService.getAllContacts();
		assertNotEquals(contacts1.size(), contacts2.size());
	}


	@Test
	public void testUpdateContact() {
		Contact c3 = ClientsContactsService.addContact("M", "Tajiri", "Satoshi");
		Contact c = ClientsContactsService.updateContact(c3.getId(), "M", "Péan", "Frédéric");
		Contact c2 = ClientsContactsService.getById(c3.getId());
		assertEquals(c, c2);
		ClientsContactsService.delContact(c3.getId());
		
	}

}
