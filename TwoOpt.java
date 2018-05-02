import java.util.ArrayList;

public class TwoOpt {
  public HouseManager TO (HouseManager input) {
   HouseManager path = TwoOpt.NN(input);
   boolean done = false;
   while (!done) {
     done = true;
     int dist = path.totDistance();
     int[] best = new int[2];
     for (int i = 1; i < path.getList().size(); i++) {
       for (int j = 0; j < i; j++) {
         if (path.switchD(j, i) < dist) {
           best[0] = j;
           best[1] = i;
           done = false;
         }
       }
     }
     path.switch(j, i);
   }
   return path;
  }
  public HouseManager NN(HouseManager list, House complex) {
    House home = new House(125, 22, 'a');
    House current = home;
    ArrayList<House> path = new ArrayList<House>();
    boolean[] delivered = new boolean[list.getList().size()];
    for (int i = 0; i < list.getList().size(); i++) {
      int currentBest = -1;
      int minDist = 65536;
      int j;
      for (j = 0; j < list.getList().size(); j++) {
        if (!delivered[j] && list.getList().get(j).distanceTo(current) < minDist) {
          minDist = list.getList().get(j).distanceTo(current);
          currentBest = j;
        }
      }
      current = list.getList().get(j);
      path.add(current);
      delivered[j] = true;
    }
    return new HouseManager(path);
  }

}
