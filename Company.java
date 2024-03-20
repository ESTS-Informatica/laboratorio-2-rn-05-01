
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;


/**
 * Manage a company.
 *
 * @author POO
 * @version 03/2024
 */
public class Company {

    // Clients registry
    private ArrayList<User> clients;
    // Sellers registry
    private ArrayList<User> sellers;
    // Properties registry
    private ArrayList<Property> properties;
    // Sells registry
    private ArrayList<Sell> sells;

    /**
     * Constructor of class Company
     */
    public Company() {
        this.clients = new ArrayList<>();
        this.sellers = new ArrayList<>();
        this.properties = new ArrayList<>();
        this.sells = new ArrayList<>();

    }

    /**
     * Get the list of clients.
     *
     * @return This company clients.
     */
    public List<User> getClients() {
        return this.clients;        
    }

    /**
     * Get the list of sellers.
     *
     * @return This company sellers.
     */
    public List<User> getSellers() {
        return this.sellers;         
    }

    /**
     * Get the list of properties.
     *
     * @return This company's properties.
     */
    public List<Property> getProperties() {
        return this.properties;         
    }

    /**
     * Get the list of sells.
     *
     * @return This company sells.
     */
    public List<Sell> getSells() {
        return this.sells;         
    }

    /**
     * Register a client.
     *
     * @param client to register. Must not be null. Must not be registered.
     * @return true If the registration succeeds, false otherwise.
     */
    public boolean registerClient(User client) {
        if (client == null  || clients.contains(client)){
            return false;
        }

       

        clients.add(client);
        return true; // Cliente registrado com sucesso
    }

    /**
     * Register a seller.
     *
     * @param seller to register. Must not be null. Must not be registered.
     * @return true If the registration succeeds, false otherwise.
     */
    public boolean registerSeller(User seller) {
        if ( seller == null || sellers.contains(seller)) {
            return false;
        }

        sellers.add(seller);
        return true; // seller registrado com sucesso
    }

    /**
     * Register a property.
     *
     * @param property to register. Must not be null. Must not be registered.
     * @return true If the registration succeeds, false otherwise.
     */
    public boolean registerProperty(Property property) {
         if ( property == null || properties.contains(property)) {
            return false;
        }
        properties.add(property);
        return true;         
    }

    /**
     * Register a sell.
     *
     * @param sell to register. Must not be null. Must not be registered.
     * @return true If the registration succeeds, false otherwise.
     */
    public boolean registerSell(Sell sell) {
         if ( sell == null || sells.contains(sell)) {
            return false;
        }
        sells.add(sell);
        return true;      
    }

    /**
     * Generate a new sell and register that sell.
     *
     * @param client Must be already registered.
     * @param seller Must be already registered.
     * @param property Must be already registered.
     * @return true If the request succeeds, false otherwise.
     */
    public boolean createSell(User client, User seller, Property property) {
        if (client == null || seller == null || property == null) {
        return false; // Se algum dos parâmetros for nulo, a venda não pode ser criada
    } else if (!clients.contains(client) || !sellers.contains(seller) || !properties.contains(property)) {
        return false; // Se o cliente, vendedor ou propriedade não estiverem registrados, a venda não pode ser criada
    } else {
        // Criar a venda
        Sell sell = new Sell(client, seller, property);

        // Registrar a venda
        if (!registerSell(sell)) {
            return false;
        }

        return true; // Venda criada e registrada com sucesso
    }
    }

    /**
     * Calculates the total number of sells within the provided year.
     *
     * @param year
     * @return The total number of sells in the year.
     */
    public int calculateSellsOfTheYear(int year) {
        int totalSells = 0;

    // Iterar sobre as vendas e contar aquelas que ocorreram no ano fornecido
    for (Sell sell : sells) {
        if (sell.getDate().getYear() == year) {
            totalSells++;
        }
    }

    return totalSells;
    }

    /**
     * Find the seller with more sells within the provided year.
     *
     * @param year
     * @return The name of the seller of the year.
     */
    public String findSellerOfTheYear(int year) {
          String sellerOfTheYear = null;
        int maxSells = 0;

        for (Sell sell : sells) {
            if (sell.getDate().getYear() == year) {
                User seller = sell.getSeller();
                int sellsCount = countSellsForSeller(seller, year);
                if (sellsCount > maxSells) {
                    maxSells = sellsCount;
                    sellerOfTheYear = seller.getName();
                }
            }
        }

        return sellerOfTheYear;
            

}
/**
 * Método auxiliar para contar o número de vendas de um vendedor
 */
private int countSellsForSeller(User seller, int year) {
        int sellsCount = 0;
        for (Sell sell : sells) {
            if (sell.getSeller().equals(seller) && sell.getDate().getYear() == year) {
                sellsCount++;
            }
        }
        return sellsCount;
    }
}
