import { Router } from 'express';
import { uploadRadiographs, getRadiographs, processBatchRadiographs } from '../controllers/radiographController';
import { validateRadiographUpload } from '../middlewares/validation';

const router = Router();

// Route to upload radiographs
router.post('/upload', validateRadiographUpload, uploadRadiographs);

// Route to get all radiographs
router.get('/', getRadiographs);

// Route to process batch of radiographs
router.post('/batch-process', processBatchRadiographs);

export default router;