package Gestion.src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner objScanner = new Scanner(System.in);
        GestionCurso objGestion = new GestionCurso();


        int option = 0;

        do {
            System.out.println("""
                    Menu de opciones
                    1. Administrar curso.
                    2. Administrar estudiantes.
                    3. Salir.
                    """);
            option = objScanner.nextInt();

            switch (option) {
                case 1:
                    int option2 = 0;
                    do {
                        System.out.println("""
                                Menu de cursos
                                1. Crear cursos.
                                2. Buscar curso por codigo.
                                3. Lista de cursos.
                                4. Salir.
                                """);
                        option2 = objScanner.nextInt();
                        switch (option2) {
                            case 1:
                                objGestion.guardarCurso(objScanner);
                                break;
                            case 2:
                                System.out.println("Ingresa el codigo del curso");
                                String codigo = objScanner.next();
                                System.out.println(objGestion.buscarPorCodigo(codigo).toString());
                                break;
                            case 3:
                                objGestion.listarCursos();
                                break;

                        }
                    } while (option2 != 4);
                    break;

                case 2:
                    int option3 = 0;
                    do {
                        System.out.println("""
                                Menu
                                1. Agregar estudiantes.
                                2. Eliminar estudiante.
                                3. Listar Estudiantes.
                                4. Salir
                                """);
                        option3 = objScanner.nextInt();
                        switch (option3) {
                            case 1:
                                objGestion.listarCursos();

                                System.out.println("Ingrese el codigo del curso donde desee inscribir el estudiante");
                                String codigo = objScanner.next();

                                Curso curso = objGestion.buscarPorCodigo(codigo);
                                if (curso == null) {
                                    System.out.println("Curso no encontrado");
                                } else {
                                    curso.guardarEstudiante(objScanner);
                                }
                                break;
                            case 2:
                                objGestion.listarCursos();

                                System.out.println("ingrese el codigo del curso del estudiante que desea eliminar");
                                codigo = objScanner.next();

                                Curso objCurso = objGestion.buscarPorCodigo(codigo);
                                if (objCurso == null) {
                                    System.out.println("Codigo no valido");
                                }else {
                                    objCurso.eliminarEstudiantes(objScanner);
                                }
                                break;

                            case 3:
                                objGestion.listarCursos();

                                System.out.println("Ingresar el codigo del curso que quiere ver los estudiantes");
                                codigo = objScanner.next();
                                curso = objGestion.buscarPorCodigo(codigo);

                                if (curso == null) {
                                    System.out.println("Curso no encontrado");
                                }else {
                                    curso.listarEstudiantes();
                                }
                                break;
                        }
                    } while (option3 != 4);

                    break;
            }
        } while (option != 3);

    }
}