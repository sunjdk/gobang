/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;


/**
 *
 * @author Administrator
 */
public class Win extends Frame{
   MenuBar menubar;
   Menu menu;
   MenuItem item1,item2;
    Win(String s){
        setTitle(s);
        Toolkit tool=getToolkit();
        Dimension dim=tool.getScreenSize();
        setBounds(0,0,dim.width,dim.height/2);
        menubar=new MenuBar();
        menu=new Menu("文件");

        
        item1=new MenuItem("打开");
        item2=new MenuItem("保存");
        
        menu.add(item1);
        menu.add(item2);
        
        menubar.add(menu);
        setMenuBar(menubar);
        setVisible(true);
    }
    public static void main(String args[]){
        Win w=new Win("菜单窗口");
    }
}
