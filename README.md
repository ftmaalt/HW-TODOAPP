# HW-TODOAPP

A Spring Boot RESTful API to manage to-do list categories and items.

## Design Decisions & Reasons

- **Layered Architecture:** Organized into `controller`, `service`, `repository`, `model`, and `security` layers to keep code clean and easy to maintain.
- **Entity Relationships:**
  - `User` (1) to `UserProfile` (1): Keeps login credentials separate from user profile details.
  - `Category` (1) to `Item` (N): Allows users to group multiple todo items under specific categories.
- **JWT Security:** Used JSON Web Tokens (JWT) for stateless authentication so users log in once, receive a token, and use it to access protected endpoints.
- **Spring Profiles:** Used `application-dev.properties` to isolate local database settings from production settings.
  
## API Endpoints

### Auth Endpoints
| Method | Endpoint | Description | Access |
| :--- | :--- | :--- | :--- |
| `POST` | `/auth/users/register` | Register a new user | Public |
| `POST` | `/auth/users/login` | Login and get JWT token | Public |

### Category Endpoints
| Method | Endpoint | Description | Access |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/categories` | List all categories | Private |
| `POST` | `/api/categories` | Create a category | Private |
| `GET` | `/api/categories/{categoryId}` | Get category by ID | Private |
| `PUT` | `/api/categories/{categoryId}` | Update category by ID | Private |
| `DELETE` | `/api/categories/{categoryId}` | Delete category by ID | Private |

### Item Endpoints
| Method | Endpoint | Description | Access |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/categories/{categoryId}/items` | List items in category | Private |
| `POST` | `/api/categories/{categoryId}/items` | Create item in category | Private |
| `GET` | `/api/categories/{categoryId}/items/{itemId}` | Get single item by ID | Private |
| `PUT` | `/api/categories/{categoryId}/items/{itemId}` | Update item by ID | Private |
| `DELETE` | `/api/categories/{categoryId}/items/{itemId}` | Delete item by ID | Private |

---

## Screenshots

### Category Endpoints
* **Create Category (POST):**
<img width="403" height="611" alt="Screenshot 2026-09-26 222247" src="https://github.com/user-attachments/assets/75d1f441-8909-40a1-94e2-5508f5d70e01" />

* **Get All Categories (GET):**
<img width="398" height="437" alt="Screenshot 2026-09-26 221651" src="https://github.com/user-attachments/assets/79f5ed6d-acff-4221-b832-e30c0e43c317" />


### Item Endpoints
* **Create Item (POST):**
<img width="409" height="472" alt="Screenshot 2026-09-26 224104" src="https://github.com/user-attachments/assets/2d058a1d-1e9f-4528-aaaa-f91a61f77c9c" />


* **Get Category Items (GET):**
<img width="405" height="547" alt="Screenshot 2026-09-26 224131" src="https://github.com/user-attachments/assets/8d504a01-76d1-42f1-89b4-b281cdf80cf0" />


---
