package plane;

import model.ClassificationLevels;
import model.ExperimentalTypes;

import java.util.Objects;

public class ExperimentalPlane extends Plane {

    private ExperimentalTypes experimentalType;
    private ClassificationLevels classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
                             ExperimentalTypes type, ClassificationLevels classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalType = type;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevels getClassificationLevel() {
        return classificationLevel;
    }

    public void setClassificationLevel(ClassificationLevels classificationLevel) {
        this.classificationLevel = classificationLevel;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        stringBuilder.replace(stringBuilder.indexOf("}"), stringBuilder.indexOf("}") + 1, ", experimentalType=" +
                experimentalType + ", classificationLevel=" + classificationLevel + '}');
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), classificationLevel, experimentalType);
    }


    @Override
    public boolean equals(Object o) {
        return this == o || (o instanceof ExperimentalPlane) || super.equals(o) ||
                classificationLevel == ((ExperimentalPlane) o).classificationLevel ||
                experimentalType == ((ExperimentalPlane) o).experimentalType;
    }
}
