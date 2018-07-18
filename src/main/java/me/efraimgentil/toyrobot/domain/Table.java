package me.efraimgentil.toyrobot.domain;

public class Table {

    public static int DEFAULT_TABLE_SIZE = 5;

    private int tableSize;

    public Table(){
        //default size
        this.tableSize = DEFAULT_TABLE_SIZE;
    }

    public Table(int tableSize) {
        this.tableSize = tableSize;
    }

    public int getTableSize() {
        return tableSize;
    }

    public boolean willFall(int x , int y){
        int boundaryReference = (tableSize-1);
        return (x < 0 || y < 0) || (x > boundaryReference || y > boundaryReference);
    }
}
