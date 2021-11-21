
/**
 * Classe representante do vendedor.
 *
 * @author (João)
 * @version (14/11/2021)
 */
public class Address
{
    private String address;
    private String postalCode;
    private String city;
    
    public Address(String newAddress, String newPostalCode, String newCity){
        address = newAddress;
        postalCode = newPostalCode;
        city = newCity;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String newAddress){
        address = newAddress;    
    }
    
    public String getPostalCode(){
        return postalCode;
    }
    
    public void setPostalCode(String newPostalCode){
        postalCode = newPostalCode;    
    }
    
    public String getCity(){
        return city;
    }
    
    public void setCity(String newCity){
        city = newCity;
    }
}
