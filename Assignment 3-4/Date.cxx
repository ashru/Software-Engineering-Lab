#include <iostream>
#include <exception>
#include <stdexcept>
#include "Date.h"
#include <stdlib.h>
#include <ctime>
#include <string.h>
#include <stdio.h>
#include <iomanip>
using namespace std;
DateFormat Date::format;
DateFormat::DateFormat(const char* dateFormat, const char* monthFormat, const char* yearFormat)throw(invalid_argument)
{
	
	if(strcmp(dateFormat,"0")!=0 && strcmp(dateFormat,"d")!=0 && strcmp(dateFormat,"dd")!=0 )
		throw invalid_argument("Invalid argument:Invalid date format");
	if(strcmp(monthFormat,"0")!=0 && strcmp(monthFormat,"m")!=0 && strcmp(monthFormat,"mm")!=0 && strcmp(monthFormat,"mmm")!=0)
		throw invalid_argument("Invalid argument:Invalid date format");
	if(strcmp(yearFormat,"0")!=0 && strcmp(yearFormat,"yy")!=0 && strcmp(yearFormat,"yyyy")!=0 )
		throw invalid_argument("Invalid argument:Invalid date format");
	this->dateFormat=new char[2];//dateformat is either d or dd
	this->monthFormat=new char[3];//monthformat is either 0 or m or mm or mm(each less or equal to 3 characters)
	this->yearFormat=new char[4];//0 or yy or yyyy
	strcpy(this->dateFormat,dateFormat);
	strcpy(this->monthFormat,monthFormat);
	strcpy(this->yearFormat,yearFormat);

}
DateFormat::DateFormat(const char* format)throw(invalid_argument)//there are only 36(3*4*3) valid dateformats
{
	dateFormat=new char[2];
	monthFormat=new char[3];
	yearFormat=new char[4];
	char *a=new char[5];char *b=new char[5];char *c=new char[5];
	int i=0,j=0,k=0; int y=0;
	while(format[j])
	{
		if(format[j]=='-'){++y;}
		++j;
		
		
	}
	if(y!=2 || strlen(format)>11)//a vali dateformat has exactly 2 hyphens and has max length=10(dd-mm-yyyy)
		throw invalid_argument("Invalid Date Format");
	char format1[50];
	strcpy(format1,format);
	a= strtok (format1,"-");//extracts the substring before first hyphen
	b=strtok(NULL, "-");//the substring before next hyphen and after previous one
	c=strtok(NULL, "-");//the rest of the substring
	if(strcmp(a,"0")!=0 && strcmp(a,"d")!=0 && strcmp(a,"dd")!=0)
		throw invalid_argument("Invalid argument:Invalid Date Format");
	if(strcmp(b,"0")!=0 && strcmp(b,"m")!=0 && strcmp(b,"mm")!=0 && strcmp(b,"mmm")!=0)
		throw invalid_argument("Invalid argument:Invalid Date Format");
	if(strcmp(c,"0")!=0 && strcmp(c,"yy")!=0 && strcmp(c,"yyyy")!=0)
		throw invalid_argument("Invalid argument:Invalid Date Format");
	strcpy(dateFormat,a);
	strcpy(monthFormat,b);
	strcpy(yearFormat,c);

}
DateFormat::DateFormat()//default format:dd-mmm-yy
{
	dateFormat=new char[2];
	monthFormat=new char[3];
	yearFormat=new char[4];
	strcpy(dateFormat,"dd");
	strcpy(monthFormat,"mm");
	strcpy(yearFormat,"yy");
}
DateFormat::~DateFormat()//destructor of dateformat
{
	
	delete [] dateFormat;//prevents memory leak
	delete [] monthFormat;
	delete [] yearFormat;
	
}
char* DateFormat::getdateFormat()//getter function to access private member dateformat
{
	return dateFormat;
}
char* DateFormat::getmonthFormat()//getter function to access private member monthformat
{
	return monthFormat;
}
char* DateFormat::getyearFormat()//getter function to access private member yearformat
{
	return yearFormat;
}
DateFormat& DateFormat::operator=(const DateFormat& rhs)//overloaded copy assignment operator of dateformat to prevent memory leak as it has 3 pointers which are lost if we use the default copy assignment
{

	if(this!=&rhs)//takes care of self assignment
	{

		delete [] dateFormat;
		delete [] monthFormat;
		delete [] yearFormat;
		dateFormat=new char[2];
		monthFormat=new char[3];
		yearFormat=new char[4];
		strcpy(dateFormat,rhs.dateFormat);
		strcpy(monthFormat,rhs.monthFormat);
		strcpy(yearFormat,rhs.yearFormat);
	
	}
	return (*this);
}
ostream& operator<<(ostream& os,const DateFormat& df)//this has been added to demonstrate the output.It does not contribute to the design
{
	os<<df.dateFormat<<"-"<<df.monthFormat<<"-"<<df.yearFormat;
	return os;
}
Date::Date(Day d, Month m, Year y) throw(
invalid_argument, // One or more of the arguments d or m is/are invalid (27, 13, 13)
domain_error, // (d, m, y) as a triplet does not define a valid date (30, 2, 61)
out_of_range)
{

	InvalidArgument(d,m,y);
    DomainError(d,m,y);
    OutOfRange(d,m,y);
	day=d;
	month=m;
	year=y;
	
}
Date::Date(const char* date) // date in string format -- to be parsed as static format member
throw(invalid_argument, domain_error, out_of_range)//there are only 8 valid input formats
{
	if((strcmp(Date::format.getdateFormat(),"0")==0)||(strcmp(Date::format.getyearFormat(),"0")==0))
		throw invalid_argument("Invalid argument:Invalid date format for input!");
	if((strcmp(Date::format.getmonthFormat(),"0")==0)||(strcmp(Date::format.getmonthFormat(),"mmm")==0))
		throw invalid_argument("Invalid argument:Invalid date format for input!");

	int da,mo,ye;
	int i;int j=0,k=0;
	for(i=0;i<strlen(date);++i)
	{
		if(!(date[i]=='-' ||((date[i]-'0'>=0)&&(date[i]-'0'<=9))))//every character in a valid date is either a digit in 0-9 or a hyphen
			throw invalid_argument("Invalid argument:Invalid date format!");
		if(date[i]=='-')
			++j;

	}
	if(j!=2)
		throw invalid_argument("Invalid argument:Invalid date format!");

	
	if(strcmp(Date::format.getdateFormat(),"dd")==0)
	{
		if(date[2]!='-')
			throw invalid_argument("Invalid argument:Invalid date format!");
		da=(date[0]-'0')*10+date[1]-'0';
		if(da>31||da<1)
			throw invalid_argument("Invalid argument:Invalid date!!");
		if(strcmp(Date::format.getmonthFormat(),"mm")==0)
		{
			if(date[5]!='-')
				throw invalid_argument("Invalid argument:Invalid date format!");
			mo=(date[3]-'0')*10+date[4]-'0';
			if(mo>12||mo<1)
				throw invalid_argument("Invalid argument:Invalid month!!");
			if(strcmp(Date::format.getyearFormat(),"yy")==0)//handles dd-mm-yy
			{
				if(strlen(date)!=8)
					throw invalid_argument("Invalid argument:Invalid date format!");
				ye=10*(date[6]-'0')+date[7]-'0';
				if(ye<0 ||ye>99)
					throw invalid_argument("Invalid argument:Invalid year!!");
				if(ye<=49)
					ye+=2000;
				else ye+=1900;
				if(ye<0 || ye>9999)
					throw invalid_argument("Invalid argument:Invalid date format!");


			}
			if(strcmp(Date::format.getyearFormat(),"yyyy")==0)//handles dd-mm-yyyy
			{
				if(strlen(date)!=10)
					throw invalid_argument("Invalid argument:Invalid date format!");
				ye=1000*(date[6]-'0')+100*(date[7]-'0')+10*(date[8]-'0')+date[9]-'0';
				if(ye<0 || ye>9999)
					throw invalid_argument("Invalid argument:Invalid date format!");
				

			}

		}
		if(strcmp(Date::format.getmonthFormat(),"m")==0)
		{
			if(date[5]=='-')
			{
				if(date[3]=='0')
					throw invalid_argument("Invalid argument:Invalid date format!");
				mo=(date[3]-'0')*10+date[4]-'0';
				if(mo>12||mo<1)
					throw invalid_argument("Invalid argument:Invalid month!!");
				if(strcmp(Date::format.getyearFormat(),"yy")==0)//handles dd-m-yy(when months are 10,11,12 ie 2 digit)
				{
					if(strlen(date)!=8)
						throw invalid_argument("Invalid argument:Invalid date format!");
					ye=10*(date[6]-'0')+date[7]-'0';
					if(ye<0 || ye>99)
						throw invalid_argument("Invalid argument:Invalid date format!");

					if(ye<=49)
						ye+=2000;
					else ye+=1900;
					

				}
				if(strcmp(Date::format.getyearFormat(),"yyyy")==0)//handles dd-m-yyyy(when months are 10,11,12 ie 2 digit)
				{
					if(strlen(date)!=10)
						throw invalid_argument("Invalid argument:Invalid date format!");
					ye=1000*(date[6]-'0')+100*(date[7]-'0')+10*(date[8]-'0')+date[9]-'0';
					if(ye<0 || ye>9999)
						throw invalid_argument("Invalid argument:Invalid date format!");
				

				}
			}
			else if(date[4]!='-')
				throw invalid_argument("Invalid argument:Invalid date format!");
			else
			{
				mo=date[3]-'0';
				if(mo>9 ||mo<1)
					throw invalid_argument("Invalid argument:Invalid month!!");
				if(strcmp(Date::format.getyearFormat(),"yy")==0)//handles dd-m-yy(when months are 1-9 ie 1 digit)
				{
					if(strlen(date)!=7)
						throw invalid_argument("Invalid argument:Invalid date format!");
					ye=10*(date[5]-'0')+date[6]-'0';
					if(ye<0 || ye>99)
						throw invalid_argument("Invalid argument:Invalid date format!");
					if(ye<=49)
						ye+=2000;
					else ye+=1900;
					
				}
				if(strcmp(Date::format.getyearFormat(),"yyyy")==0)//handles dd-m-yyyy(when months are 1-9 ie 1 digit)
				{
					if(strlen(date)!=9)
						throw invalid_argument("Invalid argument:Invalid date format!");
					ye=1000*(date[5]-'0')+100*(date[6]-'0')+10*(date[7]-'0')+date[8]-'0';
					if(ye<0 || ye>9999)
						throw invalid_argument("Invalid argument:Invalid date format!");
				

				}

			}

		}

	}
	if(strcmp(Date::format.getdateFormat(),"d")==0)
	{
		if(date[2]=='-')
		{
			if(date[0]=='0')
				throw invalid_argument("Invalid argument:Invalid date format!");
			da=(date[0]-'0')*10+date[1]-'0';
			if(da>31||da<1)
			throw invalid_argument("Invalid argument:Invalid date!!");
		if(strcmp(Date::format.getmonthFormat(),"mm")==0)
		{
			if(date[5]!='-')
				throw invalid_argument("Invalid argument:Invalid date format!");
			mo=(date[3]-'0')*10+date[4]-'0';
			if(mo>12||mo<1)
				throw invalid_argument("Invalid argument:Invalid month!!");
			if(strcmp(Date::format.getyearFormat(),"yy")==0)//handles d-mm-yy(when days are are 10-31 ie 2 digit)
			{
				if(strlen(date)!=8)
					throw invalid_argument("Invalid argument:Invalid date format!");
				ye=10*(date[6]-'0')+date[7]-'0';
				if(ye<0 ||ye>99)
					throw invalid_argument("Invalid argument:Invalid year!!");
				if(ye<=49)
					ye+=2000;
				else ye+=1900;
				


			}
			if(strcmp(Date::format.getyearFormat(),"yyyy")==0)//handles d-mm-yyyy(when days are are 10-31 ie 2 digit)
			{
				if(strlen(date)!=10)
					throw invalid_argument("Invalid argument:Invalid date format!");
				ye=1000*(date[6]-'0')+100*(date[7]-'0')+10*(date[8]-'0')+date[9]-'0';
				if(ye<0 || ye>9999)
					throw invalid_argument("Invalid argument:Invalid date format!");
				

			}

		}
		if(strcmp(Date::format.getmonthFormat(),"m")==0)
		{
			if(date[5]=='-')
			{
				if(date[3]=='0')
					throw invalid_argument("Invalid argument:Invalid date format!");
				mo=(date[3]-'0')*10+date[4]-'0';
				if(mo>12||mo<1)
					throw invalid_argument("Invalid argument:Invalid month!!");
				if(strcmp(Date::format.getyearFormat(),"yy")==0)//handles d-m-yy(when days are are 10-31 ie 2 digit and months are 10-12 ie 2-digit)
				{
					if(strlen(date)!=8)
						throw invalid_argument("Invalid argument:Invalid date format!");
					ye=10*(date[6]-'0')+date[7]-'0';
					if(ye<0 || ye>99)
						throw invalid_argument("Invalid argument:Invalid date format!");

					if(ye<=49)
						ye+=2000;
					else ye+=1900;
					

				}
				if(strcmp(Date::format.getyearFormat(),"yyyy")==0)//handles d-m-yyyy(when days are are 10-31 ie 2 digit and months are 10-12 ie 2-digit)
				{
					if(strlen(date)!=10)
						throw invalid_argument("Invalid argument:Invalid date format!");
					ye=1000*(date[6]-'0')+100*(date[7]-'0')+10*(date[8]-'0')+date[9]-'0';
					if(ye<0 || ye>9999)
						throw invalid_argument("Invalid argument:Invalid date format!");
				

				}
			}
			else if(date[4]!='-')
				throw invalid_argument("Invalid argument:Invalid date format!");
			else
			{
				mo=date[3]-'0';
				if(mo>9 ||mo<1)
					throw invalid_argument("Invalid argument:Invalid month!!");
				if(strcmp(Date::format.getyearFormat(),"yy")==0)//handles d-m-yy(when days are are 10-31 ie 2 digit and months are 1-9 ie 1-digit)
				{
					if(strlen(date)!=7)
						throw invalid_argument("Invalid argument:Invalid date format!");
					ye=10*(date[5]-'0')+date[6]-'0';
					if(ye<0 || ye>99)
						throw invalid_argument("Invalid argument:Invalid date format!");
					if(ye<=49)
						ye+=2000;
					else ye+=1900;
					
				}
				if(strcmp(Date::format.getyearFormat(),"yyyy")==0)//handles d-m-yyyy(when days are are 10-31 ie 2 digit and months are 1-9 ie 1-digit)
				{
					if(strlen(date)!=9)
						throw invalid_argument("Invalid argument:Invalid date format!");
					ye=1000*(date[5]-'0')+100*(date[6]-'0')+10*(date[7]-'0')+date[8]-'0';
					if(ye<0 || ye>9999)
						throw invalid_argument("Invalid argument:Invalid date format!");
				

				}

			}

		}
		}
		else if(date[1]!='-')
			throw invalid_argument("Invalid argument:Invalid date format!");
		else
		{
			da=date[0]-'0';
			if(da>9 ||da<1)
				throw invalid_argument("Invalid argument:Invalid date!!");
			if(strcmp(Date::format.getmonthFormat(),"mm")==0)
			{
				if(date[4]!='-')
					throw invalid_argument("Invalid argument:Invalid date format!");
				mo=(date[2]-'0')*10+date[3]-'0';
				if(mo>12||mo<1)
					throw invalid_argument("Invalid argument:Invalid month!!");
				if(strcmp(Date::format.getyearFormat(),"yy")==0)//handles d-mm-yy(when days are are 1-9 ie 1 digit)
				{
					if(strlen(date)!=7)
						throw invalid_argument("Invalid argument:Invalid date format!");
					ye=10*(date[5]-'0')+date[6]-'0';
					if(ye<0 || ye>99)
						throw invalid_argument("Invalid argument:Invalid year!");
					if(ye<=49)
						ye+=2000;
					else ye+=1900;
				


				}
				if(strcmp(Date::format.getyearFormat(),"yyyy")==0)//handles d-mm-yyyy(when days are are 1-9 ie 1 digit)
				{
					if(strlen(date)!=9)
						throw invalid_argument("Invalid argument:Invalid date format!");
					ye=1000*(date[5]-'0')+100*(date[6]-'0')+10*(date[7]-'0')+date[8]-'0';
					if(ye<0 || ye>9999)
						throw invalid_argument("Invalid argument:Invalid date format!");
				

				}

			}
			if(strcmp(Date::format.getmonthFormat(),"m")==0)
			{
				if(date[4]=='-')
				{
					if(date[2]=='0')
						throw invalid_argument("Invalid argument:Invalid date format!");
					mo=(date[2]-'0')*10+date[3]-'0';
					if(mo>12||mo<1)
						throw invalid_argument("Invalid argument:Invalid month!!");
					if(strcmp(Date::format.getyearFormat(),"yy")==0)//handles d-m-yy(when days are are 1-9 ie 1 digit and months are 10-12 ie 2 digit)
					{
						if(strlen(date)!=7)
							throw invalid_argument("Invalid argument:Invalid date format!");
						ye=10*(date[5]-'0')+date[6]-'0';
						if(ye<0 || ye>99)
							throw invalid_argument("Invalid argument:Invalid date format!");

						if(ye<=49)
							ye+=2000;
						else ye+=1900;
					

					}
					if(strcmp(Date::format.getyearFormat(),"yyyy")==0)//handles d-m-yyyy(when days are are 1-9 ie 1 digit and months are 10-12 ie 2 digit)
					{
						if(strlen(date)!=9)
							throw invalid_argument("Invalid argument:Invalid date format!");
						ye=1000*(date[5]-'0')+100*(date[6]-'0')+10*(date[7]-'0')+date[8]-'0';
						if(ye<0 || ye>9999)
							throw invalid_argument("Invalid argument:Invalid date format!");
				

					}
				}
				else if(date[3]!='-')
					throw invalid_argument("Invalid argument:Invalid date format!");
				else
				{
					mo=date[2]-'0';
					if(mo>9 ||mo<1)
						throw invalid_argument("Invalid argument:Invalid month!!");
					if(strcmp(Date::format.getyearFormat(),"yy")==0)//handles d-m-yy(when days are are 1-9 ie 1 digit and months are 1-9 ie 1 digit)
					{
						if(strlen(date)!=6)
							throw invalid_argument("Invalid argument:Invalid date format!");
						ye=10*(date[4]-'0')+date[5]-'0';
						if(ye<0 || ye>99)
							throw invalid_argument("Invalid argument:Invalid date format!");
						if(ye<=49)
							ye+=2000;
						else ye+=1900;
					
					}
					if(strcmp(Date::format.getyearFormat(),"yyyy")==0)//handles d-m-yyyy(when days are are 1-9 ie 1 digit and months are 10-12 ie 2 digit)
					{
						if(strlen(date)!=8)
							throw invalid_argument("Invalid argument:Invalid date format!");
						ye=1000*(date[4]-'0')+100*(date[5]-'0')+10*(date[6]-'0')+date[7]-'0';
						if(ye<0 || ye>9999)
							throw invalid_argument("Invalid argument:Invalid date format!");
				

					}

				}

			}

		}

	}
	InvalidArgument(da,mo,ye);
    DomainError(da,mo,ye);
    OutOfRange(da,mo,ye);
	day=static_cast<Day>(da);
	month=static_cast<Month>(mo);
	year=static_cast<Year>(ye);

	
}
Date::Date() // Default Constructor - construct ’today’ (get from system)
throw(domain_error, out_of_range)
{
	
	time_t t1 = time(0);   // get time now
    struct tm * now = localtime( & t1 );
    int da=now->tm_mday;
    int ye=now->tm_year + 1900;//tm_year return no of years from 1900
    int mo=now->tm_mon + 1;//tm_mon returns no of months from january
    InvalidArgument(da,mo,ye);
    DomainError(da,mo,ye);
    OutOfRange(da,mo,ye);
    year=static_cast<Year>(ye);
	month=static_cast<Month>(mo);
    day=static_cast<Day>(da);
}
    
	
Date::Date(const Date& rhs)//copy constructor
{	
		
		day=rhs.day;
		month=rhs.month;
		year=rhs.year;
		
	
}
Date::~Date()//destructor for date
{


}

