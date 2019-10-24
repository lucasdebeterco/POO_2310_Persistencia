import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.BiFunction;
import com.google.gson.*;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;


public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        ListaPessoas lp = new ListaPessoas();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        Pessoa p = new Pessoa();
        p.setCodigo(1);
        p.setNome("Lucas");
        p.setEmail("lucasdebeterco@gmail.com");
        p.setTelefone("988672400");
        Date data1 = formato.parse("14/12/2000");
        p.setDataNascimento(data1);
        lp.acidicionarPessoa(p);

        p = new Pessoa();
        p.setCodigo(2);
        p.setNome("Rodrigo Curvello");
        p.setEmail("rodrigo@outlook.com");
        p.setTelefone("12345678");
        Date data2 = formato.parse("05/06/1980");
        p.setDataNascimento(data2);
        lp.acidicionarPessoa(p);

        p = new Pessoa();
        p.setCodigo(3);
        p.setNome("Teste");
        p.setEmail("teste@gmail.com");
        p.setTelefone("12345678");
        Date data3 = formato.parse("15/11/1100");
        p.setDataNascimento(data2);
        lp.acidicionarPessoa(p);

        // Removendo pessoa
        lp.removerPessoa(3);
        System.out.println("----------------------");

        // Granvando arquivo XML..
        GravarXml xml = new GravarXml();
        Gravar gravar = new Gravar(xml);
        gravar.gravarLista(lp.getListaPessoas());

        // Granvando arquivo CSV..
        GravarCsv csv = new GravarCsv();
        gravar = new Gravar(csv);
        gravar.gravarLista(lp.getListaPessoas());

        // Granvando arquivo Json..
        GravarJson json = new GravarJson();
        gravar = new Gravar(json);
        gravar.gravarLista(lp.getListaPessoas());

        System.out.println("Lendo arquivo XML: ");
        lp = new ListaPessoas();
        gravar = new Gravar(xml);
        lp.setListaPessoas(gravar.Ler());
        System.out.println(lp);
        System.out.println("----------------------");

        System.out.println("Lendo arquivo CSV: ");
        lp = new ListaPessoas();
        gravar = new Gravar(csv);
        lp.setListaPessoas(gravar.Ler());
        System.out.println(lp);
        System.out.println("----------------------");

        System.out.println("Lendo arquivo Json: ");
        lp = new ListaPessoas();
        gravar = new Gravar(json);
        lp.setListaPessoas(gravar.Ler());
        System.out.println(lp);
        System.out.println("----------------------");

        System.out.println("Lista com os aniversariantes do mês: ");
        System.out.println(lp.consultarAniver(12));
        System.out.println("----------------------");

        System.out.println("Lista de pessoas com domínio de email solicitado: ");
        System.out.println(lp.consultarDominio("outlook"));
        System.out.println("----------------------");

    }
}