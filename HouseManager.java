import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
public class HouseManager{
  private ArrayList<House> houses = new ArrayList<House>();
  private int bp = 0;
  private int lp = 0;
  private int employees = 1;
  private House bart;
  private House lisa;
  public HouseManager(File f) throws Exception{
    Scanner s = new Scanner(f);
    String current = "";
    String previous = "";
    while(s.hasNextLine()){
      current = s.next();
      if(current.contains(",")){
        houses.add(new House(current));
      }else if(previous.contains("B")){
        bp = Integer.parseInt(current);
      }else if(previous.contains("L")){
        lp = Integer.parseInt(current);
      }
      previous = current;
    }
  }      
  public HouseManager(ArrayList<House> h, House b, int p, House l, int q){
    bart = b;
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
    int ans = bart.distanceTo(houses.get(findH(bart)+1+a*2)) + bart.distanceTo(houses.get(findH(bart)+2+a*2)) - houses.get(findH(bart)+1+a*2).distanceTo(houses.get(findH(bart)+2+a*2));
    return ans;
  }
  public int addLisa(int a){
    return lisa.distanceTo(houses.get(findH(lisa)+1+a*2)) + lisa.distanceTo(houses.get(findH(lisa)+2+a*2)) - houses.get(findH(lisa)+1+a*2).distanceTo(houses.get(findH(lisa)+2+a*2));
  }
  public int findH(House a){
    for(int i = 0; i < houses.size(); i++){
      if(a.equals(houses.get(i))){
         return i;
      }
    }
    return -1;
  }
  public int totDistance(){
    int previous = houses.size()-1;
    int tot = 0;
    for(int i = 0; i < houses.size(); i++){
      tot+= houses.get(previous).distanceTo(houses.get(i));
      previous = i;
    }
    int btp = 0;
    int bpt = bp;
    while(bp > 100){
      tot+= addBart(btp);
      btp++;
      bpt-=100;
    }
    int ltp = 0;
    int lpt = lp;
    while(lp > 100){
      tot+= addLisa(ltp);
      ltp++;
      lpt-=100;
    }
    return tot;
  }
  //not including methods to calculate cost because that is easier in the algorithm - more accurate maintainance
  public double time(){
    double t = totDistance()/1000.0*30.0;//seconds
    t += 60.0/employees*(bp+lp+houses.size()-3);
    return t/3600;
  }
  public void switchF(int a, int b){
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
