package Interfaccia;


import net.bit.academia.model.Agent;
import net.bit.academia.model.Course;
import net.bit.academia.model.net.bit.academia.persistence.repositories.abstractions.AgentRepository;
import net.bit.academia.model.net.bit.academia.persistence.repositories.abstractions.CourseRepository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Scanner;

import static java.lang.System.out;

public class InterfacciaUtente {

   // private AgentRepository agentRepo = new InMemoryRepositoryAgent();
   private AgentRepository agentRepository;
    private CourseRepository courseRepository;
    private Scanner input = new Scanner(System.in);

    public InterfacciaUtente(AgentRepository agentRepository , CourseRepository courseRepository){
        this.agentRepository = agentRepository;
        this.courseRepository = courseRepository;
    }

    public void start(){

        int scelta1 = 0;
        String nome;
        String cognome;
        String sex;
        Agent a;
        int currentID;

        Collection<Agent> ca;
        Collection<Course> cc ;
        while (scelta1 != 9) {
            System.out.println("Scegli cosa vuoi fare:");
            System.out.println("1. Inserisci un nuovo impiegato");
            System.out.println("2. Modifica un impiegato");
            System.out.println("3. Elimina un impiegato");
            System.out.println("4. Visualizza tutti gli impiegati");
            System.out.println("");
            System.out.println("5. Inserisci un nuovo Course");
            System.out.println("6. Modifica un Course");
            System.out.println("7. Elimina un Course");
            System.out.println("8. Visualizza tutti i Course");
            System.out.println("");
            System.out.println("9. Esci");

            scelta1 = input.nextInt();
            input.nextLine();

            switch (scelta1){
                case 1 :

                    System.out.print("nome");
                    nome = input.nextLine();
                    System.out.print("cognome");
                    cognome = input.nextLine();
                    System.out.print("sesso");
                    sex = input.nextLine();
                    a = new Agent(0,nome,cognome,sex);
                    agentRepository.create(a);
                    ca = agentRepository.getAll();
                    ca.forEach(System.out::println);
                    break;
                case 2:
                    ca = agentRepository.getAll();
                    ca.forEach(System.out::println);
                    System.out.print("Inserisci ID dell'Agent che vuoi modificare: ");
                    currentID = input.nextInt();
                    input.nextLine();
                    Agent found = agentRepository.getAgentiById(currentID);
                    if(found == null){
                        System.out.println("L'Agent con questo ID non esiste.");
                        break;
                    }
                    System.out.println(found);
                    Agent newAgent = new Agent();
                    newAgent.setId(found.getId());
                    System.out.println("Inserisci nome o lascia vuoto:");
                    String newname = input.nextLine();
                    newAgent.setFirstname(!newname.isEmpty()? newname : found.getFirstname());

                    System.out.println("Inserisci descrizione o lascia vuoto:");
                    String newsur = input.nextLine();
                    newAgent.setLastname(!newsur.isEmpty()? newsur : found.getLastname());

                    System.out.println("Inserisci  o lasciare invariato:");
                    String newsex = input.nextLine();
                    newAgent.setSex(!newsex.isEmpty() ? newsex : found.getSex());

                    agentRepository.update(currentID, newAgent);
                    break;

                case 3:
                    ca = agentRepository.getAll();
                    ca.forEach(System.out::println);
                    System.out.print("Inserisci ID dell'Agent che vuoi eliminare: ");
                    currentID = input.nextInt();
                    input.nextLine();

                    boolean wasDeleted = agentRepository.delete(currentID);
                    if(!wasDeleted) {
                        System.out.println("L'Agent con questo ID non esiste.");
                    }else {
                        System.out.println("L'Agent eliminato");
                    }

                    break;
                case 4:
                    System.out.println("Ecco la lista degli impiegati");
                    System.out.println();
                    ca = agentRepository.getAll();
                    // cc.forEach(c -> System.out.println(c));
                    ca.forEach(System.out::println);
                    break;
                case 5:
                    out.print("Inserisci titolo Course: ");
                    String titoloCourse = input.nextLine();
                    out.print("Inserisci la durata in ore del Course: ");
                    int durataOre = input.nextInt();
                    input.nextLine();
                    out.print("Inserisci la descrizione:");
                    String descrizioneCourse = input.nextLine();
                    out.print("Inserisci il costo:");
                    double costo = input.nextDouble();
                    //input.next();
                    Course nuovoCourse = new Course(0, titoloCourse, descrizioneCourse, costo, durataOre);
                    courseRepository.create(nuovoCourse);
                    cc = courseRepository.getAll();
                    cc.forEach(System.out::println);
                    break;

                case 6:
                    out.println("testetestets");
                    cc = courseRepository.getAll();
                    cc.forEach(System.out::println);
                    out.print("Inserisci ID del Course che vuoi modificare: ");
                    currentID = input.nextInt();
                    input.nextLine();
                    Course foundCourse = courseRepository.findByID(currentID);
                    if(foundCourse == null){
                        out.println("Il Course con questo ID non esiste.");
                        break;
                    }
                    out.println(foundCourse);
                    Course newCourse = new Course();
                    newCourse.setId(foundCourse.getId());
                    out.println("Inserisci nuovo titolo o lascia vuoto:");
                    String newtitle = input.nextLine();
                    newCourse.setTitle(!newtitle.isEmpty()? newtitle : foundCourse.getTitle());
                    //descrizione
                    out.println("Inserisci nuova descrizione o lascia vuoto:");
                    String newdesc = input.nextLine();
                    newCourse.setDescription(!newdesc.isEmpty()? newdesc : foundCourse.getDescription());
                    //costo
                    out.println("Inserisci nuovo costo o un numero negativo per lasciare invariato:");
                    double newcost = input.nextDouble();
                    input.nextLine();
                    BigDecimal cost = new BigDecimal(newcost <= 0 ? 0.0 : newcost);
                    newCourse.setCost(cost);
                    //numeroore
                    out.println("Inserisci numero ore o 0 per lasciare invariato:");
                    int newdurataore = input.nextInt();
                    newCourse.setTitle(!newtitle.isEmpty()? newtitle : foundCourse.getTitle());
                    courseRepository.update(currentID, newCourse);
                    break;

                case 7:
                    cc = courseRepository.getAll();
                    cc.forEach(System.out::println);
                    out.print("Inserisci ID del Course che vuoi eliminare: ");
                    currentID = input.nextInt();
                    input.nextLine();

                    boolean wasDeletedCourse = courseRepository.delete(currentID);
                    if(!wasDeletedCourse){
                        System.out.println("L'Agent con questo ID non esiste.");
                    }else {
                        System.out.println("L'Agent eliminato");
                    }
                    break;
                case 8:
                    out.println("Ecco la lista dei corsi");
                    out.println();
                    cc = courseRepository.getAll();
                    // cc.forEach(c -> System.out.println(c));
                    cc.forEach(System.out::println);

                    break;
                case 9:
                    out.println("Grazie per aver partecipato");;
                    break;
                    default:
                    System.out.println("inserisci un numero tra 0 e 9");
                    break;
            }


        }
    }
}
