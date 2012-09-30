package visual;

import java.awt.*;
import javax.swing.*;

public class IFundo extends JPanel {
   
    private Image im = new ImageIcon( this.getClass().getResource("../zimages/fundo02.jpg").getPath() ).getImage();

    public IFundo(){              
        setVisible(true);
        setBackground(Color.white);
        setSize(1200,600);        
    }
    
    @Override
    public void paintComponent ( Graphics g )
    {        
        super.paintComponent ( g );
        int x = ( this.getWidth ( ) - im.getWidth ( null ) ) / 2;
        int y = ( this.getHeight ( ) - im.getHeight ( null ) ) / 2;
        g.drawImage ( im , x , y , this );
    }

}
