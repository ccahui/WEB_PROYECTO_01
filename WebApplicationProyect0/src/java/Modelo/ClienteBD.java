/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteBD {
	
	Connection conexion;

	public ClienteBD() throws Exception{
		
		conexion=Conexion.conectarBD("banca");
	}
	public boolean buscarCliente(String dni){
		
		try {
			PreparedStatement consultaBuscar;
			String consultaPreparada="SELECT dni FROM cliente WHERE dni=?";
			consultaBuscar =conexion.prepareStatement(consultaPreparada);
			consultaBuscar.setString(1, dni);
			ResultSet rs=consultaBuscar.executeQuery();
			
			if(rs.next()){
				return true;
			}
			
		}
		catch (SQLException e) {
			System.out.println("Error "+e.getMessage());
		}
		return false;
	}
	public boolean insertarCliente(Cliente nuevo){
	
		try {
			PreparedStatement consultaInsertar;
			String consultaPreparada2="INSERT INTO cliente VALUES (?,?,?)";
			consultaInsertar=conexion.prepareStatement(consultaPreparada2);
			
			consultaInsertar.setString(1, nuevo.getDni());
			consultaInsertar.setString(2, nuevo.getNombre());
			consultaInsertar.setString(3, nuevo.getEmail());
			
			consultaInsertar.execute();
	
			return true;
		} catch (SQLException e) {
			System.out.println("Error "+e.getMessage());
		}
	return false;	
	}
	public int crearCuenta(String dni,String password){
		int numeroCuenta=-1;
		
		try {
			PreparedStatement consultaCrearCuenta;
			String consultaPreparada3="INSERT INTO cuenta (dni,password) VALUES (?,?)";
			consultaCrearCuenta=conexion.prepareStatement(consultaPreparada3,Statement.RETURN_GENERATED_KEYS);
			
			consultaCrearCuenta.setString(1,dni);
			consultaCrearCuenta.setString(2,password);
			consultaCrearCuenta.execute();
			/*Me devuelve las claves autoincrementadas de todas las apertura creadas por esta conexion, como va ser solo una por conexion
			 */
			ResultSet rs=consultaCrearCuenta.getGeneratedKeys();
			rs.next();
	       numeroCuenta=rs.getInt(1);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		 System.out.println("Error "+e.getMessage());
		}
		return numeroCuenta;
		
	}
	
	public void cerrarConexion() throws SQLException {
		conexion.close();
	}
	
}