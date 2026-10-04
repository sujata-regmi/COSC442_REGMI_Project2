import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class VendingMachineTest {
    @Test
    void testAddItem() {
        // Arrange
        VendingMachine machine = new VendingMachine();
        VendingMachineItem item = new VendingMachineItem("Soda", 1.50);

        // Act
        machine.addItem(item, "A");

        // Assert
        assertEquals(item, machine.getItem("A"));
        assertEquals("Soda", machine.getItem("A").getName());
        assertEquals(1.50, machine.getItem("A").getPrice(), 0.001);
    }

    @Test
    void testGetBalance() {
        // Arrange
        VendingMachine machine = new VendingMachine();

        // Act & Assert (Verify initial balance is 0.0)
        assertEquals(0.0, machine.getBalance(), 0.001);

        // Act
        machine.insertMoney(1.00);
        
        // Assert
        assertEquals(1.00, machine.getBalance(), 0.001);
    }

    @Test
    void testGetItem() {
        // Arrange
        VendingMachine machine = new VendingMachine();
        VendingMachineItem item = new VendingMachineItem("Candy", 0.75);
        machine.addItem(item, "B");

        // Act
        VendingMachineItem retrievedItem = machine.getItem("B");

        // Assert
        assertNotNull(retrievedItem);
        assertEquals("Candy", retrievedItem.getName());
        assertEquals(0.75, retrievedItem.getPrice(), 0.001);
    }

    @Test
    void testInsertMoney() {
        // Arrange
        VendingMachine machine = new VendingMachine();

        // Act
        machine.insertMoney(2.00);

        // Assert
        assertEquals(2.00, machine.getBalance(), 0.001);
    }
}