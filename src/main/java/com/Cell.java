package com;

public interface Cell<T> {

    boolean isBomb();

    boolean isSuggestBomb();

    boolean isSuggestEmpty();

    void suggestBomb();

    void suggestEmpty();

    /*void draw(T paint, boolean real);*/

    void open();

    boolean isOpen();

    int getNumberBombAround();
}
