
import java.util.Scanner;
import java.text.NumberFormat;


public class ModuloConsultas {

    Scanner ler = new Scanner(System.in);

    public void BuscarMedico(HashMedicos hashMedicos){

        System.out.println("Qual a especialidade do Médico? ");
        int esp = ler.nextInt();
        System.out.println("Qual a CRM do médico? ");
        int id = ler.nextInt();
        Medico medico = hashMedicos.pesquisar(esp, id);
        System.out.println(medico.getListaConsultas_Medicos());
        System.out.println("------------------------");
        System.out.println("| Historico do Médico: | " + medico.getNome_Medico());
        System.out.println("------------------------");
        System.out.println("---------------------");
        System.out.println("| Dados do Médico:  | " + medico.toString() + ", Total Recebido: " + NumberFormat.getCurrencyInstance().format(medico.getValorTotal_Medico()));
        System.out.println("---------------------");
    }
    
    public void BuscarPaciente(HashPacientes hashPacientes){
    
        System.out.println("Qual o CFP do paciente? ");
        int cpf = ler.nextInt();
        Paciente paciente = hashPacientes.pesquisar(cpf);
        System.out.println("---------------------");
        System.out.println("| Dados do Paciente: | " + paciente.toString());
        System.out.println("---------------------");
        System.out.println("------------------------");
        System.out.println("| Historico do cliente: | " + paciente.getNome_Paciente());
        System.out.println("------------------------");
        System.out.println(paciente.getHistoricoConsultas_Paciente());
        System.out.println("----------------------------------");
        System.out.println("| Valor total pago das Consultas: | " + NumberFormat.getCurrencyInstance().format(paciente.getValorTotal_Paciente()));
        System.out.println("----------------------------------");
    }

    public void BuscarConsultas(HashMedicos hashMedicos){
    
        
        System.out.println("Qual a especialidade? ");
        int esp = ler.nextInt();
        System.out.println("Qual a data? <> 'Favor informar em Formato - dd/mm/aaaa - '");
        String data = ler.next();
        System.out.println(hashMedicos.BuscarConsultas(esp, data));
        // System.out.println(consultas);
        // String consultas = hashMedicos.BuscarConsultas(esp, data);

        
    }
    
}