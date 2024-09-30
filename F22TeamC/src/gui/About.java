package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * 
 * About - This About class.
 *
 * @author Rachel McCoy
 * @version 10/27/2022
 * 
 *          This work complies with the JMU Honor Code.
 * 
 */
public class About extends JDialog implements ActionListener
{
  private static final long serialVersionUID = 1L;
  private final boolean english;
  private final boolean spanish;
  private final boolean french;
  private String version = "Version 2022-11 (3)\n\n";
  private String names = "Rachel McCoy, Stephanie Koehler,"
      + "Mark Myers,\nJustin Lacombe and Jacob Susko";

  private String cerrar = "Cerrar";
  private String fermer = "Fermer";
  private String close = "Close";

  /**
   * 
   * About - This About constructor.
   * 
   * @throws IOException
   * @param english
   * @param spanish
   * @param french
   */
  public About(final boolean english, final boolean spanish, final boolean french)
  {
    super();
    this.setAlwaysOnTop(true);
    this.toFront();
    this.spanish = spanish;
    this.french = french;
    if (!(english || spanish || french))
    {
      this.english = true;
    }
    else
    {
      this.english = english;
    }
    setupLayout();
  }

  private void setupLayout()
  {
    Container contentPane = null;
    setSize(460, 250);
    setVisible(true);
    toFront();
    // setFocusableWindowState(true);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    setTitle("About rimpleX");
    contentPane = getContentPane();
    contentPane.setLayout(new BorderLayout());
    // logo
    ImageIcon image = new ImageIcon(getClass().getResource(("/logo.png")));
    JLabel label = new JLabel(image);

    contentPane.add(label, BorderLayout.LINE_START);

    JTextArea text = new JTextArea();

    if (spanish)
    {
      String appendText = "rimpleX Calculadora\n\n";
      text.append(appendText);
      String line1 = "Versión 2022-11 (3)\n\n";
      text.append(line1);

      String line3 = "Este producto incluye software desarrollado por\n" + names;
      text.append(line3);
      text.setLineWrap(true);
    }
    else if (french)
    {
      String appendText = "rimpleX Calculatrice\n\n";
      text.append(appendText);
      String line1 = version;
      text.append(line1);

      String line3 = "Ce produit comprend un logiciel développé par\n" + names;
      text.append(line3);
      text.setLineWrap(true);
    }
    else
    {

      String appendText = "rimpleX Calculator\n\n";
      text.append(appendText);
      String line1 = version;
      text.append(line1);

      String line3 = "This product includes software developed by\n" + names;
      text.append(line3);
      text.setLineWrap(true);
    }

    contentPane.add(text, BorderLayout.CENTER);
    setFocusableWindowState(false);

    JButton b;
    if (spanish)
    {
      b = new JButton(cerrar);
    }
    else if (french)
    {
      b = new JButton(fermer);
    }
    else
    {
      b = new JButton(close);
    }
    contentPane.add(b, BorderLayout.PAGE_END);
    b.addActionListener(this);

  }

  @Override
  public void actionPerformed(final ActionEvent e)
  {
    String ae = e.getActionCommand();

    if (ae.equals(close) || ae.equals(cerrar) || ae.equals(fermer))
    {
      setVisible(false);
    }

  }

  /**
   * 
   * isEnglish - This isEnglish.
   * 
   * @return english.
   */
  public boolean isEnglish()
  {
    return english;
  }
}
