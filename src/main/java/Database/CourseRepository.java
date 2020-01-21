package Database;

import Corsi.Corsi;

import java.util.Collection;

public interface CourseRepository {

    Corsi create(Corsi toInsert);
    boolean delete(int corsiID);
    boolean update(int corsiID, Corsi toUpdate);
    Collection<Corsi> getAll();
    Collection<Corsi> getByLastNameLike(String pattern);
    Corsi getCorsiById(int id);
}
