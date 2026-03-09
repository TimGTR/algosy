package task10;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Model model = new Model();

        ViewModel viewModel = new ViewModel(model);

        SwingUtilities.invokeLater(() ->
                new MainView(viewModel)
        );
    }
}
