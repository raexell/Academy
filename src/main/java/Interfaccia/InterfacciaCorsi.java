package Interfaccia;


import Corsi.Corso;
import Database.InMemoryRepositoryCorsi;
import Database.RepositoryCorsi;
import static java.lang.System.*;

import java.util.Collection;
import java.util.Scanner;

    public class InterfacciaCorsi {
        private RepositoryCorsi courses = new InMemoryRepositoryCorsi();
        public void startCorsi(){
            int countCorso = 5;
            int sceltaCorso = 0;
            int currentID=0;
            while(sceltaCorso != 9){

                out.println("Scegli cosa vuoi fare: ");
                out.println("1. Inserisci nuovo corso.");
                out.println("2. Modifica corso.");
                out.println("3. Elimina corso.");
                out.println("4. Visualizza tutti i corsi.");

                Scanner input = new Scanner(System.in);
                sceltaCorso = input.nextInt();
                input.nextLine();
                Collection<Corso> cc ;
                switch (sceltaCorso) {
                    case 1:
                        countCorso++;
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
                        Corso nuovocorso = new Corso(countCorso, titoloCorso, descrizioneCorso, costo, durataOre);
                        courses.create(nuovocorso);
                        cc = courses.getAll();
                        cc.forEach(System.out::println);
                        break;

                    case 2:
                        cc = courses.getAll();
                        cc.forEach(System.out::println);
                        out.print("Inserisci ID del corso che vuoi modificare: ");
                        currentID = input.nextInt();
                        input.nextLine();
                        Corso found = courses.findByID(currentID);
                        if(found == null){
                            out.println("Il corso con questo ID non esiste.");
                            break;
                        }
                        out.println(found);
                        Corso newcorso = new Corso();
                        newcorso.setId(found.getId());
                        out.println("Inserisci nuovo titolo o lascia vuoto:");
                        String newtitle = input.nextLine();
                        newcorso.setTitle(!newtitle.isEmpty()? newtitle : found.getTitle());
                        //descrizione
                        out.println("Inserisci nuova descrizione o lascia vuoto:");
                        String newdesc = input.nextLine();
                        newcorso.setDescription(!newdesc.isEmpty()? newdesc : found.getDescription());
                        //costo
                        out.println("Inserisci nuovo costo o un numero negativo per lasciare invariato:");
                        double newcost = input.nextDouble();
                        input.nextLine();
                        newcorso.setCost(newcost >= 0 ? newcost : found.getCost());
                        //numeroore
                        out.println("Inserisci numero ore o 0 per lasciare invariato:");
                        int newdurataore = input.nextInt();
                        newcorso.setTitle(!newtitle.isEmpty()? newtitle : found.getTitle());
                        courses.update(currentID, newcorso);
                        break;

                    case 3:
                        cc = courses.getAll();
                        cc.forEach(System.out::println);
                        out.print("Inserisci ID del corso che vuoi eliminare: ");
                        currentID = input.nextInt();
                        input.nextLine();
                        if(currentID>countCorso) {
                            out.println("Il corso con questo ID non esiste.");
                            break;
                        }
                        courses.delete(currentID);
                        countCorso--;
                        break;
                    case 4:
                        out.println("Ecco la lista dei corsi");
                        out.println();
                        Collection<Corso> cc1 = courses.getAll();
                       // cc.forEach(c -> System.out.println(c));
                        cc1.forEach(System.out::println);
                        break;
                    default:
                        System.out.println("inserisci un numero tra 0 e 9");
                        break;
                }

            }}
    }



