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
		
		
		// ��retmen giri�i butonu
		teacherLogin = new JButton("E�itmen Kay�t");
		teacherLogin.setSize(200,200);
		teacherLogin.setLocation(425,130);
		
		teacherLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TeacherScreen ts = new TeacherScreen();
			}
		});
		
		
		// ��renci giri� butonu
		studentLogin = new JButton("��renci Kay�t");
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
		adminButton = new JButton("Admin giri�i i�in t�klay�n�z...");
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
		title = new JLabel("Kay�t T�r� Se�iniz");
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		title.setSize(300, 30);
        title.setLocation(260, 30);
		
        // Bile�enleri JFrame'e ekleme
		add(title);
		add(teacherLogin);
		add(studentLogin);
		add(adminButton);
		
	}
	
	public static void main(String[] args) 
				   
	{	
		// Ana sayfa �zellikleri
		Mainscreen mainscreen = new Mainscreen();
		mainscreen.setBounds(100, 100, 800, 500);
		mainscreen.setLayout(null);
		mainscreen.setVisible(true);
		mainscreen.setResizable(false);
		mainscreen.setTitle("Kay�t Sistemi");
	
	}
}
