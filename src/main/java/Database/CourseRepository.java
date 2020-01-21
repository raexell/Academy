package Database;

import Corsi.Corso;

import java.util.Collection;

public interface CourseRepository {

    Corso create(Corso toInsert);
    boolean delete(int corsiID);
    boolean update(int corsiID, Corso toUpdate);
    Collection<Corso> getAll();
    Collection<Corso> getByLastNameLike(String pattern);
    Corso findByID(int id);
}
