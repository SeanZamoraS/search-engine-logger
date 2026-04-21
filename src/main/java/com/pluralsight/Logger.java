package com.pluralsight;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;
import java.time.*;

public class Logger
{
    static Scanner input = new Scanner(System.in);

    public static void main()
    {
        FileOutputStream fileOutputStream = null;
        PrintStream printer = null;
        try
        {
            fileOutputStream = new FileOutputStream("log.txt", true);
            printer = new PrintStream(fileOutputStream);

            String timeStampStartUp = makeTimeStamp();

            printer.printf("%s : Started program. \n", timeStampStartUp);

            String userInput = "";

            while(!(userInput.equals("X")))
            {
                System.out.println("What would you like to search for? Enter 'X' to exit.");
                userInput = input.nextLine();

                if (!(userInput.equals("X")))
                {
                    String currentTime = makeTimeStamp();
                    printer.printf("%s : Searched for - %s\n", currentTime, userInput);
                }
            }

            System.out.println("Exiting program.");

            String currentTime = makeTimeStamp();
            printer.printf("%s : Exited program.", currentTime);
        }

        catch (Exception ex)
        {
            System.out.println("Oops, couldn't find the log file.");
        }

        finally
        {
            if (printer != null)
            {
                printer.close();
            }

        }

    }

    public static String makeTimeStamp()
    {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timeStamp = currentTime.format(timeFormatter);

        return timeStamp;
    }
}