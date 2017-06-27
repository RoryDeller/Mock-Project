
public class Address
{
  private String Street; 
  private String City;
  private String postCode;
  
  public Address(String Street, String City, String postCode) 
    {        
        this.Street = Street;
        this.City = City;
        this.postCode = postCode;
    }

    //override the toString() method, if you don't have this when outputting you get a reference to the object
    // not the values of the object
    @Override   
    public String toString() 
    {
        return this.Street + ", " + this.City + ", " +   this.postCode;
    }

    //methods - getters and setters, also known as accessor methods
    public String getStreet() { return Street;}

    public String getCity() {return City;}

    public String getpostCode() {return postCode;}

    //this keyword highlights that the attribute is being assigned to rather than the parameter being assigned to itself
    public void setRanking(String Street) {this.Street = Street;}

    public void setName(String City){ this.City = City;}

    public void setCountry(String postCode){this.postCode = postCode;}
    
}
