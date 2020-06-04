

class EscalonadorDeConsultas{
    
    /* Os médicos disponíveis são divididos por especialidade;
     cada consulta é alocada a eles de maneira circular (ou round robin), 
     ou seja, as consultas são distribuídas alternadamente e igualmente entre os médicos. */
     public HashMedicos Escalonar(Consulta consulta, HashMedicos hashMedicos){
     
         // Distanciando o médico com menos consultas através ao método da HASH
         Medico medico = hashMedicos.PesquisarMenor(consulta.getCodEspecialidade_Consulta());
 
         // Adicionando a consulta na lista de consultas do médico que está sendo escalonado.
         medico.getListaConsultas_Medicos().add(consulta);
 
         medico.getValorTotal_Medico().add(consulta.getValor_Consulta()); // Adiciona o valor fornecido.
         
         return hashMedicos;
     }
 }