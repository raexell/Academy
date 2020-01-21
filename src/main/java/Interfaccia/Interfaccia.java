package Interfaccia;

import Agenti.Agenti;
import Database.InMemoryRepositoryAgent;

import java.util.Scanner;

public class Interfaccia {

    public void startAgenti(){
        Scanner input = new Scanner(System.in);
        int scelta1 = input.nextInt();
        InMemoryRepositoryAgent imra = new InMemoryRepositoryAgent();
        int id;
        String nome;
        String cognome;
        String sex;
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

            switch (scelta1){
                case 1 :
                    System.out.print("");
                    id = input.nextInt();
                    System.out.print("");
                    nome = input.nextLine();
                    System.out.print("");
                    cognome = input.nextLine();
                    System.out.print("");
                    sex = input.nextLine();
                    Agenti a = new Agenti(id,nome,cognome,sex);
                    imra.create(a);
                case 2:
                    System.out.print("");
                    id = input.nextInt();
                    imra.delete(id);
                case 3:
                    System.out.print("");
                    id
            }


        }
    }
}
