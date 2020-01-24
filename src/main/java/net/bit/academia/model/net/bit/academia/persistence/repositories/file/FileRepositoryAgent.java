package net.bit.academia.model.net.bit.academia.persistence.repositories.file;

import net.bit.academia.model.net.bit.academia.persistence.repositories.DataExeption;
import net.bit.academia.model.net.bit.academia.persistence.repositories.abstractions.AbstractMapAgentRepository;
import net.bit.academia.model.net.bit.academia.persistence.repositories.abstractions.Database;
import net.bit.academia.model.net.bit.academia.persistence.repositories.file.DatabaseInFile;

public class FileRepositoryAgent extends AbstractMapAgentRepository {

    @Override
    public Database loadDatabase() throws DataExeption {
        return DatabaseInFile.getInstance();
    }
}
