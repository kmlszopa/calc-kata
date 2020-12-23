import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class Calculator {


    public class NegativeNumberException extends RuntimeException {

        private String message;

        public NegativeNumberException(String message) {
            this.message = message;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }

    public int add(String input) {
        int result = 0;

        if (input.isEmpty()) {
            return result;
        }
        String[] numbers = input.split(",|\n");

        List<String> negatives = new ArrayList<>();
        for (String number : numbers) {
            if (Integer.parseInt(number) < 0) {
                negatives.add(number);
            }
            result += Integer.parseInt(number);
        }
        if (negatives.isEmpty()) {
            return result;
        }
        StringBuilder sb = new StringBuilder();

        String message = "Negatives: ";
        message +=String.join(" ", negatives);
        throw new NegativeNumberException(message.trim());

    }

}
