package CList;  
import java.io.*;
import java.util.*;
import java.text.*;

class ContactList
{
    static final int MAX=10000;static int i;
    
    static void Filewriter(relatives r[],personalFriends p[],professionalFriends f[],casualAq c[],int tot,int rel,int per,int prof,int cas)throws IOException/*write to file*/
    {
        DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
       File f2 = new File("ContactList.txt");
                FileWriter writer2 = new FileWriter(f2);
                writer2.write(Integer.toString(tot)+System.getProperty( "line.separator" ));
                writer2.write(Integer.toString(rel)+System.getProperty( "line.separator" ));
                writer2.write(Integer.toString(per)+System.getProperty( "line.separator" ));
                writer2.write(Integer.toString(prof)+System.getProperty( "line.separator" ));
                writer2.write(Integer.toString(cas)+System.getProperty( "line.separator" ));
                
               
        for(i=0;i<rel;++i)
        {
                writer2.write(r[i].getname()+System.getProperty( "line.separator" ));
                writer2.write(r[i].getemail()+System.getProperty( "line.separator" ));
                writer2.write(Long.toString(r[i].getmob())+System.getProperty( "line.separator" ));
                writer2.write(df.format(r[i].getbd())+System.getProperty( "line.separator" ));
                writer2.write(df.format(r[i].getd())+System.getProperty( "line.separator" ));
                
        }
        for(i=0;i<per;++i)
        {
                
                writer2.write(p[i].getname()+System.getProperty( "line.separator" ));
                writer2.write(p[i].getemail()+System.getProperty( "line.separator" ));
                writer2.write(Long.toString(p[i].getmob())+System.getProperty( "line.separator" ));
                writer2.write(p[i].getcon()+System.getProperty( "line.separator" ));
                writer2.write(p[i].getevent()+System.getProperty( "line.separator" ));
                writer2.write(df.format(p[i].getdate())+System.getProperty( "line.separator" ));
                
        }
        for(i=0;i<prof;++i)
        {
                
                writer2.write(f[i].getname()+System.getProperty( "line.separator" ));
                writer2.write(f[i].getemail()+System.getProperty( "line.separator" ));
                writer2.write(Long.toString(f[i].getmob())+System.getProperty( "line.separator" ));
                writer2.write(f[i].getscpi()+System.getProperty( "line.separator" ));
                
        }
        for(i=0;i<cas;++i)
        {
                
                writer2.write(c[i].getname()+System.getProperty( "line.separator" ));
                writer2.write(c[i].getemail()+System.getProperty( "line.separator" ));
                writer2.write(Long.toString(c[i].getmob())+System.getProperty( "line.separator" ));
                writer2.write(df.format(c[i].getwhen())+System.getProperty( "line.separator" ));
                writer2.write(c[i].getwhere()+System.getProperty( "line.separator" ));
                writer2.write(c[i].getcir()+System.getProperty( "line.separator" ));
                writer2.write(c[i].getinfo()+System.getProperty( "line.separator" ));
                         
       }
                
                writer2.flush();
                writer2.close();
                 
    }
    
    static relatives createrelative(String n)throws IOException/*creates new relative.takes name as argument*/
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    
        DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        
        
