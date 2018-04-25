import java.util.ArrayList;
public class HouseManager{//distribution center is first, also assuming at most one complex
  private ArrayList<House> houses = new ArrayList<House>();
  private int packages;
  private int employees;
  private House complex;
  public HouseManager(ArrayList<House> h, House c, int p, int e){
    complex = c;
    houses = h;
    packages = p;
    employees = e;
  }
  public HouseManager(ArrayList<House> h, int p, int e){
    houses = h;
    packages = p;
    employees = e;
  }
  public ArrayList<House> getList(){
    return houses;
  }
  public int totDistance(){
    int previous = houses.size()-1;
    int tot;
    if(packages - 100 < houses.size()){//first house is center
      for(int i = 0; i < houses.size(); i++){
        tot+= houses.get(previous).distanceTo(houses.get(i));
        previous = i;
      }
    }else{
      for(int i = 0; i < houses.size(); i++){
        tot+= houses.get(previous).distanceTo(houses.get(i));
        previous = i;
      }
      tot+= houses.get(0).distanceTo(complex)*2;
    }
    return tot;
  }
  //not including methods to calculate cost because that is easier in the algorithm - more accurate maintainance
  public int time(){
    int t = totDistance()/1000*30;//seconds
    t += 60/employees*packages;
  }
}
