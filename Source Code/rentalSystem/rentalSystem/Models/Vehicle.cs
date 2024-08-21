using System;
using System.Collections.Generic;

namespace rentalSystem.Models
{
    public partial class Vehicle
    {
        public Vehicle()
        {
            Bookings = new HashSet<Booking>();
        }

        public int VehicleId { get; set; }
        public int BuyingYear { get; set; }
        public int RegistrationNumber { get; set; }
        public int? ModelId { get; set; }
        public int? OwnerId { get; set; }
        public int? CategoryId { get; set; }

        public virtual Category? Category { get; set; }
        public virtual Model? Model { get; set; }
        public virtual Owner? Owner { get; set; }
        public virtual ICollection<Booking> Bookings { get; set; }
    }
}
