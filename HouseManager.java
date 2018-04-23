import java.util.ArrayList;
public class HouseManager{
  private ArrayList<House> houses = new ArrayList<House>();
  public HouseManager(House h){
    houses.add(h);
  }
  public ArrayList<House> getList(){
    return houses;
  }
}
