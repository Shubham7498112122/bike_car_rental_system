﻿using System;
using System.Collections.Generic;

namespace rentalSystem.Models
{
    public partial class City
    {
        public City()
        {
            Areas = new HashSet<Area>();
        }

        public int CityId { get; set; }
        public string CityName { get; set; } = null!;

        public virtual ICollection<Area> Areas { get; set; }
    }
}
