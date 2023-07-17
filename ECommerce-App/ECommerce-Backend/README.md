# Personal-Projects
This is a backend implementation of business case 'Cart for E-Commerce Application'


User Sign Up:

Users provide their Email, First Name, Last Name, and Password.
If the username (Email) is already registered, an error message is displayed.
If the username is available, the information is stored.

User Sign In:

Users provide their Email and Password.
If the provided credentials are valid, a unique session ID is generated.
This session ID will be used for subsequent requests and needs to be validated.

Session Validation:

The session ID is passed in subsequent requests to authenticate the user.
The session ID needs to be validated before processing the request.
The session is considered valid only for 30 minutes.
After 30 minutes of inactivity, the session will expire, and the user will need to sign in again to obtain a new session ID.
