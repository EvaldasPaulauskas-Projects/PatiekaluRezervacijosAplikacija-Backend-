# PatiekaluRezervacijosAplikacija (Backend)

## Overview

The `PatiekaluRezervacijosAplikacija` is a backend application designed for food reservation management. This API enables users to create, read, update, and delete food items and reservations while providing an administrative interface for user management.

## API Endpoints

### User Endpoints

#### Food Management

- **Create Food**
  - `POST /food`
  - **Request Body**: `Food` object
  - **Permissions**: Public

- **Get All Foods**
  - `GET /foods`
  - **Response**: List of `Food` objects
  - **Permissions**: Public

- **Get Food by ID**
  - `GET /food/{id}`
  - **Response**: `Food` object
  - **Permissions**: Public

- **Update Food**
  - `PUT /food/{id}`
  - **Request Body**: `Food` object
  - **Permissions**: User with appropriate authority

- **Delete Food**
  - `DELETE /food/{id}`
  - **Response**: Success message
  - **Permissions**: User with appropriate authority

#### Reservation Management

- **Reserve Food**
  - `POST /reserve`
  - **Request Body**: `Reservation` object
  - **Permissions**: Authenticated User

- **Get All Reservations**
  - `GET /reserved/all`
  - **Response**: List of `Reservation` objects
  - **Permissions**: Authenticated User

- **Get Reservations by User ID**
  - `GET /reserved/{id}`
  - **Response**: List of `Reservation` objects
  - **Permissions**: Authenticated User

- **Delete Reservation by ID**
  - `DELETE /reserved/{id}`
  - **Response**: Success message
  - **Permissions**: Authenticated User

### Admin Endpoints

- **Get All Users**
  - `GET /admin/get-all-users`
  - **Response**: List of user information
  - **Permissions**: Admin

- **Get User by ID**
  - `GET /admin/get-users/{userId}`
  - **Response**: User information
  - **Permissions**: Admin

- **Get My Profile**
  - `GET /adminuser/get-profile`
  - **Response**: User profile information
  - **Permissions**: Admin, User

### Authentication Endpoints

- **Register**
  - `POST /auth/register`
  - **Request Body**: Registration details
  - **Permissions**: Public

- **Login**
  - `POST /auth/login`
  - **Request Body**: Login credentials
  - **Permissions**: Public

- **Refresh Token**
  - `POST /auth/refresh`
  - **Request Body**: Refresh token request
  - **Permissions**: Public

## Security Configuration

The application uses Spring Security for authentication and authorization:

- Public endpoints: `/auth/**`, `/public/**`, `/food`, `/foods`, `/food/{id}`, `/reserve`, `/reserved/all`, and `/auth/register` are accessible without authentication.
- Admin endpoints: `/admin/**` require an `ADMIN` authority.
- User endpoints: `/user/**` require a `USER` authority.

### Technologies Used

- Spring Boot
- Spring Security
- JPA / Hibernate
- H2 Database (or other database configurations)

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/PatiekaluRezervacijosAplikacija.git
   cd PatiekaluRezervacijosAplikacija

2. Run the application:
   ```bash
   ./mvnw spring-boot:run
