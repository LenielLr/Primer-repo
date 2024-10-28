package Imitador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Imitador extends JFrame {
    private JRadioButton originalRadio1, originalRadio2, originalRadio3;
    private JCheckBox originalCheck4, originalCheck5, originalCheck6;
    private JTextField originalTextField;
    private JComboBox<String> originalComboBox;
    private JSpinner originalSpinner;
    private JRadioButton espejoRadio1, espejoRadio2, espejoRadio3;
    private JCheckBox espejoCheck4, espejoCheck5, espejoCheck6;
    private JTextField espejoTextField;
    private JComboBox<String> espejoComboBox;
    private JSpinner espejoSpinner;

    public Imitador() {
        setTitle("Imitador");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel panelOriginal = new JPanel();
        panelOriginal.setBorder(BorderFactory.createTitledBorder("Original"));
        panelOriginal.setLayout(new GridLayout(5, 2, 5, 5));

        originalRadio1 = new JRadioButton("Opción 1");
        originalRadio2 = new JRadioButton("Opción 2");
        originalRadio3 = new JRadioButton("Opción 3");
        ButtonGroup group = new ButtonGroup();
        group.add(originalRadio1);
        group.add(originalRadio2);
        group.add(originalRadio3);

        originalCheck4 = new JCheckBox("Opción 4");
        originalCheck5 = new JCheckBox("Opción 5");
        originalCheck6 = new JCheckBox("Opción 6");

        originalTextField = new JTextField(10);
        originalComboBox = new JComboBox<>(new String[] { "Item 1", "Item 2" });
        originalSpinner = new JSpinner(new SpinnerNumberModel(20, 0, 100, 1));

        // Añadir componentes al panel "Original"
        panelOriginal.add(originalRadio1);
        panelOriginal.add(originalCheck4);
        panelOriginal.add(originalRadio2);
        panelOriginal.add(originalCheck5);
        panelOriginal.add(originalRadio3);
        panelOriginal.add(originalCheck6);
        panelOriginal.add(originalTextField);
        panelOriginal.add(originalComboBox);
        panelOriginal.add(new JLabel("Spinner:"));
        panelOriginal.add(originalSpinner);

        // Crear panel para "Espejo"
        JPanel panelEspejo = new JPanel();
        panelEspejo.setBorder(BorderFactory.createTitledBorder("Espejo"));
        panelEspejo.setLayout(new GridLayout(5, 2, 5, 5));

        espejoRadio1 = new JRadioButton("Opción 1");
        espejoRadio2 = new JRadioButton("Opción 2");
        espejoRadio3 = new JRadioButton("Opción 3");
        ButtonGroup espejoGroup = new ButtonGroup();
        espejoGroup.add(espejoRadio1);
        espejoGroup.add(espejoRadio2);
        espejoGroup.add(espejoRadio3);

        espejoCheck4 = new JCheckBox("Opción 4");
        espejoCheck5 = new JCheckBox("Opción 5");
        espejoCheck6 = new JCheckBox("Opción 6");

        espejoTextField = new JTextField(10);
        espejoComboBox = new JComboBox<>(new String[] { "Item 1", "Item 2" });
        espejoSpinner = new JSpinner(new SpinnerNumberModel(20, 0, 100, 1));

        // Añadir componentes al panel "Espejo"
        panelEspejo.add(espejoRadio1);
        panelEspejo.add(espejoCheck4);
        panelEspejo.add(espejoRadio2);
        panelEspejo.add(espejoCheck5);
        panelEspejo.add(espejoRadio3);
        panelEspejo.add(espejoCheck6);
        panelEspejo.add(espejoTextField);
        panelEspejo.add(espejoComboBox);
        panelEspejo.add(new JLabel("Spinner:"));
        panelEspejo.add(espejoSpinner);

        // Deshabilitar los campos del "Espejo"
        espejoRadio1.setEnabled(false);
        espejoRadio2.setEnabled(false);
        espejoRadio3.setEnabled(false);
        espejoCheck4.setEnabled(false);
        espejoCheck5.setEnabled(false);
        espejoCheck6.setEnabled(false);
        espejoTextField.setEnabled(false);
        espejoComboBox.setEnabled(false);
        espejoSpinner.setEnabled(false);

        // Añadir ambos paneles al panel principal
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(panelOriginal, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(panelEspejo, gbc);

        add(mainPanel);

        reflejarAcciones();
    }

    // Método para sincronizar acciones del panel "Original" al "Espejo"
    private void reflejarAcciones() {
        originalRadio1.addActionListener(e -> espejoRadio1.setSelected(originalRadio1.isSelected()));
        originalRadio2.addActionListener(e -> espejoRadio2.setSelected(originalRadio2.isSelected()));
        originalRadio3.addActionListener(e -> espejoRadio3.setSelected(originalRadio3.isSelected()));

        originalCheck4.addActionListener(e -> espejoCheck4.setSelected(originalCheck4.isSelected()));
        originalCheck5.addActionListener(e -> espejoCheck5.setSelected(originalCheck5.isSelected()));
        originalCheck6.addActionListener(e -> espejoCheck6.setSelected(originalCheck6.isSelected()));

        originalTextField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                espejoTextField.setText(originalTextField.getText());
            }
        });

        originalComboBox.addActionListener(e -> espejoComboBox.setSelectedItem(originalComboBox.getSelectedItem()));

        originalSpinner.addChangeListener(e -> espejoSpinner.setValue(originalSpinner.getValue()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Imitador imitador = new Imitador();
            imitador.setVisible(true);
        });
    }
}
