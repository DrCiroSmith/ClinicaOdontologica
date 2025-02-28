import { Request, Response, NextFunction } from 'express';
import { body, validationResult } from 'express-validator';

export const validateRadiographUpload = [
    body('patientId').isInt().withMessage('Patient ID must be an integer'),
    body('images').isArray().withMessage('Images must be an array'),
    body('images.*.url').isURL().withMessage('Each image must have a valid URL'),
    (req: Request, res: Response, next: NextFunction) => {
        const errors = validationResult(req);
        if (!errors.isEmpty()) {
            return res.status(400).json({ errors: errors.array() });
        }
        next();
    }
];

export const validateAppointmentCreation = [
    body('patientId').isInt().withMessage('Patient ID must be an integer'),
    body('date').isISO8601().withMessage('Date must be a valid ISO8601 date'),
    body('time').isString().withMessage('Time must be a string'),
    (req: Request, res: Response, next: NextFunction) => {
        const errors = validationResult(req);
        if (!errors.isEmpty()) {
            return res.status(400).json({ errors: errors.array() });
        }
        next();
    }
];

export const validateCancellationRequest = [
    body('appointmentId').isInt().withMessage('Appointment ID must be an integer'),
    (req: Request, res: Response, next: NextFunction) => {
        const errors = validationResult(req);
        if (!errors.isEmpty()) {
            return res.status(400).json({ errors: errors.array() });
        }
        next();
    }
];