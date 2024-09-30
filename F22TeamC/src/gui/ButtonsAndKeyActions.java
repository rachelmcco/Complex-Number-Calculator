package gui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import numbers.Calculatable;
import numbers.ComplexNumber;
import numbers.ImaginaryNumber;
import numbers.InputParse;
import numbers.RealNumber;

/**
 * Parent Class for Button and Keys.
 * 
 * @author Jacob Susko
 *
 */
public class ButtonsAndKeyActions extends AbstractAction
{

  protected static final String CLEAR = "C";
  protected static final String RESET = "R";
  protected static final String EQUALS = "=";
  protected static final String PLUS = "+";
  protected static final String MINUS = "-";
  protected static final String DOUBLE_MINUS = "--";
  protected static final String MULTIPLY = "X";
  protected static final String DIVIDE = "÷";
  protected static final String ERROR = "ERROR";
  protected static final String ZERO = "0";
  protected static final String ONE = "1";
  protected static final String TWO = "2";
  protected static final String THREE = "3";
  protected static final String FOUR = "4";
  protected static final String FIVE = "5";
  protected static final String SIX = "6";
  protected static final String SEVEN = "7";
  protected static final String EIGHT = "8";
  protected static final String NINE = "9";
  protected static final String SIGN = "±";
  protected static final String I = "i";
  protected static final String ITALIC_I = "\uD835\uDC8A";
  protected static final String RIGHT_PARA = ")";
  protected static final String LEFT_PARA = "(";
  protected static final String INVERSE = "Inv";
  protected static final String DECIMAL = ".";
  protected static final String CONJUGATE = "Conj";
  protected static final String SQUARE_ROOT = "√";
  protected static final String POWER = "^";
  protected static final String POLAR_FORM = "PF";
  protected static final String BACK_ARROW = "←";
  protected static final String LOG = "log";
  protected static final String ENGLISH = "English";
  protected static final String SPANISH = "Spanish";
  protected static final String FRENCH = "French";
  protected static final String BLANK = " ";
  protected static final String PASTE = "z";
  protected static final String COS = "cos";
  protected static final String SIN = "sin";
  protected static final String TAN = "tan";
  protected static final String ARCTAN = "arctan";
  protected static final String MESSAGE = "That calculation is not possible";
  protected static final String MESSAGEE = "Calculation cannot be simplified";
  protected static final String MES = "Cannot divide by zero.";
  protected static final String LEFT_BRACK = "[";
  protected static final String RIGHT_BRACK = "]";
  protected static final String NEWLINE = "\n";
  protected static final String BRACKL = "\\[";
  protected static final String BRACKR = "\\]";
  protected static final String LPLUS = "\\+";
  protected static final String RPLUS = ")+(";
  protected static final String RMINUS = ")-(";
  protected static final String RMULT = ")X(";
  protected static final String RDIV = ")÷(";

  protected static boolean polar = false;
  protected static boolean visualize = false;
  // protected static StdDraw graph = null;

  private static final long serialVersionUID = 1L;

  protected boolean neg = false;
  protected boolean sqrt = false;
  protected boolean exponentiation = false;
  protected boolean complexParens = false;

  protected JTextPane display;
  protected JTextPane historyDisplay;
  protected ArrayList<String> history;

  protected String operation = "";
  protected String displayText = "";
  protected String currentOperand = "";

  protected Calculatable leftOperand = null;
  protected Calculatable rightOperand = null;
  protected Calculatable holdValue = null;
  protected Calculatable result = null;
  protected boolean run = false;
  protected boolean compEven = false;
  protected boolean compOdd = false;

  protected int equalsIndex;

  /**
   * Constructor for buttons.
   * 
   * @param display2
   *          for displaying inputs and calculations
   * @param historyDisplay
   *          for displaying the history
   */
  public ButtonsAndKeyActions(final JTextPane display2, final JTextPane historyDisplay)
  {

    this.display = display2;
    // display.setEditable(false);
    StyledDocument doc = this.display.getStyledDocument();
    SimpleAttributeSet center = new SimpleAttributeSet();
    StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
    doc.setParagraphAttributes(0, doc.getLength(), center, false);

    this.historyDisplay = historyDisplay;
    history = new ArrayList<>();
  }

  @Override
  public void actionPerformed(final ActionEvent e)
  {
    // TODO Auto-generated method stub

  }

  // *********************************
  // *********************************
  // Methods to be called
  // *********************************
  // *********************************

  /**
   * Method for clearing most recent operand.
   */
  protected void clear()
  {
    // Clear the input field once it is created
    if (leftOperand != null)
    {
      // if the left operand has been entered, clears second operand
      if (polar && (leftOperand instanceof ComplexNumber))
      {
        display.setText(InputParse.complexToPolarString((ComplexNumber) leftOperand) + operation);
      }
      else
      {
        display.setText(leftOperand.toString() + operation);
      }

      this.currentOperand = "";
    }
    else
    {
      // if the left operand hasn't been entered, therefore clears first operand
      display.setText("");
      this.currentOperand = "";
    }
  }

  protected void reset()
  {
    clear();
    display.setText("");
    this.currentOperand = "";
    this.operation = "";
    leftOperand = null;
    rightOperand = null;
    result = null;
    // if (visualize)
    // {
    // // graph.frame.setVisible(false);
    // drawPoints(null);
    // }
  }

  // ***************************************************************
  // Can we delete because it is not used.... No
  // ****************************************************************
  // private void displayExpression()
  // {
  // if (leftOperand == null)
  // {
  // error();
  // // display.setText(ERROR);
  // clear(display);
  // }
  // else
  // {
  // // textArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
  // displayText = leftOperand.toString();
  // int index = displayText.indexOf(I);
  // displayText = "<html>" + displayText.substring(0, index) + "<i>i </i>"
  // + displayText.substring(index + 1, displayText.length());
  //
  // display.setText(displayText + " " + operation);
  //
  // // String l = new String("<html><center>" + "<i>i </i>");
  // // display.setText(l);
  // // display.setText(leftOperand.toString() + " " + operation);
  // // display.setText(
  // // "<html>(" + leftOperand.toString() + "<i>i " + "<i/></font>" + operation + ")</html>");
  // clear(display);
  // }
  // }

