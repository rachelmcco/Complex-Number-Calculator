package gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Window to show if customizing short cuts fails.
 * @author Jacob Susko
 *
 */
public class FailedWindow extends JFrame
{
  /**
   * Serial ID Number.
   */
  private static final long serialVersionUID = 1L;
  private static final String SET = " (ctrl-x, ctrl-c, ctrl-v, ctrl-z)\n";
  private CalculatorWindow window;
  
  /**
   * Construct the window.
   * 
   * @param window
   *          CalculatorWindow failedwindow is used on
   */
  public FailedWindow(final CalculatorWindow window)
  {
    super();
    this.window = window;
    setLayout();
  }
  
  private void setLayout()
  {
    int frameWidth = 0;
    int frameHeight = 175;
    if (window.english)
    {
      frameWidth = 500;
      
    }
    else if (window.spanish)
    {
      frameWidth = 550;
    }
    else if (window.french)
    {
      frameWidth = 575;
    }
    setSize(frameWidth, frameHeight);
    setResizable(false);
    setVisible(true);
    
    Container contentPane = getContentPane();
    
    GridLayout layout = new GridLayout(1, 1, 2, 2);
    contentPane.setLayout(layout);
    
    JPanel title1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel reasons1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel reasonOne1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel reasonTwo1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel reasonThree1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel text = new JPanel(new GridLayout(5, 1));
    
    if (window.english)
    {
      
      JLabel title = new JLabel("Error in Setting New Short Cuts; Old Short Cuts Kept\n");
      Font f = title.getFont();
      title.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
      title1.add(title);
      text.add(title1);
      
      JLabel reasons = new JLabel("Error Could of occured because...\n");
      reasons1.add(reasons);
      text.add(reasons1);
      
      JLabel reasonOne = new JLabel("   - Multiple Short Cuts have same key sequence\n");
      reasonOne1.add(reasonOne);
      text.add(reasonOne1);
      
      JLabel reasonTwo = new JLabel("   - Trying to override Operating System Shortcuts" 
          + SET);
      reasonTwo1.add(reasonTwo);
      text.add(reasonTwo1);
      
      JLabel reasonThree = new JLabel("   - Key is not a letter\n");
      reasonThree1.add(reasonThree);
      text.add(reasonThree1);
    }
    else if (window.spanish)
    {
      JLabel title = new JLabel("Error al configurar nuevos accesos directos; "
          + "Viejos atajos guardados\n");
      Font f = title.getFont();
      title.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
      title1.add(title);
      text.add(title1);
      
      JLabel reasons = new JLabel("El error podría haber ocurrido porque...\n");
      reasons1.add(reasons);
      text.add(reasons1);
     
      JLabel reasonOne = new JLabel("   - Múltiples atajos tienen la misma secuencia de teclas\n");
      reasonOne1.add(reasonOne);
      text.add(reasonOne1);
      
      JLabel reasonTwo = new JLabel("   - Intentar anular los accesos directos "
          + "del sistema operativo" + SET);
      reasonTwo1.add(reasonTwo);
      text.add(reasonTwo1);
      
      JLabel reasonThree = new JLabel("   - La clave no es una letra.\n");
      reasonThree1.add(reasonThree);
      text.add(reasonThree1);
    }
    else if (window.french)
    {
      JLabel title = new JLabel("Erreur lors de la définition de nouveaux raccourcis;"
          + " Vieux raccourcis conservés\n");
      Font f = title.getFont();
      title.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
      title1.add(title);
      text.add(title1);
      
      JLabel reasons = new JLabel("Une erreur a pu se produire car...\n");
      reasons1.add(reasons);
      text.add(reasons1);
     
      JLabel reasonOne = new JLabel("   - Plusieurs raccourcis ont la même séquence de touches\n");
      reasonOne1.add(reasonOne);
      text.add(reasonOne1);
      
      JLabel reasonTwo = new JLabel("   - Essayer de remplacer les raccourcis du "
          + "système d'exploitation" + SET);
      reasonTwo1.add(reasonTwo);
      text.add(reasonTwo1);
      
      JLabel reasonThree = new JLabel("   - La clé n'est pas une lettre\n");
      reasonThree1.add(reasonThree);
      text.add(reasonThree1);
    }
    
    contentPane.add(text);
    
  }
  
}
