package Contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	void testContact() {
		Contact contact = new Contact(
			"1234567890",
			"Charles",
			"Smith",
			"5551276894",
			"1256 Main St");
		
		assertEquals("1234567890", contact.getContactId());
		assertEquals("Charles", contact.getFirstName());
		assertEquals("Smith", contact.getLastName());
		assertEquals("5551276894", contact.getPhone());
		assertEquals("1256 Main St", contact.getAddress());
		}
	
	@Test
	void testContactIdTooLong() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact(
	        	"12345678901",
	            "Charles",
	            "Smith",
	            "5551276894",
	            "1256 Main St");
	    });
	}
	@Test
	void testContactIdNull() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact(
	        	null,
	            "Charles",
	            "Smith",
	            "5551276894",
	            "1256 Main St");
	    });
	}
	@Test
	void testFirstNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
				"1234567890",
				"CharlesLong",
				"Smith",
				"5551276894",
				"1256 Main St");
		});
	}
	@Test
	void testFirstNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
				"1234567890",
				null,
				"Smith",
				"5551276894",
				"1256 Main St");
		});
	}
	@Test
	void testLastNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
				"1234567890",
				"Charles",
				"SmithLonger",
				"5551276894",
				"1256 Main St");
		});
	}
	@Test
	void testLastNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
				"1234567890",
				"Charles",
				null, 
				"5551276894",
				"1256 Main St");
		});
	}
	@Test
	void testPhoneTooShort() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
				"1234567890",
				"Charles",
				"Smaith",
				"555127689",
				"1256 Main St");
		});
	}
	@Test
	void testPhoneTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
				"1234567890",
				"Charles",
				"Smith",
				"55512768941",
				"1256 Main St");
		});
	}
	@Test
	void testPhoneContainsLetters() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Contact(
	            "1234567890",
	            "Charles",
	            "Smith",
	            "12345abcde",
	            "1256 Main St");
	    });
	}
	@Test
	void testPhoneNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
				"1234567890",
				"Charles",
				"Smith",
				null,
				"1256 Main St");
		});
	}
	@Test
	void testAddressTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
				"1234567890",
				"Charles",
				"Smith",
				"5551276894",
				"12568 Skyline Truck Tail Suite #206");
		});
	}
	@Test
	void testAddressNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact (
				"1234567890",
				"Charles",
				"Smith",
				"5551276894",
				null);			
			});
	}
}
