import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

/*        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }*/

/*        int contador = 0;
        int sumaTotal = 0;

        while (contador <= 100){
            sumaTotal += contador;
            contador ++;
        }
        System.out.println(sumaTotal);*/
        /*String option = "";
        double saldo = 0;

        do {
            option = JOptionPane.showInputDialog(null, "\n\n Menu de opciones\n" + "1. Ver saldo\n" + "2. Depositar dinero\n" + "3. Retirar\n" + "4. Salir\n\n" + "Ingese una opcion: ");
            switch (option) {
                case "1":
                    JOptionPane.showMessageDialog(null, "Tu saldo es de: " + saldo);
                    break;
                case "2":
                    String precioString = JOptionPane.showInputDialog(null, "Ingresa el valor a depositar\n" + "$");
                    try {
                        double precio = Double.parseDouble(precioString);
                        saldo += precio;

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Dinero ingresado correctamente");

                    }

                    break;
                case "3":
                    try {

                        double valorRetirar = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingresa el valor a retirar"));

                        if (valorRetirar <= saldo) {
                            saldo -= valorRetirar;
                            JOptionPane.showMessageDialog(null,"Retiro correcto");
                        }else {
                            JOptionPane.showMessageDialog(null,"Saldo insuficiente");
                        }
                    }catch (Exception e){

                    }
            }
        } while (!option.equals("4"));*/

        //Ejercicio 4

        /*int contador = 0;

        for (int i = 0; i <= 100; i++) {
            if (i %2 == 0) {
                System.out.println((contador += i ));
            }
        }*/

        //Ejercicio 5
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su edad");
        int pedirEdad = scanner.nextInt();

        while (pedirEdad > 120 || pedirEdad <=0){
            System.out.println("No es una edad valida");
            System.out.println("Vuelva a ingresar otra edad");
            pedirEdad = scanner.nextInt();
            if (pedirEdad <120 && pedirEdad >0){
                System.out.println("Edad valida");
                break;
            }

        }*/
    //Ejercicio 6

    }
}