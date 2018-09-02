package STCM;
import java.io.*;
class Faculty extends Person
{
    String Department;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    
    boolean course_coordinator;
    Faculty()
    {
        
        Department="";
        
        course_coordinator=false;
    }
    Faculty(String Department,String name,String address,String email_id,long mobile_no,boolean course_coordinator)
    {
        super(name,address,email_id,mobile_no);
        this.Department=Department;
        
        this.course_coordinator=course_coordinator;
        
        
    }
    
    public void ModifyDep()throws IOException
    {
		System.out.println("Enter Department:");
		String new_dep=br.readLine();
        this.Department=new_dep;
    }
    
    public void ModifyStatus(boolean co)
    {
        this.course_coordinator=co;
    }
    void printfaculty()
    {
        this.printperson();
        System.out.println("Department:"+this.Department);
        
    }
    
}