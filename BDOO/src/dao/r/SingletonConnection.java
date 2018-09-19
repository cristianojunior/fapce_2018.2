package dao.r;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {

	private Connection connection;
	
	public static final String ESQUEMA = "bdoo_2016110248";

	private static final String URL = "jdbc:postgresql://labsql.fapce.edu.br:3024/fap_2018_2";
	private static final String USUARIO = "bdoo_2016110248";
	private static final String SENHA = "sonic1996";	
//	private static final String URL = System.getenv("URL");
//	private static final String USUARIO = System.getenv("USUARIO");
//	private static final String SENHA = System.getenv("SENHA");
	
	private static SingletonConnection singletonConnection;
	
	private SingletonConnection() {
		System.out.println("BDR: SingletonConnection()");
		System.out.println("Variável do sistema: " + System.getenv("TESTE_VAR_SISTEMA"));
		try {
			connection = DriverManager.getConnection(URL, USUARIO, SENHA); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SingletonConnection getSingletonConnection() {
		System.out.println("BDR: getConnection()");
		if ( singletonConnection == null ) {
			singletonConnection = new SingletonConnection();
		}
		
		return singletonConnection;		
	}
	
	public Connection getConnection() {
		return connection;
	}

}
