# Low-Level Design Pattern

A Java-based repository for **Low-Level Design (LLD)** concept, including **Design Pattern**, **SOLID Principle**, and practical **problem-based application**.  
Each module focus on clean architecture, modularity, and reusability — essential trait for scalable system design.

![Java](https://img.shields.io/badge/Language-Java-blue)

---

## Project Structure
```
├── BDP/          # Behavioral Design Pattern
├── CDP/          # Creational Design Pattern
├── SDP/          # Structural Design Pattern
├── SOLID/        # SOLID Principle
└── Problem/      # Case Study
```

---

## Design Pattern Implementation

### Behavioral Design Pattern (BDP)

| Pattern | Folder | Description |
|----------|---------|-------------|
| **Command** | `Command_Design_Pattern/` | Encapsulate command as object. Example: `BoldCommand`, `TextEditor`. |
| **Iterator** | `Iterator_Design_Pattern/` | Provide sequential access to element. Example: `BookCollection`, `BookIterator`. |
| **Mediator** | `Mediator_Design_Pattern/` | Facilitate communication through a mediator. Example: `ChatRoom`, `ChatUser`. |
| **Memento** | `Memento_Design_Pattern/` | Restore object states using snapshots. Example: `TextEditor`, `CareTaker`. |
| **Observer** | `Observer_Design_Pattern/` | One-to-many dependency model. Example: `WeatherStation`, `MobileDevice`. |
| **State** | `State_Design_Pattern/` | Change behavior based on internal state. Includes `TrafficLight` and `DirectionService` example. |
| **Strategy** | `Strategy_Design_Pattern/` | Define interchangeable algorithm. Example: `PaymentService`, `UPIPaymentStrategy`. |
| **Template Method** | `Template_Method_Pattern/` | Define skeleton of an algorithm with extensible step. Example: `DataParser`, `ReportTemplate`. |

---

### Creational Design Pattern (CDP)

| Pattern | Folder | Description |
|----------|---------|-------------|
| **Factory Method** | `Factory/` | Create transport instance (`Car`, `Bike`, `Bus`) via `TransportFactory`. |
| **Abstract Factory** | `Abstract_Factory/` | Produce related UI object without specifying concrete class (`WindowFactory`, `MacFactory`). |
| **Builder** | `Builder/` | Step-by-step object construction (`CarBuilder`). |
| **Prototype** | `Prototype/` | Clone objects instead of creating (`CharacterFactory`). |
| **Singleton** | `Singleton/` | Ensure one shared instance of configuration class (`AppSetting`). |

---

### Structural Design Pattern (CDP)

| Pattern | Folder | Description |
|----------|---------|-------------|
| **Adapter Method** | `Adapter/` | Convert interface (`SmartLightAdapter`, `CoffeeMachineAdapter)`. |
| **Composite Factory** | `Composite/` | Tree structure for smart device (`CompositeSmartComponent`). |
| **Decorator** | `Decorator/` | Add behavior dynamically (`MilkDecorator`, `SugarDecorator`). |
| **Flyweight** | `FlyWeight/` | Optimize memory usage by sharing intrinsic state (`ParticleTypeFactory`, `Particle`). |
| **Facade** | `Facade/` | Provide simplified interface to complex subsystem (`MediaFacade` - `MusicPlayer`, `VideoPlayer`, `ImageViewer`). |

---

### SOLID Principle

| Principle | Folder | Key Classes / Focus |
|------------|----------|--------------------|
| **OCP (Open/Closed Principle)** | `OCP/` | Demonstrate extensible payment processing (`PaymentProcessor`, `CreditCard`, `UPI`). |
| **LSP (Liskov Substitution Principle)** | `LSP/` | Ensure substitutability between readable/writable file (`ReadableFile`, `WritableFile`). |
| **DIP (Dependency Inversion Principle)** | `DIP/` | Promote abstraction in dependency handling (`NotificationService`, `EmailService`, `SMSService`). |

---

## Case Study

### **Chess**
- **Factory Pattern** for dynamic piece creation (`PieceFactory`).
- **Strategy Pattern** for movement logic (`MovementStrategyPattern`).
- **State Pattern** for turn management (`GameContext`, `GameState`).
- Modular class for board setup, movement validation, and game flow.

### **Snake Game**
- **Observer Pattern** for notifying score and movement update (`GameObserver`, `ConsoleGameObserver`).
- **Strategy Pattern** for dynamic movement control (`HumanMovementStrategy`).
- Flexible, event-driven gameplay using custom observer.

### **Tic-Tac-Toe**
- **State Pattern** for game transition (`XTurnState`, `OWonState`).
- **Event Listener** for move tracking and UI update (`GameEventListener`, `ConsoleGameEventListener`).
- Clean separation of concern through board, player, and context management.

### **Parking Lot**
- **Factory Pattern** for vehicle creation (`VehicleFactory`, `CarVehicle`, `BikeVehicle`).
- **Strategy Pattern** for fare calculation & payment (`BasicHourRateStrategy`, `PremiumRateStrategy`, `CashPayment`, `CreditCardPayment`).
- Modular class design for parking spot (`CarParkingSpot`, `BikeParkingSpot`).
- Flexible system for extending new vehicle type, pricing rule, and payment provider.

### **File System**
- **Composite Pattern** for directory & file hierarchy (`Directory`, `File`).
- Path-based operation for create/delete and file content management (`FileSystem`).
- Clean API supporting file read/write behavior and tree traversal.

