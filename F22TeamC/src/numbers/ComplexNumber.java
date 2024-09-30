package numbers;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

/**
 * Complex number class.
 * 
 * @author Justin Lacombe
 * @version 10/27/2022
 * 
 *          This work complies with the JMU Honor Code.
 */
public class ComplexNumber implements Calculatable
{

  static String negOneStr = "-1.0";
  static String zeroStr = "0.0";
  String oneStr = "1.0";
  String iStr = "\uD835\uDC8A";
  private final BigDecimal negOne = new BigDecimal(negOneStr);
  private final BigDecimal zero = new BigDecimal(zeroStr);
  private final BigDecimal one = new BigDecimal(oneStr);
  private BigDecimal normalNumber;
  private BigDecimal imaginaryNumber;
  private int imaginaryExponent;

  /**
   * Default constructor.
   */
  public ComplexNumber()
  {
    this.normalNumber = new BigDecimal(zeroStr);
    this.imaginaryNumber = new BigDecimal(zeroStr);
    this.imaginaryExponent = 1;
  }

  /**
   * Constructor for complex numbers with no exponents.
   * 
   * @param normalNumber
   *          the whole number part of a complex number
   * @param imaginaryNumber
   *          the imaginary number part of a complex number
   */
  public ComplexNumber(final double normalNumber, final double imaginaryNumber)
  {
    this.normalNumber = new BigDecimal("" + normalNumber);
    this.imaginaryNumber = new BigDecimal("" + imaginaryNumber);
    this.imaginaryExponent = 1;
  }

  /**
   * Constructor for complex numbers with no exponents.
   *
   * @param normalNumber
   *          the whole number part of a complex number
   * @param imaginaryNumber
   *          the imaginary number part of a complex number
   */
  public ComplexNumber(final BigDecimal normalNumber, final BigDecimal imaginaryNumber)
  {
    this.normalNumber = normalNumber;
    this.imaginaryNumber = imaginaryNumber;
    this.imaginaryExponent = 1;
  }

  /**
   * Constructor used when the imaginary number has an exponent.
   * 
   * @param normalNumber
   *          the whole number part of a complex number
   * @param imaginaryNumber
   *          the imaginary number part of a complex number
   * @param imaginaryExponent
   *          the imaginary number's exponent
   */
  public ComplexNumber(final double normalNumber, final double imaginaryNumber,
      final int imaginaryExponent)
  {
    this.normalNumber = new BigDecimal("" + normalNumber);
    this.imaginaryNumber = new BigDecimal("" + imaginaryNumber);
    this.imaginaryExponent = imaginaryExponent;
  }

  /**
   * Constructor used when the imaginary number has an exponent.
   *
   * @param normalNumber
   *          the whole number part of a complex number
   * @param imaginaryNumber
   *          the imaginary number part of a complex number
   * @param imaginaryExponent
   *          the imaginary number's exponent
   */
  public ComplexNumber(final BigDecimal normalNumber, final BigDecimal imaginaryNumber,
      final int imaginaryExponent)
  {
    this.normalNumber = normalNumber;
    this.imaginaryNumber = imaginaryNumber;
    this.imaginaryExponent = imaginaryExponent;
  }

  /**
   * Gets the ComplexNumber's whole number.
   * 
   * @return the normalNumber
   */
  public BigDecimal getNormalNumber()
  {
    return this.normalNumber;
  }

  /**
   * Gets the ComplexNumber's imaginary number.
   * 
   * @return the imaginaryNumber
   */
  public BigDecimal getImaginaryNumber()
  {
    return this.imaginaryNumber;
  }

  /**
   * Gets the exponent of the ComplexNumber's imaginary number.
   * 
   * @return imaginaryExponent
   */
  public int getExponent()
  {
    return this.imaginaryExponent;
  }

  /**
   * Sets the ComplexNumber's whole number.
   * 
   * @param set
   *          the number to change normalNumber to
   */
  public void setNormalNumber(final BigDecimal set)
  {
    this.normalNumber = set;
  }

  /**
   * Sets the ComplexNumber's whole number with a double param.
   *
   * @param set
   *          the number to change normalNumber to
   */
  public void setNormalNumber(final double set)
  {
    this.normalNumber = new BigDecimal("" + set);
  }

