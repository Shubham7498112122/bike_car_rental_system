﻿using System;
using System.Collections.Generic;

namespace rentalSystem.Models
{
    public partial class Brand
    {
        public Brand()
        {
            Models = new HashSet<Model>();
        }

        public int BrandId { get; set; }
        public string BrandName { get; set; } = null!;

        public virtual ICollection<Model> Models { get; set; }
    }
}
