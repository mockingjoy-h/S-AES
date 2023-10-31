import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SAESUI extends JFrame {
    private JTextField plaintextField;
    private JTextField keyField;
    private JTextField ciphertextField;
    private JTextField decryptedField;
    
    public SAESUI() {
        setTitle("SAES加解密");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        JRadioButton one = new JRadioButton("单重加密");
        JRadioButton two = new JRadioButton("双重加密");
        JRadioButton three = new JRadioButton("三重加密");
        ButtonGroup keys = new ButtonGroup();
        keys.add(one);
        keys.add(two);
        keys.add(three);
        add(one,gbc);
        gbc.gridx = 1;
        add(two,gbc);
        gbc.gridx = 2;
        add(three,gbc);
    
        gbc.gridx = 0; 
        gbc.gridy = 1;
        add(new JLabel("明文:"), gbc);
        
        gbc.gridx = 1;
        plaintextField = new JTextField(25);
        add(plaintextField, gbc);
        
        gbc.gridx = 2;
        JRadioButton option1 = new JRadioButton("二进制");
        JRadioButton option2 = new JRadioButton("字符串");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(option1);
        buttonGroup.add(option2);
        gbc.gridheight = 3;
        gbc.gridy = 0;
        add(option1,gbc);
        gbc.gridy = 2;
        add(option2,gbc);
        gbc.gridheight = 1;
    
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("密钥:"), gbc);

        gbc.gridx = 1;
        keyField = new JTextField(25);
        add(keyField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("密文:"), gbc);

        gbc.gridx = 1;
        ciphertextField = new JTextField(25);
        add(ciphertextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("解密明文:"), gbc);
        gbc.gridx = 1;
        decryptedField = new JTextField(25);
        decryptedField.setEditable(false);
        add(decryptedField, gbc);

        gbc.gridx = 0; 
        gbc.gridy = 6; 
        JButton encryptButton = new JButton("加密");
        JButton decryptButton = new JButton("解密");
        add(encryptButton, gbc);
        gbc.gridx = 2;
        add(decryptButton, gbc);
    
        //加密监听器
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String plaintext = plaintextField.getText();
                String key = keyField.getText();
                String ciphertext = new String();
                if(option1.isSelected()) {
                    if(one.isSelected()) {
                        ciphertext = Cipher.cipher(plaintext, key);
                    }
                    else if(two.isSelected()){
                        ciphertext = Cipher.cipher2(plaintext,key);
                    }
                    else if(three.isSelected()){
                        ciphertext = Cipher.cipher3(plaintext,key);
                    }
                }
                else if(option2.isSelected()){
                    if(one.isSelected()) {
                        ciphertext = ASCII.asciiEncipher(plaintext, key);
                    }
                    else if(two.isSelected()){
                        ciphertext = ASCII.asciiEncipher2(plaintext,key);
                    }
                    else if(three.isSelected()){
                        ciphertext = ASCII.asciiEncipher3(plaintext,key);
                    }
                }
                ciphertextField.setText(ciphertext);
            }
        });

        //解密监听器
        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ciphertext = ciphertextField.getText();
                String decryptKey = keyField.getText();
                String decryptedText = new String();
                if(option1.isSelected()) {
                    if(one.isSelected()) {
                        decryptedText = Decipher.decipher(ciphertext, decryptKey);
                    }
                    else if(two.isSelected()){
                        decryptedText = Decipher.decipher2(ciphertext, decryptKey);
                    }
                    else if(three.isSelected()){
                        decryptedText = Decipher.decipher3(ciphertext, decryptKey);
                    }
                }
                else if(option2.isSelected()){
                    if(one.isSelected()) {
                        decryptedText = ASCII.asciiDecipher(ciphertext, decryptKey);
                    }
                    else if(two.isSelected()){
                        decryptedText = ASCII.asciiDecipher2(ciphertext, decryptKey);
                    }
                    else if(three.isSelected()){
                        decryptedText = ASCII.asciiDecipher3(ciphertext, decryptKey);
                    }
                }
                decryptedField.setText(decryptedText);
            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SAESUI();
            }
        });
    }
}
