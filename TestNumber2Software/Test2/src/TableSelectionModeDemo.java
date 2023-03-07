//package test2;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * @author Everett Reynolds
 * 
 * This class is a constructor which initializes the panel which is created when
 * the window is created.
 * 
 * <p>
 * This method always runs and creates the panel, regardless of what is in it.
 *
 */
public class TableSelectionModeDemo extends JPanel {
    public TableSelectionModeDemo() {
        initializePanel();
    }
    /**
     * 
     * @author Everett Reynolds
     *
     *This method actually puts together and creates the entire panel and table which is the result of
     *all of the code below.
     *
     *
     */
    public static void showFrame() {
        JPanel panel = new TableSelectionModeDemo();
        panel.setOpaque(true);

        JFrame frame = new JFrame("JTable Single Selection");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
    /**
     * 
     * @author Everett Reynolds
     * This method facilitates the images within a table model to display images within
     *
     */
    public class JTableImageIconRenderer extends DefaultTableCellRenderer {
    	public void setValue(Object value) {
    	if (value instanceof ImageIcon) {
    	ImageIcon c = (ImageIcon) value;
    	setIcon(c);
    	} else {
    	super.setValue(value);
    	}
    	}
    	}
    /**
     * 
     * @author Everett Reynolds
     *
     *This method is our main method which calls the showFrame method to invoke the creation
     *of the window and content within the window for our Java database
     *
     *@param String[] args The Command Line and User Input Capabilities
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TableSelectionModeDemo::showFrame);
        
        
        
    }
    /**
     * 
     * @author Everett Reynolds
     *
     *This method does the most out of all methods as this method creates numerous
     *JTables, JPanels, 2D Arrays, JFrames, & Panes to both create the content
     *Seen in our final product and to organize it into a readable format
     *
     *There is portions of this method which are used to create Action Listeners
     *for both buttons and certain other nested tables to populate the screen
     *with relevant issues from publishers
     *
     */
    private void initializePanel() {
        this.setLayout(new BorderLayout());
        //
        
        JFrame jFrame = new JFrame();
        JDialog jd = new JDialog(jFrame);
        jd.setLayout(new FlowLayout());
        jd.setBounds(500, 300, 400, 300);
       final int[] setRow;
        int[] setCol;
        String data;
        //
        JTable table = new JTable(new DataTableModel());
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(200);
        
        JLabel selectedValue = new JLabel("Value selected: ");
        JPanel valuePane = new JPanel();
        JButton jbtnMail = new JButton("Online");
        JButton jbtnCall = new JButton("Call");
        valuePane.add(selectedValue);
        valuePane.add(jbtnMail);
        valuePane.add(jbtnCall);
        
        this.add(valuePane, BorderLayout.SOUTH);
        JLabel bookReorder = new JLabel(new ImageIcon("img/books.png"));
        this.add(bookReorder, BorderLayout.NORTH);
     
        // Settings table selection mode. We can use the following
        // three constants to define the selection mode.
        //
        // - ListSelectionModel.SINGLE_SELECTION
        // - ListSelectionModel.SINGLE_INTERVAL_SELECTION
        // - ListSelectionModel.MULTIPLE_INTERVAL_SELECTION
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getSelectionModel().addListSelectionListener(
        		new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
				        String selectedData = null;

				        int[] selectedRow = table.getSelectedRows();
				        int[] selectedColumns = table.getSelectedColumns();
				      // setRow = selectedRow;
				        
				        System.out.println("Selected rows: " + selectedRow[0]
				        		+ "/" + selectedRow.length);
				        /*
				        for (int i = 0; i < selectedRow.length; i++) {
				          for (int j = 0; j < selectedColumns.length; j++) {
				            selectedData = ""+table.getValueAt(selectedRow[i], selectedColumns[j]);
				          }
				        }
				        */
				        selectedData = ""+table.getValueAt(selectedRow[0], 0);
				        //System.out.println("Selected: " + selectedData);
				        selectedValue.setText("Selected: " + selectedData);
				        
					}
        			
        		});
       
