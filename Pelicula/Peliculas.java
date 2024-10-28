package Pelicula;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Peliculas extends JFrame {

    private JTextField ingresaPelicula;
    private JComboBox<String> peliLis;
    private JButton boton;

    public Peliculas() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Peliculas");
        pack();
    }

    private void initComponents() {
        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JLabel jLabel1 = new JLabel("Escribe el título de una película");
        JLabel jLabel2 = new JLabel("Peliculas");
        ingresaPelicula = new JTextField(15);
        peliLis = new JComboBox<>();
        boton = new JButton("Añadir");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Configuración de jPanel1
        jPanel1.setBackground(new java.awt.Color(255, 204, 0));
        jPanel1.setLayout(new BorderLayout());

        // Configuración de jPanel2
        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        // este es el layout del jPanel2
        GroupLayout layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(ingresaPelicula)
                                .addComponent(boton))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(peliLis)));

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(ingresaPelicula)
                                .addComponent(peliLis))
                        .addComponent(boton));

        // Añadir jPanel2 a jPanel1
        jPanel1.add(jPanel2, BorderLayout.CENTER);

        // Configuración del layout principal
        getContentPane().add(jPanel1);

        // Acción del botón "Añadir"
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pelicula = ingresaPelicula.getText().trim();
                if (!pelicula.isEmpty()) {
                    peliLis.addItem(pelicula);
                    ingresaPelicula.setText("");
                }
            }
        });

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Peliculas().setVisible(true);
        });
    }
}
