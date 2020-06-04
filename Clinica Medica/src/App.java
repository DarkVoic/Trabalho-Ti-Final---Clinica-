
import java.util.Scanner;

public class App {

    public static HashPacientes hashPacientes = new HashPacientes();
    public static HashMedicos hashMedicos = new HashMedicos();

    static void Menu() {
        System.out.println("---------------------");
        System.out.println("| Clinica Médica | ");
        System.out.println("---------------------");
        System.out.println("Escolha a Opção");
        System.out.println("1 - Historico de Paciente");
        System.out.println("2 - Consultas");
        System.out.println("3 - Relatórios dos Médicos");
        System.out.println("-------//-------//-------");
        System.out.println("4 - Integrantes do Projeto 'Clinica Medica'");

    }

    // Carrega os dados
    static void carregarDados() throws Exception {

        Dados dados = new Dados();
        dados.CarregarPacientes();
        dados.CarregarMedicos();
        dados.CarregarConsultas();
        hashPacientes = dados.getHash_Pacientes();
        hashMedicos = dados.getHash_Medicos();

    }

    public static void main(String[] args) throws Exception {

        carregarDados();
        ModuloConsultas consultar = new ModuloConsultas();
        
        Scanner ler = new Scanner(System.in);

        String escolha = "";
        while (escolha != "0"){
        
            Menu();
            escolha = ler.next();

            switch (escolha){
                
                case "1":
                    consultar.BuscarPaciente(hashPacientes);
                    break;
                case "2":
                    consultar.BuscarConsultas(hashMedicos);
                    break;
                case "3":
                    consultar.BuscarMedico(hashMedicos);
                    break;
                default:
                    break;
            }
        }
        ler.close();
        
    }
}
