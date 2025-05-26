package Ultimaunidad;/* Programa: MisAnimales.java
   Funcion : Crea los objetos a partir de las clases (Perro y Gato) extendidas de la interface Animal
   Autor   : Javier Contreras Ruiz
*/

public class MisAnimales {
    public static void main(String[] args) {
        Animal miAnimal = new Perro();
        miAnimal.hacerSonido(); // Imprime: El perro ladra así: Guau

        miAnimal = new Gato();
        miAnimal.hacerSonido(); // Imprime: El gato maulla así: Miau
    }
}
