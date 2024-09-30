package gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * 
 * @author jacob
 *
 */
public class AboutAction extends AbstractAction
{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private CalculatorWindow window;
  
  /**
   * 
   * @param window
   */
  public AboutAction(final CalculatorWindow window)
  {
    super();
    this.window = window;
  }
  
  @Override
  public void actionPerformed(final ActionEvent e)
  {
    // TODO Auto-generated method stub
    ActionEvent event = new ActionEvent(window, 0, "About");
    window.actionPerformed(event);
  }
}
