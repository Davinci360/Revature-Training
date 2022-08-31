package com.revature.data;

// producing DAOs
// For projects with multiple DAOs, we can still use just one factory to produce different types of daos
// Singleton - only want one instance of the DAO
public class DaoFactory {

    private static PetDao petDao = null;
    private static PersonDao personDao = null;


    // don't have access to the constructor:
    private DaoFactory() {

    }

    // only public method in this class (So far)
    // We would also add another method like this for every dao we're producing
    public static PetDao getPetDao() {
        if(petDao == null) {
            System.out.println("This should only be called once (Pet Dao Creation)");
            // if we haven't created a pet dao yet, we do that here:
            petDao = new PetDaoImpl();
        }
        return petDao;
    }

    public static PersonDao getPersonDao() {
        if(personDao == null) {
            System.out.println("This should only run once");
            personDao = new PersonDaoImpl();
        }
        return personDao;
    }
}
