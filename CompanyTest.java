

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste CompanyTest.
 *
 * @author  (seu nome)
 * @version (um número da versão ou uma data)
 */
public class CompanyTest
{
    Company company;
    User client1, client2, seller1, seller2;
    Property property1, property2;
    Sell sell1, sell2;

    /**
     * Construtor default para a classe de teste CompanyTest
     */
    public CompanyTest()
    {
    }
    
    @Test
    public void testConstructor(){
        
        assertNotNull(company.getClients());
        assertNotNull(company.getSellers());
   
    }
    //Clients
    @Test
    public void testRegisterClient(){
       
        assertTrue(company.registerClient(client1));
        
        assertTrue(company.getClients().contains(client1));

        
    }
    
    @Test
    public void testRegisterClients(){
        assertTrue(company.registerClient(client1));
        assertTrue(company.registerClient(client2));
        
        assertTrue(company.getClients().contains(client1));
        assertTrue(company.getClients().contains(client2));
        
    }
    
    @Test
    public void testRegisterClientDuplicate(){
         
         company.registerClient(client1);
         assertFalse(company.registerClient(client1));
         
        
    }
    @Test
    public void testRegisterClientNull(){
        // Tentar registrar um cliente null
        assertFalse(company.registerClient(null));
        
    }
    //Sellers
    @Test
     public void testRegisterSeller(){
       
        assertTrue(company.registerSeller(seller1));
        
        assertTrue(company.getSellers().contains(seller1));

        
    }
    @Test
     public void testRegisterSellers(){
        assertTrue(company.registerSeller(seller1));
        assertTrue(company.registerSeller(seller2));
        
        //assertTrue(company.getSellers().contains(seller1));
        //assertTrue(company.getSellers().contains(seller2));
        
    }
    @Test
    public void testRegisterSellerDuplicate(){
         
         company.registerSeller(seller1);
         assertFalse(company.registerSeller(seller1));
         
        
    }
    @Test
    public void testRegisterSellerNull(){
        // Tentar registrar um cliente null
        assertFalse(company.registerSeller(null));
        
    }
    //Properties
    @Test
     public void testRegisterProperty(){
       
        assertTrue(company.registerProperty(property1));
        
        assertTrue(company.getProperties().contains(property1));

        
    }
    @Test
     public void testRegisterProperties(){
        assertTrue(company.registerProperty(property1));
        assertTrue(company.registerProperty(property2));
    
    }
    @Test
    public void testRegisterPropertyDuplicate(){
         
         company.registerProperty(property1);
         assertFalse(company.registerProperty(property1));
         
        
    }
    @Test
    public void testRegisterPropertyNull(){
        // Tentar registrar um cliente null
        assertFalse(company.registerProperty(null));
        
    }
    //SELLS
    @Test
    public void testCreateSell(){
        company.registerClient(client1);
        company.registerSeller(seller1);
        company.registerProperty(property1);
 
        assertTrue(company.createSell(client1, seller1, property1));
        
        
    }
    @Test
    public void testCalculateSellsOfTheYear(){
        company.registerSell(sell1);
        company.registerSell(sell2);
        
        assertEquals(2,company.calculateSellsOfTheYear(2024));
    }
    @Test
    public void testFindSellerOfTheYear(){
        company.registerSell(sell1);
        company.registerSell(sell2);

        // Encontrar o vendedor do ano 2024
        String sellerOfTheYear = company.findSellerOfTheYear(2024);

        // Verificar se o vendedor encontrado é o esperado
        assertEquals("Fernando Fernandes", sellerOfTheYear);
    }
    /**
     * Define a 'fixture' do teste.
     *
     * Chamado antes de cada método de caso de teste.
     */
    @BeforeEach
    public void setUp()
    {
        this.company = new Company();

        // Criar objetos User conforme a tabela 2
        this.client1 = new User("José Manuel", "911111111", "zemanel@yahoo.com");
        this.client2 = new User("António Francisco", "922222222", "tochico@hotmail.com");
        this.seller1 = new User("Fernando Fernandes", "966777101", "fefe@remax.pt");
        this.seller2 = new User("Rodrigo Rodrigues", "966777152", "roro@remax.pt");
        this.property1 = new Property("T3 Monte Belo", 150000.0);
        this.property2 = new Property("Casa de Praia", 250000.0);
        
        this.sell1 = new Sell(client1, seller1, property1);
        this.sell2 = new Sell(client2, seller2, property2);
        

      
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
