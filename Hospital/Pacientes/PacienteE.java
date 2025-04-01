package Hospital.Pacientes;

import java.time.LocalDateTime;
import java.util.Date;

public class PacienteE extends PacienteG{

    public String cveEsp;


    public PacienteE(int numExp, String nom, String cveEsp, Date fecha, LocalDateTime hora) {
        super(numExp, nom);
        this.cveEsp = cveEsp;

    }
    public PacienteE(int numExp, String nom) {
        super(numExp, nom);

    }

    public String getCveEsp() {
        return cveEsp;
    }

    public void setCveEsp(String cveEsp) {
        this.cveEsp = cveEsp;
    }



}
