using Aircompany.Models;
using Aircompany.Planes;
using System.Collections.Generic;
using System.Linq;

namespace Aircompany
{
    public class Airport
    {
        public List<Plane> planes;

        public Airport(IEnumerable<Plane> _planes)
        {
            planes = _planes.ToList();
        }

        public List<PassengerPlane> GetPassengersPlanes()
        {
            return planes.Where(plane => plane.GetType() == typeof(PassengerPlane)).Cast<PassengerPlane>().ToList();
        }

        public List<MilitaryPlane> GetMilitaryPlanes()
        {
            return planes.Where(plane => plane.GetType() == typeof(MilitaryPlane)).Cast<MilitaryPlane>().ToList();
        }

        public PassengerPlane GetPassengerPlaneWithMaxPassengersCapacity()
        {
            return GetPassengersPlanes().Aggregate((w, x) => w.GetPassengersCapacity() > x.GetPassengersCapacity() ? w : x);             
        }

        public IEnumerable<MilitaryPlane> GetTransportMilitaryPlanes()
        {
            return GetMilitaryPlanes().Where(plane => plane.GetPlaneType() == MilitaryType.Transport);
        }

        public Airport GetAirportWithSortedPlanesByMaxFlightDistance()
        {
            return new Airport(planes.OrderBy(w => w.GetMaxFlightDistance()));
        }

        public Airport GetAirportWithSortedPlanesByMaxSpeed()
        {
            return new Airport(planes.OrderBy(w => w.GetMS()));
        }

        public Airport GetAirportWithSortedPlanesByMaxLoadCapacity()
        {
            return new Airport(planes.OrderBy(w => w.GetMaxLoadCapacity()));
        }


        public IEnumerable<Plane> GetPlanes()
        {
            return planes;
        }

        public override string ToString()
        {
            return "Airport{" + "planes=" + string.Join(", ", planes.Select(x => x.GetModel())) + '}';
        }
    }
}
