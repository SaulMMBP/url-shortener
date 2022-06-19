# Acortador de URLs

Proyecto creado en Java con Spring, Thymeleaf y MongoDB

## Base de datos

Creada en MongoDB, contiene dos colectiones

- database_sequence: Una colección de apoyo para la generación automática de IDs para los acortadores.

- urlShorteners: Colección que almacena los acortadores y la url a la que están asociados. 

## Modelos

- DatabaseSequence: Entidad que se mapea a los documentos en la colección database_sequence, que contiene
el nombre de la colección a la que pertenece y la secuencia que lleva.

- UrlShortener: Entidad que se mapea a los documentos que almacenan los datos de los acortadores.

## DAO

Contiene un repositorio para la manipulación directa de los documentos de la base de datos

## Capa de Servicio

Contiene dos servicios, el primero correspondiente a la manipulación de los documentos de la base datos
que se obtienen del repositorio.

El segundo corresponde a la generación de de IDs.

## EventListener

Se implementó un escuchador de eventos del ciclo de vida del mapeo de Spring Data MongoDB, y asignar
automáticamente el Id generador por el servicio SequenceGeneratorService.

## Controller

- ViewController: Controlador para insertar el acortador generado dentro de la misma página.

- UrlShortenerController: Controlador para manejar las peticiones y aplicar los servicios requeridos en la base de datos.

- UrlShortenerErrorController: Controlador para manejar los errores por medio de páginas customizadas.

## View

HTML con formulario básico y CSS basado en el estilo de la página de error utilizada.

La página de Error es una template gratuito HTML, CSS 

**Template:** <br>
https://codepen.io/honeybadger2788/pen/oNzKzvy <br>
**Obtenido de:** <br>
https://freefrontend.com/html-css-404-page-templates/ <br>
**Autor:** <br>
JSON.girlify
