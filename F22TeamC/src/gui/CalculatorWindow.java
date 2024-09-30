package gui;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JWindow;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.Timer;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.Highlighter.Highlight;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 * 
 * CalculatorWindow - This CalculatorWindow class which runs the Gui for.
 *
 * @author Rachel McCoy
 * @version 10/27/2022
 * 
 *          This work complies with the JMU Honor Code.
 *
 */
public class CalculatorWindow extends JFrame implements ActionListener, ComponentListener
{
  private static final long serialVersionUID = 1L;

  protected boolean english;
  protected boolean spanish;
  protected boolean french;

  private ButtonPressed listener;

  // private KeyPressed key;
  private Color grey = new Color(225, 225, 225);
  private Color blue = new Color(153, 204, 255);
  private Color companyColor;// = new Color(128, 0, 32);
  private Color textColor;// = new Color(255, 255, 255);

  private boolean pressed = false;

  private String ar = "Ariel";
  private String polar = "PF";
  private String greater = ">";
  private String less = "<";
  private String ingles = "Ingles";

  private String espanol = "Español";
  private String frances = "Francés";
  private String lenguaje = "Lenguaje";
  private String anglais = "Anglais";
  private String espagnol = "Espagnol";
  private String francais = "Français";
  private String lengue = "Lengue";

  private String englan = "English";
  private String spalan = "Spanish";
  private String frelan = "French";

  private String saldot = "Salida:";
  private String imdot = "Impresión:";
  private String sobdot = "Sobre:";
  private String nuadot = "Nueva Ventana:";
  private String ingdot = "Ingles:";
  private String espdot = "Español:";
  private String fradot = "Francés:";
  private String condot = "Contenido de la Ayuda:";
  private String sordot = "Sortir:";
  private String impdot = "Imprimer:";
  private String surdot = "Sur:";
  private String defdot = "Définir les Préférences:";
  private String noudot = "Nouvelle Fenetre:";
  private String angdot = "Anglais:";
  private String espadot = "Espagnol:";
  private String frandot = "Français:";
  private String contenudot = "Contenu de l'aide:";

  private String expection = "exception";

  private String enter = "=";
  private String minus = "-";
  private String slash = "slash";
  private String multiply = "X";
  private String mult = "*";
  private String plus = "+";
  private String backspace = "back";
  private String decimal = ".";
  private final String paste = "p"; // ctrl z
  private String one = "1";
  private String two = "2";
  private String three = "3";
  private String four = "4";
  private String five = "5";
  private String six = "6";
  private String seven = "7";
  private String eight = "8";
  private String nine = "9";
  private String zero1 = "zero";
  private String rightPara = "right";
  private String leftPara = "left";
  private String italics = "it";
  private String dash = "\\";
  private String comma = ",";

  private String expediente = "Expediente";
  private String salida = "Salida";
  private String nuevaVentana = "Nueva Ventana";
  private String impresion = "Impresión";
  private String ayuda = "Ayuda";
  private String sobre = "Sobre";
  private String contenido = "Contenido de la Ayuda";
  private String lenguage = "Lenguage";
  private String preferencias = "Preferencias";
  private String establecer = "Establecer Preferencias";
  private String establecer2 = "Establecer Preferencias:";
  private String visualizacion = "Visualización";
  private String plano = "Plano complejo";

  private String dossier = "Dossier";
  private String sortir = "Sortir";
  private String nouvelle = "Nouvelle Fenetre";
  private String imprimer = "Imprimer";
  private String aider = "Aider";
  private String sur = "Sur";
  private String contenu = "Contenu de l'Aide";
  private String langue = "Langue";
  private String preferences = "Préférences";
  private String definir = "Définir les Préférences";
  private String visualisation = "Visualisation";
  private String plan = "Plan complexe";

  private String file = "File";
  private String exit1 = "Exit";
  private String newWindow = "New Window";
  private String printa = "Print";
  private String help = "Help";
  private String abouta = "About";
  private String helpCon = "Help Contents";
  private String language = "Language";
  private String pref = "Preferences";
  private String setPreferences = "Set Preferences";
  private String visualization = "Visualization";
  private String complex = "Complex Plane";
  private String exdot = "Exit:";
  private String prdots = "Print:";
  private String adot = "About:";
  private String sps = "Set Preferences:";
  private String nwd = "New Window:";

  private String ed = "English:";
  private String sd = "Spanish:";
  private String fd = "French:";
  private String helcon = "Help Contents:";

  private final String ii = "i";

  private final Font regFont = new Font(ar, Font.PLAIN, 17);
  private final Font ital = new Font(ar, Font.ITALIC, 20);
  private final Font small = new Font(ar, Font.BOLD, 15);
  private final Font litte = new Font(ar, Font.BOLD, 11);

  private PrinterJob pj;
  private JWindow slideWindow;
  private JButton button;
  private JButton buttondef;
  private JButton pF;
  private JButton zero;
  private JButton i;
  private JButton arctan;
  private JButton sin;
  private JButton cos;
  private JButton tan;

  private JScrollPane historyPane;
  private Timer timer;
  private JTextPane historyDisplay;
  private JTextPane display;

  private int x;
  private int y;
  private int frameWidth;
  private int frameHeight;
  private int windowHeight;
  private boolean extended;

  private int to;
  private int from;

  private JMenuBar menuBar;
  private JMenu fileMenu, helpMenu, languageMenu, preferenceMenu, visualizationMenu;
  private JMenuItem exit;
  private JMenuItem newW;
  private JMenuItem complexPlane;
  private JMenuItem print;
  private JMenuItem about;
  private JMenuItem hc;
  private JMenuItem preference;
  private JMenuItem englishLang = null;
  private JMenuItem spanishLang = null;
  private JMenuItem frenchLang = null;

  private SimpleAttributeSet itAttr;
  private SimpleAttributeSet normAttr;

  private LinkedHashMap<String, String> shortCuts;

  /**
   * 
   * CalculatorWindow - This CalculatorWindow constructor.
   * 
   * @throws IOException
   * @param english
   * @param spanish
   * @param french
   */

  public CalculatorWindow(final boolean english, final boolean spanish, final boolean french)
      throws IOException
  {
    super();
    // this.setAlwaysOnTop(true);
    // this.toFront();
    pressed = false;
    this.spanish = spanish;
    this.french = french;
    // if all are false, set default (english) to true
    if (!(english || spanish || french))
    {
      this.english = true;
    }
    else
    {
      this.english = english;
    }
    mainPan();
  }

