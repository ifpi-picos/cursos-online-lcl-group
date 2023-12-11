package br.edu.ifpi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.edu.ifpi.dao.AlunoDao;
import br.edu.ifpi.dao.AutenticacaoDao;
import br.edu.ifpi.dao.Conexao;

import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.enums.StatusAluno;

public class AlunoTest {
    public static void main(String[] args) throws SQLException {

        Connection conexao = Conexao.getConnection();
        AlunoDao alunoDao = new AlunoDao(conexao);
        AutenticacaoDao autenticacaoDao = new AutenticacaoDao(conexao);
        Scanner scanner = new Scanner(System.in);
    
// * metodo cadastrar aluno
        //Aluno novoAluno = new Aluno("Livya", "livya@gmail.com", StatusAluno.ATIVO);
        //int resultadoCadastro = alunoDao.cadastrar(novoAluno);
        //Aluno Livya = autenticacaoDao.autenticarAluno("livya@gmail.com");
        
// * metodo consultar 
        //List<Aluno> alunosConsultados = alunoDao.consultar();

//* Metodo remover 
        //Aluno aluno_remover = new Aluno(0, null, null, null);
        //System.out.println("Digite o id do aluno que deseja remover: ");
        //int id_remove = scanner.nextInt();

        //aluno_remover.setIdAluno((id_remove));

        //alunoDao.remover(aluno_remover);
        
//* metodo alterar  
//         System.out.println("Digite o id do aluno que deseja alterar:");
//         int idAlterar = scanner.nextInt();
//         scanner.nextLine();

//         Aluno alterAluno = new Aluno(idAlterar, null, null, null);
//         alterAluno.setIdAluno(idAlterar);
        
//         System.out.println("Novo Nome: ");
//         alterAluno.setNome(scanner.nextLine());

//         System.out.println("Novo Email: ");
//         alterAluno.setEmail(scanner.next());

// // PARTE DE ALTERAR O STATUS DO ALUNO
//         System.out.println("Digite o número correspondente ao novo status do aluno:");
//         System.out.println("1 - ATIVO");
//         System.out.println("2 - INATIVO");

//         int escolha = scanner.nextInt();

//         switch (escolha) {
//             case 1:
//                 alterAluno.setStatus(StatusAluno.ATIVO);
//                 break;
//             case 2:
//                 alterAluno.setStatus(StatusAluno.INATIVO);
//                 break;
//             default:
//                 System.out.println("Opção inválida. O status não foi alterado.");
//                 return; // Se a escolha for inválida, encerra o programa ou faz alguma outra manipulação apropriada.
//         }

//         System.out.println("Novo status do aluno: " + alterAluno.getStatus());

//         alunoDao.alterar(alterAluno);

  }
}
