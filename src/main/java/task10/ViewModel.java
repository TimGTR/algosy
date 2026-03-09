package task10;

public class ViewModel {

    private Model model;

    public ViewModel(Model model) {
        this.model = model;
    }

    public void setText(String text) {
        model.setText(text);
    }

    public String getText() {
        return model.getText();
    }

    public void bind(Model.ModelListener listener) {
        model.addListener(listener);
    }
}
