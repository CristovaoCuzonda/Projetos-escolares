/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades.Consulta.model;

import ConexaoBD.Conexaobd;
import Entidades.Consulta.controller.ConsultaC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ConsultaBD {

    Connection connect;
    PreparedStatement pstm;
    ResultSet rs;

    // Agendar uma nova consulta
    public void agendarConsulta(ConsultaC cs) {
        connect = new Conexaobd().ConexaoBd();
        try {
            String sql = "INSERT INTO consulta (bi_paciente, cod_funcionario, data_consulta, hora_consulta, estado, situacao) VALUES (?, ?, ?, ?, ?, ?)";
            pstm = connect.prepareStatement(sql);
            pstm.setString(1, cs.getBiPaciente());
            pstm.setString(2, cs.getCodFuncionario());
            pstm.setDate(3, cs.getDataConsulta());
            pstm.setTime(4, cs.getHoraConsulta());

            pstm.setString(5, cs.getEstado());
            pstm.setString(6, cs.getSituacao());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Consulta agendada com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao agendar consulta: " + e.getMessage());
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

    // Remarcar uma consulta existente
    public void remarcarConsulta(ConsultaC cs) {
        connect = new Conexaobd().ConexaoBd();
        try {
            String sql = "UPDATE consulta SET data_consulta = ?, hora_consulta = ? WHERE id_consulta = ?";
            pstm = connect.prepareStatement(sql);
            pstm.setDate(1, cs.getDataConsulta());
            pstm.setTime(2, cs.getHoraConsulta());

            pstm.setInt(3, cs.getId_consulta());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Consulta remarcada com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao remarcar consulta: " + e.getMessage());
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

    // Listar todas as consultas
    public List<ConsultaC> listarConsultas() {
        connect = new Conexaobd().ConexaoBd();
        List<ConsultaC> consultas = new ArrayList<>();
        try {
            String sql = "select  consulta.estado, consulta.cod_funcionario, consulta.data_consulta ,consulta.bi_paciente, consulta.id_consulta from consulta";
            pstm = connect.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ConsultaC cs = new ConsultaC();
                cs.setId_consulta(rs.getInt("id_consulta"));
                cs.setCodFuncionario(rs.getString("consulta.cod_funcionario"));
                cs.setBiPaciente(rs.getString("bi_paciente"));

                cs.setDataConsulta(rs.getDate("data_consulta"));
                //cs.setHoraConsulta(rs.getTime("hora_consulta"));
                cs.setEstado(rs.getString("estado"));
                //cs.setSituacao(rs.getString("situacao"));

                consultas.add(cs);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar consultas: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
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
        return consultas;
    }

    // Excluir uma consulta existente
    public void excluirConsulta(int idConsulta) {
        connect = new Conexaobd().ConexaoBd();
        try {
            String sql = "DELETE FROM consulta WHERE id_consulta = ?";
            pstm = connect.prepareStatement(sql);
            pstm.setInt(1, idConsulta);
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Consulta excluída com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir consulta: " + e.getMessage());
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
