

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste PropertyTest.
 *
 * @author  (seu nome)
 * @version (um número da versão ou uma data)
 */
public class PropertyTest
{
    /**
     * Construtor default para a classe de teste PropertyTest
     */
    public PropertyTest()
    {
    }
    
    @Test
    public void testConstructor(){
       

        // Criar objeto Property
        Property property1 = new Property("T3 Monte Belo", 150000);

        // Verificar se os valores fornecidos foram configurados corretamente
        assertEquals("T3 Monte Belo", property1.getDescription());
        assertEquals(150000, property1.getPrice(), 0.001);
    }

    /**
     * Define a 'fixture' do teste.
     *
     * Chamado antes de cada método de caso de teste.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Desfaz a 'fixture' do teste.
     *
     * Chamado após cada método de teste de caso.
     */
    @AfterEach
    public void tearDown()
    {
    }
}
