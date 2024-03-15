package Ejercicios_POO_parte2_1;

public class Banco {

    private String titular;
    private  double salario;

    public Banco(String titular, double salario) {
        this.titular = titular;
        this.salario = salario;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void ingresarSalario(double sumaSalario){
        this.salario += sumaSalario;
    }

    public void retirarSalario(double retiroSalario){

        if (salario < 0){
            System.out.println("no tienes el dinero necesario");
        }else{
            this.salario -= retiroSalario;
        }
    }

    @Override
    public String toString() {
        return "Ejercicios_POO_parte2_1.Banco{" +
                "titular='" + titular + '\'' +
                ", salario=" + salario +
                '}';
    }
}