  private void displayEquals()
  {
    // if (leftOperand != null && rightOperand != null && result != null && visualize)
    // {
    // Calculatable allOperands;
    // ArrayList<ComplexNumber> points = new ArrayList<>();
    // for (int i = 0; i < 3; i++)
    // {
    // if (i == 0)
    // {
    // allOperands = leftOperand;
    // }
    // else if (i == 1)
    // {
    // allOperands = rightOperand;
    // }
    // else
    // {
    // allOperands = result;
    // }
    // ComplexNumber use;
    // if (allOperands instanceof RealNumber)
    // {
    // RealNumber rn = (RealNumber) allOperands;
    // if (operation.equals(MINUS) && i == 1)
    // {
    // rn = new RealNumber(-1 * rn.getNumber().doubleValue());
    // }
    // use = new ComplexNumber(rn.getNumber().doubleValue(), 0);
    // }
    // else if (allOperands instanceof ImaginaryNumber)
    // {
    // ImaginaryNumber in = (ImaginaryNumber) allOperands;
    // if (operation.equals(MINUS) && i == 1)
    // {
    // in = new ImaginaryNumber(-1 * in.getNumber().doubleValue());
    // }
    // use = new ComplexNumber(0, in.getNumber().doubleValue());
    // }
    // else
    // {
    // ComplexNumber cn = (ComplexNumber) allOperands;
    // if (operation.equals(MINUS) && i == 1)
    // {
    // cn = new ComplexNumber(-1 * cn.getNormalNumber().doubleValue(),
    // -1 * cn.getImaginaryNumber().doubleValue());
    // }
    // use = cn;
    // }
    // points.add(use);
    // }
    // drawPoints(points);
    // }
    if (operation.equals(POWER))
    {
      display.setText(leftOperand.toString() + operation + LEFT_PARA + rightOperand.toString()
          + RIGHT_PARA + BLANK + EQUALS + BLANK + result.toString());
      history.add(display.getText());
      historyDisplay.setText(historyDisplay.getText() + NEWLINE + history.get(history.size() - 1));
      return;
    }
    if (!polar)
    {
      if (this.leftOperand != null && this.rightOperand != null)
      {
        // Changed for when using parenthesis to keep the original operation
        //
        // display.setText(leftOperand.toString() + BLANK + operation + BLANK +
        // rightOperand.toString()
        // + BLANK + EQUALS + BLANK + result.toString());
        display.setText(display.getText() + BLANK + EQUALS + BLANK + result.toString());
      }
    }
    else
    {
      String leftString = "";
      String rightString = "";
      String resultString = "";

      if (leftOperand instanceof ComplexNumber)
      {
        leftString = InputParse.complexToPolarString((ComplexNumber) leftOperand);
      }
      else
      {
        leftString = leftOperand.toString();
      }

      if (rightOperand instanceof ComplexNumber)
      {
        rightString = InputParse.complexToPolarString((ComplexNumber) rightOperand);
      }
      else
      {
        rightString = rightOperand.toString();
      }

      if (result instanceof ComplexNumber)
      {
        resultString = InputParse.complexToPolarString((ComplexNumber) result);
      }
      else
      {
        result.toString();
      }

      display.setText(leftString + BLANK + operation + BLANK + rightString + BLANK + EQUALS + " "
          + resultString);
    }

    rightOperand = null;
    leftOperand = result;
    result = null;
    this.operation = "";
    run = true;
    equalsIndex = display.getText().indexOf("=");
    // Commented out vvv just to test simple calculator

    // String left = leftOperand.toString();
    // int leftInd = left.indexOf("i");
    // left = "<html>" + left.substring(0, leftInd) + "<i>i </i>"
    // + left.substring(leftInd + 1, left.length());
    //
    // String right = rightOperand.toString();
    // int rightInd = right.indexOf("i");
    // right = "<html>" + right.substring(0, rightInd) + "<i>i </i>"
    // + right.substring(rightInd + 1, right.length());
    //
    // String res = result.toString();
    // int resInd = res.indexOf("i");
    // res = "<html>" + res.substring(0, resInd) + "<i>i </i>"
    // + res.substring(resInd + 1, res.length());
    //
    // // displayText =
    // display.setText(left + " " + operation + " " + right + " " + EQUALS + " " + res);
    // clear(input);
    // // for running store result as leftOperand
    // rightOperand = null;
    // leftOperand = result;
    // result = null;
  }

  /**
   * Adds the string "key" to the display.
   * 
   * @param key
   *          the string to add
   */
  protected void displayChar(final String k)
  {
    String key = k;
    if (k.equals(I))
    {
      key = ITALIC_I;
    }
    try
    {
      if (leftOperand != null && run && leftOperand.equals(result))
      {
        @SuppressWarnings("unused")
        int i = Integer.parseInt(key);
      }
    }
    // Specify the Exception?
    catch (NumberFormatException e)
    {
      if (display.getText().contains("="))
      {
        leftOperand = result;
      }
    }
    if (this.operation.equals(POWER)
        && display.getText().substring(display.getText().length() - 1).equals(")"))
    {
      display.setText(
          display.getText().substring(0, display.getText().length() - 1) + key + RIGHT_PARA);
    }
    else if (this.operation.equals(POWER)
        && !display.getText().substring(display.getText().length() - 1).equals(")"))
    {
      display.setText(display.getText() + key + ")");
    }
    else if (operation.equals(SQUARE_ROOT) && display.getText().equals(""))
    {
      display.setText(display.getText() + key);
    }
    else if (this.operation.equals(SQUARE_ROOT)
        && display.getText().substring(display.getText().length() - 1).equals(")"))
    {
      display.setText(
          display.getText().substring(0, display.getText().length() - 1) + key + RIGHT_PARA);
    }
    else if (this.operation.equals(SQUARE_ROOT)
        && !display.getText().substring(display.getText().length() - 1).equals(")"))
    {
      display.setText(display.getText() + key + ")");
    }
    // else if (operation.equals(PLUS) || operation.equals(MINUS) || operation.equals(DIVIDE)
    // || operation.equals(MULTIPLY))
    // {
    // if (display.getText().contains("(")
    // && display.getText().charAt(display.getText().length() - 1) == '(')
    // {
    // display.setText(display.getText() + key);
    // }
    // else
    // {
    // display.setText(display.getText() + BLANK + key);
    // }
    // }
    else
    {
      if (display.getText().contains("=")/* && result != null */)
      {
        leftOperand = result;
      }
      /*
       * if (leftOperand == result) { leftOperand = null; .println("aggg"); }
       */
      /*
       * if (display.getText().contains("=")) { leftOperand = result; }
       */
      // System.out.println(display.getText() + " Display");
      display.setText(display.getText() + key);
    }
    // }
    // else
    // {
    // display.setText(display.getText() + "<html><i>i</i></html>");
    // }
  }

