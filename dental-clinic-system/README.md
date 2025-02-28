# Dental Clinic System

## Overview
The Dental Clinic System is a comprehensive application designed to manage various aspects of a dental clinic, including patient records, appointment scheduling, radiograph processing, and cancellation policies. The system aims to streamline operations and enhance the patient experience through an intuitive interface and efficient backend services.

## Features
- **Patient Management**: Create, retrieve, and manage patient records.
- **Radiograph Processing**: Upload and process multiple radiographs in batches, with individual viewing capabilities.
- **Dynamic Scheduling**: Adjust appointment schedules dynamically based on availability, with a calendar view for easy management.
- **Cancellation Policies**: Clearly outline and manage cancellation policies for patients.

## Project Structure
The project is organized into the following main directories:

- **src**: Contains the source code for both client and server components.
  - **client**: Frontend components and pages built with React.
  - **server**: Backend API and services built with Node.js and Express.
  - **shared**: Shared types and interfaces used across the application.

## Installation
1. Clone the repository:
   ```
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```
   cd dental-clinic-system
   ```
3. Install dependencies:
   ```
   npm install
   ```

## Usage
To start the application, run the following command:
```
npm start
```
This will initialize both the client and server components of the application.

## API Documentation
The API endpoints are organized as follows:
- **Patients**: `/api/patients`
- **Radiographs**: `/api/radiographs`
- **Scheduling**: `/api/scheduling`

Refer to the respective route files for detailed endpoint specifications.

## Contributing
Contributions are welcome! Please submit a pull request or open an issue for any enhancements or bug fixes.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.