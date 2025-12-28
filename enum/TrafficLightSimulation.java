enum TrafficLight {
    RED,
    YELLOW,
    GREEN
}
class TrafficLightSimulator {
    private TrafficLight currentLight;
    
    public TrafficLightSimulator(TrafficLight initialLight) {
        this.currentLight = initialLight;
    }
    
    public void changeColor() {
        switch (currentLight) {
            case RED:
                currentLight = TrafficLight.GREEN;
                break;
            case YELLOW:
                currentLight = TrafficLight.RED;
                break;
            case GREEN:
                currentLight = TrafficLight.YELLOW;
                break;
        }
    }
    
    public TrafficLight getCurrentLight() {
        return currentLight;
    }
    
    @Override
    public String toString() {
        String lightDisplay = "";
        
        switch (currentLight) {
            case RED:
                lightDisplay = " STOP - RED LIGHT!";
                break;
            case YELLOW:
                lightDisplay = " CAUTION - YELLOW LIGHT!";
                break;
            case GREEN:
                lightDisplay = " GO - GREEN LIGHT!";
                break;
        }
        
        return "Traffic Light Status: " + lightDisplay;
    }
}

public class TrafficLightSimulation {
    public static void main(String[] args) {
        TrafficLightSimulator simulator = new TrafficLightSimulator(TrafficLight.RED);
        
        for (int i = 1; i <= 10; i++) {
            System.out.println("TICK " + i + ":");
            System.out.println(simulator.toString());
            System.out.println();
            
            simulator.changeColor();
            
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("COMPLETED");
    }
}