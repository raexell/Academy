package net.bit.academia.model.net.bit.academia.persistence.repositories.jpa;

import net.bit.academia.model.Agent;
import net.bit.academia.model.net.bit.academia.persistence.repositories.abstractions.AgentRepository;

import javax.persistence.EntityManager;
import java.util.Collection;


public class AgentJPARepository implements AgentRepository {
    private EntityManager entityManager;

    public AgentJPARepository (EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Agent create(Agent toInsert) {
        entityManager.persist(toInsert);
        return toInsert;
    }

    @Override
    public boolean delete(int agentID) {
        Agent toDelete = entityManager.getReference(Agent.class,agentID);
        entityManager.remove(agentID);
        return true;
    }

    @Override
    public boolean update(int agentID, Agent toUpdate) {

        Agent updated = entityManager.merge(toUpdate);
        return true;

    }

    @Override
    public Collection<Agent> getAll() {
        return entityManager.createQuery("select a from Agent a", Agent.class)
                .getResultList();
    }

    @Override
    public Collection<Agent> getByLastNameLike(String pattern) {
        return entityManager.createQuery("select a from Agent a where a.lastname like :pattern", Agent.class)
                .setParameter("pattern","%"+pattern+"%")
                .getResultList();
    }

    @Override
    public Agent getAgentiById(int id) {
        return null;
    }
}
