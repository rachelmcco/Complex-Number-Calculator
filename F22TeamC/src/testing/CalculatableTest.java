package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import numbers.Calculatable;
import numbers.ComplexNumber;
import numbers.ImaginaryNumber;
import numbers.RealNumber;

/**
 * Tests all of the calculatables.
 * 
 * @author Justin Lacombe
 * @version 11/13/2022
 */
class CalculatableTest
{

  protected static final String ITALIC_I = "\uD835\uDC8A";

  @Test
  void testingAll()
  {
    RealNumber posReal = new RealNumber(5);
    RealNumber negReal = new RealNumber(-5);
    RealNumber zeroReal = new RealNumber(0);
    ImaginaryNumber posImag = new ImaginaryNumber(5);
    ImaginaryNumber negImag = new ImaginaryNumber(-5);
    ImaginaryNumber zeroImag = new ImaginaryNumber(0);
    ComplexNumber posPos = new ComplexNumber(8, 2);
    // ComplexNumber negPos = new ComplexNumber(-6, 4);
    // ComplexNumber posNeg = new ComplexNumber(7, -7);
    // ComplexNumber negNeg = new ComplexNumber(-9, -1);
    // System.out.println(ComplexNumber.squareRoot(new ComplexNumber(-7, -7)));

    // RealNumber----------------------------------------------------------------------------------

    // posReal
    assertEquals(((RealNumber) posReal.add(posReal)).getNumber().doubleValue(), 10);
    assertEquals(((RealNumber) posReal.subtract(posReal)).getNumber().doubleValue(), 0);
    assertEquals(((RealNumber) posReal.multiply(posReal)).getNumber().doubleValue(), 25);
    assertEquals(((RealNumber) posReal.divide(posReal)).getNumber().doubleValue(), 1);

    assertEquals(((RealNumber) posReal.add(negReal)).getNumber().doubleValue(), 0);
    assertEquals(((RealNumber) posReal.subtract(negReal)).getNumber().doubleValue(), 10);
    assertEquals(((RealNumber) posReal.multiply(negReal)).getNumber().doubleValue(), -25);
    assertEquals(((RealNumber) posReal.divide(negReal)).getNumber().doubleValue(), -1);

    assertEquals(((RealNumber) posReal.add(zeroReal)).getNumber().doubleValue(), 5);
    assertEquals(((RealNumber) posReal.subtract(zeroReal)).getNumber().doubleValue(), 5);
    assertEquals(((RealNumber) posReal.multiply(zeroReal)).getNumber().doubleValue(), 0);
    assertEquals(posReal.divide(zeroReal), null);

    // negReal
    assertEquals(((RealNumber) negReal.add(negReal)).getNumber().doubleValue(), -10);
    assertEquals(((RealNumber) negReal.subtract(negReal)).getNumber().doubleValue(), 0);
    assertEquals(((RealNumber) negReal.multiply(negReal)).getNumber().doubleValue(), 25);
    assertEquals(((RealNumber) negReal.divide(negReal)).getNumber().doubleValue(), 1);

    assertEquals(((RealNumber) negReal.add(posReal)).getNumber().doubleValue(), 0);
    assertEquals(((RealNumber) negReal.subtract(posReal)).getNumber().doubleValue(), -10);
    assertEquals(((RealNumber) negReal.multiply(posReal)).getNumber().doubleValue(), -25);
    assertEquals(((RealNumber) negReal.divide(posReal)).getNumber().doubleValue(), -1);

    assertEquals(((RealNumber) negReal.add(zeroReal)).getNumber().doubleValue(), -5);
    assertEquals(((RealNumber) negReal.subtract(zeroReal)).getNumber().doubleValue(), -5);
    assertEquals(((RealNumber) negReal.multiply(zeroReal)).getNumber().doubleValue(), 0);
    assertEquals(negReal.divide(zeroReal), null);

    // zeroReal
    assertEquals(((RealNumber) zeroReal.add(zeroReal)).getNumber().doubleValue(), 0);
    assertEquals(((RealNumber) zeroReal.subtract(zeroReal)).getNumber().doubleValue(), 0);
    assertEquals(((RealNumber) zeroReal.multiply(zeroReal)).getNumber().doubleValue(), 0);
    assertEquals(zeroReal.divide(zeroReal), null);

    assertEquals(((RealNumber) zeroReal.add(posReal)).getNumber().doubleValue(), 5);
    assertEquals(((RealNumber) zeroReal.subtract(posReal)).getNumber().doubleValue(), -5);
    assertEquals(((RealNumber) zeroReal.multiply(posReal)).getNumber().doubleValue(), 0);
    assertEquals(((RealNumber) zeroReal.divide(posReal)).getNumber().doubleValue(), 0);

    assertEquals(((RealNumber) zeroReal.add(negReal)).getNumber().doubleValue(), -5);
    assertEquals(((RealNumber) zeroReal.subtract(negReal)).getNumber().doubleValue(), 5);
    assertEquals(((RealNumber) zeroReal.multiply(negReal)).getNumber().doubleValue(), 0);
    assertEquals(((RealNumber) zeroReal.divide(negReal)).getNumber().doubleValue(), 0);

    // ImaginaryNumbers-----------------------------------------------------------------------------

    // posImag
    assertEquals(((ImaginaryNumber) posImag.add(posImag)).getNumber().doubleValue(), 10);
    assertEquals(((ImaginaryNumber) posImag.subtract(posImag)).getNumber().doubleValue(), 0);
    assertEquals(((RealNumber) posImag.multiply(posImag)).getNumber().doubleValue(), -25);
    assertEquals(((RealNumber) posImag.divide(posImag)).getNumber().doubleValue(), 1);

    assertEquals(((ImaginaryNumber) posImag.add(negImag)).getNumber().doubleValue(), 0);
    assertEquals(((ImaginaryNumber) posImag.subtract(negImag)).getNumber().doubleValue(), 10);
    assertEquals(((RealNumber) posImag.multiply(negImag)).getNumber().doubleValue(), 25);
    assertEquals(((RealNumber) posImag.divide(negImag)).getNumber().doubleValue(), -1);

    assertEquals(((ImaginaryNumber) posImag.add(zeroImag)).getNumber().doubleValue(), 5);
    assertEquals(((ImaginaryNumber) posImag.subtract(zeroImag)).getNumber().doubleValue(), 5);
    assertEquals(((RealNumber) posImag.multiply(zeroImag)).getNumber().doubleValue(), 0);
    assertEquals(posImag.divide(zeroImag), null);

    // negImag
    assertEquals(((ImaginaryNumber) negImag.add(negImag)).getNumber().doubleValue(), -10);
    assertEquals(((ImaginaryNumber) negImag.subtract(negImag)).getNumber().doubleValue(), 0);
    assertEquals(((RealNumber) negImag.multiply(negImag)).getNumber().doubleValue(), -25);
    assertEquals(((RealNumber) negImag.divide(negImag)).getNumber().doubleValue(), 1);

    assertEquals(((ImaginaryNumber) negImag.add(posImag)).getNumber().doubleValue(), 0);
    assertEquals(((ImaginaryNumber) negImag.subtract(posImag)).getNumber().doubleValue(), -10);
    assertEquals(((RealNumber) negImag.multiply(posImag)).getNumber().doubleValue(), 25);
    assertEquals(((RealNumber) negImag.divide(posImag)).getNumber().doubleValue(), -1);

    assertEquals(((ImaginaryNumber) negImag.add(zeroImag)).getNumber().doubleValue(), -5);
    assertEquals(((ImaginaryNumber) negImag.subtract(zeroImag)).getNumber().doubleValue(), -5);
    assertEquals(((RealNumber) negImag.multiply(zeroImag)).getNumber().doubleValue(), 0);
    assertEquals(negImag.divide(zeroImag), null);

    // zeroImag
    assertEquals(((ImaginaryNumber) zeroImag.add(zeroImag)).getNumber().doubleValue(), 0);
    assertEquals(((ImaginaryNumber) zeroImag.subtract(zeroImag)).getNumber().doubleValue(), 0);
    assertEquals(((RealNumber) zeroImag.multiply(zeroImag)).getNumber().doubleValue(), 0);
    assertEquals(zeroImag.divide(zeroImag), null);

    assertEquals(((ImaginaryNumber) zeroImag.add(posImag)).getNumber().doubleValue(), 5);
    assertEquals(((ImaginaryNumber) zeroImag.subtract(posImag)).getNumber().doubleValue(), -5);
    assertEquals(((RealNumber) zeroImag.multiply(posImag)).getNumber().doubleValue(), 0);
    assertEquals(((RealNumber) zeroImag.divide(posImag)).getNumber().doubleValue(), 0);

    assertEquals(((ImaginaryNumber) zeroImag.add(negImag)).getNumber().doubleValue(), -5);
    assertEquals(((ImaginaryNumber) zeroImag.subtract(negImag)).getNumber().doubleValue(), 5);
    assertEquals(((RealNumber) zeroImag.multiply(negImag)).getNumber().doubleValue(), 0);
    assertEquals(((RealNumber) zeroImag.divide(negImag)).getNumber().doubleValue(), 0);

    // xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
    // /////////////////////////_CALCULATABLES_WITH_OTHER_CALCULATABLES_/////////////
    // xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    // posPos = (8+2i)
    // negPos = (-6+4i)
    // posNeg = (7-7i)
    // negNeg = (-9-1i)

    // posPos, posReal ((8, 2), 5)
    // String oneStr = "(13+2i)";
    // String twoStr = "(3+2i)";
    // String threeStr = "(40+10i)";
    // String fourStr = "(1.6+0.4i)";
    // String fiveStr = "(8+2i)";
    // String sixStr = "(5+5i)";
    // String sevStr = "(8+7i)";
    // String eightStr = "25i";
    // String nineStr = "(-10+40i)";
    // String tenStr = "-1i";
    String oneStr = "(13+2" + ITALIC_I + ")";
    String twoStr = "(3+2" + ITALIC_I + ")";
    String threeStr = "(40+10" + ITALIC_I + ")";
    String fourStr = "(1.6+0.4" + ITALIC_I + ")";
    String fiveStr = "(8+2" + ITALIC_I + ")";
    String sixStr = "(5+5" + ITALIC_I + ")";
    String sevStr = "(8+7" + ITALIC_I + ")";
    String eightStr = "25" + ITALIC_I;
    String nineStr = "(-10+40" + ITALIC_I + ")";
    String tenStr = "-1" + ITALIC_I;
    assertEquals(((ComplexNumber) posPos.add(posReal)).toString(), oneStr);
    assertEquals(((ComplexNumber) posPos.subtract(posReal)).toString(), twoStr);
    assertEquals(((ComplexNumber) posPos.multiply(posReal)).toString(), threeStr);
    assertEquals(((ComplexNumber) posPos.divide(posReal)).toString(), fourStr);

    // posPos, negReal ((8, 2), -5)
    assertEquals(((ComplexNumber) posPos.add(negReal)).toString(), twoStr);
    assertEquals(((ComplexNumber) posPos.subtract(negReal)).toString(), oneStr);
    assertEquals(((ComplexNumber) posPos.multiply(negReal)).toString(), "(-40-10" + ITALIC_I + ")");
    assertEquals(((ComplexNumber) posPos.divide(negReal)).toString(), "(-1.6-0.4" + ITALIC_I + ")");

    // posPos, zeroReal ((8, 2), 0)
    assertEquals(((ComplexNumber) posPos.add(zeroReal)).toString(), fiveStr);
    assertEquals(((ComplexNumber) posPos.subtract(zeroReal)).toString(), fiveStr);
    assertEquals(((RealNumber) posPos.multiply(zeroReal)).toString(), "0");
    assertEquals(posPos.divide(zeroReal), null);

    // System.out.println(posPos);
    // zeroPos, zeroNeg, posZero, negZero
    // Test All calculatable classes
    // Test non-terminating decimals for division and multiplication if possible

    // START OF SIMPLE COVERAGE FOR ALL (Helped find a lot of bugs)
    // posPos = (8+2i), posReal = 5, posImag = 5
    assertEquals(((ComplexNumber) posReal.add(posPos)).toString(), oneStr);
    assertEquals(((ComplexNumber) posReal.add(posImag)).toString(), sixStr);

    assertEquals(((ComplexNumber) posImag.add(posPos)).toString(), sevStr);
    assertEquals(((ComplexNumber) posImag.add(posReal)).toString(), sixStr);

    assertEquals(((ComplexNumber) posPos.add(posReal)).toString(), oneStr);
    assertEquals(((ComplexNumber) posPos.add(posImag)).toString(), sevStr);

    // posPos = (8+2i), posReal = 5, posImag = 5
    assertEquals(((ComplexNumber) posReal.subtract(posPos)).toString(), "(-3-2" + ITALIC_I + ")");
    assertEquals(((ComplexNumber) posReal.subtract(posImag)).toString(), "(5-5" + ITALIC_I + ")");

    assertEquals(((ComplexNumber) posImag.subtract(posPos)).toString(), "(-8+3" + ITALIC_I + ")");
    assertEquals(((ComplexNumber) posImag.subtract(posReal)).toString(), "(-5+5" + ITALIC_I + ")");

    assertEquals(((ComplexNumber) posPos.subtract(posReal)).toString(), twoStr);
    assertEquals(((ComplexNumber) posPos.subtract(posImag)).toString(), "(8-3" + ITALIC_I + ")");

    // posPos = (8+2i), posReal = 5, posImag = 5
    assertEquals(((ComplexNumber) posReal.multiply(posPos)).toString(), threeStr);
    assertEquals(((ImaginaryNumber) posReal.multiply(posImag)).toString(), eightStr);

    assertEquals(((ComplexNumber) posImag.multiply(posPos)).toString(), nineStr);
    assertEquals(((ImaginaryNumber) posImag.multiply(posReal)).toString(), eightStr);

    assertEquals(((ComplexNumber) posPos.multiply(posReal)).toString(), threeStr);
    assertEquals(((ComplexNumber) posPos.multiply(posImag)).toString(), nineStr);

    // posPos = (8+2i), posReal = 5, posImag = 5
    assertEquals(((ComplexNumber) posReal.divide(posPos)).toString(),
        "(0.5882352941176471-0.14705882352941177" + ITALIC_I + ")");
    assertEquals(((ImaginaryNumber) posReal.divide(posImag)).toString(), tenStr);

    assertEquals(((ComplexNumber) posImag.divide(posPos)).toString(),
        "(0.14705882352941177+0.5882352941176471" + ITALIC_I + ")");
    assertEquals(((ImaginaryNumber) posImag.divide(posReal)).toString(), "1" + ITALIC_I);

    assertEquals(((ComplexNumber) posPos.divide(posReal)).toString(), fourStr);
    assertEquals(((ComplexNumber) posPos.divide(posImag)).toString(), "(0.4+1.6" + ITALIC_I + ")");

    ComplexNumber one = new ComplexNumber(2, 2);
    ComplexNumber two = new ComplexNumber(-2, 2);
    assertEquals(one.divide(two).toString(), tenStr);

  }

