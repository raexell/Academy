package Database;

import Agenti.Agente;

import java.util.Collection;

public interface AgentRepository {
    Agente create(Agente toInsert);
    boolean delete(int agentID);
    boolean update(int agentID, Agente toUpdate);
    Collection<Agente> getAll();
    Collection<Agente> getByLastNameLike(String pattern);
    Agente getAgentiById(int id);
}
