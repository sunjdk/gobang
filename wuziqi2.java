/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class wuziqi2 extends JFrame implements MouseListener{
    
    Vector v=new Vector(); //所有的每一步走棋信息
    Vector white=new Vector();//白方走棋信息
    Vector black=new Vector();//黑方走棋信息
    boolean b;                //判断是白棋还是黑棋
    int blackcount,whitecount;//统计悔棋步数
    int w=25;                 //间距大小，是双数
    int px=100,py=100;
    
    int pxw=(px+w),pyw=(py+w);
    int width=w*16,height=w*16;
    
    int vline=(width+px);       //垂直线的长度
    int hline=(height+py);      //水平线的长度
    
    
    
    public wuziqi2(){
        super("五子棋");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container con=this.getContentPane();
        con.setLayout(new BorderLayout());
        this.addMouseListener(this);
        this.setSize(600,600);
        this.setBackground(Color.orange);
        this.setVisible(true);
    }
    
    public void paint(Graphics g){
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.BLACK);
        //画棋盘边框
        g.drawRect(px, py, width, height);
        g.drawString("五子棋小游戏，右击可以悔棋，欢迎使用", 180, 70);
        
        //画棋盘内线
        for(int i=0;i<15;i++){
            g.drawLine(125+i*25, 100, 125+i*25, 500);
            g.drawLine(100, 125+i*25, 500, 125+i*25);
        }
        for(int x=0;x<v.size();x++){
            //get(int index) 返回向量中指定位置的元素
            String str=(String)v.get(x);
            String tmp[]=str.split("-");
            int a=Integer.parseInt(tmp[0]);
            int b=Integer.parseInt(tmp[1]);
            
            a=a*w+px;
            b=b*w+py;
            
            if(x%2==0){
                g.setColor(Color.WHITE);
            }else{
                g.setColor(Color.BLACK);
            }
            g.fillArc(a-w/2, b-w/2, w, w, 0, 360);
        }
    }
    
    
    
    @Override
    public void mouseClicked(MouseEvent e){
        System.out.println("mouseClicked");       
        //鼠标左键单击下棋
        if(e.getButton()==e.BUTTON1){
            
            //鼠标坐标和棋盘坐标相互转换
            int x=e.getX(),y=e.getY();
            
            x=(x-x%w)+(x%w>w/2?w:0);
            y=(y-y%w)+(y%w>w/2?w:0);
                    
            x=(x-px)/w;
            y=(y-py)/w;            
            
            if(x>=0&&y>=0&&x<=16&&y<=16){//鼠标落在了棋盘内
                if(v.contains(x+"-"+y)){//落子的位置已经被棋子占用，该处已经有棋子了
                    System.out.println("There are already pieces");
                }else{
                    v.add(x+"-"+y);//把棋子坐标用x-y的方式添加到向量中
                    this.repaint();//重绘棋盘
                    if(v.size()%2==0){//黑子
                        black.add(x+"-"+y);
                        this.victory(x, y, black);
                        System.out.println("black chess");
                    }else{//白子
                        white.add(x+"-"+y);
                        this.victory(x, y, white);
                        System.out.println("white chess");
                    }
                    System.out.println(e.getX()+"-"+e.getY());
                }
            }else{//鼠标落在棋盘外
                System.out.println(e.getX()+"-"+e.getY()+"|"+x+"-"+y+"\t beyond border");
            }
        }
        //鼠标右键单击悔棋
        if(e.getButton()==e.BUTTON3){
            System.out.println("Mouse right - click regret");
            if(v.isEmpty()){//棋盘为空无棋可悔
                
            }else{
                if(v.size()%2==0){//黑棋悔棋
                    blackcount++;
                    if(blackcount>3){//黑棋悔棋超过三步，不能再悔
                        JOptionPane.showMessageDialog(this, "Black has repented three moves");
                    }else{//开始悔棋逻辑，移除最后一步下的棋子，删除向量中的最后一个元素
                        v.remove(v.lastElement());
                        this.repaint();
                    }
                }else{//白棋悔棋
                    whitecount++;
                    if(whitecount>3){
                        JOptionPane.showMessageDialog(this, "White has repented three moves");
                    }else{
                        v.remove(v.lastElement());
                        this.repaint();
                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("mousePressed");
    }
    

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("mouseReleased");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("mouseEntered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("mouseExited");
    }

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
            System.out.println(contain.toString());
        }
        for(int i=1;i<5;i++){
            if(contain.contains((x-i)+"-"+y))
                ch++;
            else
                break;
            System.out.println(contain.toString());
        }
        
        
        //判断垂直方向
        for(int i=1;i<5;i++){
            if(contain.contains(x+"-"+(y+i)))
                cv++;
            else
                break;
            System.out.println(contain.toString());
        }
        for(int i=1;i<5;i++){
            if(contain.contains(x+"-"+(y-i)))
                cv++;
            else
                break;
            System.out.println(contain.toString());
        }
        //判断对角线方向
        for(int i=1;i<5;i++){
            if(contain.contains((x+i)+"-"+(y+i)))
                ci1++;
            else
                break;
            System.out.println(contain.toString());
        }
        for(int i=1;i<5;i++){
            if(contain.contains((x-i)+"-"+(y-i))){
                ci1++;
            }else{
                break;
            }
            System.out.println(contain.toString());
        }
        //判断反对角线方向
        for(int i=1;i<5;i++){
            if(contain.contains((x-i)+"-"+(y+i)))
                ci2++;
            else
                break;
            System.out.println(contain.toString());
        }
        for(int i=1;i<5;i++){
            if(contain.contains((x+i)+"-"+(y-i)))
                ci2++;
            else
                break;
            System.out.println(contain.toString());
        }
        
        if(ch>=4||cv>=4||ci1>=4||ci2>=4){
            System.out.println(v.size()+"step chess");
            if(v.size()%2==0){
                System.out.println("Vectory struct"+v.toString());
                JOptionPane.showMessageDialog(null, "恭喜你黑棋赢了");                
            }else{
                System.out.println("Vectory struct"+v.toString());
                JOptionPane.showMessageDialog(null, "恭喜你白棋赢了");                
            }
            
            
            
            this.v.clear();
            this.black.clear();
            this.white.clear();
            this.repaint();
            
        }
    }    
}
