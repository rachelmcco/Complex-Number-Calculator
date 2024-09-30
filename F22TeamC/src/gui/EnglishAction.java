package gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * Action Listerner for the Custom ShortCut to 
 * Change language to english.
 * @author Jacob Susko
 *
 */
public class EnglishAction extends AbstractAction
{

  /**
   * Serial ID Number.
   */
  private static final long serialVersionUID = 1L;
  private CalculatorWindow window;
  
  /**
   * Construct Action Listener.
   * @param window
   *          Where language is changed
   */
  public EnglishAction(final CalculatorWindow window)
  {
    super();
    this.window = window;
  }
  
  @Override
  public void actionPerformed(final ActionEvent e)
  {
    // TODO Auto-generated method stub
    ActionEvent event = new ActionEvent(window, 0, "English");
    window.actionPerformed(event);
  }

}
