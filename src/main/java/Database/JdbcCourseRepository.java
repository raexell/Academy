package Database;

import Agenti.Agente;
import Corsi.Corso;

import java.sql.*;
import java.util.*;

public class JdbcCourseRepository implements CourseRepository {
    public static final String insQuery = "insert into course(title, description, cost, numHours) values (?, ?, ?, ?)";
    public static final String delQuery = "delete from course where id = ?";
    public static final String updateQuery = "update course set title = ?, description = ?, cost = ?, numHours = ? where id = ?";
    public static final String ALL_COURSE= "SELECT id, title, description, cost, numHours FROM course";
    public static final String SRC_BY_NAME= ALL_COURSE+" WHERE title= ?";
    public static final String SRC_BY_ID= ALL_COURSE+" WHERE id= ?";
    private Connection con;

    public JdbcCourseRepository(Connection con){
        this.con=con;
    }

    @Override
    public Corso create(Corso toInsert) throws DataExeption {
        try(PreparedStatement st = con.prepareStatement(insQuery,Statement.RETURN_GENERATED_KEYS)){
            st.setString(1, toInsert.getTitle());
            st.setString(2, toInsert.getDescription());
            st.setDouble(3, toInsert.getCost());
            st.setInt(4, toInsert.getNumHours());
            st.executeUpdate();
            ResultSet generatedKeys = st.getGeneratedKeys();
            if (generatedKeys.next()) {
                toInsert.setId(generatedKeys.getInt(1));
            }
            return toInsert;
        } catch (SQLException e) {
            DataExeption ex = new DataExeption("Errore nella create del corso", e );
            throw ex;
        }
    }

    @Override
    public boolean delete(int corsiID) throws DataExeption {
        try(PreparedStatement st = con.prepareStatement(delQuery)){
            st.setInt(1, corsiID);
            int rows = st.executeUpdate();
            return rows!=0;
            } catch (SQLException e) {
            DataExeption ex = new DataExeption("Errore nella cancellazione del corso", e );
            throw ex;
        }
    }

    @Override
    public boolean update(int corsiID, Corso toUpdate) throws DataExeption {
        try(PreparedStatement st = con.prepareStatement(updateQuery)){
            st.setString(1, toUpdate.getTitle());
            st.setString(2, toUpdate.getDescription());
            st.setDouble(3, toUpdate.getCost());
            st.setInt(4, toUpdate.getNumHours());
            st.setInt(5, corsiID);
            int rows = st.executeUpdate();
            return rows!=0;
            }
        catch (SQLException e) {
            DataExeption ex = new DataExeption("Errore nell'update del corso", e );
            throw ex;
        }
    }

    @Override
    public Collection<Corso> getAll() throws DataExeption {
        try(Statement st =con.createStatement()) {
            ResultSet rs = st.executeQuery(ALL_COURSE);
            return readResult(rs);
        }catch (SQLException e) {
            DataExeption ex = new DataExeption("Errore nella ricerca corsi", e );
            throw ex;
        }
    }

    @Override
    public Collection<Corso> getByLastNameLike(String pattern) throws DataExeption {
        try (PreparedStatement st = con.prepareStatement(SRC_BY_NAME)) {
            st.setString(1, "%" + pattern + "%");
            ResultSet rs = st.executeQuery();
            return readResult(rs);
        } catch ( SQLException e) {
            DataExeption ex = new DataExeption("Errore nella ricerca LIKE su lastname", e );
            throw ex;
        }
    }

    @Override
    public Corso findByID(int id) throws DataExeption {
        try(PreparedStatement st = con.prepareStatement(SRC_BY_ID)){
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            List<Corso> res=readResult(rs);
            if(res.isEmpty())
                return null;
            else
                return res.get(0);
        } catch (SQLException e) {
            DataExeption ex = new DataExeption("Errore nella ricerca del corso per ID", e );
            throw ex;
        }
    }

    private List<Corso> readResult(ResultSet rs) throws SQLException{
        List<Corso> corsi = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String desc = rs.getString("description");
            double cost = rs.getDouble("cost");
            int numHours = rs.getInt("numHours");
            Corso c = new Corso(id, title, desc, cost, numHours);
            corsi.add(c);
        }
        return corsi;
    }
}
