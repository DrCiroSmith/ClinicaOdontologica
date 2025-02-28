import React from 'react';

const CancellationPolicy: React.FC = () => {
    return (
        <div>
            <h2>Cancellation Policy</h2>
            <p>
                We understand that sometimes plans change. If you need to cancel or reschedule your appointment, please do so at least 24 hours in advance to avoid any cancellation fees.
            </p>
            <h3>Cancellation Fees</h3>
            <ul>
                <li>No charge for cancellations made 24 hours in advance.</li>
                <li>A fee of $50 will be charged for cancellations made less than 24 hours in advance.</li>
                <li>Failure to show up for your appointment will result in a charge of the full appointment fee.</li>
            </ul>
            <h3>How to Cancel</h3>
            <p>
                You can cancel your appointment by calling our office or using the online scheduling system.
            </p>
        </div>
    );
};

export default CancellationPolicy;