  /**
   * Sets the ComplexNumber's imaginary number.
   * 
   * @param set
   *          the number to change imaginaryNumber to
   */
  public void setImaginaryNumber(final BigDecimal set)
  {
    this.imaginaryNumber = set;
  }

  /**
   * Sets the ComplexNumber's imaginary number with a double param.
   *
   * @param set
   *          the number to change imaginaryNumber to
   */
  public void setImaginaryNumber(final double set)
  {
    this.imaginaryNumber = new BigDecimal("" + set);
  }

  /**
   * Prints a ComplexNumber as a string.
   * 
   * @return a correctly formatted ComplexNumber as string
   */
  public String toString()
  {
    // To get rid of returns, would need to assign the double value of the imaginaryNumber and
    // normalNumber to a string for when they have 0 as the decimal
    String retStr = null;
    String i = iStr;
    String leftPar = "(";
    String rightPar = ")";
    String minus = "-";
    String plus = "+";
    if (this.imaginaryNumber.doubleValue() == 0)
    {
      if (this.normalNumber.doubleValue() % 1 == 0)
      {
        return "" + (int) this.normalNumber.doubleValue();
      }
      return "" + this.normalNumber;
    }
    else if (this.normalNumber.doubleValue() == 0)
    {
      // return String.format("(%fi)", this.imaginaryNumber);
      if (this.imaginaryNumber.doubleValue() % 1 == 0)
      {
        return "" + (int) this.imaginaryNumber.doubleValue() + i;
      }
      return "" + this.imaginaryNumber + i;
    }
    else if (this.imaginaryNumber.doubleValue() < 0)
    {
      if (this.normalNumber.doubleValue() % 1 == 0 && this.imaginaryNumber.doubleValue() % 1 == 0)
      {
        return leftPar + (int) this.normalNumber.doubleValue() + minus
            + Math.abs((int) this.imaginaryNumber.doubleValue()) + i + rightPar;
      }
      else if (this.normalNumber.doubleValue() % 1 == 0)
      {
        return leftPar + (int) this.normalNumber.doubleValue() + minus + this.imaginaryNumber.abs()
            + i + rightPar;
      }
      else if (this.imaginaryNumber.doubleValue() % 1 == 0)
      {
        return leftPar + this.normalNumber + minus + (int) this.imaginaryNumber.abs().doubleValue()
            + i + rightPar;
      }
      return leftPar + this.normalNumber + minus + this.imaginaryNumber.abs() + i + rightPar;
    }
    else
    {
      if (this.normalNumber.doubleValue() % 1 == 0 && this.imaginaryNumber.doubleValue() % 1 == 0)
      {
        return leftPar + (int) this.normalNumber.doubleValue() + plus
            + Math.abs((int) this.imaginaryNumber.doubleValue()) + i + rightPar;
      }
      else if (this.normalNumber.doubleValue() % 1 == 0)
      {
        return leftPar + (int) this.normalNumber.doubleValue() + plus + this.imaginaryNumber.abs()
            + i + rightPar;
      }
      else if (this.imaginaryNumber.doubleValue() % 0 == 0)
      {
        return leftPar + this.normalNumber + plus
            + Math.abs((int) this.imaginaryNumber.doubleValue()) + i + rightPar;
      }
      return leftPar + this.normalNumber + plus + this.imaginaryNumber.abs() + i + rightPar;
      // return retStr;
    }
  }

  @Override
  public Calculatable add(final Calculatable other)
  {
    if (other instanceof RealNumber)
    {
      RealNumber otherRN = (RealNumber) other;
      return new ComplexNumber(new BigDecimal("" + otherRN.getNumber()).add(this.getNormalNumber()),
          this.getImaginaryNumber());
    }
    else if (other instanceof ImaginaryNumber)
    {
      ImaginaryNumber otherIN = (ImaginaryNumber) other;
      return new ComplexNumber(this.getNormalNumber(),
          new BigDecimal("" + otherIN.getNumber()).add(this.getImaginaryNumber()));
    }
    else if (other instanceof ComplexNumber)
    {
      ComplexNumber otherCN = (ComplexNumber) other;
      return new ComplexNumber(this.getNormalNumber().add(otherCN.getNormalNumber()),
          this.getImaginaryNumber().add(otherCN.getImaginaryNumber()), this.getExponent());
    }
    return null;
  }

