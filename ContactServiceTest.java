import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
	
	@Test
	public void testAddContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
		
		service.addContact(contact);
		assertEquals(contact, service.getContact("1"));
	}
	
	@Test
	public void testAddDuplicateContactId() {
		ContactService service = new ContactService();
		Contact contact1 = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
		Contact contact2 = new Contact("1", "Jane", "Smith", "0987456321", "456 Elm St");
		
		service.addContact(contact1);
		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(contact2);
		});
	}
	
	@Test
	public void testDeleteContact() {
		ContactService service = new ContactService();
		Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
		
		service.addContact(contact);
		service.deleteContact("1");
		
		assertNull(service.getContact("1"));
	}
	
	@Test
	public void testUpdateFields() {
		ContactService service = new ContactService();
		Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
		
		service.addContact(contact);
		
		service.updateFirstName("1", "Mike");
		assertEquals("Mike", service.getContact("1").getFirstName());
		
		service.updateLastName("1", "Smith");
		assertEquals("Smith", service.getContact("1").getLastName());
		
		service.updatePhone("1", "0987456321");
		assertEquals("0987456321", service.getContact("1").getPhone());
		
		service.updateAddress("1", "456 Elm St");
		assertEquals("456 Elm St", service.getContact("1").getAddress());
	}
}
