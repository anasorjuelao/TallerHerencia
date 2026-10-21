package co.edu.uniquindio.poo.model;

public class EmpleadoVentas extends Empleado {

    private float totalVentas;
    private float porcentajeComision;

    public EmpleadoVentas(String nombre, String documento, int edad,
                          float salarioBasico, CategoriaEmpleado categoria,
                          float descuentoSalud, float descuentoPension, float totalVentas,
                          float porcentajeComision) {
        super(nombre, documento, edad, salarioBasico, categoria, descuentoSalud, descuentoPension);
        this.totalVentas = totalVentas;
        this.porcentajeComision= porcentajeComision;
    }

    public float getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(float totalVentas) {
        this.totalVentas = totalVentas;
    }

    public float getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(float porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public float calcularSalarioBruto() {
        return salarioBasico + calcularBonificacionCategoria() + calcularComisionVentas();
    }
    public float calcularComisionVentas(){
        return totalVentas * porcentajeComision/100;
    }
    //Validacion 3
    public void validarPorcentajeComision(){
        if(porcentajeComision<0 || porcentajeComision>100){
            throw new AtributosNoValidosException("El porcentaje jamás sera menor que 0 o " +
                    "mayor a 100.");
        }
    }
}
