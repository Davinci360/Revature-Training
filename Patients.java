public class Patients {
    private String name;
    private int age;
    private boolean vax;

    public boolean boost;

    //setter {method}
    public void setName(String newName) { //void bc nothing to return just set
        name = newName;
    }
    //getter {method}
    public String getName(){ //nothing to pass in just get
        return name;
    }
    //setter{} method
    public void setAge(int newAge){
        age = newAge;
    }
    //getter{} method
    public int getAge(){
        return age;
    }

    public void setVax(boolean vax) {
        this.vax = vax;
    }

    public static boolean isVax() {
        return false;
    }
    public void setBoost(boolean newBoost){
        boolean boost = newBoost;
    }
    public boolean isBoost() {
        return boost;
    }
}
