package gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * Action Listener for the Custom ShortCut to 
 * close the window/program.
 * @author Jacob Susko
 *
 */
public class ExitAction extends AbstractAction
{

  /**
   * Serial ID Number.
   */
  private static final long serialVersionUID = 1L;
  private CalculatorWindow window;
  
  /**
   * Construct Action Listener.
   * @param window
   *          to be closed
   */
  public ExitAction(final CalculatorWindow window)
  {
    super();
    this.window = window;
  }
  
  @Override
  public void actionPerformed(final ActionEvent e)
  {
    // TODO Auto-generated method stub
    ActionEvent event = new ActionEvent(window, 0, "Exit");
    window.actionPerformed(event);
  }
}
