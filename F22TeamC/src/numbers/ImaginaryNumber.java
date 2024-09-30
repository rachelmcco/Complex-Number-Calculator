package numbers;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Imaginary number class.
 * 
 * @author Justin Lacombe
 * @version 11/21/2022
 */
public class ImaginaryNumber implements Calculatable
{
  String negOneStr = "-1.0";
  String zeroStr = "0.0";
  String oneStr = "1.0";
  String iStr = "\uD835\uDC8A";
  private final BigDecimal negOne = new BigDecimal(negOneStr);
  private final BigDecimal zero = new BigDecimal(zeroStr);
  private final BigDecimal one = new BigDecimal(oneStr);
  private BigDecimal number;
  private double exponent;

  /**
   * ImaginaryNumber constructor.
   * 
   * @param number
   *          the number used for the imaginary number
   */
  public ImaginaryNumber(final double number)
  {
    this.number = new BigDecimal("" + number);
    this.exponent = 1.0;
  }

  /**
   * ImaginaryNumber constructor.
   * 
   * @param number
   *          the number used for the imaginary number
   */
  public ImaginaryNumber(final BigDecimal number)
  {
    this.number = number;
    this.exponent = 1.0;
  }

  /**
   * ImaginaryNumber constructor.
   * 
   * @param number
   *          the number to use for the imaginary number
   * @param exponent
   *          the exponent of the imaginary number
   */
  public ImaginaryNumber(final double number, final double exponent)
  {
    this.number = new BigDecimal("" + number);
    this.exponent = exponent;
  }

  /**
   * ImaginaryNumber constructor.
   * 
   * @param number
   *          the number to use for the imaginary number
   * @param exponent
   *          the exponent of the imaginary number
   */
  public ImaginaryNumber(final BigDecimal number, final double exponent)
  {
    this.number = number;
    this.exponent = exponent;
  }

  /**
   * Used to get this objects number.
   * 
   * @return the objects number
   */
  public BigDecimal getNumber()
  {
    return this.number;
  }

  /**
   * Used to get this objects exponent.
   * 
   * @return the objects exponent
   */
  public double getExponent()
  {
    return this.exponent;
  }

  @Override
  public Calculatable add(final Calculatable other)
  {
    if (other instanceof RealNumber)
    {
      RealNumber otherRN = (RealNumber) other;
      return new ComplexNumber(otherRN.getNumber(), this.getNumber());
    }
    else if (other instanceof ImaginaryNumber)
    {
      ImaginaryNumber otherIN = (ImaginaryNumber) other;
      return new ImaginaryNumber(this.getNumber().add(otherIN.getNumber()));
    }
    else
    {
      ComplexNumber otherCN = (ComplexNumber) other;
      return new ComplexNumber(otherCN.getNormalNumber(),
          new BigDecimal("" + this.getNumber()).add(otherCN.getImaginaryNumber()));
    }
    
  }

  @Override
  public Calculatable subtract(final Calculatable other)
  {
    if (other instanceof RealNumber)
    {
      RealNumber otherRN = (RealNumber) other;
      return new ComplexNumber(otherRN.getNumber().multiply(negOne), this.getNumber());
    }
    else if (other instanceof ImaginaryNumber)
    {
      ImaginaryNumber otherIN = (ImaginaryNumber) other;
      return new ImaginaryNumber(this.getNumber().subtract(otherIN.getNumber()));
    }
    else
    {
      ComplexNumber otherCN = (ComplexNumber) other;
      return new ComplexNumber(negOne.multiply(otherCN.getNormalNumber()),
          new BigDecimal("" + this.getNumber()).subtract(otherCN.getImaginaryNumber()));
    }

  }
 
