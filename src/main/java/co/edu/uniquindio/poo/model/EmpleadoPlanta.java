package co.edu.uniquindio.poo.model;

public class EmpleadoPlanta extends Empleado{

    private String cargo;
    private int horasExtras;
    private float valorHoraExtra;
    private float auxilioTransporte;

    public EmpleadoPlanta(String nombre, String documento, int edad,
                          float salarioBasico, CategoriaEmpleado categoria,
                          float descuentoSalud, float descuentoPension, String cargo,
                          int horasExtras, float valorHoraExtra, float auxilioTransporte) {
        super(nombre, documento, edad, salarioBasico, categoria, descuentoSalud, descuentoPension);
        this.cargo = cargo;
        this.horasExtras= horasExtras;
        this.valorHoraExtra= valorHoraExtra;
        this.auxilioTransporte= auxilioTransporte;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    public float getValorHoraExtra() {
        return valorHoraExtra;
    }

    public void setValorHoraExtra(float valorHoraExtra) {
        this.valorHoraExtra = valorHoraExtra;
    }

    public float getAuxilioTransporte() {
        return auxilioTransporte;
    }

    public void setAuxilioTransporte(float auxilioTransporte) {
        this.auxilioTransporte = auxilioTransporte;
    }

    @Override
    public float calcularSalarioBruto() {
        return salarioBasico + calcularBonificacionCategoria() + valorHoraExtra*horasExtras
                + auxilioTransporte;
    }
    //validacion 1
    public void validarHorasExtras(){
        if(horasExtras<0){
            throw new AtributosNoValidosException("Las horas extras no pueden ser negativas.");
        }
    }
    public void validarValorHorasExtras(){
        if(valorHoraExtra<0){
        throw new AtributosNoValidosException("Las horas no pueden tener un precio negativo.");
        }
    }


}
