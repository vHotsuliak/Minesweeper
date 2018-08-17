package com.logics;

import com.Cell;
import com.SaperLogic;

public class Easy implements SaperLogic {
    private Cell[][] cells;

    @Override
    public void loadBoard(Cell[][] cells) {
        this.cells = cells;
    }

    @Override
    public boolean shouldBang(int x, int y) {
        final Cell selected = this.cells[x][y];
        return selected.isBomb() && !selected.isSuggestBomb();
    }

    @Override
    public boolean finish() {
        boolean finish = false;
        for (Cell[] row: cells) {
            for (Cell cell: row)
                finish = ((cell.isSuggestBomb() && cell.isBomb()) ||
                          (cell.isSuggestEmpty() && !cell.isBomb()));
        }
        return finish;
    }

    @Override
    public void suggest(int x, int y, boolean bomb) {
        if (bomb) {
            this.cells[x][y].suggestBomb();
        } else {
            this.cells[x][y].suggestEmpty();
        }
    }
}
