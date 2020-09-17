package edu.escuelaing.arep.model;

/**
 * Class that represent a message
 */
public class Mensaje {

    private String mensaje;

    public Mensaje(String mensaje) {
        this.mensaje=mensaje;
    }

    /**
     * return the message
     * @return the message
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * set the message
     * @param mensaje the message
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }


}
