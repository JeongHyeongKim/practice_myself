#include <iostream>
using namespace std;

int main()
{
	int big, small;
	int buffer_big, buffer_small;
	cin>>big>>small;

	int a,b;
	
	if(big<small)
	{
		int buffer=small;
		small=big;
		big=buffer;
	}
	
	buffer_big=big;
	buffer_small=small;	

	while(1)
	{
		if(buffer_big%buffer_small!=0)
		{
			buffer_small--;
		}
		else
		{
			if(small%buffer_small!=0)
				buffer_small--;
			else{
			a=buffer_small;
			break;
			}
		}
	}
	int big_count=1;
	int small_count=1;
	buffer_big=big;
	buffer_small=small;
	while(1)
	{
		if(big_count*buffer_big>small_count*buffer_small)
			small_count++;
		else if(big_count*buffer_big<small_count*buffer_small)
			big_count++;

		else
		{
			b=big_count*big_buffer;
			break;
		}
	}

	cout<<a<<endl<<b;			
	return 0;
}
