package shippingstore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.io.IOException;
import java.util.logging.*;
import javax.swing.border.TitledBorder;
import java.text.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Program creates a GUI interface for a Shipping Store.  Creates an initial 
 * JFrame with selection buttons that toggle different JPanels.  Reads existing
 * database when launching program and writes to database when closed.  Program
 * has a logging system that sends messages to user interactively and also writes
 * logs to a .txt file.
 * 
 * @author Matt Windham
 * @date 11/20/17
 */
public class MainApp  {
    
    private final JFrame frame = new JFrame("Main Menu");
    //Layouts used for every panel
    private final SpringLayout layout = new SpringLayout();
    private final SpringLayout layout2 = new SpringLayout();
    private final SpringLayout layout3 = new SpringLayout();
    private final SpringLayout layout4 = new SpringLayout();
    private final SpringLayout crateLayout = new SpringLayout();
    private final SpringLayout drumLayout = new SpringLayout();
    private final SpringLayout showPackLayout = new SpringLayout();
    private final SpringLayout deletePackLayout = new SpringLayout();
    private final SpringLayout searchPackLayout = new SpringLayout();
    private final SpringLayout showUsersLayout = new SpringLayout();
    private final SpringLayout addUserLayout = new SpringLayout();
    private final SpringLayout showTransLayout = new SpringLayout();
    private final SpringLayout customerLayout = new SpringLayout();
    private final SpringLayout employeeLayout = new SpringLayout();
    private final SpringLayout updateUserLayout = new SpringLayout();
    private final SpringLayout updateCustomerLayout = new SpringLayout();
    private final SpringLayout updateEmployeeLayout = new SpringLayout();
    private final SpringLayout completeTransLayout = new SpringLayout();
    //Panels used for mainMenu and menu options
    private final JPanel mainPanel = new JPanel();
    private final JPanel addPanel = new JPanel();
    private final JPanel envelopePanel = new JPanel();
    private final JPanel boxPanel = new JPanel();
    private final JPanel cratePanel = new JPanel();
    private final JPanel drumPanel = new JPanel();
    private final JPanel typeOfPackage = new JPanel();
    private final JPanel showPackagesPanel = new JPanel();
    private final JPanel deletePackPanel = new JPanel();
    private final JPanel searchPackPanel = new JPanel();
    private final JPanel showUserPanel = new JPanel();
    private final JPanel addUserPanel = new JPanel();
    private final JPanel typeOfUserPanel = new JPanel();
    private final JPanel typeOfUserPanel2 = new JPanel();
    private final JPanel showTransPanel = new JPanel();
    private final JPanel customerPanel = new JPanel();
    private final JPanel employeePanel = new JPanel();
    private final JPanel updateUserPanel = new JPanel();
    private final JPanel updateCustomerPanel = new JPanel();
    private final JPanel updateEmployeePanel = new JPanel();
    private final JPanel completeTransPanel = new JPanel();
    //Labels for Panels and TextField description
    private final JLabel label1 = new JLabel("Choose from the following menu options");
    private final JLabel ptn = new JLabel("Enter Tracking Number: ");
    private final JLabel specification = new JLabel("Enter Specification: ");
    private final JLabel mailingClass = new JLabel("Enter Mailing Class: ");
    private final JLabel height = new JLabel("Enter Height: ");
    private final JLabel width = new JLabel("Enter Width: ");
    private final JLabel maxDim = new JLabel("Enter Largest Dimension: ");
    private final JLabel maxLoad = new JLabel("Enter Max Load Weight: ");
    private final JLabel content = new JLabel("Enter Content: ");
    private final JLabel volume = new JLabel("Enter Volume: ");
    private final JLabel diameter = new JLabel("Enter Diameter: ");
    private final JLabel material = new JLabel("Enter Material: ");
    private final JLabel delete = new JLabel("Enter Tracking Number: ");
    private final JLabel search = new JLabel("Enter Tracking Number: ");
    private final JLabel firstName = new JLabel("Enter First Name: ");
    private final JLabel updateFirstName = new JLabel("Enter First Name: ");
    private final JLabel lastName = new JLabel("Enter Last Name: ");
    private final JLabel updateLastName = new JLabel("Enter Last Name: ");
    private final JLabel phoneNumber = new JLabel("Enter Phone Number: ");
    private final JLabel updatePhoneNumber = new JLabel("Enter Phone Number: ");
    private final JLabel address = new JLabel("Enter Address: ");
    private final JLabel updateAddress = new JLabel("Enter Address: ");
    private final JLabel salary = new JLabel("Enter Monthly Salary: ");
    private final JLabel updateSalary = new JLabel("Enter Monthly Salary: ");
    private final JLabel ssn = new JLabel("Enter SSN: ");
    private final JLabel updateSSN = new JLabel("Enter SSN: ");
    private final JLabel accountNumber = new JLabel("Enter Bank Account #: ");
    private final JLabel updateAccountNumber = new JLabel("Enter Bank Account #: ");
    private final JLabel updateID = new JLabel("Enter User ID: ");
    private final JLabel customerID = new JLabel("Enter Customer ID: ");
    private final JLabel employeeID = new JLabel("Enter Employee ID: ");
    private final JLabel completeTrackNum = new JLabel("Enter Tracking Number: ");
    private final JLabel shippingDate = new JLabel("Enter Shipping Date: ");
    private final JLabel deliveryDate = new JLabel("Enter Delivery Date: ");
    private final JLabel price = new JLabel("Enter Price: ");
    //TextFields for user input
    private final int FIELD_WIDTH = 15;
    private final JTextField tnField = new JTextField("", FIELD_WIDTH);
    private final JTextField heightField = new JTextField("", FIELD_WIDTH);
    private final JTextField widthField = new JTextField("", FIELD_WIDTH);
    private final JTextField contentField = new JTextField("", FIELD_WIDTH);
    private final JTextField volumeField = new JTextField("", FIELD_WIDTH);
    private final JTextField maxDimField = new JTextField("", FIELD_WIDTH);
    private final JTextField maxLoadField = new JTextField("", FIELD_WIDTH);
    private final JTextField diamField = new JTextField("", FIELD_WIDTH);
    private final JTextField deletePackField = new JTextField("", FIELD_WIDTH);
    private final JTextField searchPackField = new JTextField("", FIELD_WIDTH);
    private final JTextField firstField = new JTextField("", FIELD_WIDTH);
    private final JTextField updateFirstField = new JTextField("", FIELD_WIDTH);
    private final JTextField lastField = new JTextField("", FIELD_WIDTH);
    private final JTextField updateLastField = new JTextField("", FIELD_WIDTH);
    private final JTextField numberField = new JTextField("", FIELD_WIDTH);
    private final JTextField updateNumberField = new JTextField("", FIELD_WIDTH);
    private final JTextField addressField = new JTextField("", FIELD_WIDTH);
    private final JTextField updateAddressField = new JTextField("", FIELD_WIDTH);
    private final JTextField salaryField = new JTextField("", FIELD_WIDTH);
    private final JTextField updateSalaryField = new JTextField("", FIELD_WIDTH);
    private final JTextField ssnField = new JTextField("", FIELD_WIDTH);
    private final JTextField updateSSNField = new JTextField("", FIELD_WIDTH);
    private final JTextField accountNumField = new JTextField("", FIELD_WIDTH);
    private final JTextField updateAccountNumField = new JTextField("", FIELD_WIDTH);
    private final JTextField updateIDField = new JTextField("", FIELD_WIDTH);
    private final JTextField customerIDField = new JTextField("", FIELD_WIDTH);
    private final JTextField employeeIDField = new JTextField("", FIELD_WIDTH);
    private final JTextField completeTNField = new JTextField("", FIELD_WIDTH);
    private final JTextField priceField = new JTextField("", FIELD_WIDTH);
    private final JTextField shippingDateField = new JTextField("", FIELD_WIDTH);
    private final JTextField deliveryDateField = new JTextField("", FIELD_WIDTH);
    //TextAreas to display packages, users and transactions
    private final JTextArea showPackagesArea = new JTextArea(200, 100);
    private final JTextArea searchPackagesArea = new JTextArea(200, 100);
    private final JTextArea showUsersArea = new JTextArea(200, 100);
    private final JTextArea showTransArea = new JTextArea(200, 100);
    //mainPanel Buttons
    private final JButton showPackagesButton = new JButton("Show all packages");
    private final JButton addPackageBtn = new JButton("Add Package");
    private final JButton addPackageButton = new JButton("Add new package");
    private final JButton removePackageButton = new JButton("Delete package");
    private final JButton searchPackageButton = new JButton("Search for package");
    private final JButton findUserButton = new JButton("Find all users");
    private final JButton addUserButton = new JButton("Add new user");
    private final JButton updateUserButton = new JButton("Update user");
    private final JButton deliverButton = new JButton("Deliver package");
    private final JButton showTransactionsButton = new JButton("Show all transactions");
    private final JButton exitButton = new JButton("Exit");
    //JPanel Buttons
    private final JButton deletePackButton = new JButton("Delete Package");
    private final JButton searchPackButton = new JButton("Search Package");
    private final JButton addCustomerButton = new JButton("Add Customer");
    private final JButton updateCustomerButton = new JButton("Update Customer");
    private final JButton addEmployeeButton = new JButton("Add Employee");
    private final JButton updateEmployeeButton = new JButton("Update Employee");
    private final JButton completeTransButton = new JButton("Complete Transaction");
    //User type and package type buttonGroups
    private ButtonGroup buttons;
    private ButtonGroup buttons2;
    //ComboBoxes to hold strings
    private JComboBox<String> packageSpec;
    private JComboBox<String> packageClass;
    private JComboBox<String> drumMaterial;
    //Strings for ComboBoxes
    private final String[] specStrings = { "Fragile", "Books", "Catalogs", "Do-not-bend", "N/A" };
    private final String[] classStrings = { "First-Class", "Priority", "Retail", "Ground", "Metro" };
    private final String[] materialStrings = { "Plastic", "Fiber" };
    //Buttons for type of user and package
    private final JRadioButton envelope = new JRadioButton("Envelope");
    private final JRadioButton box = new JRadioButton("Box");
    private final JRadioButton crate = new JRadioButton("Crate");
    private final JRadioButton drum = new JRadioButton("Drum");
    private final JRadioButton customer = new JRadioButton("Customer");
    private final JRadioButton customer2 = new JRadioButton("Customer");
    private final JRadioButton employee = new JRadioButton("Employee");
    private final JRadioButton employee2 = new JRadioButton("Employee");
    
    private static final Logger logger = Logger.getLogger(ShippingStore.class.getName());
    static FileHandler fh = initFh();
    private ShippingStore ss = new ShippingStore();

    //Sets up logger
    private static FileHandler initFh() {

    try {
        fh = new FileHandler("StoreLog.txt");
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        logger.addHandler(fh);
        logger.log(Level.INFO, "Initiating Logging");
        } catch(SecurityException ex) {
            logger.log(Level.WARNING,"Security alert", ex);
        } catch (IOException ex) {
            logger.log(Level.WARNING,"IO alert", ex);
        }
        return fh;
    }

    public MainApp() {
        
        ss = ShippingStore.readDatabase(logger);
    }
    
