package com.company;

import java.util.Scanner;

class Player {
    Scanner input = new Scanner(System.in);

    grid _grid;
    public Player(grid grid) {

        this._grid=grid;
    }


    void  play(){
        while (!Game.checkEndOfGame(this._grid)){
            move();
        }
    }
    public void MoveToTop(int i,int j){
        int tempX=i;
        String tempValue=
                _grid.Maze[i][j].getValue();

        while(tempX-1>=0 &&
                _grid.Maze[tempX - 1][j].getValue().equals(" ")){
            tempX--;
        }

        _grid.Maze[i][j].setValue(" ");

        _grid.Maze[tempX][j].setValue(tempValue);


    }
    public void MoveToDown(int i,int j){
        int tempX=i;
        String tempValue=
                _grid.Maze[i][j].getValue();
        while(tempX+1<
                _grid.row &&
                _grid.Maze[tempX + 1][j].getValue().equals(" ")){
            tempX++;
        }

        _grid.Maze[i][j].setValue(" ");

        _grid.Maze[tempX][j].setValue(tempValue);


    }
    public void MoveToRight(int i,int j){
        int tempY=j;
        String tempValue= _grid.Maze[i][j].getValue();

        while(tempY+1<
                _grid.column &&
                _grid.Maze[i][tempY + 1].getValue().equals(" ")){
            tempY++;
        }

        _grid.Maze[i][j].setValue(" ");

        _grid.Maze[i][tempY].setValue(tempValue);



    }
    public void MoveToLeft(int i,int j){
        int tempY=j;
        String tempValue=
                _grid.Maze[i][j].getValue();

        while(tempY-1>=0 &&
                _grid.Maze[i][tempY - 1].getValue().equals(" ")){
            tempY--;
        }

        _grid.Maze[i][j].setValue(" ");

        _grid.Maze[i][tempY].setValue(tempValue);


    }
    public void move(){
        System.out.println();
        System.out.println("Enter the x,y for your box :");
        int xOfBox = input.nextInt();
        int yofBox = input.nextInt();
        System.out.println();
        System.out.println("Press T to Top   : ");
        System.out.println("Press D to Down  : ");
        System.out.println("Press R to Right : ");
        System.out.println("Press L to Left  : ");
        System.out.println("Enter the direction of Player :");
        String Direction = input.next();


        switch (Direction) {
            case "t" -> {
                MoveToTop(xOfBox, yofBox);
                System.out.println();
                _grid.PrintGrid();
                System.out.println();
            }
            case "d" -> {
                MoveToDown(xOfBox, yofBox);
                System.out.println();
                _grid.PrintGrid();
                System.out.println();
            }
            case "r" -> {
                MoveToRight(xOfBox, yofBox);
                System.out.println();
                _grid.PrintGrid();
                System.out.println();
            }
            case "l" -> {
                MoveToLeft(xOfBox, yofBox);
                System.out.println();
                _grid.PrintGrid();
                System.out.println();
            }
            default -> System.out.println("Invalid direction");
        }

    }
}
