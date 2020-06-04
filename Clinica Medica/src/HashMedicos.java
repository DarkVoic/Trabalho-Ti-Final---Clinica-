

public class HashMedicos {
    
    // Definindo a constante do tamanho == "const"
    private final int tamanho = 10;
    private ListaMedicos[] listaMedicos;
    
    // Construtor 
    public HashMedicos(){
    
        listaMedicos = new ListaMedicos[tamanho];
    }

    public void inserir(Medico novosMedicos){

         // Se a posição na lista for vazia na HASH 
        if(listaMedicos[novosMedicos.getCodEspecialidade_Medico()-1] == null){
            listaMedicos[novosMedicos.getCodEspecialidade_Medico()-1] = new ListaMedicos(); 
        }
        // insere Médico na posição na HASH
        listaMedicos[novosMedicos.getCodEspecialidade_Medico()-1].inserir(novosMedicos);
    }

    public Medico pesquisar(int _codEspecialidade, int _crm){
    
        Medico medico = listaMedicos[_codEspecialidade-1].pesquisar(_crm);
        return medico;
    }

    public Medico PesquisarMenor(int _codEspecialidade){
    
        // retorna o médico com a menor quantidade de consultas dentre os demais de sua especialidade.
        return listaMedicos[_codEspecialidade-1].buscaMenor();
    }

    public String BuscarConsultas(int _codEspecialidade, String data){
    
        // retorna todas as consultas de uma especialidade específica em uma determinada data.
        return listaMedicos[_codEspecialidade - 1].BuscarData(data).toString();
    }
}