#include <iostream>
#include "Methods.cpp"

using namespace std;

int main()
{
    setlocale(LC_ALL,"Russian");
   Graph A;
   A.AddArc(1,2);
   A.AddArc(1,2);
   A.AddArc(2,1);
   A.AddArc(2,3);
   A.AddArc(3,1);
   A.AddArc(4,55);
   A.AddArc(7,1);
   A.AddArc(6,1);

   A.PrintGraph();

cout<<"-------------------------"<<endl;

   //A.DelArc(1,2);
   A.DelArc(6,1);
   //A.DelArc(2,3);


   A.PrintGraph();
}
