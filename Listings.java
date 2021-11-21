
/**
 * Classe representante dos imoveis.
 *
 * @author (João)
 * @version (21/11/2021)
 */
public class Listings
{
    private Listing listings;
    private Address address;
    private HouseData houseData;
    
    public Listings(double newPrice, String newAddress, String newPostalCode, String newCity, double newArea, boolean newHasYard){
        address = new Address(newAddress, newPostalCode, newCity);
        houseData = new HouseData(newArea, newHasYard, address.getAddress(), address.getPostalCode(), address.getCity());
        listings = new Listing(newPrice, address.getAddress(), address.getPostalCode(), address.getCity(), houseData.getArea(), houseData.isHasYard());
    }
    
    public void displayListings(){
        listings.display();
    }
}