  /**
   * Adds the string to currentOperand to be parsed.
   * 
   * @param key
   */
  protected void appendToCurrent(final String key)
  {
    this.currentOperand += key;
    // this.currentOperand.replace(")", "");
  }

  /**
   * Called if an error needs to be thrown.
   */
  protected void error()
  {
    reset();
    display.setText("Error!");
  }

  /**
   * Called if an error needs to be thrown.
   * 
   * @param message
   *          error message
   */
  protected void error(final String message)
  {
    reset();
    display.setText("Error!\n" + message);
  }

  /**
   * Checks if the display current has text on it.
   * 
   * @param one
   *          str
   */
  protected void checkDisplay(final String one)
  {

    if (display.getText().contains("Error") || display.getText().contains(EQUALS))
    {
      if (one.equals(PLUS) || one.equals(MINUS) || one.equals(DIVIDE) || one.equals(MULTIPLY))
      {
        if (!polar)
        {
          display.setText(leftOperand.toString());
        }
        else
        {
          if (leftOperand instanceof ComplexNumber)
          {
            ComplexNumber cn = (ComplexNumber) leftOperand;
            display.setText("(" + InputParse.complexToPolarString(cn) + ")");
          }
          else
          {
            display.setText(leftOperand.toString());
          }
        }

      }
      else if (one.equals(LOG + LEFT_PARA))
      {
        display.setText(leftOperand.toString());
      }
      else
      {

        reset();
        if (!display.getText().equals(""))
        {
        }
      }
    }

    // if (result == null && leftOperand != null && rightOperand == null && operation.equals(""))
    // {
    // display.setText(leftOperand.toString() + "banan");
    // }
    // else if (leftOperand == null)
    // {
    // display.setText("");
    // }
    // }
  }

  /**
   * Method to handle sign button.
   */
  protected void sign()
  {
    String expression = display.getText();
    int locationAdd = expression.lastIndexOf(PLUS);
    int locationSub = expression.lastIndexOf(MINUS);
    int locationDiv = expression.lastIndexOf(DIVIDE);
    int locationMult = expression.lastIndexOf(MULTIPLY);
    int locationRight = expression.lastIndexOf(RIGHT_PARA);
    int locationLeft = expression.lastIndexOf(LEFT_PARA);

    // All -1 means all failed so only numbers are in
    if (locationAdd == -1 && locationSub == -1 && locationDiv == -1 && locationMult == -1
        && locationRight == -1 && locationLeft == -1)
    {
      display.setText(MINUS + expression);
    }
    // ********************************************************************
    // + is the last char
    else if (locationAdd > locationSub && locationAdd > locationDiv && locationAdd > locationMult
        && locationAdd > locationRight && locationAdd > locationLeft)
    {
      if (locationAdd == expression.length() - 1)
      {
        display.setText(expression.substring(0, locationAdd) + MINUS);
      }
      else
      {
        display.setText(expression.substring(0, locationAdd) + MINUS
            + expression.substring(locationAdd + 1, expression.length()));
      }
    }
    // **********************************************************************
    // - is the last char
    else if (locationSub > locationAdd && locationSub > locationDiv && locationSub > locationMult
        && locationSub > locationRight && locationSub > locationLeft)
    {
      if (locationSub == expression.length() - 1)
      {
        if (expression.charAt(locationSub - 1) == 'X' || expression.charAt(locationSub - 1) == '÷')
        {
          display.setText(expression.substring(0, locationSub));
        }
        else
        {
          display.setText(expression.substring(0, locationSub) + PLUS);
        }

      }
      else if (locationSub == 0)
      {
        display.setText(expression.substring(1, expression.length()));
      }
      else if (expression.charAt(locationSub - 1) == 'X'
          || expression.charAt(locationSub - 1) == '÷' || expression.charAt(locationSub - 1) == '(')
      {
        display.setText(expression.substring(0, locationSub)
            + expression.substring(locationSub + 1, expression.length()));
      }
      else
      {
        display.setText(expression.substring(0, locationSub) + PLUS
            + expression.substring(locationSub + 1, expression.length()));
      }
    }
    // ***********************************************************************
    // X is last char
    else if (locationMult > locationAdd && locationMult > locationSub && locationMult > locationDiv
        && locationMult > locationRight && locationMult > locationLeft)
    {
      if (locationMult == expression.length() - 1)
      {
        display.setText(expression + MINUS);
      }

      else
      {
        display.setText(expression.substring(0, locationMult + 1) + MINUS
            + expression.substring(locationMult + 1, expression.length()));
      }
    }
    // ************************************************************************
    // ÷ is last char
    else if (locationDiv > locationAdd && locationDiv > locationSub && locationDiv > locationMult
        && locationDiv > locationRight && locationDiv > locationLeft)
    {
      if (locationDiv == expression.length() - 1)
      {
        display.setText(expression + MINUS);
      }

      else
      {
        display.setText(expression.substring(0, locationDiv + 1) + MINUS
            + expression.substring(locationDiv + 1, expression.length()));
      }
    }
    // ***************************************************************************
    // ( is last char
    else if (locationLeft > locationAdd && locationLeft > locationSub && locationLeft > locationMult
        && locationLeft > locationDiv && locationLeft > locationRight)
    {
      if (locationLeft == expression.length() - 1)
      {

        if (expression.charAt(locationLeft - 1) == 'g')
        {
          display.setText(expression);
        }
        else if (expression.charAt(locationLeft - 1) == '^')
        {
          display.setText(expression + MINUS);
        }

      }

      else if (locationLeft == 0)
      {
        display.setText(expression.substring(0, locationLeft + 1) + MINUS
            + expression.substring(locationLeft + 1, expression.length()));
      }

      else
      {
        if (expression.charAt(locationLeft - 1) == 'g')
        {
          display.setText(expression);
        }
        else if (expression.charAt(locationLeft - 1) == '^')
        {
          if (expression.charAt(locationLeft + 1) == '-')
          {
            display.setText(expression.substring(0, locationLeft + 1)
                + expression.substring(locationLeft + 2, expression.length()));
          }
          else
          {
            display.setText(expression.substring(0, locationLeft + 1) + MINUS
                + expression.substring(locationLeft + 2, expression.length()));
          }

        }
      }

    }
    // ***************************************************************************
    // ) is last char
    else if (locationRight > locationAdd && locationRight > locationSub
        && locationRight > locationMult && locationRight > locationDiv
        && locationRight > locationLeft)
    {
      int left = locationLeft;
      if (left == 0)
      {
        display.setText(MINUS + expression);
      }
      else if (expression.charAt(left - 1) == '-')
      {
        if (locationSub == 0)
        {
          display.setText(expression.substring(left, expression.length()));
        }
        else if (expression.charAt(left - 2) == 'X' || expression.charAt(left - 2) == '÷')
        {
          display.setText(
              expression.substring(0, left - 1) + expression.substring(left, expression.length()));
        }
        else
        {
          display.setText(expression.substring(0, left - 1) + PLUS
              + expression.substring(left, expression.length()));
        }
      }

      else if (expression.charAt(left - 1) == '^')
      {
        if (expression.charAt(left + 1) == '-')
        {
          display.setText(expression.substring(0, left + 1)
              + expression.substring(left + 2, expression.length()));
        }
        else
        {
          display.setText(expression.substring(0, left + 1) + MINUS
              + expression.substring(left + 1, expression.length()));
        }
      }

      else if (expression.charAt(left - 1) == 'g')
      {
        display.setText(expression);
      }

      else if (expression.charAt(left - 1) == '+')
      {

        display.setText(expression.substring(0, left - 1) + MINUS
            + expression.substring(left, expression.length()));
      }

      else if (expression.charAt(left - 1) == 'X' || expression.charAt(left - 1) == '÷')
      {
        display.setText(expression.substring(0, left) + MINUS
            + expression.substring(left, expression.length()));
      }
    }

  }

