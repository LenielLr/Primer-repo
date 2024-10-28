package GeneradorNumeros;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneradorNumeros extends JFrame {

    private JSpinner contador1;
    private JSpinner contador2;
    private JTextField numeroGenerado;
    private JButton botonGenerar;

    public GeneradorNumeros() {
        initComponents();
    }

    private void initComponents() {
       
        JLabel label1 = new JLabel("Número 1");
        JLabel label2 = new JLabel("Número 2");
        JLabel label3 = new JLabel("Número Generado");

        contador1 = new JSpinner(new SpinnerNumberModel(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 1));
        contador2 = new JSpinner(new SpinnerNumberModel(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 1));

        numeroGenerado = new JTextField();
        numeroGenerado.setEditable(false); 

        botonGenerar = new JButton("Generar");

        botonGenerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarNumeroAleatorio();
            }
        });

        setLayout(null);

        label1.setBounds(20, 20, 100, 25);
        contador1.setBounds(130, 20, 100, 25);

        label2.setBounds(20, 60, 100, 25);
        contador2.setBounds(130, 60, 100, 25);

        label3.setBounds(20, 100, 100, 25);
        numeroGenerado.setBounds(130, 100, 100, 25);

        botonGenerar.setBounds(80, 140, 100, 30);

        add(label1);
        add(contador1);
        add(label2);
        add(contador2);
        add(label3);
        add(numeroGenerado);
        add(botonGenerar);

        setTitle("Generador de Números Aleatorios");
        setSize(280, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  
    }

    private void generarNumeroAleatorio() {
        int num1 = (int) contador1.getValue();
        int num2 = (int) contador2.getValue();

        int min = Math.min(num1, num2);
        int max = Math.max(num1, num2);

        int numeroAleatorio = min + (int) (Math.random() * ((max - min) + 1));
        numeroGenerado.setText(String.valueOf(numeroAleatorio));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GeneradorNumeros().setVisible(true);
        });
    }
}
