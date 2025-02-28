import { Router } from 'express';
import patientRoutes from './patients';
import radiographRoutes from './radiographs';
import schedulingRoutes from './scheduling';

const router = Router();

router.use('/patients', patientRoutes);
router.use('/radiographs', radiographRoutes);
router.use('/scheduling', schedulingRoutes);

export default router;