/* Special thanks to :
 * Original Code:
 * 	1. Oracle Company: http://docs.oracle.com/javase/tutorial/uiswing/examples/components/ComboBoxDemoProject/src/components/ComboBoxDemo.java
 * 	2. Contributors to Great Java Plugin: WindowBuilder 
 *  3. To the great Java Tutorial: http://docs.oracle.com/javase/tutorial/
 *  4. Yet another great Java Tutorial: http://algo.math.ntua.gr/~symvonis/other-material/java_material/JavaTutorial/index.html
 */
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.BoxLayout;

public class Main implements ItemListener {
    JPanel cards; //a panel that uses CardLayout to display admin info.
    final static String ADMIN_PANEL = "Admin Login";
    final static String EMPLOYEE_LOGIN = "Employee login";
    
    public void addComponentToPane(Container pane) {
    	// Use FlowLayout to add component to pane
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = { ADMIN_PANEL, EMPLOYEE_LOGIN };
        JComboBox combobox = new JComboBox(comboBoxItems);
        combobox.setEditable(false);
        combobox.addItemListener(this);
        comboBoxPane.add(combobox);
        
        //Create the "cards".
        JPanel card1 = new JPanel();
        card1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        // TODO : 1. Here add passwordText
        JPasswordField passwordInputer_admin = new JPasswordField("Password",30);
        passwordInputer_admin.setToolTipText("Input Your Password");
        card1.add(passwordInputer_admin);
        
        JPanel card2 = new JPanel();
        card2.setLayout(new BorderLayout(0, 0));
        // TODO : 2. Here add Salesman inputer.
        JTextField nameInputer = new JTextField("Your UserID", 20);
        nameInputer.setToolTipText("Please Enter Your UserID");
        JPasswordField passwordInputer_sale = new JPasswordField("Password",30);
        passwordInputer_sale.setToolTipText("Input Your Password");
        card2.add(nameInputer,BorderLayout.NORTH);
        card2.add(passwordInputer_sale,BorderLayout.SOUTH);

        
        
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, ADMIN_PANEL);
        cards.add(card2, EMPLOYEE_LOGIN);
        
        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }
    
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Storage Manage System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create and set up the content pane.
        Main demo = new Main();
        demo.addComponentToPane(frame.getContentPane());
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        // Set the Look-And-Feel to System-Alike
        try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
/* As required by original coder, below provide the Copyright information.*/
/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 