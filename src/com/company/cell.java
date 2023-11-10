package com.company;

public class cell {
    int row;
    int column;
    String value;
    boolean goal;

    public cell(int row, int column, String value,boolean goal) {
        this.row = row;
        this.column = column;
        this.value = value;
        this.goal = goal;
    }

    public cell(cell c) {
        this.row = c.row;
        this.column = c.column;
        this.value = c.value;
        this.goal = c.goal;
    }
    public Boolean getGoal() {
        return goal;
    }

    public void setGoal(Boolean goal) {
        this.goal = goal;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
