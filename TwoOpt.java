public class TwoOpt {
  public HouseManager TO (HouseManager input) {
   HouseManager path = Neighbor.NN(input);
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
}
