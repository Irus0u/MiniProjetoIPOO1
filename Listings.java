
/**
 * Classe representante dos imoveis.
 *
 * @author (João)
 * @version (22/11/2021)
 */
public class Listings
{
   private Listing listing1;
   private Listing listing2;
   private Listing listing3;
   private Listing listing4;
    
   public Listings(){
       listing1 = null;
       listing2 = null;
       listing3 = null;
       listing4 = null;
   }
    
   public Listing getListing1(){
       if(listing1 != null){
           return listing1; 
       }else{
           return null; 
       }
   }
   
   public Listing getListing2(){
       if(listing2 != null){
           return listing2; 
       }else{
           return null; 
       }
   } 
   
   public Listing getListing3(){
       if(listing3 != null){
           return listing3; 
       }else{
           return null; 
       }
   } 
   
   public Listing getListing4(){
       if(listing4 != null){
           return listing4; 
       }else{
           return null; 
       }
   }   
   
   public void setListing1(Listing newListing1){
        listing1 = newListing1;
   }
   
   public void setListing2(Listing newListing2){
        listing2 = newListing2;
   }
   
   public void setListing3(Listing newListing3){
        listing3 = newListing3;
   }
   
   public void setListing4(Listing newListing4){
        listing4 = newListing4;
   }
   
   public void displayListings(){
       if(listing1 == null){
       }else{
           listing1.display(); 
       } 
       
       if(listing2 == null){
       }else{
           listing2.display(); 
       } 
       
       if(listing3 == null){
       }else{
           listing3.display(); 
       } 
       
       if(listing4 == null){
       }else{
           listing4.display();        
       }
   }
   
   public void addListings(Listing addListing){
       if(listing1 == null){
           listing1 = addListing;
       }else if(listing2 == null){
           listing2 = addListing;
       }else if(listing3 == null){
           listing3 = addListing;
       }else{
           listing4 = addListing;
       }
   }
}
