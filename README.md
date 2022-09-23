## Problem Statement:

Geocoding is the process of converting the address like (Bellandur, Bangalore) into
geographic coordinates (like latitude: 12.9337127 and longitude: 77.6621937).

- You are given an input file of locations
- Your program should accept this file and generate an output file which contains the geo-coordinates of those locations

**Example:**

### Input File :

```java
Bangalore
Lucknow
Delhi
```

### Output F File :

```java
12.96557, 77.60625
26.85579, 80.939247
28.557163, 77.163665
```

## Requirements

- Java(JRE) Version 17 or higher
- Request/Response Interceptor tools like Postman

## Usage :

- Download the GeoCoder-0.0.1-SNAPSHOT.jar from Artificat foler
- Run the following command

```bash
    java -jar GeoCoder-0.0.1-SNAPSHOT.jar
```

### Steps :

Go to Postman and follow the steps as shown :

- Make a Post Request to url

```url
localhost:8080/upload-file
```

Use key as **file** and your input file as value
![Step 1 ](https://raw.githubusercontent.com/devmohit-live/GeoCoder/main/assets/a.JPG?token=GHSAT0AAAAAABV4B2BADKMCRLLDQAGINXLIYZOENOQ)

- Yoy will get the following response

![Step 2 ](https://raw.githubusercontent.com/devmohit-live/GeoCoder/main/assets/b.JPG?token=GHSAT0AAAAAABV4B2BBTO73YJAHSTN3BVBIYZOESRA)

- Double Click on the url value

![Step 3 ](https://raw.githubusercontent.com/devmohit-live/GeoCoder/main/assets/c.JPG?token=GHSAT0AAAAAABV4B2BBAPI2JJZBZNOGXKOKYZOETYA)

- Click Send and You will get and URL for output file containing all the geo cordinated for respective inputs in your input file

![Step 4 ](https://raw.githubusercontent.com/devmohit-live/GeoCoder/main/assets/d.JPG?token=GHSAT0AAAAAABV4B2BBGA3IF2WLACV4EVAKYZOEQ2A)