  @Test
  void testConstructors()
  {
    // Imaginary number constructors
    new ImaginaryNumber(1, 1);
    new ImaginaryNumber(new BigDecimal("2.123"), 1);

    // Complex number constructor
    new ComplexNumber();
    new ComplexNumber(1, 1, 1);
    new ComplexNumber(new BigDecimal("2.0"), new BigDecimal("2.0"), 1);
  }

  @Test
  void testImaginaryExponentiation()
  {
    ImaginaryNumber a = new ImaginaryNumber(2);
    RealNumber one = new RealNumber(1);

    RealNumber b = (RealNumber) a.exponentiation(0);
    assertEquals(one.getNumber(), b.getNumber());
    
    RealNumber negFour = new RealNumber(-4);
    RealNumber c = (RealNumber) a.exponentiation(2);
    
    assertEquals(negFour.getNumber().intValue(), c.getNumber().intValue());
    
    ImaginaryNumber negEight = new ImaginaryNumber(-8);
    ImaginaryNumber d = (ImaginaryNumber) a.exponentiation(3);
    
    assertEquals(negEight.getNumber().intValue(), d.getNumber().intValue());
    
    RealNumber oneOverFour = new RealNumber(-.25);
    RealNumber e = (RealNumber) a.exponentiation(-2);
    
    assertEquals(oneOverFour.getNumber().doubleValue(), e.getNumber().doubleValue());
    
    ImaginaryNumber oneOverEight = new ImaginaryNumber(.125);
    ImaginaryNumber f = (ImaginaryNumber) a.exponentiation(-3);
    
    assertEquals(oneOverEight.getNumber().doubleValue(), f.getNumber().doubleValue());
    
    assertNull(a.exponentiation(1.5));
    assertNull(a.exponentiation(0.5));

  }
  
