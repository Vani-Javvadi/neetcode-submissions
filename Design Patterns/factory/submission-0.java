interface Vehicle {
    String getType();
}

class Car implements Vehicle {
    @Override
    public String getType() {
        return "Car";
    }
}

class Bike implements Vehicle {
    @Override
    public String getType() {
        return "Bike";
    }
}

class Truck implements Vehicle {
    @Override
    public String getType() {
        return "Truck";
    }
}

abstract class VehicleFactory {
    abstract Vehicle createVehicle();
}

class CarFactory extends VehicleFactory {
    // Write your code here
    @Override
    public Vehicle createVehicle() {
        Vehicle v = new Car();
        return v;
    }
}

class BikeFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        Vehicle v = new Bike();
        return v;
    }
}

class TruckFactory extends VehicleFactory {
    // Write your code here
    @Override
    public Vehicle createVehicle() {
        Vehicle v = new Truck();
        return v;
    }
}
