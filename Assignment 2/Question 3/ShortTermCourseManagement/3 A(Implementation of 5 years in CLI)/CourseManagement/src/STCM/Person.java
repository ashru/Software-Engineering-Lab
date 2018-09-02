package STCM;
import java.io.*;
class Person
{
    public String name,address,email_id;long mobile_no;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    
    
    Person()
    {
        name="";
        address="";
        email_id="";
        mobile_no=0;
        
    }
    Person(String name,String address,String email_id,long  mobile_no)
    {
        this.name=name;
        this.address=address;
        this.email_id=email_id;
        this.mobile_no=mobile_no;
        
        
        
    }
    public void ModifyName()throws IOException
    {
		System.out.println("Enter Name:");
		String new_name=br.readLine();
        this.name=new_name;
    }
    public void ModifyAddress()throws IOException
    {
		System.out.println("Enter Address");
		String new_add=br.readLine();
        this.address=new_add;
    }
    public  void ModifyEmail()throws IOException
    {
		System.out.println("Enter new Email:");
		String new_email=br.readLine();
        this.email_id=new_email;
    }
    
    public void ModifyMob()throws IOException
    {
		System.out.println("Enter Mobile number:");
        long new_mob=0;int flag=0;
        while(flag==0)
        {
        try
		{ new_mob=Long.parseLong(br.readLine());flag=1;}catch(Exception e){flag=0;System.out.println("Invalid mobile no.Re-enter");}
        }
        this.mobile_no=new_mob;
    }
    
    public void printperson()
    {
        System.out.println("Name:"+this.name);
        System.out.println("Address:"+this.address);
        System.out.println("Email id:"+this.email_id);
        System.out.println("Mobile number:"+this.mobile_no);
    }
    
}