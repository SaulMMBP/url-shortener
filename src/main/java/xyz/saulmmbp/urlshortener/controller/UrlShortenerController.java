package xyz.saulmmbp.urlshortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.saulmmbp.urlshortener.model.UrlShortener;
import xyz.saulmmbp.urlshortener.service.UrlShortenerService;

@Controller
@RequestMapping("/urlshortener")
public class UrlShortenerController {

    private UrlShortenerService urlShortenerService;

    /* Constructor */
    @Autowired
    public UrlShortenerController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }
    
    /**
     * Controla la petición de redirección del acortador
     * @param shortUrl Acortador
     * @return Regresa la indicación de redirijir hacia el url indicado
     */
    @GetMapping("/{shortUrl}")
    public String goToUrl(@PathVariable String shortUrl) {
        
        /* Encuentra el Documento asociado al acortador */
        UrlShortener urlShortener = urlShortenerService.findByShortUrl(shortUrl);
        
        /* Obtiene la url asociada*/
        String url = urlShortener.getUrl();
        
        return "redirect:" + url;
    }
    
    /**
     * Controla la petición de almacenar el acortador
     * @param urlShortener Objeto UrlShortener que contiene el url y el acortador
     * @param model Guarda la información para mandarla a la vista
     * @return Regresa el template que debe mostrarse
     */
    @PostMapping("/save")
    public String saveUrlShortener(UrlShortener urlShortener, Model model) {
        urlShortenerService.saveUrlShortener(urlShortener);
        
        model.addAttribute(urlShortener);
        
        return "index";
    }
}
