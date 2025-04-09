package Creational.BuilderPattern.builders;

import Creational.BuilderPattern.cars.CarType;
import Creational.BuilderPattern.components.Engine;
import Creational.BuilderPattern.components.GPSNavigator;
import Creational.BuilderPattern.components.Transmission;
import Creational.BuilderPattern.components.TripComputer;

public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
