package edu.escuelaing.arep.services;

import edu.escuelaing.arep.model.Mensaje;
import edu.escuelaing.arep.persistence.MessagePersistence;
import edu.escuelaing.arep.persistence.impl.DBConnection;


import java.util.ArrayList;

/**
 * Class that offer the services
 */
public class MessageService {

    MessagePersistence messagePersistence= new DBConnection();

    /**
     * add and save a message to the db
     * @param mensaje message to be saved
     */
    public void addMessage(String mensaje) {
        messagePersistence.writeMessage(new Mensaje(mensaje));
    }

    /**
     * return the list of the messages in the db
     * @return list of the messages
     */
    public ArrayList<Mensaje> getAllMessages() {
        return messagePersistence.loadMessages();
    }
}
