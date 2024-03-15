package Gestion.src;

import java.util.ArrayList;
import java.util.Scanner;

public class Curso {

    private String codigo;
    private String nombre;
    private ArrayList<Estudiante> listaEstudiantes;
    private static int idEstudiante = 1;

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.listaEstudiantes = new ArrayList<>();
    }

    public void guardarEstudiante(Scanner objScanner) {
        System.out.println("Agregar nuevo estudiante");
        System.out.println("Ingresa el nombre del estudiante: ");
        String nombre = objScanner.next();
        System.out.println("Ingrese el email del estudiante: ");
        String email = objScanner.next();
        Estudiante objEstudiante = new Estudiante(idEstudiante, nombre, email);
        idEstudiante++;
        if (this.listaEstudiantes.add(objEstudiante)) {
            System.out.println("Estudiante agregado correctamente");
        } else {
            System.out.println("No se pudo agregar al estudiante");
        }
    }

    public void listarEstudiantes() {
        if (this.listaEstudiantes.isEmpty()) {
            System.out.println("el curso: ".concat(this.nombre).concat("No tiene estudiantes"));
        } else {
            System.out.println("Lista de estudiantes");
            for (Estudiante estudiante : this.listaEstudiantes) {
                System.out.println(estudiante.toString());
            }
        }
    }

    public void eliminarEstudiantes(Scanner objScanner) {
        this.listarEstudiantes();
        System.out.println("Ingrese el ID: ");
        int pedirId = objScanner.nextInt();
        this.listaEstudiantes.removeIf(estudiante -> estudiante.getId() == pedirId);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    @Override
    public String toString() {
        return "Curso: " + "codigo: " + codigo  + ", nombre: " + nombre;
    }
}
