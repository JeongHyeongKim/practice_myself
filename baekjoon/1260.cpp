#include <iostream>
#include <vector>

using namespace std;

int main()
{
	int N,M,V; //N->정점 갯수, M->간선 갯수, V->탐색 시작점
	cin>>N>>M>>V;
	
	vector< vector<long> > arr(N,vector<long>(N,0));
	vector<long> search;

	for(int i=0;i<M;i++)
	{	
		int a,b;
		cin>>a>>b;
		arr[a-1][b-1]=1;
		arr[b-1][a-1]=1;
	}

	int param=V-1;
	search.push_back(V);
	vector< vector<long> > buf(N,vector<long>(N,0));
	buf=arr;
	int j=0;
	int count=0;
	while(1)
	{
		for(int i=0;i<N;i++)
		{
			cout<<"i="<<i<<endl;
			cout<<"search.size="<<search.size()<<endl;
			
			for(int j=0;j<search.size();j++)//size->원소갯수
			{	
				if(count==N)
					goto x;
				else if(buf[param][search[j]-1]==1)
				{	
					buf[param][search[j]-1]=0;
					buf[search[j]-1][param]=0;
					count++;
					cout<<"buf["<<param<<"]"<<"["<<search[j]-1<<"]="<<buf[param][search[j]-1]<<" converted!!!"<<endl;
					cout<<"count : "<<count<<endl;
				}
				else if(buf[param][i]==1)
				{
					search.push_back(i+1);
					cout<<i+1<<"->search에 등록"<<endl;
					buf[param][i]=0;
					param=i;
					cout<<"param : "<<param<<endl;
					i=param; //싱크 맞추기
					count=0;
				}
			}
		}			
	}
	x:

	for(int i=0;i<search.size();i++)
		cout<<search[i]<<" ";



	return 0;
}
