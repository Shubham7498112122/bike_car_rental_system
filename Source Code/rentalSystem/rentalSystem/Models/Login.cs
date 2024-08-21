using System;
using System.Collections.Generic;

namespace rentalSystem.Models
{
    public partial class Login
    {
        public Login()
        {
            Customers = new HashSet<Customer>();
            Owners = new HashSet<Owner>();
        }

        public int UserId { get; set; }
        public string Username { get; set; } = null!;
        public string? Password { get; set; }
        public string ActiveStatus { get; set; } = null!;
        public int? RoleId { get; set; }

        public virtual Role? Role { get; set; }
        public virtual ICollection<Customer> Customers { get; set; }
        public virtual ICollection<Owner> Owners { get; set; }
    }
}
