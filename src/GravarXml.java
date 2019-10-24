import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GravarXml implements Gravacao {

    public boolean gravarLista(ArrayList<Pessoa> lp) throws IOException {
        try{
            FileOutputStream fos = new FileOutputStream(new File("agenda.xml"));
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(lp);
            encoder.close();
            fos.close();

        } catch (IOException ex){
            ex.printStackTrace();
        }
        return true;
    }

    public ArrayList<Pessoa> ler() {
        ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
        try {
            FileInputStream fis = new FileInputStream(new File("agenda.xml"));
            XMLDecoder decoder = new XMLDecoder(fis);
            lista = (ArrayList<Pessoa>) decoder.readObject();
            decoder.close();
            fis.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return lista;
    }
}
