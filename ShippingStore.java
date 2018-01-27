package shippingstore;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShippingStore {

    private final List<Package> packageList;
    private final List<User> users;
    private final List<Transaction> transactions;
    private Logger logger = Logger.getLogger(ShippingStore.class.getName());
    private int userIdCounter = 1;

    /**
     * Default constructor. Initializes the inventory, users, and transactions
     * tables.
     */
    public ShippingStore() {
        this.packageList = new ArrayList<Package>();
        this.users = new ArrayList<User>();
        this.transactions = new ArrayList<Transaction>();

    }

    public ShippingStore(Logger logger) {
        this.packageList = new ArrayList<Package>();
        this.users = new ArrayList<User>();
        this.transactions = new ArrayList<Transaction>();
        this.logger = logger;
    }

    /**
     * Constructor. Initializes the package list, users, transactions and logger to
     * given values.
     *
     * @param packageList List of packages
     * @param users List of Users
     * @param transactions List of Transactions
     */
    public ShippingStore(List<Package> packageList, List<User> users, List<Transaction> transactions, Logger logger) {
        this.packageList = packageList;
        this.users = users;
        this.transactions = transactions;
        this.logger = logger;
    }

    /**
     *
     * @param Counter Counter
     */
    public void setUserIdCounter(int Counter) {
        this.userIdCounter = Counter;
    }

        /**
     * Auxiliary method used to find a package in the database, given its
     * tracking number.
     *
     * @param ptn TrackingNumber
     * @return The package found, or otherwise null.
     */
    public Package findPackage(String ptn) {
        for (Package p : packageList) {
            logger.log(Level.FINER, "processing findPackage", packageList.size());
            if (p.getPtn().equals(ptn)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Returns true if the package exists in the database.
     * @param ptn Tracking Number
     * @return
     */
    public boolean packageExists(String ptn) {
        if (findPackage(ptn) != null)
            return true;
        return false;
    }

    /**
     *
     * @param ptn Tracking Number
     * @param specification
     * @param mailingClass
     * @param height
     * @param width
     */
    public void addEnvelope(String ptn, String specification, String mailingClass, int height, int width) {
        Envelope env = new Envelope(ptn, specification, mailingClass, height, width);
        packageList.add(env);
        logger.log(Level.INFO, "Envelope Added");
    }

    /**
     *
     * @param ptn
     * @param specification
     * @param mailingClass
     * @param dimension
     * @param volume
     */
    public void addBox(String ptn, String specification, String mailingClass, int dimension, int volume) {
        Box box = new Box(ptn, specification, mailingClass, dimension, volume);
        packageList.add(box);
         logger.log(Level.INFO, "Box Added");
    }

    /**
     *
     * @param ptn
     * @param specification
     * @param mailingClass
     * @param loadWeight
     * @param content
     */
    public void addCrate(String ptn, String specification, String mailingClass, float loadWeight, String content) {
        Crate crate = new Crate(ptn, specification, mailingClass, loadWeight, content);
        packageList.add(crate);
        logger.log(Level.INFO, "Crate Added");
    }

    /**
     *
     * @param ptn
     * @param specification
     * @param mailingClass
     * @param material
     * @param diameter
     */
    public void addDrum(String ptn, String specification, String mailingClass, String material, float diameter) {
        Drum drum = new Drum(ptn, specification, mailingClass, material, diameter);
        packageList.add(drum);
        logger.log(Level.INFO, "Drum Added");
    }


    /**
     * This method allows the user to delete a package from the inventory
     * database given its tracking number.
     * @param ptn The package tracking number
     * @return True if the package was found and was deleted. False otherwise.
     */
    public boolean deletePackage(String ptn) {

        for (Package p : packageList) {
            logger.log(Level.FINER, "processing delete package", packageList.size());
            if (p.getPtn().equals(ptn)) {
                packageList.remove(p);
                logger.log(Level.INFO, "Package Deleted");
                return true;
            }
        }
        return false;
    }


    /**
     * Auxiliary private method to return a list of packages in a formatted
     * manner.
     */
    private String getFormattedPackageList(List<Package> packages) {
        String text = "---------------------------------------------------"
                + "----------------------------------------------------------\n";
         text = String.format("| %12s | %12s | %13s | %13s | %22s                                           |%n",
                "PACKAGE TYPE", "TRACKING #", "SPECIFICATION", "MAILING CLASS", "OTHER DETAILS");
        text +=  "---------------------------------------------------"
                + "----------------------------------------------------------\n";
        for (Package p : packages) {
            text += p.getFormattedText();
        }
        text += "---------------------------------------------------"
                + "----------------------------------------------------------\n";

        return text;
    }

    /**
     * This method return all the packages currently in the inventory, in a
     * formatted manner.
     * @return
     */
    public String getAllPackagesFormatted() {
        return getFormattedPackageList(packageList);
    }

    /**
     *
     * @param ptn
     * @return
     */
    public String getPackageFormatted(String ptn) {
        ArrayList<Package> matchingPackage = new ArrayList<Package>(1);
        matchingPackage.add(findPackage(ptn));
        return getFormattedPackageList(matchingPackage);
    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param phoneNumber
     * @param address
     */
    public void addCustomer(String firstName, String lastName, String phoneNumber, String address) {
        users.add(new Customer(userIdCounter++, firstName, lastName, phoneNumber, address));
        logger.log(Level.INFO, "Customer Added");
    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param ssn
     * @param monthlySalary
     * @param bankAccNumber
     */
    public void addEmployee(String firstName, String lastName, int ssn, float monthlySalary, int bankAccNumber) {
        users.add(new Employee(userIdCounter++, firstName, lastName, ssn, monthlySalary, bankAccNumber));
        logger.log(Level.INFO, "Employee Added");
    }

    /**
     * Auxiliary private method to return a list of users in a formatted
     * manner.
     */
    private String getFormattedUserList(List<User> users) {
        String text ="---------------------------------------------------"
                + "------------------------------------------------"
                + "---------------\n";
        text += String.format("| %10s | %9s | %25s | %25s | %70s                         | %n",
                "USER TYPE", "USER ID", "FIRST NAME", "LAST NAME", "OTHER DETAILS");
        text += "---------------------------------------------------"
                + "-----------------------------------------------"
                + "---------------\n";
        for (User u : users) {
            text += u.getFormattedText();
        }
        text += "---------------------------------------------------"
                + "-----------------------------------------------"
                + "---------------\n";

        return text;
    }

    /**
     * Returns a string list of all users in the database in a formatted manner.
     * @return a formatted string of all the users in the database.
     */
    public String getAllUsersFormatted() {
        return getFormattedUserList(users);
    }

    /**
     *
     * @param userID
     * @return
     */
    public boolean userExists(int userID) {
        if (findUser(userID) != null)
            return true;

        return false;
    }

    /**
     *
     * @param userID
     * @return
     */
    public User findUser(int userID) {
        User user = null;

        for (User u : users) {
            if (u.getId() == userID) {
                user = u;
            }
        }

        return user;
    }

    /**
     *
     * @param userID
     * @return
     */
    public boolean isCustomer(int userID) {
        User user = findUser(userID);
        if (user instanceof Customer)
            return true;
        return false;
    }

    /**
     *
     * @param userID
     * @return
     */
    public boolean isEmployee(int userID) {
        User user = findUser(userID);
        if (user instanceof Employee)
            return true;
        return false;
    }

    /**
     *
     * @param userID
     * @param firstName
     * @param lastName
     * @param phoneNumber
     * @param address
     */
    public void updateCustomer(int userID, String firstName, String lastName,
            String phoneNumber, String address) {
        Customer customer = (Customer) findUser(userID);
        if (customer == null) {
            System.err.println("Customer not found!");
            logger.log(Level.INFO, "Customer not found!");
            return;
        }
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPhoneNumber(phoneNumber);
        customer.setAddress(address);
    }

    /**
     *
     * @param userID
     * @param firstName
     * @param lastName
     * @param ssn
     * @param monthlySalary
     * @param bankAccNumber
     */
    public void updateEmployee(int userID, String firstName, String lastName,
            int ssn, float monthlySalary, int bankAccNumber) {
        Employee employee = (Employee) findUser(userID);
        if (employee == null) {
            System.err.println("Employee not found!");
            logger.log(Level.INFO, "Employee not found!");
            return;
        }
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setSocialSecurityNumber(ssn);
        employee.setMonthlySalary(monthlySalary);
        employee.setBankAccountNumber(bankAccNumber);
    }

    /**
     *
     * @param customerId
     * @param employeeId
     * @param ptn
     * @param shippingDate
     * @param deliveryDate
     * @param price
     */
    public void addShppingTransaction(int customerId, int employeeId, String ptn,
                       Date shippingDate, Date deliveryDate, float price) {
        Transaction trans = new Transaction(customerId, employeeId, ptn, shippingDate, deliveryDate, price);
        transactions.add(trans);
    }


    /**
     * Return a list of all recorded transactions.
     *
     * @return transactions
     */
    public String getAllTransactionsText() {
        String transText = "";
        for (Transaction trans : transactions) {
            transText += trans.toString();
        }
        return transText;
    }


    /**
     * This method is used to read the database from a file, serializable
     * objects.
     *
     * @return A new ShippingStore object.
     */
    @SuppressWarnings("unchecked") // This will prevent Java unchecked operation warning when
    // convering from serialized Object to Arraylist<>
    public static ShippingStore readDatabase(Logger logger) {
        System.out.print("Reading database...");

        File dataFile = new File("ShippingStore.ser");

        ShippingStore ss = null;
        // Try to read existing dealership database from a file
        InputStream file = null;
        InputStream buffer = null;
        ObjectInput input = null;
        try {
            if (!dataFile.exists()) {
                System.out.println("Data file does not exist. Creating a new database.");
                ss = new ShippingStore(logger);
                return ss;
            }
            file = new FileInputStream(dataFile);
            buffer = new BufferedInputStream(file);
            input = new ObjectInputStream(buffer);
            // Read serilized data
            List<Package> packageList = (ArrayList<Package>) input.readObject();
            List<User> users = (ArrayList<User>) input.readObject();
            List<Transaction> transactions = (ArrayList<Transaction>) input.readObject();
            ss = new ShippingStore(packageList, users, transactions, logger);
            ss.userIdCounter = input.readInt();

            input.close();
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.toString());
            logger.log(Level.WARNING,"class not found",ex);
        } catch (FileNotFoundException ex) {
            System.err.println("Database file not found.");
            logger.log(Level.WARNING,"file not found",ex);
        } catch (IOException ex) {
            System.err.println(ex.toString());
            logger.log(Level.WARNING,"IO trouble",ex);
        } finally {
            close(file);
        }
        System.out.println("Done.");

        return ss;
    }

    /**
     * This method is used to save the Dealership database as a serializable
     * object.
     */
    public void writeDatabase() {
        System.out.print("Writing database...");
        //serialize the database
        OutputStream file = null;
        OutputStream buffer = null;
        ObjectOutput output = null;
        try {
            file = new FileOutputStream("ShippingStore.ser");
            buffer = new BufferedOutputStream(file);
            output = new ObjectOutputStream(buffer);
            output.writeObject(packageList);
            output.writeObject(users);
            output.writeObject(transactions);
            output.writeInt(userIdCounter);
            output.close();
        } catch (IOException ex) {
            System.err.println(ex.toString());
            logger.log(Level.WARNING,"IO trouble",ex);
        } finally {
            close(file);
        }
        System.out.println("Done.");
    }


    /**
     * Auxiliary convenience method used to close a file and handle possible
     * exceptions that may occur.
     *
     * @param c
     */
    public static void close(Closeable c) {
        if (c == null) {
            return;
        }
        try {
            c.close();
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Return 2D array with all Package data
     * This will be used to show the data in a table in the user interface
     * @param ptn If parameter not empty, returns only packages with the given Tracking Number
     * @return 2D Array of Package data
     */
    public Object[][] returnPackageDataArray(String ptn) {

        Object[][] data = new Object[packageList.size()][6];

        int i = 0;
        int j;
        for (Package p : packageList) {
            if (ptn.isEmpty() || ptn.equals(p.getPtn())) {

                j = 0;
                for (String w : p.toString().split(";", 6)) {
                    data[i][j] = w;
                    j++;
                }
                i++;
            }

        }

        return data;

    }



    /**
     * Return 2D array with all User data
     * This will be used to show the data in a table in the user interface
     * @return 2D Array of User data
     */
    public Object[][] returnUserDataArray() {

        Object[][] data = new Object[users.size()][10];

        int i = 0;
        int j;
        for (User p : users) {
                j = 0;
                for (String w : p.toString().split(";", 10)) {
                    data[i][j] = w;
                    j++;
                }
                i++;
        }

        return data;

    }

    /**
     * Return 2D array with all Completed Transactions data
     * This will be used to show the data in a table in the user interface
     * @return 2D Array of Completed Transactions data
     */
    public Object[][] returnTransactionsDataArray() {

        Object[][] data = new Object[transactions.size()][10];

        int i = 0;
        int j;
        for (Transaction p : transactions) {
            j = 0;
            for (String w : p.toString().split(";", 10)) {
                data[i][j] = w;
                j++;
            }
            i++;
        }

        return data;
    }

}