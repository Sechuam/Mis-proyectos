import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
	
	private List<Book> books = new ArrayList<>();
	private List<User> users = new ArrayList<>();
	
	// Métodos para manejar libros
	
	public void addBook(String title, String author) {
		books.add(new Book(title, author));
	}
	
	public void listBooks() {
		for (Book book : books) {
			System.out.println(book);
		}
	}
	
	public Book findBook(String title) {
		for (Book book : books) {
			if (book.getTitle().equalsIgnoreCase(title)) {
				return book;
			}
		}
		return null;
	}
	
	// Métodos para manejar usuarios
	
	public void addUser(String name, String userId) {
		users.add(new User(name, userId));
	}
	
	public User findUser(String userId) {
		for (User user : users) {
			if (user.getUserId().equals(userId)) {
				return user;
			}
		}
		return null;
	}
	
	// Métodos para manejar préstamos y devoluciones
	
	public void borrowBook(String title, String userId) {
		Book book = findBook(title);
		User user = findUser(userId);
		
		if (book != null && user != null && book.isAvailable()) {
			book.borrowBook();
			System.out.println("El libro '" + title + "' ha sido prestado a " + user.getName());
		} else if (book == null) {
			System.out.println("El libro no se encuentra en la biblioteca.");
		} else if (user == null) {
			System.out.println("Usuario no registrado.");
		} else {
			System.out.println("El libro ya está prestado.");
		}
	}
	
	public void returnBook(String title) {
		Book book = findBook(title);
		
		if (book != null && !book.isAvailable()) {
			book.returnBook();
			System.out.println("El libro '" + title + "' ha sido devuelto.");
		} else if (book == null) {
			System.out.println("El libro no se encuentra en la biblioteca.");
		} else {
			System.out.println("El libro no estaba prestado.");
		}
	}
}