  // *****************************************
  // *****************************************
  // Methods to be called in KeyPressed
  // *****************************************
  // *****************************************

  /**
   * Method to handle operations button and keys.
   * 
   * @param op
   *          operation being used
   */
  protected void operations(final String op)
  {
    // Saves current display string in case changed when numbers are being visualized
    String disStr = display.getText();
    if (display.getToolTipText() != null && display.getToolTipText().equals("."))
    {
      ButtonsAndKeyActions.visualize = true;
    }

    if (complexParens)
    {
      if (!this.currentOperand.equals(""))
      {
        displayChar(op);
      }
      appendToCurrent(op);
      return;
    }
    if (leftOperand == null)
    {
      if (!polar)
      {
        if (display.getText().contains(LEFT_PARA) && !operation.equals(LOG)
            && !operation.equals(POWER))
        {
          changeDisplay();
        }
        display.setText(display.getText().replace("[", "("));
        display.setText(display.getText().replace("]", ")"));
        leftOperand = InputParse.validNumber(display.getText());
        // if (leftOperand != null && visualize)
        // {
        // ComplexNumber use;
        // if (leftOperand instanceof RealNumber)
        // {
        // RealNumber rn = (RealNumber) leftOperand;
        // use = new ComplexNumber(rn.getNumber().doubleValue(), 0);
        // }
        // else if (leftOperand instanceof ImaginaryNumber)
        // {
        // ImaginaryNumber in = (ImaginaryNumber) leftOperand;
        // use = new ComplexNumber(0, in.getNumber().doubleValue());
        // }
        // else
        // {
        // ComplexNumber in = (ComplexNumber) leftOperand;
        // use = in;
        // }
        // ArrayList<ComplexNumber> points = new ArrayList<>();
        // points.add(use);
        // // FunctionGraph.drawPoints(points);
        // drawPoints(points);
        // }
      }
    }
    else
    {
      display.setText(leftOperand.toString());
      // if (leftOperand != null && visualize)
      // {
      // ComplexNumber use;
      // if (leftOperand instanceof RealNumber)
      // {
      // RealNumber rn = (RealNumber) leftOperand;
      // use = new ComplexNumber(rn.getNumber().doubleValue(), 0);
      // }
      // else if (leftOperand instanceof ImaginaryNumber)
      // {
      // ImaginaryNumber in = (ImaginaryNumber) leftOperand;
      // use = new ComplexNumber(0, in.getNumber().doubleValue());
      // }
      // else
      // {
      // ComplexNumber in = (ComplexNumber) leftOperand;
      // use = in;
      // }
      // ArrayList<ComplexNumber> points = new ArrayList<>();
      // points.add(use);
      // // FunctionGraph.drawPoints(points);
      // drawPoints(points);
      // }
    }
    // Sets display back to original (change so that parenthesis calculations can be visualized
    display.setText(disStr);
    this.operation = op;

    displayChar(op);
    this.currentOperand = "";
    // if (display.getText().contains("="))
    // {
    // leftOperand = result;
    // }
    // if (leftOperand != null && currentOperand.equals(""))
    // {
    // display.setText(leftOperand.toString() + op);
    // }
    // if (display.getText().contains(EQUALS))
    // {
    // display.setText(leftOperand.toString() + op);
    // return;
    // }
    // if (complexParens || display.getText().contains(LEFT_PARA))
    // {
    // if (!this.currentOperand.equals(""))
    // {
    // displayChar(op);
    // }
    // appendToCurrent(op);
    // return;
    // }
    // if (leftOperand != null)
    // {
    // display.setText(leftOperand.toString() + op);
    // return;
    // }
    // // Allows for pasting/typing of the first operand
    // else if (!display.getText().equals("") && currentOperand.equals(""))
    // {
    //
    // if (!polar)
    // {
    // leftOperand = InputParse.validNumber(display.getText());
    // }
    // else
    // {
    // leftOperand = InputParse.validNumberPolar(display.getText());
    // }
    // }
    // else
    // {
    // if (!polar)
    // {
    // leftOperand = InputParse.validNumber(currentOperand);
    // }
    // else
    // {
    // leftOperand = InputParse.validNumberPolar(currentOperand);
    // }
    // }
    // if (leftOperand == null)
    // {
    // error("Invalid input");
    // return;
    // }
    // this.operation = op;
    // displayChar(op);
    //
    // this.currentOperand = "";
  }

