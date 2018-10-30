#include <iostream>

using namespace std;

int main()
{
	int small[9];
	int sum=0;
	int clue[2];
	for(int i=0;i<9;i++)
		cin>>small[i];
	
	for(int i=0;i<9;i++)
	{
		for(int j=i+1;j<9;j++)
		{
			if(small[j]<small[i])
			{
				swap(small[i], small[j]);
			}
		}
	}
	for(int i=0;i<9;i++)
		sum=sum+small[i];
	for(int i=0;i<9;i++)
	{
		for(int j=i+1;j<9;j++)
		{
			if(small[i]+small[j]==sum-100)
			{
				clue[0]=i;
				clue[1]=j;
			}
		}
	}
	for(int i=0;i<9;i++)
	{
		if(i==clue[0]||i==clue[1])
		{}
		else
			cout<<small[i]<<endl;
	}
	
	return 0;
}
