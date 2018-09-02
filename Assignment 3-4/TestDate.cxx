#include <iostream>
#include "Date.h"

using namespace std;
void TestDate()
{
	cout<<"+++Checking the constructors of dateformat "<<endl;
	try
	{
		DateFormat df1;
		cout<<"Default constructor:dateformat="<<df1<<endl;
	}
	catch(logic_error e)
	{
		cout<<e.what();
	}
	cout<<"Checking construcor taking 3 string arguments"<<endl;
	try
	{
		DateFormat df1("dd","m","yyyy");
		cout<<"Parameters:(dd,m,yyyy)dateformat="<<df1<<endl;
		cout<<"Parameters:(ddd,m,yyyy)dateformat="<<endl;
		DateFormat df2("dd","m","yyyy");
	
	}
	catch(logic_error e)
	{
		cout<<e.what();
	}
	cout<<"Checking construcor taking 1 string argument"<<endl;
	try
	{
		DateFormat df1("dd-mm-yy");
		cout<<"Parameters:(dd-mm-yy):dateformat="<<df1<<endl;
		cout<<"Parameters:(dd-mmmmmmm-yy):dateformat="<<endl;
		DateFormat df2("dd-mmmmmmm-yy");
	}
	catch(logic_error e)
	{
		cout<<e.what();
	}


	try
	{
		DateFormat df("dd-mm-yyyy");
		Date::setFormat(df);
	}
	catch(const invalid_argument& e)
	{
		cout<<"Invalid argument:"<<e.what()<<endl;
	}
	cout<<"Checking set format and get format functions(After Date::setFormat(df) we print by getFormat(df)(df=dd-mm-yyyy))"<<endl;
	cout<<Date::getFormat()<<endl;
		cout<<"+++Checking the Date Constructors"<<endl;
	cout<<"Checking the default constructor of Date"<<endl;
	try
	{
		Date d1;
		cout<<"The current system date,d1="<<d1<<endl;
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	cout<<"Checking the constructor explicit Date(const char *) of Date"<<endl;

	try
	{
		cout<<"Parameter passed:29-02-2016"<<endl;
		Date d2("29-02-2016");
		cout<<"New date constructed="<<d2<<endl;
		cout<<"Parameter passed:29-02-16"<<endl;
		Date d3("29-02-16");
		cout<<"New date constructed="<<d3<<endl;
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		cout<<"Parameter passed:31-02-2016"<<endl;
		Date d2("31-02-2016");
		cout<<"New date constructed="<<d2<<endl;
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		cout<<"Parameter passed:37-09-2016"<<endl;
		Date d2("37-09-2016");
		cout<<"New date constructed="<<d2<<endl;
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		cout<<"Parameter passed:30-13-2016"<<endl;
		Date d2("30-13-2016");
		cout<<"New date constructed="<<d2<<endl;
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		cout<<"Parameter passed:30-12-2088"<<endl;
		Date d2("30-12-2088");
		cout<<"New date constructed="<<d2<<endl;
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}

	cout<<"Checking the constructor Date(Date d,Month m,Year y) of Date"<<endl;
	try
	{
		cout<<"Parameter passed:(D01,Dec,2012)"<<endl;
		Date d2(D01,Dec,2012);
		cout<<"New date constructed="<<d2<<endl;
		cout<<"Parameter passed:(D30,Feb,2012)"<<endl;
		Date d3(D30,Feb,2012);
		cout<<"New date constructed="<<d3<<endl;
	}

	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		cout<<"Parameter passed:(static_cast<Day>(32),Jun,2015)"<<endl;
		Date d2(static_cast<Day>(32),Jun,2015);
		cout<<"New date constructed="<<d2<<endl;
		
	}
	
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		cout<<"Parameter passed:(D05,static_cast<Day>(15),2015)"<<endl;
		Date d2(D05,static_cast<Month>(15),2015);
		cout<<"New date constructed="<<d2<<endl;
		
	}
	
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		cout<<"Parameter passed:(D06,Jun,2051)"<<endl;
		Date d2(D06,Jun,2051);
		cout<<"New date constructed="<<d2<<endl;
		
	}
	
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	cout<<"Checking the copy constructor of Date:"<<endl;
	try{
		Date d1;
		cout<<"d1="<<d1<<endl;
		Date d2(d1);
		cout<<"Date d2(d1)="<<d2<<endl;

	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	cout<<"Checking the copy assignment operator of Date:"<<endl;
	try{
		Date d1("07-07-2008");
		cout<<"d1="<<d1<<endl;
		Date d2=d1;
		cout<<"Date d2=d1="<<d2<<endl;

	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	cout<<"+++Checking the pre increment ++ operator of Date"<<endl;
	try
	{
		Date d1("28-02-2011");
		cout<<"d1="<<d1<<endl;
		++d1;
		cout<<"After ++d1, d1="<<d1<<endl;

	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		Date d1("31-12-2049");
		cout<<"d1="<<d1<<endl;
		++d1;
		cout<<"After ++d1, d1="<<d1<<endl;

	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		Date d1("28-02-2016");
		cout<<"d1="<<d1<<endl;
		++d1;
		cout<<"After ++d1, d1="<<d1<<endl;

	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		Date d1("31-12-2011");
		cout<<"d1="<<d1<<endl;
		++d1;
		cout<<"After ++d1, d1="<<d1<<endl;

	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	cout<<"+++Checking the post increment ++ operator of Date"<<endl;
	try
	{
		Date d1("25-02-2011");
		cout<<"d1="<<d1<<endl;
		d1++;
		cout<<"After d1++, d1="<<d1<<endl;

	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		Date d1("30-12-2049");
		cout<<"d1="<<d1<<endl;
		d1++;
		cout<<"After d1++, d1="<<d1<<endl;

	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		Date d1("25-02-2016");
		cout<<"d1="<<d1<<endl;
		d1++;
		cout<<"After d1++, d1="<<d1<<endl;

	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		Date d1("28-12-2011");
		cout<<"d1="<<d1<<endl;
		d1++;
		cout<<"After d1++, d1="<<d1<<endl;

	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	cout<<"+++Checking the pre decrement -- operator of Date"<<endl;
	try
	{
		Date d1("01-03-2011");
		cout<<"d1="<<d1<<endl;
		--d1;
		cout<<"After --d1, d1="<<d1<<endl;

	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		Date d1("01-01-1950");
		cout<<"d1="<<d1<<endl;
		++d1;
		cout<<"After ++d1, d1="<<d1<<endl;

	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		Date d1("01-03-2016");
		cout<<"d1="<<d1<<endl;
		--d1;
		cout<<"After --d1, d1="<<d1<<endl;

	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		Date d1("01-01-2011");
		cout<<"d1="<<d1<<endl;
		--d1;
		cout<<"After --d1, d1="<<d1<<endl;

	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	cout<<"+++Checking the post decrement -- operator of Date"<<endl;
	try
	{
		Date d1("05-03-2011");
		cout<<"d1="<<d1<<endl;
		d1--;
		cout<<"After d1--, d1="<<d1<<endl;

	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		Date d1("05-01-1950");
		cout<<"d1="<<d1<<endl;
		d1--;
		cout<<"After d1--, d1="<<d1<<endl;

	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		Date d1("06-03-2016");
		cout<<"d1="<<d1<<endl;
		d1--;
		cout<<"After d1--, d1="<<d1<<endl;

	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		Date d1("03-01-2011");
		cout<<"d1="<<d1<<endl;
		d1--;
		cout<<"After d1--, d1="<<d1<<endl;

	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	cout<<"+++Checking the + operator for Date"<<endl;
	try
	{
		Date d1("30-12-2016");
		cout<<"d1="<<d1<<endl;
		cout<<"d1+368="<<d1+368<<endl;
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		Date d1("30-12-2049");
		cout<<"d1="<<d1<<endl;
		cout<<"d1+36="<<d1+36<<endl;
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		Date d1("28-02-2015");
		cout<<"d1="<<d1<<endl;
		cout<<"d1+366="<<d1+366<<endl;
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		Date d1("28-02-2016");
		cout<<"d1="<<d1<<endl;
		cout<<"d1+368="<<d1+368<<endl;
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	cout<<"+++Checking the - operator for Date"<<endl;
	try
	{
		Date d1("28-02-2015");
		Date d2("29-02-2016");
		cout<<"d1="<<d1<<"   d2="<<d2<<endl;
		cout<<"d1-d2="<<d1-d2<<endl;
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		Date d1("01-01-1950");
		Date d2("31-12-2049");
		cout<<"d1="<<d1<<"   d2="<<d2<<endl;
		cout<<"d1-d2="<<d1-d2<<endl;
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	cout<<"+++Checking the cast operator WeekNumber: "<<endl;
	try
	{
		Date d1("02-03-2016");
		cout<<"d1="<<d1<<"     static_cast<WeekNumber>(d1)="<< static_cast<WeekNumber>(d1)<<endl;


	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		Date d1("01-01-2016");
		cout<<"d1="<<d1<<"     static_cast<WeekNumber>(d1)="<< static_cast<WeekNumber>(d1)<<endl;


	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}

	try
	{
		Date d1("31-12-2012");
		cout<<"d1="<<d1<<"     static_cast<WeekNumber>(d1)"<< static_cast<WeekNumber>(d1)<<endl;


	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		Date d1("31-12-2016");
		cout<<"d1="<<d1<<"     static_cast<WeekNumber>(d1)="<< static_cast<WeekNumber>(d1)<<endl;


	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		Date d1("31-12-2015");
		cout<<"d1="<<d1<<"    static_cast<WeekNumber>(d1)="<< static_cast<WeekNumber>(d1)<<endl;


	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	cout<<"Checking cast operaor WeekDay for Date"<<endl;
	try
	{
		Date d1("02-03-2015");
		cout<<"d1="<<d1<<"    static_cast<WeekDay>(d1)="<<static_cast<WeekDay>(d1)<<endl;


	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		Date d1("27-06-1996");
		cout<<"d1="<<d1<<"    static_cast<WeekDay>(d1)="<<static_cast<WeekDay>(d1)<<endl;


	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	cout<<"Checking cast operaor Month for Date"<<endl;
	try
	{
		Date d1("02-03-2015");
		cout<<"d1="<<d1<<"    static_cast<Month>(d1)="<<static_cast<Month>(d1)<<endl;


	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		Date d1("27-06-1996");
		cout<<"d1="<<d1<<"    static_cast<Month>(d1)="<<static_cast<Month>(d1)<<endl;


	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	cout<<"+++Testing the relational operators..."<<endl;
	try{
		Date d1("22-07-2011");
		Date d2("02-08-2005");
		Date d3("07-02-1996");
		Date d4("12-12-2016");
		Date d5("08-02-2016");
		Date d6("02-02-2015");
		Date d7(D02,Feb,2015);
		if(d1==d6)
			cout<<d1<<"=="<<d6<<endl;
		else cout<<d1<<"!="<<d6<<endl;
		if(d7==d6)
			cout<<d7<<"=="<<d6<<endl;
		else cout<<d7<<"!="<<d6<<endl;
		if(d2!=d6)
			cout<<d2<<"!="<<d6<<endl;
		else cout<<d2<<"=="<<d6<<endl;
		if(d7!=d6)
			cout<<d7<<"!="<<d6<<endl;
		else cout<<d7<<"=="<<d6<<endl;
		if(d4>=d6)
			cout<<d4<<">="<<d6<<endl;
		else cout<<d4<<"<"<<d6<<endl;
		if(d1>=d6)
			cout<<d1<<">="<<d6<<endl;
		else cout<<d1<<"<"<<d6<<endl;
		if(d3<=d6)
			cout<<d3<<"<="<<d6<<endl;
		else cout<<d3<<">"<<d6<<endl;
		if(d5<=d6)
			cout<<d5<<"<="<<d6<<endl;
		else cout<<d5<<">"<<d6<<endl;
		if(d3<d5)
			cout<<d3<<"<"<<d5<<endl;
		else cout<<d3<<">="<<d5<<endl;
		if(d4<d5)
			cout<<d4<<"<"<<d5<<endl;
		else cout<<d4<<">="<<d5<<endl;
		if(d4>d1)
			cout<<d4<<">"<<d1<<endl;
		else cout<<d4<<"<="<<d1<<endl;	
		if(d2>d1)
			cout<<d2<<">"<<d1<<endl;
		else cout<<d2<<"<="<<d1<<endl;	
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	
	cout<<"+++Checking all the date formats"<<endl;
	try
	{
		
		Date d7(D04,Mar,2018);
		DateFormat df("dd-mm-yy");
		Date::setFormat(df);
		cout<<df<<":"<<d7<<endl;
		DateFormat df1("d-mm-yy");
		Date::setFormat(df1);
		cout<<df1<<":"<<d7<<endl;
		DateFormat df2("0-mm-yy");
		Date::setFormat(df2);
		cout<<df2<<":"<<d7<<endl;
		DateFormat df3("dd-m-yy");
		Date::setFormat(df3);
		cout<<df3<<":"<<d7<<endl;
		DateFormat df4("d-m-yy");
		Date::setFormat(df4);
		cout<<df4<<":"<<d7<<endl;
		DateFormat df5("0-m-yy");
		Date::setFormat(df5);
		cout<<df5<<":"<<d7<<endl;
		DateFormat df6;//default format dd-mmm-yy
		Date::setFormat(df6);
		cout<<df6<<":"<<d7<<endl;
		DateFormat df7("d-mmm-yy");
		Date::setFormat(df7);
		cout<<df7<<":"<<d7<<endl;
		DateFormat df8("0-mmm-yy");
		Date::setFormat(df8);
		cout<<df8<<":"<<d7<<endl;
		DateFormat df9("dd-0-yy");
		Date::setFormat(df9);
		cout<<df9<<":"<<d7<<endl;
		DateFormat df10("d-0-yy");
		Date::setFormat(df10);
		cout<<df10<<":"<<d7<<endl;
		DateFormat df11("0-0-yy");
		Date::setFormat(df11);
		cout<<df11<<":"<<d7<<endl;
		DateFormat df12("dd-mm-yyyy");
		Date::setFormat(df12);
		cout<<df12<<":"<<d7<<endl;
		DateFormat df13("d-mm-yyyy");
		Date::setFormat(df13);
		cout<<df13<<":"<<d7<<endl;
		DateFormat df14("0","mm","yyyy");
		Date::setFormat(df14);
		cout<<df14<<":"<<d7<<endl;
		DateFormat df15("dd-m-yyyy");
		Date::setFormat(df15);
		cout<<df15<<":"<<d7<<endl;
		DateFormat df16("d-m-yyyy");
		Date::setFormat(df16);
		cout<<df16<<":"<<d7<<endl;
		DateFormat df17("0-m-yyyy");
		Date::setFormat(df17);
		cout<<df17<<":"<<d7<<endl;
		DateFormat df18("dd-mmm-yyyy");
		Date::setFormat(df18);
		cout<<df18<<":"<<d7<<endl;
		DateFormat df19("d-mmm-yyyy");
		Date::setFormat(df19);
		cout<<df19<<":"<<d7<<endl;
		DateFormat df20("0-mmm-yyyy");
		Date::setFormat(df20);
		cout<<df20<<":"<<d7<<endl;
		DateFormat df21("dd-0-yyyy");
		Date::setFormat(df21);
		cout<<df21<<":"<<d7<<endl;
		DateFormat df22("d-0-yyyy");
		Date::setFormat(df22);
		cout<<df22<<":"<<d7<<endl;
		DateFormat df23("0-0-yyyy");
		Date::setFormat(df23);
		cout<<df23<<":"<<d7<<endl;
		DateFormat df24("dd-mm-0");
		Date::setFormat(df24);
		cout<<df24<<":"<<d7<<endl;
		DateFormat df25("d-mm-0");
		Date::setFormat(df25);
		cout<<df25<<":"<<d7<<endl;
		DateFormat df26("0-mm-0");
		Date::setFormat(df26);
		cout<<df26<<":"<<d7<<endl;
		DateFormat df27("dd-m-0");
		Date::setFormat(df27);
		cout<<df27<<":"<<d7<<endl;
		DateFormat df28("d-m-0");
		Date::setFormat(df28);
		cout<<df28<<":"<<d7<<endl;
		DateFormat df29("0-m-0");
		Date::setFormat(df29);
		cout<<df29<<":"<<d7<<endl;
		DateFormat df30("dd-mmm-0");
		Date::setFormat(df30);
		cout<<df30<<":"<<d7<<endl;
		DateFormat df31("d-mmm-0");
		Date::setFormat(df31);
		cout<<df31<<":"<<d7<<endl;
		DateFormat df32("0-mmm-0");
		Date::setFormat(df32);
		cout<<df32<<":"<<d7<<endl;
		DateFormat df33("dd-0-0");
		Date::setFormat(df33);
		cout<<df33<<":"<<d7<<endl;
		DateFormat df34("d-0-0");
		Date::setFormat(df34);
		cout<<df34<<":"<<d7<<endl;
		DateFormat df35("0","0","0");
		Date::setFormat(df35);
		cout<<df35<<":"<<d7<<endl;
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
			char str1[]="02-06-2012";
		char str2[]="02-06-12";
		char str3[]="2-06-12";
		char str4[]="2-06-2012";
		char str5[]="02-6-12";
		char str6[]="02-6-2012";
		char str7[]="2-6-12";
		char str8[]="2-6-2012";
		try
		{
		DateFormat df50("dd-mm-yy");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str2<<":";
		Date d7(str2);
		cout<<d7<<endl;
		cout<<str1<<":";
		Date d8(str1);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		
		try
		{
		DateFormat df50("d-mm-yy");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("d-mm-yyyy");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str4<<":";
		Date d7(str4);
		cout<<d7<<endl;
		cout<<str5<<":";
		Date d8(str5);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("dd-mm-yyyy");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str1<<":";
		Date d7(str1);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("dd-m-yy");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str5<<":";
		Date d7(str5);
		cout<<d7<<endl;
		cout<<str6<<":";
		Date d8(str6);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("dd-m-yyyy");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str6<<":";
		Date d7(str6);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("d-m-yy");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str7<<":";
		Date d7(str7);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("d-m-yyyy");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str8<<":";
		Date d7(str8);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("dd-mmm-yy");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("dd-mmm-yyyy");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("d-mmm-yy");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("d-mmm-yyyy");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("0-mmm-yy");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("0-mmm-yyyy");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("0-mmm-0");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("d-mmm-0");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("dd-mmm-0");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("d-0-yy");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("dd-0-yy");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("d-0-yyyy");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("dd-0-yyyy");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("0-0-0");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("0-0-yy");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("0-0-yyyy");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("d-0-0");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("dd-0-0");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("0-mm-yy");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("0-mm-yyyy");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("0-m-yy");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("0-m-yyyy");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("0-mm-0");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("0-m-0");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("d-mm-0");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("dd-mm-0");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("d-m-0");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		try
		{
		DateFormat df50("dd-m-0");
		Date::setFormat(df50);
		cout<<df50<<endl;
		cout<<str3<<":";
		Date d7(str3);
		cout<<d7<<endl;
		cout<<str4<<":";
		Date d8(str4);
		cout<<d8<<endl;
		}
		catch(logic_error e)
		{
			cout<<e.what()<<endl;
		}
		
	cout<<"++Checking  some other exception situations"<<endl;
	try
	{
		cout<<"Date d8(static_cast<Day>(35),Mar,2015):";
		Date d8(static_cast<Day>(35),Mar,2015);
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		cout<<"Date d8(D30,static_cast<Month>(13),2015):";
		Date d8(D30,static_cast<Month>(13),2015);
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		cout<<"Date d8(D30,Mar,-2015):";
		Date d8(D30,Mar,-2015);
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		cout<<"Date d8(D31,Apr,2015):";
		Date d8(D31,Apr,2015);
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		cout<<"Date d8(D29,Feb,2015):";
		Date d8(D29,Feb,2015);
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		cout<<"Date d8(D30,Jun,2060):";
		Date d8(D30,Jun,2060);
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	DateFormat df36("dd-mm-yyyy");
	Date::setFormat(df36);
	try
	{
		cout<<"Date d8(31-02-2012):";
		Date d8("31-02-2012");
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		cout<<"DateFormat=dd-mm-yyyy Date d8(31-1-2012):";
		Date d8("31-1-2012");
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		cout<<"DateFormat=dd-mm-yyyy Date d8(7-8-2012):";
		Date d8("7-8-2012");
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		cout<<"DateFormat=dd-mm-yyyy Date d8(07-08-12):";
		Date d8("07-08-12");
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		cout<<"07-08-2012"<<"+20000="<<endl;
		Date d50("07-08-2012");//overflow error for + operator
		Date d51=d50+20000;
		cout<<d50<<"+20000="<<d51<<endl;
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	try
	{
		cout<<"DateFormat d40(dddddddd-mmmmmmmm-yyyyyyyyyyyyy):";
		DateFormat d40("dddddddd-mmmmmmmm-yyyyyyyyyyyyy");
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	Date::setFormat(df36);
	cout<<"+++Taking inputs from user:"<<endl;
	cout<<"Enter a date in dd-mm-yyyy format"<<endl;
	try
	{
		Date d10;
		cin>>d10;
		cout<<"New date created="<<d10<<endl;
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	DateFormat df37("dd","mm","yy");
	Date::setFormat(df37);
	cout<<"Enter a date in dd-mm-yy format"<<endl;
	try
	{
		Date d10;
		cin>>d10;
		cout<<"New date created="<<d10<<endl;
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	DateFormat df38("dd","m","yyyy");
	Date::setFormat(df38);
	cout<<"Enter a date in dd-m-yyyy format"<<endl;
	try
	{
		Date d10;
		cin>>d10;
		cout<<"New date created="<<d10<<endl;
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	DateFormat df39("dd","m","yy");
	Date::setFormat(df39);
	cout<<"Enter a date in dd-m-yy format"<<endl;
	try
	{
		Date d10;
		cin>>d10;
		cout<<"New date created="<<d10<<endl;
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	DateFormat df40("d","mm","yyyy");
	Date::setFormat(df40);
	cout<<"Enter a date in d-mm-yyyy format"<<endl;
	try
	{
		Date d10;
		cin>>d10;
		cout<<"New date created="<<d10<<endl;
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	DateFormat df41("d","mm","yy");
	Date::setFormat(df38);
	cout<<"Enter a date in d-mm-yy format"<<endl;
	try
	{
		Date d10;
		cin>>d10;
		cout<<"New date created="<<d10<<endl;
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	DateFormat df42("d","m","yy");
	Date::setFormat(df42);
	cout<<"Enter a date in d-m-yy format"<<endl;
	try
	{
		Date d10;
		cin>>d10;
		cout<<"New date created="<<d10<<endl;
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	DateFormat df43("d","m","yyyy");
	Date::setFormat(df43);
	cout<<"Enter a date in d-m-yyyy format"<<endl;
	try
	{
		Date d10;
		cin>>d10;
		cout<<"New date created="<<d10<<endl;
	}
	catch(logic_error e)
	{
		cout<<e.what()<<endl;
	}
	

}
int main()
{

	TestDate();
	return 0;
}
