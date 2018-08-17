package com.gui;

import com.Board;
import com.Cell;

import javax.swing.*;
import java.awt.*;

public class GUIBoard extends JPanel implements Board {
    public static int PADDING = 50;

    /**
     * Cells for board.
     */
    private Cell[][] cells;
    static int length;

    /**
     * Draw all components for every cell.
     * @param graphics contains a graphic for board.
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        PADDING = this.getHeight() < this.getWidth() ? this.getHeight()/length : this.getWidth()/length;
        if (this.cells != null) {
            for (int x = 0; x != cells.length; x++) {
                for (int y = 0; y != cells[0].length; y++) {
                    graphics.drawImage(getImage(x, y), x*PADDING+1, y*PADDING+1, PADDING-1, PADDING-1, this);
                    graphics.drawRect(x * PADDING, y * PADDING, PADDING, PADDING);
                }
            }
        }
    }

    /**
     * Draws a board with cells.
     * @param cells Array of cells.
     */
    @Override
    public void drawBoard(Cell[][] cells) {
        this.cells = cells;
        length = cells[0].length;
        this.repaint();

    }


    /**
     * End of the game, was opened cell with bomb.
     */
    @Override
    public void drawBang() {
        for (int x = 0; x != cells.length; x++) {
            for (int y = 0; y != cells[0].length; y++) {
                this.cells[x][y].open();
            }
        }
        this.repaint();
    }


    @Override
    public void drawCongratulation() {
    }

    /**
     * Opening cell by coordinates (x; y). If cell is bomb then draw bang.
     * @param x position by horizontal(column).
     * @param y position by vertical(row).
     */
    @Override
    public void openCell(int x, int y) {
        if(!this.cells[x][y].isOpen() && !this.cells[x][y].isSuggestBomb()) {
            if(this.cells[x][y].getNumberBombAround() != 0)
                this.cells[x][y].open();
            else
              openEmptyCell(x,y);
        }
        if (this.cells[x][y].isBomb() && !this.cells[x][y].isSuggestBomb()) {
            drawBang();
        }
    }

    /**
     * Open empty cell around cell with coordinates (x; y). Method has recursion for every empty cells around this cell.
     * @param x position by horizontal(column).
     * @param y position by vertical(row).
     */
    private void openEmptyCell(int x, int y) {
        if (!this.cells[x][y].isOpen()) {
            this.cells[x][y].open();
            for (int i = x - 1, end1 = x + 2; i < end1; i++) {
                if (i >= 0 && i < length) {
                    for (int j = y - 1, end2 = y + 2; j < end2; j++) {
                        if (j >= 0 && j < length) {
                            if (this.cells[i][j].getNumberBombAround() == 0)
                                openEmptyCell(i, j);
                            else
                                openCell(i, j);
                        }
                    }
                }
            }
        }
    }

    /**
     * Change suggest status for cell(x,y):
     *  <pre>-if isn't suggest to suggest bomb;</pre>
     *  <pre>-if is suggest bomb to suggest empty;</pre>
     *  <pre>-if is suggest empty then nothing suggest.</pre>
     * @param x position by horizontal(column).
     * @param y position by vertical(row).
     */
    public void suggestCell(int x, int y) {
        if (!this.cells[x][y].isSuggestBomb() && !this.cells[x][y].isSuggestEmpty())
            this.cells[x][y].suggestBomb();
        else {
            if (!this.cells[x][y].isSuggestEmpty())
                this.cells[x][y].suggestBomb();
            this.cells[x][y].suggestEmpty();
        }
    }

    /**
     * Return image for this cell(x,y).
     * Choose image using cell statuses.
     * @param x position by horizontal(column).
     * @param y position by vertical(row).
     * @return image fot cell(x,y).
     */
    public Image getImage(int x, int y) {
        Image image;
        if (cells[x][y].isOpen())
            if(!cells[x][y].isBomb())
                image =  Toolkit.getDefaultToolkit().getImage("E:\\Java\\workspaceIntel\\Minesweeper\\image\\" + cells[x][y].getNumberBombAround() + ".png");
            else
                image =  Toolkit.getDefaultToolkit().getImage("E:\\Java\\workspaceIntel\\Minesweeper\\image\\explosion.png");
        else if (cells[x][y].isSuggestBomb())
            image =  Toolkit.getDefaultToolkit().getImage("E:\\Java\\workspaceIntel\\Minesweeper\\image\\suggestBomb.png");
        else if (cells[x][y].isSuggestEmpty())
            image =  Toolkit.getDefaultToolkit().getImage("E:\\Java\\workspaceIntel\\Minesweeper\\image\\suggestEmpty.png");
        else
            image =  Toolkit.getDefaultToolkit().getImage("E:\\Java\\workspaceIntel\\Minesweeper\\image\\square.png");
        return image;
    }
}

