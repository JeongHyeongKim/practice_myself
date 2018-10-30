#include<iostream>
#include<vector>
using namespace std;

int main()
{
	vector<int> buffer;
	float a;
	cout<<"소수 입력시 종료"<<endl;
	while(1)
	{
		cout<<"input:";
		cin>>a;
		if(a-(int)a!=0)
			break;
		buffer.push_back(a);
	}
	int compare=buffer[0];
	int max=0;
	vector<int> list;
	list.push_back(buffer[0]);
	for(int i=0;i<buffer.size();i++)
		cout<<buffer[i];
	cout<<endl<<"output : ";
	for(int i=1;i<buffer.size();i++)
	{
		if(compare+buffer[i]<buffer[i])
		{
			compare=buffer[i];
			list.clear();
			list.push_back(buffer[i]);
			if(max<compare)
				max=compare;
		}
		else
		{
			compare=compare+buffer[i];
			list.push_back(buffer[i]);
			if(max<compare)
				max=compare;
		}
	}
	cout<<max<<"//";
	for(int i=0;i<list.size();i++)
	{	
		if(i==list.size()-1)
		{
			cout<<list[i];
			continue;
		}
		if(list[i]>=0)
			cout<<list[i]<<"+";
		else
			cout<<"("<<list[i]<<")"<<"+";
	}
	cout<<endl<<endl;
	for(int i=0;i<list.size()-1;i++)
		cout<<list[i]<<" ";
	return 0;
}
		
