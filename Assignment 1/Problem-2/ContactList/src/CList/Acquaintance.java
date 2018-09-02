package CList;
import java.io.*;

class Acquaintance
{
    private String name,email;long mobile_no;
    Acquaintance(String name,String e,long mob)
    {
        this.name=name;
        this.email=e;
        this.mobile_no=mob;
    }
    String getname()
    {
    	return name;

    }
    String getemail()
    {
    	return email;
    }
    long getmob()
    {
    	return mobile_no;
    }


}