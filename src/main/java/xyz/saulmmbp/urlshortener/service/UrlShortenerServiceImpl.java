package xyz.saulmmbp.urlshortener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.saulmmbp.urlshortener.dao.UrlShortenerRepository;
import xyz.saulmmbp.urlshortener.model.UrlShortener;

/**
 * Implementación del servicio de UrlShortener
 * @author SAUL
 *
 */
@Service
public class UrlShortenerServiceImpl implements UrlShortenerService {

    private UrlShortenerRepository urlShortenerRepository;
    
    @Autowired
    public UrlShortenerServiceImpl(UrlShortenerRepository urlShortenerRepository) {
        this.urlShortenerRepository = urlShortenerRepository;
    }

    @Override
    public void saveUrlShortener(UrlShortener urlShortener) {
        
        /* Asignar urlShortener */
        String shortUrl = ((Double) Math.random()).toString().substring(2, 7);
        urlShortener.setShortUrl(shortUrl);
        
        urlShortenerRepository.save(urlShortener);
    }

    @Override
    public UrlShortener findByShortUrl(String shortUrl) {
        
        /* Obtiene urlShortener asociado al acortador */
        UrlShortener urlShortener = urlShortenerRepository.findByShortUrl(shortUrl);
        
        if(urlShortener == null) {
            throw new RuntimeException("El Acortador ingresado no existe - " + shortUrl);
        }
        
        return urlShortener;
    }
    
}
