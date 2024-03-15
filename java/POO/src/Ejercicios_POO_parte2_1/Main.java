package Ejercicios_POO_parte2_1;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Libro objLibro = new Libro(
                "Cien años de soledad",
                "Gabriel Garcia M",
                "Mayo 1967",
                false);


        System.out.println(objLibro.getTitulo());

        objLibro.setTitulo("El rastro de tu sangre en la nieve");

        System.out.println(objLibro.getTitulo());

        System.out.println(objLibro);

        objLibro.setPrestado(true);

        System.out.println(objLibro.getPrestado());

        Gestion objGestion = new Gestion(
                "miguel",
                "Gerente",
                2000000,
                1
        );

      Scanner objScanner = new Scanner(System.in);

        System.out.println("Ingrese el porcentaje que quiere aumentar en base al salario" +
                "salario actual: " + objGestion.getSalario());

        double aumSalario = objScanner.nextDouble();

        objGestion.aumentarSalario(aumSalario);

        System.out.println(objGestion.getSalario());


        Banco objBanco = new Banco(
                "Miguel Espinal",
                20000
        );


        System.out.println("Ingresar fondos");


        int option;
        double saldo;
        saldo = objBanco.getSalario();
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    --- Cuenta bancaria ---
                    1. Ingresar mas saldo
                    2. Retirar saldo
                    3. Ver saldo
                    4. Salir"""));
            switch (option) {
                case 1:
                    double sumarSaldo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el saldo"));
                    saldo += sumarSaldo;
                    break;
                case 2:
                    double retirarSalario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad que quiere retirar"));
                        if (saldo < retirarSalario){
                            JOptionPane.showMessageDialog(null,"No tienes saldo suficiente");
                        }else{
                            saldo -= retirarSalario;
                        }
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null,saldo);
                    break;
            }

        } while (option != 4);



    }
}