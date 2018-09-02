package STCM;
import java.io.*;
import java.util.*;
import java.text.*;
import java.nio.*;

class Course
{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public String Course_name;
    public Date start_date;
    public long Course_fees;
    public int duration;
    public Faculty Co_ordinator;
    Faculty instructors[]=new Faculty[5];
    Participant students[]=new Participant[5];
    public int no_of_instructors;
    public int no_of_students;
    Course(String Course_name,Date start,long fees,int duration,int no_of_ins,int no_of_std,Faculty cc,Faculty ins[],Participant std[])
    {
        this.Course_name=Course_name;
        this.Course_fees=fees;
        this.duration=duration;
        this.no_of_instructors=no_of_ins;
        this.no_of_students=no_of_std;
        this.start_date=start;
        this.Co_ordinator=cc;
        int i;
        for(i=0;i<this.no_of_instructors;++i)
            {this.instructors[i]=new Faculty();this.instructors[i]=ins[i];}
        for(i=0;i<this.no_of_students;++i)
            {this.students[i]=new Participant();this.students[i]=std[i];}
    }
    void modifycname()throws IOException
    {
        System.out.println("Enter Course Name:");
        this.Course_name=br.readLine();
    }
    void modifyfees()throws IOException
    {
        int flag=0;
        while(flag==0)
        {try
        {System.out.println("Enter Course Fees:");
        this.Course_fees=Long.parseLong(br.readLine());
        flag=1;}
        catch(Exception e)
        {flag=0;System.out.println("Invalid Input.Please re-enter!");}
    }
    }
    void modifydate()throws IOException
    {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        int flag=0;
        Date d1=new Date();
        while(flag==0)
        {
            try
            {
                System.out.println("Enter Start date(in dd/mm/yyyy format) (course with date earlier than 1yr will not be recorded:");
                d1=(Date)df.parse(br.readLine());
                this.start_date=d1;
                flag=1;
            }
            catch(ParseException e) 
            {
                flag=0;System.out.println("Invalid Input.Please re-enter!");
            }
            
            
        
            
            
 
       }
    }
    void modifydur()throws IOException
    {
        int flag=0;
        while(flag==0)
        {
        try{        
        System.out.println("Enter duration of course:");
        this.duration=Integer.parseInt(br.readLine());
        if(this.duration>14 || this.duration<0)
        {System.out.println("Invalid duration .Re-enter:");flag=0;}
        flag=1;
        }
        catch(Exception e)
        {flag=0;System.out.println("Invalid Input.Please re-enter!");}
    }

    }
    
    void displaycourse()//displays course details
    {
        int i;
        
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        int flag=0;

        System.out.println("Course Name: "+this.Course_name);
        System.out.println("Course Fees: "+this.Course_fees);
        System.out.println("Course start date: "+df.format(this.start_date));
        System.out.println("Course Duration: "+this.duration);
        System.out.println("Course Co-ordinator:");
        this.Co_ordinator.printfaculty();
        if(this.no_of_instructors==0)
        System.out.println("No instructors for this course!");
        else
        System.out.println("List of Instructors:");
        for(i=0;i<this.no_of_instructors;++i)
        
        {
        	System.out.println("Instructor "+i+1);
            this.instructors[i].printfaculty();
            
        }
        if(this.no_of_students==0)
        System.out.println("No students for this course!");
        else
        System.out.println("List of Participants:");
        for(i=0;i<this.no_of_students;++i)
        {
        	System.out.println("Student "+i+1);
        	this.students[i].printparticipant();
            
        }
        
        
            
    }
    
    
    
}