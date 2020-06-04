import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.*;

public class Dados {
    
    private Boolean carregado = false;
    private String[] dados = new String[0];
    public HashMedicos hashMedicos = new HashMedicos();
    public HashPacientes hashPacientes = new HashPacientes();

    // Método Get e Set > HashMedicos
    public HashMedicos getHash_Medicos() { return hashMedicos; }
    
    // Método Get e Set > HashMedicos
    public HashPacientes getHash_Pacientes() { return hashPacientes; }

    // Método Get e Set > carregado
    public Boolean getValidacao(){ return carregado;}

    public EscalonadorDeConsultas Escalonador = new EscalonadorDeConsultas();

    // Métodos para carregar os dados dos Pacientes.txt direcionando a classe Paciente e inserindo na Hash
    public void CarregarPacientes() throws ParseException{

        try{
        // FileReader para para ler arquivos dos Dados do (Paciente| Medico| Consultas)
        final FileReader leitorPacientes = new FileReader("C:\\Users\\mathe\\Universidade PUC\\4 - Periodo\\Algoritmos e Estruturas de Dados\\Trabalho Final TI - Clinica Medica\\AEDpacientes.txt");
        final BufferedReader lerPacientes = new BufferedReader(leitorPacientes);
        
            while (lerPacientes.ready()){
            
                dados = lerPacientes.readLine().split(";");

                Paciente paciente = new Paciente();
                
                    paciente.setCpf_Paciente(Integer.parseInt(dados[0]));
                    paciente.setNome_Paciente(dados[1]);
                    paciente.setCodEspecialidade_Paciente(Integer.parseInt(dados[2]));
                
                hashPacientes.inserir(paciente);
            }
            lerPacientes.close();
        }catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
    }

    // Métodos para carregar os dados dos Medicos.txt direcionando a classe Paciente e inserindo na Hash
    public void CarregarMedicos() throws ParseException {

        try{
            final FileReader leitorMedicos = new FileReader("C:\\Users\\mathe\\Universidade PUC\\4 - Periodo\\Algoritmos e Estruturas de Dados\\Trabalho Final TI - Clinica Medica\\AEDmedicos.txt");
            final BufferedReader lerMedicos = new BufferedReader(leitorMedicos);
            while (lerMedicos.ready()){
            
                dados = lerMedicos.readLine().split(";");

                Medico medico = new Medico();
                
                    medico.setCrm_Medico(Integer.parseInt(dados[0]));
                    medico.setNome_Medico(dados[1]);
                    medico.setCodEspecialidade_Medico(Integer.parseInt(dados[2]));
                

                hashMedicos.inserir(medico);
            }
            lerMedicos.close();
        }catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
    }
    
    // Métodos para carregar os dados das Consultas.txt direcionando a classe Paciente e inserindo na Hash
    public void CarregarConsultas() throws ParseException {
        
        try{
            final FileReader leitorConsultas = new FileReader("C:\\Users\\mathe\\Universidade PUC\\4 - Periodo\\Algoritmos e Estruturas de Dados\\Trabalho Final TI - Clinica Medica\\AEDconsultas.txt");
            final BufferedReader lerConsultas = new BufferedReader(leitorConsultas);
           
            while (lerConsultas.ready()){
            
                dados = lerConsultas.readLine().split(";");
                Consulta consulta = new Consulta();

                    consulta.setCodEspecialidade_Consulta(Integer.parseInt(dados[0]));
                    consulta.setTipo_Consulta(Integer.parseInt(dados[1]));
                    consulta.setCpf_Consulta(Integer.parseInt(dados[2]));
                    consulta.setData_Consulta(dados[3]);

                switch(consulta.getTipo_Consulta()){
                
                    case 0:
                        consulta.setValor_Consulta(50); 
                        break;
                    case 1:
                        consulta.setValor_Consulta(100); 
                        break;
                    default:
                        break;
                }
                hashPacientes.InserirConsulta(consulta);
                hashMedicos = Escalonador.Escalonar(consulta, hashMedicos);
               
            }lerConsultas.close();
        }
        catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
        carregado = true;
    }

}