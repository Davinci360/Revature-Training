public class VaxPatients extends Patients {
    private boolean vax;

    public void setVax(boolean vax) {
        vax = true;
    }

    public static boolean isVax() {
        return vax;
    }
}
