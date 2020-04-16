package Jproj;
/*add database view
* test view
* test database creation*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;

public class Screen extends JFrame implements ActionListener {
    //Attributes
    JMenuBar bar;
    JMenu database, aboutMenu;
    JMenuItem load, show, intOwnParams, about;

    //Constructor
    public Screen(String title){
        super(title);
        this.setLayout(new FlowLayout());
        this.setSize(500, 500);

        bar = new JMenuBar();
        this.setJMenuBar(bar);
        this.add(bar);
        //Declare Menus
        this.database = this.initMenu( bar, "Database" );
        this.aboutMenu = this.initMenu( bar, "About" );
        //Declare all the menu items
        this.load = this.initMenuItem( database, "Load" );
        this.show = this.initMenuItem( database, "Show" );
        this.intOwnParams = this.initMenuItem( database, "Search" );
        this.about = this.initMenuItem( aboutMenu, "About" );



        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    //To initialize components
    //Initializes menuItem
    private JMenuItem initMenuItem( JMenu parent, String name ){

        JMenuItem tmp = new JMenuItem(name);
        parent.add(tmp);
        tmp.addActionListener(this);
        return tmp;
    }
    //Initializes menu
    private JMenu initMenu( JMenuBar parent, String name ){
        JMenu tmp = new JMenu(name);
        parent.add(tmp);
        return tmp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.load){
            Table_handle tab = new Table_handle();
            JOptionPane.showMessageDialog(
                    this, "Database has been loaded");
            tab.populateTable();
            tab.createView();
        }
        if (e.getSource() == this.about){
            JOptionPane.showMessageDialog(
                    this, "Author: Andrei Negura (c16733435)\n" +
                            "Purpose: OOP Java assignment\n" +
                            "Lecturer: Susan McKeever\n" +
                            "IDE: IntelliJ\n" +
                            "Program description: The purpose of this project is to take a dataset" +
                            " – and build a tool that shows interesting\n" +
                            "facts from the dataset. These datasets are at : https://data.gov.ie/" +
                            "data/search?res_format=CSV\n You don’t have to use the full dataset if it " +
                            "is too big. But to query it, you will need to LOAD the\ndataset, or a subset " +
                            "of it, into a relational database yourself – and get a connection working between\n" +
                            "your java code and the database (using JDBC). ");
        }
    }
}

