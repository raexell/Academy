package Database;

import Agenti.Agente;

import java.util.Map;

public interface Database {
     Map<Integer, Agente> getAgentMap();

     void loadData() throws DataExeption;

}
