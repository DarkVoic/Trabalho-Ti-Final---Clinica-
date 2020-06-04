import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.DoubleAdder;

public class Paciente {

    private int cpf;
    private String nome;
    private int codEspecialidade;
    private DoubleAdder valorTotal = new DoubleAdder(); // Cria um novo somador com soma inicial de zero.
    private List<Consulta> historicoConsultas = new ArrayList<Consulta>();
    public Paciente Proximo;

    // Método Get e Set > cpf
    public int getCpf_Paciente(){ return cpf;} 
    public void setCpf_Paciente(int _cpf){ this.cpf = _cpf;}

    // Método Get e Set > nome
    public String getNome_Paciente(){ return nome;} 
    public void setNome_Paciente(String _nome){ this.nome = _nome;}

    // Método Get e Set > codEspecialidade
    public int getCodEpecialidade_Paciente(){return codEspecialidade;} 
    public void setCodEspecialidade_Paciente(int idEspecialidade){this.codEspecialidade = idEspecialidade;}
    
    // Método Get e Set > valorTotal
    public DoubleAdder getValorTotal_Paciente(){return valorTotal;}
    public void setValorTotal_Paciente(DoubleAdder _valorTotal){this.valorTotal = _valorTotal;}

    // Método Get e Set > List<Consulta>
    public List<Consulta> getHistoricoConsultas_Paciente(){return historicoConsultas;} 
    public void setHistoricoConsultas_Paciente(List<Consulta>_listaConsultas){this.historicoConsultas = _listaConsultas; }

    // Subscrever o método
    public @Override String toString(){
    
        return "Cpf: " + this.cpf + ", Nome:  " + this.nome + ", Codigo de Especialidade: " + this.codEspecialidade;
    }
}