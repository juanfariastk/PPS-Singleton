import java.sql.SQLException;
import dao.Funcionario;
import dao.FuncionarioDAO;

public class MainSingleton {
    public static void main(String[] args) {
        try {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            
            /* ao criar o banco para rodar, precisa rodar o seguinte sql para criar a table de funcionário 
			    CREATE TABLE funcionario (
			    id SERIAL PRIMARY KEY,
			    nome VARCHAR(100) NOT NULL,
			    endereco VARCHAR(255) NOT NULL
				);
            */
            
            // Criação do funcionário João
            Funcionario funcionario1 = new Funcionario();
            funcionario1.setNome("João");
            funcionario1.setEndereco("Rua A, 123");
            funcionarioDAO.save(funcionario1);
            
            // criação da funcionária Maria
            Funcionario funcionario2 = new Funcionario();
            funcionario2.setNome("Maria");
            funcionario2.setEndereco("Rua B, 456");
            funcionarioDAO.save(funcionario2);
            
            // criação do funcionário Pedro
            Funcionario funcionario3 = new Funcionario();
            funcionario3.setNome("Pedro");
            funcionario3.setEndereco("Rua C, 789");
            funcionarioDAO.save(funcionario3);
            
            // criação da funcionária Ana
            Funcionario funcionario4 = new Funcionario();
            funcionario4.setNome("Ana");
            funcionario4.setEndereco("Rua D, 101");
            funcionarioDAO.save(funcionario4);

            // Listagem
            funcionarioDAO.getAll().forEach(f -> 
                System.out.println(f.getId() + ": " + f.getNome() + " - " + f.getEndereco())
            );
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
