/* 
 * File:   main.cpp
 * Author: Lukas Elmer
 *
 * Created on 25. Juli 2010, 18:36
 */

#include <cstdlib>
#include <string>
#include <functional>
#include <numeric>

using namespace std;

#include "cute.h"
#include "ide_listener.h"
#include "cute_runner.h"

struct toLowerFunct {

    char operator()(char & c) {
        return tolower(c);
    }
};

struct countingToLowerFunct {

    int operator()(int & act, char & c) {
        return act + (tolower(c) == c ? 0 : 1);
    }
};

int countingToLower(string & str) {
    int count = accumulate(str.begin(), str.end(), 0, countingToLowerFunct());
    transform(str.begin(), str.end(), str.begin(), toLowerFunct());
    return count;
}

//int countingToLower(string & str) {
//    int counter = 0;
//    string::iterator it = str.begin();
//    while (it != str.end()) {
//        char d = tolower(*it);
//        if (d != *it) {
//            *it = d;
//            counter++;
//        }
//        it++;
//    }
//    return counter;
//}

void lowerFirstCharacter() {
    std::string str("Hello!");
    ASSERT_EQUAL(1, countingToLower(str));
    ASSERT_EQUAL("hello!", str);
}

void lowerSeveralCharacters() {
    std::string str("Hello World, its ME!");
    ASSERT_EQUAL(4, countingToLower(str));
    ASSERT_EQUAL("hello world, its me!", str);
}

void lowerNone() {
    std::string str("no uppercase characters here");
    ASSERT_EQUAL(0, countingToLower(str));
    ASSERT_EQUAL("no uppercase characters here", str);
}

void lowerAll() {
    std::string str("LOL");
    ASSERT_EQUAL(3, countingToLower(str));
    ASSERT_EQUAL("lol", str);
}

void lowerEmpty() {
    std::string str("");
    ASSERT_EQUAL(0, countingToLower(str));
    ASSERT_EQUAL("", str);
}

void umlautsAreNotChanged() {
    std::string str("ÄÖÜ");
    ASSERT_EQUAL(0, countingToLower(str));
    ASSERT_EQUAL("ÄÖÜ", str);
}

void runSuite() {
    cute::suite s;

    s.push_back(CUTE(lowerFirstCharacter));
    s.push_back(CUTE(lowerSeveralCharacters));
    s.push_back(CUTE(lowerNone));
    s.push_back(CUTE(lowerAll));
    s.push_back(CUTE(lowerEmpty));
    s.push_back(CUTE(umlautsAreNotChanged));

    cute::ide_listener lis;
    cute::makeRunner(lis)(s, "countingToLower-Suite");
}

int main() {
    runSuite();
}


