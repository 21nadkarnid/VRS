import java.util.ArrayList;
public class HouseManager{
  private ArrayList<House> houses = new ArrayList<House>();
  public HouseManager(House h){
    houses.add(h);
  }
  public ArrayList<House> getList(){
    return houses;
  }
  public int totDistance(){
    int previous = houeses.size()-1;
    int tot;
    for(int i = 0; i < houses.size(); i++){
      tot+= houses.get(previous).distanceTo(houses.get(i));
      previous = i;
    }
    return tot;
  }
  public int costExEm(){
    return totDistance()/1000;
  }
}
