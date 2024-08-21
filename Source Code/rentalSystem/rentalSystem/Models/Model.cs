using System;
using System.Collections.Generic;

namespace rentalSystem.Models
{
    public partial class Model
    {
        public Model()
        {
            Vehicles = new HashSet<Vehicle>();
        }

        public int ModelId { get; set; }
        public string ModelName { get; set; } = null!;
        public int? BrandId { get; set; }
        public int Charges { get; set; }

        public virtual Brand? Brand { get; set; }
        public virtual ICollection<Vehicle> Vehicles { get; set; }
    }
}
