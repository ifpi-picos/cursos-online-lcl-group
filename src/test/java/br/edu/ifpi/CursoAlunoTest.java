package br.edu.ifpi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpi.dao.AutenticacaoDao;
import br.edu.ifpi.dao.Conexao;
import br.edu.ifpi.dao.CursoAlunoDao;
import br.edu.ifpi.dao.CursoDao;
import br.edu.ifpi.entidades.Aluno;
import br.edu.ifpi.entidades.Curso;
import br.edu.ifpi.entidades.Professor;
import br.edu.ifpi.enums.StatusAluno;
import br.edu.ifpi.enums.StatusCurso; 
import br.edu.ifpi.entidades.CursoAluno;

public class CursoAlunoTest {
    public static void main(String[] args) throws SQLException {
        Connection conexao = Conexao.getConnection();
        AutenticacaoDao autenticacaoDao = new AutenticacaoDao(Conexao.getConnection());
        CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(conexao);
        Curso curso = new Curso(0, null, 0, null, null);
        Aluno aluno = new Aluno(0, null, null, null);

        //* metodo cadastrar funcionando
        // CursoAluno cursoAluno = new CursoAluno(null, null, (float) 0); // pega o curso_aluno que vc ja cadastrou na tabela e cadastra/autera a nota
        // cursoAluno.setIdCurso(3); //pega o id do curso
        // cursoAluno.setIdAluno(1); // pega o id do aluno

        // int resultadoCadastro = cursoAlunoDao.cadastrar(cursoAluno);
        // System.out.println("Cadastro realizado com sucesso!! " + resultadoCadastro);

        //* metodo consultar funcionando 

        //cursoAlunoDao.consultar();

        // * metodo remover funcionanddo
        // CursoAluno cursoRemover = new CursoAluno(null, null, (float) 0);
        // cursoRemover.setIdCurso(3); //pega o id do curso
        // cursoRemover.setIdAluno(1); // pega o id do aluno

        // int idCursoRemover = cursoAlunoDao.remover(cursoRemover);
        // System.out.println("Remoção realizada com sucesso! " + idCursoRemover);

        // * metodo totaldeAlunosMatriculadosCurso
         Curso cursoTest = autenticacaoDao.autenticarCurso("ADS");
        //cursoAlunoDao.totaldeAlunosMatriculadosCurso(cursoTest);

        //* metodo media Alunos
        cursoAlunoDao.mediaAlunos(cursoTest);

        //* metodo porcentagem de alunos aprovados
        cursoAlunoDao.porcentagemAlunosAprovados(cursoTest);

        //* metodo porcentagem de alunos reprovados
        cursoAlunoDao.porcentagemAlunosReprovados(cursoTest);
        
        //* metodo inserir nota
        CursoAluno alunoNota = new CursoAluno(curso, aluno, null);
        alunoNota.setIdCurso(3); 
        alunoNota.setIdAluno(1); 

        Float nota = 7.0f;
        cursoAlunoDao.inserirNota(alunoNota, nota);
     }

}
