package Debugger;

import enums.LogLevel;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Logger {

    protected static String DatePattern = "MM/dd/yyyy";
    protected static File file;
    protected static DateFormat dateFormat;
    protected static BufferedWriter LogWriter;


    public static void LoggerInit(){
        dateFormat = new SimpleDateFormat(DatePattern);
        Date today = Calendar.getInstance().getTime();
        String DateString = dateFormat.format(today).replace("/", "-");
        String path = "Logging/Log-" + DateString + ".txt";
        file = new File(path);

        try {
            Files.createDirectories(Paths.get("Logging"));

            if(!file.exists()) {
                if (file.createNewFile())
                    DebugWindow.log("Created Log File: " + path);
            }
        } catch (IOException e) {
            DebugWindow.log(e.getMessage() + " Name:  " +dateFormat.format(today) );
        }
    }

    public static void LogDebug(String Log){
        Log(LogLevel.Debug, Log);
    }


    public static void Log(LogLevel Type, String Log){
        try {
            LogWriter = new BufferedWriter(new FileWriter(file, true));
            String PreparedMessage = PrepareMessage(Type, Log);
            LogWriter.append(PreparedMessage);
            LogWriter.newLine();
            LogWriter.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    protected static String PrepareMessage(LogLevel type, String FileInput) {
        String timeStamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
        String logData = "[" + type + "] ["  + timeStamp + "] " ;
        String message =  "Log: { " + FileInput + " }";
        return logData + message;
    }
}
