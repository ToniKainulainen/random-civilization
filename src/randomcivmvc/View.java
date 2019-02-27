package randomcivmvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class View extends JFrame{
    
    private Controller controller;
    private JPanel contentPanel, bContainer;
    private JLabel civilization;
    private JButton draw;
    
    public View() {
        initializeComponents();
    }
    
    private void initializeComponents(){
        setTitle("Random Civ Large Earth Map");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        civilization = new JLabel("Civilization", JLabel.CENTER);
        
        draw = new JButton("Draw");
        bContainer = new JPanel();
        bContainer.add(draw);
        
        contentPanel = new JPanel();
        
        contentPanel.add(civilization);
        contentPanel.add(bContainer);
        contentPanel.setLayout(new GridLayout(2, 1));
        
        draw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.draw();
            }
        });

        setSize(200, 200);
        setContentPane(contentPanel);
        setVisible(true);
    }
    
    public void setText(String civilization) {
        this.civilization.setText(civilization);
    }
    
    public void registerController(Controller controller) {
        this.controller = controller;
    }
}