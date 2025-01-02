import javax.swing.*;
import java.awt.event.*;

// Section 1: Rectangle Class
class Rectangle {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}

// Section 2: Vehicle and Car Classes
class Vehicle {
    protected String brand;
    protected int year;

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public void startEngine() {
        System.out.println("Engine started.");
    }
}

class Car extends Vehicle {
    private int numDoors;

    public Car(String brand, int year, int numDoors) {
        super(brand, year);
        this.numDoors = numDoors;
    }

    @Override
    public void startEngine() {
        System.out.println("Car engine started.");
    }
}

// Section 5: Custom Exception
class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

// Main Class: AssignmentProgram
public class AssignmentProgram {

    // Section 3: throws Exception example
    public static void riskyMethod() throws Exception {
        throw new Exception("This is a risky method!");
    }

    public static void main(String[] args) {

        // Section 1: Classes and Objects
        Rectangle rect = new Rectangle(5, 3);
        System.out.println("Area of rectangle: " + rect.calculateArea());

        // Section 2: Inheritance and Polymorphism
        Vehicle myVehicle = new Vehicle("Toyota", 2020);
        myVehicle.startEngine();  // Output: Engine started.

        Car myCar = new Car("Honda", 2022, 4);
        myCar.startEngine();  // Output: Car engine started.

        Vehicle polyVehicle = new Car("Ford", 2021, 4);
        polyVehicle.startEngine();  // Output: Car engine started.

        // Section 3: Exception Handling
        int num1 = 10;
        int num2 = 0;

        try {
            int result = num1 / num2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        } finally {
            System.out.println("Division attempt finished.");
        }

        try {
            riskyMethod();
        } catch (Exception e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }

        // Section 4: Swing GUI Example
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Swing Example");
                JButton button = new JButton("Click Me");

                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(frame, "Button clicked!");
                    }
                });

                frame.setSize(300, 200);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(button);
                frame.setVisible(true);
            }
        });

        // Section 4.3: JTextField and JLabel
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("TextField Example");
                JLabel label = new JLabel("Type something:");
                JTextField textField = new JTextField(20);

                textField.addKeyListener(new KeyAdapter() {
                    public void keyReleased(KeyEvent e) {
                        label.setText("You typed: " + textField.getText());
                    }
                });

                JPanel panel = new JPanel();
                panel.add(textField);
                panel.add(label);
                frame.add(panel);
                frame.setSize(300, 100);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });

        // Section 5: Comprehensive Program (Car Year and Custom Exception)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Comprehensive Program");
                JLabel label = new JLabel("Enter Car Year:");
                JTextField textField = new JTextField(10);
                JButton button = new JButton("Start Car Engine");

                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int year = Integer.parseInt(textField.getText());

                            if (year < 1886 || year > 2024) {
                                throw new InvalidInputException("Year must be between 1886 and 2024.");
                            }

                            Car car = new Car("Tesla", year, 4);
                            car.startEngine();

                        } catch (InvalidInputException ex) {
                            JOptionPane.showMessageDialog(frame, ex.getMessage());
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Please enter a valid number for the year.");
                        }
                    }
                });

                JPanel panel = new JPanel();
                panel.add(label);
                panel.add(textField);
                panel.add(button);
                frame.add(panel);
                frame.setSize(300, 200);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
