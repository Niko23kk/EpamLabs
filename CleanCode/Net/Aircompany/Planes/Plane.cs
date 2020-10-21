using System.Collections.Generic;

namespace Aircompany.Planes
{
    public abstract class Plane
    {
        public string model;
        public int maxSpeed;
        public int maxFlightDistance;
        public int maxLoadCapacity;

        public Plane(string _model, int _maxSpeed, int _maxFlightDistance, int _maxLoadCapacity)
        {
            model = _model;
            maxSpeed = _maxSpeed;
            maxFlightDistance = _maxFlightDistance;
            maxLoadCapacity = _maxLoadCapacity;
        }

        public string GetModel()
        {
            return model;
        }

        public int GetMS()
        {
            return maxSpeed;
        }

        public int GetMaxFlightDistance()
        {
            return maxFlightDistance;
        }

        public int GetMaxLoadCapacity()
        {
            return maxLoadCapacity;
        }

        public override string ToString()
        {
            return "Plane{" + "model='" + model + '\'' + ", maxSpeed=" + maxSpeed + ", maxFlightDistance="
                + maxFlightDistance + ", maxLoadCapacity=" + maxLoadCapacity + '}';
        }

        public override bool Equals(object obj)
        {
            return obj is Plane plane &&
                   model == plane.model &&
                   maxSpeed == plane.maxSpeed &&
                   maxFlightDistance == plane.maxFlightDistance &&
                   maxLoadCapacity == plane.maxLoadCapacity;
        }

        public override int GetHashCode()
        {
            var coefficient = -1521134295;
            return (((-1043886837 * coefficient) + EqualityComparer<string>.Default.GetHashCode(model)) *
                   coefficient + maxSpeed.GetHashCode()) * coefficient + maxFlightDistance.GetHashCode() *
                   coefficient + maxLoadCapacity.GetHashCode();
        }        

    }
}
