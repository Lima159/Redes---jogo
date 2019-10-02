package jogo;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class JUser extends JFrame{
    JButton pedra = new JButton();
    JButton papel =  new JButton();
    JButton tesoura = new JButton();
    JPanel panel = new JPanel();
    //Usuario user = new Usuario();
    
    public JUser(){
        pedra.setIcon(new ImageIcon("C:\\Users\\ifba2\\OneDrive\\Área de Trabalho\\Redes---jogo-master\\src\\imagens\\pedra.png"));
        panel.add(pedra);
        papel.setIcon(new ImageIcon("C:\\Users\\ifba2\\OneDrive\\Área de Trabalho\\Redes---jogo-master\\src\\imagens\\papel.png"));
        panel.add(papel);
        tesoura.setIcon(new ImageIcon("C:\\Users\\ifba2\\OneDrive\\Área de Trabalho\\Redes---jogo-master\\src\\imagens\\tesoura.png"));
        panel.add(tesoura);
        add(panel);
        
        pedra.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOptionPane.showMessageDialog(pedra, "PEDRA ESCOLHIDA");
            }
        });
        
        papel.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOptionPane.showMessageDialog(papel, "PAPEL ESCOLHIDO");
            }
        });
        
        tesoura.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOptionPane.showMessageDialog(tesoura, "TESOURA ESCOLHIDA");
            }
        });
         
        validate();
    }
    
    public static void main(String args[]){
        JUser gui = new JUser();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(900, 450);
        gui.setVisible(true);
        gui.setTitle("JO KEN PO");
    }
}