  private void mainPan() throws IOException
  {

    setupLayout();

  }

  private void setupLayout() throws IOException
  {
    // italI = "\uD835\uDC8A"; // 6 figure out the unicode number
    // this.setResizable(false);
    parseColor();
    Container contentPane;
    frameWidth = 550;
    frameHeight = 480;
    windowHeight = 350;
    setSize(frameWidth, frameHeight);
    setVisible(true);
    // setDefaultCloseOperation(EXIT_ON_CLOSE);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    Container bigPane;
    bigPane = getContentPane();

    contentPane = getContentPane();

    BorderLayout border = new BorderLayout();

    bigPane.setLayout(border);

    GridBagLayout gridLayout = new GridBagLayout();
    contentPane.setLayout(gridLayout);

    // contentPane.setBackground(companyColor);

    GridBagConstraints c = new GridBagConstraints();

    JLabel label = new JLabel();
    try
    {
      ImageIcon image = new ImageIcon(getClass().getResource(("/logo.png")));
      // path.toAbsolutePath().toString();
      // Path path = Paths.get("logo.png");
      // ImageIcon image = new ImageIcon(path.toAbsolutePath().toString());
      label = new JLabel(image);
    }
    catch (NullPointerException npe)
    {

    }

    c.anchor = GridBagConstraints.FIRST_LINE_START;

    c.ipady = 10;
    c.ipadx = 10;

    c.weightx = 0;
    c.weighty = 0;
    c.gridx = 0;
    c.gridy = 0;
    gridLayout.setConstraints(label, c);
    label.setPreferredSize(new Dimension(60, 60));
    contentPane.add(label);

    c.insets = new Insets(10, 0, 0, 0); // top padding
    c.ipady = 30;
    c.ipadx = 450;

    c.weightx = 2;
    c.weighty = 2;
    c.gridx = 0;
    c.gridy = 2;

    c.anchor = GridBagConstraints.CENTER;

    itAttr = new SimpleAttributeSet();
    itAttr.addAttribute(StyleConstants.CharacterConstants.Italic, true);
    normAttr = new SimpleAttributeSet();
    normAttr.addAttribute(StyleConstants.CharacterConstants.Italic, false);

    display = new JTextPane();
    display.setEditable(false);
    // display.addAction("ctrl V", "Paste", () -> textPane.paste());

    display.setFont(regFont);
    SimpleAttributeSet attribs = new SimpleAttributeSet();

    StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_RIGHT);
    StyleConstants.setFontSize(attribs, 17);
    StyleConstants.setFontFamily(attribs, ar);
    StyleConstants.setBackground(attribs, blue);

    display.setParagraphAttributes(attribs, true);
    display.setSelectionColor(blue);
    display.setBorder(BorderFactory.createLineBorder(grey, 2));

    gridLayout.setConstraints(display, c);
    c.ipady = 40;
    c.ipadx = 40;

    c.anchor = GridBagConstraints.CENTER;

    contentPane.add(display);
    c.insets = new Insets(10, 0, 0, 0); // top padding

    c.ipady = 10;
    c.ipadx = 10;
    c.insets = new Insets(10, 0, 0, 0); // top padding

    historyDisplay = new JTextPane();

    LinkedHashMap<String, String> defaultCuts = new LinkedHashMap<>();
    defaultCuts.put(exdot, "ctrl-o");
    defaultCuts.put(prdots, "ctrl-p");
    defaultCuts.put(adot, "ctrl-a");
    defaultCuts.put(sps, "ctrl-d");
    defaultCuts.put(nwd, "ctrl-n");
    defaultCuts.put(ed, "ctrl-e");
    defaultCuts.put(sd, "ctrl-s");
    defaultCuts.put(fd, "ctrl-f");
    defaultCuts.put(helcon, "ctrl-h");
    // defaultCuts.put(compldot, "ctrl-m");
    setShortCuts(defaultCuts);
    addKeys();

    this.listener = new ButtonPressed(display, historyDisplay, this);
    addKeys();

    slideWindow(this, historyDisplay);

    // buttons
    JPanel buttonsFirstRow = new JPanel();
    buttonsFirstRow.setLayout(new FlowLayout());

    c.gridy = 3;
    c.ipadx = 500;

    c.insets = new Insets(0, 0, 0, 0); // top padding

    // row one
    buttonsFirstRow.add(addButton("±", Color.BLUE));
    buttonsFirstRow.add(addButton("C", Color.BLUE));
    buttonsFirstRow.add(addButton("←", Color.BLUE));
    buttonsFirstRow.add(addButton(plus, Color.BLUE));
    buttonsFirstRow.add(addButton("R", Color.BLUE));
    buttonsFirstRow.add(addButton("log", Color.BLUE));

    sin = addButton("sin", Color.BLUE);
    sin.setFont(litte);
    sin.setEnabled(false);

    buttonsFirstRow.add(sin);

    gridLayout.setConstraints(buttonsFirstRow, c);
    contentPane.add(buttonsFirstRow);

    // row two
    JPanel buttonsSecRow = new JPanel();
    buttonsSecRow.setLayout(new FlowLayout());
    c.gridy = 4;
    buttonsSecRow.add(addButton(seven, textColor)).setBackground(companyColor);
    buttonsSecRow.add(addButton(eight, textColor)).setBackground(companyColor);

    buttonsSecRow.add(addButton(nine, textColor)).setBackground(companyColor);

    buttonsSecRow.add(addButton(minus, Color.BLUE));
    buttonsSecRow.add(addButton("Inv", Color.BLUE));
    buttonsSecRow.add(addButton("Conj", Color.BLUE)).setFont(small);

    cos = addButton("cos", Color.BLUE);
    cos.setFont(litte);
    cos.setEnabled(false);

    buttonsSecRow.add(cos);

    gridLayout.setConstraints(buttonsSecRow, c);
    contentPane.add(buttonsSecRow);

    // row three
    c.gridy = 5;
    JPanel buttonsThiRow = new JPanel();
    buttonsThiRow.setLayout(new FlowLayout());
    buttonsThiRow.add(addButton(four, textColor)).setBackground(companyColor);
    buttonsThiRow.add(addButton(five, textColor)).setBackground(companyColor);
    buttonsThiRow.add(addButton(six, textColor)).setBackground(companyColor);
    buttonsThiRow.add(addButton(multiply, Color.BLUE));
    buttonsThiRow.add(addButton("(", Color.BLUE));
    buttonsThiRow.add(addButton("√", Color.BLUE));

