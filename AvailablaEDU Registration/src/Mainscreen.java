import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Mainscreen extends JFrame{
	
	// Butonlar
	JButton teacherLogin;
	JButton studentLogin;
	JButton adminButton;
	JLabel title;

	public Mainscreen(){
		
		
		// Öðretmen giriþi butonu
		teacherLogin = new JButton("Eðitmen Kayýt");
		teacherLogin.setSize(200,200);
		teacherLogin.setLocation(425,130);
		
		teacherLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TeacherScreen ts = new TeacherScreen();
			}
		});
		
		
		// Öðrenci giriþ butonu
		studentLogin = new JButton("Öðrenci Kayýt");
		studentLogin.setSize(200,200);
		studentLogin.setLocation(150,130);
		
		studentLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StudentScreen sc = new StudentScreen();
				
			}
		});
		
		// Admin Buttonu
		adminButton = new JButton("Admin giriþi için týklayýnýz...");
		adminButton.setSize(475,50);
		adminButton.setLocation(150,340);
		
		adminButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminLogin al = new AdminLogin();
				
			}
		});
		
		// JLabel
		title = new JLabel("Kayýt Türü Seçiniz");
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		title.setSize(300, 30);
        title.setLocation(260, 30);
		
        // Bileþenleri JFrame'e ekleme
		add(title);
		add(teacherLogin);
		add(studentLogin);
		add(adminButton);
		
	}
	
	public static void main(String[] args) 
				   
	{	
		// Ana sayfa özellikleri
		Mainscreen mainscreen = new Mainscreen();
		mainscreen.setBounds(100, 100, 800, 500);
		mainscreen.setLayout(null);
		mainscreen.setVisible(true);
		mainscreen.setResizable(false);
		mainscreen.setTitle("Kayýt Sistemi");
	
	}
}
