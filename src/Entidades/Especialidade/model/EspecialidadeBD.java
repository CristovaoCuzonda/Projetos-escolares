/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades.Especialidade.model;

import ConexaoBD.Conexaobd;
import Entidades.Especialidade.controller.EspecialidadeC;
import Entidades.Paciente.controller.PacienteC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author hp elitebook
 */
public class EspecialidadeBD {

    Connection connect;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<EspecialidadeC> lista = new ArrayList<>();

    public void CadastrarEspecialidade(EspecialidadeC esp) {
        try {
            connect = new Conexaobd().ConexaoBd();
            String sql = "insert into especialidade (nome, descricao) values (?, ?)";
            pstm = connect.prepareStatement(sql);
            pstm.setString(1, esp.getNome());
            pstm.setString(2, esp.getDescricao());
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, " Especialidade foi cadastrado com sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na EspecialidadeBD");
        }

    }

    public ArrayList<EspecialidadeC> ListarEspecialidades() {
        try {
            String sql = "select * from especialidade";
            connect = new Conexaobd().ConexaoBd();
            pstm = connect.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                EspecialidadeC esp = new EspecialidadeC();

                esp.setIdEspecialidade(rs.getInt("id_especialidade"));
                esp.setNome(rs.getString("nome"));
                esp.setDescricao(rs.getString("descricao"));

                lista.add(esp);
            }
        } catch (Exception e) {
            System.out.println("Erro na Especialidade " + e.getMessage());
        }
        return lista;
    }
    
    public void ActualizarEspecialidade(EspecialidadeC esp){
        
          connect = new Conexaobd().ConexaoBd();
          
          try {
            
               String sqlEspecialidade = "UPDATE especialidade SET nome = ?, descricao = ? WHERE id_especialidade = ?";
               pstm = connect.prepareStatement(sqlEspecialidade);
               
               pstm.setString(1, esp.getNome());
               pstm.setString(2, esp.getDescricao());
               pstm.setInt(3, esp.getIdEspecialidade());
               pstm.executeUpdate();
                           JOptionPane.showMessageDialog(null, "Especialidade actualizada com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao actualizar Especialidade: " + e.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

     public void excluirEspecialidade(EspecialidadeC esp) {
        connect = new Conexaobd().ConexaoBd();
        try {
            String sql = "DELETE FROM especialidade WHERE id_especialidade = ?";
            pstm = connect.prepareStatement(sql);
            pstm.setInt(1, esp.getIdEspecialidade());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Especialidade excluída com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir especialidade: " + e.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
