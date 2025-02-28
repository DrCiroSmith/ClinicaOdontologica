import { Schema, model } from 'mongoose';

const appointmentSchema = new Schema({
    patientId: {
        type: Schema.Types.ObjectId,
        required: true,
        ref: 'Patient'
    },
    date: {
        type: Date,
        required: true
    },
    time: {
        type: String,
        required: true
    },
    duration: {
        type: Number,
        required: true
    },
    status: {
        type: String,
        enum: ['scheduled', 'completed', 'canceled'],
        default: 'scheduled'
    },
    cancellationReason: {
        type: String,
        default: null
    }
}, {
    timestamps: true
});

export const Appointment = model('Appointment', appointmentSchema);