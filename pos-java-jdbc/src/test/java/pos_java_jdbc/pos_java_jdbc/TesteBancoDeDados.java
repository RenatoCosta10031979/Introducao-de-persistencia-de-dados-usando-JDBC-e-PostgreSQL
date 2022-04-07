package pos_java_jdbc.pos_java_jdbc;

import java.sql.Connection;

import org.junit.Test;

import conexaoJdbc.SingleConnection;

public class TesteBancoDeDados {
	
	@Test
	public void conexaoBancoDeDados() {
		SingleConnection.getConnection();
	}
	

}
