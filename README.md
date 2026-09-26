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
  ![Create Category](<img width="398" height="437" alt="Screenshot 2026-09-26 221651" src="https://github.com/user-attachments/assets/54ed2836-c8f0-4c57-adb0-8ae074449986" />
)

* **Get All Categories (GET):**
  ![Get All Categories](<img width="403" height="611" alt="Screenshot 2026-09-26 222247" src="https://github.com/user-attachments/assets/1cb3b996-97f8-482b-a8f7-067d21457ba2" />
)

### Item Endpoints
* **Create Item (POST):**
  ![Create Item](<img width="409" height="472" alt="Screenshot 2026-09-26 224104" src="https://github.com/user-attachments/assets/f07b6b70-e30b-4c78-a411-63c999d574f7" />
)

* **Get Category Items (GET):**
  ![Get Category Items](<img width="405" height="547" alt="Screenshot 2026-09-26 224131" src="https://github.com/user-attachments/assets/0e7bcb18-a987-4d6c-86f5-df22596e7a8a" />
)

---
