/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ASUS
 */
public class PaymentDetail {

    private int paymentId;
    private Book book;
    private int quantity;
    private float subTotal;

    public PaymentDetail() {
    }

    public PaymentDetail(int paymentId, Book book, int quantity, float subTotal) {
        this.paymentId = paymentId;
        this.book = book;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "PaymentDetail{" + "paymentId=" + paymentId + ", book=" + book + ", quantity=" + quantity + ", subTotal=" + subTotal + '}';
    }

}
