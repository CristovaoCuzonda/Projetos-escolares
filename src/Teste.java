
import ConexaoBD.Conexaobd;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author hp elitebook
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Conexaobd a = new Conexaobd();
            if(a.ConexaoBd()!= null)
            System.out.println("Sucesso");
        } catch (Exception e) {
            System.out.println("Erro"+e);
        }
    }
    
}
