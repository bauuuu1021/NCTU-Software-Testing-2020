import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    private int vehicleCount = 0;
    private Vehicle v;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        v = new Vehicle();
        vehicleCount++;
        assertEquals(vehicleCount, v.totalVehicle());
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown()  {
        v.finalize();
        vehicleCount--;
        assertEquals(0, vehicleCount);
        assertEquals(vehicleCount, v.totalVehicle());
    }

    @org.junit.jupiter.api.Test
    void testFinalize() {
        Vehicle testFinal = new Vehicle();
        int currentCount = testFinal.totalVehicle();
        testFinal.finalize();
        assertEquals(currentCount-1, v.totalVehicle());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7,8,9,10})
    void setSpeed(int newSpeed) {
        System.out.println("setSpeed");
        v.setSpeed(newSpeed);
        assertEquals(newSpeed, v.getSpeed());
    }


    @ParameterizedTest
    @ValueSource(strings = {"east", "south", "west", "north"})
    void setDir(String newDir) {
        System.out.println("setDir");
        v.setDir(newDir);
        assertEquals(newDir, v.getDir());
    }

    @org.junit.jupiter.api.Test
    void getSpeed() {
        System.out.println("getSpeed");
        assertEquals(0, v.getSpeed());
    }

    @org.junit.jupiter.api.Test
    void getDir() {
        System.out.println("getDir");
        assertEquals("north", v.getDir());
    }

    @org.junit.jupiter.api.Test
    void totalVehicle() {
        System.out.println("totalVehicle");
        assertEquals(vehicleCount, v.totalVehicle());
    }
}