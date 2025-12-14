# Integration Builder – Backend Assignment

## Overview
This application provides a generic and configurable integration framework to fetch users from external SaaS platforms. All API details, authentication, pagination, and field mappings are stored in the database, allowing changes without redeploying the application.

## Features
- Supports multiple external integrations (e.g., Calendly, Dropbox)
- Dynamic API URLs and field mappings via database
- Single generic API client to call external services
- Stores fetched users in a temporary table
- Calendly integration implemented

## Tech Stack
- Java 11
- Spring Boot 2.7
- Spring Data JPA
- H2 Database

## Configuration (Important)
Before running the application, update the Calendly API token in data.sql.

## APIs
- Fetch users:
  GET /integrations/{integrationName}/fetch-users

- View users:
  GET /integrations/temp-users

## How to Run
1. Start the application
2. Open H2 console: http://localhost:8081/h2-console
3. Call the fetch users API for Calendly
