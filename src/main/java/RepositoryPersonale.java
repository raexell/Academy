import java.util.Collection;

public interface RepositoryPersonale {
    Agenti create(Agenti toInsert);
    boolean delete(int agentID);
    boolean update(int agentID, Agenti toUpdate);
    Collection<Agenti> getAll();
    Collection<Agenti> getByLastNameLike(String pattern);
}
