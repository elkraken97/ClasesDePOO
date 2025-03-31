package Proyecto1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Persona persona = null;
        boolean salir = true;
        boolean primera = true;

        Scanner sc = new Scanner(System.in);
        Persona personaAnt = null;
        Persona AntLoop = null;
        while(salir){
            System.out.print("""
                1.-Crear Persona
                2.-Ver Personas
                0.-Salir
                """);
            int op = sc.nextInt();
            sc.nextLine();
            switch (op){
                case 1:
                    System.out.println("Ingrese su nombre");
                    String nom = sc.nextLine();
                    System.out.println("La persona a la que apunte a esta persona sera la siguiente que usted cree");

                    if(primera){
                       persona = new Persona(nom,null);
                       personaAnt = persona;
                       primera = false;
                    }else{
                        Persona j = new  Persona(nom,null);
                        personaAnt.setPersona(j);
                        personaAnt = j;
                    }


                    break;

                case 2:
                    if(persona==null){
                        System.out.println("No hay personas en la lista encadenada");
                    }else{

                    boolean acabo=true;
                    boolean first = true;
                        while(acabo){
                            if(first){
                                System.out.println("La persona: \n"+persona.getNom()+"\nApunta a la persona:\n"+persona.getPersona().getNom());
                                flecha();
                                AntLoop= persona.getPersona();
                            first = false;
                            }else{

                                if(AntLoop.getPersona()==null){
                                    System.out.println("La persona: \n"+AntLoop.getNom()+"\nNo apunta a nadie");
                                    flecha();
                                    System.out.println("Aqui se acaba la lista No hay mas persona ;)\n");
                                    acabo = false;
                                }else{
                                    System.out.println("La persona: \n"+AntLoop.getNom()+"\nApunta a la persona:\n"+AntLoop.getPersona().getNom());
                                    flecha();
                                    AntLoop = AntLoop.getPersona();

                                }

                            }
                        }

                    }
                break;

                case 0:
                    System.out.println("Hasta luego");
                    salir = false;
                break;

                default:
                    System.out.println("opcion no disponible intente otraves");


            }
        }
    }

    private static void flecha() {
        System.out.println("""
                                                   |
                                                 | | |
                                                  |||
                                                   |
                                       """);
    }

}
