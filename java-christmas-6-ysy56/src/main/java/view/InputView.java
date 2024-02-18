package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readDate() {
        int date;

        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (1 이상 31 이하의 숫자만 입력해 주세요!)");

        while (true) {
            try {
                date = getValidDateInput();
                break; // 유효한 입력이면 반복문 종료

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return date;
    }

    private int getValidDateInput() {
        String input = Console.readLine();
        int date;

        try {
            date = Integer.parseInt(input);

            if (date < 1 || date > 31) {
                throw new IllegalArgumentException("[ERROR] 1 이상 31 이하의 숫자만 입력할 수 있습니다. 다시 입력해 주세요.");
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }

        return date;
    }

    public String[][] readMenu() {
        String[][] menu;

        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");

        while (true) {
            try {
                menu = getValidMenuInput();
                break; // 유효한 입력이면 반복문 종료

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return menu;
    }

    private String[][] getValidMenuInput() {
        String input = Console.readLine();
        String[][] menu = new String[12][2];

        try {
            String[] temp = input.split(",");
            for (int i = 0; i<temp.length; i++) {
                menu[i] = temp[i].split("-");
            }
            handleMenuException(menu);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }

    private void handleMenuException(String[][] menu) {
        String[][] appetizerMenu = {{"양송이수프", "6000"}, {"타파스", "5500"}, {"시저샐러드", "8000"}};
        String[][] mainMenu = {{"티본스테이크", "55000"}, {"바비큐립", "54000"}, {"해산물파스타", "35000"}, {"크리스마스파스타", "25000"}};
        String[][] desertMenu = {{"초코케이크", "15000"}, {"아이스크림", "5000"}};
        String[][] drinkMenu = {{"제로콜라", "3000"}, {"레드와인", "60000"}, {"샴페인", "25000"}};

        int menuType = menu.length;
        int drinkMenuNum = 0;
        int menuNum = 0;
        for (String[] value : menu) {
            if (Integer.parseInt(value[1]) < 0) throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            menuNum += Integer.parseInt(value[1]);
            for (String[] strings : drinkMenu) {
                if (value[0].equals(strings[0])) {
                    drinkMenuNum++;
                }
            }
        }
        if (menuNum == drinkMenu.length) throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        if (menuNum > 20 ) throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    }
}
