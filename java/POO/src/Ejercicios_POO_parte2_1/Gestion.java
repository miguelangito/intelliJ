package Ejercicios_POO_parte2_1;

import java.util.Scanner;

public class Gestion {

    private String nombre;
    private String posicion;
    private double salario;
    private int id;

    public Gestion(String nombre, String posicion, double salario, int id) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.salario = salario;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public void aumentarSalario(double aumSalario){

        this.salario = (salario*aumSalario)/100+salario;
    }

    @Override
    public String toString() {
        return "Ejercicios_POO_parte2_1.Gestion{" +
                "nombre='" + nombre + '\'' +
                ", posicion='" + posicion + '\'' +
                ", salario=" + salario +
                ", id=" + id +
                '}';
    }


}
