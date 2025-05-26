package Hospital;

import javax.naming.ldap.Control;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

class MedicoGeneral{
    private String cveMG;
    private String nombre;
    private String codProfMG;
    private MedicoGeneral m;
    public MedicoGeneral(String cveMG, String nombre, String codProfMG) {
        this.cveMG = cveMG;
        this.nombre = nombre;
        this.codProfMG = codProfMG;
    }

    public MedicoGeneral getM() {
        return m;
    }

    public void setM(MedicoGeneral m) {
        this.m = m;
    }

    public String getNombre() {
        return nombre;
    }



    public String getCveMG() {
        return cveMG;
    }


    public String getCodProfMG() {
        return codProfMG;
    }



    @Override
    public String toString() {
        return "MedicoGeneral{" +
                "cveMG='" + cveMG + '\'' +
                ", nombre='" + nombre + '\'' +
                ", codProfMG='" + codProfMG + '\'' +
                '}';
    }


}

class MedicoEspecialista extends MedicoGeneral{

    private String CedPME;
    private String CveEsp;

    public MedicoEspecialista(String cveMG, String nombre, String codProfMG, String cedPME, String cveEsp) {
        super(cveMG, nombre, codProfMG);
        CedPME = cedPME;
        CveEsp = cveEsp;
    }


    @Override
    public String toString() {

        return "MedicoEspecialista{" +
                "cveMG='" + super.getCveMG() + '\'' +
                ", nombre='" + super.getNombre() + '\'' +
                ", codProfMG='" + super.getCodProfMG() + '\'' +
                '}'+
                "CedPME='" + CedPME + '\'' +
                ", CveEsp='" + CveEsp + '\'' +
                '}';
    }
}
class Paciente {
    private int NoExpediente;
    private String NombrePaciente;
    private Paciente list;
    private LocalDateTime fecha;
    private Paciente nuevo;
    public Paciente(int noExpediente, String nombrePaciente ) {
        NoExpediente = noExpediente;
        NombrePaciente = nombrePaciente;



    }


    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Paciente getNuevo() {
        return nuevo;
    }

    public void setNuevo(Paciente nuevo) {
        this.nuevo = nuevo;
    }


    public String getNombrePaciente() {
        return NombrePaciente;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "NoExpediente=" + NoExpediente +
                ", NombrePaciente='" + NombrePaciente + '\'' +
                ", list=" + list +
                ", fecha=" + fecha +
                '}';
    }
}

class Consultas{
    private MedicoGeneral medico;
    private Paciente p;
    private LocalDateTime fecha;
    private Consultas consulta;

    public Consultas(MedicoGeneral medico, Paciente p, LocalDateTime fecha) {
        this.medico = medico;
        this.p = p;
        this.fecha = fecha;

    }

    public Consultas getConsulta() {
        return consulta;
    }

    public void setConsulta(Consultas consulta) {
        this.consulta = consulta;
    }

    @Override
    public String toString() {
        return "Consultas{" +
                "paciente=" + p.getNombrePaciente() +
                ", fecha=" + fecha +
                ", medico=" + medico.getNombre() +
                '}';
    }
}

class ControladorHospital{


    private Paciente cabeza;
    private Paciente cola;
    private MedicoGeneral cabezaM;
    private  MedicoGeneral colaM;
    private Consultas cabezaC;
    private Consultas colaC;
    private static boolean ejecutadoPacientes = false;
    private static boolean ejecutadoDoctores = false;
    private static boolean ejecutadoConsultas = false;

    public void AgregarConsulta(Consultas c){
        if(!ejecutadoConsultas){
            cabezaC = c;
            colaC = cabezaC;
            ejecutadoConsultas = true;
        }else{
            colaC.setConsulta(c);
            colaC = c;
        }

    }


    public void AgregarPaciente(Paciente n){
        if(!ejecutadoPacientes){
           cabeza = n;
           cola = cabeza;
            ejecutadoPacientes = true;
        }else{
        cola.setNuevo(n);
        cola = n;
        }

    }

    public void AgregarDoctor(MedicoGeneral m){
        if(!ejecutadoDoctores){
            cabezaM = m;
            colaM = cabezaM;
            ejecutadoDoctores = true;
        }else{
            colaM.setM(m);
            colaM = m;
        }
    }

