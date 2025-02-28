import { Request, Response } from 'express';
import { Patient } from '../../models/Patient';
import { CancellationPolicy } from '../../models/CancellationPolicy';
import { cancellationService } from '../../services/cancellationService';

// Create a new patient record
export const createPatient = async (req: Request, res: Response) => {
    try {
        const patientData = req.body;
        const newPatient = await Patient.create(patientData);
        res.status(201).json(newPatient);
    } catch (error) {
        res.status(500).json({ message: 'Error creating patient', error });
    }
};

// Retrieve patient records
export const getPatients = async (req: Request, res: Response) => {
    try {
        const patients = await Patient.findAll();
        res.status(200).json(patients);
    } catch (error) {
        res.status(500).json({ message: 'Error retrieving patients', error });
    }
};

// Retrieve a specific patient record
export const getPatientById = async (req: Request, res: Response) => {
    try {
        const patientId = req.params.id;
        const patient = await Patient.findByPk(patientId);
        if (patient) {
            res.status(200).json(patient);
        } else {
            res.status(404).json({ message: 'Patient not found' });
        }
    } catch (error) {
        res.status(500).json({ message: 'Error retrieving patient', error });
    }
};

// Update a patient record
export const updatePatient = async (req: Request, res: Response) => {
    try {
        const patientId = req.params.id;
        const updatedData = req.body;
        const [updated] = await Patient.update(updatedData, {
            where: { id: patientId }
        });
        if (updated) {
            const updatedPatient = await Patient.findByPk(patientId);
            res.status(200).json(updatedPatient);
        } else {
            res.status(404).json({ message: 'Patient not found' });
        }
    } catch (error) {
        res.status(500).json({ message: 'Error updating patient', error });
    }
};

// Delete a patient record
export const deletePatient = async (req: Request, res: Response) => {
    try {
        const patientId = req.params.id;
        const deleted = await Patient.destroy({
            where: { id: patientId }
        });
        if (deleted) {
            res.status(204).send();
        } else {
            res.status(404).json({ message: 'Patient not found' });
        }
    } catch (error) {
        res.status(500).json({ message: 'Error deleting patient', error });
    }
};

// Get cancellation policies
export const getCancellationPolicies = async (req: Request, res: Response) => {
    try {
        const policies = await CancellationPolicy.findAll();
        res.status(200).json(policies);
    } catch (error) {
        res.status(500).json({ message: 'Error retrieving cancellation policies', error });
    }
};