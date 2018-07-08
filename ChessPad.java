/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 * 定义棋盘面板
 * @author Administrator
 */
public class ChessPad extends Panel implements MouseListener,ActionListener{
    
    Vector v=new Vector(); //所有的每一步走棋信息
    Vector white=new Vector();//白方走棋信息
    Vector black=new Vector();//黑方走棋信息
    boolean b;                //判断是白棋还是黑棋
    int blackcount,whitecount;//统计悔棋步数
    
    
    int x=-1,y=-1,棋子颜色=1;
    Button button=new Button("重新开局");
    TextField text_1=new TextField("请黑棋下子"),text_2=new TextField();
    ChessPad(){
        setSize(440,440);
        setLayout(null);
        setBackground(Color.ORANGE);
        addMouseListener(this);
        add(button);
        button.setBounds(10, 5, 60, 26);
        button.addActionListener(this);
        add(text_1);
        text_1.setBounds(90, 5, 90, 24);
        add(text_2);
        text_2.setBounds(290, 5, 90, 24);
        text_1.setEditable(false);
        text_2.setEditable(false);
        
    }
    //画棋盘
    public void paint(Graphics g){
        //画棋盘的横线
        for(int i=40;i<=380;i=i+20){
            g.drawLine(40, i, 400, i);
        }
        //画边框
        g.drawLine(40, 400, 400, 400);
        //画棋盘纵线
        for(int j=40;j<=380;j=j+20){
            g.drawLine(j, 40, j, 400);
        }
        g.drawLine(400, 40, 400, 400);
        //画棋子的四个控制点
        g.fillOval(97, 97, 6, 6);
        g.fillOval(337, 97, 6, 6);
        g.fillOval(97, 337, 6, 6);
        g.fillOval(337, 337, 6, 6);
        g.fillOval(217, 217, 6, 6);
    }
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouse click");
        //throw new UnsupportedOperationException("mouse click"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    /**
     * 棋盘上鼠标按下事件监听
     */
    public void mousePressed(MouseEvent e) {        
        System.out.println("mouse pressed");
        //e.getModifiers() 返回此事件的修饰符掩码  鼠标左键是  16  鼠标右键是4 鼠标滚轮是8
        //面板的相对坐标位置
        x=(int)e.getX();
        y=(int)e.getY();
        //黑棋棋子对象
        ChessPoint_black black=new ChessPoint_black(this);
        //白棋棋子对象
        ChessPoint_white white=new ChessPoint_white(this);
        
        int a=(x+10)/20,b=(y+10)/20;
        
        //判断鼠标是否落在棋盘内
        if(x/20<2||y/20<2||x/20>19||y/20>19){
            //鼠标落到棋盘外
            System.out.println("chesspad out");
        }else{
            //棋子落在棋盘上
            System.out.println("chesspad in");
            if(棋子颜色==1){
                System.out.println("black");
                this.add(black);
                black.setBounds(a*20-10, b*20-10, 20, 20);
                棋子颜色=棋子颜色*(-1);
                text_2.setText("请白方落子");
                text_1.setText("");
            }else if(棋子颜色==-1){
                System.out.println("white");
                this.add(white);
                //计算落子坐标
                white.setBounds(a*20-10, b*20-10, 20, 20);
                棋子颜色=棋子颜色*(-1);
                text_1.setText("请黑方落子");
                text_2.setText("");
            }
        }
        
        //throw new UnsupportedOperationException("mouse pressed"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouse release");
        //throw new UnsupportedOperationException("mouse release"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouse enter");
        //throw new UnsupportedOperationException("mouse enter"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouse exit");
        //throw new UnsupportedOperationException("mouse exit"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button is press");
        this.removeAll();
        棋子颜色=1;
        add(button);
        button.setBounds(10, 5, 60, 26);
        add(text_1);
        text_1.setBounds(90, 5, 90, 24);
        text_2.setText("");
        text_1.setText("请黑方走");
        add(text_2);
        text_2.setBounds(290,5,90,24);
        //throw new UnsupportedOperationException("mouse event listener api"); //To change body of generated methods, choose Tools | Templates.
    }    
    
    
    //判断棋局输赢的方法
    private void victory(int x, int y, Vector contain) {
        System.out.println("The way to determine the outcome of a five-piece chess game");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int cv=0,ch=0,ci1=0,ci2=0;                
        //判断水平方向
        for(int i=1;i<5;i++){
            if(contain.contains((x+i)+"-"+y))
                ch++;
            else
                break;
        }
        for(int i=1;i<5;i++){
            if(contain.contains((x-i)+"-"+y))
                ch++;
            else
                break;
        }
        
        
        //判断垂直方向
        for(int i=1;i<5;i++){
            if(contain.contains(x+"-"+(y+i)))
                cv++;
            else
                break;
        }
        for(int i=1;i<5;i++){
            if(contain.contains(x+"-"+(y-i)))
                cv++;
            else
                break;
        }
        //判断对角线方向
        for(int i=1;i<5;i++){
            if(contain.contains((x+i)+"-"+(y+i)))
                ci1++;
            else
                break;
        }
        for(int i=1;i<5;i++){
            if(contain.contains((x-i)+"-"+(y-i))){
                ci1++;
            }else{
                break;
            }
        }
        //判断反对角线方向
        for(int i=1;i<5;i++){
            if(contain.contains((x-i)+"-"+(y+i)))
                ci2++;
            else
                break;
        }
        for(int i=1;i<5;i++){
            if(contain.contains((x+i)+"-"+(y-i)))
                ci2++;
            else
                break;
        }
        
        if(ch>=4||cv>=4||ci1>=4||ci2>=4){
            System.out.println(v.size()+"step chess");
            if(v.size()%2==0){
                JOptionPane.showMessageDialog(null, "恭喜你黑棋赢了");
            }else{
                JOptionPane.showMessageDialog(null, "恭喜你白棋赢了");
            }
            
            this.v.clear();
            this.black.clear();
            this.white.clear();
            this.repaint();
            
        }
    }    
    
}
