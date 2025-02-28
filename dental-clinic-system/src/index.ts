import express from 'express';
import { json } from 'body-parser';
import { connectToDatabase } from './server/config/database';
import apiRoutes from './server/api/routes/index';

const app = express();
const PORT = process.env.PORT || 5000;

// Middleware
app.use(json());

// Connect to the database
connectToDatabase();

// API Routes
app.use('/api', apiRoutes);

// Start the server
app.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`);
});