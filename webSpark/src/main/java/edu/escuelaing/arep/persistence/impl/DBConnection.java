package edu.escuelaing.arep.persistence.impl;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.escuelaing.arep.model.Mensaje;
import edu.escuelaing.arep.persistence.MessagePersistence;
import org.bson.Document;
import java.util.ArrayList;


/**
 * Class responsible for message persistence using a MongoDB database
 */
public class DBConnection implements MessagePersistence {
    public MongoClientURI uri;
    public MongoClient mongoClient;

    public DBConnection() {
        uri = new MongoClientURI(
                "mongodb://juan:password@192.168.99.100:27017/?serverSelectionTimeoutMS=5000&connectTimeoutMS=10000&authSource=Arep&authMechanism=SCRAM-SHA-1&3t.uriVersion=3");
        mongoClient = new MongoClient(uri);
    }

    /**
     * Save a message
     * @param mensaje message to be saved
     */
    @Override
    public void writeMessage(Mensaje mensaje) {
        MongoDatabase database = mongoClient.getDatabase("Arep");
        MongoCollection<Document> collection =database.getCollection("Mensajes");
        Document document=new Document();
        document.put("mensaje",mensaje.getMensaje());
        collection.insertOne(document);
    }


    /**
     * Load all messages
     * @return the list of messages
     */
    @Override
    public ArrayList<Mensaje> loadMessages() {
        ArrayList<Mensaje> mensajes=new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("Arep");
        MongoCollection<Document> collection =database.getCollection("Mensajes");
        FindIterable fit = collection.find();
        ArrayList<Document> docs = new ArrayList<Document>();
        fit.into(docs);

        for (Document document:docs) {
            String mensaje= (String) document.get("mensaje");
            mensajes.add(new Mensaje(mensaje));
        }

        return mensajes;
    }
}
