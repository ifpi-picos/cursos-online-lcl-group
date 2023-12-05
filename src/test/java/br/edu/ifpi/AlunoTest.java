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

        //List<Aluno> alunosConsultados = alunoDao.consultar();


//* METODO DE REMOVER DEU CERTO 😭😭😭😭😭
        //Aluno aluno_remover = new Aluno(0, null, null, null);
        //System.out.println("Digite o id do aluno que deseja remover: ");
        //int id_remove = scanner.nextInt();

        //aluno_remover.setIdAluno((id_remove));

        //alunoDao.remover(aluno_remover);

        alunoDao.consultar();
        
        System.out.println("Digite o id do aluno que deseja alterar:");
        int alterarId = scanner.nextInt();
        scanner.nextLine();

        Aluno alterAluno = new Aluno(alterarId, null, null, null);
        alterAluno.setIdAluno(alterarId);
        
        System.out.println("Novo Nome: ");
        alterAluno.setNome(scanner.nextLine());

        System.out.println("Novo Email: ");
        alterAluno.setEmail(scanner.next());

        alunoDao.alterar(alterAluno);



    }
}
