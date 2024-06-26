import java.awt.*;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
public class MapReader {
    private Player p;
    private TileLoader[][] map;
    private int rows;
    private int cols;
    public Player getPlayer(){
        return p;
    }
    public void move(String direction){
        if (direction.equals("E")) {
            if(p.getX()+8<= 1255){
                p.setTemp(p.getFaceRight());
                p.setX(p.getX()+8);
            }
        }
        if (direction.equals("W")) {
            if(p.getX() - 8 > 55){
                p.setTemp(p.getFaceLeft());
                p.setX(p.getX()-8);
            }
        }
    }
    public MapReader(String name){
        generateWorld(name);
    }
    private void generateWorld(String name) {
        int[][] mazeData = getWorld("Maps/" + name);
        map = new TileLoader[rows][cols];

        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) {
                TileLoader t = new TileLoader(mazeData[r][c], r, c);
                map[r][c] = t;
            }
        }
    }
    public int[][] getWorld(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }

        ArrayList<String> fileData = new ArrayList<String>();
        while (s.hasNextLine())
            fileData.add(s.nextLine());
        rows = fileData.size();
        cols = fileData.get(0).length();

        int[][] worldData = new int[rows][cols];

        for (int i = 0; i < fileData.size(); i++) {
            String d = fileData.get(i);
            for (int j = 0; j < d.length(); j++) {
                if (d.charAt(j) == '#') {
                    worldData[i][j] = 0;
                }
                if (d.charAt(j) == '.') {
                    worldData[i][j] = 1;
                }
                if (d.charAt(j) == '^') {
                    worldData[i][j] = 2;
                }
                if (d.charAt(j) == '*') {
                    worldData[i][j] = 3;
                }
                this.p = new Player();
            }
        }
        return worldData;
    }
    public Player getP() {
        return p;
    }

    public TileLoader[][] getMap() {
        return map;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}

