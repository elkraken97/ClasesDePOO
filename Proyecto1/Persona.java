package Proyecto1;

public class Persona {

    private String nom;
    private Persona persona;

    public Persona(String nom, Persona persona) {
        this.nom = nom;
        this.persona = persona;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return   "Nombre:" + nom + '\n' +
                " apunta a:" + persona ;




    }
}
