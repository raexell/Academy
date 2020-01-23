package Database;

import Agenti.Agente;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DatabaseInFile implements Database{
    private DatabaseInMemoria data = DatabaseInMemoria.getInstance();
    private File agentRepo = new File(
            getClass().getClassLoader().getResource("database.csv").getFile()
    );
   // private Map<Integer, Agente> agentMap = new HashMap<>();

    private static DatabaseInFile instance;

    public static DatabaseInFile getInstance() throws DataExeption {
        if(instance==null){
            instance=new DatabaseInFile();
        }
        return instance;
    }

    private DatabaseInFile() throws DataExeption {
        loadData();
    }

    @Override
    public void loadData() throws DataExeption {

        if (agentRepo == null) return ;
        //agentMap.clear();
        Map<Integer, Agente> agents= new HashMap<>();
        try {
            FileReader reader = new FileReader(agentRepo);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                String[] parsed= line.split(",");
                Agente a = new Agente(Integer.parseInt(parsed[0]),parsed[1],parsed[2],parsed[3]);
                agents.put(a.getId(),a);
                }
            //}
            data.setAgenti(agents);
        }catch (IOException e){
            DataExeption ex = new DataExeption("Errore nella lettura da file", e );
            throw ex;
        }

    }

    @Override
    public Map<Integer, Agente> getAgentMap(){
        return data.getAgentMap();
    }

}
