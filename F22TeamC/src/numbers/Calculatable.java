package numbers;

/**
 * Interface for all Calculatable classes.
 * 
 * @author Justin Lacombe
 * @version 11/6/2022
 */
public interface Calculatable
{

  /**
   * Adds 2 calculatables.
   * 
   * @param other
   *          the calculatable to add
   * @return the values added together
   */
  public abstract Calculatable add(final Calculatable other);

  /**
   * Subtracts 2 calculatables.
   * 
   * @param other
   *          the calculatable to subtract
   * @return the first value subtracted from the second
   */
  public abstract Calculatable subtract(Calculatable other);

  /**
   * Multiplies 2 calculatables.
   * 
   * @param other
   *          the calculatable to multiply to this object
   * @return the values multiplied together
   */
  public abstract Calculatable multiply(Calculatable other);

  /**
   * Divides calculatables.
   * 
   * @param other
   *          the calculatable to divide by
   * @return the quotient of the two values
   */
  public abstract Calculatable divide(Calculatable other);

  /**
   * Prints a Calculatable in its string format.
   * 
   * @return The mathematic number/expression as a string
   */
  public abstract String toString();

  /**
   * Does exponents for Calculatables.
   * 
   * @param exponent
   *          the exponent
   * @return the number after applying the exponent
   */
  public abstract Calculatable exponentiation(double exponent);

  /**
   * Inverts a Calculatable.
   */
  public abstract void invert();

  //
  // /**
  // * Divides 1 by the current value of the Calculatable.
  // */
  // public abstract void invert();
  //
  // /**
  // * Finds the sqaure root of the Calculatable
  // */
  // public abstract void squareRoot(Calculatable number);
  //
  // /**
  // * Finds the logrithm of the Calculatable
  // */
  // public abstract void logarithm();
}
