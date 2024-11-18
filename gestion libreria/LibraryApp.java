import java.util.Scanner;

public class LibraryApp {
	public static void main(String[] args) {
		LibraryManager libraryManager = new LibraryManager();
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			
			System.out.println("\n--- Sistema de Gestión de Biblioteca ---");
			System.out.println("1. Añadir libro");
			System.out.println("2. Listar libros");
			System.out.println("3. Registrar usuario");
			System.out.println("4. Prestar libro");
			System.out.println("5. Devolver libro");
			System.out.println("6. Salir");
			System.out.println("Selecciona una opción: ");
			
			int option = scanner.nextInt();
			scanner.nextLine(); //limpiar el buffer
			
			switch (option) {
			case 1: 
				System.out.print("Título del libro: ");
				String title = scanner.nextLine();
				System.out.print("Autor del libro: ");
				String author = scanner.nextLine();
				libraryManager.addBook(title, author);
				break;
			case 2:
				libraryManager.listBooks();
				break;
			case 3:
				System.out.print("Nombre del usuario: ");
				String name = scanner.nextLine();
				System.out.print("ID del usuario: ");
				String userId = scanner.nextLine();
				libraryManager.addUser(name, userId);
				break;
			case 4:
				System.out.print("Título del libro a prestar: ");
                String borrowTitle = scanner.nextLine();
                System.out.print("ID del usuario: ");
                String borrowUserId = scanner.nextLine();
                libraryManager.borrowBook(borrowTitle, borrowUserId);
                break;
			case 5:
				System.out.print("Título del libro a devolver: ");
                String returnTitle = scanner.nextLine();
                libraryManager.returnBook(returnTitle);
                break;
			case 6:
				System.out.println("Saliendo del sistema. ¡Hasta luego!");
                scanner.close();
                return;
            default:
                	System.out.println("Opción no válida. Inténtalo de nuevo.");
                	
			}
		}
	}

}
