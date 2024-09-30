package gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * Action Listener for the Custom ShortCut to
 * open the set preference window.
 * @author Jacob Susko
 *
 */
public class SetPAction extends AbstractAction
{

  /**
   * Serial ID Number.
   */
  private static final long serialVersionUID = 1L;
  private ButtonPressed window;
  
  /**
   * Construct Action Listener.
   * @param window
   *          to have custom short cut edited
   */
  public SetPAction(final ButtonPressed window)
  {
    super();
    this.window = window;
  }
  
  @Override
  public void actionPerformed(final ActionEvent e)
  {
    // TODO Auto-generated method stub
    ActionEvent event = new ActionEvent(window, 0, "Set Preferences");
    window.actionPerformed(event);
  }
}
