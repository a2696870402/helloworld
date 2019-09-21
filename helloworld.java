package com.c1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.security.auth.kerberos.KerberosKey;
import javax.swing.*;

public class helloworld {
    public static Thread1 thread1;
    public static Thread2 thread2;
    public static Thread3 thread3;
    public static Thread4 thread4;
    public static Thread5 thread5;
    public static void main(String[] args) {
        Threadframe threadframe = new Threadframe();
        threadframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        threadframe.show();
        //线程的创建
        thread1 = new Thread1(ThreadPanel.progressBar1);
        thread2 = new Thread2(ThreadPanel.progressBar2);
        thread3 = new Thread3(ThreadPanel.progressBar3);
        thread4 = new Thread4(ThreadPanel.progressBar4);
        thread5 = new Thread5(ThreadPanel.progressBar5);
        int i = 0, j = 0;
        int[] array = new int[1000];
        Random random = new Random(System.currentTimeMillis());
        for (i = 0; i < 1000; i++) {
            j = (int) (Math.random() * 10 % 5);
            array[i] = j;
        }
        while (true) {
            for (i = 0; i < 1000; i++) {
                switch (array[i]) {
                    case 0:
                        if (thread1.flag == true) {
                            thread1.run();
                        } else {
                            thread1.yield();
                        }
                        break;
                    case 1:
                        if (thread2.flag == true) {
                            thread2.run();
                        } else {
                            thread2.yield();
                        }
                        break;
                    case 2:
                        if (thread3.flag == true) {
                            thread3.run();
                        } else {
                            thread3.yield();
                        }
                        break;
                    case 3:
                        if (thread4.flag == true) {
                            thread4.run();
                        } else {
                            thread4.yield();
                        }
                        break;
                    case 4:
                        if (thread5.flag == true) {
                            thread5.run();
                        } else {
                            thread5.yield();
                        }
                        break;
                }
            }
        }
    }
}

class ThreadPanel extends JPanel {
    public static JProgressBar progressBar1;
    public static JProgressBar progressBar2;
    public static JProgressBar progressBar3;
    public static JProgressBar progressBar4;
    public static JProgressBar progressBar5;
    JButton button_start_1;
    JButton button_start_2;
    JButton button_start_3;
    JButton button_start_4;
    JButton button_start_5;

    JButton button_stop_1;
    JButton button_stop_2;
    JButton button_stop_3;
    JButton button_stop_4;
    JButton button_stop_5;

    public void paintComponent(Graphics e) {
        super.paintComponent(e);
        Font font = new Font("宋体", Font.BOLD + Font.ITALIC, 15);
        e.setFont(font);
        e.drawString("进程1", 20, 90);
        e.drawString("进程2", 20, 210);
        e.drawString("进程3", 20, 320);
        e.drawString("进程4", 20, 410);
        e.drawString("进程5", 20, 510);

    }

