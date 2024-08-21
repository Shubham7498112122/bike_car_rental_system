using System;
using System.Collections.Generic;

namespace rentalSystem.Models
{
    public partial class Category
    {
        public Category()
        {
            Vehicles = new HashSet<Vehicle>();
        }

        public int CategoryId { get; set; }
        public string CategoryName { get; set; } = null!;
        public int Deposit { get; set; }

        public virtual ICollection<Vehicle> Vehicles { get; set; }
    }
}
