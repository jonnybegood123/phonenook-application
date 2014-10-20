import java.io.*;

// Represents a record containing a name and a phone number
class PhoneRecord implements Serializable {
  private String name;
  private String number;

  // Constructor
  public PhoneRecord(String personName, String phoneNumber) {
    name = personName;                       
    number = phoneNumber;
  }

  // Returns the name stored in the record
  public String getName() {
    return name;
  }
 
  // Returns the phone number stored in the record
  public String getNumber() {
    return number;
  }
}
