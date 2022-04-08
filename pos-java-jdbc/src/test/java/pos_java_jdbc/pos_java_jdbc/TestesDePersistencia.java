package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import javax.swing.JOptionPane;

import org.junit.Test;

import conexaoJdbc.SingleConnection;
import model.DadosPessoas;
import padraoDao.PersistenciaDeDadosSql;

public class TestesDePersistencia {
	
	//Método principal onde o javac compila o arquivo.java
	public static void main(String[] args) {

		/**
		 * @author chama o método getConnection() e conecta a aplicação Java ao sql
		 */
		/*
		 * Inseri(inserts), dados (registros) na tabela dadospessoais criando os
		 * registros PersistenciaDeDadosSql persistirDadosSql = new
		 * PersistenciaDeDadosSql(); DadosPessoas dadosPessoa = new DadosPessoas();
		 * persistirDadosSql.inserirRegistros(dadosPessoa);
		 */

		// Executa o comando sql de consultar e exibir todos os registros gravados na
		// tabela dadospessoais
		PersistenciaDeDadosSql persistenciaDeDadosSqlListar = new PersistenciaDeDadosSql();
		try {

			List<DadosPessoas> ListaDeRegistros = persistenciaDeDadosSqlListar.consultarRegistros();

			for (DadosPessoas dadosPessoas : ListaDeRegistros) {
				System.out.println(dadosPessoas.toString());
				System.out.println("\n");
			}

		} catch (Exception e) {
		}
		
		
		PersistenciaDeDadosSql persistenciaDeDadosSqlUmDadoPorVez = new PersistenciaDeDadosSql();
		
		try {
			
			DadosPessoas dadosPessoasUmPorVez = persistenciaDeDadosSqlUmDadoPorVez.retornarRegistros(2L);
			System.out.println(dadosPessoasUmPorVez);
		
		} catch (Exception e) {
			
		}
	}

}
