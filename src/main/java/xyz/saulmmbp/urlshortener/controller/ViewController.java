package xyz.saulmmbp.urlshortener.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import xyz.saulmmbp.urlshortener.model.UrlShortener;

@Controller
public class ViewController {

    /**
     * Controla la petición para mostrar la página de inicio
     * @param model Crea un modelo que se pasará a la vista
     * @return Regresa el template que se mostrará
     */
    @GetMapping("/")
    public String showIndex(Model model) {
        UrlShortener urlShortener = new UrlShortener();
        
        model.addAttribute(urlShortener);
        
        return "index";
    }
}
