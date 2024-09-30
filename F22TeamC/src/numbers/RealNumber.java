package numbers;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Real number class for whole, real numbers.
 * 
 * @author Justin Lacombe
 * @version 11/21/2022
 *
 */
public class RealNumber implements Calculatable
{
  String negOneStr = "-1.0";
  String zeroStr = "0.0";
  String oneStr = "1.0";
  private final BigDecimal negOne = new BigDecimal(negOneStr);
  private final BigDecimal zero = new BigDecimal(zeroStr);
  private final BigDecimal one = new BigDecimal(oneStr);
  private BigDecimal number;

  /**
   * RealNumber constructor.
   * 
   * @param number
   *          the number to use
   */
  public RealNumber(final double number)
  {
    this.number = new BigDecimal("" + number);
  }

  /**
   * Real number Constructor.
   * 
   * @param number
   *          the number to use
   */
  public RealNumber(final BigDecimal number)
  {
    this.number = number;
  }

  /**
   * Returns the objects number.
   * 
   * @return number attribute
   */
  public BigDecimal getNumber()
  {
    return this.number;
  }

  @Override
  public Calculatable add(final Calculatable other)
  {
    if (other instanceof RealNumber)
    {
      RealNumber otherRN = (RealNumber) other;
      return new RealNumber(this.number.add(otherRN.number));
    }
    else if (other instanceof ImaginaryNumber)
    {
      ImaginaryNumber otherIN = (ImaginaryNumber) other;
      return new ComplexNumber(this.getNumber(), otherIN.getNumber());
    }
    else if (other instanceof ComplexNumber)
    {
      ComplexNumber otherCN = (ComplexNumber) other;
      return new ComplexNumber(new BigDecimal("" + this.getNumber()).add(otherCN.getNormalNumber()),
          otherCN.getImaginaryNumber());
    }
    return null;
  }

  @Override
  public Calculatable subtract(final Calculatable other)
  {
    if (other instanceof RealNumber)
    {
      RealNumber otherRN = (RealNumber) other;
      return new RealNumber(this.number.subtract(otherRN.number));
    }
    else if (other instanceof ImaginaryNumber)
    {
      ImaginaryNumber otherIN = (ImaginaryNumber) other;
      return new ComplexNumber(this.getNumber(), otherIN.getNumber().multiply(negOne));
    }
    else if (other instanceof ComplexNumber)
    {
      ComplexNumber otherCN = (ComplexNumber) other;
      return new ComplexNumber(
          new BigDecimal("" + this.getNumber()).subtract(otherCN.getNormalNumber()),
          negOne.multiply(otherCN.getImaginaryNumber()));
    }
    return null;
  }

  @Override
  public Calculatable multiply(final Calculatable other)
  {
    if (other instanceof RealNumber)
    {
      RealNumber otherRN = (RealNumber) other;
      return new RealNumber(this.getNumber().multiply(otherRN.getNumber()));
    }
    else if (other instanceof ImaginaryNumber)
    {
      ImaginaryNumber otherIN = (ImaginaryNumber) other;
      return new ImaginaryNumber(this.getNumber().multiply(otherIN.getNumber()));
    }
    else if (other instanceof ComplexNumber)
    {
      ComplexNumber otherCN = (ComplexNumber) other;
      return new ComplexNumber(
          otherCN.getNormalNumber().multiply(new BigDecimal("" + this.getNumber())),
          otherCN.getImaginaryNumber().multiply(new BigDecimal("" + this.getNumber())));
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
        retValue = null;
      }
      else
      {
        try
        {
          return new RealNumber(this.getNumber().divide(otherRN.getNumber()));
        }
        catch (ArithmeticException ae)
        {
          // If decimal is non-terminating, works for the first 6 digits
          // return new RealNumber(
          // new BigDecimal((this.getNumber().doubleValue() / otherRN.getNumber().doubleValue()))
          // .round(MathContext.DECIMAL32));
          // works
          // return new RealNumber(
          // this.getNumber().divide(otherRN.getNumber(), 10, RoundingMode.HALF_UP));
          // works
          //
          // return new RealNumber(this.getNumber().doubleValue() /
          // otherRN.getNumber().doubleValue());
          retValue = new RealNumber(
              this.getNumber().doubleValue() / otherRN.getNumber().doubleValue());
        }
      }
      return retValue;
    }
    else if (other instanceof ImaginaryNumber)
    {
      ImaginaryNumber otherIN = (ImaginaryNumber) other;
      if (otherIN.getNumber().doubleValue() == 0)
      {
        retValue = null;
      }
      else
      {
        try
        {
          retValue = new ImaginaryNumber(
              (this.getNumber().divide(otherIN.getNumber())).multiply(negOne));
        }
        catch (ArithmeticException ae)
        {
          retValue = new ImaginaryNumber(
              (this.getNumber().doubleValue() / otherIN.getNumber().doubleValue()) * -1);
        }
      }
    }
    else if (other instanceof ComplexNumber)
    {
      ComplexNumber otherCN = (ComplexNumber) other;
      RealNumber realTop = this;
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
    return retValue;
  }

  /**
   * Formats the RealNumber as a string.
   * 
   * @return the RealNumber as a string.
   */
  public String toString()
  {
    if ((this.number).doubleValue() % 1 == 0)
    {
      return "" + (int) this.number.doubleValue();
    }
    return "" + this.number.doubleValue();
  }

  /**
   * Finds the sqrt of a RealNumber.
   * 
   * @param num
   *          the number to get the sqrt of
   * @return num's sqrt
   */
  public RealNumber squareRoot(final double num)
  {
    return new RealNumber(Math.sqrt(num));
  }

  /**
   * Finds the log of a base using the antilog.
   * 
   * @param antiNum
   *          the base of the logarithm
   * @param baseNum
   *          the antilog of a logarithm
   * @return the calculated logarigthm
   */
  public static double logarithm(final double antiNum, final double baseNum)
  {
    return (Math.log(baseNum)) / (Math.log(antiNum));
  }

  /**
   * Inverts this object's number attribute.
   */
  public void invert()
  {
    this.number = one.divide(this.number, MathContext.DECIMAL32);
  }

  /**
   * Finds the calculated value using this number and the exponent.
   * 
   * @param exponent
   *          the exponent to use in the calculation
   * @return this object's number to the power of expoenents
   */
  public RealNumber exponentiation(final double exponent)
  {
    return new RealNumber(Math.pow(this.number.doubleValue(), exponent));
  }

}
