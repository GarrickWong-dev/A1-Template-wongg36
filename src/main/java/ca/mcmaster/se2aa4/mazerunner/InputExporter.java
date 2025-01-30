package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;
import java.util.*;

public class InputExporter{
    private String[] args;
	private static final Logger logger = LogManager.getLogger(InputExporter.class);

    public InputExporter(String[] args){
        this.args = args;
    }

    //Get maze from user input
    public ArrayList<ArrayList<String>> getMaze(){
        ArrayList<ArrayList<String>> maze = new ArrayList<>();
        Options options = new Options();
        options.addOption("i", true, "Input Maze File");
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, this.args);
            if (cmd.hasOption("i")){
                String mazeStr = cmd.getOptionValue("i");
                logger.info("**** Reading the maze from file " + mazeStr);
                BufferedReader reader = new BufferedReader(new FileReader(mazeStr));
                String line;
                boolean line1 = false;
                while ((line = reader.readLine()) != null) {
					ArrayList<String> row = new ArrayList<>();
                    for (int idx = 0; idx < line.length(); idx++) {
                        if (line.charAt(idx) == '#') {
							row.add("WALL");
                            logger.trace("WALL ");
                        } else if (line.charAt(idx) == ' ') {
							row.add("PASS");
                            logger.trace("PASS ");
                        }
                    }
                    if (line1 == true && line.length() < maze.get(0).size()){
                        for (int i = line.length(); i < maze.get(0).size(); i++){
                            row.add("PASS");
                            logger.trace("PASS");
                        }  
                    }
					maze.add(row);
                    logger.trace(System.lineSeparator());
                    line1 = true;
                }
            }
        } catch(Exception e) {
            logger.error("/!\\ An error has occured MAZE /!\\");
        }
        return maze;
    }

    public String getPath(){
        String path = "";
        Options options = new Options();
        options.addOption("p", true, "Input Path File");
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, this.args);
            if (cmd.hasOption("p")){
                path = cmd.getOptionValue("p");
            }
        } catch(Exception e) {
            logger.error("/!\\ An error has occured PATH /!\\");
        }
        return path;
    }
}

