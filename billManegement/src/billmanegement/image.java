/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package billmanegement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
/**
 *
 * @author hp
 */
public class image {
    String pic;
        public  void Image()
        {
            JFrame f = new JFrame();
            
        String fileName = pic;
        ImageIcon icon = new ImageIcon(fileName);
        JLabel label = new JLabel(icon); 
        f.getContentPane().add(new JScrollPane(label)); 
        f.setSize(1000,600);
        f.setResizable(false);
        f.setVisible(true);
        f.pack();
        f.setTitle("Your Contract ");
    }
}
