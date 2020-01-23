package Database;

import Agenti.Agente;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryRepositoryAgent extends AbstractMapAgentRepository {

    public InMemoryRepositoryAgent() throws DataExeption {
    }

    @Override
    public Database loadDatabase() {
        return DatabaseInMemoria.getInstance();
    }
   /* private File agentRepo = new File(
            getClass().getClassLoader().getResource("database.properties").getFile()
    );*/











}
