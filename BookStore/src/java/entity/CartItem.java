/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ASUS
 */
public class CartItem {

    private Book book;
    private int quatity;

    public CartItem() {
    }

    public CartItem(Book book, int quatity) {
        this.book = book;
        this.quatity = quatity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuatity() {
        return quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    @Override
    public String toString() {
        return "CartItem{" + "book=" + book + ", quatity=" + quatity + '}';
    }

}
