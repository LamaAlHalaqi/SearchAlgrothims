package com.company;

import java.util.Scanner;

public class Game {
   static grid _grid;
   Player player;
   DFS dfs;
   BFS bfs;

    public Game() {
        Scanner input = new Scanner(System.in);
        int intValue = input.nextInt();
        this._grid=new grid(intValue);
        _grid.PrintGrid();
       // player=new Player(_grid);
   dfs=new DFS();
        bfs=new BFS();
        System.out.println("if yoy want Dfs Choose 1 else To Use BFS choose 2 :");
        int intValue1 = input.nextInt();
        Boolean x;
        if(intValue1==1)
      x= dfs.Dfs(_grid);
        if(intValue1==2)
        x= bfs.BFS(_grid);
        else {
            player = new Player(_grid);
            while (!checkEndOfGame(player._grid)){
                player.play();
            }
            x=checkEndOfGame(player._grid);
        }
        System.out.println(x);
    }


    public static boolean evaluateExpression(String expression) {
        String[] parts = expression.split("=");

        if (parts.length == 2) {
            String[] operands = parts[0].split("[+\\*_]");//4
            int expected = Integer.parseInt(parts[1]);//4
            if (operands.length == 1) {
                int operand1 = Integer.parseInt(operands[0]);
                return operand1 == expected;
            }
            else if (operands.length == 2) {
                int operand1 = Integer.parseInt(operands[0]);
                int operand2 = Integer.parseInt(operands[1]);
                char operator = expression.charAt(operands[0].length());

                int result = 0;

                switch (operator) {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '_':
                        result = operand1 - operand2;
                        break;
                }

                return result == expected;
            }
        }

        return false;
    }
    public static boolean checkEndOfGame(grid _grid){

        for (int i = 0; i < _grid.row ; i++) {
            for (int j = 0; j < _grid.column; j++) {
                if(_grid.Maze[i][j].getGoal() && _grid.Maze[i][j].getValue() == " ")
                    return  false;

            }

        }
        String expression="";
        for (int i = 0; i <_grid.goals.size() ; i++) {
            expression+=_grid.Maze[_grid.goals.get(i).row][_grid.goals.get(i).column].getValue();
        }
        System.out.println(expression);
        System.out.println(evaluateExpression(expression));
        return evaluateExpression(expression);
    }

}
