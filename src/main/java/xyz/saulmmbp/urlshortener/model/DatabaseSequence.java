package xyz.saulmmbp.urlshortener.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Objeto que se mapea al Documento Database_sequence
 * y se utiliza para almacenar los Id Autogenerados
 * @author SAUL
 *
 */
@Document(collection = "database_sequences")
public class DatabaseSequence {

    /* Identificador de la colección a la que asigna los id */
    @Id
    private String id;
    
    /* Secuencia de id's */
    private long seq;

    public DatabaseSequence() {
    }
    
    public DatabaseSequence(long seq) {
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        return "DatabaseSequence [id=" + id + ", seq=" + seq + "]";
    }
    
    
}
