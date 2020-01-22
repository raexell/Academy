import Agenti.Agente;
import Database.FileRepositoryAgent;
import Database.InMemoryRepositoryAgent;
import Database.InMemoryRepositoryCorsi;
import Interfaccia.InterfacciaUtente;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        InterfacciaUtente i = new InterfacciaUtente(new FileRepositoryAgent(),
                new InMemoryRepositoryCorsi());


        i.start();

    }

}
