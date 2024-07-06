/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades.Consulta.controller;

/**
 *
 * @author hp elitebook
 */
public class ConsultaC {

    private int id_consulta;
    private String estado, situacao;

    private String biPaciente;
    private String codFuncionario;
    private java.sql.Date dataConsulta;
    private java.sql.Time horaConsulta;
    private String especialidade;

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    

    /**
     * @return the id_consulta
     */
    public int getId_consulta() {
        return id_consulta;
    }

    /**
     * @param id_consulta the id_consulta to set
     */
    public void setId_consulta(int id_consulta) {
        this.id_consulta = id_consulta;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the biPaciente
     */
    public String getBiPaciente() {
        return biPaciente;
    }

    /**
     * @param biPaciente the biPaciente to set
     */
    public void setBiPaciente(String biPaciente) {
        this.biPaciente = biPaciente;
    }

    /**
     * @return the codFuncionario
     */
    public String getCodFuncionario() {
        return codFuncionario;
    }

    /**
     * @param codFuncionario the codFuncionario to set
     */
    public void setCodFuncionario(String codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    /**
     * @return the dataConsulta
     */
    public java.sql.Date getDataConsulta() {
        return dataConsulta;
    }

    /**
     * @param dataConsulta the dataConsulta to set
     */
    public void setDataConsulta(java.sql.Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    /**
     * @return the horaConsulta
     */
    public java.sql.Time getHoraConsulta() {
        return horaConsulta;
    }

    /**
     * @param horaConsulta the horaConsulta to set
     */
    public void setHoraConsulta(java.sql.Time horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    /**
     * @return the descricao
     */
   
    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
}
