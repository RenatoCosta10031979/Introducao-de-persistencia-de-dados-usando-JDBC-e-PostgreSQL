package padraoDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	public DadosPessoas retornarRegistros(Long id) throws Exception{
		DadosPessoas retornarUmRegistroDaTabela = new DadosPessoas();
		// Comando sql para consultar os regitros da tabela dadospessoais.
		 String sql = "select * from dadospessoais where id = " + id;
		 
		 PreparedStatement statement = connection.prepareStatement(sql);
		 ResultSet resultado = statement.executeQuery();
		 //O método while executa a leitura de um único registro  da tabela.
		 while(resultado.next()) {
			 
			 retornarUmRegistroDaTabela.setId(resultado.getLong("id"));
			 retornarUmRegistroDaTabela.setNome(resultado.getString("nome"));
			 retornarUmRegistroDaTabela.setCpf(resultado.getString("cpf"));
			 retornarUmRegistroDaTabela.setEmail(resultado.getString("email"));
		 }
		 
		 return retornarUmRegistroDaTabela;
	}	
}
