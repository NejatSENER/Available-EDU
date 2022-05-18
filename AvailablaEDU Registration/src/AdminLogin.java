import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class AdminLogin extends JFrame{
	
	JPanel adminLoginPanel;
	JLabel adminUsernameLBL;
	JLabel adminPasswordLBL;
	JLabel systemMessageLBL;
	JTextField adminUsernameFLD;
	JPasswordField adminPasswordFLD;
	JButton loginButton;
	JButton exitButton;
	JButton mainscreenButton;
	
	
	AdminLogin(){
		
		// JPanel
		adminLoginPanel = new JPanel();
        Border adminLoginBorder = BorderFactory.createTitledBorder("");
        adminLoginPanel.setBorder(adminLoginBorder);
		adminLoginPanel.setBounds(150,100,200,250);
		adminLoginPanel.setLayout(new GridLayout(6,1));
		
		// JLabel
		adminUsernameLBL = new JLabel("Kullanýcý Adý: ");
		adminPasswordLBL = new JLabel("Þifre: ");
		
		systemMessageLBL = new JLabel("");
		systemMessageLBL.setFont(new Font("Arial", Font.PLAIN, 15));
		systemMessageLBL.setSize(200, 75);
		systemMessageLBL.setLocation(150,350);
		
		// JTextField
		adminUsernameFLD = new JTextField();
		adminPasswordFLD = new JPasswordField();
			
		// JButton
		loginButton = new JButton("Giriþ");
		exitButton  = new JButton("Çýkýþ");
		
		mainscreenButton = new JButton("Ana Ekran");
		mainscreenButton.setSize(100,50);
		mainscreenButton.setLocation(15,395);
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = adminUsernameFLD.getText();
				char[] passwordArray = adminPasswordFLD.getPassword();
				
				String password = "";
				for(char character : passwordArray) {
					password += character;
					
				}
				
				
				if(username.equals("admin") && password.equals("admin")) {
					AdminScreen as = new AdminScreen();
					setVisible(false);
				}else if(!username.equals("admin") && password.equals("admin")) {
					systemMessageLBL.setText("Lütfen adýnýzý kontrol ediniz.");
				}else if(username.equals("admin") && !password.equals("admin")) {
					systemMessageLBL.setText("Lütfen þifrenizi kontrol ediniz.");
				}else {
					systemMessageLBL.setText("Lütfen bilgilerinizi kontrol ediniz.");
				}
			}
		});
		
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		mainscreenButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Mainscreen mainscreen = new Mainscreen();
				mainscreen.setBounds(100, 100, 800, 500);
				mainscreen.setLayout(null);
				mainscreen.setVisible(true);
				mainscreen.setResizable(false);
				mainscreen.setTitle("Kayýt Sistemi");
			}
		});
		
		// Bileþenleri panele ekleme
		adminLoginPanel.add(adminUsernameLBL);
		adminLoginPanel.add(adminUsernameFLD);
		adminLoginPanel.add(adminPasswordLBL);
		adminLoginPanel.add(adminPasswordFLD);
		adminLoginPanel.add(loginButton);
		adminLoginPanel.add(exitButton);
		
		// Paneli JFrame'e ekleme
		add(adminLoginPanel);
		
		add(systemMessageLBL);
		add(mainscreenButton);
		
		// JFrame özellikleri
		setLayout(null);
		setTitle("Admin Giriþi");
		setBounds(20, 10, 500, 500);
		setResizable(false);
		setVisible(true);
		

		
	}
	
	public static void main(String[] args) {
		
		AdminLogin adminLogin = new AdminLogin();
		adminLogin.setBounds(20, 10, 500, 500);
		adminLogin.setVisible(true);
	}

}


