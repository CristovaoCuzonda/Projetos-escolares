package Entidades.Paciente.model;

import java.sql.ResultSet;
import java.sql.*;
import ConexaoBD.Conexaobd;
import Entidades.Paciente.controller.PacienteC;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author hp elitebook
 */
public class PacienteBD {

    Connection connect;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<PacienteC> lista = new ArrayList<>();

    public void CadastrarPaciente(PacienteC p) {
        connect = new Conexaobd().ConexaoBd();

        try {
            String sql = "insert into paciente (id, bi_paciente, nome, nacionalidade) values (?, ?, ?, ?)";
            pstm = connect.prepareStatement(sql);
            pstm.setInt(1, p.getId());
            pstm.setString(2, p.getBi());
            pstm.setString(3, p.getNome());
            pstm.setString(4, p.getNacionalidade());
            /* pstm.setString(3, p.getEstadoCivil());
            pstm.setString(4, p.getProfissao());
             */
 /*          pstm.setDouble(6, p.getPeso());
            pstm.setDouble(7, p.getAltura());*/
            pstm.execute();
            pstm.close();
            JOptionPane.showMessageDialog(null, " Paciente foi cadastrado com sucesso");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Paciente BD em Cadastrar" + erro);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Paciente BD" + e);

        }

    }

    public ArrayList<PacienteC> ListarPacientes() {

        try {
            connect = new Conexaobd().ConexaoBd();
            String sql = "select id, bi_paciente, nome, nacionalidade from paciente";

            pstm = connect.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                PacienteC p = new PacienteC();

                p.setId(rs.getInt("id"));
                p.setBi(rs.getString("bi_paciente"));
                p.setNome(rs.getString("nome"));
                p.setNacionalidade(rs.getString("nacionalidade"));

                lista.add(p);

            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PacienteBD função ListarPaciente" + erro);
        }
        return lista;

    }
    
    
    public ArrayList ListarPacientesum(String BI) {

        try {
            connect = new Conexaobd().ConexaoBd();
            String sql = "select id, bi_paciente, nome, nacionalidade from paciente where bi_paciente ='"+BI+"'";

            pstm = connect.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                PacienteC p = new PacienteC();

                p.setId(rs.getInt("id"));
                p.setBi(rs.getString("bi_paciente"));
                p.setNome(rs.getString("nome"));
                p.setNacionalidade(rs.getString("nacionalidade"));

                lista.add(p);

            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PacienteBD função ListarPaciente" + erro);
        }
        return lista;

    }
    
    
    public ArrayList ListarPacienteso(String BI) {

        try {
            connect = new Conexaobd().ConexaoBd();
            String sql = "select id, bi_paciente, nome, nacionalidade from paciente where bi_paciente ='"+BI+"'";

            pstm = connect.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                PacienteC p = new PacienteC();

                p.setId(rs.getInt("id"));
                p.setBi(rs.getString("bi_paciente"));
                p.setNome(rs.getString("nome"));
                p.setNacionalidade(rs.getString("nacionalidade"));

                lista.add(p);

            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PacienteBD função ListarPaciente" + erro);
        }
        return lista;

    }

    
    
    


}
