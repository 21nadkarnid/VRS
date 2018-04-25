public class Neighbor {
  public HouseManager NN(HouseManager list, House complex) {
    House home = new House(125, 22, a);
    House current = home;
    ArrayList<House> path = new ArrayList<House>();
    HouseManager ans;
    int currentBest = -1;
    int minDist = 65536;
    for (int i = 0; i < path.getList().size(); i++) {
      for (int j = 0; j < path.getList().size(); j++) {
        if (list.getList().get(j).distanceTo(current) < minDist) {
          minDist = list.getList().get(j).distanceTo(current);
          currentBest = j;
        }
      }
      path.add(list.getList().get(j));
    }
  }
}
