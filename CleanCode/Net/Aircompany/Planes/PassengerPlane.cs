namespace Aircompany.Planes
{
    public class PassengerPlane : Plane
    {
        public int passengersCapacity;

        public PassengerPlane(string model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int _passengersCapacity)
            :base(model, maxSpeed, maxFlightDistance, maxLoadCapacity)
        {
            passengersCapacity = _passengersCapacity;
        }

        public override bool Equals(object obj)
        {
            return obj is PassengerPlane plane &&
                   base.Equals(obj) &&
                   passengersCapacity == plane.passengersCapacity;
        }

        public override int GetHashCode()
        {
            int coefficient = -1521134295;
            return 751774561 * coefficient + base.GetHashCode() * coefficient + passengersCapacity.GetHashCode();
        }

        public int GetPassengersCapacity()
        {
            return passengersCapacity;
        }

       
        public override string ToString()
        {
            return base.ToString().Replace("{", ", passengersCapacity=" + passengersCapacity + '}');
        }       
        
    }
}
