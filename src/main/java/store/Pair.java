package store;

public class Pair<E extends Sized & Colored/*, String !!!! BAD !!!!!*/> {
  private E left;
  private E right;
//  private F stuff;
//  private java.lang.String x;
//  {
//    System.out.println("Length of x is " + x.length());
//  }

//  public static boolean isAMatchedPair(Pair<E> target) {
//    return false;
//  }
  
//  public <F> void doStuff() {
//    
//  }
  
  public E getLeft() {
    return left;
  }

  public void setLeft(E left) {
    this.left = left;
  }

  public E getRight() {
    return right;
  }

  public void setRight(E right) {
    this.right = right;
  }

  public Pair(E left, E right) {
    this.left = left;
    this.right = right;
  }
  
  public boolean isMatched() {
    return left.getSize() == right.getSize()
        && left.getColor().equals(right.getColor());
  }
}
