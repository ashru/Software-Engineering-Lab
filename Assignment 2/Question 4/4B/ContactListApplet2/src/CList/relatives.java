/**
 * 
 */
package CList;

/*birth day and the date of last meeting.*/
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
    String getdetails()
    {
        DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        /*System.out.println("Name:"+this.getname());
        System.out.println("Email:"+this.getemail());
        System.out.println("Mobile no:"+this.getmob());
        System.out.println("Birthday:"+df.format(bday));
        System.out.println("Date of last meeting:"+df.format(d));*/
        return("Reative\nName:"+this.getname()+"\nEmail:"+this.getemail()+"\nMobile no:"+Long.toString(this.getmob())+"\nBirthday:"+df.format(bday)+"\nDate of last meeting:"+df.format(d));

    }
}