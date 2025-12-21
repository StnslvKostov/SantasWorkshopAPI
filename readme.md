# 🎅 Santa Gift Delivery API

A Spring Boot REST API that helps Santa manage **gifts**, **elves**, and **deliveries**.  
This project demonstrates clean backend design, RESTful principles, and practical Spring Boot skills.

---

## 📌 Project Goals

The goal of this project is to demonstrate knowledge of:

- RESTful endpoints (GET, POST, PUT, PATCH, DELETE)
- DTOs and validation
- Service layer & controller layer separation
- Proper error handling with HTTP status codes
- Basic filtering, sorting, and pagination
- Optional database usage (PostgreSQL)
- Clean, readable, maintainable code

**No authentication is required.**

---

##🗄️ Database Setup (PostgreSQL)

The application uses **PostgreSQL** as a persistence layer.  
The database schema was created and inspected using **DBeaver**, and all API endpoints were tested via **Postman**.

The following tables are required for the application to run:

### `gift` table
Stores all gifts managed by the system.

**Required columns:**
- `id` – primary key, auto-generated
- `name` – gift name
- `category` – enum (`TOY`, `BOOK`, `GADGET`, `CLOTHES`, `OTHER`)
- `target_age` – optional integer
- `is_wrapped` – boolean
- `status` – enum (`PENDING`, `READY`, `LOADED`, `DELIVERED`)
- `created_at` – timestamp

---

### `elf` table
Stores elves and their skill levels.

**Required columns:**
- `id` – primary key, auto-generated
- `name` – elf name
- `skill_level` – enum (`JUNIOR`, `MID`, `SENIOR`)

---

### `elf_assigned_gifts` table
Join table that links elves to assigned gifts.

**Required columns:**
- `elf_id` – foreign key to `elf.id`
- `gift_id` – ID of the assigned gift

---

### `delivery` table
Stores delivery plans.

**Required columns:**
- `id` – primary key, auto-generated
- `address` – delivery address
- `recipient_name` – recipient name
- `delivery_status` – enum (`PLANNED`, `IN_TRANSIT`, `DELIVERED`, `FAILED`)
- `estimated_arrival` – optional timestamp

---

### `delivery_gifts` table
Join table linking deliveries to gifts.

**Required columns:**
- `delivery_id` – foreign key to `delivery.id`
- `gift_id` – ID of the delivered gift

---

Hibernate automatically creates and manages these tables using the configured schema.  
No manual SQL setup is required beyond creating the PostgreSQL database itself.


