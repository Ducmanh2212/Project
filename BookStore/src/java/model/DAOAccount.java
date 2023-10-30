/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class DAOAccount extends DBContext {

    public Account checkLogin(String userId, String password) {
        String sql = "SELECT * FROM Account WHERE userId = ? AND password = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            pre.setString(1, userId);
            pre.setString(2, password);
            if (res.next()) {
                Account a = new Account(userId, password, res.getString("fullname"), res.getInt("roleID"));
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Account getAccountById(String userId) {
        String sql = "Select * from Account where userID=?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            pre.setString(1, userId.toUpperCase());
            while (res.next()) {
                Account a = new Account(userId,
                        res.getString("password"),
                        res.getString("fullName"),
                        res.getInt("roleID"));
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public Account signUp(Account a) {
        String sql = "insert into Account(userID, password, fullName, roleID)"
                + "Values(?, ?, ?, ?)";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            pre.setString(1, a.getUserId());
            pre.setString(2, a.getPassword());
            pre.setString(3, a.getFullname());
            pre.setInt(4, a.getRole());
            int row = pre.executeUpdate();
            if (row > 0) { //check so cot bi thay doi, neu so cot > 0 thi signup thanh cong
                return a;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public Account update(Account a) {
        String sql = "UPDATE Account SET fullName=?, password=? WHERE userID=?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet res = pre.executeQuery();
            pre.setString(1, a.getFullname());
            pre.setString(2, a.getPassword());
            pre.setString(3, a.getUserId());
            pre.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

}
