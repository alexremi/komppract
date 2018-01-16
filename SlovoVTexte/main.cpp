#include <iostream>
#include <string>

using namespace std;

string find_spell( string spell ) {

    unsigned cnt_spell = 0;
    string sub_spell;

    unsigned size = spell.size();
    for ( unsigned i = 0; i < size; ++i ) {
        for ( unsigned j = 1; j <= size - i; ++j ) {
            string sub = spell.substr( i, j );

            unsigned cnt = 0;
            for ( unsigned k = i + 1; k <= size - sub.size(); ++k ) {
                std::string::size_type n = spell.find( sub, k );
                if ( n != string::npos ) ++cnt;
            }

            if ( cnt > cnt_spell ) {
                sub_spell = sub;
                cnt_spell = cnt;
            } else if ( cnt == cnt_spell && sub.size() > sub_spell.size() ) {
                sub_spell = sub;
                cnt_spell = cnt;
            }
        }
    }
    return sub_spell;
}

int main()
{
    cout << "Privet kak dela Privet - " << find_spell( "Privet kak dela Privet" ) << endl;
    return 0;
}
