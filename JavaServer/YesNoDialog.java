import javax.swing.JOptionPane;

public class YesNoDialog {
    public static void main(String[] args) {
        int choice = JOptionPane.showConfirmDialog(null, "Do you want to proceed?", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            System.out.println("User selected Yes");
        } else {
            System.out.println("User selected No");
        }
    }
}
