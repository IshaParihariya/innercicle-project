# 🌸 InnerCircle

A safe space just for girls 💕
Share your thoughts, express freely, and connect without judgment ✨

---

## 🚀 Features

* 🔐 User Registration & Login
* 🧑‍💼 Profile with bio & profile picture
* 📝 Create and view posts (Feed)
* 💬 Real-time-like chat system
* 🧠 Built using Hibernate + Servlets (no Spring 👀)

---

## 🛠️ Tech Stack

* Java (Servlets & JSP)
* Hibernate ORM
* PostgreSQL
* HTML, CSS
* Apache Tomcat

---

## 🏗️ Project Structure

The project follows a layered architecture:

```
src/main/java/com/isha/
│
├── model → Entity classes (User, Post, ChatMessage)
├── dao → Database interaction (CRUD using Hibernate)
├── service → Business logic layer
├── servlet → Controller layer (handles HTTP requests)

webapp/
│
├── *.jsp → Frontend views (UI)
├── css/ → Styling

resources/
│
├── hibernate.cfg.xml
├── hibernatechat.cfg.xml
├── hibernatepost.cfg.xml

```
---

### 🧠 Architecture Used
- MVC Pattern (Model-View-Controller)
- Layered Architecture (DAO → Service → Servlet)

## 📸 Application Flow

### 🏠 Home Page

![Home](assets/screenshots/index.png)

### 📝 Register

![Register](assets/screenshots/register.png)

### 🔐 Login

![Login](assets/screenshots/login.png)

### 👩‍💼 Dashboard

![Dashboard](assets/screenshots/useracc.png)

### 📰 Feed

![Feed](assets/screenshots/feed.png)

### 👥 Select User (chat)

![Chat Users](assets/screenshots/chatusers.png)

### 💬 Chat

![Chat](assets/screenshots/chat.png)

---

## ⚙️ How to Run

1. Clone the repo

   ```bash
   git clone https://github.com/IshaParihariya/innercircle-project.git
   ```

2. Open in IntelliJ / Eclipse

3. Configure PostgreSQL DB

4. Run on Apache Tomcat

---

## 🌟 Highlight

This project demonstrates:

* Hibernate ORM (Entity, Mapping, Fetching)
* File handling (profile picture as BYTEA)
* MVC architecture using Servlets
* Full CRUD operations

---

## 💡 Future Improvements

* Spring Boot migration
* WebSocket-based real-time chat
* Likes & comments on posts
* UI enhancements

---

## 👩‍💻 Author

**Isha Parihariya** 💖

BTech CSE | Java Developer
