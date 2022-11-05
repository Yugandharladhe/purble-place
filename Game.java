import java.awt.*;
import java.awt.event.*;

public class Game extends Frame {
    Label l1,l2;
    public Game()
    {
        setLayout(null);
        GamePanel p1=new GamePanel();
        p1.setLocation(60,80);
        p1.setSize(400,400);
        add(p1);

        //l1=new Label("Player 1 Score:- ");
        //l1.setLocation(600,300);
        //l1.setSize(110,30);
        //l2=new Label("Player 2 Score:- ");
        //l2.setLocation(600,500);
        //l2.setSize(110,30);
        //add(l1);
        //add(l2);
    }

    public static void main(String a[])
    {
        Game g1=new Game();
        g1.setVisible(true);
        g1.setSize(1000,1000);
    }
    
}

class GamePanel extends Panel{
    Button arr[];

    class Inner1 extends MouseAdapter{
        Button prev;
        Frame f1=new Frame("YOU WON");
        int flag=1;
        int count=0;
        public void mouseClicked(MouseEvent me)
        {
            Button b1=(Button)me.getComponent();
            if(flag==1)
            {
                prev=b1;
                b1.setForeground(Color.red);
                b1.setEnabled(false);
                flag=0;
            }
            else if(b1.getLabel()==prev.getLabel()){
                prev.setEnabled(false);
                b1.setEnabled(false);
                prev=null;
                flag=1;
                count++;
            }
            else
            {   b1.setForeground(Color.red);
                prev.setEnabled(true);
                try{
                    Thread.sleep(1500);
                }
                catch(Exception e)
                {}
                prev.setForeground(Color.white);
                b1.setEnabled(true);
                b1.setForeground(Color.white);
                prev=null;
                
                
                flag=1;
            }

            if(count==8)
            {
                f1.setVisible(true);
                f1.setLayout(null);
                f1.setSize(100,100);
                f1.add(new Label("YOU WON"));
            }
        }
    }
    GamePanel()
    {
        setLayout(new GridLayout(4,4));
        arr=new Button[16];
        
        
        Inner1 ev=new Inner1();
        for(int i=0;i<=15;i++)
        {
            arr[i]=new Button();
            arr[i].setForeground(Color.white);
            arr[i].setBackground(Color.white);
            add(arr[i]);
            arr[i].setFocusable(false);
            arr[i].addMouseListener(ev);
        }
        arr[0].setLabel("1");
        arr[1].setLabel("5");
        arr[2].setLabel("3");
        arr[3].setLabel("4");
        arr[4].setLabel("7");
        arr[5].setLabel("1");
        arr[6].setLabel("2");
        arr[7].setLabel("6");
        arr[8].setLabel("2");
        arr[9].setLabel("7");
        arr[10].setLabel("4");
        arr[11].setLabel("3");
        arr[12].setLabel("5");
        arr[13].setLabel("8");
        arr[14].setLabel("8");
        arr[15].setLabel("6");
    
}
}
