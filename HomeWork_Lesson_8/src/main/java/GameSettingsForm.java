import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSettingsForm extends JFrame {
    GameSettingsForm gameSettingsForm = this;
    public GameSettingsForm() {

        // Разметка дополнительного окна
        setTitle("Настройки игры");
        setBounds(450, 450, 240, 220);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel jLabelMode = new JLabel("Выберете режим игры:");
        add(jLabelMode);

        JRadioButton radioButtonModeTwoPlayers = new JRadioButton("Игрок против игрока");
        add(radioButtonModeTwoPlayers);
        radioButtonModeTwoPlayers.setSelected(true);
        JRadioButton radioButtonModeAgainstAI = new JRadioButton("Игрок против компьютера");
        add(radioButtonModeAgainstAI);

        JLabel jLabelAILevel = new JLabel("Уровень сложности:");
        add(jLabelAILevel);
        JSlider jSlider = new JSlider(0,2,0);
        add(jSlider);
        jSlider.setAlignmentX(LEFT_ALIGNMENT);
        jSlider.setVisible(false);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonModeTwoPlayers);
        buttonGroup.add(radioButtonModeAgainstAI);

        JLabel jLabelLinesCount = new JLabel("Размер поля (по умолчанию 3 на 3): ");
        add(jLabelLinesCount);
        JTextField jTextFieldLinesCount = new JTextField();
        jTextFieldLinesCount.setMaximumSize(new Dimension(100, 20));
        add(jTextFieldLinesCount);

        JButton jButtonSetSettings = new JButton("Начать игру!");
        add(jButtonSetSettings);
        setVisible(true);

        // Если мы выбираем режим игры против компьютера, то
        // появится слайдер, который позволяет выбрать уровень сложности
        radioButtonModeAgainstAI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButtonModeAgainstAI.isSelected()) {
                    jSlider.setVisible(true);
                }
            }
        });

        // Если выбран режим игры против другого игрока, то скрываем слайдер
        radioButtonModeTwoPlayers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButtonModeTwoPlayers.isSelected()) {
                    jSlider.setVisible(false);
                }
            }
        });

        // Задаём размер поля, если размер поля не указан, то по умолчанию он равен - 3
        jButtonSetSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGameField gameField = MainGameField.getInstance();
                if (jTextFieldLinesCount.getText().isEmpty()) {
                    gameField.linesCount = 3;
                }
                else {
                    try {
                        gameField.linesCount = Integer.parseInt(jTextFieldLinesCount.getText());
                    }
                    catch (NumberFormatException ex) {
                        System.out.println("Необходимо ввести целое число!");
                    }
                }
                // Запускаем игру
                gameField.startNewGame();
                if (radioButtonModeAgainstAI.isSelected()) {
                    gameField.gameMode = 2;
                }
                gameField.aiLevel = jSlider.getValue();
                gameSettingsForm.setVisible(false);
            }
        });
    }
}
