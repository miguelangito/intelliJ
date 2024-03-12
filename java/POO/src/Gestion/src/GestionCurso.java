package Gestion.src;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionCurso {

    private ArrayList<Curso> listaCursos;

    public GestionCurso() {
        this.listaCursos = new ArrayList<>();
    }

    public void guardarCurso(Scanner objScanner) {
        System.out.println("Agregar curso");

        System.out.println("Ingresa el nombre del curso");
        String nombre = objScanner.next();

        System.out.println("Ingresa el codigo del curso");
        String codigo = objScanner.next();

        if (this.buscarPorCodigo(codigo) != null) {
            System.out.println("El codigo ya existe");
        } else {
            Curso objCurso = new Curso(codigo, nombre);
            this.listaCursos.add(objCurso);
        }
    }

    public Curso buscarPorCodigo(String codigoBuscar) {
        for (Curso cursoTemp : this.listaCursos) {
            if (cursoTemp.getCodigo().equalsIgnoreCase(codigoBuscar)) {
                return cursoTemp;
            }
        }
        return null;
    }

    public void listarCursos(){
        if (this.listaCursos.isEmpty()) {
            System.out.println("No hay cursos registrados");
        }else {
            for (Curso cursoTempo : this.listaCursos) {
                System.out.println(cursoTempo.toString());
            }
        }
    }


    public ArrayList<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(ArrayList<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }
}
