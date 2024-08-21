using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;

namespace rentalSystem.Models
{
    public partial class Owner
    {
        public Owner()
        {
            Vehicles = new HashSet<Vehicle>();
        }

        public int OwnerId { get; set; }
        public string Name { get; set; } = null!;
        public string Email { get; set; } = null!;

        public string PhoneNumber { get; set; }
        public string Address { get; set; } = null!;
        public int? UserId { get; set; }

        public virtual Login? User { get; set; }
        public virtual ICollection<Vehicle> Vehicles { get; set; }
    }
}
