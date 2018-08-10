Proyecto Web I-Servlet: BANCA SIMPLE

- Desarrollado en JAVA Servlet y MySQL
- Utilizando XAMP (Tomcat) para armar tu servidor Local
- Sistema Banca Simple
	-Usuario se registra
	-Usuario realiza la apertura de una o 		
	 mas cuentas de Banca Simple
	-Usuario Inicia Session
	-Usuario realiza operaciones de
	 DEPOSITO y RETIRO
	-Usuario consulta su historial de 
	operaciones
	-Usuario cierra Session
	
- Para que funcione es necesario utilizar la librreia JDBC (mySql-conexion ) e IMPORTAR la BD  banca

- Si configuraste el XAMP de otra manera ,la BD : Deberas modificar en el packages Modelo conexion.java, con los nuevos valores

	 static String URL = "jdbc:mysql://localhost:3306/";
	 static String USER = "root";
	 static String PASSWORD = "";

- Si cambiaste de nombre a la BD ('banca') : Deberas modificar  packages Modelo ClienteBD.java y CuentaBD.java
 con el nombre de tu BD

	
	public ClienteBD() throws Exception{
		//Nombre de la BD a conectar
		conexion=Conexion.conectarBD("banca");
	}
       