package gui;

import java.awt.event.*;

import java.util.ArrayList;
import javax.swing.*;

import numbers.Calculatable;
import numbers.ComplexNumber;
import numbers.ImaginaryNumber;
import numbers.InputParse;
import numbers.RealNumber;

/**
 * Action Listener for Buttons.
 * 
 * @author Jacob Susko This work complies with the JMU Honor Code.
 */
public class ButtonPressed extends ButtonsAndKeyActions implements ActionListener
{

  private static final long serialVersionUID = 1L;
  private static final String PREF = "Set Preferences";
  private static final String COM = ", ";
  private CalculatorWindow window;

  /**
   * Constructor for buttons.
   * 
   * @param display
   *          for displaying inputs and calculations
   * @param historyDisplay
   *          for displaying the history
   * @param window
   *          CalculatorWindow this is attached too
   */
  public ButtonPressed(final JTextPane display, final JTextPane historyDisplay,
      final CalculatorWindow window)
  {
    super(display, historyDisplay);
    this.window = window;
  }

  @Override
  public void actionPerformed(final ActionEvent e)
  {
    String action = e.getActionCommand();


    if (action.equals("\n"))
    {
      action = EQUALS;
    }
    else if (action.equals(""))
    {
      action = BACK_ARROW;
    }
    else if (action.equals("X") || action.equals("x") || action.equals("*"))
    {
      action = MULTIPLY;
    }
    else if (action.equals("."))
    {
      action = DECIMAL;
    }
    else if (action.equals("="))
    {
      action = EQUALS;
    }
    else if (action.equals("Définir les Préférences") || action.equals("Establecer Preferencias"))
    {
      action = PREF;
    }
    else if (action.equals("/"))
    {
      action = DIVIDE;
    }
    // else if (display.getToolTipText() != null && display.getToolTipText().equals("."))
    // {
    // this.visualize = true;
    // }
    // else if (display.getToolTipText() != null && display.getToolTipText().equals(""))
    // {
    // this.visualize = false;
    // }
    // Switch Statement for all Buttons
    switch (action)
    {
      case CLEAR:
        clear();
        break;
      case RESET:
        reset();
        break;
      case EQUALS:
        equals();
        break;
      case PLUS:
        checkDisplay(PLUS);
        operations(PLUS);
        break;
      case MINUS:
        checkDisplay(MINUS);
        operations(MINUS);
        break;
      case DIVIDE:
        checkDisplay(DIVIDE);
        operations(DIVIDE);
        break;
      case MULTIPLY:
        checkDisplay(MULTIPLY);
        operations(MULTIPLY);
        break;
      // Start of Numbers
      case ZERO:
        checkDisplay(ZERO);
        displayChar(ZERO);
        appendToCurrent(ZERO);
        break;
      case ONE:
        checkDisplay(ONE);
        displayChar(ONE);
        appendToCurrent(ONE);
        break;
      case TWO:
        checkDisplay(TWO);
        displayChar(TWO);
        appendToCurrent(TWO);
        break;
      case THREE:
        checkDisplay(THREE);
        displayChar(THREE);
        appendToCurrent(THREE);
        break;
      case FOUR:
        checkDisplay(THREE);
        displayChar(FOUR);
        appendToCurrent(FOUR);
        break;
      case FIVE:
        checkDisplay(FIVE);
        displayChar(FIVE);
        appendToCurrent(FIVE);
        break;
      case SIX:
        checkDisplay(SIX);
        displayChar(SIX);
        appendToCurrent(SIX);
        break;
      case SEVEN:
        checkDisplay(SEVEN);
        displayChar(SEVEN);
        appendToCurrent(SEVEN);
        break;
      case EIGHT:
        checkDisplay(EIGHT);
        displayChar(EIGHT);
        appendToCurrent(EIGHT);
        break;
      case NINE:
        checkDisplay(NINE);
        displayChar(NINE);
        appendToCurrent(NINE);
        break;
      case I:
        checkDisplay(I);
        displayChar(I);
        appendToCurrent(I);
        break;
      case SIGN:
        sign();
        break;
      case RIGHT_PARA:
        displayChar(RIGHT_PARA);
        appendToCurrent(RIGHT_PARA);
        // Check if the user has left the parenthesis expression
        int leftPar = 0;
        int rightPar = 0;
        for (int i = 0; i < display.getText().length(); i++)
        {
          if (display.getText().charAt(i) == '(')
          {
            leftPar++;
          }
          if (display.getText().charAt(i) == ')')
          {
            rightPar++;
          }
        }
        if (leftPar == rightPar)
        {
          complexParens = false;
        }
        break;
      case LEFT_PARA:
        checkDisplay(LEFT_PARA);
        displayChar(LEFT_PARA);
        appendToCurrent(LEFT_PARA);
        complexParens = true;
        break;
      case INVERSE:
        // change current operand into inverse
        if (leftOperand == null)
        {
          leftOperand = InputParse.validNumber(display.getText());

          leftOperand.invert();
          display.setText(leftOperand.toString());

        }
        else
        {
          rightOperand = InputParse.validNumber(currentOperand);

          rightOperand.invert();
          display.setText(leftOperand.toString() + operation + rightOperand.toString());

        }
        break;
      case DECIMAL:
        displayChar(DECIMAL);
        appendToCurrent(DECIMAL);
        break;
      case CONJUGATE:
        if (leftOperand == null)
        {
          if (polar)
          {
            leftOperand = InputParse.validNumberPolar(display.getText());
          }
          else
          {
            leftOperand = InputParse.validNumber(display.getText());
          }
          if (leftOperand instanceof ComplexNumber)
          {
            leftOperand = ComplexNumber.conjugate((ComplexNumber) leftOperand);
            if (polar)
            {
              display.setText(InputParse.complexToPolarString((ComplexNumber) leftOperand));
            }
            else
            {
              display.setText(leftOperand.toString());
            }
          }
        }
        else if (leftOperand != null && operation.equals("") && rightOperand == null)
        {
          if (polar)
          {
            leftOperand = InputParse.validNumberPolar(display.getText());
          }
          else
          {
            leftOperand = InputParse.validNumber(display.getText());
          }
          if (leftOperand instanceof ComplexNumber)
          {
            leftOperand = ComplexNumber.conjugate((ComplexNumber) leftOperand);
            if (polar)
            {
              display.setText(InputParse.complexToPolarString((ComplexNumber) leftOperand));
            }
            else
            {
              display.setText(leftOperand.toString());
            }
          }
        }

        else if (rightOperand == null)
        {
          if (polar)
          {
            rightOperand = InputParse.validNumberPolar(currentOperand);
          }
          else
          {
            rightOperand = InputParse.validNumber(currentOperand);
          }

          if (rightOperand instanceof ComplexNumber)
          {
            rightOperand = ComplexNumber.conjugate((ComplexNumber) rightOperand);
            display.setText(leftOperand.toString() + operation + rightOperand.toString());
            if (polar)
            {
              display.setText(InputParse.complexToPolarString((ComplexNumber) leftOperand)
                  + operation + InputParse.complexToPolarString((ComplexNumber) rightOperand));
            }
            else
            {
              display.setText(leftOperand.toString() + operation + rightOperand.toString());
            }

          }
        }
        else if (rightOperand != null && !display.getText().contains(EQUALS))
        {
          if (polar)
          {
            rightOperand = InputParse.validNumberPolar(currentOperand);
          }

          if (rightOperand instanceof ComplexNumber)
          {
            rightOperand = ComplexNumber.conjugate((ComplexNumber) rightOperand);
            display.setText(leftOperand.toString() + operation + rightOperand.toString());
            if (polar)
            {
              display.setText(InputParse.complexToPolarString((ComplexNumber) leftOperand)
                  + operation + InputParse.complexToPolarString((ComplexNumber) rightOperand));
            }
          }
        }
        break;
      case SQUARE_ROOT:
        if (!polar)
        {
          if (leftOperand == null)
          {
            leftOperand = InputParse.validNumber(display.getText());
          }

          Calculatable retValue;
          if (leftOperand instanceof RealNumber)
          {
            RealNumber variable = (RealNumber) leftOperand;
            retValue = variable.squareRoot(variable.getNumber().doubleValue());
            reset();
            display.setText(retValue.toString());
            result = retValue;
          }
          else if (leftOperand instanceof ImaginaryNumber)
          {
            ImaginaryNumber variable = (ImaginaryNumber) leftOperand;
            ArrayList<ComplexNumber> compArr = ImaginaryNumber.squareRoot(variable);
            reset();
            display.setText(compArr.get(0) + COM + compArr.get(1));
          }
          else if (leftOperand instanceof ComplexNumber)
          {
            ComplexNumber variable = (ComplexNumber) leftOperand;
            ArrayList<ComplexNumber> compArr = ComplexNumber.squareRoot(variable);
            reset();
            display.setText(compArr.get(0) + COM + compArr.get(1));
          }
        }
        else
        {
          displayChar(SQUARE_ROOT);
        }
        break;
      case POWER:
        power();
        break;
      case POLAR_FORM:
        polar = !polar;
        break;
      case BACK_ARROW:
        backspace();
        break;
      case LOG:
        // double operand = logarithm(base, antiLog)
        checkDisplay(LOG + LEFT_PARA);
        displayChar(LOG + LEFT_PARA);
        operation = LOG;
        break;
      case PASTE:
        display.setEditable(true);
        display.paste();
        display.setEditable(false);
        break;
      case COS:
        display.setText(display.getText() + COS);
        break;
      case SIN:
        display.setText(display.getText() + SIN);
        break;
      case TAN:
        display.setText(display.getText() + TAN);
        break;
      case ARCTAN:
        display.setText(display.getText() + ARCTAN);
        break;
      case PREF:
        // open new window to pick preferences
        // pref to be picked, shortcuts

        @SuppressWarnings("unused")
        PrefWindow prefwindow = null;
        prefwindow = new PrefWindow(window);

        break;
      default:
        break;

    }
  }

}
