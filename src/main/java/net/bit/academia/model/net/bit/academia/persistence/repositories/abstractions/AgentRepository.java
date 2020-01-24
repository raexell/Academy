package net.bit.academia.model.net.bit.academia.persistence.repositories.abstractions;

import net.bit.academia.model.Agent;

import java.util.Collection;

public interface AgentRepository {
    Agent create(Agent toInsert);
    boolean delete(int agentID);
    boolean update(int agentID, Agent toUpdate);
    Collection<Agent> getAll();
    Collection<Agent> getByLastNameLike(String pattern);
    Agent getAgentiById(int id);
}
