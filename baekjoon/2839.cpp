#include<iostream>

using namespace std;

int main()
{
	int input;
	int flag=0; 
	cin>>input;
	int i,j;

	for(i=0;i<input;i++)//three*x kg
	{
		for(j=0;j*5<input;j++)//five*x kg
		{
			if(i*3+j*5==input)
			{
				flag=1;
				goto x;
			}
		}									}
	x:
//	cout<<flag<<endl;
	if(flag==0)
		cout<<-1;
	else
		cout<<i+j;
	return 0;
}

