package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import numbers.ComplexNumber;
import numbers.ImaginaryNumber;
import numbers.RealNumber;

class ComplexNumberTest
{
  private String oneStr = "1.0";

  @Test
  void testAddition()
  {
    new ComplexNumber();
    ComplexNumber a = new ComplexNumber(0, 3);
    ComplexNumber b = new ComplexNumber(1, -1);
    ComplexNumber c = (ComplexNumber) a.add(b);

    assertEquals(new BigDecimal("" + 1.0), c.getNormalNumber());
    assertEquals(new BigDecimal("" + 2.0), c.getImaginaryNumber());

    a = new ComplexNumber(-2, -1);
    b = new ComplexNumber(-3, -4);
    c = (ComplexNumber) a.add(b);

    assertEquals(new BigDecimal("" + -5.0), c.getNormalNumber());
    assertEquals(new BigDecimal("" + -5.0), c.getImaginaryNumber());

    a.setNormalNumber(0);
    a.setImaginaryNumber(0);
    b.setNormalNumber(-1);
    b.setImaginaryNumber(-2);
    c = (ComplexNumber) a.add(b);

    assertEquals(new BigDecimal("" + -1.0), c.getNormalNumber());
    assertEquals(new BigDecimal("" + -2.0), c.getImaginaryNumber());

    ComplexNumber x = new ComplexNumber(6.234, 5.124);
    ComplexNumber y = new ComplexNumber(12.145, -3.264);
    x = new ComplexNumber(374.56, 1);
    y = new ComplexNumber(374.26, 1);
    ComplexNumber z = (ComplexNumber) x.subtract(y);
    assertEquals(0.3, z.getNormalNumber().doubleValue());
    assertEquals(0, z.getImaginaryNumber().doubleValue());
    assertNotEquals(9.7, z.getNormalNumber().doubleValue());
    assertNotEquals(2.4, z.getImaginaryNumber().doubleValue());

    BigDecimal first = new BigDecimal("3.4");
    BigDecimal second = new BigDecimal("7.5");
    BigDecimal result = first.add(second);
    assertEquals(result.doubleValue(), 10.9);
    // System.out.println(result);

    // assertEquals(18.379, 6.234 + 12.145);

  }

  @Test
  void testSubtraction()
  {
    ComplexNumber a = new ComplexNumber(0, 3);
    ComplexNumber b = new ComplexNumber(1, -1);
    ComplexNumber c = (ComplexNumber) a.subtract(b);

    String fourStr = "4.0";
    String negFour = "-4.0";
    assertEquals(new BigDecimal("-1.0"), c.getNormalNumber());
    assertEquals(new BigDecimal(fourStr), c.getImaginaryNumber());

    c = (ComplexNumber) b.subtract(a);

    assertEquals(new BigDecimal(oneStr), c.getNormalNumber());
    assertEquals(new BigDecimal(negFour), c.getImaginaryNumber());

    ComplexNumber d = new ComplexNumber(4, 2);
    ComplexNumber e = new ComplexNumber(2, -2);

    ComplexNumber f = (ComplexNumber) d.subtract(e);
    assertEquals(new BigDecimal("2.0"), f.getNormalNumber());
    assertEquals(new BigDecimal(fourStr), f.getImaginaryNumber());

  }

  @Test
  void testMultiplication()
  {
    ComplexNumber a = new ComplexNumber(2, 3);
    ComplexNumber b = new ComplexNumber(5, 2);
    ComplexNumber c = (ComplexNumber) a.multiply(b);

    assertEquals(new BigDecimal("" + 4.0), c.getNormalNumber());
    assertEquals(new BigDecimal("" + 19.0), c.getImaginaryNumber());
  }

  @Test
  void testDivision()
  {
    ComplexNumber a = new ComplexNumber(2, 3);
    ComplexNumber b = new ComplexNumber(7, 8);
    ComplexNumber c = (ComplexNumber) a.divide(b);

    String twoF = "%.2f";
    String res = String.format(twoF, c.getNormalNumber());
    String resb = String.format(twoF, c.getImaginaryNumber());

    assertEquals("0.34", res);
    assertEquals("0.04", resb);

    b.setNormalNumber(0);
    b.setImaginaryNumber(0);

    assertThrows(IllegalArgumentException.class, () -> a.divide(b));

    // BigDecimal three = new BigDecimal("3");
    // BigDecimal four = new BigDecimal("7");
    // System.out.println(3.0 / 7.0 % 1000000000);

  }

  @Test
  void testToString()
  {
    ComplexNumber a = new ComplexNumber(2, 2);
    ComplexNumber b = new ComplexNumber(0, 2);
    ComplexNumber c = new ComplexNumber(2, 0);
    ComplexNumber d = new ComplexNumber(-2, 2);
    ComplexNumber e = new ComplexNumber(2, -2);
    ComplexNumber f = new ComplexNumber(-2, -2);
    ComplexNumber g = new ComplexNumber(2, -1);

    assertEquals("(2+2\uD835\uDC8A)", a.toString());
    assertEquals("2\uD835\uDC8A", b.toString());
    assertEquals("2", c.toString());
    assertEquals("(-2+2\uD835\uDC8A)", d.toString());
    assertEquals("(2-2\uD835\uDC8A)", e.toString());
    assertEquals("(-2-2\uD835\uDC8A)", f.toString());
    assertEquals("(2-1\uD835\uDC8A)", g.toString());

    // BigDecimal first = new BigDecimal("5.06");
    // BigDecimal second = new BigDecimal(oneStr);
    // System.out.println(first.remainder(second));

  }
  
  @Test
  void testConstructors() 
  {
    ComplexNumber a = new ComplexNumber(new BigDecimal(1), new BigDecimal(1));
    new ComplexNumber(1,1,1);
    
    a.setNormalNumber(new BigDecimal(5));
    a.setImaginaryNumber(new BigDecimal(5));
    
    assertEquals(a.getNormalNumber(), new BigDecimal(5));
    assertEquals(a.getImaginaryNumber(), new BigDecimal(5));
    
    a.invert();
    assertEquals(a.getNormalNumber(), new BigDecimal("0.2"));
    assertEquals(a.getImaginaryNumber(), new BigDecimal("0.2"));
    
    a.setNormalNumber(new BigDecimal(0));
    a.setImaginaryNumber(new BigDecimal(5));
    a.invert();
    assertEquals(a.getImaginaryNumber(), new BigDecimal("0.2"));
    
    a.setNormalNumber(new BigDecimal(5));
    a.setImaginaryNumber(new BigDecimal(0));
    a.invert();
    assertEquals(a.getNormalNumber(), new BigDecimal("0.2"));
    
    ComplexNumber.squareRoot(a);
  }
  
  @Test
  void testComplexExponents() 
  {
    ComplexNumber a = new ComplexNumber(new BigDecimal(2), new BigDecimal(2));
    RealNumber zero = new RealNumber(0);
    RealNumber resultA = (RealNumber) a.exponentiation(0);
    
    assertEquals(zero.getNumber(), resultA.getNumber());
    
    ImaginaryNumber eightI = new ImaginaryNumber(8);
    ComplexNumber resultB = (ComplexNumber) a.exponentiation(2);
    
    assertEquals(eightI.getNumber(), resultB.getImaginaryNumber());

  }

}
