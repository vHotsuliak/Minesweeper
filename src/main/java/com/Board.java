package com;

public interface Board {

    /**
     * Draw board based on the original array of cells.
     * @param cells Array of cells.
     */
    void drawBoard(Cell[][] cells);

    /*/**
     * Draw cell.
     * @param x position by horizontal.
     * @param y position by vertical.
     *//*
    void drawCell(int x, int y);*/

    /**
     * Draw an explosion of all bombs.
     */
    void drawBang();

    /**
     * Draw congratulation if the game is won.
     */
    void drawCongratulation();

    /**
     * Change cell status from closed to open if cell isn't open end do nothing if cell open.
     * @param x position by horizontal(column).
     * @param y position by vertical(row).
     */
    void openCell(int x, int y);
}
