package Database;

import Corsi.Corsi;

import java.util.Collection;
import java.util.Map;

public class InMemoryRepositoryCorsi implements RepositoryCorsi {
    private DatabaseInMemoria data = DatabaseInMemoria.getInstance();
    @Override
    public Corsi create(Corsi toInsert) {
        Map<Integer,Corsi> corsi = data.getCorsi();
        corsi.put(toInsert.getId(),toInsert);
        return toInsert;
    }

    @Override
    public boolean delete(int corsiID) {
        Map<Integer,Corsi> corsi = data.getCorsi();
        Corsi x = corsi.remove(corsiID);
        return x != null;
    }

    @Override
    public boolean update(int corsiID, Corsi toUpdate) {
        Map<Integer,Corsi> corsi = data.getCorsi();
        Corsi old= corsi.replace(corsiID,toUpdate);
        return old != null;
    }

    @Override
    public Collection<Corsi> getAll() {
        Map<Integer,Corsi> corsi = data.getCorsi();
        return corsi.values();
    }

    @Override
    public Collection<Corsi> getByLastNameLike(String pattern) {
        return null;
    }
}
