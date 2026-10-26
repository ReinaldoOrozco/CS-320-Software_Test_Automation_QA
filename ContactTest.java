import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {
	
	@Test
	public void testValidContatcCreation() {
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
		assertEquals("12345", contact.getContactId());
		assertEquals("John", contact.getFirstName());
		assertEquals("Doe", contact.getLastName());
		assertEquals("1234567890", contact.getPhone());
		assertEquals("123 Main St", contact.getAddress());	
	}
	
	@Test
	public void testInvalidContactId() {
		assertThrows(IllegalArgumentException.class, ()-> {
			new Contact(null, "John", "Doe", "1234567890", "123 Main St");
		} );
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", "John", "Doe","1234567890", "123 Main St" );
		} );
	}
	
	@Test
	public void testInvalidFirstName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact ("123", null, "Doe", "1234567890", "123 Main St");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123", "ThisNameIsToLong", "Doe", "1234567890", "123 Main St");
		});
	}
	
	@Test
	public void testInvalidLastName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact ("123", "Joe", null, "1234567890", "123 Main St");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123", "John", "ThisLastNameIsToLong", "1234567890", "123 Main St");
		});
	}
	
	@Test
	public void testInvalidPhone() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact ("123", "John", "Doe", null, "123 Main St");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123", "John", "Doe", "123", "123 Main St");
		});
	}
	
	@Test
	public void testInvalidAddress() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact ("123", "John", "Doe", "1234567890", null);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123", "John", "Doe", "1234567890", "This address is definately way too long to be valid");
		});
	}
	
}