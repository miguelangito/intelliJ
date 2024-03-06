import java.util.Scanner;

public class Ejercicio_02 {
    public static void main(String[] args) {

/*      Sistema de Reservas: Desarrolla un programa para un teatro para gestionar las
        reservas de asientos. El teatro tiene 5 filas con 10 asientos cada una. Utiliza un
        arreglo bidimensional de boolean donde true representa un asiento ocupado y false
        uno disponible. El sistema debe permitir:
             Reservar y cancelar asientos.
             Mostrar los asientos disponibles.
             Contabilizar el total de asientos ocupados y disponibles.*/

        //Creamos la matriz que nos permitirá guardar los estados de todos los asientos

        boolean[][] listaAsientos = new boolean[5][10];

        //Objeto Scanner para obtener información del usuario por consola
        Scanner objScanner = new Scanner(System.in);

        //Variable para guardar la opción del usuario
        int option;

        do {
            objScanner.nextLine();
            System.out.println("ENTER PARA CONTINUAR");
            objScanner.nextLine();
            System.out.println("RESERVA DE SILLAS TEATRO");
            System.out.println("1. RESERVAR ASIENTOS");
            System.out.println("2. CANCELAR ASIENTOS");
            System.out.println("3. MOSTRAR ASIENTOS DISPONIBLES");
            System.out.println("4. TOTAL ASIENTOS OCUPADOS Y DISPONIBLES");
            System.out.println("5. SALIR");
            System.out.println("INGRESE UNA OPCIÓN");

            //Leemos la opción elegida por el usuario
            option = objScanner.nextInt();
            int fila;
            int silla;
            switch (option) {
                case 1:
                    System.out.println("Ingrese fila (1 - 5)");
                    fila = objScanner.nextInt() - 1;
                    System.out.println("Ingrese el asiento (1 - 10)");
                    silla = objScanner.nextInt() - 1;

                    if (!listaAsientos[fila][silla]) {
                        listaAsientos[fila][silla] = true;
                        System.out.println("Asiento reservado correctamente");
                    } else {
                        System.out.println("Este asiento ya esta reservado");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese la fila (1 - 5)");
                    fila = objScanner.nextInt() - 1;
                    System.out.println("Ingresa el asiento (1 - 10)");
                    silla = objScanner.nextInt() - 1;

                    if (listaAsientos[fila][silla]) {
                        listaAsientos[fila][silla] = false;
                        System.out.println("Reserva cancelada");
                    } else {
                        System.out.println("Este asiento no esta reservado");
                    }
                    break;
                case 3:
                    System.out.println("Asientos disponibles");
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 10; j++) {
                            if (!listaAsientos[i][j]) {
                                System.out.println("(" + (i + 1) + "-" + (j + 1) + ")");
                            }
                        }
                    }
                    break;

                case 4:
                    int ocupado = 0, disponibles = 0;
                    for(boolean[] filaAsiento:listaAsientos){
                        for (boolean asientoocupado:filaAsiento){
                            if (asientoocupado){
                                ocupado++ ;
                            }else {
                                disponibles++;
                            }
                        }
                    }
                    System.out.println("Asientos disponibles: "+ disponibles+","+ "Asientos ocupados: "+ ocupado);

                    break;
            }


        } while (option != 5);
    }
}