    tan = addButton("tan", Color.BLUE);
    tan.setFont(litte);
    tan.setEnabled(false);

    buttonsThiRow.add(tan);

    // buttonsThiRow.setBackground(companyColor);

    gridLayout.setConstraints(buttonsThiRow, c);
    contentPane.add(buttonsThiRow);

    // row four
    c.gridy = 6;
    JPanel buttonsFourRow = new JPanel();
    buttonsFourRow.setLayout(new FlowLayout());
    buttonsFourRow.add(addButton(one, textColor)).setBackground(companyColor);
    buttonsFourRow.add(addButton(two, textColor)).setBackground(companyColor);
    buttonsFourRow.add(addButton(three, textColor)).setBackground(companyColor);
    buttonsFourRow.add(addButton("÷", Color.BLUE));
    buttonsFourRow.add(addButton(")", Color.BLUE));
    buttonsFourRow.add(addButton("^", Color.BLUE));

    arctan = addButton("arctan", Color.BLUE);
    arctan.setFont(litte);

    arctan.setEnabled(false);
    buttonsFourRow.add(arctan);

    // buttonsFourRow.setBackground(companyColor);

    gridLayout.setConstraints(buttonsFourRow, c);
    contentPane.add(buttonsFourRow);

    // row five
    c.gridy = 7;
    JPanel buttonsFiveRow = new JPanel();
    buttonsFiveRow.setLayout(new FlowLayout());

    zero = addButton("0", textColor);
    zero.setPreferredSize(new Dimension(135, 40));
    zero.setBackground(companyColor);
    buttonsFiveRow.add(zero);

    i = addButton(ii, Color.BLACK);
    i.setFont(ital);
    buttonsFiveRow.add(i);
    buttonsFiveRow.add(addButton(enter, Color.BLUE));
    buttonsFiveRow.add(addButton(decimal, Color.BLUE));
    pF = addButton(polar, Color.BLACK);
    pF.setPreferredSize(new Dimension(135, 40));
    buttonsFiveRow.add(pF);

    // buttonsFiveRow.setBackground(companyColor);

    // i.addActionListener(this);
    pF.addActionListener(this);
    gridLayout.setConstraints(buttonsFiveRow, c);
    contentPane.add(buttonsFiveRow);

    tabs();

    this.addComponentListener((ComponentListener) this);

