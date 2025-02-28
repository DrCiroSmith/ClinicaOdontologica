import { CancellationPolicy } from '../models/CancellationPolicy';
import { Appointment } from '../models/Appointment';

export const getCancellationPolicy = async () => {
    try {
        const policy = await CancellationPolicy.findOne();
        return policy;
    } catch (error) {
        throw new Error('Error fetching cancellation policy');
    }
};

export const processCancellation = async (appointmentId: string) => {
    try {
        const appointment = await Appointment.findById(appointmentId);
        if (!appointment) {
            throw new Error('Appointment not found');
        }

        // Implement cancellation logic here
        appointment.status = 'Cancelled';
        await appointment.save();

        return appointment;
    } catch (error) {
        throw new Error('Error processing cancellation: ' + error.message);
    }
};