package gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * Action Listener for the Custom ShortCut to
 * open the print window.
 * @author Jacob Susko
 *
 */
public class PrintAction extends AbstractAction
{

  /**
   * Serial ID Number.
   */
  private static final long serialVersionUID = 1L;
  private CalculatorWindow window;
  
  /**
   * Construct Action Listener.
   * @param window
   *          to be printed
   */
  public PrintAction(final CalculatorWindow window)
  {
    super();
    this.window = window;
  }
  
  @Override
  public void actionPerformed(final ActionEvent e)
  {
    // TODO Auto-generated method stub
    ActionEvent event = new ActionEvent(window, 0, "Print");
    window.actionPerformed(event);
  }
}
