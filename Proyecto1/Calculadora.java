package Proyecto1;

import java.util.Scanner;

public class Calculadora {




    public static void main(String[] args) {
        boolean salir = true;
        Scanner sc = new Scanner(System.in);
        while(salir) {
            System.out.println("""
                    Bienvenido escoga su operacion
                    1.-Suma
                    2.-Resta
                    3.-Multiplicacion
                    4.-Divisiones
                    5.-Salir
                    """);
            int op = sc.nextInt();
            sc.nextLine();
            System.out.println("Ingrese el valor de a");
            int a = sc.nextInt();

            System.out.println("Ingrese el valor de b");
            int b = sc.nextInt();

            switch (op) {
                case 1 -> System.out.println("El Resultado de la suma es:" + suma(a, b));
                case 2 -> System.out.println("El Resultado de la resta es:" + resta(a, b));
                case 3 -> System.out.println("El Resultado de la multiplicacion es:" + multiplicacion(a, b));
                case 4 -> System.out.println(division(a, b));
                case 5 -> salir = false;

            default -> System.out.println("Opcion no disponible intente denuevo");


            }
        }
    }



    public static int suma(int a,int b){
        return a+b;
    }

    public static int resta(int a,int b){
        return a-b;
    }
    public static int multiplicacion(int a,int b){
        return a*b;
    }
    public static String  division(int a,int b){
        return  "Division Entera: "+(a/b)+"\n"+
                    "Modulo: "+(int)(a%b)+"\n"+
                    "Division Real "+((double)a/b);


    }
}
