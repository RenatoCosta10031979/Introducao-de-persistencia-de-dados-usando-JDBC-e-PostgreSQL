package padraoDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaoJdbc.SingleConnection;
import model.DadosPessoas;

public class PersistenciaDeDadosSql {

	private Connection connection;

	// Métdo constructor que retonar a requisão de conexão.
	public PersistenciaDeDadosSql() {

		connection = SingleConnection.getConnection();
	}
	// --------------------MÉTODO INSERIR REGISTRO NA TABELA
	// ------------------------//

	// Método inserts insere os dados na tabela dadospessoais
	public void inserirRegistros(DadosPessoas dadosPessoas) {

		try {

			// Comando sql para inserir registros na tabela dadospessoais.
			String sql = "insert into dadospessoais (id, nome, cpf, email) values (?, ?, ?, ?)";

			// Interface que utilizada para executar instruções sql.
			// Quando o PreparedStatement é criado, a consulta sql é passada como um
			// parâmetro.
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setLong(1, 4);
			insert.setString(2, "Lívia Heloisa Laís Ribeiro");
			insert.setString(3, "238.134.986-38");
			insert.setString(4, "livia-ribeiro74@bakerhughes.com");
			insert.execute();
			connection.commit(); // salva o registro no banco de dados após persistir dados com sql.

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	// -------MÉTODO CONSULTAR (SELECT), TODOS OS REGISTRO DA TABELA (RETORNA UMA
	// LISTA)------//

	public List<DadosPessoas> consultarRegistros() throws Exception {
		List<DadosPessoas> listaDeRegistros = new ArrayList<DadosPessoas>();
		// Comando sql para consultar os regitros da tabela dadospessoais.
		String sql = "select * from dadospessoais";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		// O método while execute ler exibe a tabela enquanto houver registros
		// cadastrados na
		// tabela dadospessoais
		while (resultado.next()) {
			DadosPessoas dadosPessoas = new DadosPessoas();
			dadosPessoas.setId(resultado.getLong("id"));
			dadosPessoas.setNome(resultado.getString("nome"));
			dadosPessoas.setCpf(resultado.getString("cpf"));
			dadosPessoas.setEmail(resultado.getString("email"));

			listaDeRegistros.add(dadosPessoas);
		}

		return listaDeRegistros;
	}

	// -------MÉTODO CONSULTAR (SELECT), UM REGISTRO POR VEZ DA TABELA (PELA QUERY
	// ID)------//

	// Método que retorna um único registro ( pela query id), Data table caso ele
	// exista.
	public DadosPessoas retornarRegistros(Long id) throws Exception {
		DadosPessoas retornarUmRegistroDaTabela = new DadosPessoas();

		// Executa o comando sql para consultar os regitros da tabela dadospessoais.
		String sql = "select * from dadospessoais where id = " + id;

		// Recebe os comandos sql e faz os envios das informações
		PreparedStatement statement = connection.prepareStatement(sql);

		/*
		 * Percorre um data table de alguma consulta ao banco de dados. O ResultSet
		 * coloca o seu cursor na primeira linha do Data Table, e guarda o resultado de
		 * uma pesquisa numa estrutura de dados que pode ser percorrida de forma que
		 * você possa ler os dados do banco.
		 */
		ResultSet resultado = statement.executeQuery();

		/*
		 * O método while executa a leitura de um único registro da tabela. O método
		 * next(), permite que o ponteiro seja direcionado para próxima linha da tabela
		 * caso exista.
		 */
		while (resultado.next()) {

			retornarUmRegistroDaTabela.setId(resultado.getLong("id"));
			retornarUmRegistroDaTabela.setNome(resultado.getString("nome"));
			retornarUmRegistroDaTabela.setCpf(resultado.getString("cpf"));
			retornarUmRegistroDaTabela.setEmail(resultado.getString("email"));
		}
		// Retorna para o usuário o registro Data Table
		return retornarUmRegistroDaTabela;
	}

	// -------MÉTODO ALTERAR (UPDATE), OS REGISTROS DA TABELA (USANDO A QUERY
	// ID)------//

	public void alterar(DadosPessoas dadosPessoas) {

		// <<--------Executa o comando sql para atualizar o nome no registro da tabela ------>
		String sqlUpdateNome = "update dadospessoais set nome = ? where id = " + dadosPessoas.getId();

		try {
			// Recebe os comandos sql e prepara o envio das informações
			PreparedStatement statement = connection.prepareStatement(sqlUpdateNome);
			statement.setString(1, dadosPessoas.getNome());
			statement.execute();
			connection.commit(); // salva o registro no banco de dados

		} catch (Exception e) {

			try {
				// desfaz a última atualização
				connection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}

		}
		// <<--------Executa o comando sql para atualizar o cpf no registro da tabela ------>
		String sqlUpdateCpf = "update dadospessoais set cpf = ? where id = " + dadosPessoas.getId();
		// String sql ="update dadospessoais set email = ? where id = " +
		// dadosPessoas.getId();

		try {
			// Recebe os comandos sql e prepara o envio das informações
			PreparedStatement statement = connection.prepareStatement(sqlUpdateCpf);
			statement.setString(1, dadosPessoas.getCpf());
			statement.execute();
			connection.commit(); // salva o registro no banco de dados

		} catch (Exception e) {

			try {
				// desfaz a última atualização
				connection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}

		}
		// <<--------Executa o comando sql para atualizar o email no registro da tabela------>
		String sqlUpdateEmail = "update dadospessoais set email = ? where id = " + dadosPessoas.getId();

		try {
			// Recebe os comandos sql e prepara o envio das informações
			PreparedStatement statement = connection.prepareStatement(sqlUpdateEmail);
			statement.setString(1, dadosPessoas.getEmail());
			statement.execute();
			connection.commit(); // salva o registro no banco de dados

		} catch (Exception e) {

			try {
				// desfaz a última atualização
				connection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}

		}

	}
}
