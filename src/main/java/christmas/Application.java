package christmas;


import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.prinEventPlannerMessage();
        int date = inputView.readDate();
        String[][] menu = inputView.readMenu();

    }
}

