package gui;

import java.awt.BorderLayout;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Window that allows ShortCuts to be customized.
 * 
 * @author Jacob Susko
 *
 */
public class PrefWindow extends JFrame implements ActionListener
{

  /**
   * Serial ID Number.
   */
  private static final long serialVersionUID = 1L;

  private static final String CTRL = "ctrl-";
  private static final String ALT = "alt-";
  private static final String CTRLALT = "ctrl alt-";
  private static final String Z = "z";
  private static final String DASH = "-";

  private static final String[] CHOICES_CTRL = {CTRL, ALT, CTRLALT};
  private static final String[] CHOICES_ALT = {ALT, CTRLALT, CTRL};
  private static final String[] CHOICES_CTRL_ALT = {CTRLALT, CTRL, ALT};

  private static final String[] ENGLISH_CUTS = {"Exit:", "Print:", "About:", "Set Preferences:",
      "New Window:", "English:", "Spanish:", "French:", "Help Contents:"};

  private static final String[] SPANISH_CUTS = {"Salida:", "Impresión:", "Sobre:",
      "Establecer Preferencias:", "Nueva Ventana:", "Ingles:", "Español:", "Francés:",
      "Contenido de la Ayuda:"};

  private static final String[] FRENCH_CUTS = {"Sortir:", "Imprimer:", "Sur:",
      "Définir les Préférences:", "Nouvelle Fenetre:", "Anglais:", "Espagnol:", "Français:",
      "Contenu de l'aide:"};

  protected Container contentPane;

  // Cuts approved and used/displayed
  private String[] cuts = {"o", "p", "a", "d", "n", "e", "s", "f", "h"};

  private LinkedHashMap<String, JTextField> shortCutKeys;
  private LinkedHashMap<String, JComboBox<String>> shortCutModifier;
  private LinkedHashMap<String, String> fullShortCut;

  private CalculatorWindow window;

  /**
   * Construct the window.
   * 
   * @param window
   *          Calculator window the PrefWindow is for
   */
  public PrefWindow(final CalculatorWindow window)
  {
    super();
    this.setAlwaysOnTop(true);
    shortCutKeys = new LinkedHashMap<String, JTextField>();
    shortCutModifier = new LinkedHashMap<String, JComboBox<String>>();
    fullShortCut = window.getShortCuts();
    // setDefault(); // Adds current cuts into fullShortCut
    this.window = window;
    update();
  }

  protected void update()
  {
    int frameWidth = 500;
    int frameHeight = 450;
    setSize(frameWidth, frameHeight);
    setVisible(true);

    this.contentPane = getContentPane();

    GridLayout layout = new GridLayout(12, 3, 15, 5);

    contentPane.setLayout(layout);
    contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

    setCut(fullShortCut); // adds current shortCuts into cuts

    setInternals();

  }

  private void setCut(final LinkedHashMap<String, String> unChangedMap)
  {
    int i = 0;
    // take the last of the values and add them into Cuts
    for (Map.Entry<String, String> entry : unChangedMap.entrySet())
    {
      String value = entry.getValue();
      String key = value.substring(value.length() - 1, value.length());
      cuts[i] = key;
      i++;
    }
  }

  private JButton addButton(final String text)
  {
    JButton button = new JButton(text);
    // Font boldFont = new Font(Font.BOLD, 20);
    button.setPreferredSize(new Dimension(65, 40));
    button.addActionListener(this);
    return button;
  }

  private void addMenuName(final String menuItem, final String cutKey, final String[] choices)
  {
    // add Name
    JPanel title = new JPanel();
    title.add(new JLabel(menuItem));

    // add drop down
    JPanel drop = new JPanel();
    JComboBox<String> dropDown = new JComboBox<String>(choices);
    drop.add(dropDown);

    // add text field
    JPanel text = new JPanel();
    JTextField field = new JTextField(cutKey);
    field.setColumns(2);
    text.add(field);

    // for grabbing info when apply pressed
    shortCutKeys.put(menuItem, field);
    shortCutModifier.put(menuItem, dropDown);
    contentPane.add(title);
    contentPane.add(drop);
    contentPane.add(text);
  }

