import { Router } from 'express';
import { createAppointment, getAppointments, cancelAppointment } from '../controllers/schedulingController';
import { validateAppointment } from '../middlewares/validation';

const router = Router();

// Route to create a new appointment
router.post('/appointments', validateAppointment, createAppointment);

// Route to get all appointments
router.get('/appointments', getAppointments);

// Route to cancel an appointment
router.delete('/appointments/:id', cancelAppointment);

export default router;