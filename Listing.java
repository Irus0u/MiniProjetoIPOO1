
/**
 * Classe representante do imovel.
 *
 * @author (João)
 * @version (21/11/2021)
 */
public class Listing
{
    private double price;
    private Address address;
    private HouseData houseData;
    private static int identifier;
    
    public Listing(double newPrice, String newAddress, String newPostalCode, String newCity, double newArea)
    {
        if(newPrice > 0){
            price = newPrice;
        }else{
            price = 0;
        }
        
        //atribuir os valores da classe Address
        address = new Address(newAddress, newPostalCode, newCity);
        
        //atribuir os valores da classe HouseData
        houseData = new HouseData(newArea, false, address.getAddress(), address.getPostalCode(), address.getCity());
        
        identifier++;
    }

    public Listing(double newPrice, String newAddress, String newPostalCode, String newCity, double newArea, boolean newHasYard)
    {
        if(newPrice > 0){
            price = newPrice;
        }else{
            price = 0;
        }
        
        //atribuir os valores da classe Address
        address = new Address(newAddress, newPostalCode, newCity);
        
        //atribuir os valores da classe HouseData
        houseData = new HouseData(newArea, newHasYard, address.getAddress(), address.getPostalCode(), address.getCity());
        
        identifier++;
    }
    
    public Listing(double newPrice, String newAddress, double newArea, String newCity, boolean newHasYard)
    {
        if(newPrice > 0){
            price = newPrice;
        }else{
            price = 0;
        }

        //atribuir os valores da classe Address
        address = new Address(newAddress, "", newCity);

        //atribuir os valores da classe HouseData
        houseData = new HouseData(newArea, newHasYard, address.getAddress(), "", address.getCity());

        identifier++;      
    }
    
    public boolean isLocatedAt(String newCity){
        if(newCity == address.getCity()){
            return true;
        }else{
            return false;
        }
    }
    
    public double getPrice(){
        return price;
    }
    
    public Address getAddress(){
        return address;
    }
    
    public HouseData getHouseData(){
        return houseData;
    }
    
    public int getIdentifier(){
        return identifier;
    }
    
    public void display(){
        String yard;
        System.out.println("**************************");
        System.out.println("# " + identifier + " preco " + price);
        if(address.getPostalCode() == ""){
            System.out.println(address.getAddress() + "," + address.getCity());
        }else{
            System.out.println(address.getAddress() + "," + address.getPostalCode() + "," + address.getCity());
        }
        System.out.println(houseData.getArea() + " m2");
        if(houseData.isHasYard()){
            yard = "tem.";
        }else{
            yard = "não tem.";
        }
        System.out.println("Quintal: " + yard);
    }
}
