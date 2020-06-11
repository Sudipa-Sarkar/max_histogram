package sstack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class max_histogram {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		/*ArrayList<Integer> nsr= new ArrayList<Integer>();
		ArrayList<Integer> nsl= new ArrayList<Integer>();*/
		int n=sc.nextInt();
		int a[]=new int[n];
		//int area[]=new int[n];
		
		//int c;
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		max_histogram ob = new max_histogram();
		/*nsl= ob.NSL(a, n);
		nsr=ob.NSR(a,n);
		int z=n-1;
		int z1=n-1;
		for(int i=0;i<n;i++)
		{
			
			c=nsr.get(z--)-nsl.get(i)-1;
			System.out.println(nsr.get(z1--)+" "+nsl.get(i));
			area[i]=a[i]*c;
		}*/
		
		System.out.println(ob.MAH(a,n));
	}
	public int MAH(int ar[],int n)
	
	{
		ArrayList<Integer> nsr= new ArrayList<Integer>();
		ArrayList<Integer> nsl= new ArrayList<Integer>();
		nsr=NSR(ar,n);
		nsl=NSL(ar,n);
		int z=n-1;
		int c;
		int area[]=new int[n];
		for(int i=0;i<n;i++)
		{
			
			c=nsr.get(z--)-nsl.get(i)-1;
			//System.out.println(nsr.get(z1--)+" "+nsl.get(i));
			area[i]=ar[i]*c;
		}
		return MAX(area,n);
	}
	public int MAX(int ar[],int n1)
	{
		int max=ar[0];
		for(int i=1;i<n1;i++)
		{
			if(max<ar[i])
			{
				max=ar[i];
			}
		}
		return max;
	}
	
	public ArrayList<Integer> NSL(int ar[],int n1)
	{
		ArrayList<Integer> all= new ArrayList<Integer>();
		Stack<Integer> stk1 = new Stack<Integer>();
		 
		for(int i=0;i<n1;i++)
		{
			if(stk1.empty())
			{
				all.add(-1);
			}
			
		else if(ar[stk1.peek()]<ar[i])
			{
				all.add(stk1.peek());
			}
			else
			{
				while(stk1.empty() != true && ar[stk1.peek()]>=ar[i])
				{
					
					stk1.pop();
				}
			 if(stk1.empty())
			 {
				 all.add(-1);
			 }
			 else
			 {
				 all.add(stk1.peek());
			 }
			}
			stk1.add(i);
		}
		
		return all;
		}
	

public ArrayList<Integer> NSR(int ar[],int n1)
{
	ArrayList<Integer> al= new ArrayList<Integer>();
	Stack<Integer> stk = new Stack<Integer>();
	 
	for(int i=n1-1;i>=0;i--)
	{
		if(stk.empty())
		{
			al.add(n1);
		}
		
	else if(ar[stk.peek()]<ar[i])
		{
			al.add(stk.peek());
		}
		else
		{
			while(stk.empty() != true && ar[stk.peek()]>=ar[i])
			{
				
				stk.pop();
			}
		 if(stk.empty())
		 {
			 al.add(n1);
		 }
		 else
		 {
			 al.add(stk.peek());
		 }
		}
		stk.add(i);
	}
	return al;
	}



}
