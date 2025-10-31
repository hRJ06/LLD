# Low-Level Design Pattern

A Java-based repository for **Low-Level Design (LLD)** concept, including **Design Pattern**, **SOLID Principle**, and practical **problem-based application**.  
Each module focus on clean architecture, modularity, and reusability — essential trait for scalable system design.

---

## Project Structure
```
├── BDP/          # Behavioral Design Pattern
├── CDP/          # Creational Design Pattern
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
| **Singleton** | `Singleton/` | Ensure one shared instance of configuration class (`AppSetting`). |

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