  private String getCustomKey(final String menuItem)
  {
    JTextField field = shortCutKeys.get(menuItem);
    String customKey = field.getText();
    return customKey;
  }

  private String getCustomModifier(final String menuItem)
  {
    JComboBox<String> drop = shortCutModifier.get(menuItem);
    String customModifier = (String) drop.getSelectedItem();
    return customModifier;
  }

  private void setInternals()
  {
    // Set Preferences based on Language
    if (window.english)
    {
      JPanel paste = new JPanel();
      paste.add(new JLabel("Paste:"));
      contentPane.add(paste);

      JPanel drop = new JPanel();
      String[] control = {CTRL};
      drop.add(new JComboBox<String>(control));
      contentPane.add(drop);

      JPanel text = new JPanel();
      JTextField field = new JTextField(Z);
      field.setColumns(2);
      field.setEditable(false);
      text.add(field);
      contentPane.add(text);

      // add all editable pref
      int i = 0;
      for (Map.Entry<String, String> entry : fullShortCut.entrySet())
      {
        int dash = entry.getValue().indexOf(DASH);
        String mod = entry.getValue().substring(0, dash + 1);
        if (mod.equals(CTRL))
        {
          addMenuName(ENGLISH_CUTS[i], cuts[i], CHOICES_CTRL);
        }
        else if (mod.equals(ALT))
        {
          addMenuName(ENGLISH_CUTS[i], cuts[i], CHOICES_ALT);
        }
        else if (mod.equals(CTRLALT))
        {
          addMenuName(ENGLISH_CUTS[i], cuts[i], CHOICES_CTRL_ALT);
        }
        i++;
      }

      // Apply button
      JPanel apply = new JPanel();
      apply.setLayout(new BorderLayout());
      apply.add(addButton("Apply"));
      contentPane.add(apply);
    }
    else if (window.french)
    {
      JPanel paste = new JPanel();
      paste.add(new JLabel("Pâte:"));
      contentPane.add(paste);

      JPanel drop = new JPanel();
      String[] control = {CTRL};
      drop.add(new JComboBox<String>(control));
      contentPane.add(drop);

      JPanel text = new JPanel();
      JTextField field = new JTextField(Z);
      field.setColumns(2);
      field.setEditable(false);
      text.add(field);
      contentPane.add(text);

      int i = 0;
      for (Map.Entry<String, String> entry : fullShortCut.entrySet())
      {
        int dash = entry.getValue().indexOf(DASH);
        String mod = entry.getValue().substring(0, dash + 1);
        if (mod.equals(CTRL))
        {
          addMenuName(FRENCH_CUTS[i], cuts[i], CHOICES_CTRL);
        }
        else if (mod.equals(ALT))
        {
          addMenuName(FRENCH_CUTS[i], cuts[i], CHOICES_ALT);
        }
        else if (mod.equals(CTRLALT))
        {
          addMenuName(FRENCH_CUTS[i], cuts[i], CHOICES_CTRL_ALT);
        }
        i++;
      }

      // Apply button
      JPanel apply = new JPanel();
      apply.setLayout(new BorderLayout());
      apply.add(addButton("Appliquer"));
      contentPane.add(apply);

    }
    else if (window.spanish)
    {
      JPanel paste = new JPanel();
      paste.add(new JLabel("Pegar:"));
      contentPane.add(paste);

      JPanel drop = new JPanel();
      String[] control = {CTRL};
      drop.add(new JComboBox<String>(control));
      contentPane.add(drop);

      JPanel text = new JPanel();
      JTextField field = new JTextField(Z);
      field.setColumns(2);
      field.setEditable(false);
      text.add(field);
      contentPane.add(text);

      int i = 0;
      for (Map.Entry<String, String> entry : fullShortCut.entrySet())
      {
        int dash = entry.getValue().indexOf(DASH);
        String mod = entry.getValue().substring(0, dash + 1);
        if (mod.equals(CTRL))
        {
          addMenuName(SPANISH_CUTS[i], cuts[i], CHOICES_CTRL);
        }
        else if (mod.equals(ALT))
        {
          addMenuName(SPANISH_CUTS[i], cuts[i], CHOICES_ALT);
        }
        else if (mod.equals(CTRLALT))
        {
          addMenuName(SPANISH_CUTS[i], cuts[i], CHOICES_CTRL_ALT);
        }
        i++;
      }

      // Apply button
      JPanel apply = new JPanel();
      apply.setLayout(new BorderLayout());
      apply.add(addButton("Aplicar"));
      contentPane.add(apply);
    }
  }

