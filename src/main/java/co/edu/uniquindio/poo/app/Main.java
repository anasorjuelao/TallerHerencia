package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.EmpleadoPlanta;
import co.edu.uniquindio.poo.model.EmpleadoVentas;
import co.edu.uniquindio.poo.model.EmpleadoTemporal;
import co.edu.uniquindio.poo.model.CategoriaEmpleado;

import javax.swing.*;
import java.awt.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Optional;

public class Main {
    static void main() {

        Empresa empresa = new Empresa("Empresa", "132432");

        int opcion;

        do {
            opcion = Integer.valueOf(JOptionPane.showInputDialog(null,
                    "Por favor selecciones una opcion :\n ---Menu--\n" +
                            "1. Agregar un empleado de planta\n" +
                            " 2. Agregar un empleado de ventas\n" +
                            " 3. Agregar empleado temporal\n" +
                            " 4. Mostrar empleados\n" +
                            " 5. Buscar empleado con el documento\n" +
                            " 6. Mostrar empleado con mayor salario"));

            switch (opcion) {
                case 1:
                    agregarEmpleadoDePlanta(empresa);
                    break;
                case 2:
                    agregarEmpleadoDeVentas(empresa);
                    break;
                case 3:
                    agregarEmpleadoTemporal(empresa);
                    break;
                case 4:
                    mostrarTodosEmpleados(empresa);
                    break;
                case 5:
                    buscarEmpleado(empresa);
                    break;
                case 6:
                    mostrarEmpleadoConMasPlata(empresa);
                    break;
                case 7:
                    mostrarNomina(empresa);
                    break;
                case 8:
                    mostrarResumenPago(empresa);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Muchas " +
                            "gracias por usar nuestro sistema");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion " +
                            "Invalida");

            }
        }while(opcion!=0);

    }
    public static void agregarEmpleadoDePlanta(Empresa empresa){

        String nombreEmpleadoNuevo= JOptionPane.showInputDialog("Ingrese el nombre del " +
                "nuevo empleado.");
        String documentoEmpleadoNuevo=JOptionPane.showInputDialog("Ingrese el nombre del nuevo empleado.");

        String edadEmpleadoNuevo=JOptionPane.showInputDialog("Ingrese la edad del nuevo empleado.");

        int edad= Integer.parseInt(edadEmpleadoNuevo);

        String salarioBasicoEmpleado=JOptionPane.showInputDialog("Ingrese el salario basico del empleado.");

        float salarioBasico= Float.parseFloat(salarioBasicoEmpleado);

        CategoriaEmpleado categoria= sacarCategoria();

        String descuentoSaludE=JOptionPane.showInputDialog("Ingrese el descuento de salud.");

        float descuentoSalud= Float.parseFloat(descuentoSaludE);

        String descuentoPensionE= JOptionPane.showInputDialog("Ingrese el descuento de pension.");

        float descuentoPension= Float.parseFloat(descuentoPensionE);

        String cargoEmpleado= JOptionPane.showInputDialog("Ingrese el cargo del empleado.");

        String horasExtrasE= JOptionPane.showInputDialog("Ingrese las horas extras del empleado.");

        int horasExtras= Integer.parseInt(horasExtrasE);

        String valorHorasExtrasE= JOptionPane.showInputDialog("Ingrese el valor de horas extras del empleado.");

        float valorHoras= Float.parseFloat(valorHorasExtrasE);

        String auxilioTransporteE= JOptionPane.showInputDialog("Ingrese las horas extras del empleado.");

        float auxilioTransporte= Float.parseFloat(auxilioTransporteE);

        String agregado= empresa.agregarEmpleados(new EmpleadoPlanta(nombreEmpleadoNuevo,
                documentoEmpleadoNuevo, edad, salarioBasico, categoria, descuentoSalud,
                descuentoPension, cargoEmpleado, horasExtras, valorHoras, auxilioTransporte));

        System.out.println("Empleado de Planta agregado con exito");

    }
    public static void agregarEmpleadoDeVentas(Empresa empresa){

        String nombreEmpleadoNuevo= JOptionPane.showInputDialog("Ingrese el nombre del " +
                "nuevo empleado.");
        String documentoEmpleadoNuevo=JOptionPane.showInputDialog("Ingrese el nombre del nuevo empleado.");

        String edadEmpleadoNuevo=JOptionPane.showInputDialog("Ingrese la edad del nuevo empleado.");

        int edad= Integer.parseInt(edadEmpleadoNuevo);

        String salarioBasicoEmpleado= JOptionPane.showInputDialog("Ingrese el salario basico del empleado.");

        float salarioBasico= Float.parseFloat(salarioBasicoEmpleado);

        CategoriaEmpleado categoria= sacarCategoria();

        String descuentoSaludE=JOptionPane.showInputDialog("Ingrese el descuento de salud.");

        float descuentoSalud= Float.parseFloat(descuentoSaludE);

        String descuentoPensionE= JOptionPane.showInputDialog("Ingrese el descuento de pension.");

        float descuentoPension= Float.parseFloat(descuentoPensionE);

        int totalVentasE= 0;

        float porcentajeComisionE= 0;

        String agregado= empresa.agregarEmpleados(new EmpleadoVentas(nombreEmpleadoNuevo,
                documentoEmpleadoNuevo, edad, salarioBasico, categoria, descuentoSalud,
                descuentoPension, totalVentasE, porcentajeComisionE));

        System.out.println("Empleado de Ventas agregado con exito");

    }
    public static void agregarEmpleadoTemporal(Empresa empresa){

        String nombreEmpleadoNuevo= JOptionPane.showInputDialog("Ingrese el nombre del " +
                "nuevo empleado.");
        String documentoEmpleadoNuevo=JOptionPane.showInputDialog("Ingrese el nombre del nuevo empleado.");

        String edadEmpleadoNuevo=JOptionPane.showInputDialog("Ingrese la edad del nuevo empleado.");

        int edad= Integer.parseInt(edadEmpleadoNuevo);

        String salarioBasicoEmpleado= JOptionPane.showInputDialog("Ingrese el salario basico del empleado.");

        float salarioBasico= Float.parseFloat(salarioBasicoEmpleado);

        CategoriaEmpleado categoria= sacarCategoria();

        String descuentoSaludE=JOptionPane.showInputDialog("Ingrese el descuento de salud.");

        float descuentoSalud= Float.parseFloat(descuentoSaludE);

        String descuentoPensionE= JOptionPane.showInputDialog("Ingrese el descuento de pension.");

        float descuentoPension= Float.parseFloat(descuentoPensionE);

        int diasTrabajadosE= 0;

        String valorDiaE= JOptionPane.showInputDialog("Ingrese el valor por día.");

        float valorDia= Float.parseFloat(valorDiaE);

        String agregado= empresa.agregarEmpleados(new EmpleadoTemporal(nombreEmpleadoNuevo,
                documentoEmpleadoNuevo, edad, salarioBasico, categoria, descuentoSalud,
                descuentoPension,diasTrabajadosE, valorDia));

        System.out.println("Empleado Temporal agregado con exito");

    }
    public static void mostrarTodosEmpleados(Empresa empresa){
        String e= empresa.mostrarEmpleados();

        System.out.println("|| EMPLEADOS || \n" +e);

    }
    public static void mostrarEmpleadoConMasPlata(Empresa empresa){
        Optional <Empleado> e= empresa.empleadoConMasPasta();

        System.out.println("El empleado com más salario es:" +e);
    }
    public static void buscarEmpleado(Empresa empresa){
        String documento= JOptionPane.showInputDialog("Ingrese aqui el documento del empleado a buscar.");

        Optional<Empleado> e= empresa.buscarEmpleado(documento);

        if(e.isEmpty()){
            System.out.println("Este empleado no existe en la empresa.");
        }else{
            System.out.println("Este empleado esta en la empresa.");
        }
    }
    public static void mostrarNomina(Empresa empresa){
        float o= empresa.calcularNominaEmpresa();

        System.out.println("|| NOMINA TOTAL || \n" +o);
    }
    public static CategoriaEmpleado sacarCategoria(){
        CategoriaEmpleado[] opciones = CategoriaEmpleado.values();
        Object seleccion = JOptionPane.showInputDialog(null, "Seleccione la categoría:",
                "Categoría", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        return (CategoriaEmpleado) seleccion;
    }
    public static void mostrarResumenPago(Empresa empresa){
        System.out.println("|| RESUMEN PAGO ||" +"\n" + empresa.mostrarResumenPago());
    }
}
