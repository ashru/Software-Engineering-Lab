package CList;

//the specic common professional interests (100 chars max).
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
  String getdetails()
  {
      DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
      /*System.out.println("Name:"+this.getname());
      System.out.println("Email:"+this.getemail());
      System.out.println("Mobile no:"+this.getmob());
      System.out.println("Common professional Interest:"+scpi);*/
      return("Professional Friend \nName:"+this.getname()+"\nEmail:"+this.getemail()+"\nMobile no:"+Long.toString(this.getmob())+"\nCommon professional Interest:"+scpi);

      
  }
}