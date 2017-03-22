using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using WebApi.Models;

namespace WebApi.Controllers
{
    public class GroupAController : ApiController
    {
        public DcDataContext dc = new DcDataContext();
        // GET api/values
        public class Response
        {
            public int Id { get; set; }
            public double Latitude { get; set; }
            public double Longitude { get; set; }
            public int ResponsePositionId { get; set; }
        }
        public class Response2
        {
            public int Id { get; set; }
            public double Latitude { get; set; }
            public double Longitude { get; set; }
            public int ZoneId { get; set; }
        }

        public IEnumerable<Response> Get()
        {
            var resu = dc.GroupA_Positions.Select(x => new Response { Id = x.Id, Latitude = x.Latitude, Longitude = x.Longitude, ResponsePositionId = x.GroupB_PositionId }).OrderByDescending(x => x.Id).ToList();
            return resu;
        }

        public Response2 Get(string Longitude, string Latitude, string ZoneId)
        {

            // Search algorithm here
            var positions = dc.GroupB_Positions;
            int count = positions.Count();
            var position = positions.Skip(new Random().Next(count)).FirstOrDefault();

            try
            {
                // Save the log
                dc.GroupA_Positions.InsertOnSubmit(new GroupA_Position
                {
                    Longitude = double.Parse(Longitude),
                    Latitude = double.Parse(Latitude),
                    GroupB_PositionId = position.Id
                });

                dc.SubmitChanges();
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }

            return new Response2 { ZoneId = position.ZoneId, Id = position.Id, Latitude = position.Latitude, Longitude = position.Longitude };
        }

    }
}
