import { Schema, model } from 'mongoose';

const radiographSchema = new Schema({
    patientId: {
        type: Schema.Types.ObjectId,
        required: true,
        ref: 'Patient'
    },
    imageUrl: {
        type: String,
        required: true
    },
    analysisResults: {
        type: String,
        required: false
    },
    createdAt: {
        type: Date,
        default: Date.now
    },
    updatedAt: {
        type: Date,
        default: Date.now
    }
});

radiographSchema.pre('save', function(next) {
    this.updatedAt = Date.now();
    next();
});

const Radiograph = model('Radiograph', radiographSchema);

export default Radiograph;