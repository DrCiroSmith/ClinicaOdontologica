export interface CancellationPolicy {
    id: number;
    description: string;
    noticePeriod: number; // in hours
    feePercentage: number; // percentage of the appointment fee
}

export const defaultCancellationPolicy: CancellationPolicy = {
    id: 1,
    description: "Cancellations must be made at least 24 hours in advance to avoid a cancellation fee.",
    noticePeriod: 24,
    feePercentage: 50,
};