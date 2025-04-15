package com.hexaware.client;

import com.hexaware.entity.PasswordGenerator14;

import java.util.Scanner;

public class PasswordClient14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("type -generate-: ");
        String generate = scanner.nextLine();
     if(generate.equals("generate")){
         String password = PasswordGenerator14.generatePassword();
         System.out.println("Generated secure password: " + password);
     }else{
         System.out.println("okk");
     }

    }
}
