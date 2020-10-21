using Aircompany.Models;

namespace Aircompany.Planes
{
    public class MilitaryPlane : Plane
    {
        public MilitaryType militaryType;

        public MilitaryPlane(string model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryType _militaryType)
            : base(model, maxSpeed, maxFlightDistance, maxLoadCapacity)
        {
            militaryType = _militaryType;
        }

        public override bool Equals(object obj)
        {
            return obj is MilitaryPlane plane &&
                   base.Equals(obj) &&
                   militaryType == plane.militaryType;
        }

        public override int GetHashCode()
        {
            int coefficient = -1521134295;
            return 1701194404 * coefficient + base.GetHashCode()*coefficient+militaryType.GetHashCode();
        }

        public MilitaryType GetPlaneType()
        {
            return militaryType;
        }


        public override string ToString()
        {
            return base.ToString().Replace("{", ", type=" + militaryType + '}');
        }        
    }
}
