

public class HashPacientes {
    
    // Definindo a constante do tamanho == "const"
    private final int tamanho = 2500;
    public ListaPacientes[] listaPaciente;

    // Construtor 
    public HashPacientes(){
    
        listaPaciente = new ListaPacientes[tamanho];
    }

    // Chave utilizando o CPF do Paciente com o resto da constante
    private int FuncaoHash(int _cpf){
    
        int key = _cpf % tamanho;
        return key;
    }
    
    public void inserir(Paciente novoPaciente){
    
        // Definindo a posição do paciente na HASH
        int pos = FuncaoHash(novoPaciente.getCpf_Paciente());

        // Se a posição na lista for vazia na HASH 
        if(listaPaciente[pos] == null){
            listaPaciente[pos] = new ListaPacientes();
        }
        // insere Paciente na posição na HASH
        listaPaciente[pos].inserir(novoPaciente);

    }

    // Método de pesquisa sem comparação. 
    public Paciente pesquisar(int _cpf){

        // responsável por localizar o Paciente, com o CPF passado no parêmetro, na listaPaciente
        Paciente paciente = listaPaciente[FuncaoHash(_cpf)].pesquisar(_cpf);
        return paciente;
    }
    
    public Paciente InserirConsulta(Consulta consulta){
    
        // Busca o paciente pelo identificador e insere a consulta em seu histórico.
        Paciente paciente = pesquisar(consulta.getCpf_Consulta());
        // Comparando: Se Paciente for diferente de Null e o CPF for igual o que estou buscando...
        if(paciente != null && paciente.getCpf_Paciente() == consulta.getCpf_Consulta()){
        
            // adiciona o valor da consulta na variável "valor Total" do cliente 
            paciente.getValorTotal_Paciente().add(consulta.getValor_Consulta()); // Adiciona o valor fornecido.
            // Adiciona a consulta no Historico do Paciente
            paciente.getHistoricoConsultas_Paciente().add(consulta);
            return paciente;
        }
        return null;
    }
}
