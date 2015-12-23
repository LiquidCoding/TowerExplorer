package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JPanel
{
    private GridBagLayout LoginLayout;
    public JButton Login;
    JLabel NewAccountLabel;
    JCheckBox NewAccountBox;
    JLabel UsernameInputLabel;
    JLabel PasswordInputLabel;
    JLabel VerifyPasswordInputLabel;
    //Accepts string variables.
    public JTextField UsernameInput;
    //Accepts string variables and hides the entered text.
    public JPasswordField PasswordInput;
    //Accepts the Password again for verification for new account.
    public JPasswordField VerifyPasswordInput;
    public JButton CreateAccount;
    JButton Exit;
    
    GridBagConstraints c = new GridBagConstraints();
    
    public Login(){
       
        LoginLayout = new GridBagLayout();
        
        //All other panels follow the same basic setup.
        //**********************************************************************
        //Set up the Main Menu panel.
        //Needed for the .setPreferredSize() and sets the dimensions of the panel.
        Dimension LoginDimension = new Dimension(600, 600);
        //Determines what type of bordering the panel has if any.
        this.setBorder(BorderFactory.createLineBorder(Color.lightGray, 5));
        //When .setVisible is true the panel can be seen when in the frame.
        this.setVisible(true);
        //Uses the Dimension set previously to set the width and height of the panel.
        this.setPreferredSize(LoginDimension);
        //Sets the layout format so that the buttons and textboxes can be positioned
        //exactly where they are needed.
        this.setLayout(LoginLayout);
        //Sets the background to transparent.
        this.setOpaque(false);
        //**********************************************************************
        
        ActionListener listener = new ButtonListener();
        
        //Creates the Label for the NewAccountBox CheckBox.
        NewAccountLabel = new JLabel();
        NewAccountLabel.setText("New Account?");
        c.gridx = 9;
        c.gridy = 0;
        c.insets = new Insets(3,3,3,3);
        //Sets the Font,style, and size.
        NewAccountLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
        //Sets the color of the text.
        NewAccountLabel.setForeground(Color.YELLOW);
        this.add(NewAccountLabel, c);
        
        //Creates a checkbox used to determine if the user has an account already.
        NewAccountBox = new JCheckBox();
        c.gridx = 10;
        c.gridy = 0;
        c.insets = new Insets(3,3,3,3);
        NewAccountBox.setSelected(false);
        NewAccountBox.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e){
                if (NewAccountBox.isSelected()){
                    //Login.setVisible(false);
                    Login.setEnabled(false);
                    //CreateAccount.setVisible(true);
                    CreateAccount.setEnabled(true);
                    //VerifyPasswordInputLabel.setVisible(true);
                    VerifyPasswordInputLabel.setEnabled(true);
                    //VerifyPasswordInput.setVisible(true);
                    VerifyPasswordInput.setEnabled(true);
                }
                else if (!NewAccountBox.isSelected()) {
                    //Login.setVisible(true);
                    Login.setEnabled(true);
                    //CreateAccount.setVisible(false);
                    CreateAccount.setEnabled(false);
                    //VerifyPasswordInputLabel.setVisible(false);
                    VerifyPasswordInputLabel.setEnabled(false);
                    //VerifyPasswordInput.setVisible(false);
                    VerifyPasswordInput.setEnabled(false);
                }
            }
        });
        this.add(NewAccountBox, c);
                
        //Sets up a outward border that makes space between the component and others.
        c.insets = new Insets(3,3,3,3);
        
        //Creates the Label for the UsernameInput Textbox.
        UsernameInputLabel = new JLabel();
        UsernameInputLabel.setText("Username:");
        c.gridx = 8;
        c.gridy = 2;
        //Sets the Font, style, and size.
        UsernameInputLabel.setFont( new Font("Bookman Old Style", Font.PLAIN, 20));
        //Sets the color of the text.
        UsernameInputLabel.setForeground(Color.YELLOW);
        this.add(UsernameInputLabel, c);
        
        //Creates the Text Field needed to accept the Username.
        UsernameInput = new JTextField(12);
        /*Sets Username to be displayed as a tool tip when the cursor hovers over
        * for an extended period of time*/
        UsernameInput.setToolTipText("Username");
        //This sets the x and y cooridinates of the Textbox.
        c.gridx = 9;
        c.gridy = 2;
        this.add(UsernameInput, c);
        
        //Creates the Label for the PasswordInput Textbox.
        PasswordInputLabel = new JLabel();
        PasswordInputLabel.setText("Password:");
        c.gridx = 8;
        c.gridy = 4;
        PasswordInputLabel.setFont( new Font("Bookman Old Style", Font.PLAIN, 20));
        PasswordInputLabel.setForeground(Color.YELLOW);
        this.add(PasswordInputLabel, c);
        
        //Creates the Password Text Field needed to accept the Password.
        PasswordInput = new JPasswordField(12);
        /*Sets Username to be displayed as a tool tip when the cursor hovers over
        * for an extended period of time*/
        PasswordInput.setToolTipText("Password");
        //This sets the x and y cooridinates of the Textbox.
        c.gridx = 9;
        c.gridy = 4;
        this.add(PasswordInput, c);
        
