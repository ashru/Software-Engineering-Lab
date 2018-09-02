package CList;
import java.io.*;
import java.util.*;
import java.text.*;
class personalFriends extends Acquaintance
{
    String con,event;Date date;
   
    personalFriends(String c,String e,Date when,String name,String email,long mobile_no)
    {
        super(name,email,mobile_no);
        this.con=c;
        this.event=e;
        
        this.date=when;
    }
    String getcon()
    {
        return con;
    }
    String getevent()
    {
        return event;
    }
    
    
    Date getdate()
    {
        return date;
    }
    void getdetails()//prints details of its object
    {
        DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Contact Details:");
        System.out.println("Name:"+this.getname());
        System.out.println("Email:"+this.getemail());
        System.out.println("Mobile no:"+this.getmob());
        System.out.println("Context of Acquaintance:"+con);
        System.out.println("Date of Acquaintance:"+df.format(date));
        System.out.println("Specific Events:"+event);
    }
}