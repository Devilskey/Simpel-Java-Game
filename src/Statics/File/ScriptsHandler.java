package Statics.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ScriptsHandler {

    public static String[] GetNPCScript(String Path)
            throws IOException {
        try{
        List<String> ListLines = Files.readAllLines(Paths.get(Path));

        String[] ArrayLines = new String[ListLines.size()];

        ListLines.toArray(ArrayLines);

        return ArrayLines;

        }catch (IOException e) {
            // Handle the exception or rethrow if you want the caller to handle it
            System.err.println("An error occurred while reading the file: " + e.getMessage());
            throw e;
        }
    }
}
