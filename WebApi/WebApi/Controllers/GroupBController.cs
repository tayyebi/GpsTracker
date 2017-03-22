using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using WebApi.Models;

namespace WebApi.Controllers
{
    public class GroupBController : ApiController
    {
        public class Response
        {
            public int Id { get; set; }
            public double Latitude { get; set; }
            public double Longitude { get; set; }
            public string Phone { get; set; }
            public string ZoneName { get; set; }
        }
        public DcDataContext dc = new DcDataContext();
        // GET api/values
        public IEnumerable<Response> Get()
        {
            var g = dc.GroupB_Positions.Select(x => new Response { Id = x.Id, Latitude = x.Latitude, Longitude = x.Longitude, Phone = x.Phone, ZoneName = x.GroupB_Zone.Name }).ToList();
            var res = from e in g
                      group e by e.Phone
                  into groups
                      select groups.OrderByDescending(p => p.Id).First();
            return res.OrderByDescending(u => u.Id);
        }

        public string Get(string Latitude, string Longitude, string PhoneNumber, string ZoneId)
        {
            try
            {
                dc.GroupB_Positions.InsertOnSubmit(new GroupB_Position
                {
                    Longitude = float.Parse(Longitude),
                    Latitude = float.Parse(Latitude),
                    Phone = PhoneNumber,
                    ZoneId = int.Parse(ZoneId)
                });

                dc.SubmitChanges();
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
            return String.Empty;
        }
    }
}