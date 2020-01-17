import java.util.Collection;

public interface RepositoryCorsi{

    Corsi create(Corsi toInsert);
    boolean delete(int corsiID);
    boolean update(int corsiID, Corsi toUpdate);
    Collection<Corsi> getAll();
    Collection<Corsi> getByLastNameLike(String pattern);
}
