package com.DigitalLibraryManagment.app;

import java.util.HashMap;
import java.util.Map;

class Library {
    private Map<String, Book> books = new HashMap<>();
    
    public void addBook(Book book) {
        if (books.containsKey(book.getBookId())) {
            System.out.println("Book ID must be unique!");
            return;
        }
        books.put(book.getBookId(), book);
        System.out.println("Book added successfully.");
    }

    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }
        books.values().forEach(System.out::println);
    }

    public void searchBook(String keyword) {
        for (Book book : books.values()) {
            if (book.getBookId().equalsIgnoreCase(keyword) || book.getBookTitle().equalsIgnoreCase(keyword)) {
                System.out.println(book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void updateBook(String bookId, String title, String author, String genre, String availabilityStatus) {
        if (!books.containsKey(bookId)) {
            System.out.println("Book not found.");
            return;
        }
        Book book = books.get(bookId);
        if (!title.isEmpty()) book.setBookTitle(title);
        if (!author.isEmpty()) book.setBookAuthor(author);
        if (!genre.isEmpty()) book.setBookGenre(genre);
        if (!availabilityStatus.isEmpty()) book.setBookAvailabilityStatus(availabilityStatus);
        System.out.println("Book updated successfully.");
    }

    public void deleteBook(String bookId) {
        if (books.remove(bookId) != null) {
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }
}