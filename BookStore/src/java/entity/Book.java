/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ASUS
 */
public class Book {

    private String bookId;
    private String description;
    private float price;
    private String bookName;
    private String author;
    private int year;
    private int quantity;
    private String Img;
    private String categoryID;

    public Book() {
    }

    public Book(String bookId, String description, float price, String bookName, String author, int year, int quantity, String Img, String categoryID) {
        this.bookId = bookId;
        this.description = description;
        this.price = price;
        this.bookName = bookName;
        this.author = author;
        this.year = year;
        this.quantity = quantity;
        this.Img = Img;
        this.categoryID = categoryID;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String Img) {
        this.Img = Img;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    @Override
    public String toString() {
        return "Book{" + "bookId=" + bookId + ", description=" + description + ", price=" + price + ", bookName=" + bookName + ", author=" + author + ", year=" + year + ", quantity=" + quantity + ", Img=" + Img + ", categoryID=" + categoryID + '}';
    }

}
