public class House{
  /**
   * @author Dev
  */
  private int st;
  private int av;
  private int le;
  private final char[] letters= {'A','B','C','D','E','F','G','H','I','J'};
  public House(String a){
    String[] address = a.split(",", 3);
    st = Integer.parseInt(address[0].substring(0, address[0].length()-1));
    av = Integer.parseInt(address[1].substring(0, address[1].length()-1));
    for(int i = 0; i < 10; i++){
      if(address[2].contains(letters[i]+"")){
        le = letters[i]-64;//address will be between 1 and 10
        break;
      }
    }
  }
  public House(int a, int b, int c){
    st = a;
    av = b;
    le = c - 64;
  }
  public int distanceTo(House a){
    int b = 200*Math.abs(this.getSt()-a.getSt()) + 1000*Math.abs(this.getAv()-a.getAv());
    if(this.getAv() == a.getAv() && this.getSt() != a.getSt()) {
      if (this.getLe()+a.getLe() <= 10) {
        b += 100*(this.getLe()+a.getLe());
      } else {
        b += 100*(20-this.getLe()-a.getLe());
      }
    } else {
      b += 100*(this.getLe()-a.getLe());
    }
    return b;
  }
  public boolean isSouthOf(House a){
    if(a.getAv()>this.getAv()) {
      return true;
    } else if(a.getAv() == this.getAv() && a.getLe()>this.getLe()){
      return true;
    } else {
      return false;
    }
  }
  public int getAv(){
    return av;
  }
  public int getSt(){
    return st;
  }
  public int getLe(){
    return le;
  }
  @Override public boolean equals(House a){
    if(a.getAv() == this.getAv() && a.getSt() == this.getSt() && a.getLe() == this.getLe())
      return true;
    return false;
}