  protected void changeDisplay()
  {
    if (display.getText().contains("("))
    {
      int parensCount = 0;
      String disStr = display.getText();
      String findStr = "";
      for (int i = 0; i < disStr.length(); i++)
      {
        if (disStr.charAt(i) == '(')
        {
          parensCount++;
        }
      }

      for (int i = 0; i < parensCount; i++)
      {

        if (display.getText().contains(DOUBLE_MINUS))
        {
          display.setText(display.getText().replace(DOUBLE_MINUS, PLUS));
        }
        disStr = display.getText();
        int secondPar = 0;

        // System.out.println("prev was not comp");
        if (i % 2 == 0)
        {
          compEven = false;
        }
        else
        {
          compOdd = false;
        }
        // finds the deepest parens first
        char one = disStr.charAt(disStr.lastIndexOf("("));
        while (one != ')')
        {
          one = disStr.charAt(disStr.lastIndexOf("(") + secondPar);
          secondPar++;
        }

        findStr = disStr.substring(
            disStr.lastIndexOf(LEFT_PARA) + 1 /* doesnt includes the parens */,
            disStr.lastIndexOf(LEFT_PARA) + secondPar - 1);
        equalsStr(findStr);
        holdValue = result;
        if (holdValue instanceof ComplexNumber)
        {
          display.setText(disStr.substring(0, disStr.lastIndexOf("(")) + "["
              + holdValue.toString().substring(1, holdValue.toString().length() - 1) + "]"
              + disStr.substring((disStr.lastIndexOf("(") + secondPar), disStr.length()));
          compEven = true;
        }
        else
        {
          display.setText(disStr.substring(0, disStr.lastIndexOf("(")) + holdValue.toString()
              + disStr.substring((disStr.lastIndexOf("(") + secondPar), disStr.length()));
        }
        // }
      }

    }
  }

