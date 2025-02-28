import { Router } from 'express';
import { createPatient, getPatients, getPatientById, updatePatient, deletePatient } from '../controllers/patientController';
import { validatePatient } from '../middlewares/validation';

const router = Router();

// Route to create a new patient
router.post('/', validatePatient, createPatient);

// Route to get all patients
router.get('/', getPatients);

// Route to get a patient by ID
router.get('/:id', getPatientById);

// Route to update a patient
router.put('/:id', validatePatient, updatePatient);

// Route to delete a patient
router.delete('/:id', deletePatient);

export default router;