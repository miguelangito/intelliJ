package Ejercicios_POO_parte2_2;

public class Empleado extends Persona {

    private int idEmpleado;
    private int salario;

    public Empleado(String nombre, int edad ,int idEmpleado, int salario) {
        super(nombre, edad);
        this.idEmpleado = idEmpleado;
        this.salario = salario;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", salario=" + salario +
                '}';
    }
}