  /**
   * Method to handle equals button and Enter Key.
   */
  @SuppressWarnings("unused")
  protected void equals()
  {
    String startStr = display.getText();

    if (!polar)
    {

      if (display.getText().contains(LEFT_PARA) && !operation.equals(LOG)
          && !operation.equals(POWER))
      {
        changeDisplay();
      }
    }
    if (display.getText().contains("["))
    {
      // IF YOU CHANGE, USE CORRECT BRACKETS
      // <<<<<<< HEAD
      // String leftBrack = "\\[";
      // String rightBrack = "\\]";
      // display.setText(display.getText().replaceAll(leftBrack, "("));
      // display.setText(display.getText().replaceAll(rightBrack, ")"));
      // =======
      String leftBrack = BRACKL;
      String rightBrack = BRACKR;
      display.setText(display.getText().replaceAll(leftBrack, LEFT_PARA));
      display.setText(display.getText().replaceAll(rightBrack, RIGHT_PARA));
    }
    String removeStr = display.getText().replaceFirst(ITALIC_I, "");

    // System.out.println(display.getText().indexOf(RIGHT_PARA)
    // + BLANK + (display.getText().length() - 1));
    // Checks if it is complex and has only one i, and the operation is plus or minus

    if (holdValue instanceof ComplexNumber && !removeStr.contains(ITALIC_I)
        && !display.getText().contains(MULTIPLY) && !display.getText().contains(DIVIDE)
        && (display.getText().indexOf(")")
            - display.getText().indexOf("(") == display.getText().length() - 1))
    {

      displayEquals();
      return;
    }
    if (display.getText().contains(DOUBLE_MINUS))
    {
      display.setText(display.getText().replace(DOUBLE_MINUS, PLUS));
    }
    //
    //
    //
    if (operation.equals(POWER))
    {
      // rightOperand = InputParse.validNumber(display.getText()
      // .substring(display.getText().indexOf(LEFT_PARA)
      // + 1, display.getText().indexOf(RIGHT_PARA)));
      rightOperand = InputParse.validNumber(display.getText().substring(
          display.getText().indexOf(POWER) + 2, display.getText().lastIndexOf(RIGHT_PARA)));
      RealNumber rightVariable = null;
      if (rightOperand instanceof RealNumber)
      {
        rightVariable = (RealNumber) rightOperand;
      }
      // start of check
      if (leftOperand instanceof RealNumber)
      {
        RealNumber leftVariable = (RealNumber) leftOperand;
        if (rightVariable != null)
        {
          result = leftOperand.exponentiation(rightVariable.getNumber().doubleValue());
        }
        else
        {
          error(MESSAGE);
          return;
        }

      }
      else if (leftOperand instanceof ImaginaryNumber)
      {
        ImaginaryNumber leftVariable = (ImaginaryNumber) leftOperand;
        if (rightVariable != null && rightVariable.getNumber().doubleValue() % 1 == 0
        /* && rightVariable.getNumber().doubleValue() >= 0 */)
        {
          result = leftOperand.exponentiation(rightVariable.getNumber().doubleValue());
        }
        else
        {
          error(MESSAGE);
          return;
        }
      }
      else if (leftOperand instanceof ComplexNumber)
      {
        ComplexNumber leftVariable = (ComplexNumber) leftOperand;
        if (rightVariable != null && rightVariable.getNumber().doubleValue() % 1 == 0
        /* && rightVariable.getNumber().doubleValue() >= 0 */)
        {
          result = leftOperand.exponentiation(rightVariable.getNumber().doubleValue());
        }
        else
        {
          error(MESSAGE);
          return;
        }
      }
      display.setText(startStr);
      displayEquals();
      return;
    }
    else if (operation.equals(LOG))
    {
      int argumentLocation = display.getText().indexOf("g") + 2;
      // System.out.println("Argument Location:" + argumentLocation);
      String argument = display.getText().substring(argumentLocation,
          display.getText().length() - 1);
      // System.out.println("Argument: " + argument);
      String antiLog = display.getText().substring(0, display.getText().indexOf("l"));
      // System.out.println("antilog: " + antiLog);

      double antiNum = 0;
      double baseNum = 0;

      Calculatable arg = InputParse.validNumber(argument);
      Calculatable base = InputParse.validNumber(antiLog);

      if (arg == null || base == null)
      {
        // If error, just clears and moves on.
        reset();
        return;
      }
      if (arg.getClass() != base.getClass())
      {
        // display.setText(display.getText() + BLANK + EQUALS + BLANK + display.getText());
        error(MESSAGEE);
      }
      else if (!(arg instanceof RealNumber) && !(base instanceof RealNumber))
      {
        if (arg instanceof ImaginaryNumber)
        {
          ImaginaryNumber arg2 = (ImaginaryNumber) arg;
          ImaginaryNumber base2 = (ImaginaryNumber) base;
          if (arg2.toString().equals(base2.toString()))
          {
            result = new RealNumber(1);
            display.setText(display.getText() + BLANK + EQUALS + BLANK + result);
            rightOperand = null;
            leftOperand = result;
            result = null;
            this.operation = "";
          }
          else
          {
            error(MESSAGEE);
          }
        }
        else
        {
          ComplexNumber arg2 = (ComplexNumber) arg;
          ComplexNumber base2 = (ComplexNumber) base;
          if (arg2.toString().equals(base2.toString()))
          {
            result = new RealNumber(1);
            display.setText(display.getText() + BLANK + EQUALS + BLANK + result);
            rightOperand = null;
            leftOperand = result;
            result = null;
            this.operation = "";
          }
          else
          {
            error(MESSAGEE);
          }
        }
      }
      else
      {
        try
        {
          antiNum = Double.parseDouble(antiLog);
          // System.out.printlsn(antiNum);
          baseNum = Double.parseDouble(argument);
          // System.out.println(baseNum);
        }
        catch (NumberFormatException e)
        {
          error("Invalid log form");
          return;
        }

        result = new RealNumber(RealNumber.logarithm(antiNum, baseNum));
        display.setText(display.getText() + BLANK + EQUALS + BLANK + result);
        rightOperand = null;
        leftOperand = result;
        result = null;
        this.operation = "";
      }
      return;
    }
    String displayString = display.getText();
    if (displayString.charAt(0) == '(' && displayString.charAt(displayString.length() - 1) == ')')
    {
      if (!polar)
      {
        leftOperand = InputParse
            .validNumber(displayString.substring(1, displayString.indexOf(")")));
        displayString = displayString.substring(displayString.indexOf(")") + 1,
            displayString.length());
        operation = displayString.substring(0, 1);
        displayString = displayString.substring(displayString.indexOf(operation) + 1,
            displayString.length());
        rightOperand = InputParse.validNumber(displayString);
      }
      else
      {
        int operationIndex = displayString.indexOf(RPLUS);
        if (operationIndex == -1)
        {
          operationIndex = displayString.indexOf(RMINUS);
        }
        if (operationIndex == -1)
        {
          operationIndex = displayString.indexOf(RMULT);
        }
        if (operationIndex == -1)
        {
          operationIndex = displayString.indexOf(RDIV);
        }
        operation = displayString.substring(operationIndex + 1, operationIndex + 2);
        leftOperand = InputParse.validNumberPolar(displayString.substring(0, operationIndex + 1));
        rightOperand = InputParse.validNumberPolar(
            displayString.substring(operationIndex + 2, displayString.length() - 1));
      }
      switch (operation)
      {
        case PLUS:
          result = leftOperand.add(rightOperand);
          break;
        case MINUS:
          result = leftOperand.subtract(rightOperand);
          break;
        case DIVIDE:
          result = leftOperand.divide(rightOperand);
          break;
        case MULTIPLY:
          result = leftOperand.multiply(rightOperand);
          break;
        default:
          break;
      }
      display.setText(startStr);
      displayEquals();
    }
    else if (displayString.charAt(0) == '(')
    {
      int endComplexIndex = displayString.length() - 1;
      for (int i = displayString.length() - 1; i >= 0; i--)
      {
        if (endComplexIndex == displayString.length() - 1)
        {
          String y = displayString.substring(i, i + 1);
          if (y.equals(PLUS) || y == MINUS || y == MULTIPLY || y == DIVIDE)
          {
            endComplexIndex = i;
          }
        }
      }
      if (!polar)
      {
        leftOperand = InputParse
            .validNumber(displayString.substring(1, displayString.indexOf(")")));
      }
      else
      {
        leftOperand = InputParse.validNumberPolar(displayString.substring(1, endComplexIndex));
      }
      if (!polar)
      {
        displayString = displayString.substring(displayString.indexOf(")") + 1,
            displayString.length());
      }
      else
      {
        displayString = displayString.substring(endComplexIndex, displayString.length());
      }
      operation = displayString.substring(0, 1);
      displayString = displayString.substring(displayString.indexOf(operation) + 1,
          displayString.length());
      rightOperand = InputParse.validNumber(displayString);
      switch (operation)
      {
        case PLUS:
          result = leftOperand.add(rightOperand);
          break;
        case MINUS:
          result = leftOperand.subtract(rightOperand);
          break;
        case DIVIDE:
          if (rightOperand.toString().equals("0"))
          {
            result = null;
            error(MES);
            return;
          }
          else
          {
            result = leftOperand.divide(rightOperand);
          }
          break;
        case MULTIPLY:
          result = leftOperand.multiply(rightOperand);
          break;
        default:
          break;
      }
      display.setText(startStr);
      displayEquals();
    }
    else if (displayString.charAt(displayString.length() - 1) == ')')
    {
      leftOperand = InputParse
          .validNumber(displayString.substring(0, displayString.indexOf("(") - 1));
      displayString = displayString.substring(displayString.indexOf("(") - 1,
          displayString.length());
      operation = displayString.substring(0, 1);
      displayString = displayString.substring(displayString.indexOf(operation) + 1,
          displayString.length());
      if (!polar)
      {
        rightOperand = InputParse.validNumber(displayString);
      }
      else
      {
        rightOperand = InputParse.validNumberPolar(displayString);
      }
      switch (operation)
      {
        case PLUS:
          result = leftOperand.add(rightOperand);
          break;
        case MINUS:
          result = leftOperand.subtract(rightOperand);
          break;
        case DIVIDE:
          result = leftOperand.divide(rightOperand);
          break;
        case MULTIPLY:
          result = leftOperand.multiply(rightOperand);
          break;
        default:
          break;
      }
      display.setText(startStr);
      displayEquals();
    }
    else if (displayString.charAt(0) != '('
        && displayString.charAt(displayString.length() - 1) != ')')
    {

      boolean firstNeg = false;
      if (displayString.charAt(0) == '-')
      {
        firstNeg = true;
        displayString = displayString.substring(1, displayString.length());
      }
      if (displayString.contains(MULTIPLY))
      {
        operation = MULTIPLY;
      }
      else if (displayString.contains(DIVIDE))
      {
        operation = DIVIDE;
      }
      else if (displayString.contains(PLUS))
      {
        operation = PLUS;
      }
      else if (displayString.contains(MINUS))
      {
        operation = MINUS;
      }
      if (firstNeg)
      {
        displayString = "-" + displayString;
      }

      String[] strArr = new String[2];
      if (operation.equals(PLUS))
      {
        strArr = displayString.split(LPLUS);
      }
      else
      {
        // makes sure not to split the negative if it is
        if (/* display.getText().charAt(0) == '-' */firstNeg)
        {
          displayString = displayString.substring(1, displayString.length());
          strArr = displayString.split(operation);
          strArr[0] = "-" + strArr[0];
          displayString = "-" + displayString;
        }
        else
        {
          strArr = displayString.split(operation);
        }

        // strArr = displayString.split(operation);
        // strArr[0] = "-" + strArr[0];
      }

      // System.out.println(leftOperand.toString() + " " + rightOperand.toString());
      leftOperand = InputParse.validNumber(strArr[0]);
      // System.out.println("start str: " + startStr + " len:" + strArr.length);
      if (strArr.length <= 1 || (!startStr.contains(PLUS) && !startStr.contains(MINUS)
          && !startStr.contains(MULTIPLY) && !startStr.contains(DIVIDE)))
      {
        // Added the "|| (!startStr.contains(PLUS) && !startStr.contains(MINUS)
        // && !startStr.contains(MULTIPLY) && !startStr.contains(DIVIDE))"
        // that should just tell if it is a normal/imag number by itself
      }
      else
      {
        rightOperand = InputParse.validNumber(strArr[1]);
        switch (operation)
        {
          // TODO
          case PLUS:
            result = leftOperand.add(rightOperand);
            break;
          case MINUS:
            result = leftOperand.subtract(rightOperand);
            break;
          case DIVIDE:
            if (rightOperand.toString().equals("0"))
            {
              result = null;
              error(MES);
              return;
            }
            else
            {
              result = leftOperand.divide(rightOperand);
            }
            break;
          case MULTIPLY:
            result = leftOperand.multiply(rightOperand);
            break;
          default:
            break;
        }
      }
      display.setText(startStr);
      displayEquals();
    }
    neg = false;
    this.currentOperand = "";
    history.add(display.getText());
    historyDisplay.setText(historyDisplay.getText() + NEWLINE + history.get(history.size() - 1));
  }
  // }

