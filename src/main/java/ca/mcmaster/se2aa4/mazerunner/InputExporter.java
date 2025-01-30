package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;
import java.util.*;

public class InputExporter{
	private ArrayList<ArrayList<String>> maze = new ArrayList<>();
	private String path = "No Input";

	private static final Logger logger = LogManager.getLogger(Maze.class);
	//Stores the Maze Attribute as a 2d Array List. Will also store a given path from arguments.
	//Still have to add -p argument to command line reader
	public InputExporter(String[] args){
        Options options = new Options();

        options.addOption("i", true, "Input Maze File");
        options.addOption("p", true, "Input Path String");

        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse(options, args);
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
            if (cmd.hasOption("p")){
                this.path = cmd.getOptionValue("p");
            }
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
	}
	public ArrayList<ArrayList<String>> getMaze(){
		return this.maze;
	}

	public String getPath(){
		return this.path;
	}
}

