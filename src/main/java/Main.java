import Agenti.Agente;
import Database.*;
import Interfaccia.InterfacciaUtente;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        InterfacciaUtente i = new InterfacciaUtente(new JdbcAgentRepository(),
                new JdbcCourseRepository());
        i.start();


    }

}
