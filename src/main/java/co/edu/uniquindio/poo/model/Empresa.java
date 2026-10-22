package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Empresa {

    private String nombre;
    private final String NIT;

    ArrayList<Empleado> listaEmpleados = new ArrayList <> ();

    public Empresa(String nombre, String NIT) {
        this.nombre= nombre;
        this.NIT= NIT;
        this.listaEmpleados = listaEmpleados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNIT() {
        return NIT;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    //Metodo 1
    public String agregarEmpleados(Empleado empleado){
        Optional<Empleado> empleadoBuscado= buscarEmpleado(empleado.getDocumento());

        if(empleadoBuscado.isEmpty()){
            listaEmpleados.add(empleado);
            return "Empleado registrado exitosamente.";
        }else return "Este empleado ya esta registrado en la empresa.";

    }
    //Metodo 3
    public Optional<Empleado> buscarEmpleado(String documento){
        for(Empleado empleado: listaEmpleados) {

            return listaEmpleados.stream().filter(cliente -> documento.equals
                    (empleado.getDocumento())).findFirst();
        }
        return Optional.empty();
    }
    //Metodo 2
    public String mostrarEmpleados(){
        String mensaje="Los empleados en esta empresa son: \n";
       mensaje+= listaEmpleados;
       return mensaje;
    }
    //Metodo 4
    public Optional<Empleado> empleadoConMasPasta(){
        Empleado empleadoConMasLucas= null;
        if(listaEmpleados.isEmpty()) {
            return Optional.empty();
        }
            for (int i = 0; i < listaEmpleados.size(); i++) {
                if (listaEmpleados.get(i).calcularSalarioNeto() >
                        listaEmpleados.get(i + 1).calcularSalarioNeto()) {
                    empleadoConMasLucas = listaEmpleados.get(i);
                }
            }
            if (empleadoConMasLucas != null) {
                return Optional.of(empleadoConMasLucas);
            } else return Optional.empty();
    }
    public float calcularNominaEmpresa(){
        float nomina=0;
        for(Empleado empleado: listaEmpleados){
            nomina+=empleado.calcularSalarioNeto();
        }
        return nomina;
    }
    public String mostrarResumenPago(){

        StringBuilder mensaje= new StringBuilder();

        for(Empleado empleado: listaEmpleados){

            //Por si se pregunta profe, con el String normal no me dejo así que me toco buscar y usar esto.
            mensaje.append(empleado.generarResumenPago());
        }
        return mensaje.toString();
    }
}
