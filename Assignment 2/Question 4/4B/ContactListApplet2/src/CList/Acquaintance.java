
package CList;
import java.io.*;

public class Acquaintance {
	//name, mobile number, and e-mail.
	

	
	    String name,email;long mobile_no;
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


