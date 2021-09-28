package lab02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Linter {

    public int linterMethod(String route ) throws Exception{
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(route)));
        int errCounter = 0;
        int lineError = 0;
        String currentLine = "";
        try{

            while(scanner.hasNext()){
                if (!currentLine.endsWith(";")&& !currentLine.isEmpty()&& !currentLine.endsWith("{")
                        &&!currentLine.endsWith("}") && !currentLine.contains("if")&&!currentLine.contains("else")){
                    errCounter++;
                }else{
                    lineError++;
                }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            scanner.close();
        }
        return errCounter;



    }
}
