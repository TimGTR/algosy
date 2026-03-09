package task10;

import javax.swing.*;
import java.awt.*;

public class MainView {

    private JTextField field1 = new JTextField(30);
    private JTextField field2 = new JTextField(30);
    private JTextField field3 = new JTextField(30);
    private JButton button = new JButton("Update");

    public MainView(ViewModel viewModel) {

        JFrame frame = new JFrame("MVVM Demo");
        frame.setLayout(new FlowLayout());
        field3.setText("Мы же тут просто показываем, что поле обновится...");
        field3.setEditable(false);
        frame.add(field1);
        frame.add(field2);
        frame.add(field3);
        frame.add(button);

        frame.setSize(600,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // реакция на кнопку
        button.addActionListener(e ->
                viewModel.setText(field1.getText())
        );

        // подписка на изменения модели
        viewModel.bind(newText -> {
            field2.setText(newText);
            field3.setText("Вот поле обновилось - " + newText);
        });

        frame.setVisible(true);
    }
}