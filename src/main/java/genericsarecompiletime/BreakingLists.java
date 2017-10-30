package genericsarecompiletime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class BreakingLists {
  public static void breakList(List l) {
    l.add(new Date());
  }
  
  public static void main(String[] args) {
    List<String> ls = 
//        Collections.checkedList(
            new ArrayList<>()
//            , String.class)
        ;
    ls.add("Fred");
    ls.add("Jim");
    ls.add("Sheila");//    ls.add(new Date());
    
    String s = ls.get(0);
    System.out.println("> " + s);
    breakList(ls);
    s = ls.get(3);
    
  }
}
