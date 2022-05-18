

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class StudentScreen extends JFrame{
	
	// Panel1: ��renci Bilgileri 1
		JPanel stdRegPanel;
		JLabel stdNameLBL;
		JLabel stdLastNameLBL;
		JLabel stdMobileLBL;
		JTextField stdNameFLD;
		JTextField stdLastNameFLD;
		JTextField stdMobileFLD;
		
		
		// Panel2: ��renci Bilgileri 2
		JPanel stdRegPanel2;
		JLabel stdGenderLBL;
		JLabel birthDay;
		JRadioButton male;
		JRadioButton female;
		ButtonGroup genderGroup;
		JComboBox day;
		JComboBox month;
		JComboBox year;
		
		String days[]
		        = { "1", "2", "3", "4", "5",
		            "6", "7", "8", "9", "10",
		            "11", "12", "13", "14", "15",
		            "16", "17", "18", "19", "20",
		            "21", "22", "23", "24", "25",
		            "26", "27", "28", "29", "30",
		            "31" };
		String months[]
		        = { "Ocak", "�ubat", "Mart", "Nisan",
		            "May�s", "Haziran", "Temmuz", "A�ustos",
		            "Eyl�l", "Ekim", "Kas�m", "Aral�k" };
	    String years[]
	            = { "1995", "1996", "1997", "1998",
	                "1999", "2000", "2001", "2002",
	                "2003", "2004", "2005", "2006",
	                "2007", "2008", "2009", "2010",
	                "2011", "2012", "2013", "2014",
	                "2015", "2016", "2017", "2018",
	                "2019" };
	    
	    // Panel3: S�zle�me
	    JPanel contractPanel;
	    JLabel todayLBL;
	    JLabel startContractLBL;
	    JLabel endConctractLBL;
	    JLabel numberOfLessonLBL;
	    JTextField startContractFLD;
	    JTextField endContractFLD;
	    JTextField numberOfLessonFLD;
	    SimpleDateFormat df;
	    Date currentDate;
	    
	    // Panel4: Ders se�imleri
	    JPanel classPanel;
	    JLabel classLBL;
	    JCheckBox sportCHKBX;
	    JCheckBox danceCHKBX;
	    JCheckBox martialCHKBX;
	    JCheckBox musicCHKBX;
	    JButton joinButton;
	    JButton resetButton;
	    
	    // Panel5: S�n�flar�n detaylar�
	    JPanel detailPanel;
	    JTextArea detailsAreaS;
	    JTextArea detailsAreaD;
	    JTextArea detailsAreaMA;
	    JTextArea detailsAreaMU;
	    
	    // Panel6: �yelik klasman�
	    JPanel membershipPanel;
	    JLabel membershipLBL;
	    JRadioButton silverButton;
	    JRadioButton goldButton;
	    JRadioButton platinumButton;
	    ButtonGroup membershipGroup;
	    String membershipType;
	    int membershipMoney;
	    
	    // Panel7 �denecek Tutar
	    JPanel paymentPanel;
	    JLabel mainPaymentLBL;
	    
	    // Panel8: Kay�t ve Yenileme
	    JPanel lastPanel;
	    JButton newButton;
	    JButton saveButton;
	    
	    JButton mainscreenButton;
	    
	    StudentData student;
	    Contract contract;
	    private int selectedClassPrice;
	
	    StudentScreen() {
		
		
		//********************** Panel 1 ***************************
		
		
		// JPanel
		stdRegPanel = new JPanel();
		Border stdRegBorder = BorderFactory.createTitledBorder("Kay�t Bilgileri");
		stdRegPanel.setBorder(stdRegBorder);
		stdRegPanel.setLayout(new GridLayout(3,2));
		stdRegPanel.setBounds(15,15,300,150);
		
		// JLabel
		stdNameLBL     = new JLabel("�sim: ");
		stdLastNameLBL = new JLabel("Soyisim: ");
		stdMobileLBL   = new JLabel("Telefon No: ");
		birthDay       = new JLabel("Do�um Tarihi");
		
		// JTextFields
		stdNameFLD     = new JTextField();
		stdLastNameFLD = new JTextField();
		stdMobileFLD   = new JTextField();
				
		// Bile�enleri panele ekleme
		stdRegPanel.add(stdNameLBL);
		stdRegPanel.add(stdNameFLD);
		stdRegPanel.add(stdLastNameLBL);
		stdRegPanel.add(stdLastNameFLD);
		stdRegPanel.add(stdMobileLBL);
		stdRegPanel.add(stdMobileFLD);
		
		
		//********************** Panel 2 ***************************
		
		
		// JPanel
		stdRegPanel2 = new JPanel();
		stdRegPanel2.setBorder(stdRegBorder);
		stdRegPanel2.setLayout(new GridLayout(7,1));
		stdRegPanel2.setBounds(15,165,300,300);
		
		// JLabel
		stdGenderLBL = new JLabel("Cinsiyet: ");
		birthDay     = new JLabel("Do�um Tarihi: ");
		
		// JRadioButton
		female = new JRadioButton("Kad�n");
		female.setSelected(true);
		
		male = new JRadioButton("Erkek");
		male.setSelected(false);
	
		// ButtonGroup
		genderGroup = new ButtonGroup();
		genderGroup.add(female);
		genderGroup.add(male);
		
		// JComboBox
		day   = new JComboBox(days);
		month = new JComboBox(months);
        year  = new JComboBox(years);
		
        // Bile�enleri panele ekleme
        stdRegPanel2.add(stdGenderLBL);
        stdRegPanel2.add(female);
        stdRegPanel2.add(male);
        stdRegPanel2.add(birthDay);
        stdRegPanel2.add(day);
        stdRegPanel2.add(month);
        stdRegPanel2.add(year);
        
        
        //********************** Panel 3 ***************************
        
        
        contractPanel = new JPanel();
        Border contractBorder = BorderFactory.createTitledBorder("S�zle�me Detaylar�");
        contractPanel.setBorder(contractBorder);
        contractPanel.setBounds(15,470,300,200);
        contractPanel.setLayout(new GridLayout(7,1));
        
        // Bile�enler
        todayLBL = new JLabel();
        df = new SimpleDateFormat("dd/MM/yyyy");
        currentDate = new Date();
        todayLBL.setText("Today: " + df.format(currentDate));
        
        // S�zle�me ba�lang�c�
        startContractLBL = new JLabel("S�zle�me Ba�lang�� Tarihi (GG/AA/YYYY)");
        startContractFLD = new JTextField();
        
        // S�zle�me biti�i
        endConctractLBL = new JLabel("S�zle�me Biti� Tarihi (GG/AA/YYYY)");
        endContractFLD  = new JTextField();
        
        // Verilecek ders say�s�
        numberOfLessonLBL = new JLabel("Al�ncak Ders Say�s�: ");
        numberOfLessonFLD = new JTextField();
        
        // Bile�enleri panele ekleme
        contractPanel.add(todayLBL);
        contractPanel.add(startContractLBL);
        contractPanel.add(startContractFLD);
        contractPanel.add(endConctractLBL);
        contractPanel.add(endContractFLD);
        contractPanel.add(numberOfLessonLBL);
        contractPanel.add(numberOfLessonFLD);
        
        
        //********************** Panel 4 ***************************
        
        
        // JPanel
        classPanel = new JPanel();
        Border classBorder = BorderFactory.createTitledBorder("S�n�flar");
        classPanel.setBorder(classBorder);
        classPanel.setBounds(330,15,300,230);
        classPanel.setLayout(new GridLayout(7,1));
        
        // JLabel
        classLBL = new JLabel("L�tfen s�n�f t�r� se�iniz");
        
        // JCheckBox
        sportCHKBX   = new JCheckBox("Spor S�n�flar�");
        martialCHKBX = new JCheckBox("D�v�� Sanatlar� S�n�flar�");
        musicCHKBX   = new JCheckBox("M�zik S�n�flar�");
        danceCHKBX   = new JCheckBox("Dans S�n�flar�");
        
        // JButton
        joinButton  = new JButton("Kat�l");
        resetButton = new JButton("S�f�rla");
		
        // Bile�enleri panele ekleme
        classPanel.add(classLBL);
        classPanel.add(sportCHKBX);
        classPanel.add(martialCHKBX);
        classPanel.add(musicCHKBX);
        classPanel.add(danceCHKBX);
        classPanel.add(resetButton);
        classPanel.add(joinButton);
        
        // JCheckBox i�levleri
        sportCHKBX.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				if(sportCHKBX.isSelected()) {
					DisplaySportClasses(); // Spor s�n�flar�n� g�sterecek metod 
				}else {
					detailsAreaS.setText("");
				}
				
			}	
		});
        
        martialCHKBX.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				if(martialCHKBX.isSelected()) {
					DisplayMartialClasses(); // D�v�� sanatlar� s�n�flar�n� g�sterecek metod
				}else {
					detailsAreaMA.setText("");
				}
				
			}
		});
        
        musicCHKBX.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				if(musicCHKBX.isSelected()) {
					DisplayMusicClasses(); // M�zik s�n�flar�n� g�sterecek metod
				}else {
					detailsAreaMU.setText("");
				}
				
			}
		});
        
        danceCHKBX.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				if(danceCHKBX.isSelected()) {
					DisplayDanceClasses(); // Dans s�n�flar�n� g�sterecek metod
				}else {
					detailsAreaD.setText("");
				}
				
			}
		});
        
        // Button i�levleri
        joinButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					GetStudentData(); // ��renci bilgilerini dosyaya yazacak metod
				} catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
        
        resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ResetClasses(); // S�n�f se�imlerini s�f�rlayacak metod
				} catch(Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
        
        
        //********************** Panel 5 ***************************
        
        
        // JPanel
        detailPanel = new JPanel();
        Border detailBorder = BorderFactory.createTitledBorder("S�n�f Detaylar�");
        detailPanel.setBorder(detailBorder);
        detailPanel.setBounds(330,230,300,500);
        detailPanel.setLayout(new GridLayout(4,1));   
        
        
        // JTextField
        detailsAreaS  = new JTextArea(5,1);
        detailsAreaD  = new JTextArea(5,1);    
        detailsAreaMA = new JTextArea(5,1);        
        detailsAreaMU = new JTextArea(5,1);    
        
        // Linewrap
        detailsAreaS.setLineWrap(true);
        detailsAreaD.setLineWrap(true);
        detailsAreaMA.setLineWrap(true);
        detailsAreaMU.setLineWrap(true);
        
        // Kullan�c� de�i�iklik yapamas�n 
        detailsAreaS.setEditable(false);
        detailsAreaD.setEditable(false);
        detailsAreaMA.setEditable(false);
        detailsAreaMU.setEditable(false);
        
        // Saydaml�k ayarlama
        detailsAreaS.setOpaque(false);
        detailsAreaD.setOpaque(false);
        detailsAreaMA.setOpaque(false);
        detailsAreaMU.setOpaque(false);

        // Bile�enler panele ekleme
        detailPanel.add(detailsAreaS);
        detailPanel.add(detailsAreaD);
        detailPanel.add(detailsAreaMA);
        detailPanel.add(detailsAreaMU);
        
        
        
        
        
        //********************** Panel 6 ***************************
        
        
        // JPanel
        membershipPanel = new JPanel();
        Border membershipBorder = BorderFactory.createTitledBorder("�yelik T�r�");
        membershipPanel.setBorder(membershipBorder);
        membershipPanel.setBounds(645,15,300,200);
        membershipPanel.setLayout(new GridLayout(3,1));
        
        // JLabel
        membershipLBL   = new JLabel("");
        
        // JRadioButton
        silverButton    = new JRadioButton("Silver �yelik");    
        silverButton.setBackground(Color.GRAY);
        silverButton.setSelected(true);

        goldButton      = new JRadioButton("Gold �yelik");              
        goldButton.setBackground(Color.YELLOW);
        
        platinumButton  = new JRadioButton("Platinum �yelik");
        platinumButton.setBackground(Color.CYAN);
        
        // ButtonGroup
        membershipGroup = new ButtonGroup();
        membershipGroup.add(silverButton);
        membershipGroup.add(goldButton);
        membershipGroup.add(platinumButton);
        
        // Bile�enleri panele ekleme
        membershipPanel.add(silverButton);
        membershipPanel.add(goldButton);
        membershipPanel.add(platinumButton);
        
        if(silverButton.isSelected()) {
        	membershipType  = "silver";
        	membershipMoney = 0;
        }
        else if(goldButton.isSelected()) {
        	membershipType  = "gold";
        	membershipMoney = 250;
        }
        else if(platinumButton.isSelected()) {
        	membershipType  = "platinum";
        	membershipMoney = 500;
        }
        
        //********************** Panel 7 ***************************
        
        
        // JPanel
        paymentPanel = new JPanel();
        Border paymentBorder = BorderFactory.createTitledBorder("�deme Bilgileri");
        paymentPanel.setBorder(paymentBorder);
        paymentPanel.setBounds(645,230,300,100);
        paymentPanel.setLayout(new GridLayout());
        
        // JLabel
        mainPaymentLBL = new JLabel("�denecek Tutar (Ayl�k): ");
        
        // Bile�enleri panele ekleme
        paymentPanel.add(mainPaymentLBL);
        
        
        //********************** Panel 8 ***************************

        
        // JPanel
        lastPanel = new JPanel();
        Border lastBorder = BorderFactory.createTitledBorder("");
        lastPanel.setBorder(lastBorder);
        lastPanel.setBounds(645,345,300,100);
        lastPanel.setLayout(new GridLayout(2,1));
        
        // JButton
        saveButton = new JButton("Kaydet");
        newButton  = new JButton("Yenile");
        
        saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SaveStudentData(); // Kullan�c� bilgilerini dosyaya kaydedecek metod
			}
		});
        
        newButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				NewRegistration(); // Sayfay� s�f�rlayacak metod				
			}
		});
        
        // MainscreenButton
        mainscreenButton = new JButton("Ana Sayfa");
        mainscreenButton.setSize(100,50);
		mainscreenButton.setLocation(15,680);
		
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
        
        // Bile�enleri panele ekleme
        lastPanel.add(saveButton);
        lastPanel.add(newButton);
        
        
        // Panelleri JFrame'e ekleme
		add(stdRegPanel);     // Panel 1 
		add(stdRegPanel2);    // Panel 2
		add(contractPanel);	  // Panel 3
		add(classPanel);      // Panel 4
		add(detailPanel);     // Panel 5
		add(membershipPanel); // Panel 6 
		add(paymentPanel);    // Panel 7
		add(lastPanel);       // Panel 8
		add(mainscreenButton);
		
		// JFrame �zellikleri
		setLayout(null);    // JFrame i�in null layout 
		setTitle("��renci Kay�t Formu");
		setBounds(20,10,975,780);
		setResizable(false);
		setVisible(true);
	}
	    
	    
    //********************** Methodlar ***************************
	
	
	private void ResetClasses() {
		sportCHKBX.setSelected(false);
		martialCHKBX.setSelected(false);
		danceCHKBX.setSelected(false);
		musicCHKBX.setSelected(false);
		
		detailsAreaD.setText("");
		detailsAreaS.setText("");
		detailsAreaMA.setText("");
		detailsAreaMU.setText("");
	}
	
	protected int DisplaySportClasses() {
		SportClass s1 = new SportClass("Futbol","       SPOR", 200);
		SportClass s2 = new SportClass("Basketbol", "SPOR", 200);
		SportClass s3 = new SportClass("Fitness", "     SPOR", 150);
		SportClass s4 = new SportClass("Y�zme", "      SPOR", 100);
		SportClass s5 = new SportClass("Su Topu", "   SPOR", 150);
		
		ArrayList<SportClass> sportClasses = new ArrayList<>();
		sportClasses.add(s5);
		sportClasses.add(s4);
		sportClasses.add(s3);
		sportClasses.add(s2);
		sportClasses.add(s1);
		
		String sportClassSTR = "";
		int classPrice = 0;
		
		for(int i = 0; i < sportClasses.size(); i++) {
			sportClassSTR += "    " + sportClasses.get(i).getClassName()
					+ "    " + sportClasses.get(i).getClassType()
					+ "    " + sportClasses.get(i).getPrice()
					+ "\n";
			classPrice += sportClasses.get(i).getPrice();
		}
		detailsAreaS.setText(sportClassSTR);
		return classPrice;
	}
	
	private int DisplayMartialClasses() {
		MartialClass ma1 = new MartialClass("Muay Thai","D�V��", 250);
		MartialClass ma2 = new MartialClass("Krav Maga", "D�V��", 250);
		MartialClass ma3 = new MartialClass("Karate", "D�V��", 200);
		MartialClass ma4 = new MartialClass("Boks", "D�V��", 200);
		MartialClass ma5 = new MartialClass("Kick Boks", "D�V��", 200);
		
		ArrayList<MartialClass> martialClasses = new ArrayList<>();
		martialClasses.add(ma5);
		martialClasses.add(ma4);
		martialClasses.add(ma3);
		martialClasses.add(ma2);
		martialClasses.add(ma1);
		
		String martialClassSTR = "";
		int classPrice = 0;
		
		for(int i = 0; i < martialClasses.size(); i++) {
			martialClassSTR += "    " + martialClasses.get(i).getClassName()
					+ "    " + martialClasses.get(i).getClassType()
					+ "    " + martialClasses.get(i).getPrice()
					+ "\n";
			classPrice += martialClasses.get(i).getPrice();
		}
		detailsAreaS.setText(martialClassSTR);
		return classPrice;
	}
	
	private int DisplayMusicClasses() {
		MusicClass mu1 = new MusicClass("Piyano","M�Z�K", 300);
		MusicClass mu2 = new MusicClass("Gitar", "M�Z�K", 150);
		MusicClass mu3 = new MusicClass("Saksafon", "M�Z�K", 250);
		MusicClass mu4 = new MusicClass("Klarnet", "M�Z�K", 200);
		MusicClass mu5 = new MusicClass("Ba�lama", "M�Z�K", 200);
		
		ArrayList<MusicClass> MusicClasses = new ArrayList<>();
		MusicClasses.add(mu5);
		MusicClasses.add(mu4);
		MusicClasses.add(mu3);
		MusicClasses.add(mu2);
		MusicClasses.add(mu1);
		
		String musicClassSTR = "";
		int classPrice = 0;
		
		for(int i = 0; i < MusicClasses.size(); i++) {
			musicClassSTR += "    " + MusicClasses.get(i).getClassName()
					+ "    " + MusicClasses.get(i).getClassType()
					+ "    " + MusicClasses.get(i).getPrice()
					+ "\n";
			classPrice += MusicClasses.get(i).getPrice();
		}
		detailsAreaS.setText(musicClassSTR);
		return classPrice;
	}
	
	private int DisplayDanceClasses() {
		DanceClass mu1 = new DanceClass("Vals","DANS", 300);
		DanceClass mu2 = new DanceClass("Salsa", "DANS", 200);
		DanceClass mu3 = new DanceClass("Flamenko", "DANS", 250);
		DanceClass mu4 = new DanceClass("Harmandal�", "DANS", 200);
		DanceClass mu5 = new DanceClass("Kolbast�", "DANS", 200);
		
		ArrayList<DanceClass> DanceClasses = new ArrayList<>();
		DanceClasses.add(mu5);
		DanceClasses.add(mu4);
		DanceClasses.add(mu3);
		DanceClasses.add(mu2);
		DanceClasses.add(mu1);
		
		String danceClassSTR = "";
		int classPrice = 0;
		
		for(int i = 0; i < DanceClasses.size(); i++) {
			danceClassSTR += "    " + DanceClasses.get(i).getClassName()
					+ "    " + DanceClasses.get(i).getClassType()
					+ "    " + DanceClasses.get(i).getPrice()
					+ "\n";
			classPrice += DanceClasses.get(i).getPrice();
		}
		detailsAreaS.setText(danceClassSTR);
		return classPrice;
	}
	
	private void GetStudentData() throws ParseException {
		String genderData;
		if(female.isSelected()) {
			genderData = "female";
		}else {
			genderData = "male";
		}
		
		String membershipData;
		if(silverButton.isSelected()) {
			membershipData = "silver";
		}else if (goldButton.isSelected()) {
			membershipData = "gold";
		}else {
			membershipData = "platinum";
		}
		
		String birthDayData = (String)day.getSelectedItem() + "/" + (String)month.getSelectedItem() + "/" +(String)year.getSelectedItem(); 
		
		// StudentData
		student = new StudentData(
				stdNameFLD.getText(),
				stdLastNameFLD.getText(),
				birthDayData,
				genderData,
				Integer.parseInt(stdMobileFLD.getText()),
				membershipData);
		
		// S�zle�me periyodu
		Date currentDate= new Date();
		Date startDate = df.parse(startContractFLD.getText());
		Date endDate = df.parse(endContractFLD.getText());
		
		ContractPeriod period = new ContractPeriod(
				df.format(startDate),
				df.format(endDate)
				);
		
		// Contract
		contract = new Contract(
				Integer.parseInt(numberOfLessonFLD.getText()),
				student,
				period,
				df.format(currentDate),
				membershipType
				);
		
			ShowPrice();
	}
	
	public void ShowPrice() {
		if(sportCHKBX.isSelected()) {
			selectedClassPrice += DisplaySportClasses();
		}
		else if(musicCHKBX.isSelected()) {
			selectedClassPrice += DisplayMusicClasses();
		}
		else if(martialCHKBX.isSelected()) {
			selectedClassPrice += DisplayMartialClasses();
		}
		else if(danceCHKBX.isSelected()) {
			selectedClassPrice += DisplayDanceClasses();
		}
		
		int totalPay = ((contract.getTotalMoney() + selectedClassPrice) * Integer.parseInt(numberOfLessonFLD.getText())) + membershipMoney;
		
		
		mainPaymentLBL.setText("�denecek Tutar(Ayl�k): " + totalPay + "TL");

	}
	
	private void SaveStudentData() {
		ArrayList<Contract> arrToSave = new ArrayList<>();
		arrToSave.add(contract);
		File file = new File("D:\\studentData.dat");
		
		try {
			OutputStream os = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			
			oos.writeObject(arrToSave);
			oos.close();
			os.close();
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void NewRegistration() {
		
		// Her JTextField'� bo�altma
		stdNameFLD.setText("");
		stdLastNameFLD.setText("");
		stdMobileFLD.setText("");
		female.setSelected(true);
		day.setSelectedIndex(0);
		month.setSelectedIndex(0);
		year.setSelectedIndex(0);
		
		startContractFLD.setText("");
		endContractFLD.setText("");
		numberOfLessonFLD.setText("");
		
		mainPaymentLBL.setText("�denecek Tutar (Ayl�k): ");
		
		sportCHKBX.setSelected(false);
		martialCHKBX.setSelected(false);
		danceCHKBX.setSelected(false);
		musicCHKBX.setSelected(false);
		
		detailsAreaD.setText("");
		detailsAreaS.setText("");
		detailsAreaMA.setText("");
		detailsAreaMU.setText("");
	}
	
	public static void main(String[] args) {
		
		StudentScreen studentScreen = new StudentScreen();
		studentScreen.setBounds(20,10,975,780);
		studentScreen.setVisible(true);
		
	}
}
