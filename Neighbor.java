import java.util.ArrayList;

public class Neighbor {
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
      path.add(list.getList().get(j));
      delivered[j] = true;
    }
    return new HouseManager(path);
  }
}
