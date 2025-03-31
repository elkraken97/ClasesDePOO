package Hospital.Medicos;

public class MedicoGeneral {
    private String CveMG;
    private String Nombre;
    private String CedProfMG;

    public MedicoGeneral(String cveMG, String nombre, String cedProfMG) {
        CveMG = cveMG;
        Nombre = nombre;
        CedProfMG = cedProfMG;
    }

    public String getCveMG() {
        return CveMG;
    }

    public void setCveMG(String cveMG) {
        CveMG = cveMG;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCedProfMG() {
        return CedProfMG;
    }

    public void setCedProfMG(String cedProfMG) {
        CedProfMG = cedProfMG;
    }

    @Override
    public String toString() {
        return "MedicoGeneral{" +
                "CveMG='" + CveMG + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", CedProfMG='" + CedProfMG + '\'' +
                '}';
    }
}
