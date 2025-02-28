export interface Appointment {
    id: string;
    patientId: string;
    date: Date;
    time: string;
    duration: number; // in minutes
    status: 'scheduled' | 'completed' | 'canceled';
    notes?: string;
}

export interface AppointmentCancellation {
    appointmentId: string;
    reason: string;
    cancellationDate: Date;
}