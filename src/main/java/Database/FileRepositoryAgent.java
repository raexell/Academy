package Database;

public class FileRepositoryAgent extends AbstractMapAgentRepository {

    @Override
    public Database loadDatabase() {
        return DatabaseInFile.getInstance();
    }
}