Date& Date::operator=(const Date& rhs)//copy assignment operator for date
{
	day=rhs.day;
	month=rhs.month;
	year=rhs.year;
	return *this ;
}
Date& Date::operator++()//pre increment operator ++
{
	*this=*this+1;
	return *this;
}
Date Date::operator++(int)//post increment operator ++.returns the previous value(as it is POST increment)
{

	Date d1(*this);
	*this=*this+7;
	return d1;
	
}
Date& Date::operator--()//pre increment operator --
{
	*this=*this+(-1);

	
	return *this;
}
Date Date::operator--(int)//post increment operator --.returns the previous value(as it is POST increment)
{
	Date d1(*this);
	*this=*this+(-7);
	return d1;
}
unsigned int Date::operator-(const Date& otherDate) // Number of days between otherDate and current date
{
	unsigned int ans=0;
	int d1,d2,m1,m2,y1,y2,r1,r2;
	d1=day;m1=month;y1=year;
	d2=otherDate.day;m2=otherDate.month;y2=otherDate.year;
    if (m1 < 3)		//Rata Die system of assigning dates.
       { y1--; m1 += 12;}
    r1=365*y1 + y1/4 - y1/100 + y1/400 + (153*m1 - 457)/5 + d1 - 306;
    if (m2 < 3)//we assign rata die dates to both dates and calculate difference between the rata die numbers which is the number of days between them
      {  y2--, m2 += 12;}
    r2=365*y2 + y2/4 - y2/100 + y2/400 + (153*m2 - 457)/5 + d2 - 306;
    if(r1>r2)
    	ans=r1-r2;
    else ans=r2-r1;


    return ans;

}
Date Date::operator+(int noOfDays) // Day noOfDays after (before) the current date
// (sign of noOfDays decides ahead or behind)
throw(domain_error, out_of_range)//Domain error!!
{
	struct tm expire_time = {};
   	expire_time.tm_year = year - 1900;
   	expire_time.tm_mon = month - 1;
   	expire_time.tm_mday = day;
   	expire_time.tm_mday += noOfDays;//we add the number of days to get a new tm_mday
   	mktime(&expire_time);//here we cas it back to a tandard format
   	int da,mo,ye;
   	da = expire_time.tm_mday;
    mo= expire_time.tm_mon + 1;
    ye = expire_time.tm_year + 1900;
    DomainError(da,mo,ye);
    OutOfRange(da,mo,ye);
    Date d1(static_cast<Day>(da),static_cast<Month>(mo),static_cast<Year>(ye));
    return d1;

}
Date::operator WeekNumber() const // Cast to the week number of the year in which the current date falls
{
	struct tm tm;
    char format[32];
    sprintf(format,"%d-%02d-%02d",year,month,day);//library function used
    strptime(format, "%Y-%m-%d", &tm);//library function used

   strftime(format, sizeof(format),  "%V", &tm);//returns the iso week number(%V) to format
   
   WeekNumber wn= static_cast<WeekNumber>(atoi(format));
   return wn;
}
Date::operator Month() const // Cast to the month of the year in which the current date falls
{
	return month;
}
Date::operator WeekDay() const // Cast to the day of the week of the current date
{
	int t[] = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};//algorithm to calculate weekday in O(1) time
	int ye=year,mo=month,da=day;
	
    ye -= mo < 3;
    int e=(ye + ye/4 - ye/100 + ye/400 + t[mo-1] + da) % 7;
    
   
    if(e==0)
    	e=7;
    WeekDay wd=static_cast<WeekDay>(e);
	return wd;
}
bool Date::leapYear() const// checks whether a year is a leap year
{
	if(year%4==0)
		return true;
	else return false;
}
bool Date::operator==(const Date& otherDate)//2 dates are equal iff their day,month years are equal
{
	if(day==otherDate.day &&  month==otherDate.month && year==otherDate.year)
		return true;
	else return false;

}
bool Date::operator!=(const Date& otherDate)//returns negation of equal
{
	return !((*this)==otherDate);

}
bool Date::operator<(const Date& otherDate)//checks if a date is lesser than another
{
	if(year<otherDate.year)
		return true;
	if(year>otherDate.year)
		return false;
	if(month<otherDate.month)
		return true;
	if(month>otherDate.month)
		return false;
	if(day<otherDate.day)
		return true;
	return false;
}
bool Date::operator<=(const Date& otherDate)//if a date is either less than or equal to another date.uses the == and < functions,true if either of them is true
{
	return (((*this)<otherDate)||((*this)==otherDate));
}
bool Date::operator>(const Date& otherDate)//it is the negation of <=
{
	return !((*this)<=otherDate);
	
}


