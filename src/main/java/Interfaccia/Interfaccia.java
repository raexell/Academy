package Interfaccia;

import Agenti.Agenti;

import java.util.Scanner;

public class Interfaccia {

    public void startAgenti(){
        Scanner input = new Scanner(System.in);
        int scelta1 = input.nextInt();
        int intidimpiegati = 0;

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
                    int id = input.nextInt();
                    System.out.print("");
                    String nome = input.nextLine();
                    System.out.print("");
                    String cognome = input.nextLine();
                    System.out.print("");
                    String sex = input.nextLine();
                    Agenti a1 = new Agenti(id,nome,cognome,sex);
            }


        }
    }
}
