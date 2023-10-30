/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Book;
import entity.Payment;
import entity.PaymentDetail;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class DAOPayment extends DBContext {

    public Payment addPayment(Payment p) {
        String sql = "Insert into Payment(userID, dateCreate, totalPayment, address, phoneNumber, status) "
                + "Values(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            pre.setString(1, p.getUserId());
            pre.setDate(2, Date.valueOf(LocalDate.now()));
            pre.setFloat(3, p.getTotalPayment());
            pre.setString(4, p.getAddress());
            pre.setString(5, p.getPhoneNumber());
            pre.setInt(6, p.getStatus());
            int row = pre.executeUpdate();
            if (row > 0) {
                return p;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public PaymentDetail addPaymentDetail(PaymentDetail pd) {
        String sql = "Insert into PaymentDetail(paymentId, bookId, quantity, subTotal) "
                + "Values(?, ?, ?, ?)";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            pre.setInt(1, pd.getPaymentId());
            pre.setString(2, pd.getBook().getAuthor());
            pre.setInt(3, pd.getQuantity());
            pre.setFloat(4, pd.getSubTotal());
            int row = pre.executeUpdate();
            if (row > 0) {
                return pd;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public int getPaymentById(Payment p) {
        String sql = "select paymentId from Payment where userID=? and dateCreate=? and totalPayment=?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            pre.setString(1, p.getUserId());
            pre.setDate(2, p.getDateCreate());
            pre.setFloat(3, p.getTotalPayment());
            while (res.next()) {
                int paymentId = res.getInt("paymentId");
                return paymentId;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return 0;
    }

    public ArrayList<Payment> getPaymentByUserId(String userId) {
        ArrayList<Payment> list = new ArrayList<>();
        String sql = "select * from Payment where userID=?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, userId);
            ResultSet res = pre.executeQuery();
            while (res.next()) {
                Payment p = new Payment(res.getInt(1), res.getDate(3), res.getFloat(4),
                        res.getString(2), res.getString(5), res.getString(6), res.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    public ArrayList<PaymentDetail> getPaymentDetailByPaymentId(int paymentId) {
        ArrayList<PaymentDetail> list = new ArrayList<>();
        String sql = "select * from PaymentDetail where paymentId=?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, paymentId);
            ResultSet res = pre.executeQuery();
            DAOBook db = new DAOBook();
            while (res.next()) {
                Book book = db.getBookById(res.getString("bookId"));
                PaymentDetail pd = new PaymentDetail(paymentId, book,
                        res.getInt("quantity"), res.getFloat("subTotal"));
                list.add(pd);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    public ArrayList<Payment> getAllPayment() {
        ArrayList<Payment> list = new ArrayList<>();
        String sql = "select * from Payment";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            while (res.next()) {
                Payment p = new Payment(res.getInt(1), res.getDate(3), res.getFloat(4),
                        res.getString(2), res.getString(5), res.getString(6), res.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    public PaymentDetail checkBook(String bookId) {
        String sql = "select * from PaymentDetail where bookId=?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, bookId);
            ResultSet res = pre.executeQuery();
            while (res.next()) {
                DAOBook db = new DAOBook();
                Book book = db.getBookById(bookId);
                PaymentDetail pd = new PaymentDetail(res.getInt("paymentId"), book,
                        res.getInt("quantity"), res.getFloat("subTotal"));
                return pd;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

}
