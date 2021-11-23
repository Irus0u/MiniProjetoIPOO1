
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
    private Agent agent1;
    private Agent agent2;
    
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
        agent1 = null;
        agent2 = null;
        earning = 0.0;
    }
    
    public void addAgent(Agent agent){
        if(agent1 == null){
            agent1 = agent;
        }else{
            agent2 = agent;
        }
    }
    
    public void addListing(Listing newListing){
        if(isAbleToAtribute(newListing)){
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
        }else{
            System.out.println("Operacao nao efetuada, valor minimo de 4000$/m2");
        }
        
        if(agent1 != null && agent2 !=null){
            if((agent1.getEarnings() == agent2.getEarnings())){
                if(agent1.isAcceptingListings()){
                    agent1.addListing(newListing);
                }else{
                    agent2.addListing(newListing);
                }
            }
            
            if((agent1.getEarnings() < agent2.getEarnings())){
                if(agent1.isAcceptingListings()){
                    agent1.addListing(newListing);
                }
            }
            
            if(agent2.getEarnings() < agent1.getEarnings()){
                if(agent2.isAcceptingListings()){
                    agent2.addListing(newListing);
                }
            }
        }else{
            System.out.println("Sem agentes para atribuir imoveis.");
        }
    }
    
    public void sellListing(Listing listing){
        if(listing1 == listing){
            listings.setListing1(null);
            earning = earning + ((listing1.getPrice() * COMISSION)/100);
            if(agent1.getListing1() == listing){
                agent1.markAsSold(listing);
            }else{
                agent2.markAsSold(listing);
            }
            listing1 = null;
        }
        
        if(listing2 == listing){
            listings.setListing2(null);
            earning = earning + ((listing2.getPrice() * COMISSION)/100);
            listing2 = null;
            if(agent1.getListing2() == listing){
                agent1.markAsSold(listing);
            }else{
                agent2.markAsSold(listing);
            }
        }
        
        if(listing3 == listing){
            listings.setListing3(null);
            earning = earning + ((listing3.getPrice() * COMISSION)/100);
            listing3 = null;
            if(agent1.getListing1() == listing){
                agent1.markAsSold(listing);
            }else{
                agent2.markAsSold(listing);
            }
        }
        
        if(listing4 == listing){
            listings.setListing4(null);
            earning = earning + ((listing4.getPrice() * COMISSION)/100);
            listing4 = null;
            if(agent1.getListing2() == listing){
                agent1.markAsSold(listing);
            }else{
                agent2.markAsSold(listing);
            }
        }
    }
    
    public void displayLocatedAt(String city){
        if((listing1 != null) && (listing1.getAddress().getCity() == city)){
            listing1.display();
        }
        
        if((listing2 != null) && (listing2.getAddress().getCity() == city)){
            listing2.display();
        }
        
        if((listing3 != null) && (listing3.getAddress().getCity() == city)){
            listing3.display();
        }
        
        if((listing4 != null) && (listing4.getAddress().getCity() == city)){
            listing4.display();
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
        int i = name.length();
        int j;
        for(j=0; j<i+2; j++){
            System.out.print("*");  
        }
        System.out.println("");
        System.out.println("*"+ name +"*");
        for(j=0; j<i+2; j++){
            System.out.print("*");  
        }
        System.out.println("");
        System.out.println("");
        
        if((listings == null)){
            System.out.println("Lista de imoveis indisponivel!");
        }else{
            System.out.println("Imoveis:");
            listings.displayListings();
        }
        if(agent1 == null && agent2 == null){
            System.out.println("Agentes: ");    
        }else{
            System.out.println("Agentes: ");
            System.out.println(agent1.getName());
            System.out.println(agent2.getName());
        }
        System.out.println("Lucro: "+earning+"$");
    }
    
    private boolean isAbleToAtribute(Listing listing){
        if((listing.getPrice() * listing.getHouseData().getArea()) < 4000){
            return false;
        }else{
            return true;
        } 
    }
    
}
