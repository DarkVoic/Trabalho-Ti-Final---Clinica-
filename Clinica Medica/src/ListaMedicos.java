

public class ListaMedicos {
    
    private Medico primeiro;
    private Medico ultimo;
    private Medico aux;
    public int contador;

    // Construtor 
    public ListaMedicos(){
    
        primeiro = new Medico();
        ultimo = primeiro;
    }

    public void inserir(Medico novo){

        ultimo.Proximo = novo;
        ultimo = ultimo.Proximo;
        contador++;
    }

    public Boolean listaVazia(){
    
        if(primeiro == ultimo) return true;
        else return false;   
    }

    // Pesquisar Médico na lista utilizando como parâmetro o CRM.
    public Medico pesquisar(int _crm){
    
        if (listaVazia() == true)return null;
        else{
            aux = primeiro.Proximo;
            while (aux != null)
            {
                if (aux.getCrm_Medico() == _crm){
                    return aux;
                }
                else{
                    aux = aux.Proximo;
                }
            }
            return aux;
        }
    }

    // Busca o medico com a menor quantidade de consultas.  
    public Medico buscaMenor(){
    
        if (listaVazia() == true)return null;
        else{
            Medico menorM = new Medico();
            int menor = Integer.MAX_VALUE;
            aux = primeiro.Proximo;
            while (aux != null){
            
                if (aux.getListaConsultas_Medicos().size() < menor)
                {
                    menorM = aux;
                    menor = aux.getListaConsultas_Medicos().size();
                }
                aux = aux.Proximo;
            }
            return menorM;
        }
    }

    public void imprimir(){
    
        if (listaVazia() == true){
            System.out.println("Lista vazia");
        }
        else{
            aux = primeiro.Proximo;
            while (aux != null){
                System.out.println(aux.toString());
                aux = aux.Proximo;
            }
        }
    }

    public String BuscarData(String data){
        
        // Busca dentre os médicos todas as consultas compativeis com a data de entrada do usuário.
        if(listaVazia() == true) { return "Lista vazia";}
        else{
            // Variável para armazenar a saída dos que atendem a data.
            String consultas = "";
            aux = primeiro.Proximo;
            while(aux != null){
            
                // Foreach percorrendo uma List 
                for(var consulta : aux.getListaConsultas_Medicos()){
                    // Condição "Equals" comparacão
                    if(consulta.getData_Consulta().equals(data)){
                    
                        consultas += consulta.toString() + "\n";
                    }
                }
                aux = aux.Proximo;
            }
            return consultas;
        }
    }
}