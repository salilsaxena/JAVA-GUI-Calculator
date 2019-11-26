import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Salil Saxena
 */
public class calc extends JFrame implements ActionListener{
        JTextField t = new JTextField("text");
        JPanel p1 = new JPanel();
        Font f = new Font("Serif",1,36);
        JPanel p = new JPanel(new GridLayout(4,3));
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton eq = new JButton("=");
        JButton addd = new JButton("+");
        JButton mul = new JButton("*");
        JButton min = new JButton("-");
        JButton div = new JButton("/");
        JButton del =  new JButton("del");
        calc() {
          t.setFont(f);
          b1.setFont(f);
          b2.setFont(f);
          b3.setFont(f);
          b4.setFont(f);
          b5.setFont(f);
          b6.setFont(f);
          b7.setFont(f);
          b8.setFont(f);
          b9.setFont(f);
          div.setFont(f);
          del.setFont(f);
        t.setEditable(false);
            b1.addActionListener(this);
            b2.addActionListener(this);
            b3.addActionListener(this);
            b4.addActionListener(this);
            b5.addActionListener(this);
            b6.addActionListener(this);
            b7.addActionListener(this);
            b8.addActionListener(this);
            b9.addActionListener(this);
            eq.addActionListener(this);
            addd.addActionListener(this);
            mul.addActionListener(this);
            div.addActionListener(this);
            min.addActionListener(this);
            del.addActionListener(this);
        JPanel p2 = new JPanel(new GridLayout(2,1));
        System.out.println(b1.getText());
        eq.setFont(f);
        addd.setFont(f);
        mul.setFont(f);
        min.setFont(f);

        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(eq);
        p.add(mul);
        p.add(min);
        p.add(div);
        p.add(addd);
        p.add(del);
        p2.add(t);

        p2.add(p);
        add(p1);
        add(p2);
        setLayout(new GridLayout(1,2));
        setVisible(true);
        setDefaultCloseOperation(3);
        setSize(300, 400);
        }
        String disp="";
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand()=="=")
                    {
                        int c = check(disp);
                        if(c==0)
                        {
                            System.out.println("ok");

                            t.setText(comp(disp)+"");
                            disp ="";
                        }
                        else
                        {
                            dispose();
                            throw new UnsupportedOperationException("Illegal move");
                       }
                    }
            else if(e.getActionCommand()=="del")
            {
              System.out.println("done");
              String x ="";
              for(int i=0;i<disp.length()-1;i++)
              {
                  x+=disp.charAt(i);
              }
              t.setText(x);
              disp = x;
            }
            else
            {
                disp+=e.getActionCommand();
                t.setText(disp);
                    }
                  //To change body of generated methods, choose Tools | Templates.
        }
        public int comp(String a)
                {
                    String[] sy = {"\\+","/","\\*","-"};
//                    char p;
                    String[] b;
                    if(a.indexOf(sy[0].charAt(1))>0)
                    {
//                        p = '+';
                        b = a.split("\\+");
                        return Integer.valueOf(b[0]) + Integer.valueOf(b[1]);

                    }
                    else if(a.indexOf(sy[1].charAt(0))>0)
                    {
//                        p = '+';
                        b = a.split("/");
                        return Integer.valueOf(b[0]) / Integer.valueOf(b[1]);
                    }
                    else if(a.indexOf(sy[2].charAt(1))>0)
                    {
//                        p = '+';
                        b = a.split("\\*");
                        return Integer.valueOf(b[0]) * Integer.valueOf(b[1]);

                    }
                    else if(a.indexOf(sy[3].charAt(0))>0)
                    {
//                        p = '+';
                        b = a.split("-");
                        return Integer.valueOf(b[0]) - Integer.valueOf(b[1]);

                    }
                    else
                        return 0;
                }
        public int check(String a)
        {
            String[] sy = {"\\+","/","\\*","-"};
//            char[] sy = {'\\+','/','\\*','-'};
//            if(sy[0].charAt(1)==a.charAt(0)||sy[1]==a.charAt(0).charAt(0)||sy[2].charAt(1)==a.charAt(0)||a.charAt(0)==sy[3].charAt(0))
            if(sy[0].charAt(0)==a.charAt(1)||sy[1].charAt(0)==a.charAt(0)||sy[2].charAt(1)==a.charAt(0)||sy[3].charAt(0)==a.charAt(0))
                return 1;
            else if(a.indexOf(sy[0])>=0)
            {
                for(int i = a.indexOf(sy[0]);i<a.length();i++)
                {
                    if(a.charAt(i)==sy[0].charAt(1)||a.charAt(i)==sy[1].charAt(0)||a.charAt(i)==sy[2].charAt(1)||a.charAt(i)==sy[3].charAt(0))
                    {
                        if(a.charAt(i+1)==sy[0].charAt(1)||a.charAt(i+1)==sy[1].charAt(0)||a.charAt(i+1)==sy[2].charAt(1)||a.charAt(i+1)==sy[3].charAt(0))
                        { return 1;}
                            break;

                    }
                }
            }
            else if(a.indexOf(sy[1])>=0)
            {
                for(int i = a.indexOf(sy[1]);i<a.length();i++)
                {
                    if(a.charAt(i)==sy[0].charAt(1)||a.charAt(i)==sy[1].charAt(0)||a.charAt(i)==sy[2].charAt(1)||a.charAt(i)==sy[3].charAt(0))
                    {
                        if(a.charAt(i+1)==sy[0].charAt(1)||a.charAt(i+1)==sy[1].charAt(0)||a.charAt(i+1)==sy[2].charAt(1)||a.charAt(i+1)==sy[3].charAt(0))
                        {    return 1;
//                            break;
                        }

                    }
                }
            }
            else if(a.indexOf(sy[2])>=0)
            {
                for(int i = a.indexOf(sy[2]);i<a.length();i++)
                {
                    if(a.charAt(i)==sy[0].charAt(1)||a.charAt(i)==sy[1].charAt(0)||a.charAt(i)==sy[2].charAt(1)||a.charAt(i)==sy[3].charAt(0))
                    {
                        if(a.charAt(i+1)==sy[0].charAt(1)||a.charAt(i+1)==sy[1].charAt(0)||a.charAt(i+1)==sy[2].charAt(1)||a.charAt(i+1)==sy[3].charAt(0))
                        { return 1;}
//                            break;

                    }
                }
            }
            else if(a.indexOf(sy[3])>=0)
            {
                for(int i = a.indexOf(sy[3]);i<a.length();i++)
                {
                    if(a.charAt(i)==sy[0].charAt(1)||a.charAt(i)==sy[1].charAt(0)||a.charAt(i)==sy[2].charAt(1)||a.charAt(i)==sy[3].charAt(0))
                    {
                        if(a.charAt(i+1)==sy[0].charAt(1)||a.charAt(i+1)==sy[1].charAt(0)||a.charAt(i+1)==sy[2].charAt(1)||a.charAt(i+1)==sy[3].charAt(0))
                        { return 1;}
//                            break;

                    }
//                    if(a.charAt(i)==sy[0]||a.charAt(i)==sy[1]||a.charAt(i)==sy[2]||a.charAt(i)==sy[3])
//                    {
//                        if(a.charAt(i+1)==sy[0]||a.charAt(i+1)==sy[1]||a.charAt(i+1)==sy[2]||a.charAt(i+1)==sy[3])
//                        {
//                            return 1;
////                            break;
//                        }
//
//
//                    }
                }
            }

            {return 0;}

        }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            new calc();
    }

}
