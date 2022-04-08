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
		 * Inserir(inserts), dados (registros) na tabela dadospessoais criando os
		 * registros PersistenciaDeDadosSql persistirDadosSql = new
		 * PersistenciaDeDadosSql(); DadosPessoas dadosPessoa = new DadosPessoas();
		 * persistirDadosSql.inserirRegistros(dadosPessoa);
		 * 
		 */
		
		// <<---EXECUTA O MÉTODO CRIARREGISTRO() NA TABELA------->>
		 
		/*PersistenciaDeDadosSql persistenciaDeDadosSqlCriarDados = new PersistenciaDeDadosSql();
		DadosPessoas dadosPessoas = new DadosPessoas();
		
		//"Setar os atributos para criar o registro na tabela"
		//dadosPessoas.setId(5L);
		dadosPessoas.setNome("Bruno Yago Moreira");
		dadosPessoas.setCpf("Bruno Yago Moreira");
		dadosPessoas.setEmail("bruno.yago.moreira@tirel.com.br");
		persistenciaDeDadosSqlCriarDados.criarSalvarRegistros(dadosPessoas);*/
		
		// <<---EXECUTA O MÉTODO CONSULTAR  (SELECT) REGISTRO TABELA------->>
		//                 (RETORNA UMA LISTA DE REGISTROS)
		
		// Executa o comando sql de consultar e exibir todos os registros gravados na
		// tabela dadospessoais
		/*PersistenciaDeDadosSql persistenciaDeDadosSqlListar = new PersistenciaDeDadosSql();
		try {

			List<DadosPessoas> ListaDeRegistros = persistenciaDeDadosSqlListar.consultarRegistros();

			for (DadosPessoas dadosPessoas : ListaDeRegistros) {
				System.out.println(dadosPessoas.toString());
				System.out.println("\n");
			}

		} catch (Exception e) {
		}*/
		
		
		// <<------- EXECUTA O MÉTODO CONSULTAR  (SELECT) REGISTRO TABELA------->>
		//						RETORNA UM REGISTRO POR VEZ USANDO A QUERY ID
		
		/*PersistenciaDeDadosSql persistenciaDeDadosSqlUmDadoPorVez = new PersistenciaDeDadosSql();
		
		try {
			
			DadosPessoas dadosPessoasUmPorVez = persistenciaDeDadosSqlUmDadoPorVez.retornarRegistros(2L);
			System.out.println(dadosPessoasUmPorVez);
		
		} catch (Exception e) {
			
		}*/
		
		// <<------- EXECUTA O MÉTODO ATUALIZAR (UPDATE) REGISTRO TABELA------->>
		/*try {
			PersistenciaDeDadosSql persistenciaDeDadosSqlAtualizar = new PersistenciaDeDadosSql();
			
			/* Instância o objeto do tipo DadosPessoas que recebe o método retornarRegistro
			e passamos o parâmetro o id do registro da tabela para atualizar os dados de registro da tabela.*/
			/*DadosPessoas alterarRegistro = new DadosPessoas();
			
			alterarRegistro.setNome("Lavínia Gabriela Joana da Paz");
			alterarRegistro.setCpf("699.962.405-41");
			alterarRegistro.setEmail("lavinia-dapaz75@alstom.com");*/
			
			/*O objeto persistencidaDeDadosSql acessa ao metodo alterar (update) e passa o 
			o objeto consultarRegistro como parâmetro que armazena o valor do id passado pelo usuário.*/
			//persistenciaDeDadosSqlAtualizar.alterar(alterarRegistro);
			
			//JOptionPane.showMessageDialog(null, "Os dados foram atualizados");
		//} catch (Exception e) {
			//e.printStackTrace();
		//}
		
		
		// <<------- EXECUTA O MÉTODO DELETAR (DELETE) REGISTRO TABELA------->>
		
				try {
					
					PersistenciaDeDadosSql persistenciaDeDadosSqlDeletar = new PersistenciaDeDadosSql();
					persistenciaDeDadosSqlDeletar.deletar(6L);
					JOptionPane.showMessageDialog(null, "O dados foram excluídos");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
	

		
		
	}
}
