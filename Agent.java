
/**
 * Classe representante do vendedor.
 *
 * @author (João)
 * @version (21/11/2021)
 */
public class Agent
{
    private String name;
    private int sales;
    private static final double COMISSION = 2%100;
    private Listings listing1;
    private Listings listing2;
    
    public Agent(String newName)
    {
        name = newName;
        sales = 0;
        listing1 = null;
        listing2 = null;
    }
    
    public String getName(){
        return name;
    }
    
    public int getSales(){
        return sales;
    }
    
    public double getComission(){
        return COMISSION;
    }
    
    public void display(){
        System.out.println(name);
        System.out.println(displayListings());
        System.out.println("Comissoes: "+COMISSION);
        System.out.println("Imoveis vendidos: "+sales);
    }
    
    public Listing displayListings(){
        return null;//listing1.displayListings() + listing2.displayListings();
    }
    
    public boolean isAcceptingListings(){
        if((listing1 != null) && (listing2 != null)){
            return false;
        }else{
            return true;
        }
    }
    
    public void addListing(){}
    
    public void markAsSold(){}
}