        System.out.println("Enter email:");
        String em=br.readLine();
        System.out.println("Enter mobile number:");
        int flag=0;long m=0;
        while(flag==0)
        {
            try{
                m=Long.parseLong(br.readLine());
                flag=1;
            }
            catch(Exception e)
            {
                flag=0;
                System.out.println("Invalid Input.Please Re-enter!");
            }
        }
        System.out.println("Enter birthday:");
        flag=0;Date d=new Date();
        while(flag==0)
        {
            try{
                d=df.parse(br.readLine());
                flag=1;
                
            }
            catch(Exception e)
            {
                flag=0;
                System.out.println("Invalid Input.Please Re-enter!");
            }
        }
        System.out.println("Enter date of last meeting:");
        flag=0;Date d1=new Date();
        while(flag==0)
        {
            try{
                
                d1=df.parse(br.readLine());
                flag=1;
                if(d1.compareTo(d)<0)
                {
                flag=0;
                System.out.println("Invalid Input.Please Re-enter!");
                }
                
            }
            catch(Exception e)
            {
                flag=0;
                System.out.println("Invalid Input.Please Re-enter!");
            }
        }
        relatives r=new relatives(d,d1,n,em,m);
        return r;
        
    
    
    }
    static personalFriends createpersonal(String n)throws IOException/*creates new personal Friend.takes name as argument*/
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    
        DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        
        System.out.println("Enter email:");
        String em=br.readLine();
        System.out.println("Enter mobile number:");
        int flag=0;long m=0;
        while(flag==0)
        {
            try{
                m=Long.parseLong(br.readLine());
                flag=1;
            }
            catch(Exception e)
            {
                flag=0;
                System.out.println("Invalid Input.Please Re-enter!");
            }
        }
        int fl=0;String c="",e1="";
        while(fl==0){
        System.out.println("Enter context of acquaintance:");
         c=br.readLine();
    if(c.length()<=100)fl=1;
else
    System.out.println("Invalid Input(Exceeds 100 chars).Please Re-enter!");}
    fl=0;
    while(fl==0){
        System.out.println("Enter events worth remembering:");
         e1=br.readLine();
    if(e1.length()<=100)fl=1;
else
    System.out.println("Invalid Input(Exceeds 100 chars).Please Re-enter!");}
        System.out.println("Enter Date of Acquaintance:");
        flag=0;Date d=new Date();
        while(flag==0)
        {
            try{
                d=df.parse(br.readLine());
                flag=1;
            }
            catch(Exception e)
            {
                flag=0;
                System.out.println("Invalid Input.Please Re-enter!");
            }
        }
        
        personalFriends p=new personalFriends(c,e1,d,n,em,m);
        return p;
        
    
    
    }
    static professionalFriends createprof(String n)throws IOException/*create new professional friends.takes name as argument*/
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    
        DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        
        System.out.println("Enter email:");
        String em=br.readLine();
        System.out.println("Enter mobile number:");
        int flag=0;long m=0;
        while(flag==0)
        {
            try{
                m=Long.parseLong(br.readLine());
                flag=1;
            }
            catch(Exception e)
            {
                flag=0;
                System.out.println("Invalid Input.Please Re-enter!");
            }
        }
        int fl=0;String c="";
        while(fl==0){
        System.out.println("Enter common interest:");
        c=br.readLine();
    if(c.length()<=100)
     fl=1;
    else
    System.out.println("Invalid Input(Exceeds 100 chars).Please Re-enter!");}
        
        professionalFriends p=new professionalFriends(c,n,em,m);
        return p;
        
    
    
    }
    static casualAq createcas(String n)throws IOException/*creates new casual acquaintances.takes name as argument*/
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    
        DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        
        System.out.println("Enter email:");
        String em=br.readLine();
        System.out.println("Enter mobile number:");
        int flag=0;long m=0;
        while(flag==0)
        {
            try{
                m=Long.parseLong(br.readLine());
                flag=1;
            }
            catch(Exception e)
            {
                flag=0;
                System.out.println("Invalid Input.Please Re-enter!");
            }
        }
        System.out.println("Enter Date of acquaintance:");
        flag=0;Date d=new Date();
        while(flag==0)
        {
            try{
                d=df.parse(br.readLine());
                flag=1;
            }
            catch(Exception e)
            {
                flag=0;
                System.out.println("Invalid Input.Please Re-enter!");
            }
        }
        int fl=0;String cir="",w="",in="";
        while(fl==0)
        {
        System.out.println("Enter place of meeting:");
         w=br.readLine();
        if(w.length()<=100)fl=1;
        else
    System.out.println("Invalid Input(Exceeds 100 chars).Please Re-enter!");
    }
        fl=0;
        while(fl==0)
        {
        System.out.println("Enter circumstances of meeting:");
         cir=br.readLine();
        if(cir.length()<=100)fl=1;
        else
    System.out.println("Invalid Input(Exceeds 100 chars).Please Re-enter!");
    }
    fl=0;
        while(fl==0)
        {
        System.out.println("Enter any other useful information:");
        in=br.readLine();
         if(in.length()<=100)fl=1;
        else
    System.out.println("Invalid Input(Exceeds 100 chars).Please Re-enter!");
    }
        casualAq r=new casualAq(w,cir,in,d,n,em,m);
        return r;
        
    
    
    }
    static void DisplayMenu()/*displays menu*/
    {
        System.out.println("Press 1 to create new contact");
        System.out.println("Press 2 to display all contacts");
        System.out.println("Press 3 to display a particular category of contacts");
        

        System.out.println("Press 4 to search a name in the contact list");
        System.out.println("Press 5 to delete a contact");
        
        
    }
    static void displayrelatives(relatives r[],int n)/*displays relative index n of array r*/
        {
    	DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
    		System.out.println("Sl.no    Name \t                       Mobile No.\tEmail id\t            Date of birth\tDate of last meeting ");
            for(i=0;i<n;++i)
                System.out.printf("%-2s\t%-30s\t%-12s\t%-30s\t%-12s\t%-12s\n",(i+1),r[i].getname(),r[i].getmob(),r[i].getemail(),df.format(r[i].getbd()),df.format(r[i].getd()));
            
        }
        static void displayper(personalFriends r[],int n)/*displays personal friend at index n of array r*/
        {
        	DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
        	System.out.println("Sl.no    Name \t                       Mobile No.\tEmail id\t            Date of acquaintance\t    Context of acquaintance \t                                                                                Events");
            for(i=0;i<n;++i)
                System.out.printf("%-2s\t%-30s\t%-12s\t%-30s\t%-12s\t               %-100s\t%-100s\n",(i+1),r[i].getname(),r[i].getmob(),r[i].getemail(),df.format(r[i].getdate()),r[i].getcon(),r[i].getevent());
            
        }
        static void displayprof(professionalFriends r[],int n)/*displays professional friends index n of array r*/
        {
        	DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
        	System.out.println("Sl.no    Name \t                       Mobile No.\tEmail id\t            Some Common Professional Interest");
            for(i=0;i<n;++i)
                System.out.printf("%-2s\t%-30s\t%-12s\t%-30s\t%-100s\n",(i+1),r[i].getname(),r[i].getmob(),r[i].getemail(),r[i].scpi);
            
        }
        static void displaycas(casualAq r[],int n)/*displays casual acquaitance index n of array r*/
        {
        	DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
        	System.out.println("Sl.no    Name \t                       Mobile No.\tEmail id\t            Date of meeting\t               Place of FirstMeeting \t                                                                                Circumstances of meeting\t                                                                                Other Information");
            for(i=0;i<n;++i)
                System.out.printf("%-2s\t%-30s\t%-12s\t%-30s\t%-12s\t               %-100s\t%-100s\t%-100s\n",(i+1),r[i].getname(),r[i].getmob(),r[i].getemail(),df.format(r[i].getwhen()),r[i].getwhere(),r[i].getcir(),r[i].getinfo());
            
        }
    static int searchrel(String n,relatives r[],int i,int x)/*searches if n is name of a relative in r of i elements.x is a flag variable used to determine whether to print or not.we donot print while deletion*/
    {
        int l=0;int h=i-1;
        while(h>=l)
        {
            int m=(h+l)/2;
            if(r[m].getname().equals(n)==true)
            {
                if(x==1)
                r[m].getdetails();
                return m;
            }
            if(n.compareTo(r[m].getname())<0)
            {
                h=m-1;
            }
            else
                l=m+1;
            
        }
        return -1;
        
    }
    static int searchper(String n,personalFriends r[],int i,int x)/*searches if n is name of a personal friend in r of i elements.x is a flag variable used to determine whether to print or not.we donot print while deletion*/
    
    {
        int l=0;int h=i-1;
        while(h>=l)
        {
            int m=(h+l)/2;
            if(r[m].getname().equals(n)==true)
            {
                if(x==1)
                r[m].getdetails();
                return m;
            }
            if(n.compareTo(r[m].getname())<0)
            {
                h=m-1;
            }
            else
                l=m+1;
            
        }
        return -1;
        
    }
    static int searchprof(String n,professionalFriends r[],int i,int x)/*searches if n is name of a professional friend in r of i elements.x is a flag variable used to determine whether to print or not.we donot print while deletion*/
    
    {
        int l=0;int h=i-1;
        while(h>=l)
        {
            int m=(h+l)/2;
            
            if(r[m].getname().equals(n)==true)
            {
                if(x==1)
                r[m].getdetails();
                return m;
            }
            if(n.compareTo(r[m].getname())<0)
            {
                h=m-1;
            }
            else
                l=m+1;
            
        }
        return -1;
        
    }
    static int searchcas(String n,casualAq r[],int i,int x)/*searches if n is name of a casual acquaintance in r of i elements.x is a flag variable used to determine whether to print or not.we donot print while deletion*/
  
    {
        int l=0;int h=i-1;
        while(h>=l)
        {
            int m=(h+l)/2;
            if(r[m].getname().equals(n)==true)
            {
                if(x==1)
                r[m].getdetails();
                return m;
            }
            if(n.compareTo(r[m].getname())<0)
            {
                h=m-1;
            }
            else
                l=m+1;
            
        }
        return -1;
        
    }
    static void deleterel(relatives r[],int n,int ind)/*delete relative at index ind of array r having n elements*/
    {
        int i;
        for(i=ind;i<n-1;++i)
            r[i]=r[i+1];
    }
    static void deleteper(personalFriends r[],int n,int ind)/*delete personal friends at index ind of array r having n elements*/
    {
        int i;
        for(i=ind;i<n-1;++i)
            r[i]=r[i+1];
    }
    static void deleteprof(professionalFriends r[],int n,int ind)/*delete professional friend at index ind of array r having n elements*/
    {
        int i;
        for(i=ind;i<n-1;++i)
            r[i]=r[i+1];
    }
    static void deletecas(casualAq r[],int n,int ind)/*delete casual Acquaintance at index ind of array r having n elements*/
    {
        int i;
        for(i=ind;i<n-1;++i)
            r[i]=r[i+1];
    }
    public static void main(String args[])throws IOException,ParseException//main function
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        System.out.println("WELCOME TO CONTACTS LIST:");
        int  rel=0,per=0,prof=0,cas=0,tot=0;
        relatives r[]=new relatives[MAX];
        personalFriends p[]=new personalFriends[MAX];
        professionalFriends f[]=new professionalFriends[MAX];
        casualAq c[]=new casualAq[MAX];
        File f1 = new File("ContactList.txt");
        
        if(!f1.exists() && !f1.isDirectory())
        {
            f1.createNewFile();
            FileWriter writer =new FileWriter(f1); 
      
            writer.write("0"); 
            writer.flush();
            writer.close();
        }
        
        Scanner rd1 = new Scanner(new FileReader("ContactList.txt"));
        

        int x=Integer.parseInt(rd1.nextLine());
        rd1.close();
        if(x!=0)
        {
            System.out.println("There already exists a record of Contact List.\nPress 1 to retrieve the record and work on it.\nPress any other key to erase the existing record and create a completely new one");
            int vg=0;
            try{
                    vg=Integer.parseInt(br.readLine());}
                    catch(Exception e){}
                    if(vg==1)
                    {
                        Scanner rd = new Scanner(new FileReader("ContactList.txt"));
                        tot=Integer.parseInt(rd.nextLine());
                        rel=Integer.parseInt(rd.nextLine());
                        per=Integer.parseInt(rd.nextLine());
                        prof=Integer.parseInt(rd.nextLine());
                        cas=Integer.parseInt(rd.nextLine());
        for(i=0;i<rel;++i)
        {
                
                String n=rd.nextLine();
                String em=rd.nextLine();
                long m=0;
                m=Long.parseLong(rd.nextLine());
                Date d=new Date();
                d=df.parse(rd.nextLine());
                Date d1=new Date();
                d1=df.parse(rd.nextLine());
                r[i]=new relatives(d,d1,n,em,m);
                
        }
        for(i=0;i<per;++i)
        {
                
                String n=rd.nextLine();
                String em=rd.nextLine();
                long m=0;Date d=new Date();
                m=Long.parseLong(rd.nextLine());
                String c1=rd.nextLine();
                String e1=rd.nextLine();
                d=df.parse(rd.nextLine());
                p[i]=new personalFriends(c1,e1,d,n,em,m);
        }
        for(i=0;i<prof;++i)
        {
                
                String n=rd.nextLine();
                String em=rd.nextLine();
                long m=0;
                m=Long.parseLong(rd.nextLine());
                String c1=rd.nextLine();
                f[i]=new professionalFriends(c1,n,em,m);
        }
        for(i=0;i<cas;++i)
        {
                
                String n=rd.nextLine();
                String em=rd.nextLine();
                long m=0;
                m=Long.parseLong(rd.nextLine());
                Date d=new Date();
                d=df.parse(rd.nextLine());
                String w=rd.nextLine();
                String cir=rd.nextLine();
                String in=rd.nextLine();
                c[i]=new casualAq(w,cir,in,d,n,em,m);         
       }
    }
}
    
                        
                        
                
        int flagg=1;int sf=0,ch;
         while(flagg==1)
        {
            if(sf==1)
            {
                System.out.println("Enter 1 to display Main Menu.Any other key to exit!");
                int p1=0;
                try{
                    p1=Integer.parseInt(br.readLine());}
                    catch(Exception e){}
                if(p1!=1)
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
                System.out.println("Choose your option");
                System.out.println("1.Relatives");
                System.out.println("2.Personal Friends");
                System.out.println("3.Professional Friends");
                System.out.println("4.Casual Acquaintance");
                int ch1=0;
                try{
                    ch1=Integer.parseInt(br.readLine());
                }
                catch(Exception e)
                {}
                String n="";
                if(ch1==1 || ch1==2 || ch1==3 || ch1==4)
                {
                    int y=0;
                    while(y==0)
                    {
                        System.out.println("Enter name:");
                        n=br.readLine();
                        if(searchrel(n,r,rel,0)!=-1 || searchper(n,p,per,0)!=-1 || searchprof(n,f,prof,0)!=-1 || searchcas(n,c,cas,0)!=-1)
                        {
                            System.out.println("Name Already exists in the list .Enter different name.");
                            y=0;continue;
                        }
                        y=1;
                    }
                }
                if(ch1==1)
                {
                    relatives temp=createrelative(n);
                    if(rel==0)
                    i=0;
                    else
                    for(i=rel;i>0;--i)
                    {
                        if(temp.getname().compareTo(r[i-1].getname())>0)
                        {
                            
                            break;
                        }
                        r[i]=r[i-1];
                    }
                    r[i]=temp;
                    ++rel;++tot;
                }
                if(ch1==2)
                {
                    personalFriends temp=createpersonal(n);
                    if(per==0)
                    i=0;
                    else
                    for(i=per;i>0;--i)
                    {
                         if(temp.getname().compareTo(p[i-1].getname())>0)
                        {
                            
                            break;
                        }
                        p[i]=p[i-1];
                    }
                    p[i]=temp;
                    ++per;++tot;
                }
                if(ch1==3)
                {
                    professionalFriends temp=createprof(n);
                    if(prof==0)
                    i=0;
                    else
                    for(i=prof;i>0;--i)
                    { if(temp.getname().compareTo(f[i-1].getname())>0)
                        {
                            
                            break;
                        }
                        f[i]=f[i-1];
                    }
                    f[i]=temp;
                    ++prof;++tot;
                }
                if(ch1==4)
                {
                    casualAq temp=createcas(n);
                    if(cas==0)
                    i=0;
                    else
                    for(i=cas;i>0;--i)
                    {
                         if(temp.getname().compareTo(c[i-1].getname())>0)
                        {
                            
                            break;
                        }
                        c[i]=c[i-1];
                    }
                    c[i]=temp;
                    ++cas;++tot;
                }
                Filewriter(r,p,f,c,tot,rel,per,prof,cas);
                break;
                case 2:
                System.out.println("List of all acquaintances");
                System.out.println("A.Relatives");
                if(rel==0)
                {
                    System.out.println("There are no relatives in this list!");
                }
                else
                displayrelatives(r,rel);
                System.out.println("\nB.Personal Friends");
                if(per==0)
                {
                    System.out.println("There are no personal friends in this list!");
                }
                else
                displayper(p,per);
                System.out.println("\nC.Professional Friends");
                if(prof==0)
                {
                    System.out.println("There are no professional friends in this list!");
                }
                else
                displayprof(f,prof);
                System.out.println("\nD.Casual Acquaintance");
                if(cas==0)
                {
                    System.out.println("There are no casual acquaintances in this list!");break;
                }
                else
                displaycas(c,cas);
                Filewriter(r,p,f,c,tot,rel,per,prof,cas);
                break;
                case 3:
                System.out.println("Choose your option");
                System.out.println("1.Relatives");
                System.out.println("2.Personal Friends");
                System.out.println("3.Professional Friends");
                System.out.println("4.Casual Acquaintance");
                ch1=0;
                try{
                    ch1=Integer.parseInt(br.readLine());
                }
                catch(Exception e)
                {}
                
                if(ch1==1)
                {
                    
                    if(rel==0)
                {
                    System.out.println("There are no relatives in this list!");break;
                }
                else
                    displayrelatives(r,rel);
                }
                if(ch1==2)
                {
                    if(per==0)
                {
                    System.out.println("There are no personal friends in this list!");break;
                }
                else
                    displayper(p,per);
                    
                }
                if(ch1==3)
                {
                    if(prof==0)
                {
                    System.out.println("There are no professional friends in this list!");break;
                }
                else
                    displayprof(f,prof);
                }
                if(ch1==4)
                {
                    if(cas==0)
                {
                    System.out.println("There are no casual acquaintances in this list!");break;
                }
                else
                    displaycas(c,cas);
                }
                Filewriter(r,p,f,c,tot,rel,per,prof,cas);
                break;
                case 4:
                if(tot==0)
                {
                    System.out.println("There are no saved contacts!");break;
                }
                int t1,t2,t3,t4;
                t1=-1;t2=-1;t3=-1;t4=-1;
                System.out.println("Enter a name to search");
                String st=br.readLine();
                if(rel>0)
                t1=searchrel(st,r,rel,1);
                if(per>0)
                t2=searchper(st,p,per,1);
                if(prof>0)
                t3=searchprof(st,f,prof,1);
                if(cas>0)
                t4=searchcas(st,c,cas,1);
                if(t1==-1 && t2==-1 && t3==-1 && t4==-1)
                System.out.println("The entered name does not exist in the list");
                Filewriter(r,p,f,c,tot,rel,per,prof,cas);
                break;
                case 5:
                if(tot==0)
                {
                    System.out.println("There are no saved contacts!");break;
                }
                System.out.println("Enter a name to delete");
                st=br.readLine();
                t1=-1;t2=-1;t3=-1;t4=-1;
                if(rel>0)
                t1=searchrel(st,r,rel,0);
                if(t1!=-1)
                {
                    deleterel(r,rel,t1);
                    --tot;
                    --rel;
                }
                if(per>0)
                {
                    t2=searchper(st,p,per,0);
                    
                }
                if(t2!=-1)
                {
                    deleteper(p,per,t2);
                    --tot;
                    --per;
                }
                if(prof>0)
                t3=searchprof(st,f,prof,0);
                if(t3!=-1)
                {
                    deleteprof(f,prof,t3);
                    --prof;--tot;
                }
                if(cas>0)
                {
                    t4=searchcas(st,c,cas,0);
                }
                if(t4!=-1)
                {
                    deletecas(c,cas,t4);
                    --cas;
                    --tot;
                }
                if(t1==-1 && t2==-1 && t3==-1 && t4==-1)
                System.out.println("The entered name does not exist in the list");
                else
                System.out.println("Contact deleted.");
                 Filewriter(r,p,f,c,tot,rel,per,prof,cas);
                break;
           
                
                
                
            }
        }
        File f2 = new File("ContactList.txt");
                FileWriter writer2 = new FileWriter(f2);
                writer2.write(Integer.toString(tot)+System.getProperty( "line.separator" ));
                writer2.write(Integer.toString(rel)+System.getProperty( "line.separator" ));
                writer2.write(Integer.toString(per)+System.getProperty( "line.separator" ));
                writer2.write(Integer.toString(prof)+System.getProperty( "line.separator" ));
                writer2.write(Integer.toString(cas)+System.getProperty( "line.separator" ));
                
               
        for(i=0;i<rel;++i)
        {
                writer2.write(r[i].getname()+System.getProperty( "line.separator" ));
                writer2.write(r[i].getemail()+System.getProperty( "line.separator" ));
                writer2.write(Long.toString(r[i].getmob())+System.getProperty( "line.separator" ));
                writer2.write(df.format(r[i].getbd())+System.getProperty( "line.separator" ));
                writer2.write(df.format(r[i].getd())+System.getProperty( "line.separator" ));
                
        }
        for(i=0;i<per;++i)
        {
                
                writer2.write(p[i].getname()+System.getProperty( "line.separator" ));
                writer2.write(p[i].getemail()+System.getProperty( "line.separator" ));
                writer2.write(Long.toString(p[i].getmob())+System.getProperty( "line.separator" ));
                writer2.write(p[i].getcon()+System.getProperty( "line.separator" ));
                writer2.write(p[i].getevent()+System.getProperty( "line.separator" ));
                writer2.write(df.format(p[i].getdate())+System.getProperty( "line.separator" ));
                
        }
        for(i=0;i<prof;++i)
        {
                
                writer2.write(f[i].getname()+System.getProperty( "line.separator" ));
                writer2.write(f[i].getemail()+System.getProperty( "line.separator" ));
                writer2.write(Long.toString(f[i].getmob())+System.getProperty( "line.separator" ));
                writer2.write(f[i].getscpi()+System.getProperty( "line.separator" ));
                
        }
        for(i=0;i<cas;++i)
        {
                
                writer2.write(c[i].getname()+System.getProperty( "line.separator" ));
                writer2.write(c[i].getemail()+System.getProperty( "line.separator" ));
                writer2.write(Long.toString(c[i].getmob())+System.getProperty( "line.separator" ));
                writer2.write(df.format(c[i].getwhen())+System.getProperty( "line.separator" ));
                writer2.write(c[i].getwhere()+System.getProperty( "line.separator" ));
                writer2.write(c[i].getcir()+System.getProperty( "line.separator" ));
                writer2.write(c[i].getinfo()+System.getProperty( "line.separator" ));
                         
       }
                
                writer2.flush();
                writer2.close();
                
                
                
                
               
            
    }
}