package gui;

import java.awt.event.ActionEvent;


import javax.swing.AbstractAction;
import javax.swing.JTextPane;

/**
 * ActionListener for shortcut to paste.
 * 
 * @author Jacob Susko
 * @version 11/21/2022
 */
public class EditAction extends AbstractAction
{

  /**
   * SerialVersion.
   */
  private static final long serialVersionUID = 1L;
  private JTextPane display;
  
  /**
   * EditAction constructor.
   * 
   * @param display
   *          That is being pasted into
   */
  public EditAction(final JTextPane display)
  {
    super();
    this.display = display;
  }
  
  @Override
  public void actionPerformed(final ActionEvent e)
  {
    // TODO Auto-generated method stub
    display.setEditable(true);
    display.paste();
    display.setEditable(false);
  }

}
