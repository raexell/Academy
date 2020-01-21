package Database;

import Agenti.Agenti;

import java.util.Collection;

public interface AgentRepository {
    Agenti create(Agenti toInsert);
    boolean delete(int agentID);
    boolean update(int agentID, Agenti toUpdate);
    Collection<Agenti> getAll();
    Collection<Agenti> getByLastNameLike(String pattern);
    Agenti getAgentiById(int id);
}
