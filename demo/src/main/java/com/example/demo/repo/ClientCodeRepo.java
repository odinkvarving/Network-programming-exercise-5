package com.example.demo.repo;

import com.example.demo.code.ClientCode;
import org.springframework.stereotype.Repository;
import java.io.*;

@Repository
public class ClientCodeRepo {

    public ClientCode getCode(ClientCode code) {

        if(code.getCode() != null) {
            try {
                FileWriter writer = new FileWriter("C:\\Users\\odink\\OneDrive – NTNU\\Nettverksprogrammering\\Arbeidskrav 5\\demo\\src\\main\\resources\\main.cpp");
                PrintWriter printWriter = new PrintWriter(writer);
                printWriter.print(code.getCode());
                writer.close();
                printWriter.close();
                System.out.println("Code added to file");
                code.setCode(runTerminalCommands());
                return code;
            }catch (IOException e) {
                System.out.println("ERROR");
                e.printStackTrace();
            }
        }
        System.out.println("ERROR");
        return null;
    }

    public String runTerminalCommands() {

        String[] command = {"bash", "src/main/resources/docker-script.sh"};
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        //processBuilder.redirectErrorStream(true);
        try {
            Process process = processBuilder.start();
            BufferedReader response = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String output = "";
            while((output = response.readLine()) != null) {
                sb.append(output).append("\n");
            }
            process.waitFor();
            return sb.toString();

        }catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
