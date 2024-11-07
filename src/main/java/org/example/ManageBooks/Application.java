package org.example.ManageBooks;

import org.example.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private final ArrayList<Book> bookList = new ArrayList<>();

    public Application() {
        // Initialize with a sample book
        this.bookList.add(new Book("Robin Hood", "Tom Cruise", "1"));
    }

    // Main menu display function
    public void printMenu() {
        Scanner scanner = new Scanner(System.in);
        String menu =
                "1. Add book\n" +
                        "2. View all books\n" +
                        "3. Delete book\n" +
                        "4. Change repository\n" +
                        "5. Exit";

        String option;
        do {
            System.out.println(menu);
            System.out.print("Choose an option: ");
            option = scanner.nextLine();
            handleMenuOption(option);
        } while (!option.equals("5"));
    }

    // Menu handler method that calls respective functions
    private void handleMenuOption(String option) {
        switch (option) {
            case "1":
                addBook();
                break;
            case "2":
                viewBooks();
                break;
            case "3":
                deleteBook();
                break;
            case "4":
                changeRepository();
                break;
            case "5":
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }

    // Method to add a book with validation
    private void addBook() {
        Scanner scanner = new Scanner(System.in);
        String title, author, isbn;

        do {
            System.out.print("Add Title (required): ");
            title = scanner.nextLine().trim();
            System.out.print("Add Author (required): ");
            author = scanner.nextLine().trim();
            System.out.print("Add ISBN (required): ");
            isbn = scanner.nextLine().trim();

            if (title.isEmpty() || author.isEmpty() || isbn.isEmpty()) {
                System.out.println("All fields are mandatory. Please try again.");
            } else if (isDuplicateISBN(isbn)) {
                System.out.println("This ISBN already exists. Please try again.");
            } else {
                Book book = new Book(title, author, isbn);
                bookList.add(book);
                System.out.println("The book has been added successfully!");
                break;
            }
        } while (true);
    }

    // Method to view all books
    private void viewBooks() {
        if (bookList.isEmpty()) {
            System.out.println("There are no books in the repository.");
        } else {
            for (Book book : bookList) {
                System.out.println(book);
            }
        }
    }

    // Placeholder method for deleting a book
    private void deleteBook() {
        System.out.println("Option to delete a book is under development.");
    }

    // Placeholder method for changing the repository
    private void changeRepository() {
        System.out.println("Option to change repository is under development.");
    }

    // Helper method to check for duplicate ISBNs
    private boolean isDuplicateISBN(String isbn) {
        for (Book book : bookList) {
            if (book.getISBN().equals(isbn)) {
                return true;
            }
        }
        return false;
    }
}
