
/**
 * Classe representante dos imoveis.
 *
 * @author (João)
 * @version (21/11/2021)
 */
public class Listings
{
    private Listing listings;
    private Listing newListings;
    private Address address;
    private HouseData houseData;
    
    public Listings(){
    }
    
    public void displayListings(){
        if(listings == null){
            System.out.println("Sem imóveis.");
        }else{
            listings.display();
        }
    }
    
    public void addListings(Listing listings){
        newListings = new Listing(listings.getPrice(), address.getAddress(), address.getPostalCode(), address.getCity(), houseData.getArea(), houseData.isHasYard());
    }
}
