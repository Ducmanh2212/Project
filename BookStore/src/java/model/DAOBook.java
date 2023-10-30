/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Book;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class DAOBook extends DBContext {

    public List<Book> getAllBook() {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM Book";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Book b = new Book(rs.getString("bookId"),
                        rs.getString("description"),
                        rs.getFloat("price"),
                        rs.getString("bookName"),
                        rs.getString("author"),
                        rs.getInt("year"),
                        rs.getInt("quantity"),
                        rs.getString("Img"),
                        rs.getString("categoryID"));
                list.add(b);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    public List<Book> getBookByName(String searchValue) {
        List<Book> res = new ArrayList<>();
        String sql = "SELECT * FROM Book WHERE bookName LIKE ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, "%" + searchValue + "%");
            ResultSet r = pre.executeQuery();
            while (r.next()) {
                String bookId = r.getString("bookId");
                String description = r.getString("description");
                float price = r.getFloat("price");
                String bookName = r.getString("bookName");
                String author = r.getString("author");
                int year = r.getInt("year");
                int quantity = r.getInt("quantity");
                String img = r.getString("Img");
                String categoryID = r.getString("categoryID");
                Book book = new Book(bookId, description, price, bookName, author, year, quantity, img, categoryID);
                res.add(book);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return res;
    }

    public List<Book> getBookByPrice(float p1, float p2) throws SQLException, ClassNotFoundException, Exception {
        if (p1 > p2) { //dung de getBook trong khoang gia tu p1 den p2
            float temp = p1;
            p1 = p2;
            p2 = temp;
        }

        List<Book> bookList = new ArrayList<>();
        String sql = "SELECT * FROM Book WHERE price >= ? AND price <= ?";
        try {
            if (connection != null) {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setFloat(1, p1);
                st.setFloat(2, p2);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    String bookId = rs.getString("bookId");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String bookName = rs.getString("bookName");
                    String author = rs.getString("author");
                    int year = rs.getInt("year");
                    int quantity = rs.getInt("quantity");
                    String img = rs.getString("Img");
                    String categoryID = rs.getString("categoryID");

                    Book book = new Book(bookId, description, price, bookName, author, year, quantity, img, categoryID);
                    bookList.add(book);
                }
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return bookList;
    }

    public void updateBook(Book book) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Book SET description = ?, price = ?, bookName = ?, author = ?, yearOfProduction = ?, quantity = ?, bookImgURL = ?, categoryID = ? WHERE bookId = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, book.getDescription());
            st.setFloat(2, book.getPrice());
            st.setString(3, book.getBookName());
            st.setString(4, book.getAuthor());
            st.setInt(5, book.getYear());
            st.setInt(6, book.getQuantity());
            st.setString(7, book.getImg());
            st.setString(8, book.getCategoryID());
            st.setString(9, book.getBookId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);;
        }
    }

    public void delete(String bookId) {
        String sql = "DELETE FROM [dbo].[Book] WHERE bookId=?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, bookId);
            pre.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void insert(Book book) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Book (bookId, description, price, bookName, author, yearOfProduction, quantity, bookImgURL, categoryID) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            if (connection != null) {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, book.getBookId());
                st.setString(2, book.getDescription());
                st.setFloat(3, book.getPrice());
                st.setString(4, book.getBookName());
                st.setString(5, book.getAuthor());
                st.setInt(6, book.getYear());
                st.setInt(7, book.getQuantity());
                st.setString(8, book.getImg());
                st.setString(9, book.getCategoryID());

                st.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public Book getBookById(String bookId) {
        String sql = "SELECT * FROM [dbo].[Book] WHERE bookId=?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, bookId);
            ResultSet res = pre.executeQuery();
            if (res.next()) {
                Book b = new Book(res.getString("bookId"),
                        res.getString("description"),
                        res.getFloat("price"),
                        res.getString("bookName"),
                        res.getString("author"),
                        res.getInt("year"),
                        res.getInt("quantity"),
                        res.getString("Img"),
                        res.getString("categoryID"));
                return b;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public List<Book> getBookByCId(String categoryID) {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM Book WHERE categoryID = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, categoryID);
            ResultSet res = pre.executeQuery();
            while (res.next()) {
                Book b = new Book(res.getString("bookId"),
                        res.getString("description"),
                        res.getFloat("price"),
                        res.getString("bookName"),
                        res.getString("author"),
                        res.getInt("year"),
                        res.getInt("quantity"),
                        res.getString("Img"),
                        res.getString("categoryID"));
                return list;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Book> getTop3Book(int count) throws Exception {
        List<Book> list = new ArrayList<>();
        String sql = "select * from (select ROW_NUMBER() over (order by bookId asc) as rn, * from Book) as b\n"
                + "where rn >= (?*3-2) and rn <= (?*3)";
        try {
            if (connection != null) {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setInt(1, count);
                st.setInt(2, count);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    Book book = new Book();
                    book.setBookId(rs.getString("bookId"));
                    book.setDescription(rs.getString("description"));
                    book.setPrice(rs.getFloat("price"));
                    book.setBookName(rs.getString("bookName"));
                    book.setAuthor(rs.getString("author"));
                    book.setYear(rs.getInt("yearOfProduction"));
                    book.setQuantity(rs.getInt("quantity"));
                    book.setImg(rs.getString("bookImgURL"));
                    book.setCategoryID(rs.getString("categoryID"));
                    list.add(book);
                }
            }
        } catch (SQLException e) {
            throw e;

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return list;
    }

    public int count() throws Exception {
        try {
            if (connection != null) {
                String sql = "SELECT count(*) From Book";
                PreparedStatement pre = connection.prepareStatement(sql);
                ResultSet re = pre.executeQuery();
                while (re.next()) {
                    return re.getInt(1);
                }
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        DAOBook dao = new DAOBook();
        List<Book> list = dao.getAllBook();
        for (Book o : list) {
            System.out.println(o);
        }
    }
}
