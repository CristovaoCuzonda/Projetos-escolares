package Entidades.Funcionario.model;

import ConexaoBD.Conexaobd;
import Entidades.Funcionario.controller.FuncionarioC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FuncionarioBD {
    Connection connect;
    PreparedStatement pstm;
    ResultSet rs;

    // Cadastrar um novo funcionário
    public void cadastrarFuncionarioBD(FuncionarioC f) {
        connect = new Conexaobd().ConexaoBd();
        try {
            // Iniciar a transação
            connect.setAutoCommit(false);
            
            // Inserir na tabela funcionario
            String sqlFuncionario = "INSERT INTO funcionario (nome, estado_civil, funcao, bi, cargo) VALUES (?, ?, ?, ?, ?)";
            pstm = connect.prepareStatement(sqlFuncionario, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, f.getNomeFuncionario());
            pstm.setString(2, f.getEstadoCivilFuncionario());
            pstm.setString(3, f.getFuncaoFuncionario());
            pstm.setString(4, f.getBiFuncionario());
            pstm.setString(5, f.getCargoFuncionario());
            pstm.executeUpdate();
            
            rs = pstm.getGeneratedKeys();
            String codFuncionario = "";
            if (rs.next()) {
                codFuncionario = rs.getString(1);
            }
            
           /* // Inserir na tabela contacto
            String sqlContacto = "INSERT INTO contacto (cod_funcionario, tel1, tel2, email, linkdin) VALUES (?, ?, ?, ?, ?)";
            pstm = connect.prepareStatement(sqlContacto);
            pstm.setString(1, codFuncionario);
            pstm.setString(2, f.getTel1());
            pstm.setString(3, f.getTel2());
            pstm.setString(4, f.getEmailFuncionario());
            pstm.setString(5, f.getLinkdin());
            pstm.executeUpdate();
            
            // Inserir na tabela morada
            String sqlMorada = "INSERT INTO morada (cod_funcionario, rua, bairro, municipio) VALUES (?, ?, ?, ?)";
            pstm = connect.prepareStatement(sqlMorada);
            pstm.setString(1, codFuncionario);
            pstm.setString(2, f.getRua());
            pstm.setString(3, f.getBairro());
            pstm.setString(4, f.getMunicipio());
            pstm.executeUpdate();*/
            
            // Confirmar a transação
            connect.commit();
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
        } catch (SQLException e) {
            try {
                connect.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionário: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (connect != null) connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Atualizar um funcionário existente
    public void atualizarFuncionario(FuncionarioC f) {
        connect = new Conexaobd().ConexaoBd();
        try {
            // Iniciar a transação
            connect.setAutoCommit(false);
            
            // Atualizar na tabela funcionario
            String sqlFuncionario = "UPDATE funcionario SET nome = ?, estado_civil = ?, funcao = ?, bi = ?, cargo = ? WHERE cod_funcionario = ?";
            pstm = connect.prepareStatement(sqlFuncionario);
            pstm.setString(1, f.getNomeFuncionario());
            pstm.setString(2, f.getEstadoCivilFuncionario());
            pstm.setString(3, f.getFuncaoFuncionario());
            pstm.setString(4, f.getBiFuncionario());
            pstm.setString(5, f.getCargoFuncionario());
            pstm.setString(6, f.getCodFuncionario());
            pstm.executeUpdate();
            
            // Atualizar na tabela contacto
            String sqlContacto = "UPDATE contacto SET tel1 = ?, tel2 = ?, email = ?, linkdin = ? WHERE cod_funcionario = ?";
            pstm = connect.prepareStatement(sqlContacto);
            pstm.setString(1, f.getTel1());
            pstm.setString(2, f.getTel2());
            pstm.setString(3, f.getEmailFuncionario());
            pstm.setString(4, f.getLinkdin());
            pstm.setString(5, f.getCodFuncionario());
            pstm.executeUpdate();
            
            // Atualizar na tabela morada
            String sqlMorada = "UPDATE morada SET rua = ?, bairro = ?, municipio = ? WHERE cod_funcionario = ?";
            pstm = connect.prepareStatement(sqlMorada);
            pstm.setString(1, f.getRua());
            pstm.setString(2, f.getBairro());
            pstm.setString(3, f.getMunicipio());
            pstm.setString(4, f.getCodFuncionario());
            pstm.executeUpdate();
            
            // Confirmar a transação
            connect.commit();
            JOptionPane.showMessageDialog(null, "Funcionário atualizado com sucesso!");
        } catch (SQLException e) {
            try {
                connect.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Erro ao atualizar funcionário: " + e.getMessage());
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (connect != null) connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Listar todos os funcionários
    public List<FuncionarioC> listarFuncionarios() {
        connect = new Conexaobd().ConexaoBd();
        List<FuncionarioC> funcionarios = new ArrayList<>();
        try {
            String sql = "SELECT f.*, c.tel1, c.tel2, c.email, c.linkdin, m.rua, m.bairro, m.municipio FROM funcionario f "
                       + "LEFT JOIN contacto c ON f.cod_funcionario = c.cod_funcionario "
                       + "LEFT JOIN morada m ON f.cod_funcionario = m.cod_funcionario";
            pstm = connect.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                FuncionarioC f = new FuncionarioC();
                f.setCodFuncionario(rs.getString("cod_funcionario"));
                f.setNomeFuncionario(rs.getString("nome"));
                f.setEstadoCivilFuncionario(rs.getString("estado_civil"));
                f.setFuncaoFuncionario(rs.getString("funcao"));
                f.setBiFuncionario(rs.getString("bi"));
                f.setCargoFuncionario(rs.getString("cargo"));
                f.setTel1(rs.getString("tel1"));
                f.setTel2(rs.getString("tel2"));
                f.setEmailFuncionario(rs.getString("email"));
                f.setLinkdin(rs.getString("linkdin"));
                f.setRua(rs.getString("rua"));
                f.setBairro(rs.getString("bairro"));
                f.setMunicipio(rs.getString("municipio"));
                funcionarios.add(f);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar funcionários: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (connect != null) connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return funcionarios;
    }

    // Excluir um funcionário existente
    public void excluirFuncionario( FuncionarioC f) {
        connect = new Conexaobd().ConexaoBd();
        try {
            // Iniciar a transação
            connect.setAutoCommit(false);
            
            // Excluir na tabela contacto
            String sqlContacto = "DELETE FROM contacto WHERE cod_funcionario = ?";
            pstm = connect.prepareStatement(sqlContacto);
            pstm.setString(1, f.getCodFuncionario());
            pstm.executeUpdate();
            
            // Excluir na tabela morada
            String sqlMorada = "DELETE FROM morada WHERE cod_funcionario = ?";
            pstm = connect.prepareStatement(sqlMorada);
            pstm.setString(1, f.getCodFuncionario());
            pstm.executeUpdate();
            
            // Excluir na tabela funcionario
            String sqlFuncionario = "DELETE FROM funcionario WHERE cod_funcionario = ?";
            pstm = connect.prepareStatement(sqlFuncionario);
              pstm.setString(1, f.getCodFuncionario());
            pstm.executeUpdate();
            
            // Confirmar a transação
            connect.commit();
            JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso!");
        } catch (SQLException e) {
            try {
                connect.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Erro ao excluir funcionário: " + e.getMessage());
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (connect != null) connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
