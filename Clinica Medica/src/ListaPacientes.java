

public class ListaPacientes {
    
    private Paciente primeiro;
    private Paciente ultimo;
    private Paciente aux;
    public int contador;

    // Construtor 
    public ListaPacientes(){
    
        primeiro = new Paciente();
        ultimo = primeiro;
        ultimo.Proximo = primeiro;
    }
    public Boolean listaVazia(){

        if(primeiro == ultimo) return true;
        else return false;     
    }

    public void inserir(Paciente novo){
    
        ultimo.Proximo = novo;
        ultimo = ultimo.Proximo;
        contador++;
    }
    public Paciente pesquisar(int _cpf){
    
        if (listaVazia() == true) return null; 
        else{
            aux = primeiro.Proximo;
            while(aux != null){

                if (aux.getCpf_Paciente() == _cpf){
                    return aux;
                }
                else{
                    aux = aux.Proximo;
                }
            }
            return aux;
        }
    }
}