  /**
   * Method to handle backspace button.
   */
  protected void backspace()
  {
    // prevents error when backspacing too many times
    if (display.getText().length() > 0 && operation.equals(POWER) && !polar
        || operation.equals(SQUARE_ROOT) && !polar)
    {
      currentOperand = currentOperand.substring(0, currentOperand.length() - 1);
      // System.out.println(currentOperand);
      display.setText(display.getText().substring(0, display.getText().length() - 2) + ")");
      // System.out.println(display.getText());
    }
    else if (display.getText().length() > 0 && currentOperand.length() > 0)
    {
      display.setText(display.getText().substring(0, display.getText().length() - 1));
      currentOperand = currentOperand.substring(0, currentOperand.length() - 1);
    }
    else if (display.getText().length() > 0)
    {
      display.setText(display.getText().substring(0, display.getText().length() - 1));
    }
  }

  /**
   * Method to handle power button.
   */
  protected void power()
  {
    operations(POWER);
    if (leftOperand != null)
    {
      display.setText(leftOperand.toString() + POWER + "(");
      operation = POWER;
    }
    else
    {
      if (currentOperand.equals(""))
      {
        reset();
      }
      else
      {
        leftOperand = InputParse.validNumber(currentOperand);
        display.setText(leftOperand.toString() + POWER);
        operation = POWER;
      }
    }
    this.currentOperand = "";
  }

