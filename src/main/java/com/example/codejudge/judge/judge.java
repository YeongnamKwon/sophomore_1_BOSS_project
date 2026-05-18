package com.example.codejudge.judge;

public class judge {

    public boolean check(String output,String answer) {
    	return output.trim().equals(answer.trim());
    }
}