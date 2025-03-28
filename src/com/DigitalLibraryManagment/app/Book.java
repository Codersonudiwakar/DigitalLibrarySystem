package com.DigitalLibraryManagment.app;


import java.util.HashSet;
import java.util.Set;

public class Book {
    private static final Set<String> bookIds = new HashSet<>(); 

    private String bookId;
    private String bookTitle;
    private String bookAuthor;
    private String bookGenre;
    private String bookAvailabilityStatus;

    public Book(String bookId, String bookTitle, String bookAuthor, String bookGenre, String bookAvailabilityStatus) {
        validateBookId(bookId);
        validateNonEmpty(bookTitle, "Book title cannot be empty.");
        validateNonEmpty(bookAuthor, "Book author cannot be empty.");
        validateAvailabilityStatus(bookAvailabilityStatus);

        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookGenre = bookGenre;
        this.bookAvailabilityStatus = bookAvailabilityStatus;
        
        bookIds.add(bookId); 
    }

    public Book() {
        super();
    }

    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor + ", bookGenre="
                + bookGenre + ", bookAvailabilityStatus=" + bookAvailabilityStatus + "]";
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        validateBookId(bookId);
        this.bookId = bookId;
        bookIds.add(bookId);
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        validateNonEmpty(bookTitle, "Book title cannot be empty.");
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        validateNonEmpty(bookAuthor, "Book author cannot be empty.");
        this.bookAuthor = bookAuthor;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public String getBookAvailabilityStatus() {
        return bookAvailabilityStatus;
    }

    public void setBookAvailabilityStatus(String bookAvailabilityStatus) {
        validateAvailabilityStatus(bookAvailabilityStatus);
        this.bookAvailabilityStatus = bookAvailabilityStatus;
    }

    // Validation methods
    private void validateBookId(String bookId) {
        if (bookId == null || bookId.isEmpty()) {
            throw new IllegalArgumentException("Book ID cannot be null or empty.");
        }
        if (bookIds.contains(bookId)) {
            throw new IllegalArgumentException("Book ID must be unique. Duplicate ID found: " + bookId);
        }
    }

    private void validateNonEmpty(String value, String errorMessage) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void validateAvailabilityStatus(String status) {
        if (!"Available".equalsIgnoreCase(status) && !"Checked Out".equalsIgnoreCase(status)) {
            throw new IllegalArgumentException("Availability status must be either 'Available' or 'Checked Out'.");
        }
    }
}
