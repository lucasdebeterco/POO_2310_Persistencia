import org.w3c.dom.CDATASection;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class GravarCsv implements Gravacao {

    public boolean gravarLista (ArrayList<Pessoa> lp) {

        try {
            Scanner ler = new Scanner(System.in);
            FileWriter arq = new FileWriter("agenda.csv");
            PrintWriter gravarArq = new PrintWriter(arq);

            for (Pessoa pessoa : lp){
                gravarArq.printf("%d;%s;%s;%s;%tc\n", pessoa.getCodigo(), pessoa.getNome(), pessoa.getEmail(), pessoa.getTelefone(), pessoa.getDataNascimento());
            }
            arq.close();
            return true;
        } catch (IOException  e) {
            return false;
        }
    }

    public ArrayList<Pessoa> ler() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Pessoa> lista = new ArrayList <Pessoa>();
        Pessoa p = new Pessoa();
        try {
            FileReader arq1 = new FileReader("agenda.csv");
            BufferedReader lerArq = new BufferedReader(arq1);
            String linha = lerArq.readLine();
            lista = new ArrayList <Pessoa>();
            while (linha != null) {
                String [] leitura = linha.split(";");
                p = new Pessoa ();
                p.setCodigo(Integer.parseInt(leitura[0]));
                p.setNome(leitura[1]);
                p.setEmail(leitura[2]);
                p.setTelefone(leitura[3]);
                lista.add(p);
                linha = lerArq.readLine ();
            }
            arq1.close();
            return lista;
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo : %s.\n" , e.getMessage());
            return null;
        }
    }


}

