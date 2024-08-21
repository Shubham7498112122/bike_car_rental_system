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
    public class CustomersController : ControllerBase
    {
        private readonly bike_car_rental_portalContext _context;

        public CustomersController(bike_car_rental_portalContext context)
        {
            _context = context;
        }

        // POST: api/Customers/RegisterCustomer
        [HttpPost("RegisterCustomer")]
        public async Task<ActionResult<Customer>> Register(CustomerRegistrationDto registrationDto)
        {
            // Validate input data
            if (await _context.Logins.AnyAsync(l => l.Username == registrationDto.Username))
            {
                return BadRequest(new { message = "Username is already taken" });
            }

            if (await _context.Customers.AnyAsync(c => c.Email == registrationDto.Email))
            {
                return BadRequest(new { message = "Email is already in use" });
            }

            if (await _context.Customers.AnyAsync(c => c.PhoneNumber == registrationDto.PhoneNumber))
            {
                return BadRequest(new { message = "Phone number is already in use" });
            }

            if (await _context.Customers.AnyAsync(c => c.AadharNumber == registrationDto.AadharNumber))
            {
                return BadRequest(new { message = "Aadhar number is already in use" });
            }

            if (await _context.Customers.AnyAsync(c => c.DrivingLicenceNo == registrationDto.DrivingLicenceNo))
            {
                return BadRequest(new { message = "Driving Licence No is already in use" });
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

            if (!IsValidAadharNumber(registrationDto.AadharNumber))
            {
                return BadRequest(new { message = "Aadhar number must be a 12-digit number" });
            }

            if (string.IsNullOrWhiteSpace(registrationDto.DrivingLicenceNo))
            {
                return BadRequest(new { message = "Driving Licence No cannot be empty" });
            }

            // Create Login with default RoleId of 3 (customer role)
            var login = new Login
            {
                Username = registrationDto.Username,
                Password = registrationDto.Password,
                ActiveStatus = "Active", // Or default status
                RoleId = 3 // Default role ID for customer
            };

            _context.Logins.Add(login);
            await _context.SaveChangesAsync();

            // Create Customer
            var customer = new Customer
            {
                Name = registrationDto.Name,
                Email = registrationDto.Email,
                PhoneNumber = registrationDto.PhoneNumber,
                DrivingLicenceNo = registrationDto.DrivingLicenceNo,
                AadharNumber = registrationDto.AadharNumber,
                UserId = login.UserId // Assuming UserId is auto-generated
            };

            _context.Customers.Add(customer);

            try
            {
                await _context.SaveChangesAsync();
                return Ok(new { message = "Customer registration successful" });
            }
            catch (Exception ex)
            {
                // Handle exceptions gracefully
                // Log the error for debugging
                Console.WriteLine(ex.Message);
                return StatusCode(500, "An error occurred while registering the Customer");
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

        // Aadhar number validation function
        private bool IsValidAadharNumber(string aadharNumber)
        {
            var re = new System.Text.RegularExpressions.Regex(@"^\d{12}$");
            return re.IsMatch(aadharNumber);
        }
    }
    public class CustomerRegistrationDto
    {
        public string Username { get; set; }
        public string Password { get; set; }
        public string Name { get; set; }
        public string Email { get; set; }
        public string PhoneNumber { get; set; }
        public string DrivingLicenceNo { get; set; }
        public string AadharNumber { get; set; }
    }
}
