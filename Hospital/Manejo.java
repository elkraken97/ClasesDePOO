package Hospital;

import Hospital.Medicos.Cirujano;
import Hospital.Medicos.MedicoGeneral;
import Hospital.Medicos.Nutriologo;
import Hospital.Medicos.Trauma;
import Hospital.Pacientes.PacienteE;
import Hospital.Pacientes.PacienteG;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manejo {

    public static List<MedicoGeneral> medicos = new ArrayList<>();
    public static List<Cirujano> cirujanos = new ArrayList<>();
    public static List<Trauma> traumatologos = new ArrayList<>();
    public static List<Nutriologo> Nutriologos = new ArrayList<>();
    public static List<PacienteG>  pacientes = new ArrayList<>();
    public static List<Consultorio>  consultas = new ArrayList<>();
    public static void main(String[] args) {
        boolean salir = true;
        Scanner sc = new Scanner(System.in);
        while(salir){
            System.out.println("""
                    1.-Registro
                    2.-Mostrar Datos
                    3.-Salir
                    """);
            int op = sc.nextInt();
            switch (op){
                case 1:
                    MenuRegistro(sc);
                case 5:
                    salir = false;
                default:
                    System.out.println("Opcion no disponible");
            }
        }
    }

    private static void MenuRegistro(Scanner sc) {

        System.out.println("""
                ¿Que desea registrar?
                1.-Medicos
                2.-Pacientes
                3.-Consultas
                """);
        int op = sc.nextInt();
        switch (op){
            case 1->RegistroMedicos(sc);
            case 2->RegistroPacientes(sc);
            case 3->RegistrarConsulta(sc);
            default -> System.out.println("Opcion no disponible");
        }


    }

    private static void RegistrarConsulta(Scanner sc) {
        if(!pacientes.isEmpty()){
            Consultorio consulta = new Consultorio();
            System.out.println("Ingrese el numero de expediente del paciente");
            int numero = sc.nextInt();
            PacienteE pacienteEsp = null;
            for (PacienteG paciente : pacientes) {
                if (paciente.getNumExp() == numero) {
                    pacienteEsp = (PacienteE)paciente;
                    consulta.setNumExp(paciente.getNumExp());
                    break;
                }
            }
            if (pacienteEsp == null) {
                System.out.println("No existe ese paciente intente denuevo ");
            } else {

                System.out.println("Ingrese el nombre de su especialidad a consultar 1.-Nutriologo 2.- Cirujano 3.-Traumatologo 4.- Medico general");
                int nomEsp = sc.nextInt();
                switch (nomEsp) {
                    case 1:

                        System.out.println("Nutriologos:");
                        int i = 0;
                        for (Nutriologo nutriologo : Nutriologos) {
                            i++;
                            System.out.println("Nutriologo "+i+" :");
                            System.out.println(nutriologo.toString());
                        }

                        break;
                    case 2:
                        System.out.println("Cirujanos:");
                        int a = 0;
                        for (Cirujano cirujano : cirujanos) {
                            a++;
                            System.out.println("Nutriologo "+a+" :");
                            System.out.println(cirujano.toString());
                        }
                        break;
                    case 3:
                        System.out.println("Traumatologos");
                            int e = 0;
                            for (Trauma traumatologo : traumatologos) {
                                e++;
                                System.out.println("Traumatologo "+e+" :");
                                System.out.println(traumatologo.toString());
                            }
                        System.out.println("Ingrese el numero del medico que se va asignar al paciente");
                        int med = sc.nextInt();
                        pacienteEsp.setCveEsp(traumatologos.get(med).getCveEsp());
                        break;
                    case 4:
                        System.out.println("Medicos:");
                        int o = 0;
                        for (MedicoGeneral medico : medicos) {
                            System.out.println("Medicos "+o+" :");
                            System.out.println(medico.toString());
                        }
                        System.out.println("Ingrese el numero del medico que se va asignar al paciente");
                        int gen = sc.nextInt();
                        pacienteEsp.setCveEsp(((Trauma)medicos.get(gen)).getCveEsp());
                        break;
                    default:
                        System.out.println("Ese tipo de doctor no se puede registrar");
                }
            }

        }else{
            System.out.println("No hay pacientes regsitrados registre uno para registrarlo en una consulta");
        }

    }


    private static void RegistroPacientes(Scanner sc) {
        System.out.println("Ingrese el nombre del paciente");
        String nom = sc.nextLine();
        System.out.println("Ingrese el numero de expendiente");
        int num = sc.nextInt();
        pacientes.add(new PacienteE(num,nom));
        System.out.println("Paciente registrado");
    }

    private static void RegistroMedicos(Scanner sc) {
        System.out.println("Ingrese el nombre del medico");
        String nombre = sc.nextLine();
        System.out.println("Ingrese su Cedula de Medico General");
        String cve = sc.nextLine();
        System.out.println("Ingrese su celdula profesional");
        String cedula = sc.nextLine();
        System.out.println("El medico tiene alguna especialidad 1:Si 2:NO");
        int esp = sc.nextInt();

        if(esp == 1){
            System.out.println("Deme su cedula de la especialidad");
            String cedulaESP = sc.nextLine();
            System.out.println("INgrese la clave de su especialidad ");
            String clavEsp = sc.nextLine();
            System.out.println("Ingrese el nombre de su especialidad 1.-Nutriologo 2.- Cirujano 3.-Traumatologo");
            int nomEsp = sc.nextInt();
            switch (nomEsp){
                case 1:
                    Nutriologos.add(new Nutriologo(cve,nombre,cedula,cedulaESP,"Nutriologo",clavEsp));
                    break;
                case 2:
                    cirujanos.add(new Cirujano(cve,nombre,cedula,cedulaESP,"Cirujano",clavEsp));
                    break;
                case 3:
                    traumatologos.add(new Trauma(cve,nombre,cedula,cedulaESP,"Traumatologo",clavEsp));
                    break;
                default: System.out.println("Ese tipo de doctor no se puede registrar");
            }

            System.out.println("Medico registrado");

        }else if(esp==2){medicos.add(new MedicoGeneral(cve,nombre,cedula));
            System.out.println("Medico registrado");}

    }


}