//Creates the Label for the PasswordInput Textbox.
        VerifyPasswordInputLabel = new JLabel();
        VerifyPasswordInputLabel.setText("Verify Password:");
        c.gridx = 8;
        c.gridy = 5;
        VerifyPasswordInputLabel.setFont( new Font("Bookman Old Style", Font.PLAIN, 20));
        VerifyPasswordInputLabel.setForeground(Color.YELLOW);
        VerifyPasswordInputLabel.setEnabled(false);
        this.add(VerifyPasswordInputLabel, c);
        
        //Creates the Password Text Field needed to accept the Password.
        VerifyPasswordInput = new JPasswordField(12);
        /*Sets Username to be displayed as a tool tip when the cursor hovers over
        * for an extended period of time*/
        VerifyPasswordInput.setToolTipText("Verify Password");
        //This sets the x and y cooridinates of the Textbox.
        c.gridx = 9;
        c.gridy = 5;
        VerifyPasswordInput.setEnabled(false);
        this.add(VerifyPasswordInput, c); 
        
        
        //Creates the button to login to the game.
        Login = new JButton("Login");
        //Sets Alt+S to a hotkey.
        Login.setMnemonic(KeyEvent.VK_L);
        /*The .setActionCommand sets a string value
         * that will be check by the ButtonListener.*/
        Login.setActionCommand("Login");
        //This sets the x and y coordinates of the upper left corner of the button.
        c.gridx = 8;
        c.gridy = 11;
        c.insets = new Insets(3,3,3,30);
        this.add(Login, c);
        
        //Creates the button to close the system.
        Exit = new JButton("Exit");
        Exit.setMnemonic(KeyEvent.VK_X);
        Exit.setActionCommand("Exit");
        c.gridx = 10;
        c.gridy = 11;
        c.insets = new Insets(3,30,3,3);
        this.add(Exit, c);
        
        //Work on.
        //Creates the button to create an account.
        CreateAccount = new JButton("Create Account");
        CreateAccount.setMnemonic(KeyEvent.VK_C);
        CreateAccount.setActionCommand("Create Account");
        c.gridx = 9;
        c.gridy = 11;
        c.insets = new Insets(3,3,3,3);
        CreateAccount.setEnabled(false);
        this.add(CreateAccount, c);
        
        CreateAccount.addActionListener(listener);
        Exit.addActionListener(listener);
    }
    
    private class ButtonListener implements ActionListener{
     
        @Override
        public void actionPerformed(ActionEvent e) {

            if ("Exit".equals(e.getActionCommand())) {
                System.exit(0);
            }
        }   
    }
}