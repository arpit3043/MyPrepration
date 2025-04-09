# Parking Lot System Design

## Features

- There is one entrance and can be more as well.
- There is one exit and can be more as well.
- The parking lot has multiple levels, each with a configurable number of parking spots.
- The parking lot supports different types of vehicles:
  - 2 Wheeler
  - 3 Wheeler
  - 4 Wheeler
  - Heavy Vehicles
- Each parking spot is designated for a specific type of vehicle.
- The system assigns a parking spot to a vehicle upon entry and releases it when the vehicle exits.
- Tracks real-time availability of parking spots and provides this information to customers.
- Handles multiple concurrent entries and exits.
- Vehicles are assigned the **nearest** parking spot from the **entry gate** using **min-heap functionality**.
- Payment strategy:
  - **2 Wheeler**: Minutes-based
  - **4 Wheeler**: Hourly-based
  - **Heavy Vehicles**: Mixed strategy

---

## Classes, Interfaces, and Enumerations

### `ParkingLot` (Singleton Pattern)
- Ensures a single instance of the parking lot.
- Maintains a list of `Level` objects.
- Provides methods to park and unpark vehicles.
- Handles synchronization for thread safety.

### `Level`
- Represents a level in the parking lot.
- Contains a list of `ParkingSpot` objects.
- Handles parking and unparking of vehicles at that level.

### `ParkingSpot`
- Represents an individual parking spot.
- Tracks the current availability.
- Holds a reference to the parked vehicle.

### `Vehicle` (Abstract Class)
- Abstract base class for different types of vehicles.
- Subclasses:
  - `TwoWheeler`
  - `ThreeWheeler`
  - `FourWheeler`
  - `HeavyVehicle`

### `VehicleType` (Enum)
- Enumerates supported vehicle types:
  - `TWO_WHEELER`
  - `THREE_WHEELER`
  - `FOUR_WHEELER`
  - `HEAVY_VEHICLE`

### `Main`
- Demonstrates usage and interactions with the Parking Lot system.

---

## Design Patterns Used

### ✅ Singleton Pattern
- Ensures only one instance of the `ParkingLot`.

### ✅ Factory Pattern (Optional Extensions)
- For vehicle creation based on input.
- For assigning appropriate parking spots based on type and availability.

### ✅ Strategy Pattern
- For payment calculation strategies:
  - `MinutesBasedPaymentStrategy`
  - `HourlyBasedPaymentStrategy`
  - `MixedPaymentStrategy`

### ✅ Observer Pattern (Optional Extension)
- Notifies users about availability updates in real-time.

---

## Concurrency

- Critical sections are synchronized using Java's `synchronized` keyword to ensure thread safety in a multi-threaded environment.

---

## Future Extensions

- Mobile app or dashboard integration for real-time spot tracking.
- Notifications on parking spot availability and vehicle exit reminders.
- License plate recognition for automatic entry and exit logging.
