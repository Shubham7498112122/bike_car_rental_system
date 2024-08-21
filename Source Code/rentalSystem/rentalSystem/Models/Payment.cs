using System;
using System.Collections.Generic;

namespace rentalSystem.Models
{
    public partial class Payment
    {
        public int PaymentId { get; set; }
        public int? BookingId { get; set; }
        public string PaymentDate { get; set; } = null!;
        public int Amount { get; set; }
        public string PaymentMethod { get; set; } = null!;

        public virtual Booking? Booking { get; set; }
    }
}
