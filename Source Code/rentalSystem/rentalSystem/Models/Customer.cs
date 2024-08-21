using System;
using System.Collections.Generic;

namespace rentalSystem.Models
{
    public partial class Customer
    {
        public Customer()
        {
            Bookings = new HashSet<Booking>();
        }

        public int CustomerId { get; set; }
        public string? Name { get; set; }
        public string? Email { get; set; }
        public string PhoneNumber { get; set; } = null!;
        public string DrivingLicenceNo { get; set; } = null!;
        public string AadharNumber { get; set; } = null!;
        public int? UserId { get; set; }

        public virtual Login? User { get; set; }
        public virtual ICollection<Booking> Bookings { get; set; }
    }
}
