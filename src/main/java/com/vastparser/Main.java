package com.vastparser;

import com.vastparser.service.VastService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VastService vastService = new VastService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the input method:");
        System.out.println("1. Read XML from File");
        System.out.println("2. Read XML from URL");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter the file path: ");
                String filePath = scanner.nextLine();
                vastService.parseVastFromFile(filePath);
                break;
            case 2:
                System.out.print("Enter the URL: ");
                String url = scanner.nextLine();
                vastService.parseVastFromUrl(url);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
}
