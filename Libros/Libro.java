package Libros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Libro {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Libros");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Crear panel de fondo con el color azul especificado
        JPanel panelFondo = new JPanel();
        panelFondo.setBackground(new Color(115, 251, 253));
        panelFondo.setLayout(null);

        // Crear panel principal con fondo blanco y bordes
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.WHITE);
        panelPrincipal.setBounds(25, 20, 330, 220);
        panelFondo.add(panelPrincipal);

        // Título
        JLabel labelTitulo = new JLabel("Libros");
        labelTitulo.setBounds(140, 10, 100, 25);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        panelPrincipal.add(labelTitulo);

        // Ingrese el nombre del libro
        JLabel labelNombre = new JLabel("Ingrese el nombre del libro:");
        labelNombre.setBounds(20, 50, 200, 25);
        panelPrincipal.add(labelNombre);

        JTextField textNombre = new JTextField();
        textNombre.setBounds(180, 50, 130, 25);
        panelPrincipal.add(textNombre);

        // Tipo de libro
        JLabel labelTipo = new JLabel("Tipo de libro:");
        labelTipo.setBounds(20, 80, 100, 25);
        panelPrincipal.add(labelTipo);

        JCheckBox checkOriginal = new JCheckBox("Original");
        checkOriginal.setBounds(180, 80, 100, 25);
        checkOriginal.setBackground(Color.WHITE);
        panelPrincipal.add(checkOriginal);

        JCheckBox checkFotocopia = new JCheckBox("Fotocopia");
        checkFotocopia.setBounds(180, 110, 100, 25);
        checkFotocopia.setBackground(Color.WHITE);
        panelPrincipal.add(checkFotocopia);

        // Libros originales
        JLabel labelLibrosOriginales = new JLabel("Libros originales:");
        labelLibrosOriginales.setBounds(20, 140, 150, 25);
        panelPrincipal.add(labelLibrosOriginales);

        JComboBox<String> comboLibrosOriginales = new JComboBox<>();
        comboLibrosOriginales.setBounds(180, 140, 130, 25);
        panelPrincipal.add(comboLibrosOriginales);

        // Libros copia
        JLabel labelLibrosCopia = new JLabel("Libros copia:");
        labelLibrosCopia.setBounds(20, 170, 150, 25);
        panelPrincipal.add(labelLibrosCopia);

        JComboBox<String> comboLibrosCopia = new JComboBox<>();
        comboLibrosCopia.setBounds(180, 170, 130, 25);
        panelPrincipal.add(comboLibrosCopia);

        // Botón Guardar
        JButton buttonGuardar = new JButton("Guardar");
        buttonGuardar.setBounds(120, 200, 80, 25);
        panelPrincipal.add(buttonGuardar);

        // Acción del botón Guardar
        buttonGuardar.addActionListener(new ActionListener() {
        
            public void actionPerformed(ActionEvent e) {
                String titulo = textNombre.getText().trim();

                if (titulo.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor ingrese el nombre del libro.");
                    return;
                }

                if (checkOriginal.isSelected() && checkFotocopia.isSelected()) {
                    JOptionPane.showMessageDialog(frame, "Seleccione solo un tipo: Original o Fotocopia.");
                    return;
                }

                if (checkOriginal.isSelected()) {
                    comboLibrosOriginales.addItem(titulo);
                } else if (checkFotocopia.isSelected()) {
                    comboLibrosCopia.addItem(titulo);
                } else {
                    JOptionPane.showMessageDialog(frame, "Seleccione si el libro es Original o Fotocopia.");
                }

                // Limpiar los campos
                textNombre.setText("");
                checkOriginal.setSelected(false);
                checkFotocopia.setSelected(false);
            }
        });

        // Asegura que solo se pueda seleccionar uno de los dos checkboxes
        checkOriginal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkOriginal.isSelected()) {
                    checkFotocopia.setSelected(false);
                }
            }
        });

        checkFotocopia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkFotocopia.isSelected()) {
                    checkOriginal.setSelected(false);
                }
            }
        });

        frame.add(panelFondo);
        frame.setVisible(true);
    }
}
