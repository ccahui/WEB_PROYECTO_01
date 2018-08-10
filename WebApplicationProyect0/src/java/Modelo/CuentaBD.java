package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class CuentaBD implements HttpSessionBindingListener {

    Connection conexion;
    PreparedStatement datosCuenta;
    PreparedStatement datosTransacciones;

    public CuentaBD() throws Exception {

        conexion = Conexion.conectarBD("banca");
        //Saldo y Nombre 
        String consulta = "SELECT * FROM clientexCuenta WHERE num_cuenta=?";
        String consulta1 = "SELECT * FROM cuentaxtransaccion where num_cuenta=?";

        datosCuenta = conexion.prepareStatement(consulta);
        datosTransacciones = conexion.prepareStatement(consulta1);
    }

    public boolean inicioCuenta(String numCuenta, String password) {

        String consulta = "SELECT * FROM cuenta WHERE num_cuenta=? and password=?";
        Cuenta datos;
        try {
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ps.setString(1, numCuenta);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        return false;
    }

    public Cuenta datosCuenta(String numCuenta) {
        Cuenta datos = new Cuenta(numCuenta, null);
        try {
            datosCuenta.setString(1, numCuenta);
            ResultSet rs = datosCuenta.executeQuery();
            if (rs.next()) {
                datos.setPropietario(rs.getString("nombre"));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error: " + e.getMessage());
        }
        return datos;
    }

    public ResultSet cuentaTransacciones(String numCuenta) {
        ResultSet rs = null;
        try {
            datosTransacciones.setString(1, numCuenta);
            rs = datosTransacciones.executeQuery();
            return rs;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error " + null);
        }

        return null;

    }

    public String saldo(String numCuenta) {
        try {
            datosCuenta.setString(1, numCuenta);
            ResultSet rs = datosCuenta.executeQuery();
            if (rs.next()) {
                return rs.getString("saldo");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error: " + e.getMessage());
        }
        return null;

    }

    public boolean transaccion(String numCuenta, String monto, String operacion) {

        try {
            String dinero = saldo(numCuenta);
            double saldo = Double.parseDouble(dinero);
            double transaccion = Double.parseDouble(monto);
            if ("RETIRO".equals(operacion)) {
                transaccion = -transaccion;
            }

            double saldoActual = saldo + transaccion;

            if (saldoActual >= 0) {

                String insertar = "INSERT INTO transaccion (num_cuenta,operacion,monto,fecha) VALUES (?,?,?,?)";
                String modificar = "UPDATE cuenta SET SALDO=? where NUM_CUENTA=?";
                Statement line = conexion.createStatement();
                PreparedStatement line2 = conexion.prepareStatement(insertar);
                PreparedStatement line3 = conexion.prepareStatement(modificar);

                line2.setString(1, numCuenta);
                line2.setString(2, operacion);
                line2.setString(3, monto);
                line2.setString(4, new Date().toString());

                line3.setDouble(1, saldoActual);
                line3.setString(2, numCuenta);
                line.execute("BEGIN");
                line2.executeUpdate();
                line3.executeUpdate();
                line.execute("COMMIT");
                return true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("ERROR : " + e.getMessage());
        }
        return false;
    }

    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException e) {

        }
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    //Cierra la conexion con la BD cuenta sale de session o se elimina dicho atributo
    public void valueUnbound(HttpSessionBindingEvent event) {

        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(CuentaBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
