package fr.gtm.bo;


import java.util.List;

public class MainClientContactsRest {

	public static void main(String[] args) {
//		List<Contact> contacts = ClientsContactsService.getAllContacts();
//		for(Contact c : contacts) {
//			System.out.println(c);
//		}
		
//		ClientsContactsService.addContact("M", "Jackson", "Mickael");
//		ClientsContactsService.delContact(59);
//		ClientsContactsService.updateContact(58, "Mme", "Morganne", "Clara");
//		System.out.println(ClientsContactsService.getById(3));
		System.out.println(ClientsContactsService.getAdressesByContactId(1));
	}

}
