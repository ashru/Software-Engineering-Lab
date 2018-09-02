package CList;
import java.io.*;
import java.util.*;
import java.text.*;
class professionalFriends extends Acquaintance
{
    String scpi;
    
    professionalFriends(String c,String name,String email,long  mobile_no)
    {
        super(name,email,mobile_no);
        this.scpi=c;
        
    }
    String getscpi()
    {
    	return scpi;
    }
    void getdetails()//prints details of its object
    {
        DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Contact Details:");
        System.out.println("Name:"+this.getname());
        System.out.println("Email:"+this.getemail());
        System.out.println("Mobile no:"+this.getmob());
        System.out.println("Common professional Interest:"+scpi);
        
    }
}