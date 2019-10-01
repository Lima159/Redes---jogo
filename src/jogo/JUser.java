package jogo;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class JUser extends JFrame{
    JButton pedra = new JButton();
    JButton papel =  new JButton();
    JButton tesoura = new JButton();
    JPanel panel = new JPanel();
    
    public JUser(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 500);
        setVisible(true);
        setTitle("JO KEN PO");
        pedra.setIcon(new ImageIcon("C:\\Users\\vitor\\Downloads\\pedra.png"));
        panel.add(pedra);
        papel.setIcon(new ImageIcon("C:\\Users\\vitor\\Downloads\\papel.png"));
        panel.add(papel);
        tesoura.setIcon(new ImageIcon("C:\\Users\\vitor\\Downloads\\tesoura.png"));
        panel.add(tesoura);
        
        add(panel);
        
        validate();
    }
    public static void main(String args[]){
             JUser gui = new JUser();
//        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        gui.setSize(500, 500);
//        gui.setVisible(true);
//        gui.setTitle("JO KEN PO");
        
        //pedra.setIcon(new ImageIcon("C:\\Users\\vitor\\Downloads\\pedra.png"));
    }
}
