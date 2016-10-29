package projeto.lsi.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConexaoFactory {
	
	
	private static ResourceBundle config;

	private static ConexaoFactory con;
	
	private ConexaoFactory() {
		config = ResourceBundle.getBundle("config");
	}
	
	public static ConexaoFactory getInstance() {
		if (con == null) {
			con = new ConexaoFactory();
		}
		return con;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(config.getString("projeto.lsi.postgresql"));
		return DriverManager.getConnection(config.getString("projeto.lsi.url.conexao.bd"), 
				config.getString("projeto.lsi.usuario.bd"), config.getString("projeto.lsi.senha.bd"));
	}

	
	
	
	
	
	

}
