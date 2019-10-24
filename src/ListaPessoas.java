import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ListaPessoas {
    ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();

    public ArrayList<Pessoa> getListaPessoas() {
        return listaPessoas;
    }
    public void setListaPessoas(ArrayList<Pessoa> listaPessoas) {
        this.listaPessoas = listaPessoas;
    }

    public void acidicionarPessoa(Pessoa pessoa) throws IOException {
        listaPessoas.add(pessoa);
    }

    public void removerPessoa(int codigo) throws IOException {
        for (Pessoa pessoa : listaPessoas){
            if (pessoa.getCodigo() == codigo){
                listaPessoas.remove(pessoa);
                break;
            }
        }
    }

    public ArrayList<Pessoa> consultarAniver(int mes) {
        mes -= 1;
        ArrayList<Pessoa> aniversariantes = new ArrayList<Pessoa>();
        for (Pessoa pessoa : listaPessoas){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(pessoa.getDataNascimento());
            if (calendar.get(Calendar.MONTH) == mes){
                aniversariantes.add(pessoa);
            }
        }
        return aniversariantes;
    }

    public ArrayList<Pessoa> consultarNome(String nome) {
        ArrayList<Pessoa> listaNome = new ArrayList<Pessoa>();
        for (Pessoa pessoa : listaPessoas){
            if (pessoa.getNome().contains(nome)){
                listaNome.add(pessoa);
            }
        }
        return listaNome;
    }

    public ArrayList<Pessoa> consultarDominio(String dominio)  {
        ArrayList<Pessoa> listaDominio = new ArrayList<Pessoa>();
        for (Pessoa pessoa : listaPessoas){
            if (pessoa.getEmail().contains(dominio)){
                listaDominio.add(pessoa);
            }
        }
        return listaDominio;
    }

    public String retornaData(Date data){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (Pessoa pessoa : listaPessoas){
            if (pessoa.getDataNascimento() == data){
                return "achou";
            }
        }
        String dataFormatada = dateFormat.format(data);
        return dataFormatada;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ListaPessoas{");
        sb.append("listaPessoas=").append(listaPessoas);
        sb.append('}');
        return sb.toString();
    }
}
