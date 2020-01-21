package Interfaccia;

import Agenti.Agenti;
import Database.InMemoryRepositoryAgent;

import java.util.Collection;
import java.util.Scanner;

public class InterfacciaUtente {

    private InMemoryRepositoryAgent agentRepo = new InMemoryRepositoryAgent();
    private Scanner input = new Scanner(System.in);
    public void start(){

        int scelta1 = 0;
        String nome;
        String cognome;
        String sex;
        Agenti a;
        int currentID;

        Collection<Agenti> ca;
        while (scelta1 != 9) {
            System.out.println("Scegli cosa vuoi fare:");
            System.out.println("1. Inserisci un nuovo impiegato");
            System.out.println("2. Elimina un impiegato");
            System.out.println("3. Modifica un impiegato");
            System.out.println("4. Visualizza tutti gli impiegati");
            System.out.println("");
            System.out.println("5. Inserisci un nuovo corso");
            System.out.println("6. Elimina un corso");
            System.out.println("7. Modifica un corso");
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
                    a = new Agenti(0,nome,cognome,sex);
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
                    Agenti found = agentRepo.getAgentiById(currentID);
                    if(found == null){
                        System.out.println("L'agente con questo ID non esiste.");
                        break;
                    }
                    System.out.println(found);
                    Agenti newagente = new Agenti();
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
                    Collection<Agenti> cc1 = agentRepo.getAll();
                    // cc.forEach(c -> System.out.println(c));
                    cc1.forEach(System.out::println);
                    break;
                default:
                    System.out.println("inserisci un numero tra 0 e 9");
                    break;
            }


        }
    }
}
