package Database;

import Agenti.Agenti;
import Corsi.Corsi;

import java.util.HashMap;
import java.util.Map;

public class DatabaseInMemoria {
    private Map<Integer, Agenti> agenti = new HashMap<>();
    private   Map<Integer, Corsi> corsi = new HashMap<>();
    private static DatabaseInMemoria instance = new DatabaseInMemoria();

    public static DatabaseInMemoria getInstance(){
        return instance;
    }
    private DatabaseInMemoria(){
        Agenti a1 = new Agenti(1,"Tim","Barner-Lee","M");
        Agenti a2 = new Agenti(2,"Theodore","Kaczynski","M");
        Agenti a3 = new Agenti(3,"Mark","Zuckerberg","M");
        Agenti a4 = new Agenti(4,"Marie","Currie","F");
        Agenti a5 = new Agenti(5,"Nicola","Tesla","M");
        Agenti a6 = new Agenti(6,"Nadia","Comaneci","F");
        Agenti a7 = new Agenti(7,"Rosa","Parks","F");

        agenti.put(a1.getId(),a1);
        agenti.put(a2.getId(),a2);
        agenti.put(a3.getId(),a3);
        agenti.put(a4.getId(),a4);
        agenti.put(a5.getId(),a5);
        agenti.put(a6.getId(),a6);
        agenti.put(a7.getId(),a7);

        Corsi c1 = new Corsi(1,"Informatica per nabbi","Easy",300,240);
        Corsi c2 = new Corsi(2,"Matematica per nabbi","Medium",356,180);
        Corsi c3 = new Corsi(3,"Inglese per nabbi","Easy",753,320);
        Corsi c4 = new Corsi(4,"Fisica per nabbi","Hard",123,240);
        Corsi c5 = new Corsi(5,"Chimica per nabbi","Medium",300,240);
    }

    public Map<Integer, Agenti> getAgenti() {
        return agenti;
    }

    public Map<Integer, Corsi> getCorsi() {
        return corsi;
    }
}
