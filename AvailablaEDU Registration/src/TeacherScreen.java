

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
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

public class TeacherScreen extends JFrame {
	
	// Panel1: E�itmen Bilgileri 1
	JPanel tchrRegPanel;
	JLabel tchrNameLBL;
	JLabel tchrLastNameLBL;
	JLabel tchrMobileLBL;
	JTextField tchrNameFLD;
	JTextField tchrLastNameFLD;
	JTextField tchrMobileFLD;
	
	// Panel2: E�itmen Bilgileri 2
	JPanel tchrRegPanel2;
	JLabel tchrGenderLBL;
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
    
    // Panel6: �denecek Tutar
    JPanel paymentPanel;
    JLabel mainPaymentLBL;
    
    // Panel7: Kay�t ve Yenileme
    JPanel lastPanel;
    JButton newButton;
    JButton saveButton;
    
    JButton mainscreenButton;
    
    TeacherData teacher;
    Contract contract;
	int selectedClassPrice = 0;
	int registryProfit = 50;
    
    TeacherScreen() {
		
		
		//********************** Panel 1 ***************************
		
		
		// JPanel
		tchrRegPanel = new JPanel();
		Border tchrRegBorder = BorderFactory.createTitledBorder("Kay�t Bilgileri");
		tchrRegPanel.setBorder(tchrRegBorder);
		tchrRegPanel.setLayout(new GridLayout(3,2));
		tchrRegPanel.setBounds(15,15,300,150);
		
		// JLabel
		tchrNameLBL     = new JLabel("�sim: ");
		tchrLastNameLBL = new JLabel("Soyisim: ");
		tchrMobileLBL   = new JLabel("Telefon No: ");
		birthDay        = new JLabel("Do�um Tarihi");
		
		// JTextFields
		tchrNameFLD     = new JTextField();
		tchrLastNameFLD = new JTextField();
		tchrMobileFLD   = new JTextField();
				
		// Bile�enleri panele ekleme
		tchrRegPanel.add(tchrNameLBL);
		tchrRegPanel.add(tchrNameFLD);
		tchrRegPanel.add(tchrLastNameLBL);
		tchrRegPanel.add(tchrLastNameFLD);
		tchrRegPanel.add(tchrMobileLBL);
		tchrRegPanel.add(tchrMobileFLD);
		
		
		//********************** Panel 2 ***************************
		
		
		// JPanel
		tchrRegPanel2 = new JPanel();
		Border tchrRegBorder2 = BorderFactory.createTitledBorder("");
		tchrRegPanel2.setBorder(tchrRegBorder2);
		tchrRegPanel2.setLayout(new GridLayout(7,1));
		tchrRegPanel2.setBounds(15,165,300,300);
		
		// JLabel
		tchrGenderLBL = new JLabel("Cinsiyet: ");
		birthDay      = new JLabel("Do�um Tarihi: ");
		
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
        tchrRegPanel2.add(tchrGenderLBL);
        tchrRegPanel2.add(female);
        tchrRegPanel2.add(male);
        tchrRegPanel2.add(birthDay);
        tchrRegPanel2.add(day);
        tchrRegPanel2.add(month);
        tchrRegPanel2.add(year);
        
        
        //********************** Panel 3 ***************************
        
        
        // JPanel
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
        numberOfLessonLBL = new JLabel("Verilecek Ders Say�s�: ");
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
					DisplayMartialClasses(); // D�v�� sanatlar� s�n�f�n� g�sterecek metod
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
					GetTeacherData(); // ��retmen bilgilerini dosyaya yazacak metod
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
        detailsAreaS  = new JTextArea(4,1);
        detailsAreaS.setEditable(false);
        
        detailsAreaD  = new JTextArea();
        detailsAreaD.setEditable(false);
        
        detailsAreaMA = new JTextArea();
        detailsAreaMA.setEditable(false);
        
        detailsAreaMU = new JTextArea();
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
        paymentPanel = new JPanel();
        Border paymentBorder = BorderFactory.createTitledBorder("�deme Bilgileri");
        paymentPanel.setBorder(paymentBorder);
        paymentPanel.setBounds(645,15,300,100);
        paymentPanel.setLayout(new GridLayout());
        
        // JLabel
        mainPaymentLBL = new JLabel("�denecek Tutar (Ayl�k): ");
        
        // Bile�enleri panele ekleme
        paymentPanel.add(mainPaymentLBL);
        
        
        //********************** Panel 7 ***************************
        
        
        // JPanel
        lastPanel = new JPanel();
        Border lastBorder = BorderFactory.createTitledBorder("");
        lastPanel.setBorder(lastBorder);
        lastPanel.setBounds(645,130,300,100);
        lastPanel.setLayout(new GridLayout(2,1));
        
        // JButton
        saveButton = new JButton("Kaydet");
        newButton  = new JButton("Yenile");
        
        saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SaveTeacherData(); // Kullan�c� bilgilerini dosyaya kaydedecek metod
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
		add(tchrRegPanel);  // Panel 1 
		add(tchrRegPanel2); // Panel 2
		add(contractPanel); // Panel 3    
		add(classPanel);    // Panel 4
		add(detailPanel);   // Panel 5
		add(paymentPanel);  // Panel 6
		add(lastPanel);     // Panel 7 
		add(mainscreenButton);
		
		
		// JFrame �zellikleri
 		setLayout(null);    // JFrame i�in null layout 
		setTitle("E�itmen Kay�t Formu");
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
	
	private int DisplaySportClasses() {
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
	
	private void GetTeacherData() throws ParseException {
		String genderData;
		if(female.isSelected()) {
			genderData = "female";
		}else {
			genderData = "male";
		}
		
		String birthDayData = (String)day.getSelectedItem() + "/" + (String)month.getSelectedItem() + "/" +(String)year.getSelectedItem(); 
		
		// TeacherData
		teacher = new TeacherData(
				tchrNameFLD.getText(),
				tchrLastNameFLD.getText(),
				birthDayData,
				genderData,
				Integer.parseInt(tchrMobileFLD.getText()));
		
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
				teacher,
				period,
				df.format(currentDate),
				""
				);
		
		int totalPay = (Integer.parseInt(numberOfLessonFLD.getText()) * selectedClassPrice - 50);
		
		mainPaymentLBL.setText("�denecek Tutar(Ayl�k): " + totalPay + "TL");
		
				ShowPrice();
	}
	
	private void ShowPrice() {
		if(sportCHKBX.isSelected()) {
			selectedClassPrice += DisplaySportClasses()  ;
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
		
		mainPaymentLBL.setText("�denecek Tutar(Ayl�k): " + 
				(Integer.parseInt(numberOfLessonFLD.getText()) * selectedClassPrice) + "TL");
	}
	
	private void SaveTeacherData() {
		ArrayList<Contract> arrToSave = new ArrayList<>();
		arrToSave.add(contract);
		File file = new File("D:\\teacherData.dat");
		
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
		tchrNameFLD.setText("");
		tchrLastNameFLD.setText("");
		tchrMobileFLD.setText("");
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
	
	public static void main(String[] args) throws Exception{
		
		TeacherScreen teacherScreen = new TeacherScreen();
		teacherScreen.setBounds(20,10,975,780);
		teacherScreen.setVisible(true);
		
	}
}
