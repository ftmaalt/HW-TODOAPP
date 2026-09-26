# HW-TODOAPP

A Spring Boot RESTful API to manage to-do list categories and items.
## Endpoints
 
### 1. Category Endpoints
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/api/categories` | Add a new category |
| `GET` | `/api/categories` | List all categories |
| `GET` | `/api/categories/{categoryId}` | Get a single category by ID |
| `PUT` | `/api/categories/{categoryId}` | Update an existing category by ID |
| `DELETE` | `/api/categories/{categoryId}` | Delete a category by ID |

---

### 2. Item Endpoints
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/api/categories/{categoryId}/items` | Add a new item under a specific category |
| `GET` | `/api/categories/{categoryId}/items` | List all items belonging to a category |
| `GET` | `/api/categories/{categoryId}/items/{itemId}` | Get a single item by ID within a category |
| `PUT` | `/api/categories/{categoryId}/items/{itemId}` | Update an item by ID within a category |
| `DELETE` | `/api/categories/{categoryId}/items/{itemId}` | Delete an item by ID from a category |

---
## Screenshots

Add your Postman testing screenshots in your repository (e.g., inside an `assets/` or `images/` directory) and link them below:

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
