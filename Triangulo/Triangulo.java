package Triangulo;

import javax.swing.JOptionPane;

public class Triangulo {
    private double ladoA;
    private double ladoB;
    private double ladoC;

    public Triangulo(double ladoA, double ladoB, double ladoC) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    // Método para verificar si es escaleno (todos los lados diferentes)
    public boolean esEscaleno() {
        return ladoA != ladoB && ladoA != ladoC && ladoB != ladoC;
    }

    // Método para verificar si es isósceles (dos lados iguales)
    public boolean esIsosceles() {
        return (ladoA == ladoB && ladoA != ladoC) ||
                (ladoA == ladoC && ladoA != ladoB) ||
                (ladoB == ladoC && ladoB != ladoA);
    }

    // Método para verificar si es equilátero (todos los lados iguales)
    public boolean esEquilatero() {
        return ladoA == ladoB && ladoB == ladoC;
    }

    // Método para verificar si tiene ángulo recto usando el teorema de Pitágoras, aqui fue donde me di cuenta que no sirvo pa las matematica 🥲
    public boolean tieneAnguloRecto() {
        double maxLado = Math.max(ladoA, Math.max(ladoB, ladoC));
        double sumaCuadradosLadosRestantes = (ladoA * ladoA + ladoB * ladoB + ladoC * ladoC) - (maxLado * maxLado);
        return Math.abs((maxLado * maxLado) - sumaCuadradosLadosRestantes) < 0.000001;
    }

    public static void main(String[] args) {
        try {
            // Pedir los lados del triángulo
            double ladoA = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el lado A del triángulo:"));
            double ladoB = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el lado B del triángulo:"));
            double ladoC = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el lado C del triángulo:"));

            // Crear un triángulo con los lados ingresados
            Triangulo triangulo = new Triangulo(ladoA, ladoB, ladoC);

            // Crear el mensaje con los resultados
            String resultado = "Resultados para el triángulo con lados " + ladoA + ", " + ladoB + ", " + ladoC + ":\n";
            resultado += "Es escaleno: " + triangulo.esEscaleno() + "\n";
            resultado += "Es isósceles: " + triangulo.esIsosceles() + "\n";
            resultado += "Es equilátero: " + triangulo.esEquilatero() + "\n";
            resultado += "Tiene ángulo recto: " + triangulo.tieneAnguloRecto();

            // Mostrar resultados
            JOptionPane.showMessageDialog(null, resultado);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Error: Por favor, ingrese valores numéricos válidos.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}