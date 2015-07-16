using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using experitestClient;

namespace Experitest
{
    [TestClass]
    public class Untitled
    {
        private string host = "localhost";
        private int port = 8889;
        private string projectBaseDirectory = "C:\\Users\\gmandala\\workspace\\project2";
        protected Client client = null;
        
        [TestInitialize()]
        public void SetupTest()
        {
            client = new Client(host, port, true);
            client.SetProjectBaseDirectory(projectBaseDirectory);
            client.SetReporter("xml", "reports", "Untitled");
        }

        [TestMethod]
        public void TestUntitled()
        {
            client.SetDevice("Cloud Devices");
            client.Click("default", "element 0", 0, 1);
        }

        [TestCleanup()]
        public void TearDown()
        {
            client.GenerateReport(true);
        }
    }
}