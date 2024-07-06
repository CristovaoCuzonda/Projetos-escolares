/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades.Admin.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OverlayExample extends JFrame {
    private final JButton openDialogButton;
    private JDialog overlayDialog;

    public OverlayExample() {
        setTitle("Exemplo de Sobreposição de JDialog");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Botão para abrir o JDialog sobreposto
        openDialogButton = new JButton("Abrir JDialog");
        openDialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (overlayDialog == null) {
                    // Cria o JDialog apenas uma vez
                    overlayDialog = new JDialog(OverlayExample.this, "Janela Sobreposta", true);
                    overlayDialog.setSize(200, 100);
                    overlayDialog.setLocationRelativeTo(OverlayExample.this); // Centraliza em relação à janela principal

                    // Botão dentro do JDialog para fechá-lo
                    JButton closeButton = new JButton("Fechar");
                    closeButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            overlayDialog.dispose(); // Fecha o JDialog
                            overlayDialog = null; // Define como null para poder recriá-lo
                        }
                    });

                    overlayDialog.setLayout(new FlowLayout());
                    overlayDialog.add(new JLabel("JDialog Sobreposto"));
                    overlayDialog.add(closeButton);
                }

                overlayDialog.setVisible(true); // Mostra o JDialog sobreposto
            }
        });

        // Adiciona o botão à janela principal
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        add(openDialogButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                OverlayExample overlayExample = new OverlayExample();
                overlayExample.setVisible(true);
            }
        });
    }
}
