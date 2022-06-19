package xyz.saulmmbp.urlshortener.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import xyz.saulmmbp.urlshortener.model.UrlShortener;

/* Capa Dao, repositorio autoimplementado */
public interface UrlShortenerRepository extends MongoRepository<UrlShortener, Integer> {

    /**
     * Busca el shortUrl indicado, en la base de datos
     * @param shortUrl Término de busqueda
     * @return Regresa el objeto UrlShortener encontrado
     */
    public UrlShortener findByShortUrl(String shortUrl);
}
