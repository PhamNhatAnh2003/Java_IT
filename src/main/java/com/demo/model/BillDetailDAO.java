package com.demo.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDetailDAO {
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/anhpham";
        String username = "root";
        String password = "123456";
        return DriverManager.getConnection(url, username, password);
    }

    public List<BillDetail> getAllBillDetails() {
        List<BillDetail> billDetails = new ArrayList<>();
        String sql = "SELECT * FROM bill_detail";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                BillDetail billDetail = new BillDetail(
                        rs.getString("bid"),
                        rs.getString("mid"),
                        rs.getInt("quantity"),
                        rs.getString("unit"),
                        rs.getString("delivery")
                );
                billDetails.add(billDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billDetails;
    }

    public void addBillDetail(BillDetail billDetail) {
        String sql = "INSERT INTO bill_detail (bid, mid, quantity, unit, delivery) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, billDetail.getBid());
            pstmt.setString(2, billDetail.getMid());
            pstmt.setInt(3, billDetail.getQuantity());
            pstmt.setString(4, billDetail.getUnit());
            pstmt.setString(5, billDetail.getDelivery());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
