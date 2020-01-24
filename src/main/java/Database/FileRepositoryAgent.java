package Database;

public class FileRepositoryAgent extends AbstractMapAgentRepository {

    public FileRepositoryAgent() throws DataExeption {
    }

    @Override
    public Database loadDatabase() throws DataExeption {
        return DatabaseInFile.getInstance();
    }
}
