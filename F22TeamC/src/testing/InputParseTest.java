package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import numbers.Calculatable;
import numbers.ComplexNumber;
import numbers.InputParse;

class InputParseTest
{

  private static final String ITALIC_I = "\uD835\uDC8A";
  private static final String BOTH_POSITIVE = "√(25)cos(arctan(4÷3)) + √(25)sin(arctan(4÷3))" 
      + ITALIC_I;
  private static final String NEGATIVE_POSITIVE = "√(25)cos(-arctan(4÷3)) "
      + "+ √(25)sin(-arctan(4÷3))" + ITALIC_I;
  private static final String POSITIVE_NEGATIVE = "√(25)cos(π - arctan(4÷3)) "
      + "+ √(25)sin(π - arctan(4÷3))" + ITALIC_I;
  private static final String BOTH_NEGATIVE = "√(25)cos(arctan(4÷3) - π) "
      + "+ √(25)sin(arctan(4÷3) - π)" + ITALIC_I;
  private static final String FOUR = "4";
  private static final String THREE = "3";
  private static final String NEG_FOUR = "-4";
  private static final String NEG_THREE = "-3";

   @Test
   void testValidNumber()
   {
     
     
     String a = "3+2" + ITALIC_I;
     Calculatable b = InputParse.validNumber(a);
  
     assertEquals(new BigDecimal("3.0"), ((ComplexNumber) b).getNormalNumber());
     assertEquals(new BigDecimal("2.0"), ((ComplexNumber) b).getImaginaryNumber());
   }

  @Test
  void testValidNumberPolar()
  {
    ComplexNumber b = InputParse.validNumberPolar(BOTH_POSITIVE);

    assertEquals(new BigDecimal(FOUR), b.getImaginaryNumber());
    assertEquals(new BigDecimal(THREE), b.getNormalNumber());

    ComplexNumber d = InputParse.validNumberPolar(NEGATIVE_POSITIVE);

    assertEquals(new BigDecimal(NEG_FOUR), d.getImaginaryNumber());
    assertEquals(new BigDecimal(THREE), d.getNormalNumber());

    ComplexNumber f = InputParse.validNumberPolar(POSITIVE_NEGATIVE);

    assertEquals(new BigDecimal(FOUR), f.getImaginaryNumber());
    assertEquals(new BigDecimal(NEG_THREE), f.getNormalNumber());

    ComplexNumber h = InputParse.validNumberPolar(BOTH_NEGATIVE);

    assertEquals(new BigDecimal(NEG_FOUR), h.getImaginaryNumber());
    assertEquals(new BigDecimal(NEG_THREE), h.getNormalNumber());

    String i = "5cos(arctan(4÷3)) + 5sin(arctan(4÷3))i";
    ComplexNumber j = InputParse.validNumberPolar(i);

    assertEquals(new BigDecimal(FOUR), j.getImaginaryNumber());
    assertEquals(new BigDecimal(THREE), j.getNormalNumber());

    String k = "5+2i";
    assertThrows(IndexOutOfBoundsException.class, () -> {
      InputParse.validNumberPolar(k);
    });
  }

  @Test
  void testConversion()
  {
    ComplexNumber b = InputParse.validNumberPolar(BOTH_POSITIVE);
    assertEquals(BOTH_POSITIVE, InputParse.complexToPolarString(b));

    ComplexNumber d = InputParse.validNumberPolar(NEGATIVE_POSITIVE);
    assertEquals(NEGATIVE_POSITIVE, InputParse.complexToPolarString(d));

    ComplexNumber f = InputParse.validNumberPolar(POSITIVE_NEGATIVE);
    assertEquals(POSITIVE_NEGATIVE, InputParse.complexToPolarString(f));

    ComplexNumber h = InputParse.validNumberPolar(BOTH_NEGATIVE);
    assertEquals(BOTH_NEGATIVE, InputParse.complexToPolarString(h));

    ComplexNumber i = new ComplexNumber(2.52753, 4.7502498);
    System.out.println(InputParse.complexToPolarString(i));

  }

}
