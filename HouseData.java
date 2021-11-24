
/**
 * Classe representante dos detalhes de um imovel.
 *
 * @author (João)
 * @version (17/11/2021)
 */
public class HouseData
{
    private Address address;
    private double area;
    private boolean hasYard;
    
    //construtor de houseData
    public HouseData(double newArea, boolean newHasYard, String newAddress, String newPostalCode, String newCity){
        address = new Address(newAddress, newPostalCode, newCity);
        if(newArea > 0){
            area = newArea; //m^2
        }else{
            area = 10; //m^2
        }
        hasYard = newHasYard;
    }
    
    //selector da area
    public double getArea(){
        return area;
    }
    
    //modificador da area
    public void setArea(double newArea){
        if(newArea > 0){
            area = newArea; //m2
        }else{
            area = 10; //m2, atribuicao por defeito
        }
    }
    
    //verificar se tem quintal
    public boolean isHasYard(){
        return hasYard;
    }
    
    //modificador do quintal
    public void setHasYard(boolean newHasYard){
        hasYard = newHasYard;
    }
}
