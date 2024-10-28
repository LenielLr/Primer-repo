package MiniEncuesta;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiniEncuesta extends JFrame {

    private JPanel jPanel1;
    private JPanel jPanel2;
    private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5;
    private JRadioButton jRadioButton1, jRadioButton2, jRadioButton3;
    private JCheckBox jCheckBox1, jCheckBox2, jCheckBox3;
    private JSlider jSlider1;
    private JButton jButton1;
    private ButtonGroup buttonGroup1;

    public MiniEncuesta() {
        initComponents();
        setTitle("Mini Encuesta");
        setSize(300, 400); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initComponents() {
        buttonGroup1 = new ButtonGroup();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jLabel1 = new JLabel("Elije un sistema operativo");
        jLabel2 = new JLabel("Elige tu especialidad");
        jLabel3 = new JLabel("Horas dedicadas al ordenador");
        jLabel4 = new JLabel("Mini Encuesta");
        jLabel5 = new JLabel("0"); 

        jRadioButton1 = new JRadioButton("Windows");
        jRadioButton2 = new JRadioButton("Linux");
        jRadioButton3 = new JRadioButton("Mac");

        jCheckBox1 = new JCheckBox("Programacion");
        jCheckBox2 = new JCheckBox("Diseño grafico");
        jCheckBox3 = new JCheckBox("Administracion");

        jSlider1 = new JSlider(0, 10, 0); 
        jSlider1.setMajorTickSpacing(1);
        jSlider1.setPaintTicks(true);

        jSlider1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int value = jSlider1.getValue();
                jLabel5.setText(String.valueOf(value)); 
            }
        });

        jButton1 = new JButton("Generar");

        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sistemaOperativo = "";
                if (jRadioButton1.isSelected()) {
                    sistemaOperativo = "Windows";
                } else if (jRadioButton2.isSelected()) {
                    sistemaOperativo = "Linux";
                } else if (jRadioButton3.isSelected()) {
                    sistemaOperativo = "Mac";
                }

                String especialidad = "";
                if (jCheckBox1.isSelected()) {
                    especialidad += "Programación ";
                }
                if (jCheckBox2.isSelected()) {
                    especialidad += "Diseño gráfico ";
                }
                if (jCheckBox3.isSelected()) {
                    especialidad += "Administración ";
                }

                int horas = jSlider1.getValue();

                String mensaje = "Sistema Operativo: " + sistemaOperativo + "\n"
                               + "Especialidad: " + especialidad + "\n"
                               + "Horas dedicadas al ordenador: " + horas;

                JOptionPane.showMessageDialog(null, mensaje);
            }
        });

        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton3);

        jPanel1.setLayout(null); 
        jPanel1.setBackground(new java.awt.Color(255, 204, 0));

        jLabel4.setBounds(100, 10, 100, 20);
        jPanel1.add(jLabel4);

        jPanel2.setBounds(30, 40, 220, 300);
        jPanel2.setLayout(null);
        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setBounds(10, 10, 200, 20);
        jRadioButton1.setBounds(10, 30, 100, 20);
        jRadioButton2.setBounds(10, 50, 100, 20);
        jRadioButton3.setBounds(10, 70, 100, 20);

        jLabel2.setBounds(10, 100, 200, 20);
        jCheckBox1.setBounds(10, 120, 150, 20);
        jCheckBox2.setBounds(10, 140, 150, 20);
        jCheckBox3.setBounds(10, 160, 150, 20);

        jLabel3.setBounds(10, 190, 200, 20);
        jLabel5.setBounds(10, 210, 20, 20);
        jSlider1.setBounds(40, 210, 150, 40); 

        jButton1.setBounds(60, 260, 100, 30);

        jPanel2.add(jLabel1);
        jPanel2.add(jRadioButton1);
        jPanel2.add(jRadioButton2);
        jPanel2.add(jRadioButton3);
        jPanel2.add(jLabel2);
        jPanel2.add(jCheckBox1);
        jPanel2.add(jCheckBox2);
        jPanel2.add(jCheckBox3);
        jPanel2.add(jLabel3);
        jPanel2.add(jLabel5);
        jPanel2.add(jSlider1);
        jPanel2.add(jButton1);

        // Añadir paneles a la ventana
        jPanel1.add(jPanel2);
        add(jPanel1);
    }

    //Estoy pensando seriamente en meterme pa multimedia🥲
    public static void main(String[] args) {
        new MiniEncuesta();
    }
}
