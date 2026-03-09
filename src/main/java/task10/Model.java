package task10;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Model {

    @Getter
    private String text;

    public interface ModelListener {
        void onModelChanged(String newValue);
    }

    private List<ModelListener> listeners = new ArrayList<>();

    public void addListener(ModelListener listener) {
        listeners.add(listener);
    }

    public void setText(String text) {
        this.text = text;

        for (ModelListener l : listeners) {
            l.onModelChanged(text);
        }
    }
}
