package com.gui;

import com.BaseAction;
import com.GeneratorBoard;
import com.SaperLogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static com.gui.GUIBoard.PADDING;
import static com.gui.GUIBoard.length;

public class GUIAction extends BaseAction implements ActionListener, MouseListener {
    private GUIBoard board;

    /**
     *
     * @param generator generate a bard
     * @param board contains board
     * @param logic
     */
    public GUIAction(GeneratorBoard generator, GUIBoard board, SaperLogic logic) {
        super(generator, board, logic);
        this.board = board;
        this.board.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.initGame();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX()/PADDING;
        int y = e.getY()/PADDING;
        if (x < length && y < length ) {
            if (e.getButton() == 1) {
                board.openCell(x, y);
            } else if (e.getButton() == 3) {
                board.suggestCell(x, y);
            }
        }
        this.board.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
