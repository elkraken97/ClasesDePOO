package Examen;


import java.util.ArrayList;
import java.util.List;

import java.util.Objects;
import java.util.Scanner;

public class Main{

    //Explicacion del codigo
    public static void main(String[] args) {

        //Creacion de la instancia hacia el objeto de biblioteca
        Biblioteca biblioteca = new Biblioteca();
        //booleano que controla el salir del bucle
        //Funciones propuestas del examen
        biblioteca.agregarMaterial("El Señor de los Anillos", "J.R.R. Tolkien", "Fantasía", "Libro");
        biblioteca.agregarMaterial("National Geographic", "Editorial Nacional", "Ciencia", "Revista");
        biblioteca.agregarMaterial("El País", "Editorial El País", "Noticias", "Periódico");
        biblioteca.agregarMaterial("La Lista de Schindler", "Steven Spielberg", "Drama", "Cinta");

        boolean salir = false;
        //Scanner (se que no pidio un menu el examen pero quise hacerlo)
        Scanner sc = new Scanner(System.in);
        //bucle para no temrminar el programa hasta que el usuario requiera
        while(!salir){

            //menu
            System.out.println("""
                    Hola Bienvenido a la biblioteca
                    ¿Que desea hacer?
                    1.-Agregar Material
                    2.-Buscar Por titulo
                    3.-Buscar Por autor
                    4.- Buscar Por genero
                    5.-Salir""");
            //lee la opcion
            int op=VerificarNum(sc);
            //limpia el bufer (si no se hace esto se salta un input)
            sc.nextLine();
            switch (op){
                //opcion 1 Ingresar un libro
                case 1:
                    //Quise hacer algo practico para el menu asi que implemente que primero leyera el tipo
                    String tipo;
                    //bucle para que escoja forzadamente el material
                    while(true){
                        System.out.println("""
                                Ingrese el tipo de Material
                                1.-Libro
                                2.-Revistas
                                3.-Periodicos
                                4.-Cintas
                                5.-Cancelar
                                """);
                        //lee la opcion
                        int type = VerificarNum(sc);
                        //Da el tipo de material al String
                        switch (type){
                            case 1-> tipo="Libro";
                            case 2-> tipo = "Revista";
                            case 3-> tipo = "Periodico";
                            case 4-> tipo = "Cinta";
                            //
                            case 5 -> {return;}
                            default ->{
                                System.out.println("Escoja una opcion valida");
                                //Sigue con la siguiente vuelta del bucle para no ejecutar el break
                                continue;
                            }

                        }
                        //se se escoje una opcion sale del bucle ya que el switch se ejecuto correctamente
                        break;
                        }
                    //se limpia el input otraves
                    sc.nextLine();
                    // se lee el resto de atributos y puse el tipo al final para mejor interface
                    System.out.println("Ingrese el titulo de su "+tipo);
                    String titulo = sc.nextLine();
                    System.out.println("Ingrese el autor de su "+tipo);
                    String autor = sc.nextLine();
                    System.out.println("Ingrese el genero de su "+tipo);
                    String genero = sc.nextLine();
                    //se agrega a la biblioteca
                    biblioteca.agregarMaterial(titulo,autor,genero,tipo);
                    break;
                case 2:
                    //si en la biblioteca no hay libros no se pueden realizar busquedas (agregue esto en cada case)
                    if(biblioteca.hayLibros()) {
                        // lee el titulo
                        System.out.println("Ingrese el titulo que busca");
                        String Titulo = sc.nextLine();
                        //se manda a la funcion de biblioteca
                        List<Material> resultados = biblioteca.buscarMaterialPorTitulo(Titulo);
                        //si esta la lista vacia se avisa que no se encontro nada
                        if (!resultados.isEmpty()) {
                            //se listan todos lo encontrado con for each
                            /*
                            * ¿como funciona foreach?
                            * se usa en listas de tipo LIst o ArrayList dando la lista con los objetos
                            * y se declara un objeto del mismo tipo que tenga la lista y en cada vuelta del for
                            * ese objeto sera un objeto de la lista esto de acuerdo al orden que se le dio a lista
                            * se podria poner como resultados.forEach(System.out::println) pero asi se explica mejor (siento)
                            * */

                            for (Material resultado : resultados) {
                                System.out.println(resultado);
                            }
                        } else {
                            System.out.println("No se encontro ningun material con ese autor");
                        }
                    }else{
                        System.out.println("No hay libros en la biblioteca ingrese uno para realizar las busquedas");
                    }

                    break;
                case 3:
                    if(biblioteca.hayLibros()) {
                        // se lee el autor
                    System.out.println("Ingrese el autor del material que busca");
                    String Autor = sc.nextLine();
                    List<Material> Aut = biblioteca.buscarMaterialPorAutor(Autor);
                    //misma logica en este caso
                    if(!Aut.isEmpty()){
                        for (Material Lib : Aut) {
                            System.out.println(Lib);
                        }
                    }else{
                        System.out.println("No se encontro ningun material con ese autor");
                    }
                    }else{
                        System.out.println("No hay libros en la biblioteca ingrese uno para realizar las busquedas");
                    }
                    break;
                case 4:
                    if(biblioteca.hayLibros()) {
                        // se lee el genero
                        System.out.println("Ingrese el genero del material que busca");
                        String Genero = sc.nextLine();
                        List<Material> Gen = biblioteca.buscarMaterialPorGenero(Genero);
                        // misma logica otraves
                        if (!Gen.isEmpty()) {
                            for (Material genr : Gen) {
                                System.out.println(genr);
                            }
                        } else {
                            System.out.println("No se encontro ninguna material de ese genero");
                        }
                    }else{
                        System.out.println("No hay libros en la biblioteca ingrese uno para realizar las busquedas");
                    }
                    break;
                case 5:
                    //sale del bucle
                    System.out.println("Hasta pronto!");
                    salir = true;
                    break;
                    //caso defauilt si no se ingreso opcion valida
                default:
                    System.out.println("Ingrese una opcion valida");
                    }
            }

        }
        //funcion que puse porque se repetia este codigo al querer un numero y para evitar que hay excepciones no deseadas
        public static int VerificarNum(Scanner sc){
        try{
                return sc.nextInt();
        }catch (Exception e){
            System.out.println("A ingresado algo que no es un numero");
        }
        return 0;
        }
    }

