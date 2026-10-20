package Contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactServiceTest {

	@Test
	void testAddContact() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact(
			"1234567890",
			"Charles",
			"Smith",
			"5551276894",
			"1256 Main St");
	
		service.addContact(contact);
		assertSame(contact, service.getContact("1234567890"));
	}
	@Test
	void testAddNullContact() {
	    ContactService service = new ContactService();

	    assertThrows(IllegalArgumentException.class, () -> {
	        service.addContact(null);
	    });
	}
	@Test
	void testAddDuplicateContact() {
		ContactService service = new ContactService();
		
		Contact contact1 = new Contact(
			"1234567890",
			"Charles",
			"Smith",
			"5551276894",
			"1256 Main St");
		
		Contact contact2 = new Contact(
			"1234567890",
			"Jason",
			"Miles",
			"5551276897",
			"1253 Oak Dr");
		
		service.addContact(contact1);
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(contact2);
		});
	}
	@Test
	void testDeleteContact() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact(
			"1234567890",
			"Charles",
			"Smith",
			"5551276894",
			"1256 Main St");
		
		service.addContact(contact);
		service.deleteContact("1234567890");
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact("1234567890");
		});
	}
	@Test
	void testUpdateFirstName() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact(
			"1234567890",
			"Charles",
			"Smith",
			"5551276894",
			"1256 Main St");
		
		service.addContact(contact);
		service.updateFirstName("1234567890", "Jason");
		
		assertEquals("Jason", contact.getFirstName());
	}
	@Test
	void testUpdateLastName() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact(
			"1234567890",
			"Charles",
			"Smith",
			"5551276894",
			"1256 Main St");
		
		service.addContact(contact);
		service.updateLastName("1234567890", "Miles");
		
		assertEquals("Miles", contact.getLastName());
	}
	@Test
	void testUpdatePhone() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact(
			"1234567890",
			"Charles",
			"Smith",
			"5551276894",
			"1256 Main St");
		
		service.addContact(contact);
		service.updatePhone("1234567890", "5551276897");
		
		assertEquals("5551276897", contact.getPhone());
	}
	@Test
	void testUpdateAddress() {
		ContactService service = new ContactService();
		
		Contact contact = new Contact(
			"1234567890",
			"Charles",
			"Smith",
			"5551276894",
			"1256 Main St");
		
		service.addContact(contact);
		service.updateAddress("1234567890", "1253 Oak Dr");
		
		assertEquals("1253 Oak Dr", contact.getAddress());
	}
	@Test
	void testDeleteContactNotFound() {
		ContactService service = new ContactService();
		
		assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact("1234567890");
		});
	}
	@Test
	void testUpdateContactNotFound() {
	    ContactService service = new ContactService();

	    assertThrows(IllegalArgumentException.class, () -> {
	        service.updateFirstName("1234567890", "Jason");
	    });
	}
}
