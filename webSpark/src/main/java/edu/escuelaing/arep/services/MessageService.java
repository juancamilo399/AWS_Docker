package edu.escuelaing.arep.services;

import edu.escuelaing.arep.model.Mensaje;
import edu.escuelaing.arep.persistence.MessagePersistence;
import edu.escuelaing.arep.persistence.impl.DBConnection;


import java.util.ArrayList;


public class MessageService {

    MessagePersistence messagePersistence= new DBConnection();

    public void addMessage(String mensaje) {
        messagePersistence.writeMessage(new Mensaje(mensaje));
    }

    public ArrayList<Mensaje> getAllMessages() {
        return messagePersistence.loadMessages();
    }
}
