package store;

import java.awt.Color;
import java.util.Date;

public class Store {
  public static void main(String[] args) {
//    Pair<String> ps = new Pair<>("Fred", "Jones");
//    
//    String s = ps.getRight();
//    
//    
//    Pair<Date> pd = new Pair<>(new Date(), new Date());
////    pd.setRight("Fred");

    Pair<Sock> pSock = new Pair<>(new Sock(Color.BLUE, 8), new Sock(Color.BLUE, 9));
    System.out.println("IsMatched?? " + pSock.isMatched());
  }
}
