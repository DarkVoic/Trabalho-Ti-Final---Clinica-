import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.DoubleAdder;

public class Medico {

    private int crm;
    private String nome;
    private int codEspecialidade;
    private DoubleAdder valorTotal = new DoubleAdder(); // Cria um novo somador com soma inicial de zero.
    private List<Consulta> listaConsultas = new ArrayList<Consulta>();
    public Medico Proximo;

    // Método Get e Set > crm
    public int getCrm_Medico(){return crm;}
    public void setCrm_Medico(int _crm){this.crm = _crm;}

    // Métodos Get e Set > nome
    public String getNome_Medico(){ return nome;} 
    public void setNome_Medico(String _nome) { this.nome = _nome;}

    // Métodos Get e Set > codEspecialidade
    public int getCodEspecialidade_Medico(){ return codEspecialidade; }
    public void setCodEspecialidade_Medico(int idEspecialidade) {this.codEspecialidade = idEspecialidade;}

    //Métodos Get e Set > valorTotal
    public DoubleAdder getValorTotal_Medico(){return valorTotal;}
    public void setValorTotal_Medico(DoubleAdder _valorTotal){this.valorTotal = _valorTotal;}

    //Métodos Get e Set > List<Consulta>
    public List<Consulta> getListaConsultas_Medicos(){return listaConsultas;} 
    public void setListaConsultas_Medicos(List<Consulta> _listaConsultas) { this.listaConsultas = _listaConsultas;}

    public double CalcularSalario(){
       
        return ((valorTotal.doubleValue() * 80) / 100); // Equivalente a sum().
    }

    // Subscrever o método
    public @Override String toString(){
    
        return "Crm: " + this.crm + ", Nome: " + this.nome + ", Codigo de Especialidade: " + this.codEspecialidade;
    }
}