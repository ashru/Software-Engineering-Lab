package STCM;
import java.io.*;
import java.util.*;
import java.text.*;
class CourseManagement
{
    static final int MAXCOURSE=1000; static final int MAXPERYEAR=10;
    
static void modify(Course c[],int k,int n)throws IOException/*function to modify course parameters:the course array,the index of course to be modified and total no of courses*/
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int ch;
        System.out.println("Press 1 to modify Course name.Any other key to retain previous name.");
        ch=0;
        try{ch=Integer.parseInt(br.readLine());}catch(Exception e){}
        if(ch==1)
        {
            c[k].modifycname();
        }
        System.out.println("Press 1 to modify Course fees.Any other key to retain previous fees.");
        try{ch=Integer.parseInt(br.readLine());}catch(Exception e){}
        if(ch==1)
        {
            c[k].modifyfees();
        }
        System.out.println("Press 1 to modify Course start date.Any other key to retain previous start date.");
        try{ch=Integer.parseInt(br.readLine());}catch(Exception e){}
        if(ch==1)
        {
            c[k].modifydate();
        }
        System.out.println("Press 1 to modify Course duration.Any other key to retain previous duration.");
        try{ch=Integer.parseInt(br.readLine());}catch(Exception e){}
        if(ch==1)
        {
            c[k].modifydur();
        }
        System.out.println("Press 1 to modify Course Co-ordinator.Any other key to retain previous details.");
        try{ch=Integer.parseInt(br.readLine());}catch(Exception e){}
        if(ch==1)
        {
            modifyfac(c[k].Co_ordinator);
        }
        
