import nodemailer from 'nodemailer';

const transporter = nodemailer.createTransport({
    service: 'gmail',
    auth: {
        user: process.env.EMAIL_USER,
        pass: process.env.EMAIL_PASS,
    },
});

export const sendAppointmentConfirmation = async (email: string, appointmentDetails: any) => {
    const mailOptions = {
        from: process.env.EMAIL_USER,
        to: email,
        subject: 'Appointment Confirmation',
        text: `Your appointment is confirmed for ${appointmentDetails.date} at ${appointmentDetails.time}.`,
    };

    try {
        await transporter.sendMail(mailOptions);
    } catch (error) {
        console.error('Error sending appointment confirmation email:', error);
    }
};

export const sendCancellationNotice = async (email: string, appointmentDetails: any) => {
    const mailOptions = {
        from: process.env.EMAIL_USER,
        to: email,
        subject: 'Appointment Cancellation',
        text: `Your appointment scheduled for ${appointmentDetails.date} at ${appointmentDetails.time} has been cancelled.`,
    };

    try {
        await transporter.sendMail(mailOptions);
    } catch (error) {
        console.error('Error sending cancellation notice email:', error);
    }
};