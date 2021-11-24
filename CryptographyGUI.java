import java.awt.*;
import java.awt.event.*;


public class CryptographyGUI extends Frame{

    String emessage[] = new String[2];
    Hill obj = new Hill();

    static CryptographyGUI gui = new CryptographyGUI();
    public static void main(String[] args) {

        gui.infoframe();
    } 
    public void infoframe()
    {
        Frame f1 = new Frame("Cryptography");

        Label l1 = new Label("Choose Your Encryption Method");

        Button b1 = new Button("Hill Cipher");
        Button b2 = new Button("Vigenere Cipher");
        Button b3 = new Button("Caeser Cipher");

        Button b4 = new Button("Exit");


        l1.setBounds(140,50,180,50);

        b1.setBounds(50,150,100,30);
        b2.setBounds(200,150,100,30);
        b3.setBounds(350,150,100,30);

        b4.setBounds(200,250,100,30);




        //button work start

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
       

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(false);
                f1.dispose();
                gui.hillframe();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(false);
                f1.dispose();
                gui.vigenereframe();
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(false);
                f1.dispose();
                gui.caeserframe();
            }
        });


     //button work end

        f1.add(l1);

        f1.add(b1);
        f1.add(b2);
        f1.add(b3);


        f1.add(b4);


        f1.setSize(500,300);

        f1.setLayout(null);
        f1.setVisible(true);
    }

    public void hillframe()
    {
        Frame f2 = new Frame("Hill Cipher");

        

        Label l1 = new Label("Enter the text to Encrpt.");
        TextField encrypttxt = new TextField();
        Label key1 = new Label("Your Key is :");
        TextField keytxt1 = new TextField();
        Label encryp = new Label("Encryptic Text is :");
        Button submit = new Button("Encrypt");



        Label l2 = new Label("Enter the Encrypted text to Decrypt.");
        TextField decrypttxt = new TextField();
        Label key2 = new Label("Enter the Key");
        TextField keytxt2 = new TextField();
        Label decryp = new Label("Decryptic Text is :");
        Button decButton = new Button("Decrpyt");

        Button transfer = new Button("Transfer");
        
        Button b1 = new Button("Back");



        //button work start
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f2.setVisible(false);
                f2.dispose();
                gui.infoframe();

            }
        });

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = encrypttxt.getText();
                text = text.substring(0, 3);
                text = text.toUpperCase();
                emessage = obj.encrypt(text);
                encryp.setText("Encryptic Text is : " + emessage[1]);
                keytxt1.setText(emessage[0]);

            }
        });

        transfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decrypttxt.setText(emessage[1]);
                keytxt2.setText(emessage[0]);
            }
        });


        decButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = decrypttxt.getText();
                String key = keytxt2.getText();
                text = text.toUpperCase();
                text = text.substring(0, 3);
                key = key.toUpperCase();
                // keytxt2.setText(emessage[0]);
                // decrypttxt.setText(emessage[1]);
                // System.out.println(emessage[0]);
                // System.out.println(emessage[1]);
                
                // System.out.println(key);
                // System.out.println(text);
                String dmessage = "";
                // dmessage = obj.decrypt(emessage[0], emessage[1]);
                dmessage = obj.decrypt(key, text);
                decryp.setText("Decryptic Text is : " + dmessage);
            }
        });
        //button work end



        
        l1.setBounds(50,50,200,30);
        encrypttxt.setBounds(50,100,200,30);
        key1.setBounds(50,150,200,30);
        keytxt1.setBounds(50,200,200,30);
        submit.setBounds(50,250,100,30);
        encryp.setBounds(50,300,200,30);

        transfer.setBounds(300,150,100,30);

        l2.setBounds(500,50,200,30);
        decrypttxt.setBounds(500,100,200,30);
        key2.setBounds(500,150,200,30);
        keytxt2.setBounds(500,200,200,30);
        decryp.setBounds(500,250,200,30);
        decButton.setBounds(500,300,100,30);


        



        b1.setBounds(300,350,100,30);

        f2.add(l1);
        f2.add(encrypttxt);
        f2.add(key1);
        f2.add(encryp);
        f2.add(submit);
        f2.add(keytxt1);

        f2.add(transfer);

        f2.add(l2);
        f2.add(decrypttxt);
        f2.add(key2);
        f2.add(keytxt2);
        f2.add(decryp);
        f2.add(decButton);


        f2.add(b1);

        f2.setSize(750,400);

        f2.setLayout(null);
        f2.setVisible(true);
    }

    public void vigenereframe()
    {
        Frame f2 = new Frame("Hill Cipher");

        

        Label l1 = new Label("Enter the text to Encrpt.");
        TextField encrypttxt = new TextField();
        Label key1 = new Label("Your Key is :");
        TextField keytxt1 = new TextField();
        Label encryp = new Label("Encryptic Text is :");
        Button submit = new Button("Encrypt");



        Label l2 = new Label("Enter the Encrypted text to Decrypt.");
        TextField decrypttxt = new TextField();
        Label key2 = new Label("Enter the Key");
        TextField keytxt2 = new TextField();
        Label decryp = new Label("Decryptic Text is :");
        Button decButton = new Button("Decrpyt");

        Button transfer = new Button("Transfer");
        
        Button b1 = new Button("Back");



        //button work start
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f2.setVisible(false);
                f2.dispose();
                gui.infoframe();

            }
        });

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = encrypttxt.getText();
                text = text.substring(0, 3);
                text = text.toUpperCase();
                emessage = obj.encrypt(text);
                encryp.setText("Encryptic Text is : " + emessage[1]);
                keytxt1.setText(emessage[0]);

            }
        });

        transfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decrypttxt.setText(emessage[1]);
                keytxt2.setText(emessage[0]);
            }
        });


        decButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = decrypttxt.getText();
                String key = keytxt2.getText();
                text = text.toUpperCase();
                text = text.substring(0, 3);
                key = key.toUpperCase();
                // keytxt2.setText(emessage[0]);
                // decrypttxt.setText(emessage[1]);
                // System.out.println(emessage[0]);
                // System.out.println(emessage[1]);
                
                // System.out.println(key);
                // System.out.println(text);
                String dmessage = "";
                // dmessage = obj.decrypt(emessage[0], emessage[1]);
                dmessage = obj.decrypt(key, text);
                decryp.setText("Decryptic Text is : " + dmessage);
            }
        });
        //button work end



        
        l1.setBounds(50,50,200,30);
        encrypttxt.setBounds(50,100,200,30);
        key1.setBounds(50,150,200,30);
        keytxt1.setBounds(50,200,200,30);
        submit.setBounds(50,250,100,30);
        encryp.setBounds(50,300,200,30);

        transfer.setBounds(300,150,100,30);

        l2.setBounds(500,50,200,30);
        decrypttxt.setBounds(500,100,200,30);
        key2.setBounds(500,150,200,30);
        keytxt2.setBounds(500,200,200,30);
        decryp.setBounds(500,250,200,30);
        decButton.setBounds(500,300,100,30);


        



        b1.setBounds(300,350,100,30);

        f2.add(l1);
        f2.add(encrypttxt);
        f2.add(key1);
        f2.add(encryp);
        f2.add(submit);
        f2.add(keytxt1);

        f2.add(transfer);

        f2.add(l2);
        f2.add(decrypttxt);
        f2.add(key2);
        f2.add(keytxt2);
        f2.add(decryp);
        f2.add(decButton);


        f2.add(b1);

        f2.setSize(750,400);

        f2.setLayout(null);
        f2.setVisible(true);

    }







    public void caeserframe()
    {
        Frame f2 = new Frame("Hill Cipher");

        

        Label l1 = new Label("Enter the text to Encrpt.");
        TextField encrypttxt = new TextField();
        Label key1 = new Label("Your Key is :");
        TextField keytxt1 = new TextField();
        Label encryp = new Label("Encryptic Text is :");
        Button submit = new Button("Encrypt");



        Label l2 = new Label("Enter the Encrypted text to Decrypt.");
        TextField decrypttxt = new TextField();
        Label key2 = new Label("Enter the Key");
        TextField keytxt2 = new TextField();
        Label decryp = new Label("Decryptic Text is :");
        Button decButton = new Button("Decrpyt");

        Button transfer = new Button("Transfer");
        
        Button b1 = new Button("Back");



        //button work start
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f2.setVisible(false);
                f2.dispose();
                gui.infoframe();

            }
        });

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = encrypttxt.getText();
                text = text.substring(0, 3);
                text = text.toUpperCase();
                emessage = obj.encrypt(text);
                encryp.setText("Encryptic Text is : " + emessage[1]);
                keytxt1.setText(emessage[0]);

            }
        });

        transfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decrypttxt.setText(emessage[1]);
                keytxt2.setText(emessage[0]);
            }
        });


        decButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = decrypttxt.getText();
                String key = keytxt2.getText();
                text = text.toUpperCase();
                text = text.substring(0, 3);
                key = key.toUpperCase();
                // keytxt2.setText(emessage[0]);
                // decrypttxt.setText(emessage[1]);
                // System.out.println(emessage[0]);
                // System.out.println(emessage[1]);
                
                // System.out.println(key);
                // System.out.println(text);
                String dmessage = "";
                // dmessage = obj.decrypt(emessage[0], emessage[1]);
                dmessage = obj.decrypt(key, text);
                decryp.setText("Decryptic Text is : " + dmessage);
            }
        });
        //button work end



        
        l1.setBounds(50,50,200,30);
        encrypttxt.setBounds(50,100,200,30);
        key1.setBounds(50,150,200,30);
        keytxt1.setBounds(50,200,200,30);
        submit.setBounds(50,250,100,30);
        encryp.setBounds(50,300,200,30);

        transfer.setBounds(300,150,100,30);

        l2.setBounds(500,50,200,30);
        decrypttxt.setBounds(500,100,200,30);
        key2.setBounds(500,150,200,30);
        keytxt2.setBounds(500,200,200,30);
        decryp.setBounds(500,250,200,30);
        decButton.setBounds(500,300,100,30);


        



        b1.setBounds(300,350,100,30);

        f2.add(l1);
        f2.add(encrypttxt);
        f2.add(key1);
        f2.add(encryp);
        f2.add(submit);
        f2.add(keytxt1);

        f2.add(transfer);

        f2.add(l2);
        f2.add(decrypttxt);
        f2.add(key2);
        f2.add(keytxt2);
        f2.add(decryp);
        f2.add(decButton);


        f2.add(b1);

        f2.setSize(750,400);

        f2.setLayout(null);
        f2.setVisible(true);

    }
}