# Week 7 Project — Spring Boot Weather App

## Context
I lost a bet with a friend and he challenged me that for the next 52 weeks, during weekends I need to create from scratch a new project.

For this week because of a busy schedule we decided on a quick app and went with weatherApp using an external API, and I will work on it only on saturday.

## The rules are the following:
*   Each Friday night, me and him will talk about what project I need to do.
*   Mostly he will decide for me, but I’m allowed to suggest and do my own ideas if he agrees on them.
*   Once the project is decided, he will tell me if I’m allowed to work Saturday and Sunday, or only Sunday.
(Surely this won’t backfire at some point by underestimating a project, right? 😅)

## About the project
This project is a simple web application that fetches and displays real-time weather data for a given city using **OpenWeatherMap API** to retrieve weather information.

The application allows a user to input a city name, and it will display the current temperature, weather conditions, and humidity.

## Features
*   Search for current weather by giving a city name.
*   Displays Temperature, Description, and Humidity.

## How to Run the Project Locally

To run this application, you first need a free API key to access the weather data.

### 1. Get Your Free API Key
1.  Go to the [OpenWeatherMap website](https://openweathermap.org/price) and sign up.
2.  Navigate to your account page and click on the **'API keys'** tab.
3.  Your default API key will be available there. Copy it for the next step.

### 2. Configure the Application
You have two ways to provide your API key to the application. You only need to do **one** of these.

#### Option A (Recommended): Using a `.env` file
This method keeps your secret key completely separate from the main source code.

1.  In the **root directory** of the project, create a file named `.env`.
2.  Add the following line to the file, replacing the placeholder with your actual API key:
    ```
    weather_api_key=your_key
    ```

#### Option B: Using the `application.properties` file
This method is quicker if you don't want to create a new file.

1.  Navigate to `src/main/resources/` and open the `application.properties` file.
2.  Uncomment the last line and paste your key after the equals sign:
    ```properties
    # weather_api_key=key
    ```

Open your web browser and navigate to **http://localhost:8080** to use the application.
