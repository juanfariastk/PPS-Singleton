package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.DBConnect;

public class FuncionarioDAO implements DAO<Funcionario> {
    private final Connection connection;

    public FuncionarioDAO() throws SQLException {
        this.connection = DBConnect.getInstance().getConnection();
    }

    @Override
    public void save(Funcionario funcionario) {
        try {
            String query = "INSERT INTO funcionario (nome, endereco) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getEndereco());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Funcionario funcionario, String[] params) {
       
    }

    @Override
    public void delete(Funcionario funcionario) {
        
    }

    @Override
    public List<Funcionario> getAll() {
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            String query = "SELECT * FROM funcionario";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }

    @Override
    public Funcionario get(int id) {
        Funcionario funcionario = null;
        try {
            String query = "SELECT * FROM funcionario WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEndereco(rs.getString("endereco"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionario;
    }
}

