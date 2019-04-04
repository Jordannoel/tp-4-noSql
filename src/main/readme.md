# TP3 REDIS

Cette application permet de gérer ses notes (créer, afficher, supprimer) grâce à des requêtes HTTP.

## Pré-requis

- JDK 8
- Maven 3+
- Redis

## Utilisation

Avec un gestionnaire de requêtes HTTP comme curl ou Postman, effectuer les requêtes suivantes :

### GET

``` GET localhost:8080/notes ``` : Permet d'afficher la liste des toutes les notes enregistrées.

``` GET localhost:8080/notes/{idNote} ``` : Permet d'afficher la note qui possède l'id ```idNote```.

``` GET localhost:8080/subscribe/{auteur} ``` : Permet d'afficher toutes les notes d'un auteur ```auteur``` en particulier.

### POST

``` POST localhost:8080/notes/{contenu}/{auteur} ``` : Permet de poster une note avec un contenu ```contenu``` et un auteur ```auteur```. La note possédera également une date de création et une heure de création.

### DELETE

``` DELETE localhost:8080/notes/{idNote} ``` : Supprime la note qui possède l'id ```idNote```.