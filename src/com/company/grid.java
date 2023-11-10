package com.company;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class grid {
    cell[][] Maze;
    int level;
    int row;
    int column;
    ArrayList<cell> goals=new ArrayList<cell>();

    Scanner input = new Scanner(System.in);
    public grid(int level) {

        this.level=level;
        switch (level) {
            case 2:
                row=2;
                column=5;
                this.Maze = new cell[row][column];
                // initilize
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j <column ; j++) {
                        this.Maze[i][j] = new cell(i,j," ",false); // Create a new cell object

                    }

                }
                // set walls
                this.Maze[1][0].setValue("X");
                this.Maze[1][1].setValue("X");
                this.Maze[1][3].setValue("X");
                this.Maze[1][4].setValue("X");
                // set default value
                this.Maze[0][0].setValue("4");
                this.Maze[0][4].setValue("4");
                this.Maze[1][2].setValue("=");
                // set Goals
                this.Maze[0][1].setGoal(true);
                this.Maze[0][2].setGoal(true);
                this.Maze[0][3].setGoal(true);
                goals.add(Maze[0][1]);
                goals.add(Maze[0][2]);
                goals.add(Maze[0][3]);


                break;
            case 4:
                // Code to be executed if expression is equal to value2
                break;
            // Add more cases as needed
            default:
                // Code to be executed if expression doesn't match any case
        }



    }
    /* Copy Constructor */
    public grid(grid grid) {

        this.Maze = new cell[grid.row][grid.column];
        this.row = grid.row;
        this.column = grid.column;
        for (int i = 0; i < grid.row; i++) {
            for (int j = 0; j < grid.column; j++) {
                this.Maze[i][j] =new cell(grid.Maze[i][j]);
            }
        }
        for (int i = 0; i <grid.goals.size() ; i++) {
                this.goals.add(new cell(grid.goals.get(i)));
        }




    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    ArrayList<cell> getPositionOfBoxes(grid temp){
        ArrayList<cell> boxes=new ArrayList<cell>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (temp.Maze[i][j].getValue()!=" " && temp.Maze[i][j].getValue()!="X")
                    boxes.add(temp.Maze[i][j]);
            }
        }
        return boxes;
    }
    public ArrayList<grid> GetNextGrid() {
        ArrayList<grid> list = new ArrayList<>();

        Player p;

        grid right = new grid(this);
        p = new Player(right);
        ArrayList<cell> boxes = getPositionOfBoxes(right);

        right.PrintGrid();
        for (int i = 0; i <boxes.size() ; i++) {
            p.MoveToRight(boxes.get(i).row,boxes.get(i).column);

           p._grid.PrintGrid();

            if (!DFS.VisitedGrid.contains(p._grid)  && !BFS.VisitedGrid.contains(p._grid))
                list.add(p._grid);
            right = new grid(this);
            p = new Player(right);
        }

   grid down = new grid(this);
        p=new Player(down);
        ArrayList<cell> boxesDown = getPositionOfBoxes(down);
        for (int i = 0; i < boxesDown.size(); i++) {


            p.MoveToDown(boxesDown.get(i).row,boxesDown.get(i).column);
            if (!DFS.VisitedGrid.contains(p._grid)  && !BFS.VisitedGrid.contains(p._grid))
                list.add(p._grid);

            down = new grid(this);
            p=new Player(down);
        }




        grid left = new grid(this);

        p=new Player(left);
        ArrayList<cell> boxesLeft = getPositionOfBoxes(left);
        for (int i = 0; i < boxesLeft.size(); i++) {


            p.MoveToLeft(boxesLeft.get(i).row,boxesLeft.get(i).column);



            if (!DFS.VisitedGrid.contains(p._grid) && !BFS.VisitedGrid.contains(p._grid))
                list.add(p._grid);

            left = new grid(this);

            p=new Player(left);
        }



        grid up = new grid(this);
        p=new Player(up);
        ArrayList<cell> boxesUP = getPositionOfBoxes(up);
        for (int i = 0; i < boxesUP.size(); i++) {


            p.MoveToTop(boxesUP.get(i).row,boxesUP.get(i).column);

            if (!DFS.VisitedGrid.contains(p._grid) && !BFS.VisitedGrid.contains(p._grid))
                list.add(p._grid);

            up = new grid(this);
            p=new Player(up);
        }


        System.out.println("__________________________________________________");
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            list.get(i).PrintGrid();
            System.out.println("__________________________________________________");
        }
        return list;
    }



    public static void PrintPath(Map<grid, grid> track, grid finalNode) {
        if (track.get(finalNode) == null) {
            return;
        } else {
            PrintPath(track, track.get(finalNode));

           finalNode.PrintGrid();
        }

    }



    public void PrintGrid() {
        System.out.print(" __ __ __ __ __ __ __ __ __ __ _ ");
        for (int i = 0; i < row; i++) {
            System.out.println();
            for (int j = 0; j < column; j++) {
                if (j == 0) {
                    System.out.print("|__" +this.Maze[i][j].getValue() + " _|__");
                } else if (j == column - 1)
                    System.out.print(this.Maze[i][j].getValue() + "__|");
                else
                    System.out.print(this.Maze[i][j].getValue() + "__|__");
            }
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof grid) {
            grid input = (grid) obj;
            for (int i = 0; i < input.row; i++) {
                for (int j = 0; j < input.column; j++) {
                    if (!this.Maze[i][j].getValue().equals(input.Maze[i][j].getValue()))
                        return false;
                }
            }
            return true;
        }
        return false;

    }
}