  @Override
  public Calculatable subtract(final Calculatable other)
  {
    if (other instanceof RealNumber)
    {
      RealNumber otherRN = (RealNumber) other;
      return new ComplexNumber(
          new BigDecimal("" + this.getNormalNumber().subtract(otherRN.getNumber())),
          this.getImaginaryNumber());
    }
    else if (other instanceof ImaginaryNumber)
    {
      ImaginaryNumber otherIN = (ImaginaryNumber) other;
      return new ComplexNumber(this.getNormalNumber(),
          new BigDecimal("" + this.getImaginaryNumber()).subtract(otherIN.getNumber()));
    }
    else if (other instanceof ComplexNumber)
    {
      ComplexNumber otherCN = (ComplexNumber) other;
      return new ComplexNumber(this.getNormalNumber().subtract(otherCN.getNormalNumber()),
          this.getImaginaryNumber().subtract(otherCN.getImaginaryNumber()), this.getExponent());
    }
    return null;
  }

  @Override
  public Calculatable multiply(final Calculatable other)
  {
    Calculatable retValue = null;
    if (other instanceof RealNumber)
    {
      RealNumber otherRN = (RealNumber) other;
      if (otherRN.getNumber().doubleValue() == 0)
      {
        // return new RealNumber(0);
        retValue = new RealNumber(0);
      }
      else
      {
        // return new ComplexNumber(this.normalNumber.multiply(new BigDecimal("" + otherRN)),
        // this.imaginaryNumber.multiply(new BigDecimal("" + otherRN)));
        retValue = new ComplexNumber(this.normalNumber.multiply(new BigDecimal("" + otherRN)),
            this.imaginaryNumber.multiply(new BigDecimal("" + otherRN)));
      }
      return retValue;
    }
    else if (other instanceof ImaginaryNumber)
    {
      ImaginaryNumber otherIN = (ImaginaryNumber) other;
      return new ComplexNumber(
          negOne.multiply(this.imaginaryNumber.multiply(new BigDecimal("" + otherIN.getNumber()))),
          this.normalNumber.multiply(new BigDecimal("" + otherIN.getNumber())));
    }
    else if (other instanceof ComplexNumber)
    {
      ComplexNumber otherCN = (ComplexNumber) other;
      return new ComplexNumber(
          ((this.getNormalNumber().multiply(otherCN.getNormalNumber()))
              .subtract((this.getImaginaryNumber().multiply(otherCN.getImaginaryNumber()))))
                  .doubleValue(),
          ((this.getNormalNumber().multiply(otherCN.getImaginaryNumber()))
              .add((this.getImaginaryNumber().multiply(otherCN.getNormalNumber())))).doubleValue());
    }
    return null;
  }

