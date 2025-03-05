import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.*;

public class ScientificCalculator extends JFrame implements ActionListener {
    private JTextField display;
    private StringBuilder input;

    public ScientificCalculator() {
        setTitle("Scientific Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        input = new StringBuilder();
        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 5, 5, 5));

        String[] buttons = { "7", "8", "9", "/", "C",
                "4", "5", "6", "*", "sqrt",
                "1", "2", "3", "-", "^",
                "0", ".", "=", "+", "(",
                ")", "sin", "cos", "tan", "log",
                "ln"};

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.addActionListener(this);
            panel.add(button);
        }
        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            if (command.equals("C")) {
                input.setLength(0);
                display.setText("");
            } else if (command.equals("=")) {
                double result = evaluate(input.toString());
                display.setText(String.valueOf(result));
                input.setLength(0);
            } else {
                input.append(command);
                display.setText(input.toString());
            }
        } catch (Exception ex) {
            display.setText("Error");
        }
    }

    private double evaluate(String expression) {
        expression = expression.replace("^", "**");
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        try {
            return Double.parseDouble(engine.eval(expression).toString());
        } catch (Exception e) {
            return Double.NaN;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ScientificCalculator().setVisible(true);
        });
    }
}
