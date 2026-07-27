# Hostel Booking System

Your original Hostel Management System concept, rebuilt using the exact same layered Maven architecture as the Movie Booking System project: one package per domain, each split into `model` / `dao` / `service` / `controller`, a shared `observer` package, and a `facade` package — all MySQL-backed via a singleton `DBConnection`.

## Design Patterns (from your original code, now properly layered)

- **Factory Pattern** — `user/factory/UserFactory.java` creates `Admin` / `Student` / `Warden` role objects.
- **Facade Pattern** — `booking/facade/HostelFacade.java` runs a full student flow (book room → log complaint → pay fee) in one call, mirroring your original `studentOperations()`.
- **Strategy Pattern** — `fee/strategy/FeeStrategy.java` with `MonthlyFee` / `YearlyFee`, chosen at runtime.
- **Observer Pattern** — `observer/` package; `UserService` notifies subscribers (e.g. `NotificationObserver`, `LogObserver`) on registration.

## Domain Mapping (movie booking → hostel booking)

| Movie Booking | Hostel Booking | Purpose |
|---|---|---|
| `user` | `user` | Accounts (register/login) + role dashboards via Factory |
| `movie` | `room` | Catalog of hostel rooms |
| `show` | `allocation` | A specific bookable slot (room + duration + beds available) |
| `booking` | `booking` | A student booking beds in an allocation |
| `payment` | `fee` | Fee payment, via Strategy pattern |
| *(none)* | `complaint` | Your original complaint-registration feature |

## Project Structure

```
src/main/java/
├── TestDB.java, TestUser.java          Quick manual sanity checks (not JUnit)
├── user/         model, factory, db, dao, services, controller
├── room/          model, dao, service, controller
├── allocation/      model, dao, service, controller
├── booking/           model, dao, service, controller, facade (HostelFacade + TestBooking)
├── fee/                model, strategy, dao, service, controller
├── complaint/           model, dao, service, controller
├── observer/             Observer, Subject, LogObserver, NotificationObserver
└── test/                  UserObserverTest.java
SQL/hostel_schema.sql        Database schema
pom.xml
```

## Which file do you run?

**There's no single `Main.java`** — same as the movie booking project. Each `*Controller.java` (and the root-level `Test*.java` files) has its own `main()` method. In your IDE, right-click whichever one you want to try and choose **Run As → Java Application**:

| Run this file | To try |
|---|---|
| `TestDB.java` | Just check the DB connection works |
| `user/controller/UserController.java` | Register or log in, and see the Factory-created role dashboard |
| `test/UserObserverTest.java` | See both Observers fire on registration |
| `room/controller/RoomController.java` | Add/list rooms |
| `allocation/controller/AllocationController.java` | Create a room allocation (needs a room to already exist) |
| `booking/controller/BookingController.java` | Book beds in an allocation (needs an allocation to already exist) |
| `booking/facade/TestBooking.java` | See the full Facade flow: book + complaint + fee in one call |
| `fee/controller/FeeController.java` | Pay a fee directly, choosing Monthly or Yearly |
| `complaint/controller/ComplaintController.java` | Register/view complaints directly |

**Recommended order for a first run:** `RoomController` (add a room) → `AllocationController` (allocate it) → `BookingController` or `booking/facade/TestBooking` (book it).

## Setup

1. Run `SQL/hostel_schema.sql` against your MySQL server — creates the `HostelBookingSystem` database and all 6 tables.
2. Open `user/db/DBConnection.java` and confirm `username`/`password` match your MySQL setup (defaults: `root`/`root`).
3. Import as a Maven project (NetBeans, Eclipse, or IntelliJ all work — it's a plain Maven project).
4. Right-click any `*Controller.java` (or `Test*.java`) → Run As Java Application.

## Note

Like the movie booking project, this compiles/runs against JDK 17+ and needs `mysql-connector-j` on the classpath — Maven will pull that in automatically from `pom.xml` once you build the project (`mvn compile` or your IDE's build step).