  @Override
  public Calculatable divide(final Calculatable other)
  {
    Calculatable retValue = null;
    if (other instanceof RealNumber)
    {
      RealNumber otherRN = (RealNumber) other;
      if (otherRN.getNumber().doubleValue() == 0)
      {
        // return null;
        retValue = null;
      }
      else
      {
        BigDecimal otherRNBG = new BigDecimal("" + otherRN.getNumber());
        // return new ComplexNumber(this.getNormalNumber().divide(otherRNBG),
        // this.getImaginaryNumber().divide(otherRNBG));
        retValue = new ComplexNumber(this.getNormalNumber().divide(otherRNBG),
            this.getImaginaryNumber().divide(otherRNBG));
      }
      return retValue;
    }
    else if (other instanceof ImaginaryNumber)
    {
      ImaginaryNumber otherIN = (ImaginaryNumber) other;
      BigDecimal otherINBG = new BigDecimal("" + otherIN.getNumber());
      return new ComplexNumber(this.getImaginaryNumber().divide(otherINBG),
          this.getNormalNumber().divide(otherINBG));
    }
    else if (other instanceof ComplexNumber)
    {
      ComplexNumber otherCN = (ComplexNumber) other;
      ComplexNumber top = this;
      ComplexNumber bottom = otherCN;
      // ComplexNumber bottomConjugate = new ComplexNumber(bottom.getNormalNumber().doubleValue(),
      // (new BigDecimal("-1.0")).multiply(bottom.getImaginaryNumber()).doubleValue());
      ComplexNumber bottomConjugate = conjugate(bottom);
      top = (ComplexNumber) top.multiply(bottomConjugate);
      bottom = (ComplexNumber) bottom.multiply(bottomConjugate);
      ComplexNumber quotient = null;

      if (bottom.getNormalNumber().equals(zero) && bottom.getImaginaryNumber().equals(zero))
      {
        throw new IllegalArgumentException(
            "Multiplying by the conjugate resulted in a division by zero.");
      }
      else if (bottom.normalNumber.equals(zero))
      {
        quotient = new ComplexNumber(
            top.imaginaryNumber.doubleValue() / (bottom.imaginaryNumber.doubleValue()),
            -1 * ((top.normalNumber.doubleValue() / (bottom.imaginaryNumber.doubleValue()))));
      }
      else if (bottom.imaginaryNumber.equals(zero))
      {
        try
        {
          quotient = new ComplexNumber(top.normalNumber.divide(bottom.normalNumber),
              top.imaginaryNumber.divide(bottom.normalNumber));
        }
        catch (ArithmeticException e)
        {
          quotient = new ComplexNumber(
              top.normalNumber.doubleValue() / (bottom.normalNumber.doubleValue()),
              top.imaginaryNumber.doubleValue() / bottom.normalNumber.doubleValue());
        }
      }
      else
      {
        quotient = new ComplexNumber(
            top.getNormalNumber().doubleValue() / (bottom.getNormalNumber().doubleValue()),
            top.getImaginaryNumber().doubleValue() / (bottom.getImaginaryNumber().doubleValue()));
      }
      return quotient;
    }
    return null;
  }

  /**
   * Gets the conjugate of a complex number.
   * 
   * @param other
   *          the complexnumber get the conjugate of
   * @return the conjugate of other
   */
  public static ComplexNumber conjugate(final ComplexNumber other)
  {
    return new ComplexNumber(other.getNormalNumber().doubleValue(),
        (new BigDecimal(negOneStr)).multiply(other.getImaginaryNumber()).doubleValue());
  }

  /**
   * Inverts this complex number.
   */
  public void invert()
  {
    if (this.getNormalNumber().doubleValue() != 0 && this.getImaginaryNumber().doubleValue() != 0)
    {
      this.setNormalNumber(one.divide(this.getNormalNumber(), MathContext.DECIMAL32));
      this.setImaginaryNumber(one.divide(this.getImaginaryNumber(), MathContext.DECIMAL32));
    }
    else if (this.getNormalNumber().doubleValue() == 0)
    {
      this.setImaginaryNumber(one.divide(this.getImaginaryNumber(), MathContext.DECIMAL32));
    }
    else
    {
      this.setNormalNumber(one.divide(this.getNormalNumber(), MathContext.DECIMAL32));
    }
  }

  /**
   * Finds both roots of a Complex Number.
   * 
   * @param other
   *          The Complex Number to find the sqrt of
   * @return other's sqrts
   */
  public static ArrayList<ComplexNumber> squareRoot(final ComplexNumber other)
  {
    return RootFinder.complexRoot(other);
  }

  @Override
  public Calculatable exponentiation(final double exponent)
  {
    if (exponent == 0)
    {
      return new RealNumber(0);
    }
    Calculatable holdValue = this;
    if (exponent % 1 == 0 && exponent > 0)
    {
      for (int i = 1; i < exponent; i++)
      {
        holdValue = holdValue.multiply(this);
      }
      return holdValue;
    }
    else if (exponent % 1 == 0 && exponent < 0)
    {
      // System.out.println("Made it: 4");
      // for (int i = 1; i >= exponent; i--)
      // {
      // holdValue = holdValue.divide(this);
      // }
      // return holdValue;
      for (int i = 1; i < Math.abs(exponent); i++)
      {
        holdValue = holdValue.multiply(this);
      }
      holdValue.invert();
      return holdValue;
    }
    return null;
  }

}
