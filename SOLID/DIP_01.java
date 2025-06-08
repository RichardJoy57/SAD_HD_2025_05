package SOLID;

// Abstraction
public class DIP_01 {

    // Create a Device interface that both the Switch and LightBulb depend on
    public interface SwitchableDevice {
        void turnOn();
        void turnOff();
    }

    // Low-level module depends on the abstraction
    public static class LightBulb implements SwitchableDevice {
        @Override
        public void turnOn() {
            System.out.println("Light is ON!");
        }

        @Override
        public void turnOff() {
            System.out.println("Light is OFF!");
        }
    }

    // High-level module also depends on the abstraction
    public static class Switch {
        private SwitchableDevice device;
        private boolean isOn;

        public Switch(SwitchableDevice device) {
            this.device = device;
        }

        public void operate() {
            if (isOn) {
                device.turnOff();
            } else {
                device.turnOn();
            }
            isOn = !isOn;
        }
    }

    public static void main(String[] args) {
        SwitchableDevice lightBulb = new LightBulb();
        Switch lightSwitch = new Switch(lightBulb);
        lightSwitch.operate(); // Turns ON
        lightSwitch.operate(); // Turns OFF
    }
}
