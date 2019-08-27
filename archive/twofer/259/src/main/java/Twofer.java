import java.text.MessageFormat;

class Twofer {
    String twofer(String name) {
        if(name == null){
            name = "you";
        }
        return MessageFormat.format("One for {0}, one for me.", name);
    }
}