bool Date::operator>=(const Date& otherDate)//it is the negation of <
{
	return !((*this)<otherDate);
}
ostream& operator<<(ostream& os, const Date& d)//overloaded output operator
{
	
	char A[][20]={"January","February","March","April","May","June","July","August","September","October","November","December"};
	char B[][20]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	char dd[3],mm[10],yy[5];
	if(strcmp(Date::format.getdateFormat(),"0")==0)//there are 3 possible output dateformats
	{
		sprintf(dd,"\0");
	}
	if(strcmp(Date::format.getdateFormat(),"d")==0)
	{
		sprintf(dd,"%d-",(int)d.day);
	}
	if(strcmp(Date::format.getdateFormat(),"dd")==0)
	{
		sprintf(dd,"%02d-",(int)d.day);
	}
	if(strcmp(Date::format.getmonthFormat(),"0")==0)//there are 4 possible output monthformats
	{
		sprintf(mm,"%s",A[d.month-1]);
	}
	if(strcmp(Date::format.getmonthFormat(),"m")==0)
	{
		sprintf(mm,"%d",d.month);
	}
	if(strcmp(Date::format.getmonthFormat(),"mm")==0)
	{
		sprintf(mm,"%02d",d.month);
	}
	if(strcmp(Date::format.getmonthFormat(),"mmm")==0)
	{
		sprintf(mm,"%s",B[d.month-1]);
	}
	if(strcmp(Date::format.getyearFormat(),"0")==0)//there are 3 possible output yearformats
	{
		sprintf(yy,"\0");
	}
	if(strcmp(Date::format.getyearFormat(),"yy")==0)
	{
		sprintf(yy,"-%02d",((int)(d.year)%100));
	}
	if(strcmp(Date::format.getyearFormat(),"yyyy")==0)
	{
		sprintf(yy,"-%04d",(int)d.year);
	}
	os<<dd<<mm<<yy;

	return os;

}
istream& operator>>(istream& is, Date& d)//overloaded input operator for date
{
		
	char *t=new char;
	is>>t;
	Date temp(t);//uses the Date(const char *) constructor where validity of a date is checked
	d=temp;
	delete [] t;		
	return is;
	
}
void Date::setFormat(DateFormat& f)//setter function for private member format
{
	Date::format=f;


}
DateFormat&  Date::getFormat()//getter function for private member format
{
	return Date::format;
}
void Date::InvalidArgument(int d,int m,int y)//exception handling for invalid_argument
throw(invalid_argument)
{
	if(d>31 || d<1)
		throw invalid_argument("Invalid Argument:No of days in a month lies in between 1-31!!");
	if(m>12 || m<1)
		throw invalid_argument("Invalid Argument:No of months in a year lies in between 1-12!!");
	if(y<0)
		throw invalid_argument("Invalid Argument:No of years is non negative!!");
}
void Date::DomainError(int d,int m,int y)//exception handling for domain_error
throw(domain_error)
{
	if(m==2 && (d==30 || d==31))
		throw domain_error("Domain Error:February has 28 or 29 days !");
	if(m==2 && d==29 && (y%4!=0))
		throw domain_error("Domain Error:A non-leapyear february has 28 days");
	if(m==4 && d==31)
		throw domain_error("Domain Error:April has 30 days!!");
	if(m==6 && d==31)
		throw domain_error("Domain Error:June has 30 days!!");
	if(m==9 && d==31)
		throw domain_error("Domain Error:September has 30 days!!");
	if(m==11 && d==31)
		throw domain_error("Domain Error:November has 30 days!!");


}
void Date::OutOfRange(int d,int m,int y)//exception handling for out_of_range
throw(out_of_range)
{
	if(y<1950 || y>2049)
		throw out_of_range("Out of Range:This date does ot lie between 1st Jan 1950 and 31st Dec 2049");
}

ostream& operator<<(ostream &os,WeekDay w)//overloaded output operator to print the name of weekday
{
	switch(w)
	{
		case 1:os<<"Monday";break;
		case 2:os<<"Tuesday";break;
		case 3:os<<"Wednesday";break;
		case 4:os<<"Thursday";break;
		case 5:os<<"Friday";break;
		case 6:os<<"Saturday";break;
		case 7:os<<"Sunday";break;
	}
	return os;
}

ostream& operator<<(ostream &os,Month m)//overloaded output operator to print the name of month
{
	switch(m)
	{
		case 1:os<<"January";break;
		case 2:os<<"February";break;
		case 3:os<<"March";break;
		case 4:os<<"April";break;
		case 5:os<<"May";break;
		case 6:os<<"June";break;
		case 7:os<<"July";break;
		case 8:os<<"August";break;
		case 9:os<<"September";break;
		case 10:os<<"October";break;
		case 11:os<<"November";break;
		case 12:os<<"December";break;
	}
	return os;
}