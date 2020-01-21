package Database;

import Agenti.Agenti;
import Corsi.Corso;

import java.util.HashMap;
import java.util.Map;

public class DatabaseInMemoria {
    private Map<Integer, Agenti> agenti = new HashMap<>();
    private   Map<Integer, Corso> corsi = new HashMap<>();
    private static DatabaseInMemoria instance = new DatabaseInMemoria();

    public static DatabaseInMemoria getInstance(){
        return instance;
    }
    private DatabaseInMemoria() {
        Agenti a1 = new Agenti(1, "Tim", "Barner-Lee", "M");
        Agenti a2 = new Agenti(2, "Theodore", "Kaczynski", "M");
        Agenti a3 = new Agenti(3, "Mark", "Zuckerberg", "M");
        Agenti a4 = new Agenti(4, "Marie", "Currie", "F");
        Agenti a5 = new Agenti(5, "Nicola", "Tesla", "M");
        Agenti a6 = new Agenti(6, "Nadia", "Comaneci", "F");
        Agenti a7 = new Agenti(7, "Rosa", "Parks", "F");

        agenti.put(a1.getId(), a1);
        agenti.put(a2.getId(), a2);
        agenti.put(a3.getId(), a3);
        agenti.put(a4.getId(), a4);
        agenti.put(a5.getId(), a5);
        agenti.put(a6.getId(), a6);
        agenti.put(a7.getId(), a7);

        Corso c1 = new Corso(1, "Informatica per nabbi", "Easy", 300, 240);
        Corso c2 = new Corso(2, "Matematica per nabbi", "Medium", 356, 180);
        Corso c3 = new Corso(3, "Inglese per nabbi", "Easy", 753, 320);
        Corso c4 = new Corso(4, "Fisica per nabbi", "Hard", 123, 240);
        Corso c5 = new Corso(5, "Chimica per nabbi", "Medium", 300, 240);

        corsi.put(c1.getId(), c1);
        corsi.put(c2.getId(), c2);
        corsi.put(c3.getId(), c3);
        corsi.put(c4.getId(), c4);
        corsi.put(c5.getId(), c5);
    }

    public Map<Integer, Agenti> getAgenti() {
        return agenti;
    }

    public Map<Integer, Corso> getCorsi() {
        return corsi;
    }
}
