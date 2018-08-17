package com.gui;

import com.Cell;
import com.GeneratorBoard;

import java.util.Random;

public class GUIGeneratorBoard implements GeneratorBoard {
    private GUICell[][] cells;
    private byte length;

    public GUIGeneratorBoard(byte length) {
        this.length = length;
        cells = new GUICell[length][length];
    }

    @Override
    public Cell[][] generate() {
        generateCellsEmpty();
        generateBomb();
        return cells;
    }

    private void generateCellsEmpty() {
        for (int i = 0; i < this.length; i++)
            for (int j = 0; j < this.length; j++)
                this.cells[i][j] = new GUICell(false);
    }

    private void generateBomb() {
        int i = 0, bomb = (int) (length*length*0.15);
        while (i < bomb) {
            Random random = new Random();
            short x = (short) (random.nextInt(1000) % length);
            short y = (short) (random.nextInt(1000) % length);
            if (!cells[x][y].isBomb()) {
                cells[x][y] = new GUICell(true);
                i++;
                increment(x, y);
            }
        }
    }

    private void increment(short x, short y) {
        for (int i = x - 1, e = x + 2; i < e; i++)
            if (i >= 0 && i < length)
                for (int j = y - 1, exit = y + 2; j < exit; j++)
                    if (j >= 0 && j < length && !cells[i][j].isBomb())
                        cells[i][j].countIncrement();
    }
}