        /*while(true)
        {
            System.out.println("Here is the list of instructors.Press the index number to modify corresponding faculty.Press any other key to keep all insructor details same:");
        for(int i=0;i<c[k].no_of_instructors;++i)
            System.out.println((i+1)+": "+c[k].instructors[i].name);
            System.out.println("Enter index number of faculty to modify(Enter any ther index to exit this menu):");   
            try{ch=Integer.parseInt(br.readLine());}catch(Exception e){System.out.println("Invalid Index.Returning...");}
            if(ch>=1 && ch<=c[k].no_of_instructors)
            {
                System.out.println("Press 1 to modify details,2 to delete faculty from list,any other key to go to previous menu");
                int r=0;
                try{r=Integer.parseInt(br.readLine());}catch(Exception e){}
                
                if(r==1)
                    modifyfac(c[k].instructors[ch-1]);
                else if(r==2)
                deletefac(c,k,n,ch-1);
            }
            else break;
        }
        
        while(true)
        {
            System.out.println("Here is the list of participants.Press the index number to modify corresponding participant.Press any other key to keep all participant details same:");
        for(int i=0;i<c[k].no_of_students;++i)
            System.out.println((i+1)+": "+c[k].students[i].name);
            System.out.println("Enter index number of participant to modify(Enter any ther index to exit this menu):");   
            try{ch=Integer.parseInt(br.readLine());}catch(Exception e){System.out.println("Invalid Index.Returning...");}
            if(ch>=1 && ch<=c[k].no_of_students)
            {
                System.out.println("Press 1 to modify details,2 to delete student from list,any other key to go to previous menu");
                int r=0;
                try{ r=Integer.parseInt(br.readLine());}catch(Exception e){}
                if(r==1)
                    modifystud(c[k].students[ch-1]);
                else if(r==2)
                deletestud(c,k,n,ch-1);
            }
            else break;
        }*/

        
        

        
        
    }
    static void DisplayMenu()/*Displays main menu*/
    {
        System.out.println("Press 1 to create new course");
        System.out.println("Press 2 to display all courses(within 5 year)");
        System.out.println("Press 3 to create new participants for a course");

        System.out.println("Press 4 to display all participants registered for a course");
        System.out.println("Press 5 to delete a course");
        System.out.println("Press 6 to alter details of a course");
        System.out.println("Press 7 to delete a Faculty");
        System.out.println("Press 8 to alter details of a Faculty");
        System.out.println("Press 9 to delete a participant");
        System.out.println("Press 10 to alter details of a participant");
        System.out.println("Press 11 to create new instructors for a course");
        System.out.println("Press 12 to display all instructors for a course");
        System.out.println("Press 13 to display all courses with complete faculty and instructors details");
        
    }
    static int createnewcourse(Course c[],int n,int no_in_y[])throws IOException/*Creates new course parameters:Course array,no_of_courses present*/
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s1;
        
        long fees;
        int dur,nins,npar,i,flag=0;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        System.out.println("Enter Course Name:");
        s1=br.readLine();
        fees=0;
        System.out.println("Enter Course Fees:");
        while(flag==0){
        try{fees=Long.parseLong(br.readLine());flag=1;
        }
        catch(Exception e){flag=0;exceptionhandling();}
        }
         flag=0;
        Date d1=new Date();
        while(flag==0)
        {
            try
            {
                System.out.println("Enter Start date(in dd/mm/yyyy format) :");
                d1=(Date)df.parse(br.readLine());
                if(withinYear(d1)!=-1){
                	int g8=withinYear(d1);
                	if(no_in_y[g8]==MAXPERYEAR)
                	{
                		System.out.println("No more courses allowed in the date of this  academic year.Exiting....");
                		return 0;
                	}
                	++no_in_y[g8];
                	
                }
                
                
                flag=1;
            }
            catch(ParseException e) 
            {
                flag=0;exceptionhandling();
            }
            
            
        
            
            
 
       }
        
        
        
        dur=0;
        System.out.println("Enter duration(in days) of course:");
        flag=0;
        while(flag==0){
        try{dur=Integer.parseInt(br.readLine());flag=1;if(dur>14 || dur<0){System.out.println("Duration must be less than 14 days ");flag=0;}
        }
        catch(Exception e){flag=0;exceptionhandling();}
        }
        
        System.out.println("Enter details of course co-ordinator");
        Faculty cc=createfac(true);
        System.out.println("Enter number of instructors(<=5):");
        flag=0;
        nins=0;npar=0;
        while(flag==0){
        try{nins=Integer.parseInt(br.readLine());flag=1;if(nins>5 || nins<0){exceptionhandling();flag=0;}
        }
        catch(Exception e){flag=0;exceptionhandling();}
        }

        
        Faculty ins[]=new Faculty[5];
        for(i=0;i<nins;++i)
        {
            System.out.println("Enter details of instructor "+(i+1)+" :");
            ins[i]=createfac(false);
        }
        System.out.println("Enter number of participants(<=5):");
        flag=0;
        while(flag==0){
        try{npar=Integer.parseInt(br.readLine());flag=1;if(npar>5 || npar<0){exceptionhandling();flag=0;}
        }
        catch(Exception e){flag=0;exceptionhandling();}
        }
        Participant par[]=new Participant[5];
        for(i=0;i<npar;++i)
        {
            System.out.println("Enter details of paricipant "+(i+1)+" :");
            par[i]=createpar();
        }
        c[n]=new Course(s1,d1,fees,dur,nins,npar,cc,ins,par);
        
        
            
            
            
        
        return 1;
        
        
        
    }
    static Faculty createfac(boolean cc)throws IOException/*Create a new faculty.Boolean value is true if faculty is a course co-ordinator*/
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s1,s2,s3,s4,s5;long l=0;
        System.out.println("Enter name:");
        s1=br.readLine();
        System.out.println("Enter Department:");
        s2=br.readLine();
        System.out.println("Enter Address:");
        s3=br.readLine();
        System.out.println("Enter Email id:");
        s4=br.readLine();
        System.out.println("Enter Mobile number");
        int flag=0;
        while(flag==0)
        {
            try
            {
                    l=Long.parseLong(br.readLine());
                    flag=1;}
            catch(Exception e){flag=0;exceptionhandling();}}
        Faculty f=new Faculty(s2,s1,s3,s4,l,cc);
        return f;
    }
    static Participant createpar()throws IOException/*creates a new participant*/
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s1,s2,s3,s4,s5;long l=0;
        System.out.println("Enter name:");
        s1=br.readLine();
        System.out.println("Enter Organization:");
        s2=br.readLine();
        System.out.println("Enter Address:");
        s3=br.readLine();
        System.out.println("Enter Email id:");
        s4=br.readLine();
        System.out.println("Enter Mobile number");
        int flag=0;
        while(flag==0)
        {
            try
            {
                    l=Long.parseLong(br.readLine());
                    flag=1;}
            catch(Exception e){flag=0;exceptionhandling();}}
        Participant f=new Participant(s2,s1,s3,s4,l);
        return f;
    }
    
    static void deletecourse(Course c[],int del,int n)/*deletes a course at index del of course array c containing n courses*/
    {
        int i;
        for(i=del;i<n-1;++i)
            c[i]=c[i+1];
            System.out.println("Deletion Successful");
    }
    static void deletestud(Course c[],int k,int n,int del)/*deletes a faculty at index del of instructors array in course at index k  of course array c containing n courses*/
    {
        int i;
        for(i=del;i<c[k].no_of_students-1;++i)
            c[k].students[i]=c[k].students[i+1];
        c[k].no_of_students--;
         System.out.println("Deletion Successful");
    }
    static void deletefac(Course c[],int k,int n,int del)/*deletes a participant at index del of students array in course at index k  of course array c containing n courses*/
    {

        int i;
        for(i=del;i<c[k].no_of_instructors-1;++i)
            c[k].instructors[i]=c[k].instructors[i+1];
        c[k].no_of_instructors--;
         System.out.println("Deletion Successful");
    }
    static void modifystud(Participant p)throws IOException/*Modifies details of participant*/
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int ch=0;
        System.out.println("Press 1 to modify Student name.Any other key to retain previous name.");
        try{
        ch=Integer.parseInt(br.readLine());}
        catch(Exception e){}
        if(ch==1)
        {
            p.ModifyName();
        }
        ch=0;
        System.out.println("Press 1 to modify Address.Any other key to retain previous address.");
        try{
        ch=Integer.parseInt(br.readLine());}
        catch(Exception e){}
        if(ch==1)
        {
            p.ModifyAddress();
        }
        ch=0;
        System.out.println("Press 1 to modify Email Id.Any other key to retain previous email.");
        try{
        ch=Integer.parseInt(br.readLine());}
        catch(Exception e){}
        if(ch==1)
        {
            p.ModifyEmail();
        }
        ch=0;
        System.out.println("Press 1 to modify Mobile number.Any other key to retain previous number.");
        try{
        ch=Integer.parseInt(br.readLine());}
        catch(Exception e){}
        if(ch==1)
        {
            p.ModifyMob();
        }
        ch=0;
        System.out.println("Press 1 to modify Organization.Any other key to retain previous one.");
        try{
        ch=Integer.parseInt(br.readLine());}
        catch(Exception e){}
        if(ch==1)
        {
            p.ModifyOrg();
        }
    }
    static void modifyfac(Faculty f)throws IOException/*Modifies faculty details*/
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int ch=0;
        System.out.println("Press 1 to modify Faculty Name.Any other key to retain previous name.");
        try{
        ch=Integer.parseInt(br.readLine());}
        catch(Exception e){}
        if(ch==1)
        {
            f.ModifyName();
        }
        ch=0;
        System.out.println("Press 1 to modify Address.Any other key to retain previous address.");
        try{
        ch=Integer.parseInt(br.readLine());}
        catch(Exception e){}
        if(ch==1)
        {
            f.ModifyAddress();
        }
        ch=0;

        System.out.println("Press 1 to modify Email Id.Any other key to retain previous email.");
        try{
        ch=Integer.parseInt(br.readLine());}
        catch(Exception e){}
        if(ch==1)
        {
            f.ModifyEmail();
        }
        ch=0;
        System.out.println("Press 1 to modify Mobile number.Any other key to retain previous number.");
        try{
        ch=Integer.parseInt(br.readLine());}
        catch(Exception e){}
        if(ch==1)
        {
            f.ModifyMob();
        }
        ch=0;
        System.out.println("Press 1 to modify Department.Any other key to retain previous one.");
        try{
        ch=Integer.parseInt(br.readLine());}
        catch(Exception e){}
        if(ch==1)
        {
            f.ModifyDep();
        }
    }
    static void displayallcourses(Course c[],int n)/*display name of all courses*/
    {
        int i;
        
        for(i=0;i<n;++i)
            System.out.println((i+1)+": "+c[i].Course_name);
            if(n==0)
        System.out.println("No courses to display!!");

    } 
   
        
        
        
    
    static void exceptionhandling()//Error message
    {
        System.out.println("Invalid Input.Try again!");
        
    }
    
    
    static void writefile(Course c[],int no_of_courses,int no_in_year[])throws IOException//write the records to a text file
    {
        File f2 = new File("CourseManagement.txt");
                FileWriter writer2 = new FileWriter(f2);
                int i;
                int n1=no_of_courses;
                
                writer2.write(Integer.toString(no_of_courses)+System.getProperty( "line.separator" ));
                for(i=0;i<5;++i)
                writer2.write(Integer.toString(no_in_year[i])+System.getProperty( "line.separator" ));
                
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                df.setLenient(false);
                
                 
                for(i=0;i<n1;++i)
                {
                    
                    writer2.write(c[i].Course_name+System.getProperty( "line.separator" ));
                    writer2.write(Long.toString(c[i].Course_fees)+System.getProperty( "line.separator" ));
                    writer2.write(df.format(c[i].start_date)+System.getProperty( "line.separator" ));
                    writer2.write(Integer.toString(c[i].duration)+System.getProperty( "line.separator" ));
                    writer2.write(c[i].Co_ordinator.name+System.getProperty( "line.separator" ));
                    writer2.write(c[i].Co_ordinator.Department+System.getProperty( "line.separator" ));
                    writer2.write(c[i].Co_ordinator.address+System.getProperty( "line.separator" ));
                    writer2.write(c[i].Co_ordinator.email_id+System.getProperty( "line.separator" ));
                    writer2.write(c[i].Co_ordinator.mobile_no+System.getProperty( "line.separator" ));
                    writer2.write(Integer.toString(c[i].no_of_instructors)+System.getProperty( "line.separator" ));
                    writer2.write(Integer.toString(c[i].no_of_students)+System.getProperty( "line.separator" ));
                    int j;
                    for(j=0;j<c[i].no_of_instructors;++j)
                    {
                        writer2.write(c[i].instructors[j].name+System.getProperty( "line.separator" ));
                        writer2.write(c[i].instructors[j].Department+System.getProperty( "line.separator" ));
                        writer2.write(c[i].instructors[j].address+System.getProperty( "line.separator" ));
                        writer2.write(c[i].instructors[j].email_id+System.getProperty( "line.separator" ));
                        writer2.write(c[i].instructors[j].mobile_no+System.getProperty( "line.separator" ));
                    }
                    for(j=0;j<c[i].no_of_students;++j)
                    {
                        writer2.write(c[i].students[j].name+System.getProperty( "line.separator" ));
                        writer2.write(c[i].students[j].org_name+System.getProperty( "line.separator" ));
                        writer2.write(c[i].students[j].address+System.getProperty( "line.separator" ));
                        writer2.write(c[i].students[j].email_id+System.getProperty( "line.separator" ));
                        writer2.write(c[i].students[j].mobile_no+System.getProperty( "line.separator" ));
                    }
                }    
                writer2.flush();
                writer2.close();
    }
    public static  int withinYear(Date inputDate)//checks if date is within a year of today's date
    {
   GregorianCalendar calToday = new GregorianCalendar();
GregorianCalendar oneYearAgoTodayAtMidnight = new GregorianCalendar(calToday.get(Calendar.YEAR) - 1, calToday.get(Calendar.MONTH), calToday.get(Calendar.DATE));
   
    Date date1 = oneYearAgoTodayAtMidnight.getTime();

    if (date1.compareTo(inputDate)<=0)
             return 1;
    GregorianCalendar oneYearAgoTodayAtMidnight2 = new GregorianCalendar(calToday.get(Calendar.YEAR) - 2, calToday.get(Calendar.MONTH), calToday.get(Calendar.DATE));
    
    Date date2 = oneYearAgoTodayAtMidnight2.getTime();
    
    if (date2.compareTo(inputDate)<=0)
        return 2;
    
    GregorianCalendar oneYearAgoTodayAtMidnight3 = new GregorianCalendar(calToday.get(Calendar.YEAR) - 3, calToday.get(Calendar.MONTH), calToday.get(Calendar.DATE));
    
    Date date3 = oneYearAgoTodayAtMidnight3.getTime();
    
    if (date3.compareTo(inputDate)<=0)
        return 3;
    
    
    GregorianCalendar oneYearAgoTodayAtMidnight4 = new GregorianCalendar(calToday.get(Calendar.YEAR) - 4, calToday.get(Calendar.MONTH), calToday.get(Calendar.DATE));
    
    Date date4 = oneYearAgoTodayAtMidnight4.getTime();
    
    if (date4.compareTo(inputDate)<=0)
        return 4;
    GregorianCalendar oneYearAgoTodayAtMidnight5 = new GregorianCalendar(calToday.get(Calendar.YEAR) - 5, calToday.get(Calendar.MONTH), calToday.get(Calendar.DATE));
    
    Date date5 = oneYearAgoTodayAtMidnight5.getTime();
    if (date5.compareTo(inputDate)<=0)
        return 5;
            return -1;

        }
    public static void main(String args[])throws IOException 
    {
        int ch,i;
        System.out.println("Welcome to SHORT TERM COURSE MANAGEMENT");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int no_of_courses=0;int no_in_year[]=new int[5];for(i=0;i<5;++i)no_in_year[i]=0;
        Course c[]=new Course[MAXCOURSE];
        Date td=new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        int flag=1;
        File f = new File("CourseManagement.txt");
        
        if(!f.exists() && !f.isDirectory())
        {
            f.createNewFile();
            FileWriter writer =new FileWriter(f); 
      
            writer.write("0"); 
            writer.flush();
            writer.close();
        }
        
        Scanner rd1 = new Scanner(new FileReader("CourseManagement.txt"));
        int x;
        try{
         x=Integer.parseInt(rd1.nextLine());}
        catch(Exception e)
        {x=0;}
        rd1.close();
        if(x!=0)
        {
            System.out.println("There already exists a record of Course.\nPress 1 to retrieve the record and work on it.\nPress any other key to erase the existing record and create a completely new one");
            int vg=0;
            try{
        vg=Integer.parseInt(br.readLine());}
        catch(Exception e){}
            if(vg==1)
            {
                Scanner rd = new Scanner(new FileReader("CourseManagement.txt"));
                no_of_courses=Integer.parseInt(rd.nextLine());int n3=no_of_courses,o;
                for(int i1=0;i1<5;++i1)
                {
                no_in_year[i1]=Integer.parseInt(rd.nextLine());
                }
                for(i=0,o=0;i<n3;++i)
                {
                     flag=1;
                    String name=rd.nextLine();
                    
                    Long fs=Long.parseLong(rd.nextLine());
                    Date  star=new Date();
                    try{
                    star=(Date)df.parse(rd.nextLine());
                
                    }
                    catch(Exception e){}
                    int du=Integer.parseInt(rd.nextLine());
                    String ncc=rd.nextLine();
                    String ccd=rd.nextLine();
                    String cca=rd.nextLine();
                    String cce=rd.nextLine();
                    long ccn=Long.parseLong(rd.nextLine());
                    int n1=Integer.parseInt(rd.nextLine());
                    int n2=Integer.parseInt(rd.nextLine());
                    int j;
                    Faculty f1[]=new Faculty[5];
                    Faculty fc;
                    Participant s[]=new Participant[5];
                    fc=new Faculty(ccd,ncc,cca,cce,ccn,true);
                    for(j=0;j<n1;++j)
                    {
                        ncc=rd.nextLine();
                        ccd=rd.nextLine();
                        cca=rd.nextLine();
                        cce=rd.nextLine();
                        ccn=Long.parseLong(rd.nextLine());
                        f1[j]=new Faculty(ccd,ncc,cca,cce,ccn,false);
                    }
                    for(j=0;j<n2;++j)
                    {
                        ncc=rd.nextLine();
                        ccd=rd.nextLine();
                        cca=rd.nextLine();
                        cce=rd.nextLine();
                        ccn=Long.parseLong(rd.nextLine());
                        s[j]=new Participant(ccd,ncc,cca,cce,ccn);
                    }
                    if(flag!=0){
                        
                        c[o]=new Course(name,star,fs,du,n1,n2,fc,f1,s);++o;}
                    
                        
                    
                    
                    
                }
                
            }
            
        
            
        }
        
        
        
        int sf=0;int flagg=1;
        while(flagg==1)
        {
            if(sf==1)
            {
                System.out.println("Enter 1 to display Main Menu.Any other key to exit!");
                int p=0;
                try{
                    p=Integer.parseInt(br.readLine());}
                    catch(Exception e){}
                if(p!=1)
                break;
            }
            DisplayMenu();if(sf==0)sf=1;
            ch=0;
            try{
            ch=Integer.parseInt(br.readLine());}
            catch(Exception e){}
            switch(ch)
            {
                case 1: 
                	
                if(no_of_courses==MAXCOURSE)
                {System.out.println("Maximum number of Courses  reached.Cannot create anymore Courses.Exiting to menu");break;}
                
                int t=createnewcourse(c,no_of_courses,no_in_year);
                if(t!=0)
                ++no_of_courses;
                writefile(c,no_of_courses,no_in_year);
                        
                        break;
                case 2:
                	
                if(no_of_courses==0 ||(no_in_year[0]+no_in_year[1]+no_in_year[2]+no_in_year[3]+no_in_year[4])==0)
                {
                    System.out.println("There are currently no saved courses within 5 years ");break;
                }
                        System.out.println("Displaying all courses within 5 year:");
                                System.out.println("S.No.   Name\t\t\t\tCoordinator\t\tFees\t\tDate\t\tDuration\tNo of instructors\t No of students");
                                int j=0;
                    for(i=0;i<no_of_courses;++i)
                        
                    { 
                        
                    	if(withinYear(c[i].start_date)==-1)
                    	{continue;}
                    	++j;
                        System.out.printf("%-2s\t%-30s\t%-20s\t%-13s\t%-8s\t%-2s\t\t%-2s\t\t\t\t%-2s%n",j,c[i].Course_name,c[i].Co_ordinator.name,c[i].Course_fees,df.format(c[i].start_date),c[i].duration,c[i].no_of_instructors,c[i].no_of_students);

                    }
                    
                        break;
                case 3:
                if(no_of_courses==0)
                {
                    System.out.println("There are currently no saved courses ");break;
                }
                displayallcourses(c,no_of_courses);
                System.out.println("Enter the Course Index ");
                flag=0;int k=0;
                int flag1=0;
                while(flag==0)
                {
                    try{
                k=Integer.parseInt(br.readLine());
                flag=1;
                if(k<=0 ||k>no_of_courses)
                    {System.out.println("Sorry,Invalid Entry.Re-enter ");flag=0;}}
                catch(Exception e){flag=0;exceptionhandling();}
                }
                k--;
                
                
                    char p='y';
                    if(c[k].no_of_students==5)
                        {System.out.println("Maximum number of participants reached.Cannot create anymore participants for this course.Exiting to menu");break;}
                    
                         c[k].students[c[k].no_of_students]=new Participant();
                        c[k].students[c[k].no_of_students]=createpar();
                        c[k].no_of_students++;
                        
                writefile(c,no_of_courses,no_in_year);
                break;
                case 4:
                if(no_of_courses==0)
                {
                    System.out.println("There are currently no saved courses ");break;
                }
                displayallcourses(c,no_of_courses);
                System.out.println("Enter the Course Index ");
                flag=0;k=0;
                while(flag==0)
                {
                    try{
                k=Integer.parseInt(br.readLine());
                flag=1;
                if(k<=0 ||k>no_of_courses)
                    {System.out.println("Sorry,Invalid Entry.Re-enter ");flag=0;}}
                catch(Exception e){flag=0;exceptionhandling();}}
                
                k--;
                
                    for(i=0;i<c[k].no_of_students;++i)
                    {
                        System.out.println("Participant "+(i+1));
                        c[k].students[i].printparticipant();
                    }
                
                break;
            
                case 5:
                if(no_of_courses==0)
                {
                    System.out.println("There are currently no saved courses ");break;
                }
                displayallcourses(c,no_of_courses);
                System.out.println("Enter the Course Index ");
                flag=0;k=0;
                while(flag==0)
                {
                    try{
                k=Integer.parseInt(br.readLine());
                flag=1;
                if(k<=0 ||k>no_of_courses)
                    {System.out.println("Sorry,Invalid Entry.Re-enter ");flag=0;}}
                catch(Exception e){flag=0;exceptionhandling();}}
                
                
                    deletecourse(c,k-1,no_of_courses);
                    no_of_courses--;
                    int g8=withinYear(c[k-1].start_date);
                    no_in_year[g8]--;
                    writefile(c,no_of_courses,no_in_year);
                
                break;
                case 6:
                if(no_of_courses==0)
                {
                    System.out.println("There are currently no saved courses ");break;
                }
                displayallcourses(c,no_of_courses);
                System.out.println("Enter the Course Index ");
                flag=0;k=0;
                while(flag==0)
                {
                    try{
                k=Integer.parseInt(br.readLine());
                flag=1;
                if(k<=0 ||k>no_of_courses)
                    {System.out.println("Sorry,Invalid Entry.Re-enter ");flag=0;}}
                catch(Exception e){flag=0;exceptionhandling();}}
                
                
                    modify(c,k-1,no_of_courses);
                    
                        writefile(c,no_of_courses,no_in_year);
                   
                    break;
                case 7:
                if(no_of_courses==0)
                {
                    System.out.println("There are currently no saved courses ");break;
                }
                for(i=0;i<no_of_courses;++i)
                {
                    System.out.println((i+1)+"."+"Course: "+c[i].Course_name);
                    
                }
                System.out.println("Enter index of course of faculty:");
                 int cn=0;
                    try
                    {cn=Integer.parseInt(br.readLine());}
                    catch(Exception e){System.out.println("Invalid Index");}
                if(cn>0 && cn<=no_of_courses)
                {
                    for(int s=0;s<c[cn-1].no_of_instructors;++s)
                    System.out.println("Instructor "+(s+1)+": "+c[cn-1].instructors[s].name);
                    if(c[cn-1].no_of_instructors==0) {System.out.println("No Instructor for this course");break;}
                    else
                    System.out.println("Enter index of  faculty in the corresponding course:");
                    int cn2=0;
                    try{
                        cn2=Integer.parseInt(br.readLine());}
                    catch(Exception e)
                    {System.out.println("Invalid Index");}
                    if(cn2>0 && cn2<=c[cn-1].no_of_instructors)
                        deletefac(c,cn-1,no_of_courses,cn2-1);
                    else
                         System.out.println(cn-1+"Invalid Index");

                }
                else
                         System.out.println("Invalid Index");
                writefile(c,no_of_courses,no_in_year);
                break;
                case 8:
                if(no_of_courses==0)
                {
                    System.out.println("There are currently no saved courses ");break;
                }
                for(i=0;i<no_of_courses;++i)
                {
                    System.out.println((i+1)+"."+"Course: "+c[i].Course_name);
                    
                }
                System.out.println("Enter index of course of faculty:");
                 cn=0;
                    try
                    {cn=Integer.parseInt(br.readLine());}
                    catch(Exception e){System.out.println("Invalid Index");}
                if(cn>0 && cn<=no_of_courses)
                {
                    for(int s=0;s<c[cn-1].no_of_instructors;++s)
                    System.out.println("Instructor "+(s+1)+": "+c[cn-1].instructors[s].name);
                    if(c[cn-1].no_of_instructors==0) {System.out.println("No Instructor for this course");break;}
                    else
                    System.out.println("Enter index of  faculty in the corresponding course:");
                    int cn2=0;
                    try
                    {cn2=Integer.parseInt(br.readLine());}
                    catch(Exception e){System.out.println("Invalid Index");}
                    if(cn2>0 && cn2<=c[cn-1].no_of_instructors)
                        modifyfac(c[cn-1].instructors[cn2-1]);
                    else
                         System.out.println("Invalid Index");

                }
                else
                         System.out.println("Invalid Index");
                         writefile(c,no_of_courses,no_in_year);
                         break;
                case 9:
                if(no_of_courses==0)
                {
                    System.out.println("There are currently no saved courses ");break;
                }
                
                for(i=0;i<no_of_courses;++i)
                {
                    System.out.println((i+1)+"."+"Course: "+c[i].Course_name);
                    
                }
                System.out.println("Enter index of course of participant:");
                cn=0;
                    try
                    {cn=Integer.parseInt(br.readLine());}
                    catch(Exception e){System.out.println("Invalid Index");}
                if(cn>0 && cn<=no_of_courses)
                {
                    
                    
                    for(int s=0;s<c[cn-1].no_of_students;++s)
                    System.out.println((s+1)+": "+c[cn-1].students[s].name);
                    if(c[cn-1].no_of_students==0){ System.out.println("No Participant for this course");break;}
                    else
                    System.out.println("Enter index of  partcipant  in the corresponding course:");
                    int cn2=0;
                    try
                    {cn2=Integer.parseInt(br.readLine());}
                    catch(Exception e){System.out.println("Invalid Index");}
                    if(cn2>0 && cn2<=c[cn-1].no_of_students)
                        deletestud(c,cn-1,no_of_courses,cn2-1);
                    else
                         System.out.println("Invalid Index");

                }
                else
                         System.out.println("Invalid Index");
                writefile(c,no_of_courses,no_in_year);
                break;
                case 10:
                
                for(i=0;i<no_of_courses;++i)
                {
                    System.out.println((i+1)+"."+"Course: "+c[i].Course_name);
                    
                }
                System.out.println("Enter index of course of participant:");
                cn=0;
                    try
                    {cn=Integer.parseInt(br.readLine());}
                    catch(Exception e){System.out.println("Invalid Index");}
                if(cn>0 && cn<=no_of_courses)
                {
                    
                    
                    for(int s=0;s<c[cn-1].no_of_students;++s)
                    System.out.println((s+1)+": "+c[cn-1].students[s].name);
                    if(c[cn-1].no_of_students==0) {System.out.println("No Participant for this course");break;}
                    else
                    System.out.println("Enter index of  partcipant  in the corresponding course:");
                    int cn2=0;
                    try
                    {cn2=Integer.parseInt(br.readLine());}
                    catch(Exception e){System.out.println("Invalid Index");}
                    if(cn2>0 && cn2<=c[cn-1].no_of_students)
                        modifystud(c[cn-1].students[cn2-1]);
                    else
                         System.out.println("Invalid Index");

                }
                else
                         System.out.println("Invalid Index");
                writefile(c,no_of_courses,no_in_year);
                break;
                case 11:
                if(no_of_courses==0)
                {
                    System.out.println("There are currently no saved courses ");break;
                }
                displayallcourses(c,no_of_courses);
                System.out.println("Enter the Course Index ");
                flag=0; k=0;
                flag1=0;
                while(flag==0)
                {
                    try{
                k=Integer.parseInt(br.readLine());
                flag=1;
                if(k<=0 ||k>no_of_courses)
                    {System.out.println("Sorry,Invalid Entry.Re-enter ");flag=0;}}
                catch(Exception e){flag=0;exceptionhandling();}
                }
                    k--;
                
                    p='y';
                    if(c[k].no_of_instructors==5)
                        {System.out.println("Maximum number of instructors reached.Cannot create anymore instructors for this course.Exiting to menu");break;}
                    
                        c[k].instructors[c[k].no_of_instructors]=new Faculty();
                        c[k].instructors[c[k].no_of_instructors]=createfac(false);
                        c[k].no_of_instructors++;
                        writefile(c,no_of_courses,no_in_year);
                break;
                case 12:
                
                if(no_of_courses==0)
                {
                    System.out.println("There are currently no saved courses ");break;
                }
                displayallcourses(c,no_of_courses);
                System.out.println("Enter the Course Index ");
                flag=0;k=0;
                while(flag==0)
                {
                    try{
                k=Integer.parseInt(br.readLine());
                flag=1;
                if(k<=0 ||k>no_of_courses)
                    {System.out.println("Sorry,Invalid Entry.Re-enter ");flag=0;}}
                catch(Exception e){flag=0;exceptionhandling();}}
                
                k--;
                
                    for(i=0;i<c[k].no_of_instructors;++i)
                    {
                        System.out.println("Instructor "+(i+1));
                        c[k].instructors[i].printfaculty();
                    }
                
                break;
                case 13:
                	
                if(no_of_courses==0)
                {
                    System.out.println("There are currently no saved courses ");break;
                }
                        
                                
                    for(i=0;i<no_of_courses;++i)
                        
                    { 
                        System.out.println("Course "+(i+1)+":");
                        c[i].displaycourse();
                    	

                    }
                    
                        break;
            
                
                
            }
            
            
        }
        
                
        }
    }


