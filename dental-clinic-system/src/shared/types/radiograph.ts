export interface Radiograph {
    id: string;
    patientId: string;
    imageUrl: string;
    createdAt: Date;
    updatedAt: Date;
    status: 'pending' | 'processed' | 'error';
    analysisResults?: AnalysisResult[];
}

export interface AnalysisResult {
    id: string;
    radiographId: string;
    findings: string;
    recommendations: string;
    createdAt: Date;
}