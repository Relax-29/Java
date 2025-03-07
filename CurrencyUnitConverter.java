import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CurrencyUnitConverter extends JFrame {
    private JTextField amountField;
    private JComboBox<String> fromCurrency, toCurrency;
    private JComboBox<String> unitType, fromUnit, toUnit;
    private JLabel currencyResultLabel, unitResultLabel;

    private final Map<String, Double> currencyRates = new HashMap<>();
    private final Map<String, Map<String, Double>> unitConversions = new HashMap<>();

    public CurrencyUnitConverter() {
        setTitle("Currency & Unit Converter");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 1));

        initializeCurrencyRates();
        initializeUnitConversions();

        // Amount input
        add(new JLabel("Enter Amount:"));
        amountField = new JTextField();
        add(amountField);

        // Currency Converter
        add(new JLabel("Currency Converter"));
        fromCurrency = new JComboBox<>(currencyRates.keySet().toArray(new String[0]));
        toCurrency = new JComboBox<>(currencyRates.keySet().toArray(new String[0]));
        JButton convertCurrencyButton = new JButton("Convert Currency");
        currencyResultLabel = new JLabel("Converted: ");

        add(fromCurrency);
        add(toCurrency);
        add(convertCurrencyButton);
        add(currencyResultLabel);

        convertCurrencyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        // Unit Converter
        add(new JLabel("Unit Converter"));
        unitType = new JComboBox<>(new String[]{"Length", "Weight", "Temperature"});
        fromUnit = new JComboBox<>();
        toUnit = new JComboBox<>();
        JButton convertUnitButton = new JButton("Convert Unit");
        unitResultLabel = new JLabel("Converted: ");

        add(unitType);
        add(fromUnit);
        add(toUnit);
        add(convertUnitButton);
        add(unitResultLabel);

        unitType.addActionListener(e -> updateUnits());
        convertUnitButton.addActionListener(e -> convertUnit());

        updateUnits();
        setVisible(true);
    }

    private void initializeCurrencyRates() {
        currencyRates.put("USD", 1.0);
        currencyRates.put("EUR", 0.92);
        currencyRates.put("INR", 82.50);
        currencyRates.put("GBP", 0.78);
        currencyRates.put("JPY", 150.25);
    }

    private void initializeUnitConversions() {
        unitConversions.put("Length", Map.of("Meter", 1.0, "Kilometer", 0.001, "Mile", 0.000621371, "Foot", 3.28084));
        unitConversions.put("Weight", Map.of("Gram", 1.0, "Kilogram", 0.001, "Pound", 0.00220462, "Ounce", 0.035274));
        unitConversions.put("Temperature", Map.of("Celsius", 1.0, "Fahrenheit", 1.8, "Kelvin", 1.0));
    }

    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String from = (String) fromCurrency.getSelectedItem();
            String to = (String) toCurrency.getSelectedItem();

            double convertedAmount = (amount / currencyRates.get(from)) * currencyRates.get(to);
            currencyResultLabel.setText("Converted: " + String.format("%.2f", convertedAmount) + " " + to);
        } catch (NumberFormatException e) {
            currencyResultLabel.setText("Invalid Input!");
        }
    }

    private void updateUnits() {
        String selectedType = (String) unitType.getSelectedItem();
        fromUnit.removeAllItems();
        toUnit.removeAllItems();

        if (unitConversions.containsKey(selectedType)) {
            for (String unit : unitConversions.get(selectedType).keySet()) {
                fromUnit.addItem(unit);
                toUnit.addItem(unit);
            }
        }
    }

    private void convertUnit() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String type = (String) unitType.getSelectedItem();
            String from = (String) fromUnit.getSelectedItem();
            String to = (String) toUnit.getSelectedItem();

            if (type.equals("Temperature")) {
                double convertedAmount = convertTemperature(amount, from, to);
                unitResultLabel.setText("Converted: " + String.format("%.2f", convertedAmount) + " " + to);
            }
            else {
                double convertedAmount = (amount / unitConversions.get(type).get(from)) * unitConversions.get(type).get(to);
                unitResultLabel.setText("Converted: " + String.format("%.2f", convertedAmount) + " " + to);
            }
        }
        catch (NumberFormatException e) {
            unitResultLabel.setText("Invalid Input!");
        }
    }

    private double convertTemperature(double amount, String from, String to) {
        if (from.equals(to)) return amount;
        if (from.equals("Celsius") && to.equals("Fahrenheit")) return (amount * 1.8) + 32;
        if (from.equals("Fahrenheit") && to.equals("Celsius")) return (amount - 32) / 1.8;
        if (from.equals("Celsius") && to.equals("Kelvin")) return amount + 273.15;
        if (from.equals("Kelvin") && to.equals("Celsius")) return amount - 273.15;
        return amount;
    }

    public static void main(String[] args) {
        new CurrencyUnitConverter();
    }
}
