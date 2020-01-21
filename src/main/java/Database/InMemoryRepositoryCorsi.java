package Database;

import Corsi.Corso;

import java.util.Collection;
import java.util.Map;

public class InMemoryRepositoryCorsi implements CourseRepository {
    private DatabaseInMemoria data = DatabaseInMemoria.getInstance();
    @Override
    public Corso create(Corso toInsert) {
        Map<Integer, Corso> corsi = data.getCorsi();
        int maxKey = corsi.keySet().stream().mapToInt(Integer::intValue).max().orElse(0);
        toInsert.setId(++maxKey);
        corsi.put(toInsert.getId(),toInsert);
        return toInsert;
    }

    @Override
    public boolean delete(int corsiID) {
        Map<Integer, Corso> corsi = data.getCorsi();
        Corso x = corsi.remove(corsiID);
        return x != null;
    }

    @Override
    public boolean update(int corsiID, Corso toUpdate) {
        Map<Integer, Corso> corsi = data.getCorsi();
        Corso old= corsi.replace(corsiID,toUpdate);
        return old != null;
    }

    @Override
    public Collection<Corso> getAll() {
        Map<Integer, Corso> corsi = data.getCorsi();
        return corsi.values();
    }

    @Override
    public Collection<Corso> getByLastNameLike(String pattern) {
        return null;
    }

    @Override
    public Corso findByID(int id) {
        return data.getCorsi().get(id);
    }
}
