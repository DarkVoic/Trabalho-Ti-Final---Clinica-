
public class Consulta {
    private int codEspecialidade;
    private int tipo;
    private int cpf;
    private String data;
    private double valor;
    

    // Métodos Get e Set > codEspecialidade
    public int getCodEspecialidade_Consulta(){ return codEspecialidade; }
    public void setCodEspecialidade_Consulta(int idEspecialidade) {this.codEspecialidade = idEspecialidade;}

    // Métodos Get e Set > Tipo
    public int getTipo_Consulta(){ return tipo;} 
    public void setTipo_Consulta(int _tipo) { this.tipo = _tipo;}

    // Método Get e Set > cpf
    public int getCpf_Consulta(){return cpf;}
    public void setCpf_Consulta(int _cpf){this.cpf = _cpf;}
    
    // Métodos Get e Set > data
    public String getData_Consulta(){return data;}
    public void setData_Consulta(String _data){this.data = _data;}

    //Métodos Get e Set > valor
    public double getValor_Consulta(){return valor;}
    public void setValor_Consulta(double _valor){this.valor = _valor;}

    // Subscrever o método
    public @Override String toString(){
    
        return "\nCodigo de Especialidade:: " + this.codEspecialidade + ", tipo: " + this.tipo + ", data: " 
        + this.data + ", valor: " + this.valor + ", id: " + this.cpf;
    }
}