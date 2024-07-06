/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades.Medico.controller;

import ConexaoBD.Conexaobd;
import Entidades.Consulta.controller.ConsultaC;
import Entidades.Funcionario.controller.FuncionarioC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.Timer;

/**
 *
 * @author hp elitebook
 */
public class MedicoC extends FuncionarioC {

    private int codMedico;
    private Timer hora_de_entrada;
    private Timer hora_de_saida;
    private String especialidade;

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    /**
     * @return the codMedico
     */
    public int getCodMedico() {
        return codMedico;
    }

    /**
     * @param codMedico the codMedico to set
     */
    public void setCodMedico(int codMedico) {
        this.codMedico = codMedico;
    }

    /**
     * @return the hora_de_entrada
     */
    public Timer getHora_de_entrada() {
        return hora_de_entrada;
    }

    /**
     * @param hora_de_entrada the hora_de_entrada to set
     */
    public void setHora_de_entrada(Timer hora_de_entrada) {
        this.hora_de_entrada = hora_de_entrada;
    }

    /**
     * @return the hora_de_saida
     */
    public Timer getHora_de_saida() {
        return hora_de_saida;
    }

    /**
     * @param hora_de_saida the hora_de_saida to set
     */
    public void setHora_de_saida(Timer hora_de_saida) {
        this.hora_de_saida = hora_de_saida;
    }

}