    timer();
    // display.setText(italI + " i");

  }

  private void tabs()
  {
    // file and edit
    menuBar = new JMenuBar();
    // tabs

    if (spanish)
    {
      fileMenu = new JMenu(expediente);
      exit = new JMenuItem(salida);
      newW = new JMenuItem(nuevaVentana);
      print = new JMenuItem(impresion);
      helpMenu = new JMenu(ayuda);
      about = new JMenuItem(sobre);
      hc = new JMenuItem(contenido);
      languageMenu = new JMenu(lenguage);
      preferenceMenu = new JMenu(preferencias);
      preference = new JMenuItem(establecer);
      visualizationMenu = new JMenu(visualizacion);
      complexPlane = new JMenuItem(plano);

    }
    else if (french)
    {
      fileMenu = new JMenu(dossier);
      exit = new JMenuItem(sortir);
      newW = new JMenuItem(nouvelle);
      print = new JMenuItem(imprimer);
      helpMenu = new JMenu(aider);
      about = new JMenuItem(sur);
      hc = new JMenuItem(contenu);
      languageMenu = new JMenu(langue);
      preferenceMenu = new JMenu(preferences);
      preference = new JMenuItem(definir);
      visualizationMenu = new JMenu(visualisation);
      complexPlane = new JMenuItem(plan);

    }
    else
    {
      fileMenu = new JMenu(file);
      exit = new JMenuItem(exit1);
      newW = new JMenuItem(newWindow);
      print = new JMenuItem(printa);
      helpMenu = new JMenu(help);
      about = new JMenuItem(abouta);
      hc = new JMenuItem(helpCon);
      languageMenu = new JMenu(language);
      preferenceMenu = new JMenu(pref);
      preference = new JMenuItem(setPreferences);
      visualizationMenu = new JMenu(visualization);
      complexPlane = new JMenuItem(complex);
    }

    fileMenu.add(exit);
    exit.addActionListener(this);
    print.addActionListener(this);
    newW.addActionListener(this);

    fileMenu.add(print);

    fileMenu.add(newW);

    menuBar.add(fileMenu);

    // HelpMenu = new JMenu("Help");

    // about = new JMenuItem("About");
    helpMenu.add(about);
    helpMenu.add(hc);
    about.addActionListener(this);
    hc.addActionListener(this);

    preferenceMenu.add(preference);
    preference.addActionListener(listener);

    if (spanish)
    {
      englishLang = new JMenuItem(ingles);
      spanishLang = new JMenuItem(espanol);
      frenchLang = new JMenuItem(frances);
      languageMenu = new JMenu(lenguaje);
    }
    else if (french)
    {
      englishLang = new JMenuItem(anglais);
      spanishLang = new JMenuItem(espagnol);
      frenchLang = new JMenuItem(francais);
      languageMenu = new JMenu(lengue);
    }
    else if (english)
    {
      englishLang = new JMenuItem(englan);
      spanishLang = new JMenuItem(spalan);
      frenchLang = new JMenuItem(frelan);
      languageMenu = new JMenu(language);
    }

    menuBar.add(fileMenu);
    menuBar.add(preferenceMenu);
    menuBar.add(helpMenu);

    englishLang.addActionListener(this);
    spanishLang.addActionListener(this);
    frenchLang.addActionListener(this);
    menuBar.add(languageMenu);

    languageMenu.add(englishLang);
    languageMenu.add(spanishLang);
    languageMenu.add(frenchLang);

    visualizationMenu = new JMenu(visualization);
    complexPlane = new JMenuItem(complex);
    // visualizationMenu.add(complexPlane);
    // visualizationMenu.addActionListener(this);

    complexPlane.addActionListener(this);

    // menuBar.add(visualizationMenu);

    setJMenuBar(menuBar);

  }

  /**
   * addButton - This returns a new button.
   * 
   * @param text
   *          - what you want the button to say
   * @param color
   *          - what color you want the button text to be.
   * @return JButton.
   */
  private JButton addButton(final String text, final Color color)
  {
    buttondef = new JButton(text);
    Font boldFont = new Font(ar, Font.BOLD, 20);
    buttondef.setFont(boldFont);
    buttondef.setForeground(color);
    buttondef.setPreferredSize(new Dimension(65, 40));
    buttondef.addActionListener(listener);
    // button.addActionListener(this);
    return buttondef;

  }

  private void timer()
  {
    x = (int) this.getLocation().getX();
    y = (int) this.getLocation().getY();

    to = x + 405;
    from = x + 45;

    timer = new Timer(30, new ActionListener()
    {
      public void actionPerformed(final ActionEvent ae)
      {
        if (!extended)
        {
          to -= 5;
          slideWindow.setSize(to, windowHeight);
          slideWindow.repaint();

          if (to <= from)
          {
            timer.stop();
            to = x + 405;
          }
        }
        else
        {
          from += 5;
          slideWindow.setSize(from, windowHeight);
          slideWindow.repaint();
          if (from >= to)
          {
            timer.stop();
            from = x + 45;
          }
        }
      }
    });

  }

  private void slideWindow(final JFrame frame, final JTextPane hDisplay)
  {
    // Container contentPane;
    SimpleAttributeSet attribsH = new SimpleAttributeSet();

    // StyleConstants.setAlignment(attribsH, StyleConstants.ALIGN_RIGHT);
    StyleConstants.setFontSize(attribsH, 17);
    StyleConstants.setFontFamily(attribsH, ar);
    StyleConstants.setBackground(attribsH, blue);

    hDisplay.setParagraphAttributes(attribsH, true);
    hDisplay.setSelectionColor(blue);
    hDisplay.setBorder(BorderFactory.createLineBorder(grey, 2));
    hDisplay.setCaret(hDisplay.getCaret());

    slideWindow = new JWindow(frame);
    slideWindow.setSize(45, windowHeight);
    slideWindow.setLocation(x + frameWidth, (int) (frameHeight / 5.5));

    hDisplay.setEditable(true);
    slideWindow.setFocusable(true);

    historyPane = new JScrollPane(hDisplay);
    historyPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    historyPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    hDisplay.addCaretListener((CaretListener) new CaretListener()
    {

      @Override
      public void caretUpdate(final CaretEvent e)
      {
        Highlight[] h = hDisplay.getHighlighter().getHighlights();
        int start = 0;
        int end = 0;
        String copyString = "";
        for (int j = 0; j < h.length; j++)
        {
          start = h[j].getStartOffset();
          end = h[j].getEndOffset();
        }
        if (end > 0 && start >= 0)
        {
          try
          {
            copyString = display.getText().substring(start - 1, end - 1);
          }
          catch (StringIndexOutOfBoundsException sioobe)
          {

          }
        }
        StringSelection ssCopy = new StringSelection(copyString);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(ssCopy, ssCopy);
      }
    });

    button = new JButton(greater);

    button.addActionListener(this);

    // slideWindow.setLocationRelativeTo(frame);
    slideWindow.setVisible(true);

    slideWindow.add(button, BorderLayout.EAST);
    slideWindow.add(historyPane, BorderLayout.CENTER);

  }

  @SuppressWarnings("static-access")
  @Override
  public void actionPerformed(final ActionEvent e)
  {
    // boolean visible = pnlTools.isVisible();
    // pnlTools.setVisible(!visible);

    String string = e.getActionCommand();

    /*
     * if (string.equals(ii) { display.setCharacterAttributes(itAttr, true); } else {
     * display.setCharacterAttributes(normAttr, true); }
     */

    if (string.equals(abouta) || string.equals(sobre) || string.equals(sur))
    {
      // this.toBack();
      new About(english, spanish, french);
    }
    else if (string.equals(helpCon))
    {
      try
      {
        // File htmlPage = new File("/Users/steph/Documents/Fall2022/CS345/htmlHelpPages.html");
        // Path path = ResourceCopier.copyResourcesToTemp("fix",
        // "htmlHelpPagesEnglish.html");
        // File htmlPage = new File(path);

        URI uri = new URI("https://rimplexhelppage.w3spaces.com/");
        java.awt.Desktop.getDesktop().browse(uri);// htmlPage.toURI());
      }
      catch (IOException | URISyntaxException e2)
      {
        e2.printStackTrace();
      }
    }

    else if (string.equals(contenu))
    {
      try
      {

        URI     uri     = new URI("https://rimplexhelpfrench.w3spaces.com");

        java.awt.Desktop.getDesktop().browse(uri);// htmlPage.toURI());
        // java.awt.Desktop.getDesktop().browse(htmlPage.toURI());
      }
      catch (IOException | URISyntaxException e2)
      {
        e2.printStackTrace();
      }

    }
    else if (string.equals(contenido))
    {
      try
      {

        URI     uri     = new URI("https://rimplexhelpspanish.w3spaces.com");
        java.awt.Desktop.getDesktop().browse(uri);// htmlPage.toURI());
      }
      catch (IOException | URISyntaxException e2)
      {
        e2.printStackTrace();
      }

    }
    else if (string.equals(exit1) || string.equals(salida) || string.equals(sortir))
    {
      dispose();
    }
    else if (string.equals(newWindow) || string.equals(nuevaVentana) || string.equals(nouvelle))
    {

      try
      {
        new CalculatorWindow(true, false, false);
      }
      catch (IOException e1)
      {
        e1.printStackTrace();
      }
      /*
       * try { setupLayout(); } catch (IOException e1) { e1.printStackTrace(); }
       */
    }

    else if (string.equals(englan) || string.equals(anglais) || string.equals(ingles))
    {

      fileMenu.setText(file);
      exit.setText(exit1);
      newW.setText(newWindow);
      print.setText(printa);
      helpMenu.setText(help);
      about.setText(abouta);
      hc.setText(helpCon);
      languageMenu.setText(language);
      preferenceMenu.setText(pref);
      preference.setText(setPreferences);
      visualizationMenu.setText(visualization);
      complexPlane.setText(complex);
      englishLang.setText(englan);
      spanishLang.setText(spalan);
      frenchLang.setText(frelan);
      languageMenu.setText(language);
      this.english = true;
      this.spanish = false;
      this.french = false;
      // double xAlign = this.getLocation().getX();
      // double yAlign = this.getLocation().getY();
      // dispose();
      // try
      // {
      // CalculatorWindow engWindow = new CalculatorWindow(true, false, false);
      // engWindow.setLocation((int) xAlign, (int) yAlign);
      // }
      // catch (IOException e1)
      // {
      // e1.printStackTrace();
      // }
    }
    else if (string.equals(spalan) || string.equals(espanol) || string.equals(espagnol))
    {
      // double xAlign = this.getLocation().getX();
      // double yAlign = this.getLocation().getY();
      fileMenu.setText(expediente);
      exit.setText(salida);
      newW.setText(nuevaVentana);
      print.setText(impresion);
      helpMenu.setText(ayuda);
      about.setText(sobre);
      hc.setText(contenido);
      languageMenu.setText(lenguage);
      preferenceMenu.setText(preferencias);
      preference.setText(establecer);
      visualizationMenu.setText(visualizacion);
      complexPlane.setText(plano);
      englishLang.setText(ingles);
      spanishLang.setText(espanol);
      frenchLang.setText(frances);
      languageMenu.setText(lenguaje);
      this.english = false;
      this.spanish = true;
      this.french = false;
      // dispose();
      // try
      // {
      // CalculatorWindow spanWindow = new CalculatorWindow(false, true, false);
      // spanWindow.setLocation((int) xAlign, (int) yAlign);
      // }
      // catch (IOException e1)
      // {
      // e1.printStackTrace();
      // }
    }
    else if (string.equals(frelan) || string.equals(frances) || string.equals(francais))
    {
      fileMenu.setText(dossier);
      exit.setText(sortir);
      newW.setText(nouvelle);
      print.setText(imprimer);
      helpMenu.setText(aider);
      about.setText(sur);
      hc.setText(contenu);
      languageMenu.setText(langue);
      preferenceMenu.setText(preferences);
      preference.setText(definir);
      visualizationMenu.setText(visualisation);
      complexPlane.setText(plan);
      englishLang.setText(anglais);
      spanishLang.setText(espagnol);
      frenchLang.setText(francais);
      languageMenu.setText(lengue);
      this.english = false;
      this.spanish = false;
      this.french = true;
      // double xAlign = this.getLocation().getX();
      // double yAlign = this.getLocation().getY();
      // dispose();
      // try
      // {
      // CalculatorWindow frenchWindow = new CalculatorWindow(false, false, true);
      // frenchWindow.setLocation((int) xAlign, (int) yAlign);
      // }
      // catch (IOException e1)
      // {
      // e1.printStackTrace();
      // }
    }
    else if (string.equals(greater))
    {
      timer.start();
      button.setText(less);
      extended = true;
      // write method call to display the history

    }
    else if (string.equals(less))
    {
      button.setText(greater);
      timer.start();
      button.setText(greater);
      extended = false;
    }
    else if (string.equals(printa) || string.equals(imprimer) || string.equals(impresion))
    {
      pj = PrinterJob.getPrinterJob();
      if (pj.printDialog())
      {
        try
        {
          historyDisplay.print();
          // pj.print();
        }
        catch (PrinterException exc)
        {
        }
      }
    }

    else if (string.equals(polar))
    {
      if (!pressed)
      {
        pF.setBackground(companyColor);
        pF.setForeground(textColor);
        pressed = true;
        tan.setEnabled(true);
        sin.setEnabled(true);
        cos.setEnabled(true);
        arctan.setEnabled(true);

      }
      else
      {
        pF.setBackground(grey);
        pF.setForeground(Color.BLACK);
        pressed = false;
        tan.setEnabled(false);
        sin.setEnabled(false);
        cos.setEnabled(false);
        arctan.setEnabled(false);
      }
    }
    // else if (string.equals(complex) || string.equals(plano) || string.equals(plan))
    // {
    //
    // // ArrayList<ComplexNumber> points = new ArrayList<>();
    // // FunctionGraph.drawPoints(points);
    // if (display.getToolTipText() != null && display.getToolTipText().equals(decimal))
    // {
    // display.setToolTipText("");
    // ButtonsAndKeyActions.graph.frame.dispose();
    // ButtonsAndKeyActions.visualize = false;
    // }
    // else
    // {
    // ButtonsAndKeyActions.drawPoints(null);
    // ButtonsAndKeyActions.graph = null;
    // display.setToolTipText(decimal);
    // }
    // }
    /*
     * display.setCharacterAttributes(normAttr, true); }
     */

  }

  @Override
  public void componentResized(final ComponentEvent e)
  {
    x = (int) this.getLocation().getX();
    y = (int) this.getLocation().getY();
    Dimension d = this.getSize();
    frameWidth = d.width;
    frameHeight = d.height;
    // windowWidth = frameWidth / 10;
    windowHeight = frameHeight * 7 / 11;
    if (extended)
    {
      slideWindow.setSize(450, windowHeight);
    }
    else
    {
      slideWindow.setSize(45, windowHeight);
    }
    slideWindow.setLocation(x + frameWidth, y + (int) (frameHeight / 5.5));
  }

  @Override
  public void componentMoved(final ComponentEvent e)
  {
    x = (int) this.getLocation().getX();
    y = (int) this.getLocation().getY();
    Dimension d = this.getSize();
    frameWidth = d.width;
    frameHeight = d.height;
    slideWindow.setLocation(x + frameWidth, y + (int) (frameHeight / 5.5));
  }

  @Override
  public void componentShown(final ComponentEvent e)
  {
    // slideWindow.toBack();

  }

  @Override
  public void componentHidden(final ComponentEvent e)
  {
    // slideWindow.toBack();
  }

  protected LinkedHashMap<String, String> getShortCuts()
  {
    return this.shortCuts;
  }

  protected void removeShortCuts(final LinkedHashMap<String, String> map)
  {
    shortCuts = map;
    String exitCut = null;
    String printCut = null;
    String aboutCut = null;
    String setPCut = null;
    String newWCut = null;
    String englishCut = null;
    String spanishCut = null;
    String frenchCut = null;
    String helpCCut = null;
    // String comPCut = null;

    exitCut = shortCuts.get(exdot);
    printCut = shortCuts.get(prdots);
    aboutCut = shortCuts.get(adot);
    setPCut = shortCuts.get(sps);
    newWCut = shortCuts.get(nwd);
    englishCut = shortCuts.get(ed);
    spanishCut = shortCuts.get(sd);
    frenchCut = shortCuts.get(fd);
    helpCCut = shortCuts.get(helcon);
    // comPCut = shortCuts.get(compldot);

    if (exitCut == null)
    {
      exitCut = shortCuts.get(saldot);
      printCut = shortCuts.get(imdot);
      aboutCut = shortCuts.get(sobdot);
      setPCut = shortCuts.get(establecer2);
      newWCut = shortCuts.get(nuadot);
      englishCut = shortCuts.get(ingdot);
      spanishCut = shortCuts.get(espdot);
      frenchCut = shortCuts.get(fradot);
      helpCCut = shortCuts.get(condot);
      // comPCut = shortCuts.get(plandot);
    }
    if (printCut == null)
    {
      exitCut = shortCuts.get(sordot);
      printCut = shortCuts.get(impdot);
      aboutCut = shortCuts.get(surdot);
      setPCut = shortCuts.get(defdot);
      newWCut = shortCuts.get(noudot);
      englishCut = shortCuts.get(angdot);
      spanishCut = shortCuts.get(espadot);
      frenchCut = shortCuts.get(frandot);
      helpCCut = shortCuts.get(contenudot);
      // comPCut = shortCuts.get(pladot);
    }

    int exitMod = getMod(exitCut);
    int exitKey = getKey(exitCut);

    int printMod = getMod(printCut);
    int printKey = getKey(printCut);

    int aboutMod = getMod(aboutCut);
    int aboutKey = getKey(aboutCut);

    int setPMod = getMod(setPCut);
    int setPKey = getKey(setPCut);

    int newWMod = getMod(newWCut);
    int newWKey = getKey(newWCut);

    int englishMod = getMod(englishCut);
    int englishKey = getKey(englishCut);

    int spanishMod = getMod(spanishCut);
    int spanishKey = getKey(spanishCut);

    int frenchMod = getMod(frenchCut);
    int frenchKey = getKey(frenchCut);

    int helpCMod = getMod(helpCCut);
    int helpCKey = getKey(helpCCut);

    // int comPMod = getMod(comPCut);
    // int comPKey = getKey(comPCut);

    // Exit Menu Item
    display.getInputMap().put(KeyStroke.getKeyStroke(exitKey, exitMod, false), null);

    // Print Menu Item
    display.getInputMap().put(KeyStroke.getKeyStroke(printKey, printMod, false), null);

    // About Menu Item
    display.getInputMap().put(KeyStroke.getKeyStroke(aboutKey, aboutMod, false), null);

    // Set Preferences Menu Item
    display.getInputMap().put(KeyStroke.getKeyStroke(setPKey, setPMod, false), null);

    // New Window Menu Item
    display.getInputMap().put(KeyStroke.getKeyStroke(newWKey, newWMod, false), null);

    // English Menu Item
    display.getInputMap().put(KeyStroke.getKeyStroke(englishKey, englishMod, false), null);

    // Spanish Menu Item
    display.getInputMap().put(KeyStroke.getKeyStroke(spanishKey, spanishMod, false), null);

    // French Menu Item
    display.getInputMap().put(KeyStroke.getKeyStroke(frenchKey, frenchMod, false), null);

    // Help Contents Menu Item
    display.getInputMap().put(KeyStroke.getKeyStroke(helpCKey, helpCMod, false), null);

    // // Complex Plane Menu Item
    // display.getInputMap().put(KeyStroke.getKeyStroke(comPKey, comPMod, false), null);
  }

  protected void setShortCuts(final LinkedHashMap<String, String> map)
  {
    shortCuts = map;
    String exitCut = null;
    String printCut = null;
    String aboutCut = null;
    String setPCut = null;
    String newWCut = null;
    String englishCut = null;
    String spanishCut = null;
    String frenchCut = null;
    String helpCCut = null;
    // String comPCut = null;

    if (english)
    {
      exitCut = shortCuts.get(exdot);
      printCut = shortCuts.get(prdots);
      aboutCut = shortCuts.get(adot);
      setPCut = shortCuts.get(sps);
      newWCut = shortCuts.get(nwd);
      englishCut = shortCuts.get(ed);
      spanishCut = shortCuts.get(sd);
      frenchCut = shortCuts.get(fd);
      helpCCut = shortCuts.get(helcon);
      // comPCut = shortCuts.get(compldot);
    }
    if (spanish)
    {
      exitCut = shortCuts.get(saldot);
      printCut = shortCuts.get(imdot);
      aboutCut = shortCuts.get(sobdot);
      setPCut = shortCuts.get(establecer2); // is returning null
      newWCut = shortCuts.get(nuadot);
      englishCut = shortCuts.get(ingdot);
      spanishCut = shortCuts.get(espdot);
      frenchCut = shortCuts.get(fradot);
      helpCCut = shortCuts.get(condot);
      // comPCut = shortCuts.get(plano + ":");
    }
    else if (french)
    {
      exitCut = shortCuts.get(sordot);
      printCut = shortCuts.get(impdot);
      aboutCut = shortCuts.get(surdot);
      setPCut = shortCuts.get(defdot);
      newWCut = shortCuts.get(noudot);
      englishCut = shortCuts.get(angdot);
      spanishCut = shortCuts.get(espadot);
      frenchCut = shortCuts.get(frandot);
      helpCCut = shortCuts.get(contenudot);
      // comPCut = shortCuts.get(pladot);
    }

    int exitMod = getMod(exitCut);
    int exitKey = getKey(exitCut);

    int printMod = getMod(printCut);
    int printKey = getKey(printCut);

    int aboutMod = getMod(aboutCut);
    int aboutKey = getKey(aboutCut);

    int setPMod = getMod(setPCut);
    int setPKey = getKey(setPCut);

    int newWMod = getMod(newWCut);
    int newWKey = getKey(newWCut);

    int englishMod = getMod(englishCut);
    int englishKey = getKey(englishCut);

    int spanishMod = getMod(spanishCut);
    int spanishKey = getKey(spanishCut);

    int frenchMod = getMod(frenchCut);
    int frenchKey = getKey(frenchCut);

    int helpCMod = getMod(helpCCut);
    int helpCKey = getKey(helpCCut);

    // int comPMod = getMod(comPCut);
    // int comPKey = getKey(comPCut);

    EnglishAction ea = new EnglishAction(this);
    ExitAction xa = new ExitAction(this);
    FrenchAction fa = new FrenchAction(this);
    HelpCAction hca = new HelpCAction(this);
    NewWAction nwa = new NewWAction(this);
    PrintAction pa = new PrintAction(this);
    SetPAction spa = new SetPAction(listener);
    SpanishAction sa = new SpanishAction(this);
    AboutAction aa = new AboutAction(this);
    // ComPAction cpa = new ComPAction(this);

    // Exit Menu Item
    display.getInputMap().put(KeyStroke.getKeyStroke(exitKey, exitMod, false), exitCut);
    display.getActionMap().put(exitCut, xa);

    // Print Menu Item
    display.getInputMap().put(KeyStroke.getKeyStroke(printKey, printMod, false), printCut);
    display.getActionMap().put(printCut, pa);

    // About Menu Item
    display.getInputMap().put(KeyStroke.getKeyStroke(aboutKey, aboutMod, false), aboutCut);
    display.getActionMap().put(aboutCut, aa);

    // Set Preferences Menu Item
    display.getInputMap().put(KeyStroke.getKeyStroke(setPKey, setPMod, false), setPCut);
    display.getActionMap().put(setPCut, spa);

    // New Window Menu Item
    display.getInputMap().put(KeyStroke.getKeyStroke(newWKey, newWMod, false), newWCut);
    display.getActionMap().put(newWCut, nwa);

    // English Menu Item
    display.getInputMap().put(KeyStroke.getKeyStroke(englishKey, englishMod, false), englishCut);
    display.getActionMap().put(englishCut, ea);

    // Spanish Menu Item
    display.getInputMap().put(KeyStroke.getKeyStroke(spanishKey, spanishMod, false), spanishCut);
    display.getActionMap().put(spanishCut, sa);

    // French Menu Item
    display.getInputMap().put(KeyStroke.getKeyStroke(frenchKey, frenchMod, false), frenchCut);
    display.getActionMap().put(frenchCut, fa);

    // Help Contents Menu Item
    display.getInputMap().put(KeyStroke.getKeyStroke(helpCKey, helpCMod, false), helpCCut);
    display.getActionMap().put(helpCCut, hca);

    // // Complex Plane Menu Item
    // display.getInputMap().put(KeyStroke.getKeyStroke(comPKey, comPMod, false), comPCut);
    // display.getActionMap().put(comPCut, cpa);

  }

  private int getKey(final String shortCut)
  {
    int key = 0;
    int dash2 = shortCut.indexOf(minus);
    String keyPress = shortCut.substring(dash2 + 1, shortCut.length());

    switch (keyPress)
    {
      case "a":
        key = KeyEvent.VK_A;
        break;
      case "b":
        key = KeyEvent.VK_B;
        break;
      case "c":
        key = KeyEvent.VK_C;
        break;
      case "d":
        key = KeyEvent.VK_D;
        break;
      case "e":
        key = KeyEvent.VK_D;
        break;
      case "f":
        key = KeyEvent.VK_D;
        break;
      case "g":
        key = KeyEvent.VK_G;
        break;
      case "h":
        key = KeyEvent.VK_H;
        break;
      case ii:
        key = KeyEvent.VK_I;
        break;
      case "j":
        key = KeyEvent.VK_J;
        break;
      case "k":
        key = KeyEvent.VK_K;
        break;
      case "l":
        key = KeyEvent.VK_L;
        break;
      case "m":
        key = KeyEvent.VK_M;
        break;
      case "n":
        key = KeyEvent.VK_N;
        break;
      case "o":
        key = KeyEvent.VK_O;
        break;
      case paste:
        key = KeyEvent.VK_P;
        break;
      case "q":
        key = KeyEvent.VK_Q;
        break;
      case "r":
        key = KeyEvent.VK_R;
        break;
      case "s":
        key = KeyEvent.VK_S;
        break;
      case "t":
        key = KeyEvent.VK_T;
        break;
      case "u":
        key = KeyEvent.VK_U;
        break;
      case "v":
        key = KeyEvent.VK_V;
        break;
      case "w":
        key = KeyEvent.VK_W;
        break;
      case "x":
        key = KeyEvent.VK_X;
        break;
      case "y":
        key = KeyEvent.VK_Y;
        break;
      case "z":
        key = KeyEvent.VK_Z;
        break;
      default:
        break;
    }
    return key;
  }

  private int getMod(final String shortCut)
  {
    int mod = 0;
    int dash1 = shortCut.indexOf(minus);
    String modifier = shortCut.substring(0, dash1);

    switch (modifier)
    {
      case "ctrl":
        mod = InputEvent.CTRL_DOWN_MASK;
        break;

      case "alt":
        mod = InputEvent.ALT_DOWN_MASK;
        break;

      case "ctrl alt":
        // ask about how to set modifier for this situation
        mod = InputEvent.ALT_DOWN_MASK | InputEvent.CTRL_DOWN_MASK;
        break;

      default:
        break;
    }
    return mod;
  }

  private void addKeys()
  {

    // Action Listener for Paste
    EditAction editAction = new EditAction(display);

    // ( working for ( button
    display.getInputMap()
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_9, KeyEvent.SHIFT_DOWN_MASK, false), rightPara);
    display.getActionMap().put(rightPara, listener);

    // ) working for ) button
    display.getInputMap()
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_0, KeyEvent.SHIFT_DOWN_MASK, false), leftPara);
    display.getActionMap().put(leftPara, listener);

    // i working for i button
    display.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_I, 0, false), italics);
    display.getInputMap(JComponent.WHEN_FOCUSED)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_I, 0, false), italics);
    display.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_I, 0, false), italics);
    display.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_I, 0, false), italics);
    display.getActionMap().put(italics, listener);

    // Enter Key working for =
    display.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), enter);
    display.getInputMap(JComponent.WHEN_FOCUSED)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), enter);
    display.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), enter);
    display.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), enter);
    display.getActionMap().put(enter, listener);

    // - Key working for - button
    display.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0, false), minus);
    display.getInputMap(JComponent.WHEN_FOCUSED)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0, false), minus);
    display.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0, false), minus);
    display.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0, false), minus);
    display.getActionMap().put(minus, listener);

    // / key working for division
    display.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_SLASH, 0, false), slash);
    display.getInputMap(JComponent.WHEN_FOCUSED)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_SLASH, 0, false), slash);
    display.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_SLASH, 0, false), slash);
    display.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_SLASH, 0, false), slash);
    display.getActionMap().put(slash, listener);

    // * key working for multiplication
    display.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_X, 0, false), multiply);
    display.getInputMap(JComponent.WHEN_FOCUSED)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_X, 0, false), multiply);
    display.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_X, 0, false), multiply);
    display.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_X, 0, false), multiply);
    display.getActionMap().put(multiply, listener);

    display.getInputMap()
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_8, KeyEvent.SHIFT_DOWN_MASK, false), mult);
    display.getInputMap(JComponent.WHEN_FOCUSED)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_8, KeyEvent.SHIFT_DOWN_MASK, false), mult);
    display.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_8, KeyEvent.SHIFT_DOWN_MASK, false), mult);
    display.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_8, KeyEvent.SHIFT_DOWN_MASK, false), mult);
    display.getActionMap().put(mult, listener);

    // + key working for addition
    display.getInputMap()
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, KeyEvent.SHIFT_DOWN_MASK, false), plus);
    display.getInputMap(JComponent.WHEN_FOCUSED)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, KeyEvent.SHIFT_DOWN_MASK, false), plus);
    display.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, KeyEvent.SHIFT_DOWN_MASK, false), plus);
    display.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, KeyEvent.SHIFT_DOWN_MASK, false), plus);
    display.getActionMap().put(plus, listener);

    // backspace key working for backspace button
    display.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0, false), backspace);
    display.getInputMap(JComponent.WHEN_FOCUSED)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0, false), backspace);
    display.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0, false), backspace);
    display.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0, false), backspace);
    display.getActionMap().put(backspace, listener);

    // Paste contents
    display.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK, false), paste);
    display.getActionMap().put(paste, editAction);

    // . key working for decimal button
    display.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_PERIOD, 0, false), decimal);
    display.getInputMap(JComponent.WHEN_FOCUSED)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_PERIOD, 0, false), decimal);
    display.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_PERIOD, 0, false), decimal);
    display.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_PERIOD, 0, false), decimal);
    display.getActionMap().put(decimal, listener);

    // number key working for number buttons

    // 1
    display.getInputMap(JComponent.WHEN_FOCUSED)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_1, 0, false), one);
    display.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_1, 0, false), one);
    display.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_1, 0, false), one);
    display.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_1, 0, false), one);
    display.getActionMap().put(one, listener);

    // 2
    display.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_2, 0, false), two);
    display.getInputMap(JComponent.WHEN_FOCUSED)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_2, 0, false), two);
    display.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_2, 0, false), two);
    display.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_2, 0, false), two);
    display.getActionMap().put(two, listener);

    // 3
    display.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_3, 0, false), three);
    display.getInputMap(JComponent.WHEN_FOCUSED)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_3, 0, false), three);
    display.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_3, 0, false), three);
    display.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_3, 0, false), three);
    display.getActionMap().put(three, listener);

    // 4
    display.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_4, 0, false), four);
    display.getInputMap(JComponent.WHEN_FOCUSED)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_4, 0, false), four);
    display.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_4, 0, false), four);
    display.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_4, 0, false), four);
    display.getActionMap().put(four, listener);

    // 5
    display.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_5, 0, false), five);
    display.getInputMap(JComponent.WHEN_FOCUSED)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_5, 0, false), five);
    display.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_5, 0, false), five);
    display.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_5, 0, false), five);
    display.getActionMap().put(five, listener);

    // 6
    display.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_6, 0, false), six);
    display.getInputMap(JComponent.WHEN_FOCUSED)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_6, 0, false), six);
    display.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_6, 0, false), six);
    display.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_6, 0, false), six);
    display.getActionMap().put(six, listener);

    // 7
    display.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_7, 0, false), seven);
    display.getInputMap(JComponent.WHEN_FOCUSED)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_7, 0, false), seven);
    display.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_7, 0, false), seven);
    display.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_7, 0, false), seven);
    display.getActionMap().put(seven, listener);

    // 8
    display.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_8, 0, false), eight);
    display.getInputMap(JComponent.WHEN_FOCUSED)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_8, 0, false), eight);
    display.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_8, 0, false), eight);
    display.getActionMap().put(eight, listener);

    // 9
    display.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_9, 0, false), nine);
    display.getInputMap(JComponent.WHEN_FOCUSED)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_9, 0, false), nine);
    display.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_9, 0, false), nine);
    display.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_8, 0, false), eight);
    display.getActionMap().put(nine, listener);

    // 0
    display.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_0, 0, false), zero1);
    display.getInputMap(JComponent.WHEN_FOCUSED)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_0, 0, false), zero1);
    display.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_0, 0, false), zero1);
    display.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_0, 0, false), zero1);
    display.getActionMap().put(zero1, listener);

  }

  /**
   * 
   * 
   * @return
   * @throws IOException
   */

  public void parseColor() throws IOException
  {
    String os = System.getProperty("os.name");
    String currentDir;
    Path path = Paths.get("color.txt");
    if (os.contains("Windows"))
    {
      currentDir = path.toAbsolutePath().toString();
      currentDir = currentDir.replace(dash, dash + dash);
    }
    else
    {
      currentDir = path.toAbsolutePath().toString().replace(dash, "/");
    }

    // }
    try (InputStream in = getClass().getResourceAsStream("/color.txt");)
    {

      Scanner scan = new Scanner(in);
      scan.useDelimiter(comma);
      String line;
      int rgbRed = 0;
      int rgbGreen = 0;
      int rgbBlue = 0;
      for (int j = 0; j < 2; j++)
      {
        line = scan.nextLine();
        if (line.equals(""))
        {
          break;
        }
        rgbRed = Integer.parseInt(line.substring(0, line.indexOf(comma)));
        if (rgbRed < 0)
        {
          rgbRed = 0;
        }
        else if (rgbRed > 255)
        {
          rgbRed = 255;
        }
        // System.out.println(rgbRed);
        rgbGreen = Integer
            .parseInt(line.substring(line.indexOf(comma) + 1, line.lastIndexOf(comma)));
        if (rgbGreen < 0)
        {
          rgbGreen = 0;
        }
        else if (rgbGreen > 255)
        {
          rgbGreen = 255;
        }
        // System.out.println(rgbGreen);
        rgbBlue = Integer.parseInt(line.substring(line.lastIndexOf(comma) + 1, line.length()));
        if (rgbBlue < 0)
        {
          rgbBlue = 0;
        }
        else if (rgbBlue > 255)
        {
          rgbBlue = 255;
        }
        // System.out.println(rgbBlue);
        if (j == 0)
        {
          this.companyColor = new Color(rgbRed, rgbGreen, rgbBlue);
        }
        else
        {
          this.textColor = new Color(rgbRed, rgbGreen, rgbBlue);
        }
      }
      scan.close();
    }
    catch (NullPointerException npe)
    {
      // this.companyColor = new Color(108, 0, 25);
      this.companyColor = new Color(255, 255, 255);
      this.textColor = new Color(0, 0, 0);
    }

  }

}
