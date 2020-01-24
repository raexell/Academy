package net.bit.academia.model.net.bit.academia.persistence.repositories.inMemory;

import net.bit.academia.model.net.bit.academia.persistence.repositories.abstractions.AbstractMapAgentRepository;
import net.bit.academia.model.net.bit.academia.persistence.repositories.abstractions.Database;

public class InMemoryRepositoryAgent extends AbstractMapAgentRepository {

    public InMemoryRepositoryAgent() throws DataExeption {
    }

    @Override
    public Database loadDatabase() {
        return DatabaseInMemoria.getInstance();
    }
   /* private File agentRepo = new File(
            getClass().getClassLoader().getResource("database.properties").getFile()
    );*/
}
