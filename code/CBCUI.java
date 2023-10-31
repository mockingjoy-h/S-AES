import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CBCUI extends JFrame {
    
    private JTextField plaintextField;
    private JTextField keyField;
    private JTextField ciphertextField;
    private JTextField decryptedField;

    public CBCUI() {
        setTitle("CBC加密解密程序");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 300);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("明文:"), gbc);
        gbc.gridx = 1;
        plaintextField = new JTextField(25);
        add(plaintextField, gbc);
        gbc.gridx = 2;
        gbc.gridx = 0;

        gbc.gridy = 1;
        add(new JLabel("密钥:"), gbc);
        gbc.gridx = 1;
        keyField = new JTextField(25);
        add(keyField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("密文:"), gbc);
        gbc.gridx = 1;
        ciphertextField = new JTextField(25);
        add(ciphertextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("解密后明文:"), gbc);
        gbc.gridx = 1;
        decryptedField = new JTextField(25);
        decryptedField.setEditable(false);
        add(decryptedField, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton CBCencryptButton = new JButton("CBC加密");
        buttonPanel.add(CBCencryptButton);

        JButton CBCdecryptButton = new JButton("CBC解密");
        buttonPanel.add(CBCdecryptButton);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        add(buttonPanel, gbc);

        CBCencryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String plaintext = plaintextField.getText();
                String key = keyField.getText();
                String cbcCiphertext = CBC.CBCcipher(plaintext, key);
                ciphertextField.setText(cbcCiphertext);
            }
        });

        CBCdecryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cbcCiphertext = ciphertextField.getText();
                String key = keyField.getText();
                String decryptedText = CBC.CBCdecipher(cbcCiphertext, key);
                decryptedField.setText(decryptedText);
            }
        });
    }

    public static void main(String[] args) {
        CBCUI ui = new CBCUI();
        ui.setVisible(true);
    }
}
