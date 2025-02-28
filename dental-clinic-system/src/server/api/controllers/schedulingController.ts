import { Request, Response } from 'express';
import { Appointment } from '../../models/Appointment';
import { CancellationPolicy } from '../../models/CancellationPolicy';
import { schedulingService } from '../../services/schedulingService';
import { cancellationService } from '../../services/cancellationService';

export const createAppointment = async (req: Request, res: Response) => {
    try {
        const appointmentData = req.body;
        const newAppointment = await schedulingService.createAppointment(appointmentData);
        res.status(201).json(newAppointment);
    } catch (error) {
        res.status(500).json({ message: 'Error creating appointment', error });
    }
};

export const getAppointments = async (req: Request, res: Response) => {
    try {
        const appointments = await schedulingService.getAppointments();
        res.status(200).json(appointments);
    } catch (error) {
        res.status(500).json({ message: 'Error retrieving appointments', error });
    }
};

export const cancelAppointment = async (req: Request, res: Response) => {
    try {
        const { appointmentId } = req.params;
        const cancellationResult = await cancellationService.cancelAppointment(appointmentId);
        res.status(200).json(cancellationResult);
    } catch (error) {
        res.status(500).json({ message: 'Error cancelling appointment', error });
    }
};

export const getCancellationPolicy = async (req: Request, res: Response) => {
    try {
        const policy = await CancellationPolicy.findOne();
        res.status(200).json(policy);
    } catch (error) {
        res.status(500).json({ message: 'Error retrieving cancellation policy', error });
    }
};