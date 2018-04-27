import java.util.ArrayList;
public class HouseManager{//distribution center is first, also assuming at most one complex
  private ArrayList<House> houses = new ArrayList<House>();
  private int packages = 0;
  private int employees = 1;
  private House complex;
  public HouseManager(ArrayList<House> h, House c, int p){
    complex = c;
    houses = h;
    packages = p;
  }
  public HouseManager(ArrayList<House> h){
    houses = h;
  }
  public HouseManager(){
  }
  public void setE(int i){
    employees = i;
  }
  public ArrayList<House> getList(){
    return houses;
  }
  public int totDistance(){
    int previous = houses.size()-1;
    int tot = 0;
    if(packages < 101){//first house is center
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
  public double time(){
    double t = totDistance()/1000.0*30.0;//seconds
    t += 60.0/employees*(packages+houses.size()-1);
    return t/3600;
  }
  public void switch(int a, int b){
      House place = houses.get(a);
      House place1 = houses.get(b);
      houses.remove(a);
      houses.add(a, place1);
      houses.remove(b);
      houses.add(b, place);
  }
}
