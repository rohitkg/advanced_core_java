package store;

import java.awt.Color;

public class Sock implements Sized, Colored {
  private Color color;
  private int size;

  public Sock(Color color, int size) {
    this.color = color;
    this.size = size;
  }

  public Color getColor() {
    return color;
  }

  public int getSize() {
    return size;
  }
  
}