        jbtnMail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 JFrame f = new JFrame("Directory of Companies");
            	int num = 100;
                 String[] columns = {"Company Image","Web Address"};
             	 ImageIcon i1 = new ImageIcon("img/PRINTING IS US.jpg");
            	 //JLabel bookReorder = new JLabel(new ImageIcon("img/books.png"));
                 ImageIcon i2 = new ImageIcon("img/PUBLISH OUR WAY.jpg");
                 ImageIcon i3 = new ImageIcon("img/AMERICAN PUBLISHING.png");
                 ImageIcon i4 = new ImageIcon("img/READING MATERIALS INC..jpg");
                 ImageIcon i5 = new ImageIcon("img/REED-N-RITE.png");
              //   JLabel l1 = new JLabel(i1);
               //  JLabel l2 = new JLabel(i2);
               //  JLabel l3 = new JLabel(i3);
              //   JLabel l4 = new JLabel(i4);
                // JLabel l5 = new JLabel(i5);
            	Object[][] tabled = {
            			{i1,"printing-is-us.com"},
            			{i2,"publish-our-way.com"},
            			{i3,"american-publishing.com"},
            			{i4,"reading-materials-inc.com"},
            			{i5,"reed-n-rite.com"}
            	};
            	
            	 DefaultTableModel model = new DefaultTableModel(tabled, columns);
            	 table.setPreferredScrollableViewportSize(new Dimension(
            	            table.getColumnCount() * num, table.getRowHeight() * 16));
            	 JTable tables = new JTable(model) {
            	      public Class getColumnClass(int column) {
            	        return (column == 3) ? Icon.class : Object.class;
            	      }
            	    };
            	  //  TableColumn imageColumn = tabled.getColumnModel().getColumn(0);
            	  //  imageColumn.setCellRenderer(new JTableImageIconRenderer());
            	 tables.setRowHeight(500);
            	JTable jTable1 = new JTable(tabled, columns); 
            	TableColumn imageColumn = jTable1.getColumnModel().getColumn(0);
        	    imageColumn.setCellRenderer(new JTableImageIconRenderer());
            	 f.add(jTable1);
              //f.add(p2);
             // f.add(p3);
             // f.add(p4);
             // f.add(p5);

              // set the size of frame
              f.setSize(500, 500);
         
