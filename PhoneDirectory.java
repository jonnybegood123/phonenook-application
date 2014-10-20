


import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;

/** the PhoneDirectory class to manage contacts information, like add, delete
 * update, and search
*/


public class PhoneDirectory {
  private  static PhoneRecord[] records;
  private int numRecords;


  
 // constructor to initialize instance variables
  public PhoneDirectory(int size)
  {
      this.records = new PhoneRecord[size];
      this.numRecords = 0;
  }

    /**
     * @return the records
     */
    public PhoneRecord[] getRecords() {
        return records;
    }

    /**
     * @return the numRecords
     */
    public int getNumRecords() {
        return numRecords;
    }
    
    public void searchRecords(String inputName)
    {
        int i;
        String names = "";
        String numbers = "";
        for (i=0; i<numRecords;i++){
        String name = records[i].getName().toLowerCase();
        String number = records[i].getNumber();
        if (name.contains(inputName)){
            names += (name + " - " + number + "\n");
                 
        }
        //find all records with record name contains this inputName string, and print all of them out on the screen
        //use the contains method in String, learn by yourself how to use it     
    }
       if (names == ""){
        JOptionPane.showMessageDialog(null, "Couldn't find any matches.", "ERROR", JOptionPane.PLAIN_MESSAGE);
       }
       else {
           JOptionPane.showMessageDialog(null, names, "FOUND MATCHES:", JOptionPane.PLAIN_MESSAGE);
           
       
       }
        
    }
    
    public void deleteRecord(String contactName)
    {
        int j = 0;
        int i; 
        for (i=0; i<numRecords;i++){
        String name = records[i].getName().toLowerCase();
        if (name.equalsIgnoreCase(contactName)){
            records[i] = null;    
            JOptionPane.showMessageDialog(null, "Contact was deleted!", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
            j = 1;
            }
}
        if (j == 0) {
            JOptionPane.showMessageDialog(null, "Contact not found.", "ERROR", JOptionPane.PLAIN_MESSAGE);
        }
        for (i=0; i<numRecords;i++){ 
        if ((records[i] == null)){
            records[i] = records[i + 1];
            records[i + 1] = null;
            }
        }
        // find a record with name exactly the same with contactName, then delete this record.
        // remember available spaces can only be at the end of the arrays, 
        //when deleting an element not at the end of the array, you have to move this availble space to the end of the array.
    }
    
    public void updateRecord(String contactName, String phoneNumber)
    {
     int i;
        for (i=0; i<numRecords;i++){
        String name = records[i].getName().toLowerCase();
        PhoneRecord contact = new PhoneRecord(contactName, phoneNumber);
        if (name.equalsIgnoreCase(contactName)){
            records[i] = contact;  
            return;
            }
        else {
            System.out.println("Couldn't find.");
        }

}
      //find a record with name exactly the same with contactName, then update its number to phoneNumber
    }
    public void addRecord(String name, String phoneNumber)
    {
        if (numRecords < records.length){
        PhoneRecord contact = new PhoneRecord(name, phoneNumber);
        records[numRecords] = contact;
        numRecords++;
        }
        else {
            JOptionPane.showMessageDialog(null, "Not enough space.", "ERROR", JOptionPane.PLAIN_MESSAGE);
        }
        // add this record to the array
    }
  
     public void viewAllContacts() {
       int i;
        String names = "";
        String numbers = "";
        
        for (i=0; i<numRecords; i++){
        String name = records[i].getName();
        String number = records[i].getNumber();
        names += (name + " - " + number + "\n");
                 
        }
        
        JOptionPane.showMessageDialog(null, names, "Contacts:", JOptionPane.PLAIN_MESSAGE);
        
        }
      
}
