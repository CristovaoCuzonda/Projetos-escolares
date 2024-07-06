/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades.Medico.model;

import ConexaoBD.Conexaobd;
import Entidades.Consulta.controller.ConsultaC;
import Entidades.Medico.controller.MedicoC;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author hp elitebook
 */
public class MedicoBD {
     Connection  connect;
    PreparedStatement pstm;
    ResultSet rs;

    public List<MedicoC> listarMedicos() {
        connect = new Conexaobd().ConexaoBd();
        List<MedicoC> listaMedicos = new ArrayList<>();
        try {
            String sql = "select medico.cod_funcionario, medico.cod_medico, funcionario.nome, especialidade.nome from funcionario natural join medico natural join especialidade_medico natural join especialidade";
            pstm = connect.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                MedicoC m = new MedicoC();
                m.setCodFuncionario(rs.getString("cod_funcionario"));
                m.setNomeFuncionario(rs.getString("funcionario.nome"));
                
                

             
                

                listaMedicos.add(m);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Medico: " + e.getMessage());
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
        return listaMedicos;
    }

    public void CadastrarMedico(MedicoC m) {
         connect = new Conexaobd().ConexaoBd();
       

        try {

            String sql = "insert into login(cod_funcionario) values(?)";
            pstm = connect.prepareStatement(sql);
            pstm.setString(1,m.getCodFuncionario());
            
            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Usuario: " + erro);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuario: " + e);

        }

    }

     
    
    }
      
      
    
