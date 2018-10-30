#include <iostream>

using namespace std;

int main()
{
	int E,S,M;
	cin>>E>>S>>M;

	int result=0;
	int E_else,S_else,M_else=0;
	while(true)
	{
		E_else=result%15;
		S_else=result%28;
		M_else=result%19;
		if(E_else==E-1&&S_else==S-1&&M_else==M-1)
			break;
		result++;
	}
	cout<<result+1;
	return 0;
}
	
