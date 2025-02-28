import React, { useState, useEffect } from 'react';
import { fetchAppointments, updateAppointment } from '../../../services/api';
import { Appointment } from '../../../shared/types/appointment';

const DynamicScheduler: React.FC = () => {
    const [appointments, setAppointments] = useState<Appointment[]>([]);
    const [loading, setLoading] = useState<boolean>(true);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        const loadAppointments = async () => {
            try {
                const data = await fetchAppointments();
                setAppointments(data);
            } catch (err) {
                setError('Failed to load appointments');
            } finally {
                setLoading(false);
            }
        };

        loadAppointments();
    }, []);

    const handleUpdateAppointment = async (appointmentId: string, newTime: string) => {
        try {
            await updateAppointment(appointmentId, { time: newTime });
            setAppointments((prev) =>
                prev.map((appointment) =>
                    appointment.id === appointmentId ? { ...appointment, time: newTime } : appointment
                )
            );
        } catch (err) {
            setError('Failed to update appointment');
        }
    };

    if (loading) return <div>Loading...</div>;
    if (error) return <div>{error}</div>;

    return (
        <div>
            <h2>Dynamic Appointment Scheduler</h2>
            <ul>
                {appointments.map((appointment) => (
                    <li key={appointment.id}>
                        {appointment.patientName} - {appointment.time}
                        <button onClick={() => handleUpdateAppointment(appointment.id, 'New Time')}>
                            Reschedule
                        </button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default DynamicScheduler;