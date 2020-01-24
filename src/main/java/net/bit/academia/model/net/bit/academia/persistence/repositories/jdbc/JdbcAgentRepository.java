package net.bit.academia.model.net.bit.academia.persistence.repositories.jdbc;


import net.bit.academia.model.Agent;
import net.bit.academia.model.net.bit.academia.persistence.repositories.abstractions.AgentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JdbcAgentRepository implements AgentRepository {
    public static final String INSERT_AGENT = "INSERT INTO agent(FIRSTNAME, LASTNAME, SEX) VALUES (?, ?, ?)";
    public static final String DELETE_AGENT = "DELETE FROM agent WHERE id=?";
    public static final String UPDATE_AGENT = "UPDATE agent SET firstname=?, lastname=?, sex=? WHERE id=?";
    public static final String ALL_AGENT= "SELECT id, firstname, lastname, sex FROM agent";
    public static final String SRC_BY_LASTNAME= ALL_AGENT + " WHERE lastname LIKE ?";

    @Override
    public Agent create(Agent toInsert) {
        try(Connection con = ConnectionFactory.createConnection();
            PreparedStatement ps =  con.prepareStatement(INSERT_AGENT)) {
            ps.setString(1, toInsert.getFirstname());
            ps.setString(2, toInsert.getLastname());
            ps.setString(3, toInsert.getSex());
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                toInsert.setId(generatedKeys.getInt(1));
            }
            return toInsert;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(int agentID) {
        try(Connection con = ConnectionFactory.createConnection();
            PreparedStatement ps =  con.prepareStatement(DELETE_AGENT)) {
            ps.setInt(1, agentID);
            int rows =ps.executeUpdate();
            return rows!= 0 ;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int agentID, Agent toUpdate) {
        try(Connection con = ConnectionFactory.createConnection();
            PreparedStatement ps =  con.prepareStatement(UPDATE_AGENT)) {
            ps.setString(1, toUpdate.getFirstname());
            ps.setString(1, toUpdate.getLastname());
            ps.setString(1, toUpdate.getSex());
            ps.setInt(1, agentID);
            int rows =ps.executeUpdate();
            return rows!=0 ;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Collection<Agent> getAll() {
        try(Connection con = ConnectionFactory.createConnection();
            Statement st =con.createStatement()){
            ResultSet rs =st.executeQuery(ALL_AGENT);
            return readResult(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Agent> getByLastNameLike(String pattern) {
        try(Connection con = ConnectionFactory.createConnection();
            PreparedStatement st =con.prepareStatement(SRC_BY_LASTNAME)){
            st.setString(1,"%"+pattern+"%");
            ResultSet rs= st.executeQuery();
            return readResult(rs);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Agent getAgentiById(int id) {
        return null;
    }

    private List<Agent> readResult(ResultSet rs) throws SQLException{
        List<Agent> agenti = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String lastname = rs.getString("lastname");
            String firstname = rs.getString("firstname");
            String sex  = rs.getString("sex");
            Agent a = new Agent(id, firstname, lastname, sex);
            agenti.add(a);
        }
        return agenti;
    }
}