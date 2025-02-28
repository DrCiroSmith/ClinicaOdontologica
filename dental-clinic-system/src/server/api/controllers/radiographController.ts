import { Request, Response } from 'express';
import { Radiograph } from '../../models/Radiograph';
import { batchProcessRadiographs } from '../../services/batchProcessingService';
import { CancellationPolicy } from '../../models/CancellationPolicy';
import { getCancellationPolicy } from '../../services/cancellationService';

// Upload and process a single radiograph
export const uploadRadiograph = async (req: Request, res: Response) => {
    try {
        const radiographData = req.body;
        const newRadiograph = await Radiograph.create(radiographData);
        res.status(201).json(newRadiograph);
    } catch (error) {
        res.status(500).json({ message: 'Error uploading radiograph', error });
    }
};

// Batch process radiographs
export const batchUploadRadiographs = async (req: Request, res: Response) => {
    try {
        const radiographsData = req.body;
        const processedRadiographs = await batchProcessRadiographs(radiographsData);
        res.status(200).json(processedRadiographs);
    } catch (error) {
        res.status(500).json({ message: 'Error processing radiographs', error });
    }
};

// Get cancellation policy
export const fetchCancellationPolicy = async (req: Request, res: Response) => {
    try {
        const policy = await getCancellationPolicy();
        res.status(200).json(policy);
    } catch (error) {
        res.status(500).json({ message: 'Error fetching cancellation policy', error });
    }
};