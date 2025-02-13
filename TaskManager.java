import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

class Task implements Serializable {
    private String name;
    private String description;
    private boolean completed;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.completed = false;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public boolean isCompleted() { return completed; }
    public void markCompleted() { this.completed = true; }
}

public class TaskManager extends JFrame {
    private ArrayList<Task> tasks = new ArrayList<>();
    private DefaultTableModel model;
    private JTable table;
    private static final String FILE_NAME = "tasks.ser";

    public TaskManager() {
        setTitle("Task Manager");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        String[] columnNames = {"Task", "Description", "Completed"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        JButton addButton = new JButton("Add Task");
        JButton removeButton = new JButton("Remove Task");
        JButton completeButton = new JButton("Mark Completed");
        JButton saveButton = new JButton("Save Tasks");
        JButton loadButton = new JButton("Load Tasks");

        panel.add(addButton);
        panel.add(removeButton);
        panel.add(completeButton);
        panel.add(saveButton);
        panel.add(loadButton);
        add(panel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addTask());
        removeButton.addActionListener(e -> removeTask());
        completeButton.addActionListener(e -> markTaskCompleted());
        saveButton.addActionListener(e -> saveTasks());
        loadButton.addActionListener(e -> loadTasks());
    }

    private void addTask() {
        String name = JOptionPane.showInputDialog("Enter task name:");
        String desc = JOptionPane.showInputDialog("Enter task description:");
        if (name != null && desc != null) {
            tasks.add(new Task(name, desc));
            model.addRow(new Object[]{name, desc, "No"});
        }
    }

    private void removeTask() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            tasks.remove(selectedRow);
            model.removeRow(selectedRow);
        }
    }

    private void markTaskCompleted() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            tasks.get(selectedRow).markCompleted();
            model.setValueAt("Yes", selectedRow, 2);
        }
    }

    private void saveTasks() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(tasks);
            JOptionPane.showMessageDialog(this, "Tasks saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadTasks() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            tasks = (ArrayList<Task>) in.readObject();
            model.setRowCount(0);
            for (Task task : tasks) {
                model.addRow(new Object[]{task.getName(), task.getDescription(), task.isCompleted() ? "Yes" : "No"});
            }
            JOptionPane.showMessageDialog(this, "Tasks loaded successfully!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TaskManager().setVisible(true));
    }
}
