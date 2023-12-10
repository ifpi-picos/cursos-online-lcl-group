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
import br.edu.ifpi.enums.StatusCursoAluno; 
import br.edu.ifpi.entidades.CursoAluno;

public class CursoAlunoTest {
    public static void main(String[] args) throws SQLException {
        Connection conexao = Conexao.getConnection();
        AutenticacaoDao autenticacaoDao = new AutenticacaoDao(Conexao.getConnection());
        CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(conexao);
        Curso curso = new Curso(0, null, 0, null, null);
        Aluno aluno = new Aluno(0, null, null, null);
        //Curso cursoTest = autenticacaoDao.autenticarCurso("ADS");

        //* metodo cadastrar
        // CursoAluno cursoAluno = new CursoAluno(null, null, (float) 0); // pega o curso_aluno que vc ja cadastrou na tabela e cadastra/autera a nota
        // cursoAluno.setIdCurso(3); //pega o id do curso
        // cursoAluno.setIdAluno(1); // pega o id do aluno

        // int resultadoCadastro = cursoAlunoDao.cadastrar(cursoAluno);
        // System.out.println("Cadastro realizado com sucesso!! " + resultadoCadastro);

        //* metodo consultar

        //cursoAlunoDao.consultar();        

        // * metodo remover 
        // CursoAluno cursoRemover = new CursoAluno(null, null, (float) 0);
        // cursoRemover.setIdCurso(3); //pega o id do curso
        // cursoRemover.setIdAluno(1); // pega o id do aluno

        // int idCursoRemover = cursoAlunoDao.remover(cursoRemover);
        // System.out.println("Remoção realizada com sucesso! " + idCursoRemover);

        // * metodo totaldeAlunosMatriculadosCurso
        //cursoAlunoDao.totaldeAlunosMatriculadosCurso(cursoTest);

        //* metodo media Alunos
        // cursoAlunoDao.mediaAlunos(cursoTest);

        //* metodo porcentagem de alunos aprovados
        // cursoAlunoDao.porcentagemAlunosAprovados(cursoTest);

        //* metodo porcentagem de alunos reprovados
        // cursoAlunoDao.porcentagemAlunosReprovados(cursoTest);
        
        // //* metodo alterar nota
        //  CursoAluno cursoAlterarNota = new CursoAluno(null, null, null, (float) 0);
        // cursoAlterarNota.setIdCurso(3);
        //  cursoAlterarNota.setIdAluno(1);
        // Double nota = 4.5;

        // cursoAlunoDao.inserirNota(cursoAlterarNota, nota);
        // System.out.println("Nota cadastrada com sucesso!");

        // * cursos matriculado
        // Aluno alunoT = new Aluno(1, null, null, null);
        // cursoAlunoDao.cursosMatriculados(alunoT);

        //* metodo cursos concluídos
        //  CursoAluno cursoConcluido = new CursoAluno(null, null, null, (float) 0);
        //  cursoConcluido.setIdAluno(8);
        
        // cursoAlunoDao.cursosConcluidos(cursoConcluido);
        
        // * metodo consultar boletim
        //no alunoTest 👇 voce muda o idAluno para o id do aluno que vc quer saber o boletim 
        //Aluno alunoTest = new Aluno(1, null, null, null);
        // cursoAlunoDao.consultarBoletimAluno(alunoTest);

        // * metodo visualizar perfil do aluno
        // cursoAlunoDao.VisualizarPerfilAluno(alunoTest);
     }

}
