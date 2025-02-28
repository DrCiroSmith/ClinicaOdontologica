import { Appointment } from '../models/Appointment';
import { CancellationPolicy } from '../models/CancellationPolicy';
import { Patient } from '../models/Patient';

interface ScheduleOptions {
    date: Date;
    patientId: string;
    duration: number; // in minutes
}

class SchedulingService {
    private appointments: Appointment[] = [];

    public scheduleAppointment(options: ScheduleOptions): Appointment {
        const appointment = new Appointment({
            date: options.date,
            patientId: options.patientId,
            duration: options.duration,
        });
        this.appointments.push(appointment);
        return appointment;
    }

    public cancelAppointment(appointmentId: string): boolean {
        const index = this.appointments.findIndex(app => app.id === appointmentId);
        if (index !== -1) {
            this.appointments.splice(index, 1);
            return true;
        }
        return false;
    }

    public getAppointmentsForPatient(patientId: string): Appointment[] {
        return this.appointments.filter(app => app.patientId === patientId);
    }

    public getAllAppointments(): Appointment[] {
        return this.appointments;
    }

    public applyCancellationPolicy(appointmentId: string): string {
        const appointment = this.appointments.find(app => app.id === appointmentId);
        if (!appointment) {
            return 'Appointment not found.';
        }

        const policy = new CancellationPolicy();
        // Logic to apply cancellation policy
        return policy.getPolicyDetails();
    }
}

export default new SchedulingService();