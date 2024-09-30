package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * 
 * @author Stephanie Koehler
 * @version 11/4--sprint 1
 * 
 * This work complies with the JMU Honor Code.
 */
public class Typed implements KeyListener
{

  private JTextPane inputPane;
  // private SimpleAttributeSet attribs;
  private StyledDocument doc;
  private Style style;
  
  /**
   * Constructor for the typed listener.
   * 
   * @param inputPane pane where the keys are being accessed
   */
  public Typed(final JTextPane inputPane) 
  {
    this.inputPane = inputPane;
    doc = inputPane.getStyledDocument();
    style = inputPane.addStyle("", null);
    // this.attribs = attribs;
  }

  @Override
  public void keyTyped(final KeyEvent e) 
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void keyPressed(final KeyEvent e) 
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void keyReleased(final KeyEvent e) 
  {
    char key = e.getKeyChar();
    
    if (key == 'i') 
    {
      inputPane.setText(inputPane.getText().substring(0, 
          inputPane.getText().length() - 1));
      StyleConstants.setItalic(style, true);
      try 
      {
        doc.insertString(doc.getLength(), "i", style);
        StyleConstants.setItalic(style, false);
        doc.insertString(doc.getLength(), " ", style);
      } catch (BadLocationException e1) 
      {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    } 
  }

}
