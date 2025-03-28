package com.DigitalLibraryManagment.app;

import java.util.Scanner;

public class DigitalLibrarySystem {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Library libraryService = new Library();

	        while (true) {
	            System.out.println("\n1. Add Book\n2. View All Books\n3. Search Book\n4. Update Book\n5. Delete Book\n6. Exit\nChoose an option:");
	            int choice;
	            try {
	                choice = Integer.parseInt(scanner.nextLine());
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input. Please enter a number.");
	                continue;
	            }

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter Book ID: ");
	                    String bookId = scanner.nextLine();
	                    System.out.print("Enter Title: ");
	                    String title = scanner.nextLine();
	                    System.out.print("Enter Author: ");
	                    String author = scanner.nextLine();
	                    System.out.print("Enter Genre: ");
	                    String genre = scanner.nextLine();
	                    System.out.print("Enter Availability Status (Available/Checked Out): ");
	                    String status = scanner.nextLine();
	                    try {
	                        libraryService.addBook(new Book(bookId, title, author, genre, status));
	                    } catch (IllegalArgumentException e) {
	                        System.out.println("Error: " + e.getMessage());
	                    }
	                    break;
	                case 2:
	                    libraryService.viewAllBooks();
	                    break;
	                case 3:
	                    System.out.print("Enter Book ID or Title: ");
	                    String keyword = scanner.nextLine();
	                    libraryService.searchBook(keyword);
	                    break;
	                case 4:
	                    System.out.print("Enter Book ID to update: ");
	                    String updateId = scanner.nextLine();
	                    System.out.print("Enter new Title (or leave blank to keep unchanged): ");
	                    String newTitle = scanner.nextLine();
	                    System.out.print("Enter new Author (or leave blank to keep unchanged): ");
	                    String newAuthor = scanner.nextLine();
	                    System.out.print("Enter new Genre (or leave blank to keep unchanged): ");
	                    String newGenre = scanner.nextLine();
	                    System.out.print("Enter new Availability Status (Available/Checked Out): ");
	                    String newStatus = scanner.nextLine();
	                    libraryService.updateBook(updateId, newTitle, newAuthor, newGenre, newStatus);
	                    break;
	                case 5:
	                    System.out.print("Enter Book ID to delete: ");
	                    String deleteId = scanner.nextLine();
	                    libraryService.deleteBook(deleteId);
	                    break;
	                case 6:
	                    System.out.println("Exiting system.");
	                    scanner.close();
	                    return;
	                default:
	                    System.out.println("Invalid choice! Try again.");
	            }
	        }
	    }

}
