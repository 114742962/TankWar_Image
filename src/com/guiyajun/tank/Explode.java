package com.guiyajun.tank;

import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @ProjectName:  [TankWar] 
 * @Package:      [com.guiyajun.tank.Explode.java]  
 * @ClassName:    [Explode]   
 * @Description:  [实现了爆炸效果]   
 * @Author:       [Guiyajun]   
 * @CreateDate:   [2019年10月22日 下午4:10:30]   
 * @UpdateUser:   [Guiyajun]   
 * @UpdateDate:   [2019年10月22日 下午4:10:30]   
 * @UpdateRemark: [说明本次修改内容]  
 * @Version:      [v1.0]
 */
public class Explode {
    
    /** 客户端实例变量用于管理元素 */
    public TankWarClient twc = null;
    /** 定义爆炸效果直径数组  */
    private int[] diameter = {5, 10, 17, 25, 30, 35, 40, 45, 50, 55, 60};
    /** 定义爆炸直径数组的初始下标值  */
    private int step = 0;
    /** 爆炸效果的x坐标  */
    private int x;
    /** 爆炸效果的y坐标  */
    private int y;
    /** 爆炸效果是否存活  */
    private boolean aliveOfExplode = true;
    /** 定义爆炸效果图片数组  */
    private static Image[] images = new Image[11];
    /** 图片资源初始化  */
    static {
        try {
            images[0] = ImageIO.read(Explode.class.getClassLoader().getResource("images/0.gif"));
            images[1] = ImageIO.read(Explode.class.getClassLoader().getResource("images/1.gif"));
            images[2] = ImageIO.read(Explode.class.getClassLoader().getResource("images/2.gif"));
            images[3] = ImageIO.read(Explode.class.getClassLoader().getResource("images/3.gif"));
            images[4] = ImageIO.read(Explode.class.getClassLoader().getResource("images/4.gif"));
            images[5] = ImageIO.read(Explode.class.getClassLoader().getResource("images/5.gif"));
            images[6] = ImageIO.read(Explode.class.getClassLoader().getResource("images/6.gif"));
            images[7] = ImageIO.read(Explode.class.getClassLoader().getResource("images/7.gif"));
            images[8] = ImageIO.read(Explode.class.getClassLoader().getResource("images/8.gif"));
            images[9] = ImageIO.read(Explode.class.getClassLoader().getResource("images/9.gif"));
            images[10] = ImageIO.read(Explode.class.getClassLoader().getResource("images/10.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    /**
          * 创建一个新的实例 Explode.
    * @param x  x坐标
    * @param y  y坐标
    * @param twc    客户端实例
     */
    public Explode(int x, int y, TankWarClient twc) {
        this.x = x;
        this.y = y;
        this.twc = twc;
    }
    
    /**
    * @Title: draw
    * @Description: (爆炸效果的绘制方法)
    * @param @param g    参数，可以理解为绘画用的笔 
    * @return void    返回类型
    * @throws
     */
    public void draw(Graphics g) {
        
        if (!aliveOfExplode) {
            return;
        }
        
        if (step == diameter.length) {
            aliveOfExplode = false;
            step = 0;
            return;
        }
        
        // 根据被击中坦克的中心点画出爆炸效果
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.drawImage(images[step], x + Tank.TANK_WIDTH/2 - diameter[step]/2,
            y + Tank.TANK_WIDTH/2 - diameter[step]/2, null);
        g.setColor(c);
        
        /*
                  每画一次，下标递增1，为了取下一步的爆炸直径
        */
        step ++;
    }
    
    /**
    * @Title: isAliveOfExplode
    * @Description: (获取爆炸效果的存活状态)
    * @param @return    参数 
    * @return boolean    返回类型
    * @throws
     */
    public boolean isAliveOfExplode() {
        return aliveOfExplode;
    }
    
    /**
    * @Title: setAliveOfExplode
    * @Description: (设置爆炸效果的存活状态)
    * @param @param aliveOfExplode    参数 
    * @return void    返回类型
    * @throws
     */
    public void setAliveOfExplode(boolean aliveOfExplode) {
        this.aliveOfExplode = aliveOfExplode;
    }
}
