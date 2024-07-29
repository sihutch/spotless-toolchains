package com.shutch.spotless;

public class Java21Example {
    record Point(int x, int y) {}


    public static int recordPattern(Object obj) {
        if(obj instanceof Point(int x, int y)) {
            return x+y;
        }
        return 0;
    }
}
