import React, { useState } from 'react';

const BatchProcessing: React.FC = () => {
    const [files, setFiles] = useState<File[]>([]);
    const [processingStatus, setProcessingStatus] = useState<string>('');

    const handleFileChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        if (event.target.files) {
            const selectedFiles = Array.from(event.target.files);
            setFiles(selectedFiles);
        }
    };

    const handleBatchProcess = async () => {
        setProcessingStatus('Processing...');
        try {
            // Simulate an API call to process the batch of radiographs
            await new Promise((resolve) => setTimeout(resolve, 2000));
            setProcessingStatus('Batch processing completed successfully!');
        } catch (error) {
            setProcessingStatus('Error processing batch.');
        }
    };

    return (
        <div>
            <h2>Batch Processing of Radiographs</h2>
            <input type="file" multiple onChange={handleFileChange} />
            <button onClick={handleBatchProcess} disabled={files.length === 0}>
                Process Batch
            </button>
            {processingStatus && <p>{processingStatus}</p>}
        </div>
    );
};

export default BatchProcessing;