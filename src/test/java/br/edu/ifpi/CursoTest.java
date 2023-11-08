package br.edu.ifpi;

public class CursoTest {
  public String nome;
  public Boolean status;
  public int cargaHoraria;
  
  public CursoTest(String nome, Boolean status, int cargaHoraria) {
    this.nome = nome;
    this.status = status;
    this.cargaHoraria = cargaHoraria;
}

  // Curso cursoPadrao = null;


  // @Before
  // public void setup() {
  // cursoPadrao =
  // new Curso("Padrão", StatusCurso.ABERTO, 80, new Professor("Professor", 1, "89999"));
  // }

  // @Test
  // public void cursoAbertoDeveAceitarMatriculaDeAluno() {
  // Aluno aluno = new Aluno("Aluno", 0, "899999");
  // assertTrue(cursoPadrao.getAlunos().size() == 0);
  // cursoPadrao.realizaMatricula(aluno);
  // assertTrue(cursoPadrao.getAlunos().size() == 1);
  // }

  // @Test
  // public void cursoFechadoDeveRecusarMatriculaDeAluno() {
  // Aluno aluno = new Aluno("Aluno", 0, "899999");
  // cursoPadrao.setStatus(StatusCurso.FECHADO);
  // cursoPadrao.realizaMatricula(aluno);
  // assertTrue(cursoPadrao.getAlunos().size() == 0);
  // }

}
