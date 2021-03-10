import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class XO_grafick extends JFrame {

    private static final int SIZE = 3;
    private static JLabel[][] jPanel = new JLabel[SIZE][SIZE];

    public XO_grafick(){
        setTitle("Крестики и нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(360,360);
        setLocationRelativeTo(null);
        setResizable(false);

        JMenuBar mainMenu = new JMenuBar();
        setJMenuBar(mainMenu);
        JMenu fileMenu = new JMenu("Файл");
        JMenu helpMenu = new JMenu("Справка");
        JMenuItem start = new JMenuItem("Новая игра");
        JMenuItem exit = new JMenuItem("Выход");
        fileMenu.add(start);
        fileMenu.add(exit);
        JMenuItem info = new JMenuItem("О программе");
        helpMenu.add(info);

        mainMenu.add(fileMenu);
        mainMenu.add(helpMenu);

        // нажатие на "Выход"
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        // нажатие на "Новая игра"
        start.addActionListener(new ActionListener()
        {
            @Override

            public void actionPerformed(ActionEvent e)
            {
                System.out.println(start.getText());
                humanClick();
            }
        });

        // нажатие на "Справка"
        info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                smallWindow();
            }
        });

        setLayout(new GridLayout(SIZE,SIZE));
        for (int i = 0; i < jPanel.length; i++) {
            for (int j = 0; j < jPanel[i].length; j++) {
                jPanel[i][j]= new JLabel(".",SwingConstants.CENTER);
                jPanel[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                add(jPanel[i][j]);
            }
        }
        setVisible(true);
    }

    private int two_Window(int option){
        switch (option) {
            case (0):
                return JOptionPane.showConfirmDialog(null, "Хотите сыграть еще раз?", "Ничья", JOptionPane.YES_NO_OPTION);

            case (1):
                return JOptionPane.showConfirmDialog(null, "Хотите сыграть еще раз?", "Вы победили", JOptionPane.YES_NO_OPTION);
            default:
                return JOptionPane.showConfirmDialog(null, "Хотите сыграть еще раз?", "Вы проиграли", JOptionPane.YES_NO_OPTION);
        }
    }

    private void reset(){
        for (int i = 0; i < jPanel.length; i++) {
            for (int j = 0; j < jPanel[i].length; j++) {
                jPanel[i][j].setText(".");
                jPanel[i][j].setEnabled(true);
            }
        }
    }

    private  void pcTurn(){
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(jPanel.length);
            y = random.nextInt(jPanel.length);
        } while (!(jPanel[y][x].getText().equals(".")));
        jPanel[y][x].setText("O");
        jPanel[y][x].setEnabled(false);

    }

    private boolean isWinner(String symbol){
        int countX=0,countY=0,countL=0,countR=0;
        for (int i = 0; i < jPanel.length; i++) {
            for (int j = 0; j < jPanel.length; j++) {
                if(jPanel[i][j].getText().equals(symbol)){
                    countX++;
                }
                if(jPanel[j][i].getText().equals(symbol)){
                    countY++;
                }
                if(i==j&& jPanel[i][j].getText().equals(symbol)){
                    countL++;
                }
                if(j==jPanel.length-i-1&& jPanel[i][j].getText().equals(symbol)){
                    countR++;
                }
            }
            if(countX==3||countY==3){
                return true;
            }
            else{
                countX=countY=0;
            }
        }
        return countL==3||countR==3;
    }

    public void humanClick(){
        for (JLabel[] butt : jPanel) {
            for (JLabel everyBut : butt) {
                everyBut.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (everyBut.getText().equals(".")) {
                            everyBut.setText("X");
                            everyBut.setEnabled(false);

                            if(isWinner("X")){
                                setTitle("Player победил");
                                if(two_Window(1)==0) {
                                    reset();
                                }
                                else{
                                    System.exit(0);
                                }
                            }
                            else if(countField()==9){
                                setTitle("Ничья");
                                if(two_Window(0)==0) {
                                    reset();
                                }
                                else{
                                    System.exit(0);
                                }
                            }
                            else {
                                pcTurn();
                                if(isWinner("O")){
                                    setTitle("Comp. победил");
                                    if(two_Window(2)==0) {
                                        reset();
                                    }
                                    else{
                                        System.exit(0);
                                    }
                                }
                            }

                        }
                    }
                });
            }
        }
    }

    private int countField(){
        int count=0;
        for (int i = 0; i < jPanel.length; i++) {
            for (int j = 0; j < jPanel[i].length; j++) {
                if(!(jPanel[i][j].getText().equals("."))){
                    count++;
                }
            }
        }
        return count;
    }
    
    private void smallWindow() {
        JOptionPane.showConfirmDialog(null, "Игра крестики и нолики\nверсия 1.0 без ИИ\nАвтор: Пилипенко В.А.", "Информация", JOptionPane.CLOSED_OPTION);
    }
}