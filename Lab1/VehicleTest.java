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
        vehicleCount--;
        v.finalize();
        assertEquals(vehicleCount, v.totalVehicle());
    }

    @org.junit.jupiter.api.Test
    void testFinalize() {
        Vehicle testFinal = new Vehicle();
        int current = testFinal.totalVehicle();
        testFinal.finalize();
        assertEquals(current-1, v.totalVehicle());
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
        Vehicle x = new Vehicle(10, "west");
        assertEquals(10, x.getSpeed());
        x.finalize();
    }

    @org.junit.jupiter.api.Test
    void getDir() {
        System.out.println("getDir");
        Vehicle x = new Vehicle(10, "east");
        assertEquals("east", x.getDir());
        x.finalize();
    }

    @org.junit.jupiter.api.Test
    void totalVehicle() {
        System.out.println("totalVehicle");
        assert(0<vehicleCount);
    }
}