  //
  //
  //
  //
  //
  //
  //
  //
  //
  //
  //
  protected void equalsStr(final String str)
  {
    String equalStr = str;
    if (equalStr.contains("["))
    {
      // IF YOU REPLACE USE THE CORRECT BRACKET/BRACE
      // <<<<<<< HEAD
      // equalStr = equalStr.replaceAll("\\[", "(");
      // equalStr = equalStr.replaceAll("\\]", ")");
      // =======
      equalStr = equalStr.replaceAll(BRACKL, LEFT_PARA);
      equalStr = equalStr.replaceAll(BRACKR, RIGHT_PARA);
    }
    display.setText(equalStr);
    // if (operation.equals(POWER))
    // {
    // rightOperand = InputParse.validNumber(display.getText()
    // .substring(display.getText().indexOf("(") + 1, display.getText().indexOf(")")));
    // // Calculatable retValue;
    //
    // RealNumber rightVariable = null;
    // if (rightOperand instanceof RealNumber)
    // {
    // rightVariable = (RealNumber) rightOperand;
    // }
    // // start of check
    // if (leftOperand instanceof RealNumber)
    // {
    // RealNumber leftVariable = (RealNumber) leftOperand;
    // if (rightVariable != null)
    // {
    // result = leftOperand.exponentiation(rightVariable.getNumber().doubleValue());
    // }
    // else
    // {
    // error("That calculation is not possible");
    // return;
    // }
    //
    // }
    // else if (leftOperand instanceof ImaginaryNumber)
    // {
    // ImaginaryNumber leftVariable = (ImaginaryNumber) leftOperand;
    // if (rightVariable != null && rightVariable.getNumber().doubleValue() % 1 == 0
    // && rightVariable.getNumber().doubleValue() >= 0)
    // {
    // result = leftOperand.exponentiation(rightVariable.getNumber().doubleValue());
    // }
    // else
    // {
    // error("That calculation is not possible");
    // return;
    // }
    // }
    // else if (leftOperand instanceof ComplexNumber)
    // {
    // ComplexNumber leftVariable = (ComplexNumber) leftOperand;
    // if (rightVariable != null && rightVariable.getNumber().doubleValue() % 1 == 0
    // && rightVariable.getNumber().doubleValue() >= 0)
    // {
    // result = leftOperand.exponentiation(rightVariable.getNumber().doubleValue());
    // }
    // else
    // {
    // error("That calculation is not possible");
    // return;
    // }
    // }
    // displayEquals();
    // return;
    // }
    // else if (operation.equals(LOG))
    // {
    // int baseLocation = display.getText().indexOf("g") + 2;
    // String base = display.getText().substring(baseLocation, display.getText().length() - 1);
    // int antiLogLoc = display.getText().indexOf("l") - 1;
    // String antiLog = display.getText().substring(1, antiLogLoc);
    //
    // int antiNum = 0;
    // int baseNum = 0;
    //
    // try
    // {
    // antiNum = Integer.parseInt(antiLog);
    // baseNum = Integer.parseInt(base);
    // }
    // catch (NumberFormatException e)
    // {
    // error("Invalid log form");
    // return;
    // }
    //
    // double answer = RealNumber.logarithm(baseNum, antiNum);
    // display.setText(display.getText() + EQUALS + answer);
    //
    // }
    //
    // TODO XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    //
    String displayString = equalStr;
    if (displayString.charAt(0) == '(' && displayString.charAt(displayString.length() - 1) == ')')
    {
      if (!polar)
      {
        leftOperand = InputParse
            .validNumber(displayString.substring(1, displayString.indexOf(")")));
        displayString = displayString.substring(displayString.indexOf(")") + 1,
            displayString.length());
        operation = displayString.substring(0, 1);
        displayString = displayString.substring(displayString.indexOf(operation) + 1,
            displayString.length());
        rightOperand = InputParse.validNumber(displayString);
      }
      else
      {
        int operationIndex = displayString.indexOf(RPLUS);
        if (operationIndex == -1)
        {
          operationIndex = displayString.indexOf(RMINUS);
        }
        if (operationIndex == -1)
        {
          operationIndex = displayString.indexOf(RMULT);
        }
        if (operationIndex == -1)
        {
          operationIndex = displayString.indexOf(RDIV);
        }
        operation = displayString.substring(operationIndex + 1, operationIndex + 2);
        leftOperand = InputParse.validNumberPolar(displayString.substring(0, operationIndex + 1));
        rightOperand = InputParse.validNumberPolar(
            displayString.substring(operationIndex + 2, displayString.length() - 1));
      }
      switch (operation)
      {
        case PLUS:
          result = leftOperand.add(rightOperand);
          break;
        case MINUS:
          result = leftOperand.subtract(rightOperand);
          break;
        case DIVIDE:
          result = leftOperand.divide(rightOperand);
          break;
        case MULTIPLY:
          result = leftOperand.multiply(rightOperand);
          break;
        default:
          break;
      }
    }
    else if (displayString.charAt(0) == '(')
    {
      int endComplexIndex = displayString.length() - 1;
      for (int i = displayString.length() - 1; i >= 0; i--)
      {
        if (endComplexIndex == displayString.length() - 1)
        {
          if (!Character.isDigit(displayString.charAt(i)))
          {
            endComplexIndex = i;
          }
        }
      }
      if (!polar)
      {
        leftOperand = InputParse
            .validNumber(displayString.substring(1, displayString.indexOf(")")));
      }
      else
      {
        leftOperand = InputParse.validNumberPolar(displayString.substring(1, endComplexIndex));
      }
      if (!polar)
      {
        displayString = displayString.substring(displayString.indexOf(")") + 1,
            displayString.length());
      }
      else
      {
        displayString = displayString.substring(endComplexIndex, displayString.length());
      }
      operation = displayString.substring(0, 1);
      displayString = displayString.substring(displayString.indexOf(operation) + 1,
          displayString.length());
      rightOperand = InputParse.validNumber(displayString);
      switch (operation)
      {
        case PLUS:
          result = leftOperand.add(rightOperand);
          break;
        case MINUS:
          result = leftOperand.subtract(rightOperand);
          break;
        case DIVIDE:
          if (rightOperand.toString().equals("0"))
          {
            result = null;
            error(MES);
          }
          else
          {
            result = leftOperand.divide(rightOperand);
          }
          break;
        case MULTIPLY:
          result = leftOperand.multiply(rightOperand);
          break;
        default:
          break;
      }
    }
    else if (displayString.charAt(displayString.length() - 1) == ')')
    {
      leftOperand = InputParse
          .validNumber(displayString.substring(0, displayString.indexOf("(") - 1));
      displayString = displayString.substring(displayString.indexOf("(") - 1,
          displayString.length());
      operation = displayString.substring(0, 1);
      displayString = displayString.substring(displayString.indexOf(operation) + 1,
          displayString.length());
      if (!polar)
      {
        rightOperand = InputParse.validNumber(displayString);
      }
      else
      {
        rightOperand = InputParse.validNumberPolar(displayString);
      }
      switch (operation)
      {
        case PLUS:
          result = leftOperand.add(rightOperand);
          break;
        case MINUS:
          result = leftOperand.subtract(rightOperand);
          break;
        case DIVIDE:
          result = leftOperand.divide(rightOperand);
          break;
        case MULTIPLY:
          result = leftOperand.multiply(rightOperand);
          break;
        default:
          break;
      }
    }
    else if (displayString.charAt(0) != '('
        && displayString.charAt(displayString.length() - 1) != ')')
    {
      boolean firstNeg = false;
      if (displayString.charAt(0) == '-')
      {
        firstNeg = true;
        displayString = displayString.substring(1, displayString.length());
      }
      if (displayString.contains(MULTIPLY))
      {
        operation = MULTIPLY;
      }
      else if (displayString.contains(DIVIDE))
      {
        operation = DIVIDE;
      }
      else if (displayString.contains(PLUS))
      {
        operation = PLUS;
      }
      else if (displayString.contains(MINUS))
      {
        operation = MINUS;
      }

      if (firstNeg)
      {
        displayString = "-" + displayString;
      }

      String[] strArr = new String[2];
      if (operation.equals(PLUS))
      {
        strArr = displayString.split(LPLUS);
      }
      else
      {
        // makes sure not to split the negative if it is
        if (equalStr.charAt(0) == '-')
        {
          displayString = displayString.substring(1, displayString.length());
          strArr = displayString.split(operation);
          strArr[0] = "-" + strArr[0];
          displayString = "-" + displayString;
        }
        else
        {
          strArr = displayString.split(operation);
        }
      }
      leftOperand = InputParse.validNumber(strArr[0]);
      // TODO
      if (strArr.length > 1)
      {
        rightOperand = InputParse.validNumber(strArr[1]);
        // System.out.println("rightOperand : " + rightOperand);
        // System.out.println("leftOperand : " + leftOperand);
        switch (operation)
        {
          case MULTIPLY:
            result = leftOperand.multiply(rightOperand);
            break;
          case DIVIDE:
            if (rightOperand.toString().equals("0"))
            {
              result = null;
              error(MES);
            }
            else
            {
              result = leftOperand.divide(rightOperand);
            }
            break;
          case PLUS:
            result = leftOperand.add(rightOperand);
            break;
          case MINUS:
            result = leftOperand.subtract(rightOperand);
            break;
          default:
            break;
        }
      }
    }
    neg = false;
    this.currentOperand = "";
  }

}
