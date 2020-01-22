package Database;

import Agenti.Agente;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractMapAgentRepository implements AgentRepository{
    private Database data= loadDatabase();

    public abstract Database loadDatabase();

    @Override
    public Agente create(Agente toInsert) {
        Map<Integer, Agente> agents = data.getAgentMap();
        int maxKey = agents.keySet().stream().mapToInt(Integer::intValue).max().orElse(0);
        toInsert.setId(++maxKey);
        agents.put(toInsert.getId(),toInsert);
        return toInsert;
    }

    @Override
    public boolean delete(int agentID) {
        Map<Integer, Agente> agents = data.getAgentMap();
        Agente x = agents.remove(agentID);
        return x != null;
    }

    @Override
    public boolean update(int agentID, Agente toUpdate) {
        Map<Integer, Agente> agents = data.getAgentMap();
        Agente old= agents.replace(agentID,toUpdate);
        return old != null;
    }

    @Override
    public Collection<Agente> getAll() {
        Map<Integer, Agente> agents = data.getAgentMap();
        return agents.values();
    }

    @Override
    public Collection<Agente> getByLastNameLike(String pattern) {
        return data.getAgentMap()
                .values().stream()
                .filter(a -> a.getLastname().contains(pattern))
                .collect(Collectors.toList());
    }

    @Override
    public Agente getAgentiById(int id) {
        return data.getAgentMap().get(id);
    }




}
