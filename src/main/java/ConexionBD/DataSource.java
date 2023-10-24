/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Pamonte
 */
public class DataSource {

    private Connection conexion = null;
    private int status = 0;

    private String host = "";
    private String user = "";
    private String pass = "";
    private String bd = "";
    private String bd_def = "";

    public DataSource() throws ClassNotFoundException, SQLException {
        try {
            recogerBaseFichero();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion = DriverManager.getConnection(bd_def, user, pass);
        } catch (SQLException ex) {
            System.out.println("ORIGEN DS: " + ex);
        }
    }

    public void cerrarConexion() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }

    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        if (conexion != null) {
            return conexion.prepareStatement(sql);
        } else {
            return null;
        }
    }

    public int ejecutarInsert(PreparedStatement st) throws SQLException {
        if (conexion != null) {
            status = st.executeUpdate();
            st.close();
            return status;
        } else {
            return 0;
        }
    }

    public int ejecutarUpdate(PreparedStatement st) throws SQLException {
        if (conexion != null) {
            status = st.executeUpdate();
            st.close();
            return status;
        } else {
            return 0;
        }
    }

    public PreparedStatement recibirSelect(String sql) throws SQLException {
        if (conexion != null) {
            return conexion.prepareStatement(sql);
        } else {
            return null;
        }
    }

    private void recogerBaseFichero() {
        int cont = 0;
        String st;
        BufferedReader br = null;

        File file = new File("C:\\FrimosaBascula\\conexion.txt");

        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException ex) {
            System.out.println("Error desde DS: " + ex);
        }

        if (br != null) {
            try {
                while ((st = br.readLine()) != null) {

                    switch (cont) {
                        case 0:
                            host = st;
                            break;

                        case 1:
                            bd = st;
                            break;
                    }

                    cont++;
                }

                bd_def = "jdbc:sqlserver://" + host + ";databaseName=" + bd;
                bd_def = bd_def + ";TrustServerCertificate=True";

                user = "sa";
                //user = "logic";
                pass = "Sage2009+";
            } catch (IOException ex) {
                System.out.println("Error desde DS: " + ex);
            }
        }
    }
}
