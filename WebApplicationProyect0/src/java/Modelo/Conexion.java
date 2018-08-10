/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class Conexion {

	 static String URL = "jdbc:mysql://localhost:3306/";
	 static String USER = "root";
	 static String PASSWORD = "";

	    public static Connection conectarBD  (String dataBase) throws Exception{
                Connection conexion;
	        	String urlNueva=URL+dataBase;
					Class.forName("com.mysql.jdbc.Driver");
                    conexion = DriverManager.getConnection(urlNueva, USER,PASSWORD);
                    
	        return conexion;
	    }   
}
