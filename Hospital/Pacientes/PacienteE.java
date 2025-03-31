package Hospital.Pacientes;

import java.time.LocalDateTime;
import java.util.Date;

public class PacienteE extends PacienteG{

    public String cveEsp;
    public Date Fecha;
    public LocalDateTime Hora;

    public PacienteE(int numExp, String nom, String cveEsp, Date fecha, LocalDateTime hora) {
        super(numExp, nom);
        this.cveEsp = cveEsp;
        Fecha = fecha;
        Hora = hora;
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

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public LocalDateTime getHora() {
        return Hora;
    }

    public void setHora(LocalDateTime hora) {
        Hora = hora;
    }

    @Override
    public String toString() {
        return "PacienteE{" +
                "cveEsp='" + cveEsp + '\'' +
                ", Fecha=" + Fecha +
                ", Hora=" + Hora +
                '}';
    }
}
