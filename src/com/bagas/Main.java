package com.bagas;

import com.bagas.Controllers.MataKuliahRepository;
import com.bagas.Models.MataKuliah;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DbConnector connector = DbConnector.getInstance();
        Connection conn = connector.getConnection();
        Scanner scanner = new Scanner(System.in);
        var matkulRepository = new MataKuliahRepository(conn);

        System.out.print("Masukan kode Mata Kuliah: ");
        var kode = scanner.nextLine();
        System.out.print("Masukan nama Mata Kuliah: ");
        var nama = scanner.nextLine();

        try {
            MataKuliah mataKuliah = new MataKuliah(kode, nama);
            matkulRepository.insert(mataKuliah);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
