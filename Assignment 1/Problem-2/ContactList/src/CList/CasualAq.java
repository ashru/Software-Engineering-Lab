package CList;
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
    void getdetails()//prints details of its object
    {
        DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Contact Details:");
        System.out.println("Name:"+this.getname());
        System.out.println("Email:"+this.getemail());
        System.out.println("Mobile no:"+this.getmob());
        System.out.println("Date of meeting:"+df.format(when));
        System.out.println("Place of meeting "+where);
        System.out.println("Circumstances of meeting "+cir);
        System.out.println("Additional Info "+info);
        
        
    }
   
}