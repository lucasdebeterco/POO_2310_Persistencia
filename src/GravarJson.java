import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GravarJson implements Gravacao{

    public boolean gravarLista(ArrayList<Pessoa> lp) throws IOException {
        try {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            FileWriter writer = new FileWriter("agenda.json");
            writer.write(gson.toJson(lp));
            writer.close();
            return true;
        } catch (IOException e) {
        return false;
        }
    }

    public ArrayList<Pessoa> ler() throws FileNotFoundException {
        ListaPessoas lp = new ListaPessoas();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        builder = new GsonBuilder();
        gson = builder.create();
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("agenda.json"));

        Type listType = new TypeToken<ArrayList<Pessoa>>(){}.getType();
        ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
        lista = new Gson().fromJson(bufferedReader, listType);
        lp.setListaPessoas(lista);
        return lp.getListaPessoas();
    }
}
