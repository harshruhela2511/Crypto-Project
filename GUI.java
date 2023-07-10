import javax.swing.*;    
import java.awt.event.*;   
import java.io.*; 
import java.awt.*;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;


import java.nio.file.*;
import java.security.spec.KeySpec;

class GUI extends JFrame implements ActionListener{  

    private static final String ALGORITHM = "AES";
    private static final String KEY = "mysecretpassword"; 

JRadioButton rb1,rb2,rb3;    
JButton b;   
JLabel L1,L2,lb1,lb2,lb3; 
GUI(){      

Image icon=Toolkit.getDefaultToolkit().getImage("D:\\Crypto Project\\icon.png");

L2=new JLabel(new ImageIcon("D:\\Crypto Project\\image.png"));
L2.setBounds(0,0,400,100);
add(L2);

this.setIconImage(icon);
lb1=new JLabel(new ImageIcon("D:\\Crypto Project\\logo_text.png"));
lb1.setBounds(70,140,100,50);
add(lb1);

rb1=new JRadioButton("Text");    
rb1.setBounds(150,140,100,50);

lb2=new JLabel(new ImageIcon("D:\\Crypto Project\\logo_file.png"));
lb2.setBounds(70,210,100,50);
add(lb2);

rb2=new JRadioButton("File");    
rb2.setBounds(150,220,200,30);    


lb3=new JLabel(new ImageIcon("D:\\Crypto Project\\logo_image.png"));
lb3.setBounds(70,280,100,50);
add(lb3);

rb3=new JRadioButton("Image");    
rb3.setBounds(150,280,200,40);  
rb1.setFocusPainted(false);
rb2.setFocusPainted(false);
rb3.setFocusPainted(false);  
ButtonGroup bg=new ButtonGroup();    
bg.add(rb1);bg.add(rb2);bg.add(rb3);  
Color color1=new Color(160,213,255);
rb1.setBackground(color1);
rb2.setBackground(color1);
rb3.setBackground(color1);

rb1.setFont(new Font("Verdana",Font.PLAIN,25));
rb2.setFont(new Font("Verdana",Font.PLAIN,25));
rb3.setFont(new Font("Verdana",Font.PLAIN,25));

b=new JButton("click");    
b.setBounds(90,370,200,40);
b.setFont(new Font("Verdana",Font.PLAIN,20));
Color color2=new Color(55,57,55);
b.setBackground(color2);
b.setForeground(Color.white);
b.setFocusPainted(false);
b.setBorder(BorderFactory.createLineBorder(color2));   
b.addActionListener(this);    
add(rb1);add(rb2);add(rb3);add(b);
setSize(400,470);    
setLayout(null);    
setVisible(true);   
Color color=new Color(160,213,255);
this.getContentPane().setBackground(color);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setResizable(false);
}    
public void actionPerformed(ActionEvent e){    
if(rb1.isSelected()){    
    JFrame f1=new JFrame();
    Image icon=Toolkit.getDefaultToolkit().getImage("D:\\Crypto Project\\icon.png");
    f1.setIconImage(icon);
    f1.setSize(515,470);
    f1.setVisible(true);
    f1.setLayout(null);
    Color color=new Color(255,239,213);
    f1.getContentPane().setBackground(color);
    f1.setLocationRelativeTo(null);
    f1.setResizable(false);
    
    L2=new JLabel(new ImageIcon("D:\\Crypto Project\\text_image.png"));
    L2.setBounds(0,-10,500,120);
    f1.add(L2);

    JLabel lb1=new JLabel(new ImageIcon("D:\\Crypto Project\\image_encrypt.png"));
    lb1.setBounds(20,130,60,30);
    f1.add(lb1);

    JRadioButton r1=new JRadioButton("Encryption");
    r1.setBounds(70,130,140,30);
    r1.setFont(new Font("Verdana",Font.PLAIN,20));

    JLabel lb2=new JLabel(new ImageIcon("D:\\Crypto Project\\image_decrypt.png"));
    lb2.setBounds(250,130,60,30);
    f1.add(lb2);

    JRadioButton r2=new JRadioButton("Decryption");
    r2.setBounds(300,130,140,30);
    r2.setFont(new Font("Verdana",Font.PLAIN,20));

    r1.setFocusPainted(false);
    r2.setFocusPainted(false);
    r1.setBackground(color);
    r2.setBackground(color);
    ButtonGroup bg1=new ButtonGroup();
    bg1.add(r1);
    bg1.add(r2);
    f1.add(r1);
    f1.add(r2);
    JLabel l2=new JLabel("Enter Your Text");
    l2.setBounds(160,180,200,50);
    l2.setFont(new Font("Verdana",Font.PLAIN,20));
    f1.add(l2);
    JTextField t1=new JTextField();
    t1.setBounds(30,240,430,40);
    t1.setBorder(BorderFactory.createLineBorder(Color.black));
    t1.setFont(new Font("Verdana",Font.PLAIN,20));
    f1.add(t1);
    JButton btn=new JButton("Compute");
    btn.setFocusPainted(false);
    Color color1=new Color(55,57,55);
    btn.setBackground(color1);
    btn.setForeground(Color.white);
    btn.setBorder(BorderFactory.createLineBorder(color1)); 
    btn.setBounds(75,380,320,40);
    btn.setFont(new Font("Verdana",Font.PLAIN,20));
    f1.add(btn);
    JTextField t2=new JTextField();
    t2.setBounds(30,300,430,40);
    t2.setBorder(BorderFactory.createLineBorder(Color.black));
    t2.setFont(new Font("Verdana",Font.PLAIN,20));
    f1.add(t2);
    btn.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            if(r1.isSelected())
            {
                    String plainText=t1.getText();
                      try {
                            SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
                            Cipher cipher = Cipher.getInstance(ALGORITHM);
                            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                            byte[] encryptedValue = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
                            String encryptedText=Base64.getEncoder().encodeToString(encryptedValue);
                            t2.setText(encryptedText);
                     } 
                     catch (Exception ex) {
                        ex.printStackTrace();
                        }
            }

            if(r2.isSelected())
            {
                String plainText=t1.getText();
                      try {
                             SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
                            Cipher cipher = Cipher.getInstance(ALGORITHM);
                            cipher.init(Cipher.DECRYPT_MODE, secretKey);
                            byte[] decryptedValue = cipher.doFinal(Base64.getDecoder().decode(plainText));
                            String decryptedText=new String(decryptedValue, StandardCharsets.UTF_8);
                            t2.setText(decryptedText);
                     } 
                     catch (Exception ex) {
                        ex.printStackTrace();
                        }          
            }
        }
    });
 
}    
if(rb2.isSelected())
{
    JFrame fr=new JFrame();
    Image icon=Toolkit.getDefaultToolkit().getImage("D:\\Crypto Project\\icon.png");
    fr.setIconImage(icon);
    fr.setSize(515,470);
    fr.setVisible(true);
    Color color=new Color(185,194,241);
    fr.getContentPane().setBackground(color);
    fr.setResizable(false);
    fr.setLocationRelativeTo(null);
    fr.setLayout(null);

    L2=new JLabel(new ImageIcon("D:\\Crypto Project\\text_file.png"));
    L2.setBounds(0,-10,500,120);
    fr.add(L2);

    JRadioButton rbtn1=new JRadioButton("Encryption");
    JLabel lab1=new JLabel(new ImageIcon("D:\\Crypto Project\\image_encrypt.png"));
    lab1.setBounds(20,130,60,30);
    fr.add(lab1);
    rbtn1.setBounds(70,130,140,30);
    rbtn1.setFocusPainted(false);
    rbtn1.setFont(new Font("Verdana",Font.PLAIN,20));
    
    JRadioButton rbtn2=new JRadioButton("Decryption");
    JLabel lab2=new JLabel(new ImageIcon("D:\\Crypto Project\\image_decrypt.png"));
    lab2.setBounds(250,130,60,30);
    fr.add(lab2);
    rbtn2.setBounds(300,130,140,30);
    rbtn2.setFont(new Font("Verdana",Font.PLAIN,20));
    rbtn2.setFocusPainted(false);
    ButtonGroup bg=new ButtonGroup();
    rbtn1.setBackground(color);
    rbtn2.setBackground(color);
    bg.add(rbtn1);
    bg.add(rbtn2);
    fr.add(rbtn1);
    fr.add(rbtn2);
    
    JLabel l2=new JLabel("Choose a file:");
    l2.setBounds(100,190,200,30);
    l2.setFont(new Font("Verdana",Font.PLAIN,20));
    fr.add(l2);

    JButton btn=new JButton(new ImageIcon("D:\\Crypto Project\\img.png"));
    btn.setBounds(250,190,30,30);
    btn.setFocusPainted(false);
    btn.setBorder(BorderFactory.createLineBorder(Color.black));
    fr.add(btn);

    JLabel l3=new JLabel();
    l3.setBounds(290,185,150,30);
    l3.setFont(new Font("Verdana",Font.PLAIN,15));
    fr.add(l3);

                JLabel result=new JLabel("Details of your encrypted file:");
                result.setBounds(80,220,400,50);
                result.setFont(new Font("Verdana",Font.PLAIN,20));
                fr.add(result);
                JLabel  lb1=new JLabel("File Name:");
                lb1.setBounds(50,270,140,50);
                lb1.setFont(new Font("Verdana",Font.PLAIN,20));
                fr.add(lb1);
                JTextField t1=new JTextField();
                t1.setBounds(170,280,250,30);
                t1.setFont(new Font("Verdana",Font.PLAIN,20));
                t1.setBorder(BorderFactory.createLineBorder(Color.black));
                fr.add(t1);
               
                JLabel  lb2=new JLabel("File Path:");
                lb2.setBounds(50,340,140,50);
                lb2.setFont(new Font("Verdana",Font.PLAIN,20));
                fr.add(lb2);
                JTextField t2=new JTextField();
                t2.setBounds(170,350,250,30);
                t2.setFont(new Font("Verdana",Font.PLAIN,20));
                t2.setBorder(BorderFactory.createLineBorder(Color.black));
                fr.add(t2);
    btn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            if(rbtn1.isSelected())
            {
            JFileChooser j=new JFileChooser();
            int i=j.showOpenDialog(null);
            if(i==JFileChooser.APPROVE_OPTION)
            {
                File f=j.getSelectedFile();
                String name=f.getName();
                String inputFilePath = f.getAbsolutePath(); // path to the input file
                Path inputFile = Paths.get(inputFilePath);
                String x1=name;
                String path2=inputFilePath.replace(x1,"Encrypted")+".txt";
                String outputFilePath = path2; // path to the output file
                String password = "myPassword123";
                Path outputFile = Paths.get(outputFilePath);
                try{
                byte[] fileContent = Files.readAllBytes(inputFile);
                // generate a secret key
                byte[] keyBytes = "MySecretKey12345".getBytes();
                SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
                // initialize the cipher
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
                // encrypt the file content
                byte[] encryptedFileContent = cipher.doFinal(fileContent);
                // write the encrypted content to a new file
                Files.write(outputFile, encryptedFileContent);
                l3.setText(name);
                t1.setText("Encrypted");
                t2.setText(outputFilePath);
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
            }


            if(rbtn2.isSelected())
            {
            JFileChooser j1=new JFileChooser();
            int i1=j1.showOpenDialog(null);
            if(i1==JFileChooser.APPROVE_OPTION)
            {
                File f1=j1.getSelectedFile();
                String name=f1.getName();
                String inputFilePath = f1.getAbsolutePath(); // path to the input file
                Path inputFile = Paths.get(inputFilePath);
                String x1=name;
                String path2=inputFilePath.replace(x1,"Decrypted")+".txt";
                String outputFilePath = path2; // path to the output file
                String password = "myPassword123";
                Path outputFile = Paths.get(outputFilePath);
                try{
                byte[] encryptedFileContent = Files.readAllBytes(inputFile);
                byte[] keyBytes = "MySecretKey12345".getBytes();
                SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
                byte[] decryptedFileContent = cipher.doFinal(encryptedFileContent);
                Files.write(outputFile, decryptedFileContent);
                l3.setText(name);
                t1.setText("Decrypted");
                t2.setText(outputFilePath);
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
            }

            }     
        
    });
}  

if(rb3.isSelected())
{
    JFrame fr=new JFrame();
    Image icon=Toolkit.getDefaultToolkit().getImage("D:\\Crypto Project\\icon.png");
    fr.setIconImage(icon);
    fr.setSize(515,470);
    fr.setVisible(true);
    Color color=new Color(238,241,185);
    fr.getContentPane().setBackground(color);
    fr.setResizable(false);
    fr.setLocationRelativeTo(null);
    fr.setLayout(null);


    L2=new JLabel(new ImageIcon("D:\\Crypto Project\\image_image.png"));
    L2.setBounds(0,-10,500,120);
    fr.add(L2);

    JRadioButton rbtn1=new JRadioButton("Encryption");
    JLabel lab1=new JLabel(new ImageIcon("D:\\Crypto Project\\image_encrypt.png"));
    lab1.setBounds(20,130,60,30);
    fr.add(lab1);
    rbtn1.setBounds(70,130,140,30);
    rbtn1.setFont(new Font("Verdana",Font.PLAIN,20));
    rbtn1.setFocusPainted(false);
    
    JRadioButton rbtn2=new JRadioButton("Decryption");
    JLabel lab2=new JLabel(new ImageIcon("D:\\Crypto Project\\image_decrypt.png"));
    lab2.setBounds(250,130,60,30);
    fr.add(lab2);
    rbtn2.setBounds(300,130,140,30);
    rbtn2.setFont(new Font("Verdana",Font.PLAIN,20));
    rbtn2.setFocusPainted(false);
    ButtonGroup bg=new ButtonGroup();
    bg.add(rbtn1);
    bg.add(rbtn2);
    fr.add(rbtn1);
    fr.add(rbtn2);
    rbtn1.setBackground(color);
    rbtn2.setBackground(color);

    JLabel l2=new JLabel("Choose a Image:");
    l2.setBounds(90,190,200,30);
    l2.setFont(new Font("Verdana",Font.PLAIN,20));
    fr.add(l2);

    JButton btn=new JButton(new ImageIcon("D:\\Crypto Project\\img.png"));
    btn.setBounds(270,190,30,30);
    btn.setFocusPainted(false);
    btn.setBorder(BorderFactory.createLineBorder(Color.black));
    fr.add(btn);

    JLabel l3=new JLabel();
    l3.setBounds(320,185,150,30);
    l3.setFont(new Font("Verdana",Font.PLAIN,15));
    fr.add(l3);

                JLabel result=new JLabel("Details of your encrypted Image:");
                result.setBounds(80,220,400,50);
                result.setFont(new Font("Verdana",Font.PLAIN,20));
                fr.add(result);
                JLabel  lb1=new JLabel("Image Name:");
                lb1.setBounds(50,270,140,50);
                lb1.setFont(new Font("Verdana",Font.PLAIN,20));
                fr.add(lb1);
                JTextField t1=new JTextField();
                t1.setBounds(190,280,250,30);
                t1.setFont(new Font("Verdana",Font.PLAIN,20));
                t1.setBorder(BorderFactory.createLineBorder(Color.black));
                fr.add(t1);
               
                JLabel  lb2=new JLabel("Image Path:");
                lb2.setBounds(50,340,140,50);
                lb2.setFont(new Font("Verdana",Font.PLAIN,20));
                fr.add(lb2);
                JTextField t2=new JTextField();
                t2.setBounds(190,350,250,30);
                t2.setFont(new Font("Verdana",Font.PLAIN,20));
                t2.setBorder(BorderFactory.createLineBorder(Color.black));
                fr.add(t2);
    btn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            if(rbtn1.isSelected())
            {
            JFileChooser j=new JFileChooser();
            int i=j.showOpenDialog(null);
            if(i==JFileChooser.APPROVE_OPTION)
            {
                File f=j.getSelectedFile();
                String name=f.getName();
                String inputPath = f.getAbsolutePath(); 
                String x=name;
                String path2=inputPath.replace(x,"EnryptImage")+".jpg";
                String outputPath = path2;
                try{
                Path imagePath = Paths.get(inputPath);
                byte[] imageData = Files.readAllBytes(imagePath);
                String password = "myPassword";
                byte[] keyBytes = password.getBytes("UTF-8");
                MessageDigest sha = MessageDigest.getInstance("SHA-256");
                keyBytes = sha.digest(keyBytes);
                keyBytes = Arrays.copyOf(keyBytes, 16); 
                SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
                byte[] encryptedData = cipher.doFinal(imageData);
                Path encryptedImagePath = Paths.get(outputPath);
                Files.write(encryptedImagePath, encryptedData);
                l3.setText(name);
                t1.setText("EncryptImage");
                t2.setText(outputPath);
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
            }
            if(rbtn2.isSelected())
            {
                JFileChooser j1=new JFileChooser();
                int i1=j1.showOpenDialog(null);
                
                if(i1==JFileChooser.APPROVE_OPTION)
                {
                File f1=j1.getSelectedFile();
                String name1=f1.getName();
                String inputPath = f1.getAbsolutePath(); 
                String x1=name1;
                String path2=inputPath.replace(x1,"DecryptImage")+".jpg";
                String outputPath = path2;
                try{
                    Path encryptedImagePath = Paths.get(inputPath);
                    byte[] encryptedData = Files.readAllBytes(encryptedImagePath);
                    String password = "myPassword";
                    byte[] keyBytes = password.getBytes("UTF-8");
                    MessageDigest sha = MessageDigest.getInstance("SHA-256");
                    keyBytes = sha.digest(keyBytes);
                    keyBytes = Arrays.copyOf(keyBytes, 16);
                    SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
                    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                    cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
                    byte[] imageData = cipher.doFinal(encryptedData);
                    Path imagePath = Paths.get(outputPath);
                    Files.write(imagePath, imageData);
                    l3.setText(name1);
                    t1.setText("DecryptImage");
                    t2.setText(path2);
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
                }   
            }     
        }
    });
}  
}    

public static void main(String args[]){    
new GUI();    
}}   