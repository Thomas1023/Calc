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
        gbc.gridwidth=4;
        addGB( this, theDisplay, 0, 0 );
        // make the top row
        Panel topRow = new Panel(); 

        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        addGB( topRow, new Button("Put"), 0, 0 );
        gbc.weightx = 0.33;
        addGB( topRow, new Button("what"), 1, 0 );
        gbc.weightx = 1.0;
        addGB( topRow, new Button("ever"), 2, 0 );
        gbc.gridwidth = 4;
        addGB( this, topRow, 0, 1 );
        gbc.weightx = 1.0;  gbc.gridwidth = 1;
        for(int j=0; j<3; j++)
            for(int i=0; i<3; i++)
                addGB( this, new Button( "" + ((2-j)*3+i+1) ), i, j+2 );
        addGB( this, new Button("HI"), 3, 2 );
        addGB( this, new Button("LUC"), 3, 3 );
        addGB( this, new Button("KY"), 3, 4 );
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
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentAdded(ContainerEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentRemoved(ContainerEvent arg0) {
		// TODO Auto-generated method stub
		
	}
  
  
}