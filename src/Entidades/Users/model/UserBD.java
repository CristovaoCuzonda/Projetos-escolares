/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades.Users.model;

import ConexaoBD.Conexaobd;
import Entidades.Especialidade.controller.EspecialidadeC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Entidades.Users.controller.User;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author hp elitebook
 */
public class UserBD {

    Connection com;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<User> lista;
    User u = new User();

    public ResultSet autenticationUser(User u) {
        com = new Conexaobd().ConexaoBd();

        try {
            String sql = "select * from login where users = ? and password = ?";

            pstm = com.prepareStatement(sql);

            pstm.setString(1, u.getUsername());
            pstm.setString(2, u.getPassword());

            ResultSet rs = pstm.executeQuery();

            return rs;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Usuario: " + erro);
            return null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuario: " + e);
            return null;
        }

    }

    public void CadastrarUsers(User u) {

        com = new Conexaobd().ConexaoBd();

        try {

            String sql = "insert into login(cod_funcionario, nivel, users, password) values(?, ?, ?, ?)";
            pstm = com.prepareStatement(sql);
            pstm.setString(3, u.getUsername());
            pstm.setString(4, u.getPassword());
            pstm.setInt(2, u.getNivel());
            pstm.setString(1, u.getCod_funcionario());
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Usuario: " + erro);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuario: " + e);

        }

    }

    public ArrayList<User> ListarUser() {
        try {
            String sql = "select * from login";
            com = new Conexaobd().ConexaoBd();
            pstm = com.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {

                u.setCod_funcionario(rs.getString("cod_funcionario"));
                u.setNivel(rs.getInt("nivel"));
                u.setUsername(rs.getString("users"));
                u.setPassword(rs.getString("password"));

                lista.add(u);
            }
        } catch (Exception e) {
            System.out.println("Erro no UserBD " + e.getMessage());
        }
        return lista;

    }

    public void ActualizarUser(User u) {

        com = new Conexaobd().ConexaoBd();
        try {
            String sqlEspecialidade = "UPDATE login SET cod_funcionario = ?, users = ?, nivel=?, password = ? WHERE id_especialidade = ?";
            pstm = com.prepareStatement(sqlEspecialidade);

            pstm.setString(1, u.getCod_funcionario());
            pstm.setString(2, u.getUsername());
            pstm.setInt(3, u.getNivel());
            pstm.setString(3, u.getPassword());
            pstm.executeUpdate();
            pstm.close();
            JOptionPane.showMessageDialog(null, "User actualizado com sucesso!");

        } catch (Exception e) {
        }
    }

    public void ExcluirUSer(User u) {
        com = new Conexaobd().ConexaoBd();
        try {
            String sql = "DELETE FROM login WHERE cod_funcionario = ?";
            pstm = com.prepareStatement(sql);
            pstm.setString(1, u.getCod_funcionario());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "User excluído com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Users: " + e.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (com != null) {
                    com.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }
}
