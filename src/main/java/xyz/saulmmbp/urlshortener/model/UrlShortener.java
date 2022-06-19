package xyz.saulmmbp.urlshortener.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

/**
 * Objeto que se mapea al Documento (Colección) urlShortener en MongoDB
 * @author SAUL
 *
 */
public class UrlShortener {
    
    @Transient
    public static final String SEQUENCE_NAME = "urls_sequence";

    @Id
    private long id;
    
    private String url;
    private String shortUrl;
    
    public UrlShortener() {
    }

    public UrlShortener(String url, String shortUrl) {
        this.url = url;
        this.shortUrl = shortUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @Override
    public String toString() {
        return "UrlShortener [id=" + id + ", url=" + url + ", shortUrl=" + shortUrl + "]";
    }
    
    
    
}
