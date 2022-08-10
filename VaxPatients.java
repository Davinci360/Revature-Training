public class VaxPatients extends Patients {
    private boolean vax;
    private boolean boost;

    public void setVax(boolean vax) {
        vax = true;
    }

    public static boolean isVax() {
        return vax;
    }
}
