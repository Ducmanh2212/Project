/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ASUS
 */
public class Account {
    private String userId;
    private String password;
    private String fullname;
    private int role;

    public Account() {
    }

    public Account(String userId, String password, String fullname, int role) {
        this.userId = userId;
        this.password = password;
        this.fullname = fullname;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" + "userId=" + userId + ", password=" + password + ", fullname=" + fullname + ", role=" + role + '}';
    }
    
    
}
