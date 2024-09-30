package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import numbers.ComplexNumber;
import numbers.RootFinder;

class RootFinderTest
{

  @Test
  void testRoots()
  {
    // One normal number
    ComplexNumber a = new ComplexNumber(3, 0);
    ArrayList<ComplexNumber> aAnswers = new ArrayList<>();
    aAnswers.add(new ComplexNumber(Math.sqrt(3.0), 0));
    aAnswers.add(new ComplexNumber(Math.sqrt(3.0) * -1, 0));
    
    RootFinder.complexRoot(a);
    
    assertEquals(aAnswers.get(0).getNormalNumber(), 
        RootFinder.complexRoot(a).get(0).getNormalNumber());
    assertEquals(aAnswers.get(1).getNormalNumber(), 
        RootFinder.complexRoot(a).get(1).getNormalNumber());
    
    // One imaginary number
    ComplexNumber b = new ComplexNumber(0, 2);
    ArrayList<ComplexNumber> bAnswers = new ArrayList<>();
    bAnswers.add(new ComplexNumber(1, 1));
    bAnswers.add(new ComplexNumber(-1, -1));
    
    assertEquals(bAnswers.get(0).getImaginaryNumber(), 
        RootFinder.complexRoot(b).get(0).getImaginaryNumber());
    assertEquals(bAnswers.get(1).getImaginaryNumber(), 
        RootFinder.complexRoot(b).get(1).getImaginaryNumber());
    
    // Imaginary and normal are zero
    ComplexNumber zeros = new ComplexNumber(0, 0);
    
    assertEquals(null, RootFinder.complexRoot(zeros));
    
    // Trying to find coverage
    ComplexNumber c = new ComplexNumber(1.41421356237, 1.41421356237);
    RootFinder.complexRoot(c);
    
    ComplexNumber d = new ComplexNumber(-46340,1);
    RootFinder.complexRoot(d);
    
    double e = Math.sqrt((-46340 + Math.sqrt(-46340 * -46340 + 1 * 1)) / 2);
    
    int f = 0;
        
  }

}
