/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexaoBD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexaobd  {
    private static final String password="setembro5";
    private static final String username="root";
    private static final String url= "jdbc:mysql://localhost:3306/clinica_girassol";
    public static Connection ConexaoBd(){
        Connection connect = null;
       
        
        try{
            VerifyUsername(username);
            VerifyPassword(password);
            if (connect != null) return connect;

             connect = DriverManager.getConnection(url, username, password );
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro na classe de conexão"+erro.getMessage());
        }
        return connect;
    }
    
    private static boolean VerifyUsername(String username){
        if (username.length()>=3)
            return true;
            
       
        throw new RuntimeException("Username Invalida");
       
    }
    
        private static boolean VerifyPassword(String password){
        if (password.length()>=7)
            return true;
            
       
        throw new RuntimeException("Password Invalida");
       
    }
    
}
