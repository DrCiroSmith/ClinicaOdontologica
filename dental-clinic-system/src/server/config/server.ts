import express from 'express';
import { json } from 'body-parser';
import cors from 'cors';
import { createServer } from 'http';
import { Server } from 'socket.io';

const app = express();
const server = createServer(app);
const io = new Server(server);

const PORT = process.env.PORT || 5000;

app.use(cors());
app.use(json());

// Define routes here
// Example: app.use('/api/patients', patientRoutes);

server.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});

export { app, server, io };