  @Test
  void testImaginaryRoot() 
  {
    ComplexNumber a = new ComplexNumber(1,1);
    ComplexNumber b = new ComplexNumber(-1,-1);
    ImaginaryNumber two = new ImaginaryNumber(2);
    
    ArrayList<ComplexNumber> solutions = ImaginaryNumber.squareRoot(two);
    
    assertEquals(a.getNormalNumber(), solutions.get(0).getNormalNumber());
    assertEquals(a.getImaginaryNumber(), solutions.get(0).getImaginaryNumber());
    assertEquals(b.getNormalNumber(), solutions.get(1).getNormalNumber());
    assertEquals(b.getImaginaryNumber(), solutions.get(1).getImaginaryNumber());
  }
  
  @Test
  void testImaginaryToString() 
  {
    String a = "1" + "\uD835\uDC8A";
    ImaginaryNumber one = new ImaginaryNumber(1);
    
    assertEquals(a, one.toString());
    
    String b = "-2" + "\uD835\uDC8A";
    ImaginaryNumber two = new ImaginaryNumber(-2);
    
    assertEquals(b, two.toString());
    
    String c = "0";
    ImaginaryNumber three = new ImaginaryNumber(0);
    
    assertEquals(c, three.toString());
    
    String d = "1.25" + "\uD835\uDC8A";
    ImaginaryNumber four = new ImaginaryNumber(1.25);
    
    assertEquals(d, four.toString());
    
    ImaginaryNumber zero = new ImaginaryNumber(2, 0);
    
    assertEquals(c, zero.toString());
    
    String e = "4.1" + "\uD835\uDC8A";
    ImaginaryNumber five = new ImaginaryNumber(4.100);
    
    assertEquals(e, five.toString());
  }
  
