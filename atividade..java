import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ControleNotasTest {

    private ControleNotas controleNotas;

    @Before
    public void setUp() {
        controleNotas = new ControleNotas();
    }

    @Test
    public void testAdicionarNota() {
        controleNotas.adicionarNota("João", 8.0);
        Assert.assertTrue(controleNotas.notasAlunos.containsKey("João"));
        Assert.assertEquals(8.0, controleNotas.notasAlunos.get("João"), 0);
    }

    @Test
    public void testAtualizarNota() {
        controleNotas.adicionarNota("Maria", 7.0);
        controleNotas.atualizarNota("Maria", 9.0);
        Assert.assertEquals(9.0, controleNotas.notasAlunos.get("Maria"), 0);
    }

    @Test
    public void testCalcularNota() {
        controleNotas.adicionarNota("Ana", 10.0);
        Assert.assertEquals(10.0, controleNotas.calcularMedia("Ana"), 0);
    }

    @Test
    public void testObterNotaMaisAlta() {
        controleNotas.adicionarNota("Carlos", 5.0);
        controleNotas.adicionarNota("Carlos", 9.0); 
        Assert.assertEquals(9.0, controleNotas.obterNotaMaisAlta("Carlos"), 0);
    }

    @Test
    public void testObterNotaMaisBaixa() {
        controleNotas.adicionarNota("Fernanda", 9.0);
        controleNotas.adicionarNota("Fernanda", 6.0);
        Assert.assertEquals(6.0, controleNotas.obterNotaMaisBaixa("Fernanda"), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAlunoNaoEncontradoParaMedia() {
        controleNotas.calcularMedia("Ricardo");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAlunoNaoEncontradoParaNotaAlta() {
   
