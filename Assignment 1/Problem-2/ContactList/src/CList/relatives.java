package CList;
import java.io.*;
import java.util.*;
import java.text.*;
class relatives  extends Acquaintance
{
    Date bday,d;
    
    relatives(Date d,Date d2,String name,String email,long mobile_no)
    {
        super(name,email,mobile_no);
    	this.bday=d;
    	this.d=d2;
    }
    Date getbd(){
    	return bday;
    }
    Date getd()
    {return d;}
    void getdetails()//prints details of its object
    {
        DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Contact Details:");
        System.out.println("Name:"+this.getname());
        System.out.println("Email:"+this.getemail());
        System.out.println("Mobile no:"+this.getmob());
        System.out.println("Birthday:"+df.format(bday));
        System.out.println("Date of last meeting:"+df.format(d));
        
    }
}