
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList; //Libraries Needed for getting the read file into a arraylist

public class ApplicationHelper
{
    public static ArrayList<Address> myAddresses = new ArrayList<Address>();
    public static void getAddresses() throws IOException{
          FileReader fr = new FileReader("Address.txt");
          BufferedReader br = new BufferedReader(fr);
           String line;
          do {
              line = br.readLine();
              String[] values = line.split(","); //This reads the file and creates a object that
              Address address = new Address(values[0], values[1], values[2]);
              myAddresses.add(address);
          } while ((line = br.readLine()) != null);
    }
    
  
}