  @Override
  public void actionPerformed(final ActionEvent e)
  {

    // Not allowed; ctrl v, ctrl c, ctrl x, and repeats
    String[] menuUsed = null;
    if (window.english)
    {
      menuUsed = ENGLISH_CUTS;
    }
    else if (window.spanish)
    {
      menuUsed = SPANISH_CUTS;
    }
    else if (window.french)
    {
      menuUsed = FRENCH_CUTS;
    }

    boolean proper = true;

    // Create new hashmap and put inputs in it for testing
    LinkedHashMap<String, String> inputsMap = new LinkedHashMap<>();
    for (int i = 0; i < ENGLISH_CUTS.length; i++)
    {
      String shortCut = getCustomModifier(menuUsed[i]) + getCustomKey(menuUsed[i]);
      String isNull = inputsMap.put(shortCut, menuUsed[i]);

      // if put does not return NULL then there is a repeat shortCut, NULL = no repeat (good)
      if (isNull != null)
      {
        // repeat short cut
        proper = false;
      }
    }

    // proper is already false no need for further testing, keep current value of fullShortCut
    if (proper)
    {
      for (Map.Entry<String, String> entry : inputsMap.entrySet())
      {
        String lower = entry.getKey().toLowerCase();
        inputsMap.put(lower, entry.getValue());
      }
      proper = test(inputsMap);
    }

    // After all testing if proper = true, update fullShortCut to inputsMap, else keep fullShortCut
    if (proper)
    {

      // flip fullShortCut and set it in CalcWindow
      LinkedHashMap<String, String> flipped = new LinkedHashMap<>();
      for (Map.Entry<String, String> entry : inputsMap.entrySet())
      {
        flipped.put(entry.getValue(), entry.getKey());
      }
      window.removeShortCuts(fullShortCut);
      window.setShortCuts(flipped);
      fullShortCut.clear();
      fullShortCut.putAll(inputsMap);
    }
    else
    {
      // open failed window and how to properly format
      @SuppressWarnings("unused")
      FailedWindow fWindow = null;
      fWindow = new FailedWindow(window);
    }

    this.dispose();
    // setVisible(false);
  }

  /**
   * Tests to see if input contains any keys that are equal to ctrl-z, ctrl-x, ctrl-c, ctrl-v, or
   * -anything that is not a letter, and only 1 letter.
   * 
   * @param input
   * @return false if does not pass all tests, true if passing all tests
   */
  private boolean test(final LinkedHashMap<String, String> input)
  {
    boolean answer = true;

    if (input.containsKey("ctrl-z") || input.containsKey("ctrl-x") || input.containsKey("ctrl-c")
        || input.containsKey("ctrl-v"))
    {
      // Map contains invalid inputs
      answer = false;
    }

    // If answer = true, test to make sure short cuts only use one letter and not other keys
    if (answer)
    {
      // Turn keys into an array
      @SuppressWarnings("rawtypes")
      Set keys = input.entrySet();
      Object[] keyCuts = keys.toArray();
      String[] shortCuts = new String[keyCuts.length];

      // Just short cut keys are in shortCuts,
      // And testing to make sure second to last char is '-'
      for (int i = 0; i < shortCuts.length; i++)
      {
        String fullCut = String.valueOf(keyCuts[i]);
        int equalsPlace = fullCut.indexOf("=");
        shortCuts[i] = fullCut.substring(0, equalsPlace);

        String test = shortCuts[i].substring(shortCuts[i].length() - 2, shortCuts[i].length() - 1);
        // testing input to see if more than one key is chosen for shortcut
        if (!test.equals(DASH))
        {
          answer = false;
        }

        test = shortCuts[i].substring(shortCuts[i].length() - 1, shortCuts[i].length());
        if (!Character.isLetter(test.charAt(0)))
        {
          answer = false;
        }
      }

    }

    return answer;
  }

}
