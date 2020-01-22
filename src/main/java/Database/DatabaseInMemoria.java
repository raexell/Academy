package Database;

import Agenti.Agente;
import Corsi.Corso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DatabaseInMemoria {
    private static DatabaseInMemoria instance = new DatabaseInMemoria();
    private DatabaseInFile dbf = new DatabaseInFile();

    private Map<Integer, Agente> agenti = dbf.parseFile();
    private   Map<Integer, Corso> corsi = new HashMap<>();

    public static DatabaseInMemoria getInstance(){
        return instance;
    }



    private DatabaseInMemoria() {
        /*
        Agente a1 = new Agente(1,"Tim","Barner-Lee","M");
        Agente a2 = new Agente(2,"Theodore","Kaczynski","M");
        Agente a3 = new Agente(3,"Mark","Zuckerberg","M");
        Agente a4 = new Agente(4,"Marie","Currie","F");
        Agente a5 = new Agente(5,"Nicola","Tesla","M");
        Agente a6 = new Agente(6,"Nadia","Comaneci","F");
        Agente a7 = new Agente(7,"Rosa","Parks","F");

        agenti.put(a1.getId(),a1);
        agenti.put(a2.getId(),a2);
        agenti.put(a3.getId(),a3);
        agenti.put(a4.getId(),a4);
        agenti.put(a5.getId(),a5);
        agenti.put(a6.getId(),a6);
        agenti.put(a7.getId(),a7);

        Corso c1 = new Corso(1,"Informatica per nabbi","Easy",300,240);
        Corso c2 = new Corso(2,"Matematica per nabbi","Medium",356,180);
        Corso c3 = new Corso(3,"Inglese per nabbi","Easy",753,320);
        Corso c4 = new Corso(4,"Fisica per nabbi","Hard",123,240);
        Corso c5 = new Corso(5,"Chimica per nabbi","Medium",300,240);

        corsi.put(c1.getId(),c1);
        corsi.put(c2.getId(),c2);
        corsi.put(c3.getId(),c3);
        corsi.put(c4.getId(),c4);
        corsi.put(c5.getId(),c5);*/


    }


    public Map<Integer, Agente> getAgenti() {
        return agenti;
    }

    public Map<Integer, Corso> getCorsi() {
        return corsi;
    }


}
