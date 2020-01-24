import net.bit.academia.model.net.bit.academia.persistence.repositories.file.FileRepositoryAgent;
import net.bit.academia.model.net.bit.academia.persistence.repositories.inMemory.InMemoryRepositoryCorsi;
import Interfaccia.InterfacciaUtente;

public class Main {
    public static void main(String[] args) {

        InterfacciaUtente i = new InterfacciaUtente(new FileRepositoryAgent(),
                new InMemoryRepositoryCorsi());


        i.start();

    }

}
