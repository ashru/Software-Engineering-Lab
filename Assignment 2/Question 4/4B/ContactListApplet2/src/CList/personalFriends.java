package CList;

/*the context (100 chars max) and date in which acquainted, 
and specic events that need to be noted (100 chars max)*/
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
    String getdetails()
    {
        DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
       /* System.out.println("Name:"+this.getname());
        System.out.println("Email:"+this.getemail());
        System.out.println("Mobile no:"+this.getmob());
        System.out.println("Context of Acquaintance:"+con);
        System.out.println("Date of Acquaintance:"+df.format(date));
        System.out.println("Specific Events:"+event);*/
        return("Personal Friend\nName:"+this.getname()+"\nEmail:"+this.getemail()+"\nMobile no:"+Long.toString(this.getmob())+"\nDate of acquaintance:"+df.format(date)+"\nContext of Acquaintance:"+con+"\nSpecific Events:"+event);

        
    }
}