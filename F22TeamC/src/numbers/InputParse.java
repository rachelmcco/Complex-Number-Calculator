
package numbers;

import java.math.BigDecimal;

/**
 * Parses complex number strings to construct ComplexNumber objects.
 * 
 * @author Justin Lacombe
 * @version 10/30/2022
 * 
 *          This work complies with the JMU Honor Code.
 */
public class InputParse
{
  private static final String MINUS = "-";
  private static final String PLUS = "+";
  private static final String PLUS_SPLIT = "\\+";
  private static final String ZERO_TO_NINE = "[0-9]";
  private static final String PERIOD = ".";
  private static final String I_STR = "\uD835\uDC8A";
  private static final String PI = "π";
  private static final String PI_LETTERS = "pi";
  private static final String ROOT_PARENS = "√(";
  private static final String COS_INVERSE_TAN = ")cos(arctan(";
  private static final String SIN_INVERSE_TAN = ")sin(arctan(";
  private static final String SLASH = "/";
  private static final String DIVIDE = "÷";
  private static final String PARENS_ROOT = ")) + √(";
  private static final String END_PARENS_I = "))" + I_STR;
  private static final String MINUS_INVERSE_TAN = " - arctan(";
  private static final String END_PARENS_MINUS = ") - ";
  private static final String OPEN_PARENS = "(";
  private static final String CLOSE_PARENS = ")";
  private static final String NOTHING = "";
  private static final String SPACE = " ";
  private static final BigDecimal ONE = new BigDecimal("1.0");
  private static final BigDecimal NEGATIVE_ONE = new BigDecimal("-1.0");
  private static final BigDecimal ZERO = new BigDecimal("0.0");

  /**
   * Parses complex number input.
   * 
   * @param number
   *          the complex number input as a string
   * @return the input as ComplexNumber object
   * @throws NumberFormatException
   *           thrown if input is not a complex number
   */
  public static Calculatable validNumber(final String number)
  {
    Calculatable opOne = null;
    // Checks if number is a RealNumber
    try
    {
      RealNumber realNum;
      realNum = new RealNumber(Double.parseDouble(number));
      opOne = realNum;
      return opOne;
    }
    catch (NumberFormatException nfe)
    {
      // Checks if number is an ImaginaryNumber
      try
      {
        if (number.equals(I_STR))
        {
          opOne = new ImaginaryNumber(1.0);
          return opOne;
        }
        ImaginaryNumber imaginaryNum;
        String str = number;
        str = str.replace(I_STR, "");
        // replace spaces?
        imaginaryNum = new ImaginaryNumber(Double.parseDouble(str));
        opOne = imaginaryNum;
        return opOne;
      }
      catch (NumberFormatException nfe2)
      {
      }
    }

    String operator = "";
    int firstSign = 1;
    // The operand as a string
    String str = number;
    // removes the parenthesis needed around complex numbers
    str = str.replace(OPEN_PARENS, NOTHING);
    str = str.replace(CLOSE_PARENS, NOTHING);
    // Checks if the first number will be negative
    // remove parentheses first?
    if (str.indexOf(MINUS) == 0)
    {
      firstSign = -1;
      str = str.substring(1, str.length());
    }

    // Removes NORMAL hindrances to parsing
    str = str.replace(SPACE, NOTHING);
    str = str.replace("\n", NOTHING);
    str = str.replace("\t", NOTHING);
    String empty = str;

    // ComplexNumber to return
    ComplexNumber compNum = new ComplexNumber();

    // Gets rid of all necessary aspects of a complex num other than the operation
    empty = empty.replaceAll(ZERO_TO_NINE, "");
    empty = empty.replaceFirst(I_STR, "");
    // Make sure there are only 2 decimal points
    if (empty.replace(PERIOD, "").length() < empty.length() - 2)
    {
      compNum = null;
      // return null;
    }
    empty = empty.replace(PERIOD, "");

    String[] strArr = new String[2];
    // If anything other than the operator is in the string,
    // then the input was incorrectly formatted

    switch (empty)
    {
      case PLUS:
        strArr = str.split(PLUS_SPLIT);
        operator = PLUS;
        break;
      case MINUS:
        strArr = str.split(MINUS);
        operator = MINUS;
        break;
      default:
        compNum = null;
        // return null;
    }
    str = str.replaceAll(ZERO_TO_NINE, "");
    str = str.replaceFirst(I_STR, "");
    str = str.replaceFirst(PLUS_SPLIT, "");
    str = str.replaceFirst(MINUS, "");
    str = str.replaceAll(PERIOD, "");
    if (!str.equals("") || !number.contains(I_STR))
    {
      compNum = null;
      // return null;
    }

    // Parses each operand and creates a complex number
    for (int i = 0; i < strArr.length; i++)
    {
      // i by itself
      if (strArr[i].equals(I_STR))
      {
        compNum.setImaginaryNumber(ONE);
        if ((i == 0 && firstSign == -1) || (i == 1 && operator.equals(MINUS)))
        {
          compNum.setImaginaryNumber(NEGATIVE_ONE);
        }
      }
      // i with a number, ex: 5i
      else if (strArr[i].contains(I_STR))
      {
        String noI = strArr[i].replace(I_STR, "");

        compNum.setImaginaryNumber(Double.parseDouble(noI));
        if ((i == 0 && firstSign == -1) || (operator.equals(MINUS) && i == 1))
        {
          compNum.setImaginaryNumber(-1 * Double.parseDouble(noI));
        }
      }
      else
      {
        compNum.setNormalNumber(Double.parseDouble(strArr[i]));
        if ((i == 0 && firstSign == -1) || (operator.equals(MINUS) && i == 1))
        {
          compNum.setNormalNumber(-1 * Double.parseDouble(strArr[i]));
        }
      }
    }
    return compNum;
  }

