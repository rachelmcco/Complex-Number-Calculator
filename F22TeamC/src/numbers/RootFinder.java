package numbers;

import java.util.*;

/**
 * Finds the roots of a complex number.
 * 
 * @author Justin Lacombe
 * @version 11/14/2022
 */
public class RootFinder
{

  static class Pair
  {
    double first, second;

    public Pair(final double first, final double second)
    {
      this.first = first;
      this.second = second;
    }
  }

  /**
   * Finds the roots of a complex Number.
   * 
   * @param findRoots
   *          the complex number to find to roots of
   * @return an arraylist of the complex number's roots
   */
  public static ArrayList<ComplexNumber> complexRoot(final ComplexNumber findRoots)
  {

    if (findRoots.getImaginaryNumber().doubleValue() == 0
        && findRoots.getNormalNumber().doubleValue() == 0)
    {
      return null;
    }
    ArrayList<ComplexNumber> retArray = new ArrayList<>();
    // Stores all the square roots
    Vector<Pair> ans = new Vector<Pair>();
    double a = findRoots.getNormalNumber().doubleValue();
    double b = findRoots.getImaginaryNumber().doubleValue();

    // Stores the first square root
    double x1 = Math.abs(Math.sqrt((a + Math.sqrt(a * a + b * b)) / 2));
    double y1 = b / (2 * x1);

    // Push the square root in the ans
    ans.add(new Pair(x1, y1));

    // Stores the second square root
    double x2 = -1 * x1;
    double y2 = b / (2 * x2);

    // If x2 is not 0
    if (x2 != 0)
    {
      // Push the square root in the array ans[]
      ans.add(new Pair(x2, y2));
    }

    // Stores the third square root
    double x3 = (a - Math.sqrt(a * a + b * b)) / 2;

    // If x3 is greater than 0
    if (x3 > 0)
    {
      x3 = Math.abs(Math.sqrt(x3));
      double y3 = b / (2 * x3);

      // Push the square root in the array ans[]
      ans.add(new Pair(x3, y3));

      // Stores the fourth square root
      double x4 = -1 * x3;
      double y4 = b / (2 * x4);

      if (x4 != 0)
      {
        // Push the square root in the array ans[]
        ans.add(new Pair(x4, y4));
      }
    }

    for (Pair p : ans)
    {
      retArray.add(new ComplexNumber(p.first, p.second));
    }
    return retArray;
  }

  // Test in class
  // public static void main(String[] args)
  // {
  // ComplexNumber test = new ComplexNumber(8, 2);
  // ArrayList<ComplexNumber> roots = complexRoot(test);
  //
  // System.out.print("The Square roots are: " + "\n");
  // for (ComplexNumber cn : roots)
  // {
  // System.out.println(cn);
  // }
  // }

  // public static ComplexNumber logFinder
}
