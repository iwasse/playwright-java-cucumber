Feature: Login Functionality
    As a user
    I want to log in to the application
    So that I can access my account

    Scenario: Successful login with valid credentials
        Given the user is on the login page
        When the user login with valid credentials
        Then the user should be redirected to the dashboard

    Scenario: Unsuccessful login with invalid credentials
        Given the user is on the login page
        When the user login with invalid credentials "Admin" and "wrongpassword"
        Then an error message should be displayed indicating invalid login

    Scenario: Password recovery
        Given the user is on the login page
        When the user clicks on the "Forgot Password" link
        And the user submits their email address for password recovery
        Then a password recovery email should be sent to the user's email address