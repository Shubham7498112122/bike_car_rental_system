using System;
using System.Collections.Generic;
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
    public class LoginsController : ControllerBase
    {
        private readonly bike_car_rental_portalContext _context;

        public LoginsController(bike_car_rental_portalContext context)
        {
            _context = context;
        }

        [HttpPost("{username}/{password}")]
        public async Task<ActionResult<Login>> GetLogin(string username, string password)//async is used to perform asynchronun behaviour and it gives us functionality to use await inside
        {//task is for repressenting asynchronouns operations
            //Action result is return type
            if (_context.Logins == null)
            {
                return Unauthorized("Invalid username or password");
            }

            var login = await _context.Logins
                .Where(l => l.Username == username && l.Password == password)
                .Include(l => l.Role)
                .Include(l => l.Owners) // including data to query result
                .FirstOrDefaultAsync();//executes request asychronounsly

            if (login == null)
            {
                return Unauthorized("Invalid username or password");
            }

            return login;
        }
    }
}
