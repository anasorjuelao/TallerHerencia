package co.edu.uniquindio.poo.model;

public class EmpleadoTemporal extends Empleado{

    private int diasTrabajados;
    private float valorDia;

    public EmpleadoTemporal(String nombre, String documento, int edad,
                            float salarioBasico, CategoriaEmpleado categoria,
                            float descuentoSalud, float descuentoPension,
                            int diasTrabajados, float valorDia) {
        super(nombre, documento, edad, salarioBasico, categoria, descuentoSalud, descuentoPension);
        this.diasTrabajados = diasTrabajados;
        this.valorDia= valorDia;
    }

    public int getDiasTrabajados() {
        return diasTrabajados;
    }

    public void setDiasTrabajados(int diasTrabajados) {
        this.diasTrabajados = diasTrabajados;
    }

    public float getValorDia() {
        return valorDia;
    }

    public void setValorDia(float valorDia) {
        this.valorDia = valorDia;
    }

    @Override
    public float calcularSalarioBruto() {
        return valorDia* diasTrabajados;
    }
    public

}
