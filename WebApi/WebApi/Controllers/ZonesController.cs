using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using WebApi.Models;

namespace WebApi.Controllers
{
    public class ZonesController : ApiController
    {
        public DcDataContext dc = new DcDataContext();
        // GET api/values
       public class Response
        {
            public int Id { get; set; }
            public string Name { get; set; }
        }
        public IEnumerable<Response> Get()
        {
            var resu = dc.GroupB_Zones.Select(y => new Response { Id = y.Id, Name = y.Name });
            return resu;
        }


    }
}
