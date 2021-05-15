package view;

import presenter.Presenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginPage extends JFrame {
    Presenter presenter = new Presenter(this);
    Container container = getContentPane();

    ImageIcon mainIcon = new ImageIcon("images\\up103.png");
    JLabel imageLabel = new JLabel("", mainIcon, SwingConstants.CENTER);

    JLabel userLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JCheckBox showPassword = new JCheckBox("Show Password");

    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");

    JLabel signUpLabel = new JLabel("Don’t have an account?");
    JButton createAccountButton = new JButton("Create account");


    public LoginPage() {
        setVisible(true);
        setBounds(0, 0, 380, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        container.setLayout(null);
        setLocationAndSize();
        setStyle();
        addComponentsToContainer();
        addActionEvent();

    }

    private void addActionEvent() {
        userTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    passwordField.grabFocus();
                }
            }
        });

        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    loginButton.doClick();
                }
            }
        });

        loginButton.addActionListener(e -> {
            String[] fields = {userTextField.getText(), String.valueOf(passwordField.getPassword())};
            presenter.onLoginBtnClick(fields);
        });

        resetButton.addActionListener(e -> {
            userTextField.setText("");
            passwordField.setText("");
        });

        showPassword.addActionListener(e -> {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        });
        createAccountButton.addActionListener(e -> presenter.onCreateAccountBtnClick());
    }

    private void setLocationAndSize() {
        imageLabel.setBounds(138, 20, 103, 103);

        userLabel.setBounds(50, 150, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);

        passwordLabel.setBounds(50, 220, 100, 30);
        passwordField.setBounds(150, 220, 150, 30);

        showPassword.setBounds(150, 250, 150, 30);

        resetButton.setBounds(50, 300, 100, 30);
        loginButton.setBounds(200, 300, 100, 30);

        signUpLabel.setBounds(50, 370, 250, 20);
        createAccountButton.setBounds(50, 400, 250, 30);
    }

    private void setStyle() {
        passwordField.setEchoChar('*');
        signUpLabel.setFont(signUpLabel.getFont().deriveFont(Font.ITALIC));
        createAccountButton.setContentAreaFilled(false);
    }

    private void addComponentsToContainer() {
        container.add(imageLabel);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(signUpLabel);
        container.add(createAccountButton);
    }
}
