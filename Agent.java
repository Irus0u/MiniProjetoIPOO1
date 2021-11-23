
/**
 * Classe representante do vendedor.
 *
 * @author (João)
 * @version (22/11/2021)
 */
public class Agent
{
    private String name;
    private int sales;
    private double earning;
    private static final short COMISSION = 2%100;
    private static Listing listing1;
    private static Listing listing2;
    
    public Agent(String newName)
    {
        name = newName;
        sales = 0;
        listing1 = null;
        listing2 = null;
        earning = 0.0;
    }
    
    public String getName(){
        return name;
    }
    
    public int getSales(){
        return sales;
    }
    
    public double getEarnings(){
        return earning;
    }
    
    public void display(){
        getName();
        displayListings();
        System.out.println("Comissoes: "+earning);
        System.out.println("Imoveis vendidos: "+sales);
    }
    
    public void displayListings(){
       if(listing1 == null){
           System.out.println("Sem imovel.");
       }else{
           listing1.display(); 
       }
       
       if(listing2 == null){
           System.out.println("Sem imovel."); 
       }else{
           listing2.display(); 
       } 
    }
    
    public boolean isAcceptingListings(){
        if((listing1 != null) && (listing2 != null)){
            return false;
        }else{
            return true;
        }
    }
    
    public void addListing(Listing addListing){
        if(isAcceptingListings()){
            if(listing1 == null){
                listing1 = addListing;
            }else{
                listing2 = addListing;
            }
        }else{
            System.out.println("Lista de imoveis cheia.");
        }
    }
    
    public void markAsSold(Listing sellListing){
        sales++;
        if((listing1 == null)&&(listing2 == null)){
            System.out.println("Sem imoveis para venda.");
        }else{
            if(listing1 != null && listing2 == null){
                earning = earning + ((listing1.getPrice() * COMISSION)/100);
                listing1 = null;
            }else{
                earning = earning + ((listing2.getPrice() * COMISSION)/100);
                listing2 = null;
            }
        }
    }
}
