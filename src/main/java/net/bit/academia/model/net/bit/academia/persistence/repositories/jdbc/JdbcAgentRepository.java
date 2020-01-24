package net.bit.academia.model.net.bit.academia.persistence.repositories.jdbc;


import net.bit.academia.model.Agent;
import net.bit.academia.model.net.bit.academia.persistence.repositories.abstractions.AgentRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

public class JdbcAgentRepository implements AgentRepository {

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
        try(Connection con = ConnectionFactory.createConnection()){

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
