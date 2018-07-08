/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Administrator
 */
public class Chess extends Frame{

    /**
     * @param args the command line arguments
     */
    //定义棋盘
    ChessPad chesspad=new ChessPad();
    //棋盘初始化
    Chess(){
        super("五子棋");
        setVisible(true);
        setLayout(null);
        Label label=new Label("单击左键下棋子，双击吃棋子，用右键单击棋子悔棋",Label.CENTER);
        add(label);label.setBounds(70, 55, 440, 26);
        label.setBackground(Color.ORANGE);
        add(chesspad);
        chesspad.setBounds(70, 90, 440, 440);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        pack();setSize(600,550);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("init successful");
        //Chess chess=new Chess();
        wuziqi2 wzq=new wuziqi2();
    }
    
}
