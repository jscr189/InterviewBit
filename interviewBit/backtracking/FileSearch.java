package interviewBit.backtracking;

import java.util.Date;

public class FileSearch {

	public static void main(String[] args) {
		String s="23.01.1996 -w- delete-this.html\n"
				+ "25.03.1991 -w- system.dll\n"
				+ "08.01.1976 -w- readme.html\n"
				+ "12.06.1986 rw- a.ss\n"
				+ "05.09.2009 rwx s.as\n"
				+ "19.07.2004 r-- library.dll";
		System.out.println(solution(s));		
	}

	public static String solution(String s) {
		String res=null;
		int sum=0,count=0;
		String s1[]=s.split("\n");
		for(int i=0;i<s1.length;i++)
		{
			String s2[]=s1[i].split(" ");
			if(s2[1].charAt(2)=='x')
			{
				Date date1=new Date(Integer.parseInt(s2[0].substring(s2[0].length()-4)),Integer.parseInt(s2[0].substring(3, 4)),Integer.parseInt(s2[0].substring(0, 1)));
				
				if(!date1.after(new Date(2004,7,19)))
				{
					sum+=s2[2].length();
					count++;
				}					
			}
		}
		if(sum>0)
			res=""+(sum/count);
		return (res==null)?"NO FILES":res;
	}

}
