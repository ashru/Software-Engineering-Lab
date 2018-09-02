package STCM;

import java.io.*;
class Participant extends Person
{
    public String org_name;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    
    
    Participant()
    {
        
        org_name="";
    }
    Participant(String Org_name,String name,String address,String email_id,long mobile_no)
    {
        super(name,address,email_id,mobile_no);
        this.org_name=Org_name;
        
        
        
        
    }
    
    
    
    public void ModifyOrg()throws IOException
    {
		System.out.println("Enter Organization:");
		String org_name=br.readLine();
        this.org_name=org_name;
    }
    public void printparticipant()
    {
        this.printperson();
        System.out.println("Organization name:"+this.org_name);
        
    }
    
}