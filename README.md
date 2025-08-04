# 🎟️ Event Ticketing Platform

A full-stack event management system designed to handle the **entire event lifecycle** — from event creation to ticket validation. The platform serves three types of users: **Event Organizers**, **Event Attendees**, and **Event Staff**.

---

## 👥 User Roles & Features

### 1. **Event Organizers**
- Create and manage events
- Set ticket types, prices, and quantity limits
- Monitor ticket sales through dashboards

### 2. **Event Attendees**
- Search for upcoming events
- View ticket availability and pricing
- Purchase tickets securely
- Receive tickets with QR codes

### 3. **Event Staff**
- Validate tickets at entry points
- Scan QR codes for quick check-ins
- Fallback to manual validation when needed

---

## 🧩 Key Features

### ✅ Event Creation & Management
- Event details: name, date, time, venue
- Multiple ticket types (e.g., VIP, Regular) with:
  - Price variations
  - Quantity limits
- Duplicate event prevention
- REST API for event creation

### 💳 Ticket Purchase
- Event search and discovery
- Real-time ticket inventory management
- Secure payment integration
- REST API for ticket booking

### 📊 Sales Monitoring
- Sales metrics dashboard
- Automated sales control:
  - Quantity limits
  - Time-based ticket availability
- Purchaser data stored securely
- REST API for sales tracking

### 🛂 Ticket Validation
- QR code generation for each ticket
- Fast QR scanning at entry points
- Prevent duplicate or fraudulent entries
- Manual fallback validation mode

---

## ⚙️ Tech Stack

### Frontend (`/frontend`)
- React (Vite) with Typescript
- Tailwind CSS 
- Fetch API for backend integration

### Backend (`/tickets`)
- Java 21
- Spring Boot 3.5.4
- Spring Data JPA + PostgreSQL
- Spring Security with OAuth2
- Keycloak for authentication and authorization
- Adminer for database visualization
- QR Code generator ( ZXing)

---

## 🔐 Authentication & Authorization

- **OAuth2-based Login** via Keycloak
- Role-based access:
  - `ROLE_ORGANIZER`, `ROLE_ATTENDEE`, `ROLE_STAFF`
- Secure access to APIs via Bearer Tokens
- Keycloak Realm Configuration supports user management

---

## 🗂️ Database & Admin Panel

- **PostgreSQL** is used for relational data storage
- **Adminer** is integrated for DB browsing:
  - Accessible locally at `http://localhost:8081`
  - Login with DB credentials defined in `application.properties`

---

## 🚀 Getting Started

### 1. Clone the repository
```bash
git clone https://github.com/yourusername/event-ticketing-platform.git](https://github.com/Ninjasri98/Event-Ticketing-Platform
cd event-ticketing-platform
```

### 2. Start the backend
```bash
cd tickets
docker-compose up
./mvnw spring-boot:run
```

### 3. Start the frontend
```bash
cd ../frontend
npm install
npm run dev
```

## 🌟 About Me

Hi there! I'm **Sriparno Palit**. I’m a Computer Science undergrad with a keen interest towards the fields of data analytics, data engineering and software development
