/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades.Admin.view;

/**
 *
 * @author hp elitebook
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTimeDisplay extends JFrame {
    private JLabel timeLabel;
    private Timer timer;

    public CurrentTimeDisplay() {
        setTitle("Hora Atual");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setLocationRelativeTo(null);

        // Label para exibir o tempo
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        updateTime();

        // Timer para atualizar a hora a cada segundo
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTime();
            }
        });
        timer.start();

        // Layout da janela
        setLayout(new BorderLayout());
        add(timeLabel, BorderLayout.CENTER);
    }

    private void updateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        String timeStr = sdf.format(now);
        timeLabel.setText(timeStr);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CurrentTimeDisplay timeDisplay = new CurrentTimeDisplay();
                timeDisplay.setVisible(true);
            }
        });
    }
}
