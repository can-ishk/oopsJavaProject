package com.kanishk.csd213;
import java.sql.*;
//@Author KanishkChathley
public class Database{
    //OPTIONS: File Handling(HASHMAP) or Database;
    private static final String username="root";
    private static final String password="alohomora";
    private static final String url ="jdbc:mysql://localhost:3306/CSD213";
    private static java.sql.Connection conn = null;

    private static Integer CovidNormsLimit = 20;

    Database(){
        connectToDB();
    }
    private static void connectToDB() {
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("connected!");
        } catch (Exception e) {
        }
    }
        int countQuery(Slot slot) throws SQLException {
            connectToDB();
            Statement stm = conn.createStatement();
            String query = "SELECT COUNT(slot) from slots WHERE slot='"+ slot.getID() + "';";
            ResultSet res = stm.executeQuery(query);
            res.next();
            System.out.println(res.getString(1));
            return res.getInt(1);
        }
        Boolean Insert (Slot slot, String snuId) throws SQLException {
            if(countQuery(slot)>=CovidNormsLimit) return false;
            Statement stm = conn.createStatement();
            System.out.println(countQuery(slot));
            String query = "INSERT INTO slots VALUES(" + slot.getID() + ", '" + snuId + "');";
            stm.executeUpdate(query);
            return true;
        }

        void Delete(int id, String snuId) throws SQLException {
            connectToDB();
            Statement stm = conn.createStatement();
            String query = "DELETE FROM slots WHERE slot=" + id + " AND snuid='" + snuId + "';";
            stm.executeUpdate(query);
        }

}