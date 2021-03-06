package utils;


import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

  public static void main(String[] args) {
populateTestUsers();
  }



  public static void populateTestUsers(){
    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    EntityManager em = emf.createEntityManager();

    // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
    // CHANGE the three passwords below, before you uncomment and execute the code below
    // Also, either delete this file, when users are created or rename and add to .gitignore
    // Whatever you do DO NOT COMMIT and PUSH with the real passwords

    User user = new User("user", "test1", "test1@gmail.com");
    User admin = new User("admin", "test2", "test2@gmail.com");
    User both = new User("user_admin", "test3", "test3@gmail.com");
    User tester = new User("Test", "1234");
    Event event = new Event("Hey", "Ayudi", "2022-03-24-12-00");
    Tables table = new Tables(2, "round");
    event.addTable(table);
    user.addEvent(event);
    //Event event = new Event(tester,"Hey", "Ayudi", "2022-03-24-12-00");
    User testUser = new User("testUser","test1");


    if(admin.getUserPass().equals("test")||user.getUserPass().equals("test")||both.getUserPass().equals("test"))
      throw new UnsupportedOperationException("You have not changed the passwords");

    em.getTransaction().begin();
    Role userRole = new Role("user");
    Role adminRole = new Role("admin");

    testUser.addRole(userRole);

    user.addRole(userRole);
    admin.addRole(adminRole);
    both.addRole(userRole);
    both.addRole(adminRole);
    em.persist(userRole);
    em.persist(adminRole);
    em.persist(user);
    em.persist(admin);
    em.persist(both);
    //em.persist(tester);
    //em.persist(event);
    em.persist(testUser);
    em.getTransaction().commit();
    //System.out.println("PW: " + user.getUserPass());
    System.out.println("Testing user with OK password: " + user.verifyPassword("test"));
    System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
    System.out.println("Created TEST Users");


  }

}
