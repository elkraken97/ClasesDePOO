package Hospital;

public class Consultorio {
    public int NumExp;
    public String CveMG;
    public String CedPEsp;

    public Consultorio(int numExp, String cveMG, String cedPEsp) {
        NumExp = numExp;
        CveMG = cveMG;
        CedPEsp = cedPEsp;
    }
    public Consultorio(){}
    public int getNumExp() {
        return NumExp;
    }

    public void setNumExp(int numExp) {
        NumExp = numExp;
    }

    public String getCveMG() {
        return CveMG;
    }

    public void setCveMG(String cveMG) {
        CveMG = cveMG;
    }

    public String getCedPEsp() {
        return CedPEsp;
    }

    public void setCedPEsp(String cedPEsp) {
        CedPEsp = cedPEsp;
    }
}
