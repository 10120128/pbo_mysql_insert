package com.bagas.Controllers;

import com.bagas.Models.MataKuliah;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MataKuliahRepository {
    Connection connection;

    public MataKuliahRepository(Connection connection) {
        this.connection = connection;
    }

    public void insert(MataKuliah mataKuliah) throws SQLException {
        final String sql = "INSERT INTO t_mata_kuliah (kd_mk, nama_mk) VALUES (?, ?)";

        PreparedStatement pStatement = connection.prepareStatement(sql);
        pStatement.setString(1, mataKuliah.getKode());
        pStatement.setString(2, mataKuliah.getNama());

        int res = pStatement.executeUpdate();
        if (res > 0) {
            System.out.println("Penambahan data berhasil");
        }else {
            System.out.println("Penambahan data gagal");
        }

        pStatement.close();

    }
}
