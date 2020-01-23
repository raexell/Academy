package Database;

import Corsi.Corso;

import java.util.Collection;

public interface CourseRepository {

    Corso create(Corso toInsert)  throws DataExeption;
    boolean delete(int corsiID) throws DataExeption;
    boolean update(int corsiID, Corso toUpdate) throws DataExeption;
    Collection<Corso> getAll() throws DataExeption;
    Collection<Corso> getByLastNameLike(String pattern) throws DataExeption;
    Corso findByID(int id) throws DataExeption;
}
