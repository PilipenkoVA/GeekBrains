import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {

    public MainForm() {

        // Заголовок основного окна
        setTitle("Крестики и Нолики");
        // Границы формы
        setBounds(300, 300, 455, 525);
        // Устанавливаем запрет на изменение размера основного окна
        setResizable(false);
        // При закрытии - окно и программа закрываются
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Создаём экземпляр игрового поля
        MainGameField gameField = MainGameField.getInstance();

        // Создаём панель для кнопок табличного стиля
        JPanel buttonPanel = new JPanel(new GridLayout());

        // Добавляем игровок поле в центр нашей формы
        add(gameField, BorderLayout.CENTER);

        // Панель для кнопок добавляем вниз формы
        add(buttonPanel, BorderLayout.SOUTH);
        JButton btnStart = new JButton("Начать новую игру");
        JButton btnEnd = new JButton("Закончить игру");
        buttonPanel.add(btnStart);
        buttonPanel.add(btnEnd);

        // Добавляем команду для закрытия основного окна
        btnEnd.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Добавляем команду для вывода дополнительного окнам(с настройками игры)
        btnStart.addActionListener(new ActionListener()
        {
            @Override

            public void actionPerformed(ActionEvent e)
            {
                System.out.println(btnStart.getText());
                GameSettingsForm gameSettingsForm = new GameSettingsForm();
            }
        });

        setVisible(true);
    }
}
