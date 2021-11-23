
/**
 * Classe representante da agencia
 *
 * @author (João)
 * @version (22/11/2021)
 */
public class RealEstateAgency
{
    private String name;
    private Listings listings;
    private Listing listing;
    private Address address;
    private HouseData houseData;
    private static final short COMISSION = 3%100;
    private double earning;
    private Agent agent;

    
    public RealEstateAgency(String name)
    {
        this.name = name;
        listings = null;
        address = null;
        listing = null;
        houseData = null;
        agent = null;
        earning = 0.0;
    }
    
    public void addAgent(String name){
        new Agent(name);
    }
    
    public void addListing(double newPrice, String newAddress, String newPostalCode, String newCity, double newArea, boolean newHasYard){
        address = new Address(newAddress, newPostalCode, newCity);
        houseData = new HouseData(newArea, newHasYard, address.getAddress(), address.getPostalCode(), address.getCity());
        listing = new Listing(newPrice, address.getAddress(), address.getPostalCode(), address.getCity(), houseData.getArea(), houseData.isHasYard());
        listings = new Listings();
        listings.addListings(listing);
    }
    
    public void sellListing(Listing listing){
        if(listing.equals("listing1")){
            listing = null;
            listings.setListing1(null);
            earning = earning + ((listing.getPrice() * COMISSION)/100);
        }else if(listing.equals("listing2")){
            listing = null;
            listings.setListing2(null);
            earning = earning + ((listing.getPrice() * COMISSION)/100);
        }else if(listing.equals("listing3")){
            listing = null;
            listings.setListing3(null);
            earning = earning + ((listing.getPrice() * COMISSION)/100);
        }else{
            listing = null;
            listings.setListing4(null);
            earning = earning + ((listing.getPrice() * COMISSION)/100);
        }      
    }
    
    public void displayLocatedAt(String city){
        if(address.getCity().equals(city)){
            listing.display();
        }
        else{
            System.out.println("Imóvel não encontrado, tente outra cidade.");
        }
    }
    
    public void displayListingsBetween(double value1, double value2){
        if((listing.getPrice()>= value1) && (listing.getPrice()<= value2)){
            listing.display();
        }
        else{
            System.out.println("Imóvel não encontrado, tente outros valores.");
        }    
    }
    
    public void displayListingsWithYard(){
        if(houseData.isHasYard()){
            listing.display();
        }else{
            System.out.println("Imóvel com quintal não encontrado.");
        }   
    }
    
    public void displayListings(Listings checkListings){
        if(listings.equals(checkListings)){
            listings.displayListings();
        }
    }
    
    public void display(){
        System.out.println("**************************");
        System.out.println(name);
        System.out.println("Imóveis:");
        listings.displayListings();
        agent.getName();
        System.out.println(earning+" lucro");
    }
}
