
import javax.swing.JOptionPane;

class Twofer {
    String twofer(String name) {

        String userName = JOptionPane.showInputDialog(question);
        if (userName.length == 0){
            return "One for " + "you" +", one for me.";
        }
        else {
            return "One for " + userName +", one for me.";
        }

    }
}
