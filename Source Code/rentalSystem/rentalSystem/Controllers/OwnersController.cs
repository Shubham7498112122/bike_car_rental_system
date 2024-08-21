using System;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using rentalSystem.Models;

namespace rentalSystem.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class OwnersController : ControllerBase
    {
        private readonly bike_car_rental_portalContext _context;

        public OwnersController(bike_car_rental_portalContext context)
        {
            _context = context;
        }

        // POST: api/Owners/RegisterOwner
        [HttpPost("RegisterOwner")]
        public async Task<ActionResult<Owner>> RegisterOwner(OwnerRegistrationDto registrationDto)
        {
            // Validate input data
            if (await _context.Logins.AnyAsync(l => l.Username == registrationDto.Username))
            {
                return BadRequest(new { message = "Username is already taken" });
            }

            if (await _context.Owners.AnyAsync(o => o.Email == registrationDto.Email))
            {
                return BadRequest(new { message = "Email is already in use" });
            }

            if (await _context.Owners.AnyAsync(o => o.PhoneNumber == registrationDto.PhoneNumber))
            {
                return BadRequest(new { message = "Phone number is already in use" });
            }

            if (!IsValidPassword(registrationDto.Password))
            {
                return BadRequest(new { message = "Password must be at least 8 characters long, contain at least one uppercase letter, one special character, and one lowercase letter" });
            }

            if (!IsValidEmail(registrationDto.Email))
            {
                return BadRequest(new { message = "Invalid email format" });
            }

            if (!IsValidPhoneNumber(registrationDto.PhoneNumber))
            {
                return BadRequest(new { message = "Phone number must be a 10-digit number" });
            }

            // Create Login with the assigned role ID for owner
            var login = new Login
            {
                Username = registrationDto.Username,
                Password = registrationDto.Password,
                ActiveStatus = "Active",
                RoleId = 2 // Default role ID for owner
            };

            _context.Logins.Add(login);
            await _context.SaveChangesAsync();

            // Create Owner
            var owner = new Owner
            {
                Name = registrationDto.Name,
                Email = registrationDto.Email,
                PhoneNumber = registrationDto.PhoneNumber,
                Address = registrationDto.Address,
                UserId = login.UserId // Ensure UserId is correctly assigned
            };

            _context.Owners.Add(owner);

            try
            {
                await _context.SaveChangesAsync();
                return Ok(new { message = "Owner registration successful" });
            }
            catch (Exception ex)
            {
                // Handle exceptions gracefully
                // Log the error for debugging
                Console.WriteLine(ex.Message);
                return StatusCode(500, "An error occurred while registering the owner");
            }
        }

        // Password validation function
        private bool IsValidPassword(string password)
        {
            // At least 8 characters, including uppercase, lowercase, and special character
            var re = new System.Text.RegularExpressions.Regex(@"^(?=.*[a-z])(?=.*[A-Z])(?=.*\W).{8,}$");
            return re.IsMatch(password);
        }

        // Email validation function
        private bool IsValidEmail(string email)
        {
            var re = new System.Text.RegularExpressions.Regex(@"^[^\s@]+@[^\s@]+\.[^\s@]+$");
            return re.IsMatch(email);
        }

        // Phone number validation function
        private bool IsValidPhoneNumber(string phoneNumber)
        {
            var re = new System.Text.RegularExpressions.Regex(@"^\d{10}$");
            return re.IsMatch(phoneNumber);
        }
    }

    public class OwnerRegistrationDto
    {
        public string Username { get; set; }
        public string Password { get; set; }
        public string Name { get; set; }
        public string Email { get; set; }
        public string PhoneNumber { get; set; }
        public string Address { get; set; }
        // Add other registration fields specific to owners if necessary
    }
}
