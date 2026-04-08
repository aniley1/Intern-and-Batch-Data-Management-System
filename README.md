# 🚀 Intern & Batch Data Management System (IDMS)

A full-stack web application developed to manage interns and batches efficiently.
This system allows administrators to create, manage, and track interns, batches, and their relationships using a modern tech stack.

---

## 📌 Project Overview

The **Intern & Batch Data Management System (IDMS)** is designed to simplify the management of interns and batch records in an organization.
It provides features like CRUD operations, filtering, and real-time data handling with a clean UI.

---

## 🛠️ Tech Stack

### 🔹 Backend

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL

### 🔹 Frontend

* Angular (Standalone Components)
* Angular Material
* TypeScript
* HTML, CSS

---

## ✨ Features

* 👨‍🎓 Intern Management (Add, View, Delete)
* 📦 Batch Management (Create, View)
* 🔍 Search & Filter Interns
* 🔗 Intern-Batch Relationship Mapping
* 📊 Dynamic Data Rendering (Angular Material Table)
* 🧩 REST API Integration
* ⚡ Responsive UI

---

## 📂 Project Structure

```
idms-project/
│
├── backend/ (Spring Boot)
│   ├── controller/
│   ├── service/
│   ├── repository/
│   └── model/
│
├── frontend/ (Angular)
│   ├── components/
│   ├── services/
│   ├── models/
│   └── layout/
│
└── README.md
```

---

## ⚙️ Setup Instructions

### 🔧 Backend Setup

1. Navigate to backend folder:

```bash
cd backend
```

2. Run Spring Boot application:

```bash
mvn spring-boot:run
```

3. Backend runs on:

```
http://localhost:8080
```

---

### 💻 Frontend Setup

1. Navigate to frontend folder:

```bash
cd idms-frontend
```

2. Install dependencies:

```bash
npm install
```

3. Run Angular app:

```bash
ng serve
```

4. Open in browser:

```
http://localhost:4200
```

---

## 🔗 API Endpoints (Sample)

| Method | Endpoint          | Description     |
| ------ | ----------------- | --------------- |
| GET    | /api/interns      | Get all interns |
| POST   | /api/interns      | Add new intern  |
| DELETE | /api/interns/{id} | Delete intern   |
| GET    | /api/batches      | Get all batches |

---

## 🧠 Learnings

* Full-stack development (Spring Boot + Angular)
* REST API integration
* Angular Material UI design
* Debugging frontend-backend issues
* Handling relational data (JPA)

---

## ⚠️ Challenges Faced

* Data not rendering in Angular table
* Module import issues in Angular
* API integration debugging

✔ Resolved using proper data binding, module configuration, and debugging techniques.

---

## 🚀 Future Enhancements

* Update/Edit functionality
* Authentication & Authorization (JWT)
* Dashboard & Analytics
* Export data (PDF/Excel)

---

## 👨‍💻 Author

**Arnav Kumar**
MCA (2025-26)
Intern @ The Skybrisk

---

## 📄 License

This project is for educational and internship purposes.

---
