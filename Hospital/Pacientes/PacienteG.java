package Hospital.Pacientes;

public class PacienteG {
    private int NumExp;
    private String Nom;

    public PacienteG(int numExp, String nom) {
        NumExp = numExp;
        Nom = nom;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public int getNumExp() {
        return NumExp;
    }

    public void setNumExp(int numExp) {
        NumExp = numExp;
    }

    @Override
    public String toString() {
        return "PacienteG{" +
                "NumExp=" + NumExp +
                ", Nom='" + Nom + '\'' +
                '}';
    }
}
