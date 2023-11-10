package com.company;

import java.util.*;

public class BFS {
    static ArrayList<grid> VisitedGrid;
    ArrayList<grid> Queue_State;
    Map<grid, grid> Path = new HashMap<>();

    public BFS( ) {
        VisitedGrid = new ArrayList<>();
        this.Queue_State = new ArrayList<>();

    }


    public boolean BFS(grid board) {

        Queue_State.add(board);

        while (!Queue_State.isEmpty()) {

            grid Current = Queue_State.remove(0);

            if (!VisitedGrid.contains(Current)) {
                System.out.println();
                Current.PrintGrid();
                System.out.println();
                VisitedGrid.add(Current);
                System.out.println("   ");

            }

            if (Game.checkEndOfGame(Current)) {
                System.out.println();
                System.out.println(" The Final Path is :  ");
                grid.PrintPath(Path, Current);
                System.out.println();

                return true;
            }
            else {


                ArrayList<grid> children = Current.GetNextGrid();

                for (grid grid : children) {
                    Path.put(grid, Current);
                    Queue_State.add(grid);

                    if (!VisitedGrid.contains(grid)) {
                        System.out.println();
                        VisitedGrid.add(grid);
                        System.out.println("   ");
                    }


                    if (Game.checkEndOfGame(Current)) {
                        System.out.println(" The Final Path is :  ");
                        System.out.println();
                        grid.PrintPath(Path, Current);
                        System.out.println();
                        return true;
                    }
                }
            }
        }

        return false;

    }

}
