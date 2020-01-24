package net.bit.academia.model.net.bit.academia.persistence.repositories.inMemory;

import net.bit.academia.model.Agent;
import net.bit.academia.model.Course;
import net.bit.academia.model.net.bit.academia.persistence.repositories.abstractions.Database;

import java.util.HashMap;
import java.util.Map;

public class DatabaseInMemoria implements Database {
    private static DatabaseInMemoria instance = new DatabaseInMemoria();
   // private DatabaseInFile dbf = new DatabaseInFile();

    //private Map<Integer, Agent> agenti = dbf.parseFile();
    private Map<Integer, Agent> agenti = new HashMap<>();
    private   Map<Integer, Course> corsi = new HashMap<>();

    public static DatabaseInMemoria getInstance(){
        return instance;
    }
    private DatabaseInMemoria(){
        loadData();
    }

    @Override
    public Map<Integer, Agent> getAgentMap() {
        return agenti;
    }

    public Map<Integer, Course> getCorsi() {
        return corsi;
    }

    public void setAgenti(Map<Integer, Agent> agenti) {
        this.agenti = agenti;
    }

    public void setCorsi(Map<Integer, Course> corsi) {
        this.corsi = corsi;
    }

    public void loadData(){
        Agent a1 = new Agent(1,"Tim","Barner-Lee","M");
        Agent a2 = new Agent(2,"Theodore","Kaczynski","M");
        Agent a3 = new Agent(3,"Mark","Zuckerberg","M");
        Agent a4 = new Agent(4,"Marie","Currie","F");
        Agent a5 = new Agent(5,"Nicola","Tesla","M");
        Agent a6 = new Agent(6,"Nadia","Comaneci","F");
        Agent a7 = new Agent(7,"Rosa","Parks","F");

        agenti.put(a1.getId(),a1);
        agenti.put(a2.getId(),a2);
        agenti.put(a3.getId(),a3);
        agenti.put(a4.getId(),a4);
        agenti.put(a5.getId(),a5);
        agenti.put(a6.getId(),a6);
        agenti.put(a7.getId(),a7);

        Course c1 = new Course(1,"Informatica per nabbi","Easy",300,240);
        Course c2 = new Course(2,"Matematica per nabbi","Medium",356,180);
        Course c3 = new Course(3,"Inglese per nabbi","Easy",753,320);
        Course c4 = new Course(4,"Fisica per nabbi","Hard",123,240);
        Course c5 = new Course(5,"Chimica per nabbi","Medium",300,240);

        corsi.put(c1.getId(),c1);
        corsi.put(c2.getId(),c2);
        corsi.put(c3.getId(),c3);
        corsi.put(c4.getId(),c4);
        corsi.put(c5.getId(),c5);


    }

}
