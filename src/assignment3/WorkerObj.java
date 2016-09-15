/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author jgoodman
 */
public class WorkerObj {
    
    private String fName;
    private String mName;
    private String lName;
    private char gender;
    private String dob;
    private String start_date;
    private char is_Active;

    public WorkerObj(String fName, String mName, String lName, char gender, String dob, String start_date, char is_Active) {
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        this.gender = gender;
        this.dob = dob;
        this.start_date = start_date;
        this.is_Active = is_Active;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public char getIs_Active() {
        return is_Active;
    }

    public void setIs_Active(char is_Active) {
        this.is_Active = is_Active;
    }
    
     public void insertWorker(WorkerObj wo) throws SQLException {
        
         String woFname = wo.getfName();
         String woMname = wo.getmName();
         String woLname = wo.getlName();
         char woGender = wo.getGender();
         String woDOB = wo.getDob();
         String woStartDate = wo.getStart_date();
         char woIsActive = wo.getIs_Active();
         
            ConnectToDb conDB = new ConnectToDb();
          
            String sql = "INSERT INTO WORKER(F_NAME, M_NAME, L_NAME, GENDER, D_O_B, START_DATE, IS_ACTIVE)"
                + "values(?,?,?,?,?,?,?)";
            Connection con = (Connection) conDB;
            PreparedStatement stmt = con.prepareStatement(sql);
            
                 stmt.setString(1, woFname);
                 stmt.setString(2, woMname);
                 stmt.setString(3, woLname);
                 stmt.setString(4, String.valueOf(woGender));
                 stmt.setString(5, woDOB);
                 stmt.setString(6, woStartDate);
                 stmt.setString(7, String.valueOf(woIsActive));
         
                 stmt.executeUpdate();
         
         
    }
    
}
