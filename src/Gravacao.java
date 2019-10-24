import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Gravacao {
    public boolean gravarLista(ArrayList<Pessoa> lp) throws IOException;
    public ArrayList<Pessoa> ler() throws FileNotFoundException;

}