  @Override
  public Calculatable multiply(final Calculatable other)
  {
    Calculatable retValue = null;
    if (other instanceof RealNumber)
    {
      RealNumber otherRN = (RealNumber) other;
      return new ImaginaryNumber(this.getNumber().multiply(otherRN.getNumber()));
    }
    else if (other instanceof ImaginaryNumber)
    {
      // when each exponent is 1
      ImaginaryNumber otherIN = (ImaginaryNumber) other;
      if (!((this.exponent + otherIN.getExponent()) % 1 == 0.0))
      {
        // return new ImaginaryNumber(
        // (this.getNumber().multiply(otherIN.getNumber())).multiply(negOne),
        // this.exponent + otherIN.getExponent());
        retValue = new ImaginaryNumber(
            (this.getNumber().multiply(otherIN.getNumber())).multiply(negOne),
            this.exponent + otherIN.getExponent());

      }
      else
      {
        // return new RealNumber((this.getNumber().multiply(otherIN.getNumber())).multiply(negOne));
        retValue = new RealNumber(
            (this.getNumber().multiply(otherIN.getNumber())).multiply(negOne));
      }
      return retValue;
    }
    else if (other instanceof ComplexNumber)
    {
      ComplexNumber otherCN = (ComplexNumber) other;
      return new ComplexNumber(
          negOne.multiply(
              otherCN.getImaginaryNumber().multiply(new BigDecimal("" + this.getNumber()))),
          otherCN.getNormalNumber().multiply(new BigDecimal("" + this.getNumber())));
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
        // return new ImaginaryNumber(this.getNumber().divide(otherRN.getNumber()));
        retValue = new ImaginaryNumber(this.getNumber().divide(otherRN.getNumber()));
      }
      return retValue;
    }
    else if (other instanceof ImaginaryNumber)
    {
      ImaginaryNumber otherIN = (ImaginaryNumber) other;
      if (otherIN.getNumber().doubleValue() == 0)
      {
        // return null;
        retValue = null;
      }
      else
      {
        try
        {
          return new RealNumber(this.getNumber().divide(otherIN.getNumber()));
        }
        catch (ArithmeticException ae)
        {
          retValue = new RealNumber(
              this.getNumber().doubleValue() / otherIN.getNumber().doubleValue());

        }
        // retValue = new RealNumber(this.getNumber().divide(otherIN.getNumber()));
      }
      return retValue;
    }
    else if (other instanceof ComplexNumber)
    {
      ComplexNumber otherCN = (ComplexNumber) other;
      // TODO if either of otherCN attributes are =, return null?
      ImaginaryNumber realTop = this;
      ComplexNumber bottom = otherCN;
      ComplexNumber conjugate = new ComplexNumber(bottom.getNormalNumber().doubleValue(),
          (new BigDecimal(negOneStr)).multiply(bottom.getImaginaryNumber()).doubleValue());
      ComplexNumber top = (ComplexNumber) realTop.multiply(conjugate);
      bottom = (ComplexNumber) bottom.multiply(conjugate);

      ComplexNumber quotient = null;

      if (bottom.getNormalNumber().equals(zero) && bottom.getImaginaryNumber().equals(zero))
      {
        throw new IllegalArgumentException(
            "Multiplying by the conjugate resulted in a division by zero.");
      }
      else if (bottom.getNormalNumber().equals(zero))
      {
        quotient = new ComplexNumber(
            top.getImaginaryNumber().doubleValue() / (bottom.getImaginaryNumber().doubleValue()),
            -1 * ((top.getNormalNumber().doubleValue()
                / (bottom.getImaginaryNumber().doubleValue()))));
      }
      else if (bottom.getImaginaryNumber().equals(zero))
      {
        try
        {
          quotient = new ComplexNumber(top.getNormalNumber().divide(bottom.getNormalNumber()),
              top.getImaginaryNumber().divide(bottom.getNormalNumber()));
        }
        catch (ArithmeticException e)
        {
          quotient = new ComplexNumber(
              top.getNormalNumber().doubleValue() / (bottom.getNormalNumber().doubleValue()),
              top.getImaginaryNumber().doubleValue() / bottom.getNormalNumber().doubleValue());
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
   * Formats the ImaginaryNumber as a string.
   * 
   * @return the ImaginaryNumber as a string.
   */
  public String toString()
  {
    String retString = "";
    if (this.number.doubleValue() == 0)
    {
      retString += "" + (int) this.number.doubleValue();
    }
    else if (this.number.doubleValue() % 1 == 0)
    {
      retString += "" + (int) this.number.doubleValue() + iStr;
    }
    if (this.exponent == 0)
    {
      return "0";
    }
    else if (this.number.doubleValue() % 1 != 0)
    {
      // retString += this.getNumber().round(MathContext.DECIMAL32) + iStr;
      // retString += this.getNumber() + iStr;
      retString += this.getNumber();
      // gets rid of unnecessary zeros
      while (retString.charAt(retString.length() - 1) == '0')
      {
        retString = retString.substring(0, retString.length() - 1);
      }
      retString += iStr;
    }
    // else
    // {
    // retString += "" + this.number.doubleValue() + "i...";
    // }
    return retString;
  }

  /**
   * Inverts this object's number attribute.
   */
  public void invert()
  {
    this.number = one.divide(this.number);
  }

  /**
   * Finds both roots of an imaginary Number.
   * 
   * @param other
   *          The imaginary Number to find the sqrt of
   * @return other's sqrts
   */
  public static ArrayList<ComplexNumber> squareRoot(final ImaginaryNumber other)
  {
    ComplexNumber otherCN = new ComplexNumber(0, other.getNumber().doubleValue());
    return RootFinder.complexRoot(otherCN);
  }

  @Override
  public Calculatable exponentiation(final double exp)
  {
    if (exp == 0)
    {
      return new RealNumber(1);
    }
    Calculatable retValue = this;
    if (exp % 1 == 0 && exp < 0)
    {
      for (int i = -1; i > exp; i--)
      {
        retValue = retValue.multiply(this);
      }
      if (retValue instanceof RealNumber)
      {
        RealNumber p = (RealNumber) retValue;
        p.invert();
      }
      else
      {
        ImaginaryNumber p = (ImaginaryNumber) retValue;
        p.invert();
        p = new ImaginaryNumber(new BigDecimal(-1).multiply(p.getNumber()));
        retValue = p;
      }
      return retValue;
    }
    else if (exp % 1 == 0)
    {
      // exponent is positive
      for (int i = 1; i < exp; i++)
      {
        retValue = retValue.multiply(this);
      }
    }
    else
    {
      return null;
    }
    return retValue;
  }

  // Make parameters RealNumber Objects? return BigDecimal?
  // public double logarithm(final int base, final int antiLog)
  // {
  // return (Math.log(antiLog)) / (Math.log(base));
  // }

}
