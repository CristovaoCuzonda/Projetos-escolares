/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades.Users.controller;

/**
 *
 * @author hp elitebook
 */
public class User {
    
    private String username, password, cod_funcionario;
    private int nivel;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * @return the cod_funcionario
     */
    public String getCod_funcionario() {
        return cod_funcionario;
    }

    /**
     * @param cod_funcionario the cod_funcionario to set
     */
    public void setCod_funcionario(String cod_funcionario) {
        this.cod_funcionario = cod_funcionario;
    }
    
}
