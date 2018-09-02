package CList;

public class FullContactList {
	final int MAX=1000;
	int tot,per,rel,prof,cas;
	 relatives r[]=new relatives[MAX];
	 personalFriends p[]=new personalFriends[MAX];
	 professionalFriends f[]=new professionalFriends[MAX];
	casualAq c[]=new casualAq[MAX];
	public static int match(String s,FullContactList L)
	{
		for(int i=0;i<L.rel;++i)
			if(L.r[i].name.compareTo(s)==0)
				return 1;
		for(int i=0;i<L.per;++i)
			if(L.p[i].name.compareTo(s)==0)
				return 1;
		for(int i=0;i<L.prof;++i)
			if(L.f[i].name.compareTo(s)==0)
				return 1;
		for(int i=0;i<L.cas;++i)
			if(L.c[i].name.compareTo(s)==0)
				return 1;
		
		return 0;
	}
	

}
