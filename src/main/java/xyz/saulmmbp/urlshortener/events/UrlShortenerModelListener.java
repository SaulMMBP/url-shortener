package xyz.saulmmbp.urlshortener.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import xyz.saulmmbp.urlshortener.model.UrlShortener;
import xyz.saulmmbp.urlshortener.service.SequenceGeneratorService;

@Component
public class UrlShortenerModelListener extends AbstractMongoEventListener<UrlShortener> {
    
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public UrlShortenerModelListener(SequenceGeneratorService sequenceGeneratorService) {
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    /**
     * Listener que reponde a un evento generado en el ciclo de vida de 
     * spring data mongoDB y Genera un Id automático 
     */
    @Override
    public void onBeforeConvert(BeforeConvertEvent<UrlShortener> event) {
        if(event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGeneratorService.generateSequence(UrlShortener.SEQUENCE_NAME));
        }
    }
    
    

}
