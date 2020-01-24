package net.bit.academia.model.net.bit.academia.persistence.repositories.abstractions;



import net.bit.academia.model.Agent;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractMapAgentRepository implements AgentRepository {
    private Database data= loadDatabase();

    public abstract Database loadDatabase();

    @Override
    public Agent create(Agent toInsert) {
        Map<Integer, Agent> agents = data.getAgentMap();
        int maxKey = agents.keySet().stream().mapToInt(Integer::intValue).max().orElse(0);
        toInsert.setId(++maxKey);
        agents.put(toInsert.getId(),toInsert);
        return toInsert;
    }

    @Override
    public boolean delete(int agentID) {
        Map<Integer, Agent> agents = data.getAgentMap();
        Agent x = agents.remove(agentID);
        return x != null;
    }

    @Override
    public boolean update(int agentID, Agent toUpdate) {
        Map<Integer, Agent> agents = data.getAgentMap();
        Agent old= agents.replace(agentID,toUpdate);
        return old != null;
    }

    @Override
    public Collection<Agent> getAll() {
        Map<Integer, Agent> agents = data.getAgentMap();
        return agents.values();
    }

    @Override
    public Collection<Agent> getByLastNameLike(String pattern) {
        return data.getAgentMap()
                .values().stream()
                .filter(a -> a.getLastname().contains(pattern))
                .collect(Collectors.toList());
    }

    @Override
    public Agent getAgentiById(int id) {
        return data.getAgentMap().get(id);
    }




}
