# 🧠 Full-Stack Quiz Application (Spring Boot Ecosystem)

A full-stack enterprise-ready Quiz Application showcasing modern backend architectures and clean, dynamic web frontends. Originally inspired by the foundational courses by **Telusko (Navin Reddy)**, this project serves as a comprehensive portfolio piece demonstrating structural evolutionary design from a **Monolithic application** into a highly decoupled **Microservices architecture**.

---

## 🏗️ Architectural Evolution

This repository captures two core execution paradigms of modern software architecture:

### 1. The Monolithic Track
A unified, high-throughput service profile encapsulating object-relational mapping models, query controllers, and system workflows under a singular context. Excellent for immediate deployment, minimal networking overhead, and operational simplicity.

### 2. The Distributed Microservices Track
Re-engineered to support horizontal scaling, atomic failure zones, and isolated runtime responsibilities:
*   **`question-service`**: Autonomous microservice governing raw Question banks, handling localized CRUD operations, and computing targeted question allocations.
*   **`quiz-service`**: Processes business orchestrations, initiates global quiz structures, maps localized question payloads, and scores inbound user submissions.
*   **Service Mesh Ecosystem**: Utilizes **Spring Cloud Eureka Server** for dynamic service discovery and **OpenFeign Clients** for clean, declarative, type-safe inter-service REST communication (eliminating hardcoded URLs).

---

## 🛠️ Tech Stack Matrix

### Backend Core
*   **Spring Boot**: Main application framework ecosystem.
*   **Spring Data JPA / Hibernate**: Clean abstraction over underlying database engines.
*   **Spring Cloud (Eureka & OpenFeign)**: High-level configuration management and declarative routing for the microservices layer.
*   **Lombok**: Modern boiler-plate data encapsulation reduction.
*   **Database (PostgreSQL / MySQL)**: Relational datastore holding organized relational questions categorized by difficulty and technology tracking.

### Interactive Frontend
*   **JavaScript**: Manages interactive quiz states, state-driven score tallies, asynchronous REST fetches, and smooth page transitions.
*   **CSS / HTML**: Semantic interface elements styled into a clean, modern user layout.

---

## ✨ System Features

*   **Dynamic Quiz Construction**: The system queries individual pools based on criteria filters (e.g., *Category: Java*, *Count: 5 Questions*) and aggregates data objects dynamically.
*   **Decoupled Payload Delivery (DTOs)**: Leverages `QuestionWrapper` data transfer objects to hide answers and correct flags, shielding intellectual scoring data from the client inspect tool before submission.
*   **Instant Score Evaluation**: Collects client arrays, matches IDs asynchronously against real entity rows, and returns immediate evaluation data structures without complex frontend re-renders.

---

## 🚀 Quick Local Setup

### Prerequisites
*   JDK 17 or higher
*   Maven 3.6+
*   Your IDE of choice (IntelliJ IDEA highly recommended)
*   A running instance of your relational database

### Installation Sequence

1. **Clone and Enter the Workspace:**
   ```bash
   git clone [YOUR_PASTE_GITHUB_REPO_URL_HERE]
   cd [Your_Repository_Directory_Name]
