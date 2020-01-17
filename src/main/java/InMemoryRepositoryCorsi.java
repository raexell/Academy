import java.util.Collection;

public class InMemoryRepositoryCorsi implements RepositoryCorsi {
    private DatabaseInMemoria data = DatabaseInMemoria.getInstance();
    @Override
    public Corsi create(Corsi toInsert) {
        return null;
    }

    @Override
    public boolean delete(int corsiID) {
        return false;
    }

    @Override
    public boolean update(int corsiID, Corsi toUpdate) {
        return false;
    }

    @Override
    public Collection<Corsi> getAll() {
        return null;
    }

    @Override
    public Collection<Corsi> getByLastNameLike(String pattern) {
        return null;
    }
}
