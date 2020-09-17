package edu.escuelaing.arep.persistence;

import edu.escuelaing.arep.model.Mensaje;

import java.util.ArrayList;


public interface MessagePersistence {

    void writeMessage(Mensaje mensaje);

    ArrayList<Mensaje> loadMessages();
}