class Biblioteca {
    //biblioteca gestiona una lista con objetos de tipo material que son los que se guaradaran
    private final List<Material> material = new ArrayList<>();

    //Agregar material pues AGREGA un material a la lista
    public void agregarMaterial(String titulo, String autor, String genero, String tipo){
        material.add(new Material(titulo,autor,genero,tipo));
    }

    //funcion para saber si en la lista hay libros o si esta vacia
    public boolean hayLibros(){
        return !material.isEmpty();
    }


    //Funcion que busca el material por titulo
    public List<Material> buscarMaterialPorTitulo(String titulo){
        //Se hace una lista que se llenara con lo encontrado
        List<Material> Tit  = new ArrayList<>();
        //for que recorre toda la lista de material que haya
        for (Material material1 : material) {
            //si el titulo del material es igual al requerrido se agrega a la lista
            //(uso Objects.equals porque asi me lo sugierio la IDE Intellij)
            //se llama a .getTitulo para tomar el titulo que tenga el objeto actual
            if(Objects.equals(material1.getTitulo(), titulo)){
              Tit.add(material1);
            }
        }
        // la funcion retorna la lista
        return Tit;
    }
    //misma logica pero cambiando el autor
    public List<Material> buscarMaterialPorAutor(String autor){
        List<Material> Aut  = new ArrayList<>();
        for (Material material1 : material) {
            if(Objects.equals(material1.getAutor(), autor)){
                Aut.add(material1);
            }
        }

        return Aut;
    }
    //misma logica pero cambiando el genero
    public List<Material> buscarMaterialPorGenero(String genero){

        List<Material> Gen = new ArrayList<>();
        for (Material material1 : material) {
            if(Objects.equals(material1.getGenero(), genero)){
                Gen.add(material1);
            }
        }
        return Gen;
    }


}
//Objeto Material
class Material {
    //Atributos de la clase declarados con final porque no hay setters (igual sugerido poor la IDE)
    private final String titulo;
    private final String autor;
    private final String genero;
    private final String tipo;

    //constructor que initializa todos los atributos del objeto
    public Material(String titulo, String autor, String genero, String tipo) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.tipo = tipo;
    }

    //clases .get que retornan el atributo solicitado para hacer las comparaciones en biblioteca
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    //Metodo toString para mostrar todos los datos que tenga el objeto
    @Override
    public String toString() {
        return "Material{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
    /*No sabia si hacer varias clases Peridico libro etc que fueran hijas de Material pero no lo considere viable
    * porque todas compartian las mismas funciones los mismos datos etc aparte que en el mensaje de Ws del problema tipo
    * esta por String aunque se podia cambiar la clase que tuvieran en biblioteca al agregarlos considero que era demas
    * y aparte codig extra que solo iba a ser lo mismo
    */
}
