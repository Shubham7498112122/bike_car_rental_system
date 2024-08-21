using System;
using System.Collections.Generic;

namespace rentalSystem.Models
{
    public partial class Booking
    {
        public Booking()
        {
            Payments = new HashSet<Payment>();
        }

        public int BookingId { get; set; }
        public string StartingDate { get; set; } = null!;
        public int? CustomerId { get; set; }
        public int? VehicleId { get; set; }
        public string BookingDate { get; set; } = null!;
        public string EndDate { get; set; } = null!;
        public string Status { get; set; } = null!;

        public virtual Customer? Customer { get; set; }
        public virtual Vehicle? Vehicle { get; set; }
        public virtual ICollection<Payment> Payments { get; set; }
    }
}
