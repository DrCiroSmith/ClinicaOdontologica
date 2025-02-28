import { Radiograph } from '../models/Radiograph';
import { processRadiograph } from './radiographProcessingService';

export const batchProcessRadiographs = async (radiographIds: string[]) => {
    const results = [];

    for (const id of radiographIds) {
        try {
            const radiograph = await Radiograph.findById(id);
            if (radiograph) {
                const result = await processRadiograph(radiograph);
                results.push({ id, result });
            } else {
                results.push({ id, error: 'Radiograph not found' });
            }
        } catch (error) {
            results.push({ id, error: error.message });
        }
    }

    return results;
};