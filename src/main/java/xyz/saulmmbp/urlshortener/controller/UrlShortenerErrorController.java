package xyz.saulmmbp.urlshortener.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UrlShortenerErrorController implements ErrorController {

    @GetMapping("/error")
    public String handleError() {
        return "error";
    }
}
