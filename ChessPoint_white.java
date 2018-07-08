/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 白棋棋子画布
 * @author Administrator
 */
public class ChessPoint_white extends Canvas implements MouseListener{
    ChessPad chesspad=null;
    ChessPoint_white(ChessPad p) {
        setSize(20,20);
        chesspad=p;
        addMouseListener(this);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
    //画棋子
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillOval(0, 0, 20, 20);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouseClicked");
        if(e.getClickCount()>=2){
            chesspad.remove(this);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mousePressed");
        if(e.getModifiers()==InputEvent.BUTTON3_MASK){
            chesspad.remove(this);
            chesspad.棋子颜色=-1;
            chesspad.text_2.setText("请白棋下子");
            chesspad.text_1.setText("");
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouseReleased");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouseEntered");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouseExited");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
    
}