    public void ListarPacientes(){
        System.out.println("Pacientes:");
        Paciente p = cabeza;
        while(p!=null){
            System.out.println(p);
            p = p.getNuevo();
        }
    }
    public void ListarDoctores(){
        System.out.println("Medicos:");
        MedicoGeneral p = cabezaM;
        while(p!=null){
            if(p instanceof MedicoEspecialista){

                System.out.println((MedicoEspecialista) p);}
            else{
                System.out.println(p);
            }
            p = p.getM();
        }
    }
    public void ListarConsultas(){
        System.out.println("Consultas:");
        Consultas c = cabezaC;
        while(c!=null){
            System.out.println(c);
            c = c.getConsulta();
        }
    }
    public Paciente BuscarPaciente(String nombre){

        Paciente p = cabeza;
        while(p!=null){

            if(Objects.equals(p.getNombrePaciente(), nombre)){
                return p;
            }
            p=p.getNuevo();
        }
        return null;
    }
    public MedicoGeneral BuscarMedico(String nombre){

        MedicoGeneral p = cabezaM;
        while(p!=null){

            if(Objects.equals(p.getNombre(), nombre)){
                return p;
            }
            p=p.getM();
        }
        return null;
    }
    public void ficharCita(LocalDateTime d,String nombre){
        ListarPacientes();
        Paciente p = cabeza;
        while(p!=null){

            if(Objects.equals(p.getNombrePaciente(), nombre)){
               p.setFecha(d);
            }
            p=p.getNuevo();
        }

    }

}

public class Hospital {

    public static void main(String[] args) {
        ControladorHospital control = new ControladorHospital();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        while(!salir){
            System.out.println("""
                    Bienvenido al hospital que desea hacer?
                    1.-Registrar un paciente
                    2.-Registrar un medico
                    3.-Registrar una cita
                    4.-Mostrar todos los datos
                    5.-salir
                    """);
            int op = scanner.nextInt();
            switch (op){
                case 1:
                    System.out.print("Numero de expediente: ");
                    int expediente = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer

                    System.out.print("Nombre del paciente: ");
                    String nombre = scanner.nextLine();
                    control.AgregarPaciente(new Paciente(expediente,nombre));
                    System.out.println("paciente agregado");
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Ingrese la clave del medico: ");
                    String cveMG = scanner.nextLine();

                    System.out.println("Ingrese el nombre del medico: ");
                    String nombreMedico = scanner.nextLine();

                    System.out.println("Ingrese el codigo profesional del medico: ");
                    String codProfMG = scanner.nextLine();

                    System.out.println("¿El medico es especialista? (1. Si / 2. No)");
                    int opcion = scanner.nextInt();
                    scanner.nextLine();



                    if (opcion == 1) {
                        System.out.println("Ingrese la cedula profesional del medico especialista: ");
                        String cedPME = scanner.nextLine();

                        System.out.println("Ingrese la clave de la especialidad: ");
                        String cveEsp = scanner.nextLine();

                        control.AgregarDoctor(new MedicoEspecialista(cveMG, nombreMedico, codProfMG, cedPME, cveEsp));
                    } else {
                        control.AgregarDoctor(new MedicoGeneral(cveMG,nombreMedico,codProfMG));
                    }

                    System.out.println("Medico registrado:");

                    break;
                case 3:
                    scanner.nextLine();

                    System.out.print("Ingrese la fecha de la consulta (MM-dd HH:mm): ");
                    String fechaStr = scanner.nextLine();

                    int anioActual = LocalDateTime.now().getYear();
                    String fechaCompletaStr = anioActual + "-" + fechaStr;

                    LocalDateTime fechaConsulta = LocalDateTime.parse(fechaCompletaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                    control.ListarDoctores();
                    System.out.println("Ingrese el nombre del doctor que atendera");
                    MedicoGeneral m =  control.BuscarMedico(scanner.nextLine());
                    control.ListarPacientes();
                    System.out.println("Ingrese el nombre del paciente");
                    String nom = scanner.nextLine();
                    Paciente p = control.BuscarPaciente(nom);

                    control.AgregarConsulta(new Consultas(m,p,fechaConsulta));
                    control.ficharCita(fechaConsulta,nom);


                    System.out.println("Consulta agendada con exito.");
                    break;
                case 4:
                    control.ListarPacientes();
                    control.ListarDoctores();
                    control.ListarConsultas();
                    break;
                default:
                    System.out.println("opcion no disponible");

            }
        }
    }


}
