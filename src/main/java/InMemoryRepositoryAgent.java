import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryRepositoryAgent implements RepositoryPersonale {
    private DatabaseInMemoria data = DatabaseInMemoria.getInstance();
    @Override
    public Agenti create(Agenti toInsert) {
        Map<Integer,Agenti> agents = data.getAgenti();
        agents.put(toInsert.getId(),toInsert);
        return toInsert;

    }

    @Override
    public boolean delete(int agentID) {
        Map<Integer,Agenti> agents = data.getAgenti();
        Agenti x = agents.remove(agentID);
        return x != null;
    }

    @Override
    public boolean update(int agentID, Agenti toUpdate) {
        Map<Integer,Agenti> agents = data.getAgenti();
        Agenti old= agents.replace(agentID,toUpdate);
        return old != null;
    }

    @Override
    public Collection<Agenti> getAll() {
        Map<Integer,Agenti> agents = data.getAgenti();
        return agents.values();
    }

    @Override
    public Collection<Agenti> getByLastNameLike(String pattern) {
        return data.getAgenti()
                .values().stream()
                .filter(a -> a.getLastname().contains(pattern))
                .collect(Collectors.toList());
    }
}
