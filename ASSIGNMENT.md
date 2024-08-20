## Sign In 
1. Users log in to the system with their credentials.
   1. User credentials simply are `email` and `password`.

## Sign Up
1. Users should be able to sign up with `first name`, `last name`, `email`, `password` and `confirm password`.

## Confirmation Email   
1. A `confirmation email` should be sent to the _email address_ with which the user completed its registration.
2. Confirmation emails should have a specific validity date range and token to represent a specific user registration. 
   1. Expired tokens should not be validated at the back-end.

## User Cases

### Browsing Books
* Book records should be listed in a data table for the columns: `title`, `category`, `ISBN`.

### Searching Books
* Books should be searched with one of the criteria: `title`, `category`, `ISBN`.

