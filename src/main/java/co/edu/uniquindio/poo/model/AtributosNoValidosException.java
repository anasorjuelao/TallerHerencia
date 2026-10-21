package co.edu.uniquindio.poo.model;

//Clase para hacer una excepcion que se usara en todas las validaciones

public class AtributosNoValidosException extends RuntimeException{
    public AtributosNoValidosException(String mensaje){
        super(mensaje);
    }
}
