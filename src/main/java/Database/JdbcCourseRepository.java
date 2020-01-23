package Database;

import Agenti.Agente;
import Corsi.Corso;

import java.sql.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JdbcCourseRepository implements CourseRepository {

    private Map<Integer, Corso> corsi = new HashMap<>();

    @Override
    public Corso create(Corso toInsert) {
        final String insQuery = "insert into course(title, description, cost, numHours) values (?, ?, ?, ?)";
        try(Connection con = ConnectionFactory.createConnection();
            PreparedStatement st = con.prepareStatement(insQuery)){
            st.setString(1, toInsert.getTitle());
            st.setString(2, toInsert.getDescription());
            st.setDouble(3, toInsert.getCost());
            st.setInt(4, toInsert.getNumHours());
           st.executeUpdate();
           return toInsert;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public boolean delete(int corsiID) {
        final String delQuery = "delete from course where id = ?";
        try(Connection con = ConnectionFactory.createConnection();
            PreparedStatement st = con.prepareStatement(delQuery)){
            st.setInt(1, corsiID);
            st.executeUpdate();
            return true;
            } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int corsiID, Corso toUpdate) {
        final String updateQuery = "update course set title = ?, description = ?, cost = ?, numHours = ? where id = ?";

        try(Connection con = ConnectionFactory.createConnection();
            PreparedStatement st = con.prepareStatement(updateQuery)){
            st.setString(1, toUpdate.getTitle());
            st.setString(2, toUpdate.getDescription());
            st.setDouble(3, toUpdate.getCost());
            st.setInt(4, toUpdate.getNumHours());
            st.setInt(5, corsiID);
            st.executeUpdate();
            return true;
            }
        catch (
                SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Collection<Corso> getAll() {
        final String ALL_COURSE= "SELECT id, title, description, cost, numHours FROM course";

        try(Connection con = ConnectionFactory.createConnection();
            Statement st =con.createStatement()) {
            ResultSet rs = st.executeQuery(ALL_COURSE);
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String desc = rs.getString("description");
                double cost = rs.getDouble("cost");
                int numHours = rs.getInt("numHours");
                Corso c = new Corso(id, title, desc, cost, numHours);
                corsi.put(c.getId(), c);
            }
            return corsi.values();
        }catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Corso> getByLastNameLike(String pattern) {
        try(Connection con = ConnectionFactory.createConnection()){
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Corso findByID(int id) {
        try(Connection con = ConnectionFactory.createConnection()){
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