  @Test
  void testRealSimpleMethods() {
    RealNumber a = new RealNumber(-4);
    
    RealNumber sixTeen = new RealNumber(16);
    assertEquals(sixTeen.getNumber(), a.exponentiation(2).getNumber());
    
    RealNumber two = new RealNumber(2);
    
    assertEquals(0.5, RealNumber.logarithm(4, 2));
    
    assertEquals(two.getNumber(), two.squareRoot(4).getNumber());
    
    RealNumber decimal = new RealNumber(12.657);
    
    assertEquals("12.657", decimal.toString());
    
  }
  
  @Test
  void testRealDivide() {
    ImaginaryNumber zero = new ImaginaryNumber(0);
    
    RealNumber two = new RealNumber(2);
    
    ComplexNumber bothPositive = new ComplexNumber(2,2);
    ComplexNumber firstNegative = new ComplexNumber(-2,2);
    ComplexNumber secondNegative = new ComplexNumber(2,-2);
    ComplexNumber bothNegative = new ComplexNumber(-2,-2);
    
    assertNull(two.divide(zero));

    assertEquals(two.divide(bothPositive).toString(), new ComplexNumber(.5, -.5).toString());
    assertEquals(two.divide(firstNegative).toString(), new ComplexNumber(-.5, -.5).toString());
    assertEquals(two.divide(secondNegative).toString(), new ComplexNumber(.5, .5).toString());
    assertEquals(two.divide(bothNegative).toString(), new ComplexNumber(-.5, .5).toString());

  }
}
