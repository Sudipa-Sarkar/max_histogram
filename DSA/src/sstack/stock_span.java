package sstack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
public class stock_span {
public static void main(String args[])
{
	Scanner sc = new Scanner(System.in);
	ArrayList<Integer> al1= new ArrayList<Integer>();
	int n=sc.nextInt();
	int a[]=new int[n];
	for(int i=0;i<n;i++)
	{
		a[i]=sc.nextInt();
	}
	stock_span ob = new stock_span();
	al1= ob.span_stk(a, n);
	for(int i=0;i<n;i++)
	{
		System.out.println(i-al1.get(i)+" "+al1.get(i)+" ");
		//System.out.print(i-al1.get(i)+" ");
	}
	}
public ArrayList<Integer> span_stk(int ar[],int n1)
{
	ArrayList<Integer> al= new ArrayList<Integer>();
	Stack<Integer> stk = new Stack<Integer>();
	 
	for(int i=0;i<n1;i++)
	{
		if(stk.empty())
		{
			al.add(-1);
		}
		
	else if(ar[stk.peek()]>ar[i])
		{
			al.add(i-1);
		}
		else
		{
			while(stk.empty() != true && ar[stk.peek()]<=ar[i])
			{
				
				stk.pop();
			}
		 if(stk.empty())
		 {
			 al.add(i+1);
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
