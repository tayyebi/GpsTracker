using Quartz;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;

namespace WebApi.Controllers
{
    public class SmsJobs : IJob
    {
        public void Execute(IJobExecutionContext context)
        {
            try
            {
                // throw new NotImplementedException();
                TestServiceReference.TrezSmsServiceSoapClient t = new TestServiceReference.TrezSmsServiceSoapClient();

                string res = t.GetReciveMessage(About.sms_username, About.sms_password, About.sms_number);
                string[] resp = res.Split('$');
                foreach (var respo in resp)
                {

                    // A 100 200
                    // B 300 400 9388063351 5

                    // In case A: Latitude Longitude ZoneId
                    // In case B: Latitude Longitude PhoneNumber ZoneId


                    string respon = respo.Split('-')[0];
                    string[] args = respon.Split(' ');
                    switch (args[0])
                    {
                        case "A":
                            new GroupAController().Get(args[1], args[2], args[3]);
                            break;
                        case "B":
                            new GroupBController().Get(args[1], args[2], args[3], args[4]);
                            break;
                        default:
                            break;
                    }
                }
            }
            catch { }
        }
    }
}