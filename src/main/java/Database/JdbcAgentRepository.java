package Database;

import Agenti.Agente;

import java.sql.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class JdbcAgentRepository implements AgentRepository {
    private Map<Integer, Agente> agenti = new HashMap<>();
    @Override
    public Agente create(Agente toInsert) {
        final String INSERT_AGENT = "INSERT INTO agent(FIRSTNAME, LASTNAME, SEX) VALUES (?, ?, ?)";
        try(Connection con = ConnectionFactory.createConnection();
            PreparedStatement ps =  con.prepareStatement(INSERT_AGENT)) {
            ps.setString(1, toInsert.getFirstname());
            ps.setString(2, toInsert.getLastname());
            ps.setString(3, toInsert.getSex());
            ps.executeUpdate();
            return toInsert;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(int agentID) {
        final String DELETE_AGENT = "DELETE FROM agent WHERE id=?";
        try(Connection con = ConnectionFactory.createConnection();
            PreparedStatement ps =  con.prepareStatement(DELETE_AGENT)) {
            ps.setInt(1, agentID);
            ps.executeUpdate();
            return true ;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int agentID, Agente toUpdate) {
        final String UPDATE_AGENT = "UPDATE agent SET firstname=?, lastname=?, sex=? WHERE id=?";
        try(Connection con = ConnectionFactory.createConnection();
            PreparedStatement ps =  con.prepareStatement(UPDATE_AGENT)) {
            ps.setString(1, toUpdate.getFirstname());
            ps.setString(1, toUpdate.getLastname());
            ps.setString(1, toUpdate.getSex());
            ps.setInt(1, agentID);
            ps.executeUpdate();
            return true ;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Collection<Agente> getAll() {
        final String ALL_AGENT= "SELECT id, firstname, lastname, sex FROM agent";

        try(Connection con = ConnectionFactory.createConnection();
            Statement st =con.createStatement()){
            ResultSet rs =st.executeQuery(ALL_AGENT);
            while (rs.next()){
                int id = rs.getInt("id");
                String lastname = rs.getString("lastname");
                String firstname = rs.getString("firstname");
                String sex  = rs.getString("sex");
                Agente a = new Agente(id, firstname, lastname, sex);
                agenti.put(a.getId(), a);
            }
            return agenti.values();
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