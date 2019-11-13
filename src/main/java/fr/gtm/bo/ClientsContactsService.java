package fr.gtm.bo;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class ClientsContactsService {

	public static List<Contact> getAllContacts() {
		String domaine = "http://localhost:9080/jboss-contacts-rest/";
		String uri = domaine + "rest/contacts/all";

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(uri);
		Contact[] contacts = target.request(MediaType.APPLICATION_JSON).get(Contact[].class);
		return Arrays.asList(contacts);
	}
	
	public static Contact addContact(String civilite, String nom, String prenom) {
		Contact c = new Contact(civilite, nom, prenom);
		String domaine = "http://localhost:9080/jboss-contacts-rest/";
		String uri = domaine + "rest/contacts/add";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(uri);
		Contact contact = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(c, MediaType.APPLICATION_JSON), Contact.class);
		return contact;
	}
	
	public static void delContact(long id) {
		String domaine = "http://localhost:9080/jboss-contacts-rest/";
		String uri = domaine + "rest/contacts/del/"+id;	
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(uri);
		target.request().delete();
	}
	
	public static Contact updateContact(long id, String civilite, String nom, String prenom) {
		Contact c = new Contact(civilite, nom, prenom);
		c.setId(id);
		String domaine = "http://localhost:9080/jboss-contacts-rest/";
		String uri = domaine + "rest/contacts/edit";	
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(uri);
		target.request(MediaType.APPLICATION_JSON).post(Entity.json(c), String.class);	
		return c;
	}
	
	public static Contact getById(long id) {
		String domaine = "http://localhost:9080/jboss-contacts-rest/";
		String uri = domaine + "rest/contacts/get/"+id;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(uri);
		Contact c = target.request(MediaType.APPLICATION_JSON).get(Contact.class);
		return c;
	}
	
	public static List<Adresse> getAdressesByContactId(long id) {
		String domaine = "http://localhost:9080/jboss-contacts-rest/";
		String uri = domaine + "rest/contacts/adresses/"+id;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(uri);
		Adresse[] adresses = target.request(MediaType.APPLICATION_JSON).get(Adresse[].class);
		return Arrays.asList(adresses);
	}
	
}
