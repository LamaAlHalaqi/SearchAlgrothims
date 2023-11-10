package com.company;
import java.util.*;

public class DFS {
    static ArrayList<grid> VisitedGrid;
    Stack<grid> Stack_State;
    Map<grid, grid> Path = new HashMap<>();

    public DFS( ) {
        VisitedGrid = new ArrayList<>();
        this.Stack_State = new Stack<>();

    }


    public boolean Dfs(grid board) {

        Stack_State.push(board);
      
        while (!Stack_State.isEmpty()) {

            grid Current = Stack_State.pop();

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
                    Stack_State.push(grid);

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