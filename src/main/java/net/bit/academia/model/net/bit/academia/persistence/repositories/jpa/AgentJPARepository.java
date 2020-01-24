package net.bit.academia.model.net.bit.academia.persistence.repositories.jpa;

import net.bit.academia.model.Agent;
import net.bit.academia.model.net.bit.academia.persistence.repositories.abstractions.AgentRepository;

import java.util.Collection;

public class AgentJPARepository implements AgentRepository {
    @Override
    public Agent create(Agent toInsert) {
        return null;
    }

    @Override
    public boolean delete(int agentID) {
        return false;
    }

    @Override
    public boolean update(int agentID, Agent toUpdate) {
        return false;
    }

    @Override
    public Collection<Agent> getAll() {
        return null;
    }

    @Override
    public Collection<Agent> getByLastNameLike(String pattern) {
        return null;
    }

    @Override
    public Agent getAgentiById(int id) {
        return null;
    }
}
