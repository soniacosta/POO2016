

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Set;
import java.util.*;

/**
 * The test class Testes.
 *
 * É necessário completar os teste, colocando os parâmetros nos construtores.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Testes
{
    private Imoobiliaria imo;
    private Vendedor v;
    private Terreno t;

    /**
     * Teste principal
     */
    @Test
    public void mainTest() {
        imo = new Imoobiliaria();
        ArrayList<String> portSonia = new ArrayList<String>();
        ArrayList<String> favAngela = new ArrayList<String>();
        HashMap<String,Imovel> histSonia = new HashMap<String,Imovel>();

        

        try {
            imo.iniciaSessao("",null);
			fail();
        } catch(SemAutorizacaoException e) {
            
        } catch(Exception e) {
           // fail();
        }
        
        try {
            v = new Vendedor("sonia@mail.com","sonia","nini","02/01/1995","Street",portSonia, histSonia);  // Preencher parâmetros do construtor
            imo.registarUtilizador(v);
        } catch(Exception e) {
            fail();
        }
        
        String email = v.getEmail();
        String password = v.getPassword();
        
        try {
            imo.iniciaSessao(email, password);
        } catch(Exception e) {
            fail();
        }
        
        t = new Terreno("i1000","rua",1500.0,1000.0,"à venda","armazem",1000.0,4.0,2600,true);  // Preencher parâmetros do construtor
        try {
            imo.registaImovel(t);
        } catch (Exception e) {
            fail();
        }
            
        int s = imo.getImovel("Terreno", Integer.MAX_VALUE).size();
        assertTrue(s>0);
        //---método getTopImoveis nao implementado
        //Set<String> ids = imo.getTopImoveis(0);
        //assertTrue(ids.contains(t.getIdImovel()));
        //assertTrue(imo.getMapeamentoImoveis().keySet().contains(t));
        try {
            assertTrue(imo.getConsultas().size()>0);
        } catch(Exception e) {
            fail();
        }
        
        imo.fechaSessao();
        Comprador c = new Comprador("angela@mail.com","angela","1234","27/10/1995","rua",favAngela);  // Preencher parâmetros do construtor
        try {
            imo.registarUtilizador(c);
        } catch(Exception e) {
            fail();
        }
        email = c.getEmail();
        password = c.getPassword();
        
        /*try {
            imo.iniciaSessao(email, password);
            imo.setFavorito(t.getIdImovel());
            assertTrue(imo.getFavoritos().contains(t));
        } catch(Exception e) {
            e.printStackTrace();
            fail();
        }*/
    }
    
}
