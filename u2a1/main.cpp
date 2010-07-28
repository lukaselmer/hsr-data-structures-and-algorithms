/* 
 * File:   main.cpp
 * Author: Lukas Elmer
 *
 * Created on 25. Juli 2010, 16:44
 */

#include <cstdlib>

using namespace std;
#include <iostream>
#include <iterator>
#include <vector>
#include <algorithm>
#include <string>
#include <boost/bind/bind.hpp>
#include <numeric>
#include <bits/stl_function.h>
using namespace std;

//int line_counter(string line) {
//    //return distance(line.begin(), line.end());
//    return 3;
//}
//
//string line_counter(string a, string b) {
//    //return distance(line.begin(), line.end());
//    return a + b;
//}

//int line_counter(int a, int b) {
//    return a + b;
//}

struct line_counter {

    int operator()(const string & x) const {
        return x.length();
    }
};

int main(int argc, string * const argv[]) {
    //    istream_iterator<string> eof;
    //    vector<string> zeichen = vector<string > (istream_iterator<string > (cin), eof);
    //    copy(zeichen.begin(), zeichen.end(), ostream_iterator<string > (cout, "\n"));
    //    cout << "Zeilen: " << distance(zeichen.begin(), zeichen.end()) << endl;
    //    cout << "Anzahl Zeichen: " << accumulate(zeichen.begin(), zeichen.end(), "", line_counter) << endl;
    //    vector<int> vec;
    //    vec.push_back(3);
    //    vec.push_back(5);
    //    vec.push_back(10);
    //    cout << "Anzahl Zeichen: " << distance(vec.begin(), vec.end()) << endl;
    //    cout << "Zeichen: ";
    //    copy(vec.begin(), vec.end() - 1, ostream_iterator<int>(cout, ", "));
    //    cout << vec.back();
    //    cout << endl;
    //    cout << "Summe: " << accumulate(vec.begin(), vec.end(), 0, line_counter) << endl;

    vector<string> vec;
    vec.push_back("aaa");
    vec.push_back("bbb");
    vec.push_back("cc");
    cout << "Anzahl Zeichen: " << distance(vec.begin(), vec.end()) << endl;
    cout << "Zeichen: ";
    copy(vec.begin(), vec.end() - 1, ostream_iterator<string > (cout, ", "));
    cout << vec.back();
    cout << endl;
    //cout << "Summe: " << accumulate(vec.begin(), vec.end(), string(""), line_counter()) << endl;
    vector<int> vec2;
    transform(vec.begin(), vec.end(), back_inserter(vec2), line_counter());
    copy(vec2.begin(), vec2.end(), ostream_iterator<int > (cout, ", "));
    cout << endl << accumulate(vec2.begin(), vec2.end(), 0, plus<int>()) << endl;

}
