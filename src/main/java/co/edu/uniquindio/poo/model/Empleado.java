package co.edu.uniquindio.poo.model;

public abstract class Empleado {

    protected String nombre;
    protected String documento;
    protected int edad;
    protected float salarioBasico;
    protected CategoriaEmpleado categoria;
    protected float descuentoSalud;
    protected float descuentoPension;

    public Empleado(String nombre, String documento, int edad, float salarioBasico,
                    CategoriaEmpleado categoria, float descuentoSalud,
                    float descuentoPension) {
        this.nombre = nombre;
        this.documento= documento;
        this.edad= edad;
        this.salarioBasico= salarioBasico;
        this.categoria= categoria;
        this.descuentoSalud= descuentoSalud;
        this.descuentoPension= descuentoPension;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getSalarioBasico() {
        return salarioBasico;
    }

    public void setSalarioBasico(float salarioBasico) {
        this.salarioBasico = salarioBasico;
    }

    public CategoriaEmpleado getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEmpleado categoria) {
        this.categoria = categoria;
    }

    public float getDescuentoSalud() {
        return descuentoSalud;
    }

    public void setDescuentoSalud(float descuentoSalud) {
        this.descuentoSalud = descuentoSalud;
    }

    public float getDescuentoPension() {
        return descuentoPension;
    }

    public void setDescuentoPension(float descuentoPension) {
        this.descuentoPension = descuentoPension;
    }
    public float calcularBonificacionCategoria(){
        float valorBonificacion=0;

        if(getCategoria().equals(CategoriaEmpleado.JUNIOR)){
            valorBonificacion+=calcularSalarioBruto()*0.05;
        } else if(getCategoria().equals(CategoriaEmpleado.SEMI_SENIOR)){
            valorBonificacion+=calcularSalarioBruto()*0.1;
        }else{
            valorBonificacion+=calcularSalarioBruto()*0.15;
        }

        return valorBonificacion;
    }
    public float calcularDescuentos(){
        float totalDescuentosCalculados= calcularSalarioBruto()* descuentoPension +
                                    calcularSalarioBruto()* descuentoSalud;

        return totalDescuentosCalculados;
    }
    public float calcularSalarioNeto(){
        return calcularSalarioBruto() + calcularBonificacionCategoria()
                - calcularDescuentos();
    }
    public String mostrarInformación(){
        String informacion="Nombre: " +nombre+ "\n" +
                "Documento: " + documento + "\n" +
                "Edad: " + edad + "\n" +
                "Categoría: " + categoria + "\n" +
                "Salario basico: " + salarioBasico + "\n" +
                "Salario bruto: " + calcularSalarioBruto() + "\n" +
                "Bonificación: " + calcularBonificacionCategoria() + "\n" +
                "Descuentos: " + calcularDescuentos() + "\n" +
                "Salario neto: " + calcularSalarioNeto();
        return informacion;
    }
    //Validacion 2
    public void validadSalarioBasico(){
        if(salarioBasico<0) {
            throw new AtributosNoValidosException("Los salarios negativos " +
                    "no estan permitidos");
        }
    }
    //Validacion 4.1
    public void validarDescuentoSalud(){
        if(descuentoSalud<0 || descuentoSalud> 100){
            throw new AtributosNoValidosException("El descuento de salud " +
                    "debe estar entre 0 y 100.");
        }
    }
    //Validacion 4.2
    public void validarDescuentoPension(){
        if(descuentoPension<0 || descuentoPension>100){
            throw new AtributosNoValidosException("El descuento de pension " +
                    "debe estar entre 0 y 100.");
        }
    }

    public ResumenPago generarResumenPago(){

        return new ResumenPago(documento, nombre,
                categoria,calcularSalarioBruto(),
                calcularDescuentos(), calcularSalarioNeto());
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", edad=" + edad +
                ", salarioBasico=" + salarioBasico +
                ", categoria=" + categoria +
                ", descuentoSalud=" + descuentoSalud +
                ", descuentoPension=" + descuentoPension +
                '}';
    }

    public abstract float calcularSalarioBruto();
}