    //Runs JFrame
    public void runSoftware() {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
		mainMenu();
	    }
	});
    }
    
    /*
    * Creates JFrame for the main menu.  JFrame has one JPanel with ten JButtons.
    * Creates an ActionListener for each button which calls a new JPanel.  
    * ActionListeners for each button will remove all JPanels that are not being
    * called.
    */
    private void mainMenu() {
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,800);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);       
        mainPanel.setPreferredSize(new Dimension(900,800));
        mainPanel.setLayout(layout);
                  
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(label1, BorderLayout.NORTH);
        
        layout.putConstraint(SpringLayout.WEST,showPackagesButton,5,SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, showPackagesButton,10,SpringLayout.NORTH, mainPanel);
        showPackagesButton.setPreferredSize(new Dimension(170, 50));
        mainPanel.add(showPackagesButton);
        
        layout.putConstraint(SpringLayout.WEST, addPackageButton,185,SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, addPackageButton,10,SpringLayout.NORTH, mainPanel);
        addPackageButton.setPreferredSize(new Dimension(170, 50));
        mainPanel.add(addPackageButton); 
        
        layout.putConstraint(SpringLayout.WEST, removePackageButton,365,SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, removePackageButton,10,SpringLayout.NORTH, mainPanel);
        removePackageButton.setPreferredSize(new Dimension(170, 50));
        mainPanel.add(removePackageButton); 
        
        layout.putConstraint(SpringLayout.WEST, searchPackageButton,545,SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, searchPackageButton,10,SpringLayout.NORTH, mainPanel);
        searchPackageButton.setPreferredSize(new Dimension(170, 50));
        mainPanel.add(searchPackageButton);
        
        layout.putConstraint(SpringLayout.WEST, findUserButton,725,SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, findUserButton,10,SpringLayout.NORTH, mainPanel);
        findUserButton.setPreferredSize(new Dimension(170, 50));
        mainPanel.add(findUserButton);
        
        layout.putConstraint(SpringLayout.WEST, addUserButton,5,SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, addUserButton,70,SpringLayout.NORTH, mainPanel);
        addUserButton.setPreferredSize(new Dimension(170, 50));
        mainPanel.add(addUserButton); 
        
        layout.putConstraint(SpringLayout.WEST, updateUserButton,185,SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, updateUserButton,70,SpringLayout.NORTH, mainPanel);
        updateUserButton.setPreferredSize(new Dimension(170, 50));
        mainPanel.add(updateUserButton);
        
        layout.putConstraint(SpringLayout.WEST, deliverButton,365,SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, deliverButton,70,SpringLayout.NORTH, mainPanel);
        deliverButton.setPreferredSize(new Dimension(170, 50));
        mainPanel.add(deliverButton); 
        
        layout.putConstraint(SpringLayout.WEST, showTransactionsButton,545,SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, showTransactionsButton,70,SpringLayout.NORTH, mainPanel);
        showTransactionsButton.setPreferredSize(new Dimension(170, 50));
        mainPanel.add(showTransactionsButton);
               
        layout.putConstraint(SpringLayout.WEST, exitButton,725,SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, exitButton,70,SpringLayout.NORTH, mainPanel);
        exitButton.setPreferredSize(new Dimension(170, 50));
        mainPanel.add(exitButton); 
             
        frame.add(mainPanel);
        frame.setVisible(true);
        
        showPackagesButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.remove(addPanel);
                mainPanel.remove(deletePackPanel);
                mainPanel.remove(searchPackPanel);
                mainPanel.remove(addUserPanel);
                mainPanel.remove(showTransPanel);
                mainPanel.remove(showUserPanel);
                mainPanel.remove(updateUserPanel);
                mainPanel.remove(completeTransPanel);
                mainPanel.setVisible(false);
                showAllPackages();
                mainPanel.setVisible(true);
                logger.log(Level.INFO, "User Request: Show Packages Button Selected");
                logger.info("Showed all packages");
            }
        });
        
        addPackageButton.addActionListener(new ActionListener(){
            @Override
	    public void actionPerformed(ActionEvent e){			      
		mainPanel.remove(showPackagesPanel);
                mainPanel.remove(deletePackPanel);
                mainPanel.remove(searchPackPanel);
                mainPanel.remove(showUserPanel);
                mainPanel.remove(addUserPanel);
                mainPanel.remove(showTransPanel);
                mainPanel.remove(completeTransPanel);
                mainPanel.remove(updateUserPanel);
		mainPanel.setVisible(false);
		addNewPackage();
		mainPanel.setVisible(true);
                logger.log(Level.INFO, "User Request: Add Package Button Selected");
		}
	});
        
        removePackageButton.addActionListener(new ActionListener(){
            @Override
	    public void actionPerformed(ActionEvent e){			      
		mainPanel.remove(showPackagesPanel);
		mainPanel.remove(addPanel);
                mainPanel.remove(searchPackPanel);
                mainPanel.remove(showUserPanel);
                mainPanel.remove(addUserPanel);
                mainPanel.remove(showTransPanel);
                mainPanel.remove(updateUserPanel);
                mainPanel.remove(completeTransPanel);
		mainPanel.setVisible(false);
		deletePackage();
		mainPanel.setVisible(true);
                logger.log(Level.INFO, "User Request: Remove Package Button Selected");
		}
	});
        
        searchPackageButton.addActionListener(new ActionListener(){
            @Override
	    public void actionPerformed(ActionEvent e){			      
		mainPanel.remove(showPackagesPanel);
		mainPanel.remove(addPanel);
                mainPanel.remove(deletePackPanel);
                mainPanel.remove(updateUserButton);
                mainPanel.remove(showUserPanel);
                mainPanel.remove(addUserPanel);
                mainPanel.remove(showTransPanel);
                mainPanel.remove(completeTransPanel);
		mainPanel.setVisible(false);
		searchPackage();
		mainPanel.setVisible(true);
                logger.log(Level.INFO, "User Request: Search Packages Button Selected");
		}
	});
        
        findUserButton.addActionListener(new ActionListener(){
            @Override
	    public void actionPerformed(ActionEvent e){			      
		mainPanel.remove(showPackagesPanel);
		mainPanel.remove(addPanel);
                mainPanel.remove(deletePackPanel);
                mainPanel.remove(searchPackPanel);
                mainPanel.remove(updateUserButton);
                mainPanel.remove(addUserPanel);
                mainPanel.remove(showTransPanel);
                mainPanel.remove(completeTransPanel);
		mainPanel.setVisible(false);
		showAllUsers();
		mainPanel.setVisible(true);
                logger.log(Level.INFO, "User Request: Search Users Button Selected");
		}
	});
        
        addUserButton.addActionListener(new ActionListener(){
            @Override
	    public void actionPerformed(ActionEvent e){			      
		mainPanel.remove(showPackagesPanel);
		mainPanel.remove(addPanel);
                mainPanel.remove(deletePackPanel);
                mainPanel.remove(searchPackPanel);
                mainPanel.remove(showUserPanel);
                mainPanel.remove(showTransPanel);
                mainPanel.remove(completeTransPanel);
                mainPanel.remove(updateUserPanel);
		mainPanel.setVisible(false);
		addNewUser();
		mainPanel.setVisible(true);
                logger.log(Level.INFO, "User Request: Add User Button Selected");
		}
	});
        
        showTransactionsButton.addActionListener(new ActionListener(){
            @Override
	    public void actionPerformed(ActionEvent e){			      
		mainPanel.remove(showPackagesPanel);
		mainPanel.remove(addPanel);
                mainPanel.remove(deletePackPanel);
                mainPanel.remove(searchPackPanel);
                mainPanel.remove(showUserPanel);
                mainPanel.remove(addUserPanel);
                mainPanel.remove(updateUserPanel);
                mainPanel.remove(completeTransPanel);
		mainPanel.setVisible(false);
		showAllTransactions();
		mainPanel.setVisible(true);
                logger.log(Level.INFO, "User Request: Show Transactions Button Selected");
		}
	});
        
        updateUserButton.addActionListener(new ActionListener(){
            @Override
	    public void actionPerformed(ActionEvent e){			      
		mainPanel.remove(showPackagesPanel);
		mainPanel.remove(addPanel);
                mainPanel.remove(deletePackPanel);
                mainPanel.remove(searchPackPanel);
                mainPanel.remove(showUserPanel);
                mainPanel.remove(addUserPanel);
                mainPanel.remove(showTransPanel);
                mainPanel.remove(completeTransPanel);
		mainPanel.setVisible(false);
		updateUser();
		mainPanel.setVisible(true);
                logger.log(Level.INFO, "User Request: Update User Button Selected");
		}
	});
        
        deliverButton.addActionListener(new ActionListener(){
            @Override
	    public void actionPerformed(ActionEvent e){			      
		mainPanel.remove(showPackagesPanel);
		mainPanel.remove(addPanel);
                mainPanel.remove(deletePackPanel);
                mainPanel.remove(searchPackPanel);
                mainPanel.remove(showUserPanel);
                mainPanel.remove(addUserPanel);
                mainPanel.remove(showTransPanel);
                mainPanel.remove(updateUserPanel);
		mainPanel.setVisible(false);
		deliverPackage();
		mainPanel.setVisible(true);
                logger.log(Level.INFO, "User Request: Deliver Package Button Selected");
		}
	});
                
        exitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
		write();
		System.exit(0);
            }
	});
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                write();
            }
        });       
    }   
    
    /*
    * Creates JPanel for adding a new packages to database.  
    */
    private void addNewPackage() {
             
        TitledBorder addPackPanel = BorderFactory.createTitledBorder("");
        layout.putConstraint(SpringLayout.WEST, addPanel,0,SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, addPanel,120,SpringLayout.NORTH, mainPanel);
        addPanel.setPreferredSize(new Dimension(900,640));

        TitledBorder packageType = BorderFactory.createTitledBorder("Select package type");
        addPanel.setLayout(layout2);
        layout2.putConstraint(SpringLayout.WEST, typeOfPackage,5,SpringLayout.WEST, addPanel);
        layout2.putConstraint(SpringLayout.NORTH, typeOfPackage,5,SpringLayout.NORTH, addPanel);
        typeOfPackage.setPreferredSize(new Dimension(400,75));
        
        buttons = new ButtonGroup();
        buttons.add(envelope);
        buttons.add(box);        
        buttons.add(crate);       
        buttons.add(drum);                      
        typeOfPackage.add(envelope);
        typeOfPackage.add(box);
        typeOfPackage.add(crate);
        typeOfPackage.add(drum);
        addPanel.add(typeOfPackage);               
        addPanel.setBorder(addPackPanel);
        typeOfPackage.setBorder(packageType);
        
        packageSpec = new JComboBox<>(specStrings);
        packageSpec.setEditable(false);
        
        packageClass = new JComboBox<>(classStrings);
        packageClass.setEditable(false);     
       
        drumMaterial = new JComboBox<>(materialStrings);
        drumMaterial.setEditable(false);      
        mainPanel.add(addPanel);
            				
	envelope.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){                               
		envelopeMenu();
		logger.log(Level.INFO, "User Request: Select Envelope package type");
            }
	});
		
	box.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){	
		boxMenu();	
		logger.log(Level.INFO, "User Request: Select Box package type");				
            }
	});
		
	crate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){			      
		crateMenu();
		logger.log(Level.INFO, "User Request: Select Crate package type");				
            }
	});
				
	drum.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){			      
            drumMenu();
            logger.log(Level.INFO, "User Request: Select Drum package type");				
            }
	});             	  
    }  
    
    public static boolean isInteger(String s) {
        
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    public static boolean isFloat(String s) {
        try {
            Float.parseFloat(s);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
    /*
    * Displays new JPanel inside of add new package panel when envelope
    * radio button is selected.
    */              
    private void envelopeMenu() {
            
        envelopePanel.setLayout(layout3);
        envelopePanel.setPreferredSize(new Dimension(800,640));
        
        layout3.putConstraint(SpringLayout.WEST, ptn,5,SpringLayout.WEST, envelopePanel);
        layout3.putConstraint(SpringLayout.NORTH, ptn,100,SpringLayout.NORTH, envelopePanel);
        envelopePanel.add(ptn);
        layout3.putConstraint(SpringLayout.WEST, tnField,170,SpringLayout.WEST, envelopePanel);
        layout3.putConstraint(SpringLayout.NORTH, tnField,96,SpringLayout.NORTH, envelopePanel);
        envelopePanel.add(tnField);
        
        layout3.putConstraint(SpringLayout.WEST, specification,5,SpringLayout.WEST, envelopePanel);
        layout3.putConstraint(SpringLayout.NORTH, specification,140,SpringLayout.NORTH, envelopePanel);
        envelopePanel.add(specification);
        layout3.putConstraint(SpringLayout.WEST, packageSpec,170,SpringLayout.WEST, envelopePanel);
        layout3.putConstraint(SpringLayout.NORTH, packageSpec,136,SpringLayout.NORTH, envelopePanel);
        envelopePanel.add(packageSpec);
        
        layout3.putConstraint(SpringLayout.WEST, mailingClass,5,SpringLayout.WEST, envelopePanel);
        layout3.putConstraint(SpringLayout.NORTH, mailingClass,180,SpringLayout.NORTH, envelopePanel);
        envelopePanel.add(mailingClass);
        layout3.putConstraint(SpringLayout.WEST, packageClass,170,SpringLayout.WEST, envelopePanel);
        layout3.putConstraint(SpringLayout.NORTH, packageClass,176,SpringLayout.NORTH, envelopePanel);
        envelopePanel.add(packageClass);
            
        layout3.putConstraint(SpringLayout.WEST, height,5,SpringLayout.WEST, envelopePanel);
        layout3.putConstraint(SpringLayout.NORTH, height,220,SpringLayout.NORTH, envelopePanel);
        envelopePanel.add(height);
        layout3.putConstraint(SpringLayout.WEST, heightField,170,SpringLayout.WEST, envelopePanel);
        layout3.putConstraint(SpringLayout.NORTH, heightField,216,SpringLayout.NORTH, envelopePanel);
        envelopePanel.add(heightField);
        
        layout3.putConstraint(SpringLayout.WEST, width,5,SpringLayout.WEST, envelopePanel);
        layout3.putConstraint(SpringLayout.NORTH, width,260,SpringLayout.NORTH, envelopePanel);
        envelopePanel.add(width);
        layout3.putConstraint(SpringLayout.WEST, widthField,170,SpringLayout.WEST, envelopePanel);
        layout3.putConstraint(SpringLayout.NORTH, widthField,256,SpringLayout.NORTH, envelopePanel);
        envelopePanel.add(widthField);
        
        layout3.putConstraint(SpringLayout.WEST, addPackageBtn,80,SpringLayout.WEST, envelopePanel);
        layout3.putConstraint(SpringLayout.NORTH, addPackageBtn,306,SpringLayout.NORTH, envelopePanel);
        addPackageBtn.setPreferredSize(new Dimension(150, 50));
        envelopePanel.add(addPackageBtn);  
               
        addPanel.add(envelopePanel);
        addPanel.revalidate();
        addPanel.repaint();
        envelopePanel.setVisible(false);
        boxPanel.setVisible(false);
        cratePanel.setVisible(false);
        drumPanel.setVisible(false);
        envelopePanel.setVisible(true);
        
        addPackageBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){			
		logger.log(Level.INFO, "User Request: Add Envelope to Database");
                
            if (tnField.getText().length() != 5) {
                JOptionPane.showMessageDialog(addPanel, "Tracking Number must be 5 characters long");
                    logger.log(Level.INFO, "User message: Tracking Number must be 5 characters long");
            }
            else if (ss.packageExists(tnField.getText())) {
                JOptionPane.showMessageDialog(addPanel, "Tracking Number already exist");
                    logger.log(Level.INFO, "User message: Tracking Number already exist");
            }
            else if (!isInteger (heightField.getText()) && envelope.isSelected()) {
                JOptionPane.showMessageDialog(addPanel, "Heigh must be a number");
                    logger.log(Level.INFO, "User message: Heigh must be a number");
            }
            else if (!isInteger(widthField.getText()) && envelope.isSelected()) {
                JOptionPane.showMessageDialog(addPanel, "Width must be a number");
                    logger.log(Level.INFO, "User message: Width must be a number");
            }
            
            else {
                ss.addEnvelope(tnField.getText(), packageSpec.getSelectedItem().toString().replace(" ", ""), 
                packageClass.getSelectedItem().toString().replace(" ", ""), 
                Integer.parseInt(heightField.getText()), Integer.parseInt(widthField.getText()));
        
                tnField.setText("");
                heightField.setText("");
                widthField.setText("");
        
                JOptionPane.showMessageDialog(envelopePanel, "Envelope added to the Database!");
                    logger.log(Level.INFO, "User message: Envelope added to the Database");
                }
            }
        });                   
    }
    
    /*
    * Displays new JPanel inside of add new package panel when box
    * radio button is selected.
    */         
    private void boxMenu() {
            
        boxPanel.setLayout(layout4);
        boxPanel.setPreferredSize(new Dimension(700,500));

        layout4.putConstraint(SpringLayout.WEST, ptn,5,SpringLayout.WEST, boxPanel);
        layout4.putConstraint(SpringLayout.NORTH, ptn,100,SpringLayout.NORTH, boxPanel);
        boxPanel.add(ptn);
        layout4.putConstraint(SpringLayout.WEST, tnField,170,SpringLayout.WEST, boxPanel);
        layout4.putConstraint(SpringLayout.NORTH, tnField,96,SpringLayout.NORTH, boxPanel);
        boxPanel.add(tnField);
        
        layout4.putConstraint(SpringLayout.WEST, specification,5,SpringLayout.WEST, boxPanel);
        layout4.putConstraint(SpringLayout.NORTH, specification,140,SpringLayout.NORTH, boxPanel);
        boxPanel.add(specification);
        layout4.putConstraint(SpringLayout.WEST, packageSpec,170,SpringLayout.WEST, boxPanel);
        layout4.putConstraint(SpringLayout.NORTH, packageSpec,136,SpringLayout.NORTH, boxPanel);
        boxPanel.add(packageSpec);
        
        layout4.putConstraint(SpringLayout.WEST, mailingClass,5,SpringLayout.WEST, boxPanel);
        layout4.putConstraint(SpringLayout.NORTH, mailingClass,180,SpringLayout.NORTH, boxPanel);
        boxPanel.add(mailingClass);
        layout4.putConstraint(SpringLayout.WEST, packageClass,170,SpringLayout.WEST, boxPanel);
        layout4.putConstraint(SpringLayout.NORTH, packageClass,176,SpringLayout.NORTH, boxPanel);
        boxPanel.add(packageClass);
        
        layout4.putConstraint(SpringLayout.WEST, maxDim,5,SpringLayout.WEST, boxPanel);
        layout4.putConstraint(SpringLayout.NORTH, maxDim,220,SpringLayout.NORTH, boxPanel);
        boxPanel.add(maxDim);
        layout4.putConstraint(SpringLayout.WEST, maxDimField,170,SpringLayout.WEST, boxPanel);
        layout4.putConstraint(SpringLayout.NORTH, maxDimField,216,SpringLayout.NORTH, boxPanel);
        boxPanel.add(maxDimField);
        
        layout4.putConstraint(SpringLayout.WEST, volume,5,SpringLayout.WEST, boxPanel);
        layout4.putConstraint(SpringLayout.NORTH, volume,260,SpringLayout.NORTH, boxPanel);
        boxPanel.add(volume);
        layout4.putConstraint(SpringLayout.WEST, volumeField,170,SpringLayout.WEST, boxPanel);
        layout4.putConstraint(SpringLayout.NORTH, volumeField,256,SpringLayout.NORTH, boxPanel);
        boxPanel.add(volumeField);
        
        layout4.putConstraint(SpringLayout.WEST, addPackageBtn,80,SpringLayout.WEST, boxPanel);
        layout4.putConstraint(SpringLayout.NORTH, addPackageBtn,306,SpringLayout.NORTH, boxPanel);
        addPackageBtn.setPreferredSize(new Dimension(150, 50));
        boxPanel.add(addPackageBtn);      
        addPanel.add(boxPanel);
        addPanel.revalidate();
        addPanel.repaint(); 
        boxPanel.setVisible(false);
        envelopePanel.setVisible(false);
        cratePanel.setVisible(false);
        drumPanel.setVisible(false);
        boxPanel.setVisible(true);
        
        addPackageBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){	
                
		logger.log(Level.INFO, "User Request: Add Box to Database");
                
                if (tnField.getText().length() != 5) {
                    JOptionPane.showMessageDialog(addPanel, "Tracking Number must be 5 characters long");
			logger.log(Level.INFO, "User message: Tracking Number must be 5 characters long");
                }
                else if (ss.packageExists(tnField.getText())) {
                    JOptionPane.showMessageDialog(addPanel, "Tracking Number already exist");
                        logger.log(Level.INFO, "User message: Tracking Number already exist");
                }
                else if (!isInteger(maxDimField.getText()) && box.isSelected()) {
                    JOptionPane.showMessageDialog(addPanel, "Largest Dimension must be a number");
			logger.log(Level.INFO, "User message: Largest Dimension must be a number");
                }
                else if (!isInteger(volumeField.getText()) && box.isSelected()) {
                    JOptionPane.showMessageDialog(addPanel, "Volume must be a number");
			logger.log(Level.INFO, "User message: Volume must be a number");
                }
                else {               
                    ss.addBox(tnField.getText(), packageSpec.getSelectedItem().toString().replace(" ", ""),
                    packageClass.getSelectedItem().toString().replace(" ", ""), 
                    Integer.parseInt(maxDimField.getText()), Integer.parseInt(volumeField.getText()));
        
                    tnField.setText("");
                    diamField.setText("");
                    maxDimField.setText("");
        
                    JOptionPane.showMessageDialog(boxPanel, "Box added to the Database!");
                        logger.log(Level.INFO, "User message: Box added to the Database");
                }
            }
        }); 
    }
    
    /*
    * Displays new JPanel inside of add new package panel when crate
    * radio button is selected.
    */         
    private void crateMenu() {
            
        cratePanel.setLayout(crateLayout);
        cratePanel.setPreferredSize(new Dimension(800,640));

        crateLayout.putConstraint(SpringLayout.WEST, ptn,5,SpringLayout.WEST, cratePanel);
        crateLayout.putConstraint(SpringLayout.NORTH, ptn,100,SpringLayout.NORTH, cratePanel);
        cratePanel.add(ptn);
        crateLayout.putConstraint(SpringLayout.WEST, tnField,170,SpringLayout.WEST, cratePanel);
        crateLayout.putConstraint(SpringLayout.NORTH, tnField,96,SpringLayout.NORTH, cratePanel);
        cratePanel.add(tnField);
        
        crateLayout.putConstraint(SpringLayout.WEST, specification,5,SpringLayout.WEST, cratePanel);
        crateLayout.putConstraint(SpringLayout.NORTH, specification,140,SpringLayout.NORTH, cratePanel);
        cratePanel.add(specification);
        crateLayout.putConstraint(SpringLayout.WEST, packageSpec,170,SpringLayout.WEST, cratePanel);
        crateLayout.putConstraint(SpringLayout.NORTH, packageSpec,136,SpringLayout.NORTH, cratePanel);
        cratePanel.add(packageSpec);
        
        crateLayout.putConstraint(SpringLayout.WEST, mailingClass,5,SpringLayout.WEST, cratePanel);
        crateLayout.putConstraint(SpringLayout.NORTH, mailingClass,180,SpringLayout.NORTH, cratePanel);
        cratePanel.add(mailingClass);
        crateLayout.putConstraint(SpringLayout.WEST, packageClass,170,SpringLayout.WEST, cratePanel);
        crateLayout.putConstraint(SpringLayout.NORTH, packageClass,176,SpringLayout.NORTH, cratePanel);
        cratePanel.add(packageClass);
        
        crateLayout.putConstraint(SpringLayout.WEST, maxLoad,5,SpringLayout.WEST, cratePanel);
        crateLayout.putConstraint(SpringLayout.NORTH, maxLoad,220,SpringLayout.NORTH, cratePanel);
        cratePanel.add(maxLoad);
        crateLayout.putConstraint(SpringLayout.WEST, maxLoadField,170,SpringLayout.WEST, cratePanel);
        crateLayout.putConstraint(SpringLayout.NORTH, maxLoadField,216,SpringLayout.NORTH, cratePanel);
        cratePanel.add(maxLoadField);
        
        crateLayout.putConstraint(SpringLayout.WEST, content,5,SpringLayout.WEST, cratePanel);
        crateLayout.putConstraint(SpringLayout.NORTH, content,260,SpringLayout.NORTH, cratePanel);
        cratePanel.add(content);
        crateLayout.putConstraint(SpringLayout.WEST, contentField,170,SpringLayout.WEST, cratePanel);
        crateLayout.putConstraint(SpringLayout.NORTH, contentField,256,SpringLayout.NORTH, cratePanel);
        cratePanel.add(contentField);
        
        crateLayout.putConstraint(SpringLayout.WEST, addPackageBtn,80,SpringLayout.WEST, cratePanel);
        crateLayout.putConstraint(SpringLayout.NORTH, addPackageBtn,306,SpringLayout.NORTH, cratePanel);
        addPackageBtn.setPreferredSize(new Dimension(150, 50));
        cratePanel.add(addPackageBtn);      
        addPanel.add(cratePanel);
        addPanel.revalidate();
        addPanel.repaint();  
        cratePanel.setVisible(false);
        boxPanel.setVisible(false);
        envelopePanel.setVisible(false);
        drumPanel.setVisible(false);
        cratePanel.setVisible(true);
        
        addPackageBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){			
		logger.log(Level.INFO, "User Request: Add Crate to Database");
                
                if (tnField.getText().length() != 5) {
                    JOptionPane.showMessageDialog(addPanel, "Tracking Number must be 5 characters long");
			logger.log(Level.INFO, "User message: Tracking Number must be 5 characters long");
                }
                else if (ss.packageExists(tnField.getText())) {
                    JOptionPane.showMessageDialog(addPanel, "Tracking Number already exist");
                        logger.log(Level.INFO, "User message: Tracking Number already exist");
                }
                else if (!isFloat(maxLoadField.getText()) && crate.isSelected()) {
                    JOptionPane.showMessageDialog(addPanel, "Maximum Load must be a number");
			logger.log(Level.INFO, "User message: Maximum Load must be a number");
                }
                else {
                    ss.addCrate(tnField.getText(), packageSpec.getSelectedItem().toString().replace(" ", ""),
                    packageClass.getSelectedItem().toString().replace(" ", ""), 
                    Float.parseFloat(maxLoadField.getText()), contentField.getText());
        
                    tnField.setText("");
                    maxLoadField.setText("");
                    contentField.setText("");
        
                    JOptionPane.showMessageDialog(envelopePanel, "Crate added to the Database!");
                        logger.log(Level.INFO, "User message: Crate added to the Database");
                }
            }
        });                   
    }
    
    /*
    * Displays new JPanel inside of add new package panel when drum
    * radio button is selected.
    */         
    private void drumMenu() {
            
        drumPanel.setLayout(drumLayout);
        drumPanel.setPreferredSize(new Dimension(800,640));

        drumLayout.putConstraint(SpringLayout.WEST, ptn,5,SpringLayout.WEST, drumPanel);
        drumLayout.putConstraint(SpringLayout.NORTH, ptn,100,SpringLayout.NORTH, drumPanel);
        drumPanel.add(ptn);
        drumLayout.putConstraint(SpringLayout.WEST, tnField,170,SpringLayout.WEST, drumPanel);
        drumLayout.putConstraint(SpringLayout.NORTH, tnField,96,SpringLayout.NORTH, drumPanel);
        drumPanel.add(tnField);
        
        drumLayout.putConstraint(SpringLayout.WEST, specification,5,SpringLayout.WEST, drumPanel);
        drumLayout.putConstraint(SpringLayout.NORTH, specification,140,SpringLayout.NORTH, drumPanel);
        drumPanel.add(specification);
        drumLayout.putConstraint(SpringLayout.WEST, packageSpec,170,SpringLayout.WEST, drumPanel);
        drumLayout.putConstraint(SpringLayout.NORTH, packageSpec,136,SpringLayout.NORTH, drumPanel);
        drumPanel.add(packageSpec);
        
        drumLayout.putConstraint(SpringLayout.WEST, mailingClass,5,SpringLayout.WEST, drumPanel);
        drumLayout.putConstraint(SpringLayout.NORTH, mailingClass,180,SpringLayout.NORTH, drumPanel);
        drumPanel.add(mailingClass);
        drumLayout.putConstraint(SpringLayout.WEST, packageClass,170,SpringLayout.WEST, drumPanel);
        drumLayout.putConstraint(SpringLayout.NORTH, packageClass,176,SpringLayout.NORTH, drumPanel);
        drumPanel.add(packageClass);
        
        drumLayout.putConstraint(SpringLayout.WEST, material,5,SpringLayout.WEST, drumPanel);
        drumLayout.putConstraint(SpringLayout.NORTH, material,220,SpringLayout.NORTH, drumPanel);
        drumPanel.add(material);
        drumLayout.putConstraint(SpringLayout.WEST, drumMaterial,170,SpringLayout.WEST, drumPanel);
        drumLayout.putConstraint(SpringLayout.NORTH, drumMaterial,216,SpringLayout.NORTH, drumPanel);
        drumPanel.add(drumMaterial);
        
        drumLayout.putConstraint(SpringLayout.WEST, diameter,5,SpringLayout.WEST, drumPanel);
        drumLayout.putConstraint(SpringLayout.NORTH, diameter,260,SpringLayout.NORTH, drumPanel);
        drumPanel.add(diameter);
        drumLayout.putConstraint(SpringLayout.WEST, diamField,170,SpringLayout.WEST, drumPanel);
        drumLayout.putConstraint(SpringLayout.NORTH, diamField,256,SpringLayout.NORTH, drumPanel);
        drumPanel.add(diamField);
        
        drumLayout.putConstraint(SpringLayout.WEST, addPackageBtn,80,SpringLayout.WEST, drumPanel);
        drumLayout.putConstraint(SpringLayout.NORTH, addPackageBtn,306,SpringLayout.NORTH, drumPanel);
        addPackageBtn.setPreferredSize(new Dimension(150, 50));
        drumPanel.add(addPackageBtn);     
        addPanel.add(drumPanel);
        addPanel.revalidate();
        addPanel.repaint();
        drumPanel.setVisible(false);
        boxPanel.setVisible(false);
        cratePanel.setVisible(false);
        envelopePanel.setVisible(false);
        drumPanel.setVisible(true);
        
        addPackageBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){			
		logger.log(Level.INFO, "User Request: Add Drum to Database");
                
                if (tnField.getText().length() != 5) {
                    JOptionPane.showMessageDialog(addPanel, "Tracking Number must be 5 characters long");
			logger.log(Level.INFO, "User message: Tracking Number must be 5 characters long");
                }
                else if (ss.packageExists(tnField.getText())) {
                    JOptionPane.showMessageDialog(addPanel, "Tracking Number already exist");
                        logger.log(Level.INFO, "User message: Tracking Number already exist");
                }
                else if (!isFloat(diamField.getText()) && drum.isSelected()) {
                    JOptionPane.showMessageDialog(addPanel, "Diameter must be a number");
			logger.log(Level.INFO, "User message: Diameter must be a number");
                }
                else {                                                    
                    ss.addDrum(tnField.getText(), packageSpec.getSelectedItem().toString().replace(" ", ""),
                    packageClass.getSelectedItem().toString().replace(" ", ""),
                    drumMaterial.getSelectedItem().toString().replace(" ", ""),
                    Float.parseFloat(diamField.getText()));
        
                    tnField.setText("");
                    diamField.setText("");
       
                    JOptionPane.showMessageDialog(envelopePanel, "Drum added to the Database!");
                        logger.log(Level.INFO, "User message: Drum added to the Database");
                }
            }
        });            
    }
   
   /*
    * Creates new JPanel with a TextArea that displays the package database.
    */
   private void showAllPackages() {
        
        showPackagesPanel.setLayout(showPackLayout);
        layout.putConstraint(SpringLayout.WEST, showPackagesPanel,0,SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, showPackagesPanel,120,SpringLayout.NORTH, mainPanel);
        showPackagesPanel.setPreferredSize(new Dimension(900,640));
        showPackagesPanel.setBackground(Color.RED);              
        showPackLayout.putConstraint(SpringLayout.WEST, showPackagesArea,0,SpringLayout.WEST, showPackagesPanel);
        showPackLayout.putConstraint(SpringLayout.NORTH, showPackagesArea,0,SpringLayout.NORTH, showPackagesPanel);
        showPackagesArea.setText(ss.getAllPackagesFormatted());
        showPackagesPanel.add(showPackagesArea);     
        mainPanel.add(showPackagesPanel);     
    } 
    
    private void deletePackage() {
    
        TitledBorder deletedPackage = BorderFactory.createTitledBorder("Delete Package");
        deletePackPanel.setBorder(deletedPackage);
        deletePackPanel.setLayout(deletePackLayout);
        layout.putConstraint(SpringLayout.WEST, deletePackPanel,0,SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, deletePackPanel,120,SpringLayout.NORTH, mainPanel);
        deletePackPanel.setPreferredSize(new Dimension(500,300));
        
        deletePackLayout.putConstraint(SpringLayout.WEST, delete,5,SpringLayout.WEST, deletePackPanel);
        deletePackLayout.putConstraint(SpringLayout.NORTH, delete,50,SpringLayout.NORTH, deletePackPanel);
        deletePackPanel.add(delete);
        deletePackLayout.putConstraint(SpringLayout.WEST, deletePackField,170,SpringLayout.WEST, deletePackPanel);
        deletePackLayout.putConstraint(SpringLayout.NORTH, deletePackField,46,SpringLayout.NORTH, deletePackPanel);
        deletePackPanel.add(deletePackField);
        deletePackLayout.putConstraint(SpringLayout.WEST, deletePackButton,110,SpringLayout.WEST, deletePackPanel);
        deletePackLayout.putConstraint(SpringLayout.NORTH, deletePackButton,100,SpringLayout.NORTH, deletePackPanel);
        deletePackButton.setPreferredSize(new Dimension(150,50));
        deletePackPanel.add(deletePackButton);   
        mainPanel.add(deletePackPanel);
        
        deletePackButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){	
        
            if (ss.deletePackage(deletePackField.getText())) {
                JOptionPane.showMessageDialog(deletePackPanel, "Package Deleted!");
                    logger.log(Level.INFO, "User message: Package deleted from Database");
            }     
            else {
                JOptionPane.showMessageDialog(deletePackPanel, "Package with given tracking number not found in the database.");
                    logger.log(Level.INFO, "User message: Package not found in Database");
            }          
        }
    });
}
    /*
    * Creates a new JPanel used to search for a package in the database.
    */
    private void searchPackage() {
        
        TitledBorder searchPackage = BorderFactory.createTitledBorder("Search Package");
        searchPackPanel.setBorder(searchPackage);
        searchPackPanel.setLayout(searchPackLayout);
        layout.putConstraint(SpringLayout.WEST, searchPackPanel,0,SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, searchPackPanel,120,SpringLayout.NORTH, mainPanel);
        searchPackPanel.setPreferredSize(new Dimension(900,500));
        
        searchPackLayout.putConstraint(SpringLayout.WEST, search,5,SpringLayout.WEST, searchPackPanel);
        searchPackLayout.putConstraint(SpringLayout.NORTH, search,50,SpringLayout.NORTH, searchPackPanel);
        searchPackPanel.add(search);
        searchPackLayout.putConstraint(SpringLayout.WEST, searchPackField,170,SpringLayout.WEST, searchPackPanel);
        searchPackLayout.putConstraint(SpringLayout.NORTH, searchPackField,46,SpringLayout.NORTH, searchPackPanel);
        searchPackPanel.add(searchPackField);
        searchPackLayout.putConstraint(SpringLayout.WEST, searchPackButton,400,SpringLayout.WEST, searchPackPanel);
        searchPackLayout.putConstraint(SpringLayout.NORTH, searchPackButton,35,SpringLayout.NORTH, searchPackPanel);
        searchPackButton.setPreferredSize(new Dimension(150,50));
        searchPackPanel.add(searchPackButton);
        searchPackLayout.putConstraint(SpringLayout.WEST, searchPackagesArea,0,SpringLayout.WEST, searchPackPanel);
        searchPackLayout.putConstraint(SpringLayout.NORTH, searchPackagesArea,100,SpringLayout.NORTH, searchPackPanel);
        searchPackPanel.add(searchPackagesArea);
        mainPanel.add(searchPackPanel);
        
        searchPackButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){	
        
            if (ss.packageExists(searchPackField.getText())) {
                searchPackagesArea.setText(ss.getPackageFormatted(searchPackField.getText()));
                    logger.log(Level.INFO, "User message: Package found in Database");
            }
            else {
                JOptionPane.showMessageDialog(deletePackPanel, "Package with tracking number " + searchPackField.getText() +
                " not found in database.");
                    logger.log(Level.INFO, "User message: Package not found in Database");
            }
        }
    });        
}
    
    /*
    * Creates a new JPanel with a TextArea for displaying all users in the database.
    */
    private void showAllUsers() {
        
        showUserPanel.setLayout(showUsersLayout);
        layout.putConstraint(SpringLayout.WEST, showUserPanel,0,SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, showUserPanel,120,SpringLayout.NORTH, mainPanel);
        showUserPanel.setPreferredSize(new Dimension(900,640));
        showUserPanel.setBackground(Color.RED);              
        showUsersLayout.putConstraint(SpringLayout.WEST, showUsersArea,0,SpringLayout.WEST, showUserPanel);
        showUsersLayout.putConstraint(SpringLayout.NORTH, showUsersArea,0,SpringLayout.NORTH, showUserPanel);
        showUsersArea.setText(ss.getAllUsersFormatted());
        showUserPanel.add(showUsersArea);     
        mainPanel.add(showUserPanel);            
    }
    
    /*
    * Creates a new JPanel for adding new users to the database.
    */
    public void addNewUser() {
        
        TitledBorder userPanel = BorderFactory.createTitledBorder("");
        layout.putConstraint(SpringLayout.WEST, addUserPanel,0,SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, addUserPanel,120,SpringLayout.NORTH, mainPanel);
        addUserPanel.setPreferredSize(new Dimension(900,640));

        TitledBorder userType = BorderFactory.createTitledBorder("Select user type");
        addUserPanel.setLayout(addUserLayout);
        addUserLayout.putConstraint(SpringLayout.WEST, typeOfUserPanel,5,SpringLayout.WEST, addUserPanel);
        addUserLayout.putConstraint(SpringLayout.NORTH, typeOfUserPanel,5,SpringLayout.NORTH, addUserPanel);
        typeOfUserPanel.setPreferredSize(new Dimension(400,75));
        
        buttons2 = new ButtonGroup();
        buttons2.add(customer);
        buttons2.add(employee);        
                        
        typeOfUserPanel.add(customer);
        typeOfUserPanel.add(employee);
        addUserPanel.add(typeOfUserPanel);               
        addUserPanel.setBorder(userPanel);
        typeOfUserPanel.setBorder(userType);
        mainPanel.add(addUserPanel);
        
        customer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){                               
		customerMenu();
                    logger.log(Level.INFO, "User Request: Select Customer user type in add new user screen");
            }
	});	
        
	employee.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){	
		employeeMenu();	
                    logger.log(Level.INFO, "User Request: Select Employee user type in add new user screen");				
            }
	});       
    }
    
    public boolean validPhoneNumber(String phoneNum) {
			
        if (phoneNum.matches("\\d{10}")) 
            return true;	
        else if(phoneNum.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) 
            return true;        
        else if(phoneNum.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) 
            return true;
        else 
            return false;
    }
    
    /*
    * Creates a new JPanel inside of the add new user JPanel when the customer
    * radio button is selected.
    */
    public void customerMenu() {
        
        customerPanel.setLayout(customerLayout);
        customerPanel.setPreferredSize(new Dimension(800,640));
        
        customerLayout.putConstraint(SpringLayout.WEST, firstName,5,SpringLayout.WEST, customerPanel);
        customerLayout.putConstraint(SpringLayout.NORTH, firstName,100,SpringLayout.NORTH, customerPanel);
        customerPanel.add(firstName);
        customerLayout.putConstraint(SpringLayout.WEST, firstField,170,SpringLayout.WEST, customerPanel);
        customerLayout.putConstraint(SpringLayout.NORTH, firstField,96,SpringLayout.NORTH, customerPanel);
        customerPanel.add(firstField);
        
        customerLayout.putConstraint(SpringLayout.WEST, lastName,5,SpringLayout.WEST, customerPanel);
        customerLayout.putConstraint(SpringLayout.NORTH, lastName,140,SpringLayout.NORTH, customerPanel);
        customerPanel.add(lastName);
        customerLayout.putConstraint(SpringLayout.WEST, lastField,170,SpringLayout.WEST, customerPanel);
        customerLayout.putConstraint(SpringLayout.NORTH, lastField,136,SpringLayout.NORTH, customerPanel);
        customerPanel.add(lastField);
        
        customerLayout.putConstraint(SpringLayout.WEST, phoneNumber,5,SpringLayout.WEST, customerPanel);
        customerLayout.putConstraint(SpringLayout.NORTH, phoneNumber,180,SpringLayout.NORTH, customerPanel);
        customerPanel.add(phoneNumber);
        customerLayout.putConstraint(SpringLayout.WEST, numberField,170,SpringLayout.WEST, customerPanel);
        customerLayout.putConstraint(SpringLayout.NORTH, numberField,176,SpringLayout.NORTH, customerPanel);
        customerPanel.add(numberField);
            
        customerLayout.putConstraint(SpringLayout.WEST, address,5,SpringLayout.WEST, customerPanel);
        customerLayout.putConstraint(SpringLayout.NORTH, address,220,SpringLayout.NORTH, customerPanel);
        customerPanel.add(address);
        customerLayout.putConstraint(SpringLayout.WEST, addressField,170,SpringLayout.WEST, customerPanel);
        customerLayout.putConstraint(SpringLayout.NORTH, addressField,216,SpringLayout.NORTH, customerPanel);
        customerPanel.add(addressField);
               
        customerLayout.putConstraint(SpringLayout.WEST, addCustomerButton,80,SpringLayout.WEST, customerPanel);
        customerLayout.putConstraint(SpringLayout.NORTH, addCustomerButton,306,SpringLayout.NORTH, customerPanel);
        addCustomerButton.setPreferredSize(new Dimension(150, 50));
        customerPanel.add(addCustomerButton);  
               
        addUserPanel.add(customerPanel);
        addUserPanel.revalidate();
        addUserPanel.repaint();
        customerPanel.setVisible(false);
        employeePanel.setVisible(false);
        customerPanel.setVisible(true);
        
        addCustomerButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){	
                
		logger.log(Level.INFO, "User Request: Add customer to database");
                
                if (firstField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(addUserPanel, "Enter First Name");
                        logger.log(Level.INFO, "Message Sent to User: Enter First Name");
		}
		else if (lastField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(addUserPanel, "Enter Last Name");
                        logger.log(Level.INFO, "Message Sent to User: Enter Last Name");
		}
		else if (numberField.getText().isEmpty() && customer.isSelected()) {
                    JOptionPane.showMessageDialog(addUserPanel, "Enter Valid Phone Number");
                        logger.log(Level.INFO, "Message Sent to User: Enter Valid Phone Number");
		}
		else if (!validPhoneNumber(numberField.getText()) && customer.isSelected()) {
                    JOptionPane.showMessageDialog(addUserPanel, "Enter Valid Phone Number");
                        logger.log(Level.INFO, "Message Sent to User: Enter Valid Phone Number");
		}							
		else if (addressField.getText().isEmpty() && customer.isSelected()) {
                    JOptionPane.showMessageDialog(addUserPanel, "Enter Address");
                        logger.log(Level.INFO, "Message Sent to User: Enter Address");
                }
                else {                   
                    ss.addCustomer(firstField.getText(), lastField.getText(),
                    numberField.getText(), addressField.getText());
                }
                firstField.setText("");
		lastField.setText("");
		numberField.setText("");
		addressField.setText("");
                
                JOptionPane.showMessageDialog(addUserPanel, "Customer added to the Database!");
                    logger.log(Level.INFO, "User message: Customer added to the Database!");
            }                  
        });           
    }
    
    /*
    * Creates a new JPanel inside of the add new user JPanel when the employee
    * radio button is selected.
    */
    private void employeeMenu() {
        
        employeePanel.setLayout(employeeLayout);
        employeePanel.setPreferredSize(new Dimension(800,640));
        
        employeeLayout.putConstraint(SpringLayout.WEST, firstName,5,SpringLayout.WEST, employeePanel);
        employeeLayout.putConstraint(SpringLayout.NORTH, firstName,100,SpringLayout.NORTH, employeePanel);
        employeePanel.add(firstName);
        employeeLayout.putConstraint(SpringLayout.WEST, firstField,170,SpringLayout.WEST, employeePanel);
        employeeLayout.putConstraint(SpringLayout.NORTH, firstField,96,SpringLayout.NORTH, employeePanel);
        employeePanel.add(firstField);
        
        employeeLayout.putConstraint(SpringLayout.WEST, lastName,5,SpringLayout.WEST, employeePanel);
        employeeLayout.putConstraint(SpringLayout.NORTH, lastName,140,SpringLayout.NORTH, employeePanel);
        employeePanel.add(lastName);
        employeeLayout.putConstraint(SpringLayout.WEST, lastField,170,SpringLayout.WEST, employeePanel);
        employeeLayout.putConstraint(SpringLayout.NORTH, lastField,136,SpringLayout.NORTH, employeePanel);
        employeePanel.add(lastField);
        
        employeeLayout.putConstraint(SpringLayout.WEST, phoneNumber,5,SpringLayout.WEST, employeePanel);
        employeeLayout.putConstraint(SpringLayout.NORTH, phoneNumber,180,SpringLayout.NORTH, employeePanel);
        employeePanel.add(phoneNumber);
        employeeLayout.putConstraint(SpringLayout.WEST, numberField,170,SpringLayout.WEST, employeePanel);
        employeeLayout.putConstraint(SpringLayout.NORTH, numberField,176,SpringLayout.NORTH, employeePanel);
        employeePanel.add(numberField);
            
        employeeLayout.putConstraint(SpringLayout.WEST, address,5,SpringLayout.WEST, employeePanel);
        employeeLayout.putConstraint(SpringLayout.NORTH, address,220,SpringLayout.NORTH, employeePanel);
        employeePanel.add(address);
        employeeLayout.putConstraint(SpringLayout.WEST, addressField,170,SpringLayout.WEST, employeePanel);
        employeeLayout.putConstraint(SpringLayout.NORTH, addressField,216,SpringLayout.NORTH, employeePanel);
        employeePanel.add(addressField);
        
        employeeLayout.putConstraint(SpringLayout.WEST, salary,5,SpringLayout.WEST, employeePanel);
        employeeLayout.putConstraint(SpringLayout.NORTH, salary,260,SpringLayout.NORTH, employeePanel);
        employeePanel.add(salary);
        employeeLayout.putConstraint(SpringLayout.WEST, salaryField,170,SpringLayout.WEST, employeePanel);
        employeeLayout.putConstraint(SpringLayout.NORTH, salaryField,256,SpringLayout.NORTH, employeePanel);
        employeePanel.add(salaryField);
        
        employeeLayout.putConstraint(SpringLayout.WEST, ssn,5,SpringLayout.WEST, employeePanel);
        employeeLayout.putConstraint(SpringLayout.NORTH, ssn,300,SpringLayout.NORTH, employeePanel);
        employeePanel.add(ssn);
        employeeLayout.putConstraint(SpringLayout.WEST, ssnField,170,SpringLayout.WEST, employeePanel);
        employeeLayout.putConstraint(SpringLayout.NORTH, ssnField,296,SpringLayout.NORTH, employeePanel);
        employeePanel.add(ssnField);
        
        employeeLayout.putConstraint(SpringLayout.WEST, accountNumber,5,SpringLayout.WEST, employeePanel);
        employeeLayout.putConstraint(SpringLayout.NORTH, accountNumber,340,SpringLayout.NORTH, employeePanel);
        employeePanel.add(accountNumber);
        employeeLayout.putConstraint(SpringLayout.WEST, accountNumField,170,SpringLayout.WEST, employeePanel);
        employeeLayout.putConstraint(SpringLayout.NORTH, accountNumField,336,SpringLayout.NORTH, employeePanel);
        employeePanel.add(accountNumField);
               
        employeeLayout.putConstraint(SpringLayout.WEST, addEmployeeButton,80,SpringLayout.WEST, employeePanel);
        employeeLayout.putConstraint(SpringLayout.NORTH, addEmployeeButton,400,SpringLayout.NORTH, employeePanel);
        addEmployeeButton.setPreferredSize(new Dimension(150, 50));
        employeePanel.add(addEmployeeButton);  
               
        addUserPanel.add(employeePanel);
        addUserPanel.revalidate();
        addUserPanel.repaint();
        employeePanel.setVisible(false);
        customerPanel.setVisible(false);
        employeePanel.setVisible(true);
        
        addEmployeeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){	
                
		logger.log(Level.INFO, "User Request: Add employee to database");
                
                if (firstField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(addUserPanel, "Enter First Name");
                        logger.log(Level.INFO, "Message Sent to User: Enter First Name");
		}
		else if (lastField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(addUserPanel, "Enter Last Name");
                        logger.log(Level.INFO, "Message Sent to User: Enter Last Name");
		}
                else if (!isInteger(ssnField.getText()) && employee.isSelected()) {
                    JOptionPane.showMessageDialog(addUserPanel, "Enter Valid SSN");
			logger.log(Level.INFO, "Message Sent to User: Enter Valid SSN");
		}
                else if (ssnField.getText().length() != 9) {
                    JOptionPane.showMessageDialog(updateUserPanel, "SSN must be 9 digits");
                        logger.log(Level.INFO, "User message: SSN must be 9 digits");                
                }
                else if (Integer.parseInt(ssnField.getText()) < 10000000 || Integer.parseInt(ssnField.getText()) > 999999999) {
                    JOptionPane.showMessageDialog(updateUserPanel, "SSN not in range");
                        logger.log(Level.INFO, "User message: SSN not in range");             
                }
		else if (!isFloat(updateSalaryField.getText()) && employee2.isSelected()) {
                    JOptionPane.showMessageDialog(updateUserPanel, "Enter Valid Monthly Salary");
			logger.log(Level.INFO, "User message: Enter Valid Monthly Salary");
                }
                else if (Float.parseFloat(salaryField.getText()) < 0.0f) {
                    JOptionPane.showMessageDialog(updateUserPanel, "Salary cannot be less than zero");
			logger.log(Level.INFO, "User message: Salary cannot be less than zero");
		}
		else if (!isFloat(salaryField.getText()) && employee.isSelected()) {
                    JOptionPane.showMessageDialog(addUserPanel, "Enter Valid Monthly Salary");
			logger.log(Level.INFO, "Message Sent to User: Enter Valid Monthly Salary");
		}
		else if (!isInteger(accountNumField.getText()) && employee.isSelected()) {
                    JOptionPane.showMessageDialog(addUserPanel, "Enter Bank Account");
			logger.log(Level.INFO, "Message Sent to User: Enter Bank Account");
		}
                else if (accountNumField.getText().length() < 0) {
                    JOptionPane.showMessageDialog(updateUserPanel, "Account number cannot be less than zero");
			logger.log(Level.INFO, "User message: Account number cannot be less than zero");
                }
                else {
                    ss.addEmployee(firstField.getText(), lastField.getText(),
                    Integer.parseInt(ssnField.getText()), Float.parseFloat(salaryField.getText()),
                    Integer.parseInt(accountNumField.getText())) ;
                }
                firstField.setText("");
		lastField.setText("");
                numberField.setText("");
		addressField.setText("");
		ssnField.setText("");
		salaryField.setText("");
                accountNumField.setText("");
                
                JOptionPane.showMessageDialog(addUserPanel, "Empoloyee added to the Database!");
                    logger.log(Level.INFO, "User message: Employee added to the Database!");
            }
        });
    }
    
    /*
    * Creates a new JPanel used for updating exisiting users in the database.
    */
    private void updateUser() {
        
        TitledBorder updatePanel = BorderFactory.createTitledBorder("");
        layout.putConstraint(SpringLayout.WEST, updateUserPanel,0,SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, updateUserPanel,120,SpringLayout.NORTH, mainPanel);
        updateUserPanel.setPreferredSize(new Dimension(900,640));

        TitledBorder updateUserType = BorderFactory.createTitledBorder("Select user type");
        updateUserPanel.setLayout(updateUserLayout);
        updateUserLayout.putConstraint(SpringLayout.WEST, typeOfUserPanel2,5,SpringLayout.WEST, updateUserPanel);
        updateUserLayout.putConstraint(SpringLayout.NORTH, typeOfUserPanel2,5,SpringLayout.NORTH, updateUserPanel);
        typeOfUserPanel2.setPreferredSize(new Dimension(400,75));
        
        buttons2 = new ButtonGroup();
        buttons2.add(customer2);
        buttons2.add(employee2);        
                        
        typeOfUserPanel2.add(customer2);
        typeOfUserPanel2.add(employee2);
        updateUserPanel.add(typeOfUserPanel2);
                 
        updateUserPanel.setBorder(updatePanel);
        typeOfUserPanel2.setBorder(updateUserType);
        mainPanel.add(updateUserPanel);
        
        customer2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){                               
		updateCustomerMenu();
                    logger.log(Level.INFO, "User Request: Select Customer user type to update customer");
            }
	});
		
	employee2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){	
		updateEmployeeMenu();	
                    logger.log(Level.INFO, "User Request: Select Employee user type to update employee");				
            }
	});     
    }
    
    /*
    * Creates a new JPanel inside of the update user JPanel when the customer
    * radio button is selected.
    */
    private void updateCustomerMenu() {
        
        updateCustomerPanel.setLayout(updateCustomerLayout);
        updateCustomerPanel.setPreferredSize(new Dimension(800,640));
        
        updateCustomerLayout.putConstraint(SpringLayout.WEST, updateID,5,SpringLayout.WEST, updateCustomerPanel);
        updateCustomerLayout.putConstraint(SpringLayout.NORTH, updateID,100,SpringLayout.NORTH, updateCustomerPanel);
        updateCustomerPanel.add(updateID);
        updateCustomerLayout.putConstraint(SpringLayout.WEST, updateIDField,170,SpringLayout.WEST, updateCustomerPanel);
        updateCustomerLayout.putConstraint(SpringLayout.NORTH, updateIDField,96,SpringLayout.NORTH, updateCustomerPanel);
        updateCustomerPanel.add(updateIDField);
        
        updateCustomerLayout.putConstraint(SpringLayout.WEST, updateFirstName,5,SpringLayout.WEST, updateCustomerPanel);
        updateCustomerLayout.putConstraint(SpringLayout.NORTH, updateFirstName,140,SpringLayout.NORTH, updateCustomerPanel);
        updateCustomerPanel.add(updateFirstName);
        updateCustomerLayout.putConstraint(SpringLayout.WEST, updateFirstField,170,SpringLayout.WEST, updateCustomerPanel);
        updateCustomerLayout.putConstraint(SpringLayout.NORTH, updateFirstField,136,SpringLayout.NORTH, updateCustomerPanel);
        updateCustomerPanel.add(updateFirstField);
        
        updateCustomerLayout.putConstraint(SpringLayout.WEST, updateLastName,5,SpringLayout.WEST, updateCustomerPanel);
        updateCustomerLayout.putConstraint(SpringLayout.NORTH, updateLastName,180,SpringLayout.NORTH, updateCustomerPanel);
        updateCustomerPanel.add(updateLastName);
        updateCustomerLayout.putConstraint(SpringLayout.WEST, updateLastField,170,SpringLayout.WEST, updateCustomerPanel);
        updateCustomerLayout.putConstraint(SpringLayout.NORTH, updateLastField,176,SpringLayout.NORTH, updateCustomerPanel);
        updateCustomerPanel.add(updateLastField);
        
        updateCustomerLayout.putConstraint(SpringLayout.WEST, updatePhoneNumber,5,SpringLayout.WEST, updateCustomerPanel);
        updateCustomerLayout.putConstraint(SpringLayout.NORTH, updatePhoneNumber,220,SpringLayout.NORTH, updateCustomerPanel);
        updateCustomerPanel.add(updatePhoneNumber);
        updateCustomerLayout.putConstraint(SpringLayout.WEST, updateNumberField,170,SpringLayout.WEST, updateCustomerPanel);
        updateCustomerLayout.putConstraint(SpringLayout.NORTH, updateNumberField,216,SpringLayout.NORTH, updateCustomerPanel);
        updateCustomerPanel.add(updateNumberField);
            
        updateCustomerLayout.putConstraint(SpringLayout.WEST, updateAddress,5,SpringLayout.WEST, updateCustomerPanel);
        updateCustomerLayout.putConstraint(SpringLayout.NORTH, updateAddress,260,SpringLayout.NORTH, updateCustomerPanel);
        updateCustomerPanel.add(updateAddress);
        updateCustomerLayout.putConstraint(SpringLayout.WEST, updateAddressField,170,SpringLayout.WEST, updateCustomerPanel);
        updateCustomerLayout.putConstraint(SpringLayout.NORTH, updateAddressField,256,SpringLayout.NORTH, updateCustomerPanel);
        updateCustomerPanel.add(updateAddressField);
               
        updateCustomerLayout.putConstraint(SpringLayout.WEST, updateCustomerButton,80,SpringLayout.WEST, updateCustomerPanel);
        updateCustomerLayout.putConstraint(SpringLayout.NORTH, updateCustomerButton,330,SpringLayout.NORTH, updateCustomerPanel);
        updateCustomerButton.setPreferredSize(new Dimension(150, 50));
        updateCustomerPanel.add(updateCustomerButton);  
               
        updateUserPanel.add(updateCustomerPanel);
        updateUserPanel.revalidate();
        updateUserPanel.repaint();
        updateCustomerPanel.setVisible(false);
        updateEmployeePanel.setVisible(false);
        updateCustomerPanel.setVisible(true);
        
        updateCustomerButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){	
                
		logger.log(Level.INFO, "User Request: Update customer in database");
                
                if (updateFirstField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(updateUserPanel, "Enter First Name");
                        logger.log(Level.INFO, "User message: Enter First Name");
		}
		else if (updateLastField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(updateUserPanel, "Enter Last Name");
                        logger.log(Level.INFO, "User message: Enter Last Name");
		}
		else if (updateNumberField.getText().isEmpty() && customer2.isSelected()) {
                    JOptionPane.showMessageDialog(updateUserPanel, "Enter Valid Phone Number");
                        logger.log(Level.INFO, "User message: Enter Valid Phone Number");
		}
		else if (!validPhoneNumber(updateNumberField.getText()) && customer2.isSelected()) {
                    JOptionPane.showMessageDialog(updateUserPanel, "Enter Valid Phone Number");
                        logger.log(Level.INFO, "User message: Enter Valid Phone Number");
		}							
		else if (updateAddressField.getText().isEmpty() && customer2.isSelected()) {
                    JOptionPane.showMessageDialog(updateUserPanel, "Enter Address");
                        logger.log(Level.INFO, "User message: Enter Address");
                }
                else {                   
                    ss.updateCustomer(Integer.parseInt(updateIDField.getText()),
                    updateFirstField.getText(), updateLastField.getText(),
                    updateNumberField.getText(), updateAddressField.getText());
                }
                updateIDField.setText("");
                updateFirstField.setText("");
		updateLastField.setText("");
		updateNumberField.setText("");
		updateAddressField.setText("");
                
                JOptionPane.showMessageDialog(updateUserPanel, "Customer updated in Database!");
                    logger.log(Level.INFO, "Message Sent to User: Customer updated in Database!");
            }                
        });           
    }
    
    /*
    * Creates a new JPanel inside of the update user JPanel when the employee
    * radio button is selected.
    */
    private void updateEmployeeMenu() {
        
        updateEmployeePanel.setLayout(updateEmployeeLayout);
        updateEmployeePanel.setPreferredSize(new Dimension(800,640));
        
        updateEmployeeLayout.putConstraint(SpringLayout.WEST, updateID,5,SpringLayout.WEST, updateEmployeePanel);
        updateEmployeeLayout.putConstraint(SpringLayout.NORTH, updateID,100,SpringLayout.NORTH, updateEmployeePanel);
        updateEmployeePanel.add(updateID);
        updateEmployeeLayout.putConstraint(SpringLayout.WEST, updateIDField,170,SpringLayout.WEST, updateEmployeePanel);
        updateEmployeeLayout.putConstraint(SpringLayout.NORTH, updateIDField,96,SpringLayout.NORTH, updateEmployeePanel);
        updateEmployeePanel.add(updateIDField);
        
        updateEmployeeLayout.putConstraint(SpringLayout.WEST, updateFirstName,5,SpringLayout.WEST, updateEmployeePanel);
        updateEmployeeLayout.putConstraint(SpringLayout.NORTH, updateFirstName,140,SpringLayout.NORTH, updateEmployeePanel);
        updateEmployeePanel.add(updateFirstName);
        updateEmployeeLayout.putConstraint(SpringLayout.WEST, updateFirstField,170,SpringLayout.WEST, updateEmployeePanel);
        updateEmployeeLayout.putConstraint(SpringLayout.NORTH, updateFirstField,136,SpringLayout.NORTH, updateEmployeePanel);
        updateEmployeePanel.add(updateFirstField);
        
        updateEmployeeLayout.putConstraint(SpringLayout.WEST, updateLastName,5,SpringLayout.WEST, updateEmployeePanel);
        updateEmployeeLayout.putConstraint(SpringLayout.NORTH, updateLastName,180,SpringLayout.NORTH, updateEmployeePanel);
        updateEmployeePanel.add(updateLastName);
        updateEmployeeLayout.putConstraint(SpringLayout.WEST, updateLastField,170,SpringLayout.WEST, updateEmployeePanel);
        updateEmployeeLayout.putConstraint(SpringLayout.NORTH, updateLastField,176,SpringLayout.NORTH, updateEmployeePanel);
        updateEmployeePanel.add(updateLastField);
        
        updateEmployeeLayout.putConstraint(SpringLayout.WEST, updateSalary,5,SpringLayout.WEST, updateEmployeePanel);
        updateEmployeeLayout.putConstraint(SpringLayout.NORTH, updateSalary,220,SpringLayout.NORTH, updateEmployeePanel);
        updateEmployeePanel.add(updateSalary);
        updateEmployeeLayout.putConstraint(SpringLayout.WEST, updateSalaryField,170,SpringLayout.WEST, updateEmployeePanel);
        updateEmployeeLayout.putConstraint(SpringLayout.NORTH, updateSalaryField,216,SpringLayout.NORTH, updateEmployeePanel);
        updateEmployeePanel.add(updateSalaryField);
            
        updateEmployeeLayout.putConstraint(SpringLayout.WEST, updateSSN,5,SpringLayout.WEST, updateEmployeePanel);
        updateEmployeeLayout.putConstraint(SpringLayout.NORTH, updateSSN,260,SpringLayout.NORTH, updateEmployeePanel);
        updateEmployeePanel.add(updateSSN);
        updateEmployeeLayout.putConstraint(SpringLayout.WEST, updateSSNField,170,SpringLayout.WEST, updateEmployeePanel);
        updateEmployeeLayout.putConstraint(SpringLayout.NORTH, updateSSNField,256,SpringLayout.NORTH, updateEmployeePanel);
        updateEmployeePanel.add(updateSSNField);        
        
        updateEmployeeLayout.putConstraint(SpringLayout.WEST, updateAccountNumber,5,SpringLayout.WEST, updateEmployeePanel);
        updateEmployeeLayout.putConstraint(SpringLayout.NORTH, updateAccountNumber,300,SpringLayout.NORTH, updateEmployeePanel);
        updateEmployeePanel.add(updateAccountNumber);
        updateEmployeeLayout.putConstraint(SpringLayout.WEST, updateAccountNumField,170,SpringLayout.WEST, updateEmployeePanel);
        updateEmployeeLayout.putConstraint(SpringLayout.NORTH, updateAccountNumField,296,SpringLayout.NORTH, updateEmployeePanel);
        updateEmployeePanel.add(updateAccountNumField);
        
        updateEmployeeLayout.putConstraint(SpringLayout.WEST, updateEmployeeButton,80,SpringLayout.WEST, updateEmployeePanel);
        updateEmployeeLayout.putConstraint(SpringLayout.NORTH, updateEmployeeButton,350,SpringLayout.NORTH, updateEmployeePanel);
        updateEmployeeButton.setPreferredSize(new Dimension(150, 50));
        updateEmployeePanel.add(updateEmployeeButton);  
               
        updateUserPanel.add(updateEmployeePanel);
        updateUserPanel.revalidate();
        updateUserPanel.repaint();
        updateCustomerPanel.setVisible(false);
        updateEmployeePanel.setVisible(false);
        updateEmployeePanel.setVisible(true);
        
        updateEmployeeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){	
                
		logger.log(Level.INFO, "User Request: Update employee in database");
                
                if (updateFirstField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(updateUserPanel, "Enter First Name");
                        logger.log(Level.INFO, "User message: Enter First Name");
		}
		else if (updateLastField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(updateUserPanel, "Enter Last Name");
                        logger.log(Level.INFO, "User message: Enter Last Name");
		}
                else if (!isInteger(updateSSNField.getText()) && employee2.isSelected()) {
                    JOptionPane.showMessageDialog(updateUserPanel, "Enter Valid SSN");
                        logger.log(Level.INFO, "User message: Enter Valid SSN");
		}
                else if (ssnField.getText().length() != 9) {
                    JOptionPane.showMessageDialog(updateUserPanel, "SSN must be 9 digits");
                        logger.log(Level.INFO, "User message: SSN must be 9 digits");                
                }
                else if (Integer.parseInt(ssnField.getText()) < 10000000 || Integer.parseInt(ssnField.getText()) > 999999999) {
                    JOptionPane.showMessageDialog(updateUserPanel, "SSN not in range");
                        logger.log(Level.INFO, "User message: SSN not in range");             
                }
		else if (!isFloat(updateSalaryField.getText()) && employee2.isSelected()) {
                    JOptionPane.showMessageDialog(updateUserPanel, "Enter Valid Monthly Salary");
			logger.log(Level.INFO, "User message: Enter Valid Monthly Salary");
                }
                else if (Float.parseFloat(salaryField.getText()) < 0.0f) {
                    JOptionPane.showMessageDialog(updateUserPanel, "Salary cannot be less than zero");
			logger.log(Level.INFO, "User message: Salary cannot be less than zero");
		}
		else if (!isInteger(updateAccountNumField.getText()) && employee2.isSelected()) {
                    JOptionPane.showMessageDialog(updateUserPanel, "Enter Bank Account");
			logger.log(Level.INFO, "User message: Enter Bank Account");
                }
                else if (accountNumField.getText().length() < 0) {
                    JOptionPane.showMessageDialog(updateUserPanel, "Account number cannot be less than zero");
			logger.log(Level.INFO, "User message: Account number cannot be less than zero");
                }	
                else {
                    ss.updateEmployee(Integer.parseInt(updateIDField.getText()),
                    updateFirstField.getText(), updateLastField.getText(),
                    Integer.parseInt(updateSSNField.getText()), Float.parseFloat(updateSalaryField.getText()),
                    Integer.parseInt(updateAccountNumField.getText()));
                }
                
                updateIDField.setText("");
		updateFirstField.setText("");
                updateLastField.setText("");
		updateSSNField.setText("");
		updateSalaryField.setText("");
		updateAccountNumField.setText("");
        
                JOptionPane.showMessageDialog(updateUserPanel, "Employee updated in the Database!");
                    logger.log(Level.INFO, "Message Sent To User: Employee updated in the Database!"); 				
            }
        });
    }
    
    public static boolean isDate(String s) {
        
        Date shippingDate = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/YYYY");		
	try {
            shippingDate = sdf.parse(s);
	} catch (ParseException e) {
            return false;
	}			
        return true;
    }	
    
    /*
    * Creates new JPanel for completing shipping transactions.
    */
    private void deliverPackage() {
        
        TitledBorder deliveredPackage = BorderFactory.createTitledBorder("Complete Transactions");
        completeTransPanel.setBorder(deliveredPackage);
        completeTransPanel.setLayout(completeTransLayout);
        layout.putConstraint(SpringLayout.WEST, completeTransPanel,0,SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, completeTransPanel,120,SpringLayout.NORTH, mainPanel);
        completeTransPanel.setPreferredSize(new Dimension(900,400));
        
        completeTransLayout.putConstraint(SpringLayout.WEST, customerID,5,SpringLayout.WEST, completeTransPanel);
        completeTransLayout.putConstraint(SpringLayout.NORTH, customerID,30,SpringLayout.NORTH, completeTransPanel);
        completeTransPanel.add(customerID);
        completeTransLayout.putConstraint(SpringLayout.WEST, customerIDField,170,SpringLayout.WEST, completeTransPanel);
        completeTransLayout.putConstraint(SpringLayout.NORTH, customerIDField,26,SpringLayout.NORTH, completeTransPanel);
        completeTransPanel.add(customerIDField);
        
        completeTransLayout.putConstraint(SpringLayout.WEST, employeeID,5,SpringLayout.WEST, completeTransPanel);
        completeTransLayout.putConstraint(SpringLayout.NORTH, employeeID,70,SpringLayout.NORTH, completeTransPanel);
        completeTransPanel.add(employeeID);
        completeTransLayout.putConstraint(SpringLayout.WEST, employeeIDField,170,SpringLayout.WEST, completeTransPanel);
        completeTransLayout.putConstraint(SpringLayout.NORTH, employeeIDField,66,SpringLayout.NORTH, completeTransPanel);
        completeTransPanel.add(employeeIDField);
        
        completeTransLayout.putConstraint(SpringLayout.WEST, completeTrackNum,5,SpringLayout.WEST, completeTransPanel);
        completeTransLayout.putConstraint(SpringLayout.NORTH, completeTrackNum,110,SpringLayout.NORTH, completeTransPanel);
        completeTransPanel.add(completeTrackNum);
        completeTransLayout.putConstraint(SpringLayout.WEST, completeTNField,170,SpringLayout.WEST, completeTransPanel);
        completeTransLayout.putConstraint(SpringLayout.NORTH, completeTNField,106,SpringLayout.NORTH, completeTransPanel);
        completeTransPanel.add(completeTNField);
        
        completeTransLayout.putConstraint(SpringLayout.WEST, shippingDate,5,SpringLayout.WEST, completeTransPanel);
        completeTransLayout.putConstraint(SpringLayout.NORTH, shippingDate,150,SpringLayout.NORTH, completeTransPanel);
        completeTransPanel.add(shippingDate);
        completeTransLayout.putConstraint(SpringLayout.WEST, shippingDateField,170,SpringLayout.WEST, completeTransPanel);
        completeTransLayout.putConstraint(SpringLayout.NORTH, shippingDateField,146,SpringLayout.NORTH, completeTransPanel);
        completeTransPanel.add(shippingDateField);
        
        completeTransLayout.putConstraint(SpringLayout.WEST, deliveryDate,5,SpringLayout.WEST, completeTransPanel);
        completeTransLayout.putConstraint(SpringLayout.NORTH, deliveryDate,190,SpringLayout.NORTH, completeTransPanel);
        completeTransPanel.add(deliveryDate);
        completeTransLayout.putConstraint(SpringLayout.WEST, deliveryDateField,170,SpringLayout.WEST, completeTransPanel);
        completeTransLayout.putConstraint(SpringLayout.NORTH, deliveryDateField,186,SpringLayout.NORTH, completeTransPanel);
        completeTransPanel.add(deliveryDateField);
        
        completeTransLayout.putConstraint(SpringLayout.WEST, price,5,SpringLayout.WEST, completeTransPanel);
        completeTransLayout.putConstraint(SpringLayout.NORTH, price,230,SpringLayout.NORTH, completeTransPanel);
        completeTransPanel.add(price);
        completeTransLayout.putConstraint(SpringLayout.WEST, priceField,170,SpringLayout.WEST, completeTransPanel);
        completeTransLayout.putConstraint(SpringLayout.NORTH, priceField,226,SpringLayout.NORTH, completeTransPanel);
        completeTransPanel.add(priceField);
        
        completeTransLayout.putConstraint(SpringLayout.WEST, completeTransButton,110,SpringLayout.WEST, completeTransPanel);
        completeTransLayout.putConstraint(SpringLayout.NORTH, completeTransButton,280,SpringLayout.NORTH, completeTransPanel);
        completeTransButton.setPreferredSize(new Dimension(180,50));
        completeTransPanel.add(completeTransButton);      
        mainPanel.add(completeTransPanel);
        
        completeTransButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

		logger.log(Level.INFO, "User Request: Complete Transaction");	
			
		if (!isInteger(customerIDField.getText()) ) {
                    JOptionPane.showMessageDialog(completeTransPanel, "Enter a Valid Customer ID");
                        logger.log(Level.INFO, "User message: Enter a Valid Customer ID");	
		}
		else if (!ss.userExists(Integer.parseInt(customerIDField.getText())) ) {
                    JOptionPane.showMessageDialog(completeTransPanel, "The customer ID you have entered does" +
                    "not exist in the database.");
                        logger.log(Level.INFO, "User message: Enter a Valid Customer ID");	
		}			
		else if (ss.isEmployee(Integer.parseInt(customerIDField.getText()))) {
                    JOptionPane.showMessageDialog(completeTransPanel, "Enter a Valid Customer ID.  User with ID " 
                    + customerIDField.getText() + " is an Employee and not a Customer.");
                        logger.log(Level.INFO, "User message: Enter a Valid Customer ID.  User with ID " 
                        + customerIDField.getText() + " is an Employee and not a Customer.");	
		}
		else if (!isInteger(employeeIDField.getText()) ) {
                    JOptionPane.showMessageDialog(completeTransPanel, "Enter a Valid Employee ID");
                        logger.log(Level.INFO, "User message: Enter a Valid Employee ID");	
		}
		else if (!ss.userExists(Integer.parseInt(employeeIDField.getText())) ) {
                    JOptionPane.showMessageDialog(completeTransPanel, "The employee ID you have entered does" +
                    "not exist in the database");
                        logger.log(Level.INFO, "User message: Enter a Valid Employee ID");	
		}			
		else if (!ss.isEmployee(Integer.parseInt(employeeIDField.getText()))) {
                    JOptionPane.showMessageDialog(completeTransPanel, "Enter a Valid Employee ID.  User with ID " 
                    + employeeIDField.getText() + " is aCustomer and not an Employee.");
                        logger.log(Level.INFO, "User message: Enter a Valid Employee ID.  User with ID " 
                        + employeeIDField.getText() + " is aCustomer and not an Employee.");	
		}
		else if (!ss.packageExists(completeTNField.getText())) {
                    JOptionPane.showMessageDialog(completeTransPanel, "Tracking Number does not exist in database");
                        logger.log(Level.INFO, "User message: Tracking Number does not exist");
		}
		else if (!isDate(shippingDateField.getText())) {
                    JOptionPane.showMessageDialog(completeTransPanel, "Enter a Valid Shipping Date in the format MM/dd/yyyy");
                        logger.log(Level.INFO, "User message: Enter a Valid Shipping Date in the format MM/dd/yyyy");
		}
		else if (!isDate(deliveryDateField.getText())) {
                    JOptionPane.showMessageDialog(completeTransPanel, "Enter a Valid Delivery Date in the format MM/dd/yyyy");
                        logger.log(Level.INFO, "User message: Enter a Valid Delivery Date in the format MM/dd/yyyy");
		}
		else if (!isFloat(priceField.getText())) {
                    JOptionPane.showMessageDialog(completeTransPanel, "Enter a Valid Price");
                        logger.log(Level.INFO, "User message: Enter a Valid Price");
		}
                else if (Float.parseFloat(priceField.getText()) < 0.0f) {
                    JOptionPane.showMessageDialog(completeTransPanel, "Price cannot be negative");
                        logger.log(Level.INFO, "User message: Price cannot be negative");
		}
		else {			
                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                    Date shippingDate = new Date();
                    Date deliveryDate = new Date();
                    try {
                        shippingDate = sdf.parse(shippingDateField.getText());
			deliveryDate = sdf.parse(deliveryDateField.getText());
			} catch (ParseException ex) {
                            logger.log(Level.SEVERE, "Error parsing Completed Transaction Dates");
			}									
			ss.addShppingTransaction(Integer.parseInt(customerIDField.getText()), 
			Integer.parseInt(employeeIDField.getText()),completeTNField.getText(),
			shippingDate, deliveryDate, Float.parseFloat(priceField.getText()));
                        
			ss.deletePackage(completeTNField.getText());
											
			customerIDField.setText("");
			employeeIDField.setText("");
			completeTNField.setText("");
			shippingDateField.setText("");
			deliveryDateField.setText("");
			priceField.setText("");                
					
			JOptionPane.showMessageDialog(completeTransPanel, "Transaction Completed!");
                            logger.log(Level.INFO, "User message: Transaction Completed!");					
                }			
            }
        });           
    }
    
    /*
    * Creates new JPanel with TextArea to display all shipping transactions.
    */
    private void showAllTransactions() {
        
        showTransPanel.setLayout(showTransLayout);
        layout.putConstraint(SpringLayout.WEST, showTransPanel,0,SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, showTransPanel,120,SpringLayout.NORTH, mainPanel);
        showTransPanel.setPreferredSize(new Dimension(900,640));              
        showTransLayout.putConstraint(SpringLayout.WEST, showTransArea,0,SpringLayout.WEST, showTransPanel);
        showTransLayout.putConstraint(SpringLayout.NORTH, showTransArea,0,SpringLayout.NORTH, showTransPanel);
        showTransArea.setText(ss.getAllTransactionsText());
        showTransPanel.add(showTransArea);     
        mainPanel.add(showTransPanel);
        
        logger.log(Level.INFO, "User message: Showing completed transactions");
    }
       
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        
        MainApp app = new MainApp();
        app.runSoftware();
    }
    
    private void write() {
        
        ss.writeDatabase();
    }
}