               f.setVisible(true);
            }
        });
        
        
        
        jbtnCall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 JFrame f = new JFrame("Contact Information");
                 String[] columns = {"Contact Person Image","Contact Person's Name","Contact Phone Number"};
                 int num = 100;
            	 ImageIcon i1 = new ImageIcon("img/ingrid.jpg");
            	 //JLabel bookReorder = new JLabel(new ImageIcon("img/books.png"));
                 ImageIcon i2 = new ImageIcon("img/pete_rose.jpg");
                 ImageIcon i3 = new ImageIcon("img/famous-people-named-guy.jfif");
                 ImageIcon i4 = new ImageIcon("img/0848ecb3432e646bdf5fc1b15f4756a6.jpg");
                 ImageIcon i5 = new ImageIcon("img/20a6e0b66414578e9873dc536797d19f.jpg");
              //   JLabel l1 = new JLabel(i1);
               //  JLabel l2 = new JLabel(i2);
               //  JLabel l3 = new JLabel(i3);
              //   JLabel l4 = new JLabel(i4);
                // JLabel l5 = new JLabel(i5);
            	Object[][] tabled = {
            			{i1,"TOMMIE SEYMOUR","000-714-8321"},
            			{i2,"JANE TOMLIN","010-410-0010"},
            			{i3,"DAVID DAVIDSON","800-555-1211"},
            			{i4,"RENEE SMITH","800-555-9743"},
            			{i5,"SEBASTIAN JONES","800-555-8284"}
            	};
            	 DefaultTableModel model = new DefaultTableModel(tabled, columns);
            	 table.setPreferredScrollableViewportSize(new Dimension(
            	            table.getColumnCount() * num, table.getRowHeight() * 16));
            	 JTable tables = new JTable(model) {
            	      public Class getColumnClass(int column) {
            	        return (column == 3) ? Icon.class : Object.class;
            	      }
            	    };
            	  //  TableColumn imageColumn = tabled.getColumnModel().getColumn(0);
            	  //  imageColumn.setCellRenderer(new JTableImageIconRenderer());
            	 tables.setRowHeight(500);
            	JTable jTable1 = new JTable(tabled, columns); 
            	TableColumn imageColumn = jTable1.getColumnModel().getColumn(0);
        	    imageColumn.setCellRenderer(new JTableImageIconRenderer());
            	 f.add(jTable1);
              //f.add(p2);
             // f.add(p3);
             // f.add(p4);
             // f.add(p5);

              // set the size of frame
              f.setSize(500, 500);
         
               f.setVisible(true);
            }
        });
        //
        
        //
        JScrollPane pane = new JScrollPane(table);
        this.add(pane, BorderLayout.CENTER);
        this.setPreferredSize(new Dimension(500, 100));
    }
    /**
     * 
     * @author Everett Reynolds
     *
     *This method creates a static data table of publisher information
     *which does not need to have access to an SQL server to be reached
     *and is stored locally in case of a user not being able to access
     *the SQL server.
     *
     *This is another class which creates 2D array tables of information
     *which are manipulated in our main driver method
     *
     */
    static class DataTableModel extends AbstractTableModel {
        // TableModel's column names
    	 private String[] columnNames = {
    	    		"PubID","Name","Contact","Phone"	 
    	    	 };

        // TableModel's data
        private Object[][] data = {
        		 {1,"PRINTING IS US","TOMMIE SEYMOUR","000-714-8321"},
    			 {2,"PUBLISH OUR WAY","JANE TOMLIN","010-410-0010"},
    			 {3,"AMERICAN PUBLISHING","DAVID DAVIDSON","800-555-1211"},
    			 {4,"READING MATERIALS INC.","RENEE SMITH","800-555-9743"},
    			 {5,"REED-N-RITE","SEBASTIAN JONES","800-555-8284"}
        }; 
   /* static  class DataTableModel extends AbstractTableModel {
    	 private String[] columnNames = {
    		"PubID","Name","Contact","Phone"	 
    	 };
    	 
    	 private Object[][] data = {
    			 {1,"PRINTING IS US","TOMMIE SEYMOUR","000-714-8321"},
    			 {2,"PUBLISH OUR WAY","JANE TOMLIN","010-410-0010"},
    			 {3,"AMERICAN PUBLISHING","DAVID DAVIDSON","800-555-1211"},
    			 {4,"READING MATERIALS INC.","RENEE SMITH","800-555-9743"},
    			 {5,"REED-N-RITE","SEBASTIAN JONES","800-555-8284"},
    	 };
    	
    } */
        /**
         * 
         * @author Everett Reynolds
         *
         *This method gets a count of the rows within the class above's data structure
         *These rows are used for calculations in other aspects of the database.
         *
         *@return data.length The size of the row which is being asked it's row count
         */
        public int getRowCount() {
            return data.length;
        }
        /**
         * 
         * @author Everett Reynolds
         *
         *This method gets a count of the columns within the class above's data structure
         *These columns are used for calculations in other aspects of the database.
         *
         *@return data.length The size of the column which is being asked it's column count
         */
        public int getColumnCount() {
            return columnNames.length;
        }
        /**
         * 
         * @author Everett Reynolds
         *
         *A method which is takes in a row and column in order to find a data value
         *at a given location when it is requested
         *
         *
         *@return data[rowIndex][columnIndex] The information at a given position
         */
        public Object getValueAt(int rowIndex, int columnIndex) {
            return data[rowIndex][columnIndex];
        }
        /**
         * 
         * @author Everett Reynolds
         *
         *This method is used to get the header of the current category
         *which a user is currently parsing through
         *
         *@return columnNames[column]
         */
        public String getColumnName(int column) {
        	return columnNames[column];
        }
    }
    
  
}
    
    
