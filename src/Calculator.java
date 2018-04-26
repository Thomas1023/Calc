import java.awt.*;
import java.awt.event.*;
public class Calculator extends java.applet.Applet 
                            implements ContainerListener, ActionListener {
    GridBagConstraints gbc = new GridBagConstraints(); {
        gbc.weightx = 1.0;  gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
    }
    TextField theDisplay = new TextField();
    public void init() {
        setFont( new Font("Monospaced", Font.BOLD, 24) );
        addContainerListener( this );
        gbc.gridwidth=4;
        addGB( this, theDisplay, 0, 0 );
        // make the top row
        Panel topRow = new Panel(); 
        topRow.addContainerListener( this );
        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        addGB( topRow, new Button("C"), 0, 0 );
        gbc.weightx = 0.33;
        addGB( topRow, new Button("%"), 1, 0 );
        gbc.weightx = 1.0;
        addGB( topRow, new Button("+"), 2, 0 );
        gbc.gridwidth = 4;
        addGB( this, topRow, 0, 1 );
        gbc.weightx = 1.0;  gbc.gridwidth = 1;
        // make the digits
        for(int j=0; j<3; j++)
            for(int i=0; i<3; i++)
                addGB( this, new Button( "" + ((2-j)*3+i+1) ), i, j+2 );
        // -, x, and divide
        addGB( this, new Button("-"), 3, 2 );
        addGB( this, new Button("x"), 3, 3 );
        addGB( this, new Button("\u00F7"), 3, 4 );
        // make the bottom row
        Panel bottomRow = new Panel(); 
        bottomRow.addContainerListener( this );
        gbc.weightx = 1.0;
        addGB( bottomRow, new Button("0"), 0, 0 );
        gbc.weightx = 0.33;
        addGB( bottomRow, new Button("."), 1, 0 );
        gbc.weightx = 1.0;
        addGB( bottomRow, new Button("="), 2, 0 );
        gbc.gridwidth = 4;
        addGB( this, bottomRow, 0, 5 );
    }
    private void addGB( Container cont, Component comp, int x, int y  ) {
        if ( ! (cont.getLayout() instanceof GridBagLayout) )
            cont.setLayout( new GridBagLayout() );
        gbc.gridx = x;  gbc.gridy = y;
        cont.add( comp, gbc );
    }
    public void componentAdded( ContainerEvent e ) {
        Component comp = e.getChild();
        if ( comp instanceof Button )
            ((Button)comp).addActionListener( this );
    }
    public void componentRemoved( ContainerEvent e ) { }
    public void actionPerformed( ActionEvent e ) {
        if ( e.getActionCommand().equals("C") )
            theDisplay.setText( "" );
        else 
            theDisplay.setText( theDisplay.getText() + e.getActionCommand() );
    }
}