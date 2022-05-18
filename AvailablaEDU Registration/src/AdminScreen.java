import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class AdminScreen extends JFrame{

	// Panel1: ��retmen Bilgileri Tablosu
	JPanel adminTchrPanel;
	JTable tchrDataTable;
	DefaultTableModel tchrDataTableModel;
	
	// Panel2: ��renci Bilgileri Tablosu
	JPanel adminStdPanel;
	JTable stdDataTable;
	DefaultTableModel stdDataTableModel;
	
	// Panel3: Y�kleme  Paneli
	JPanel loadButtonPanel;
	JButton stdLoadButton;
	JButton tchrLoadButton;
	
	// Panel4: ��k�� Paneli
	JPanel exitButtonPanel;
	JButton exitButton;
	
	JButton mainscreenButton;
	
	// S�n�flar
	TeacherData teacherData;
	StudentData studentData;
	Contract contract;
	
	// Kay�t
	File file;
	
	
	public AdminScreen() {
		
		
		/********************* PANEL 1 ********************/
		
		
		adminTchrPanel = new JPanel();
		adminTchrPanel.setBounds(130,15,515,250);
		adminTchrPanel.setLayout(new GridLayout());
		
		Border adminTchrBorder = BorderFactory.createTitledBorder("E�itmen Bilgileri");
		adminTchrPanel.setBorder(adminTchrBorder);
		
		// JTable1:
		// 1- Table Modeli
		tchrDataTableModel = new DefaultTableModel(){
			@Override
		    public boolean isCellEditable(int row, int column) {
		       // Hi�bir h�cre de�i�tirilemesin
		       return false;
		    }
		};
		
		// 2- Kolonlar
		tchrDataTable = new JTable(tchrDataTableModel);
		tchrDataTableModel.addColumn("�sim");
		tchrDataTableModel.addColumn("Soyisim");
		tchrDataTableModel.addColumn("Telefon No");
		tchrDataTableModel.addColumn("S�zle�me Ba�lang�c�");
		tchrDataTableModel.addColumn("S�zle�me Biti�i");
		tchrDataTableModel.addColumn("Kar");
		
		// 3- ScrollPane
		JScrollPane scrollPane1 = new JScrollPane(tchrDataTable);
		adminTchrPanel.add(scrollPane1);
		
		
		/********************* PANEL 2 ********************/
		
		
		adminStdPanel = new JPanel();
		adminStdPanel.setBounds(130,280,515,250);
		adminStdPanel.setLayout(new GridLayout());
		
		Border adminStdBorder = BorderFactory.createTitledBorder("��renci Bilgileri");
		adminStdPanel.setBorder(adminStdBorder);
		
		// JTable1:
		// 1- Table Modeli
		stdDataTableModel = new DefaultTableModel(){
			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		
		// 2- Kolonlar
		stdDataTable = new JTable(stdDataTableModel);
		stdDataTableModel.addColumn("�sim");
		stdDataTableModel.addColumn("Soyisim");
		stdDataTableModel.addColumn("Telefon No");
		stdDataTableModel.addColumn("S�zle�me Ba�lang�c�");
		stdDataTableModel.addColumn("S�zle�me Biti�i");
		stdDataTableModel.addColumn("�yelik Tipi");
		stdDataTableModel.addColumn("Kar");
		
		// 3- ScrollPane
		JScrollPane scrollPane2 = new JScrollPane(stdDataTable);
		adminStdPanel.add(scrollPane2);
		
		/********************* PANEL 3 ********************/
		
		loadButtonPanel = new JPanel();
		Border loadButtonPanelBorder = BorderFactory.createTitledBorder("");
		loadButtonPanel.setBorder(loadButtonPanelBorder);
		loadButtonPanel.setLayout(new GridLayout(2,1));
		loadButtonPanel.setBounds(15,30,100,100);
		
		// Butonlar
		stdLoadButton = new JButton("��renci Y�kle");
		
		stdLoadButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LoadStudentData();
			}
		});
		
		tchrLoadButton = new JButton("E�itmen Y�kle");
		
		tchrLoadButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LoadTeacherData();
			}
		});
		
		
		
		// Bile�enleri panele ekleme
		loadButtonPanel.add(tchrLoadButton);
		loadButtonPanel.add(stdLoadButton);
		
		
		/********************* PANEL 3 ********************/

		
		exitButtonPanel = new JPanel();
		Border exitButtonPanelBorder = BorderFactory.createTitledBorder("");
		exitButtonPanel.setBorder(exitButtonPanelBorder);
		exitButtonPanel.setLayout(new GridLayout());
		exitButtonPanel.setBounds(660,450,100,75);
		
		
		exitButton = new JButton("��k��");
		
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// Bile�enleri panele ekleme
		exitButtonPanel.add(exitButton);
		
		
		// MainscreenButton
        mainscreenButton = new JButton("Ana Sayfa");
        mainscreenButton.setSize(100,50);
		mainscreenButton.setLocation(15,475);
		
		mainscreenButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Mainscreen mainscreen = new Mainscreen();
				mainscreen.setBounds(100, 100, 800, 500);
				mainscreen.setLayout(null);
				mainscreen.setVisible(true);
				mainscreen.setResizable(false);
				mainscreen.setTitle("Kay�t Sistemi");
			}
		});
		
		
		
		// Panelleri JFrame'e ekleme
		add(exitButtonPanel);
		add(adminTchrPanel);
		add(adminStdPanel);
		add(loadButtonPanel);
		add(mainscreenButton);
		
		setTitle("Admin");
		setLayout(null);
		setBounds(20,10,785,580);
		setVisible(true);
		setResizable(false);
	}
	
	private ArrayList<Contract> LoadTeacherData(){
		ArrayList<Contract> tchrArrToLoad = new ArrayList<>();
		file = new File("D:\\teacherData.dat");
		
		try {
			InputStream is= new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(is);
			
			tchrArrToLoad = (ArrayList) ois.readObject();
			ois.close();
			is.close();
			
			} catch(FileNotFoundException e) {
			e.printStackTrace();
			} catch (IOException e) {
			e.printStackTrace();
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		for(Contract teacherData : tchrArrToLoad) {
			DisplayTeacherData(teacherData);
		}
		return tchrArrToLoad;
	} 
	
	private void DisplayTeacherData(Contract teacherData) {
		tchrDataTableModel.addRow(new Object[] {
				teacherData.getRegistration().getFirstName(),
				teacherData.getRegistration().getLastName(),
				teacherData.getRegistration().getPhone(),
				teacherData.getPeriod().getStartDate(),
				teacherData.getPeriod().getEndDate(),
				teacherData.getTotalMoney()
		});
	}
	
	private ArrayList<Contract> LoadStudentData(){
		ArrayList<Contract> stdArrToLoad = new ArrayList<>();
		file = new File("D:\\studentData.dat");
		
		try {
			InputStream is= new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(is);
			
			stdArrToLoad = (ArrayList) ois.readObject();
			ois.close();
			is.close();
			
			} catch(FileNotFoundException e) {
			e.printStackTrace();
			} catch (IOException e) {
			e.printStackTrace();
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		for(Contract studentData : stdArrToLoad) {
			DisplayStudentData(studentData);
		}
		return stdArrToLoad;
	}
	
	private void DisplayStudentData(Contract studentData) {
		stdDataTableModel.addRow(new Object[] {
				studentData.getRegistration().getFirstName(),
				studentData.getRegistration().getLastName(),
				studentData.getRegistration().getPhone(),
				studentData.getPeriod().getStartDate(),
				studentData.getPeriod().getEndDate(),
				studentData.getMembershipType(),
				studentData.getTotalMoney()
				
		});
	}
	
	
	public static void main(String[] args) {
		
		AdminScreen adminScreen = new AdminScreen();
		adminScreen.setBounds(20,10,785,580);
		adminScreen.setVisible(true);
		adminScreen.setResizable(false);

	}

}
