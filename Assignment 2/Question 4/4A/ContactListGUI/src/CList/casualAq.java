package CList;

/*when, where (100 chars max), and in what circumstances (100 chars max) met, and any other
useful information (100 chars max)*/
import java.util.*;
import java.io.*;
import java.text.*;
class casualAq extends Acquaintance
{
    String where,cir,info;Date when;
    
    casualAq(String w,String c,String i,Date when,String name,String email,long mobile_no)
    {
        super(name,email,mobile_no);
        this.where=w;
        this.cir=c;
        this.info=i;
        this.when=when;
    }
    String getwhere()
    {
    	return where;

    }
    String getcir()
    {
    	return cir;
    }
    String getinfo()
    {
    	return info;
    }
    
    Date getwhen()
    {
    	return when;
    }
    String getdetails()
    {
        DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        /*System.out.println("Name:"+this.getname());
        System.out.println("Email:"+this.getemail());
        System.out.println("Mobile no:"+this.getmob());
        System.out.println("Date of meeting:"+df.format(when));
        System.out.println("Place of meeting "+where);
        System.out.println("Circumstances of meeting "+cir);
        System.out.println("Additional Info "+info);*/
        return("Casual Acquaintance\nName:"+this.getname()+"\nEmail:"+this.getemail()+"\nMobile no:"+Long.toString(this.getmob())+"\nDate of meeting:"+df.format(when)+"\nPlace of meeting "+where+"\nCircumstances of meeting "+cir+"\nAdditional Info "+info);
        
        
    }
   
}
