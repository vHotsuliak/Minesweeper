package com.gui;

import com.Cell;

import javax.swing.*;
import java.awt.*;


public class GUICell extends JPanel implements Cell<Graphics> {
    private boolean bomb;
    private boolean isSuggestBomb;
    private boolean isSuggestEmpty;
    private boolean isOpen;
    private byte numberBombsAround;


    public GUICell(boolean bomb) {
        this.bomb = bomb;
        this.isSuggestBomb = false;
        this.isSuggestEmpty = false;
        this.isOpen = false;
        this.numberBombsAround = 0;
    }

    @Override
    public boolean isBomb() {
        return this.bomb;
    }

    @Override
    public boolean isSuggestBomb() {
        return this.isSuggestBomb;
    }

    @Override
    public boolean isSuggestEmpty() {
        return this.isSuggestEmpty;
    }

    @Override
    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public int getNumberBombAround() {
        return numberBombsAround;
    }

    @Override
    public void suggestBomb() {
        this.isSuggestBomb = !this.isSuggestBomb;
    }

    @Override
    public void suggestEmpty() {
        this.isSuggestEmpty = !this.isSuggestEmpty;
    }

    public void countIncrement() {
        this.numberBombsAround++;
    }

    @Override
    public void open() {
        isOpen = true;
    }


}
