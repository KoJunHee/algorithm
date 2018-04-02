package ass1_nameCard;

public class Name {

    // private variables
    private String fName;
    private String mName;
    private String lName;


    // constructor for first, middle, last name
    public Name(String fName, String mName, String lName) {
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
    }

    // constructor for first, last name
    public Name(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }


    ///////////////////////////////////////////
    //accessor/mutator methods

    public String getFirstName() {
        return fName;
    }
    public String getMiddleName() {
        return mName;
    }
    public String getLastName() { return lName;  }
    public void setFirstName(String fName) {
        fName = fName;
    }
    public void setMiddleName(String mName) {
        mName = mName;
    }
    public void setLastName(String lName) {
        lName = lName;
    }
    public String getFirstAndLastName() {
        return fName + " " + lName;
    }
    public String getLastCommaFirst() {
        return lName + ", " + fName;
    }

    ///////////////////////////////////////////


    //return inital name
    public String getInitials() {

        String fi = this.fName == null ? " " : String.valueOf(this.fName.charAt(0));
        String mi = this.mName == null ? " " : String.valueOf(this.mName.charAt(0));
        String li = this.lName == null ? " " : String.valueOf(this.lName.charAt(0));
        String initials = fi + mi + li;
        return initials;

    }

    //return name for print in middle line
    //first name, first character of middle name, and last name will be printed
    public String getNameFormat() {

        String fi = this.fName == null ? "" : this.fName;
        String mi = this.mName == null ? "" : String.valueOf(this.mName.charAt(0));
        String li = this.lName == null ? "" : this.lName;
        return fi + " " + mi + " " + li;
    }


}

