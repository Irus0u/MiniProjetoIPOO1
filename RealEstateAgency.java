
/**
 * Classe representante da agencia
 *
 * @author (Joao)
 * @version (22/11/2021)
 */
public class RealEstateAgency
{
    private String name;
    private Listings listings;
    private Listing listing1;
    private Listing listing2;
    private Listing listing3;
    private Listing listing4;
    private Address address;
    private HouseData houseData;
    private static final short COMISSION = 3%100;
    private double earning;
    private Agent agent;

    
    public RealEstateAgency(String name)
    {
        this.name = name;
        listings = new Listings();
        address = null;
        listing1 = null;
        listing2 = null;
        listing3 = null;
        listing4 = null;
        houseData = null;
        agent = null;
        earning = 0.0;
    }
    
    public void addAgent(String name){
        agent = new Agent(name);
    }
    
    public void addListing(Listing newListing){      
        if(listing1 == null){
            listing1 = newListing;
            address = listing1.getAddress();
            houseData = listing1.getHouseData();
            listings.addListings(listing1);
        }else if(listing2 == null){
            listing2 = newListing;
            address = listing2.getAddress();
            houseData = listing2.getHouseData();
            listings.addListings(listing2);
        }else if(listing3 == null){
            listing3 = newListing;
            address = listing3.getAddress();
            houseData = listing3.getHouseData();
            listings.addListings(listing3);
        }else{
            listing4 = newListing;
            address = listing4.getAddress();
            houseData = listing4.getHouseData();
            listings.addListings(listing4);
        }
    }
    
    public void sellListing(Listing listing){
        if(listing.equals("listing1")){
            
            listings.setListing1(null);
            earning = earning + ((listing1.getPrice() * COMISSION)/100);
            listing1 = null;
        }else if(listing.equals("listing2")){
            
            listings.setListing2(null);
            earning = earning + ((listing2.getPrice() * COMISSION)/100);
            listing2 = null;
        }else if(listing.equals("listing3")){
            
            listings.setListing3(null);
            earning = earning + ((listing3.getPrice() * COMISSION)/100);
            listing3 = null;
        }else{
            
            listings.setListing4(null);
            earning = earning + ((listing4.getPrice() * COMISSION)/100);
            listing4 = null;
        }      
    }
    
    public void displayLocatedAt(String city){
        if(address.getCity().equals(city)){
            listings.displayListings();
        }
        else{
            System.out.println("Imovel nao encontrado, tente outra cidade.");
        }
    }
    
    public void displayListingsBetween(double value1, double value2){
        if(listing1 !=null){
            if((listing1.getPrice()>= value1) && (listing1.getPrice()<= value2)){
                listing1.display();
            }
        }
        
        if(listing2 !=null){
            if((listing2.getPrice()>= value1) && (listing2.getPrice()<= value2)){
                listing2.display();
            }
        }
        
        if(listing3 !=null){
            if((listing3.getPrice()>= value1) && (listing3.getPrice()<= value2)){
                listing3.display();
            }        
        }
        
        if(listing4 !=null){
            if((listing4.getPrice()>= value1) && (listing4.getPrice()<= value2)){
                listing4.display();
            }         
        }
    }
    
    public void displayListingsWithYard(){
        if((listing1 != null) && (listing1.getHouseData().isHasYard())){
            listing1.display();
        }
        
        if((listing2 != null) && (listing2.getHouseData().isHasYard())){
            listing2.display();
        }
        
        if((listing3 != null) && (listing3.getHouseData().isHasYard())){
            listing3.display();
        }
        
        if((listing4 != null) && (listing4.getHouseData().isHasYard())){
            listing4.display();
        }  
    }
    
    public void displayListings(){
        listings.displayListings();
    }
    
    public void display(){
        System.out.println("**************************");
        System.out.println(name);
        if((listings == null) && (listing3 != null)&&(listing4 != null)){
            System.out.println("Lista de imoveis indisponivel!");
        }else{
            System.out.println("Imoveis:");
            listing1.display();
            listing2.display();
            listing3.display();
            listing4.display();
            //listings.displayListings();
        }
        if(agent == null){
            System.out.println("Agente: ");    
        }else{
            agent.getName();
        }
        System.out.println(earning+" lucro");
    }
}
