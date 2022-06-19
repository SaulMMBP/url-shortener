package xyz.saulmmbp.urlshortener.service;

import xyz.saulmmbp.urlshortener.model.UrlShortener;

/**
 * Capa de servicio para UrlShortener
 * @author SAUL
 *
 */
public interface UrlShortenerService {

    /**
     * Llama a la función del mismo nombre de la capa DAO
     * para guardar el objeto UrlShortener
     * @param urlShortener Objeto a Guardar
     */
    public void saveUrlShortener(UrlShortener urlShortener);
    
    /**
     * Llama a la función del mismo nombre de la capa DAO
     * para encontrar el Documento UrlShortener que contiene
     * shortUrl
     * @param shortUrl Término de búsqueda
     * @return Regresa un Objeto UrlShortener asociado al documento encontrado
     */
    public UrlShortener findByShortUrl(String shortUrl);
}
