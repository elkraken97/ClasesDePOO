package Hospital.Medicos;

public class Cirujano extends MedicoGeneral{
    private String CedPEsp;
    private String NomEsp;
    private String CveEsp;

    public Cirujano(String cveMG, String nombre, String cedProfMG, String cedPEsp, String nomEsp, String cveEsp) {
        super(cveMG, nombre, cedProfMG);
        CedPEsp = cedPEsp;
        NomEsp = nomEsp;
        CveEsp = cveEsp;
    }

    public String getCedPEsp() {
        return CedPEsp;
    }

    public void setCedPEsp(String cedPEsp) {
        CedPEsp = cedPEsp;
    }

    public String getCveEsp() {
        return CveEsp;
    }

    public void setCveEsp(String cveEsp) {
        CveEsp = cveEsp;
    }

    public String getNomEsp() {
        return NomEsp;
    }

    public void setNomEsp(String nomEsp) {
        NomEsp = nomEsp;
    }

    @Override
    public String toString() {
        return "Cirujano{" +
                "CedPEsp='" + CedPEsp + '\'' +
                ", NomEsp='" + NomEsp + '\'' +
                ", CveEsp='" + CveEsp + '\'' +
                '}';
    }
}
