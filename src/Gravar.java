import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Gravar{

    private Gravacao tipoGravacao;

    public Gravar(Gravacao g) {
        this.tipoGravacao = g;
    }

    public boolean gravarLista(ArrayList<Pessoa> list) throws IOException {
        return tipoGravacao.gravarLista(list);
    }

    public ArrayList<Pessoa> Ler() throws FileNotFoundException {
        return tipoGravacao.ler();

    }

}