    public ThreadPanel() {
        setLayout(null);
        setSize(800, 400);
        progressBar1 = new JProgressBar();
        progressBar2 = new JProgressBar();
        progressBar3 = new JProgressBar();
        progressBar4 = new JProgressBar();
        progressBar5 = new JProgressBar();
        button_start_1 = new JButton("开始");
        button_start_2 = new JButton("开始");
        button_start_3 = new JButton("开始");
        button_start_4 = new JButton("开始");
        button_start_5 = new JButton("开始");

        button_stop_1 = new JButton("暂停");
        button_stop_2 = new JButton("暂停");
        button_stop_3 = new JButton("暂停");
        button_stop_4 = new JButton("暂停");
        button_stop_5 = new JButton("暂停");
        progressBar1.setBackground(new Color(255, 50, 0));
        progressBar2.setBackground(new Color(125, 0, 255));
        progressBar3.setBackground(new Color(115, 125, 125));
        progressBar4.setBackground(new Color(215, 220, 125));
        progressBar5.setBackground(new Color(120, 110, 150));

        progressBar1.setForeground(new Color(255, 100, 90));
        progressBar2.setForeground(new Color(255, 0, 255));
        progressBar3.setForeground(new Color(152, 155, 10));
        progressBar4.setForeground(new Color(210, 90, 210));
        progressBar5.setForeground(new Color(112, 90, 90));


        progressBar1.setBounds(100, 70, 480, 40);
        progressBar2.setBounds(100, 190, 480, 40);
        progressBar3.setBounds(100, 300, 480, 40);
        progressBar4.setBounds(100, 400, 480, 40);
        progressBar5.setBounds(100, 510, 480, 40);

        button_start_1.setBounds(600, 70, 80, 40);
        button_stop_1.setBounds(700, 70, 80, 40);

        button_start_2.setBounds(600, 190, 80, 40);
        button_stop_2.setBounds(700, 190, 80, 40);

        button_start_3.setBounds(600, 300, 80, 40);
        button_stop_3.setBounds(700, 300, 80, 40);

        button_start_4.setBounds(600, 400, 80, 40);
        button_stop_4.setBounds(700, 400, 80, 40);

        button_start_5.setBounds(600, 510, 80, 40);
        button_stop_5.setBounds(700, 510, 80, 40);


        add(progressBar1);
        add(button_start_1);
        add(button_stop_1);

        add(progressBar2);
        add(button_start_2);
        add(button_stop_2);

        add(progressBar3);
        add(button_start_3);
        add(button_stop_3);

        add(progressBar4);
        add(button_start_4);
        add(button_stop_4);

        add(progressBar5);
        add(button_start_5);
        add(button_stop_5);


        button_start_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread1.flag = true;
            }
        });
        button_stop_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread1.flag = false;
            }
        });
        button_start_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread2.flag = true;
            }
        });
        button_stop_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread2.flag = false;
            }
        });

        button_start_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread3.flag = true;
            }
        });
        button_stop_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread3.flag = false;
            }
        });

        button_start_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread4.flag = true;
            }
        });
        button_stop_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread4.flag = false;
            }
        });

        button_start_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread5.flag = true;
            }
        });
        button_stop_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread5.flag = false;
            }
        });
    }

}

class Thread1 extends Thread {
    public static boolean flag = true;
    JProgressBar progressBar;
    private static int i = 0;

    public Thread1(JProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    @Override
    public void run() {
        if (i <= 100) {
            i += 1;
            progressBar.setValue(i);
            try {
                Thread.currentThread().sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            i = 0;
        }
    }
}

class Thread2 extends Thread {
    public static boolean flag = true;
    JProgressBar progressBar;
    private static int i = 0;

    public Thread2(JProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    @Override
    public void run() {
        if (i <= 100) {
            i += 1;
            progressBar.setValue(i);
            try {
                Thread.currentThread().sleep(35);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            i = 0;
        }
    }
}

class Thread3 extends Thread {
    public static boolean flag = true;
    JProgressBar progressBar;
    private static int i = 0;

    public Thread3(JProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    @Override
    public void run() {
        if (i <= 100) {
            i += 1;
            progressBar.setValue(i);
            try {
                Thread.currentThread().sleep(36);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            i = 0;
        }
    }
}

class Thread4 extends Thread {
    public static boolean flag = true;
    JProgressBar progressBar;
    private static int i = 0;

    public Thread4(JProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    @Override
    public void run() {
        if (i <= 100) {
            i += 1;
            progressBar.setValue(i);
            try {
                Thread.currentThread().sleep(37);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            i = 0;
        }
    }
}

class Thread5 extends Thread {
    public static boolean flag = true;
    JProgressBar progressBar;
    private static int i = 0;

    public Thread5(JProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    @Override
    public void run() {
        if (i <= 100) {
            i += 1;
            progressBar.setValue(i);
            try {
                Thread.currentThread().sleep(38);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            i = 0;
        }
    }
}

class Threadframe extends JFrame {
    int width = 1200;
    int height = 800;
    public ThreadPanel threadPanel = new ThreadPanel();
    public Container container;

    public Threadframe() {
        setTitle("模拟多线程并发_ouguangji");
        setSize(width, height);
        setLocation(250, 150);
        container = getContentPane();
        container.add(threadPanel);
    }
}