  /**
   * Method that converts a polar form complex number to a complex number object.
   * 
   * @param polar
   *          the polar form complex number
   * @return the new complex number object
   */
  public static ComplexNumber validNumberPolar(final String polar)
  {
    BigDecimal a, b;

    String input = polar.replace(OPEN_PARENS, NOTHING);
    input = input.replace(CLOSE_PARENS, NOTHING);
    input = input.replace(SPACE, NOTHING);

    int piSymbolIndex = input.indexOf(PI);
    int piLettersIndex = input.indexOf(PI_LETTERS);
    int divide = input.indexOf(DIVIDE);
    int slash = input.indexOf(SLASH);
    int additionSeparatorIndex;
    int subtractionSeparatorIndex;
    if (slash == -1) 
    {
      additionSeparatorIndex = input.indexOf(PLUS, divide);
      subtractionSeparatorIndex = input.indexOf(MINUS, divide);
    } else 
    {
      additionSeparatorIndex = input.indexOf(PLUS, slash);
      subtractionSeparatorIndex = input.indexOf(MINUS, slash);
    }
    int operatorSeparatorIndex = 0;

    if (additionSeparatorIndex == -1)
    {
      operatorSeparatorIndex = subtractionSeparatorIndex;
    }
    else if (subtractionSeparatorIndex == -1)
    {
      operatorSeparatorIndex = additionSeparatorIndex;
    }
    else if (additionSeparatorIndex < subtractionSeparatorIndex)
    {
      operatorSeparatorIndex = additionSeparatorIndex;
    }
    else
    {
      operatorSeparatorIndex = subtractionSeparatorIndex;
    }

    boolean negativeA = false;
    boolean negativeB = false;
    boolean pie = piSymbolIndex == -1 && piLettersIndex == -1;

    int bIndexCheck = input.indexOf('t') - 4;

    try
    {
      if (input.charAt(bIndexCheck) == '-' && pie)
      {
        negativeB = true;
      }

      if (!pie)
      {
        negativeA = true;
      }

      if (piSymbolIndex > input.indexOf('t') || piLettersIndex > input.indexOf('t'))
      {
        negativeB = true;
      }

    }
    catch (IndexOutOfBoundsException e)
    {
      // Do nothing
    }

    if (slash == -1) {
      b = new BigDecimal(input.substring(input.indexOf('n') + 1, divide));
      a = new BigDecimal(input.substring(divide + 1, operatorSeparatorIndex));
    } else {
      b = new BigDecimal(input.substring(input.indexOf('n') + 1, slash));
      a = new BigDecimal(input.substring(slash + 1, operatorSeparatorIndex));
    }
    

    if (negativeA)
    {
      a = a.negate();
    }

    if (negativeB)
    {
      b = b.negate();
    }

    return new ComplexNumber(a, b);
  }

  /**
   * Method that converts a complex number into a polar form string representation.
   * 
   * @param num
   *          the number to convert
   * @return the string form of the complex number in polar form
   */
  public static String complexToPolarString(final ComplexNumber num)
  {
    String result = "";

    boolean negativeNormal = num.getNormalNumber().compareTo(ZERO) < 0;
    boolean negativeImaginary = num.getImaginaryNumber().compareTo(ZERO) < 0;

    BigDecimal normalSquared = num.getNormalNumber().abs().pow(2);
    BigDecimal imaginarySquared = num.getImaginaryNumber().abs().pow(2);

    BigDecimal radContents = normalSquared.add(imaginarySquared);

    if (!negativeNormal && !negativeImaginary)
    {
      result = ROOT_PARENS + radContents + COS_INVERSE_TAN + num.getImaginaryNumber().abs() + DIVIDE
          + num.getNormalNumber().abs() + PARENS_ROOT + radContents + SIN_INVERSE_TAN
          + num.getImaginaryNumber().abs() + DIVIDE + num.getNormalNumber().abs() + END_PARENS_I;
    }
    else if (negativeNormal && !negativeImaginary)
    {
      result = ROOT_PARENS + radContents + ")cos(" + PI + MINUS_INVERSE_TAN
          + num.getImaginaryNumber().abs() + DIVIDE + num.getNormalNumber().abs() + PARENS_ROOT
          + radContents + ")sin(" + PI + MINUS_INVERSE_TAN + num.getImaginaryNumber().abs() + DIVIDE
          + num.getNormalNumber().abs() + END_PARENS_I;
    }
    else if (!negativeNormal && negativeImaginary)
    {
      result = ROOT_PARENS + radContents + ")cos(-arctan(" + num.getImaginaryNumber().abs() + DIVIDE
          + num.getNormalNumber().abs() + PARENS_ROOT + radContents + ")sin(-arctan("
          + num.getImaginaryNumber().abs() + DIVIDE + num.getNormalNumber().abs() + END_PARENS_I;
    }
    else
    {
      result = ROOT_PARENS + radContents + COS_INVERSE_TAN + num.getImaginaryNumber().abs() + DIVIDE
          + num.getNormalNumber().abs() + END_PARENS_MINUS + PI + ") + √(" + radContents
          + SIN_INVERSE_TAN + num.getImaginaryNumber().abs() + DIVIDE + num.getNormalNumber().abs()
          + END_PARENS_MINUS + PI + ")" + I_STR;
    }

    return result;

  }

}
