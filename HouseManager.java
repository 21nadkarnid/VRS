import java.util.ArrayList;
public class HouseManager{//distribution center is first, also assuming at most one complex
  private ArrayList<House> houses = new ArrayList<House>();
  private int bp = 0;
  private int lp = 0;
  private int employees = 1;
  private House bart;
  private House lisa;
  public HouseManager(ArrayList<House> h, House b, int p, House l, int q){
    bart = c;
    bp = p;
    lisa = l;
    lp = q;
    houses = h;
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
  public int addBart(int a){
    return bart.distanceTo(houses.get(bart()+1+a*2)) + bart.distanceTo(houses.get(bart()+2+a*2)) - houses.get(bart()+1+a*2).distanceTo(houeses.get(bart()+2+a*2));
  }
  public int addLisa(int a){
    return lisa.distanceTo(houses.get(lisa()+1+a*2)) + lisa.distanceTo(houses.get(lisa()+2+a*2)) - houses.get(lisa()+1+a*2).distanceTo(houeses.get(lisa()+2+a*2));
  }
  public int lisa(){
  }
  public int bart(){
  }
  public int totDistance(){
    int previous = houses.size()-1;
    int tot = 0;
    for(int i = 0; i < houses.size(); i++){
      tot+= houses.get(previous).distanceTo(houses.get(i));
      previous = i;
    }
    if(bp > 100){
      tot+= houses.get(0).distanceTo(bart)*2;//edit
    }
    if(lp > 100){
      tot+= houses.get(0).distanceTo(lisa)*2;//edit
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
  public int switchD(int a, int b){
      House place = houses.get(a);
      House place1 = houses.get(b);
      houses.remove(a);
      houses.add(a, place1);
      houses.remove(b);
      houses.add(b, place);
      int ans = this.totDistance();
      houses.remove(a);
      houses.add(a, place);
      houses.remove(b);
      houses.add(b, place1);
      return ans;
  }
}
