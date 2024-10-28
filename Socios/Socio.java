package Socios;

import javax.swing.JOptionPane;

public class Socio {
    String nombre;
    int numero;
    static int proximoNumero = 1;

    Socio(String n) {
        nombre = n;
        numero = proximoNumero;
        proximoNumero += 1;
    }

    String obtenerNombre() {
        return nombre;
    }

    int obtenerNumero() {
        return numero;
    }

    void cambiarNombre(String n) {
        nombre = n;
    }

    void mostrar() {
        String mensaje = "Datos del Socio\n";
        mensaje += "-----------------\n";
        mensaje += "Nombre: " + nombre + "\n";
        mensaje += "Número: " + numero;

        JOptionPane.showMessageDialog(
                null,
                mensaje,
                "Información",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        String nombreSocio1 = JOptionPane.showInputDialog(
                null,
                "Nombre del primer socio:",
                "Registro de Socio 1",
                JOptionPane.QUESTION_MESSAGE);

        Socio s1 = new Socio(nombreSocio1);
        s1.mostrar();

        String nombreSocio2 = JOptionPane.showInputDialog(
                null,
                "Nombre del segundo socio:",
                "Registro de Socio 2",
                JOptionPane.QUESTION_MESSAGE);

        Socio s2 = new Socio(nombreSocio2);
        s2.mostrar();
    }
}
                        