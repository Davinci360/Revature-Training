/* ## For today's exercise
You will create a java project that makes use of Inheritance, Polymorphism, and Encapsulation
### Requirements:
1. At least 1 example of inheritance in the project (you will need at least 2 classes for this)
2. At least one class must exemplify encapsulation, preferably all of them
- All fields are private
- Public getters and setters
3. At least one example of overriding a method and one example of overloading */
public class Main {

    public static void main(String[] args) {
        Patients patient = new Patients();
        System.out.println("Hello world!");
        System.out.println(patient.getName());
        System.out.println((patient.getAge()));
        System.out.print(patient.isVax());//inheritance//override
        System.out.print(VaxPatients.isVax());//inheritance//override
        System.out.print(BoostPatients.isVax());
        System.out.print(BoostPatients.isVax());

    }
}