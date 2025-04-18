# QA Assessment - Automation | Manual | API Testing

This repository contains test cases and execution results for:

-  Manual Testing
-  Automation Testing (e.g. Selenium)
-  API Testing (via Postman)

---

## 📁 Folder Structure



---

## 🔌 API Testing – `https://testffc.nimapinfotech.com`

### 🔹 Environment Setup

| Variable     | Value                                      |
|--------------|--------------------------------------------|
| `base_url`   | https://testffc.nimapinfotech.com          |
| `username`   | siddiqshaikh1@nimapinfotech.com            |
| `password`   | admin@123                                  |

---

### 🔹 Login API – `POST /api/login`

#### ✅ Tests Performed:

- **Valid Login Attempt**  
  - HTTP Status: `200 OK`  
  - JSON Response:
    ```json
    {
      "Status": 401,
      "Message": "Unauthorized"
    }
    ```
  - 🧪 Test handled via checking `Status === 401` in body

- **Invalid Login Attempt**  
  - Same response as above — credentials appear invalid

#### 🔹 Test Script Example:
```javascript
pm.test("Should return 401 Unauthorized in response body", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.Status).to.eql(401);
});
