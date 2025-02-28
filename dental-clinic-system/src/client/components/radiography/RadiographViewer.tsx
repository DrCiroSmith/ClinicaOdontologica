import React from 'react';

const RadiographViewer: React.FC<{ radiograph: string; analysisResults: string }> = ({ radiograph, analysisResults }) => {
    return (
        <div className="radiograph-viewer">
            <h2>Radiograph Viewer</h2>
            <img src={radiograph} alt="Radiograph" />
            <div className="analysis-results">
                <h3>Analysis Results</h3>
                <p>{analysisResults}</p>
            </div>
        </div>
    );
};

export default RadiographViewer;