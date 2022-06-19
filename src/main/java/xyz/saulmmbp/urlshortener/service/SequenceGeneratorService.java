package xyz.saulmmbp.urlshortener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import xyz.saulmmbp.urlshortener.model.DatabaseSequence;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

/**
 * Servicio de Generación de ID
 * @author SAUL
 *
 */
@Service
public class SequenceGeneratorService {

    private MongoOperations mongoOperations;

    @Autowired
    public SequenceGeneratorService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }
    
    /**
     * Genera una Id de acuerdo a la secuencia relacionada a seqName
     * @param seqName Nombre del Modelo al que se le asigna la id
     * @return Id generada
     */
    public long generateSequence(String seqName) {
        
        DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)), new Update().inc("seq", 1), options().returnNew(true).upsert(true), DatabaseSequence.class);
        
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }
}
