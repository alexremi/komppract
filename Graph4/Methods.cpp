
using namespace std;


 class Graph {
  private:
  struct Arc{
      int beg,en,b,e;
      Arc *next;

       explicit Arc(int b, int e, Arc *n=nullptr){
      beg = b;
      en = e;
      next = n;
        }
      };

      Arc *first, *last, *Ukaz;
      int arcCount=0/*, vertexNumber=0*/;
  public:
    Graph () : first(nullptr), last(nullptr), arcCount(0)/*, vertexNumber(n)*/{};
    ~Graph();
    void AddArc (int from,int to);
    void DelArc (int from,int to);
    bool HasArc(int from,int to);
    /*int CountVertex() const{
    return vertexNumber;
    };*/
    void PrintGraph ();
};

//---------------------------------------------------------------------------------------------------------------------------------



Graph:: ~Graph(){
    Arc * current = first, * prev = nullptr;
    while (current){
        prev = current;
        current = current->next;
        delete prev;
    }
}

void Graph::AddArc(int from, int to){
    if (HasArc(from,to)){
  cout<<"Дуга "<<"("<<from<<","<<to<<")"<<" уже есть в графе"<<endl;
    }else{
 if (from < 0 || to < 0/* || from >= vertexNumber || to >= vertexNumber*/)
    return;
 Arc *newArc = new Arc(from,to);
 if (last) last->next = newArc;
    else
    first = newArc;
    last = newArc;
    ;
    arcCount++;
}
}

bool Graph::HasArc(int from, int to)  {
 for (Arc *current = first; current; current = current->next){
        if (current->beg == from && current->en == to){
                //cout<<"Дугa существует"<<endl;
             return true;
        }
}
//cout<<"Дуги "<<"("<<from<<","<<to<<")"<<" не существует"<<endl;
 return false;
}

void Graph::DelArc(int from,int to){
if (!HasArc(from,to)){
  cout<<"Дуги "<<"("<<from<<","<<to<<")"<<" не существует"<<endl;
}else{

/*Arc *current=first;
Arc *curren=first;

for (int i = 0; i < from - 1; i++) {
        for (int j = 0; j < to - 1; j++) {
curren = current;
first = first->next;
}
}
if((from>0) && (to>0))
    first = first->next;
current->next = curren->next;
//delete curren;
free(curren);*/

/*Arc *current=first;
Arc *curren=first;
if(current->beg == from && current->en == to){
        first =first->next;
    delete current;
}else{
while(current->beg != from && curren->en != to){
    first = first->next;
    curren = curren->next;
}
}*/
Arc *curren;
for (Arc *current = first; current; current = current->next){
        if (current->beg == from && current->en == to){
             delete current;
        }
}
arcCount--;
}
}

void Graph::PrintGraph(){
    if(arcCount==0){
        cout<<"Пустой граф"<<endl;
    }else{
     Arc *current= first;
     while(current!= nullptr){
        if(current->next!=nullptr){
            while(current!=nullptr){
                    cout<<"("<<current->beg<<","<<current->en<<")"<<endl;
            current=current->next;
            }
}
     }
      }
}
