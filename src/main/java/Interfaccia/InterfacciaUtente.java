package Interfaccia;

import Agenti.Agente;
import Corsi.Corso;
import Database.AgentRepository;
import Database.CourseRepository;
import Database.InMemoryRepositoryAgent;
import Database.InMemoryRepositoryCorsi;

import java.util.Collection;
import java.util.Scanner;

import static java.lang.System.out;

public class InterfacciaUtente {

    private AgentRepository agentRepo = new InMemoryRepositoryAgent();
    private CourseRepository courses = new InMemoryRepositoryCorsi();
    private Scanner input = new Scanner(System.in);
    public void start(){

        int scelta1 = 0;
        String nome;
        String cognome;
        String sex;
        Agente a;
        int currentID;

        Collection<Agente> ca;
        Collection<Corso> cc ;
        while (scelta1 != 9) {
            System.out.println("Scegli cosa vuoi fare:");
            System.out.println("1. Inserisci un nuovo impiegato");
            System.out.println("2. Modifica un impiegato");
            System.out.println("3. Elimina un impiegato");
            System.out.println("4. Visualizza tutti gli impiegati");
            System.out.println("");
            System.out.println("5. Inserisci un nuovo corso");
            System.out.println("6. Modifica un corso");
            System.out.println("7. Elimina un corso");
            System.out.println("8. Visualizza tutti i corso");
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
                    a = new Agente(0,nome,cognome,sex);
                    agentRepo.create(a);
                    ca = agentRepo.getAll();
                    ca.forEach(System.out::println);
                    break;
                case 2:
                    ca = agentRepo.getAll();
                    ca.forEach(System.out::println);
                    System.out.print("Inserisci ID dell'agente che vuoi modificare: ");
                    currentID = input.nextInt();
                    input.nextLine();
                    Agente found = agentRepo.getAgentiById(currentID);
                    if(found == null){
                        System.out.println("L'agente con questo ID non esiste.");
                        break;
                    }
                    System.out.println(found);
                    Agente newagente = new Agente();
                    newagente.setId(found.getId());
                    System.out.println("Inserisci nome o lascia vuoto:");
                    String newname = input.nextLine();
                    newagente.setFirstname(!newname.isEmpty()? newname : found.getFirstname());

                    System.out.println("Inserisci descrizione o lascia vuoto:");
                    String newsur = input.nextLine();
                    newagente.setLastname(!newsur.isEmpty()? newsur : found.getLastname());

                    System.out.println("Inserisci  o lasciare invariato:");
                    String newsex = input.nextLine();
                    newagente.setSex(!newsex.isEmpty() ? newsex : found.getSex());

                    agentRepo.update(currentID, newagente);
                    break;

                case 3:
                    ca = agentRepo.getAll();
                    ca.forEach(System.out::println);
                    System.out.print("Inserisci ID dell'agente che vuoi eliminare: ");
                    currentID = input.nextInt();
                    input.nextLine();

                    boolean wasDeleted = agentRepo.delete(currentID);
                    if(!wasDeleted) {
                        System.out.println("L'agente con questo ID non esiste.");
                    }else {
                        System.out.println("L'agente eliminato");
                    }

                    break;
                case 4:
                    System.out.println("Ecco la lista dei corsi");
                    System.out.println();
                    ca = agentRepo.getAll();
                    // cc.forEach(c -> System.out.println(c));
                    ca.forEach(System.out::println);
                    break;
                case 5:
                    out.print("Inserisci titolo corso: ");
                    String titoloCorso = input.nextLine();
                    out.print("Inserisci la durata in ore del corso: ");
                    int durataOre = input.nextInt();
                    input.nextLine();
                    out.print("Inserisci la descrizione:");
                    String descrizioneCorso = input.nextLine();
                    out.print("Inserisci il costo:");
                    double costo = input.nextDouble();
                    //input.next();
                    Corso nuovocorso = new Corso(0, titoloCorso, descrizioneCorso, costo, durataOre);
                    courses.create(nuovocorso);
                    cc = courses.getAll();
                    cc.forEach(System.out::println);
                    break;

                case 6:
                    out.println("testetestets");
                    cc = courses.getAll();
                    cc.forEach(System.out::println);
                    out.print("Inserisci ID del corso che vuoi modificare: ");
                    currentID = input.nextInt();
                    input.nextLine();
                    Corso foundcorso = courses.findByID(currentID);
                    if(foundcorso == null){
                        out.println("Il corso con questo ID non esiste.");
                        break;
                    }
                    out.println(foundcorso);
                    Corso newcorso = new Corso();
                    newcorso.setId(foundcorso.getId());
                    out.println("Inserisci nuovo titolo o lascia vuoto:");
                    String newtitle = input.nextLine();
                    newcorso.setTitle(!newtitle.isEmpty()? newtitle : foundcorso.getTitle());
                    //descrizione
                    out.println("Inserisci nuova descrizione o lascia vuoto:");
                    String newdesc = input.nextLine();
                    newcorso.setDescription(!newdesc.isEmpty()? newdesc : foundcorso.getDescription());
                    //costo
                    out.println("Inserisci nuovo costo o un numero negativo per lasciare invariato:");
                    double newcost = input.nextDouble();
                    input.nextLine();
                    newcorso.setCost(newcost >= 0 ? newcost : foundcorso.getCost());
                    //numeroore
                    out.println("Inserisci numero ore o 0 per lasciare invariato:");
                    int newdurataore = input.nextInt();
                    newcorso.setTitle(!newtitle.isEmpty()? newtitle : foundcorso.getTitle());
                    courses.update(currentID, newcorso);
                    break;

                case 7:
                    cc = courses.getAll();
                    cc.forEach(System.out::println);
                    out.print("Inserisci ID del corso che vuoi eliminare: ");
                    currentID = input.nextInt();
                    input.nextLine();

                    boolean wasDeletedCourse = courses.delete(currentID);
                    if(!wasDeletedCourse){
                        System.out.println("L'agente con questo ID non esiste.");
                    }else {
                        System.out.println("L'agente eliminato");
                    }
                    break;
                case 8:
                    out.println("Ecco la lista dei corsi");
                    out.println();
                    cc = courses.getAll();
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
