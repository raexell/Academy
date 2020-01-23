package Database;

import Agenti.Agente;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

public class JdbcAgentRepository implements AgentRepository {

    @Override
    public Agente create(Agente toInsert) {
        return null;
    }

    @Override
    public boolean delete(int agentID) {
        return false;
    }

    @Override
    public boolean update(int agentID, Agente toUpdate) {
        return false;
    }

    @Override
    public Collection<Agente> getAll() {
        try(Connection con = ConnectionFactory.createConnection()){

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Agente> getByLastNameLike(String pattern) {
        return null;
    }

    @Override
    public Agente getAgentiById(int id) {
        return null;
    }
}
