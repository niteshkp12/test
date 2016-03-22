package com.test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPattern {
	public static void main(String[] args) {
		System.out.println("TestPattern.main()");
        Scanner in = new Scanner(System.in);
        while(in.hasNext())
        {
            String IP = in.next();
            System.out.println(IP.matches(new myRegex().pattern));
        }

    }

}

class myRegex{
	public static String pattern = "([0-2]*[0-5]*[0-9]).([0-2]*[0-5]*[0-9]).([0-2]*[0-5]*[0-9])([0-2]*[0-5]*[0-9]*)";
}




/*


12.12.12.12
13.13.13.112
VUUT.12.12
111.111.11.111
1.1.1.1.1.1.1
.....
1...1..1..1
0.0.0.01
255.0.255.0
266.266.266.266
00000.000000.0000000.00001
0023.0012.0012.0034








true
true
false
true
false
false
false
true
true
false
false
false
*/