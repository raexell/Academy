package Database;

import Agenti.Agente;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DatabaseInFile {
    //private DatabaseInMemoria data = DatabaseInMemoria.getInstance();
    private File agentRepo = new File(
            getClass().getClassLoader().getResource("database.properties").getFile()
    );
    private Map<Integer, Agente> agentMap = new HashMap<>();

    public Map<Integer, Agente> parseFile() {

        if (agentRepo == null) return null;

        try {FileReader reader = new FileReader(agentRepo);

             BufferedReader br = new BufferedReader(reader);

            String line;
            String agentId="";
            String agentNome="";
            String agentCognome="";
            String agentSesso="";

            while ((line = br.readLine()) != null) {
                String[] parsed= line.split(",");
                for(int i=0; i<parsed.length;i++){
                    switch(i){
                        case 0:
                            agentId=parsed[i];
                            break;
                        case 1:
                            agentNome=parsed[i];
                            break;
                        case 2:
                            agentCognome=parsed[i];
                            break;
                        case 3:
                            agentSesso=parsed[i];
                            break;

                    }
                    Agente a = new Agente(Integer.parseInt(agentId),agentNome,agentCognome,agentSesso);
                    agentMap.put(a.getId(),a);
                }
            }
        }catch (IOException e){

        }
        return agentMap;
    }

    public File getRepo(){
        return this.agentRepo;
    }

    public void printFile(File file) throws IOException {
        if (file == null) return;

        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

}
