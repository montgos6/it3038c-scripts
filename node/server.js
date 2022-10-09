const http = require("http");
const fs = require("fs");
const os = require("os");
const ip = require("ip");

String.prototype.toHHMMSS = function () {
    var sec_num = parseInt(this, 10);
    var hours   = Math.floor(sec_num / 3600);
    var minutes = Math.floor((sec_num - (hours * 3600)) / 60);
    var seconds = sec_num - (hours * 3600) - (minutes * 60);

    if (hours   < 10) {hours   = "0"+hours;}
    if (minutes < 10) {minutes = "0"+minutes;}
    if (seconds < 10) {seconds = "0"+seconds;}
    var time    = hours+':'+minutes+':'+seconds;
    return time;
}
const server = http.createServer((req, res) => {
	if(req.url === "/") {
		fs.readFile("./public/index.html", "UTF-8", (err, body) => {
		res.writeHead(200, {"Content-Type": "text/html"});
		res.end(body);
		});
	}else if(req.url.match("/sysinfo")) {
		var time = process.uptime();
		var uptime = (time + "").toHHMMSS();
		var Tmb =(Math.floor(os.totalmem() / 1048576) + " MB");
		var Fmb =(Math.floor(os.freemem() / 1048576) + " MB");
			myHostName=os.hostname();
			html=`
			<!DOCTYPE html>
			<html>
				<head>
					<title>Node JS Response</title>
				</head>
				<body>
					<p>Hostname: ${myHostName}</p>
					<p>IP: ${ip.address()}</p>
					<p>Server Uptime: ${uptime}</p>
					<p>Total Memory: ${Tmb}</p>
					<p>Free Memory: ${Fmb}</p>
					<p>CPUs: ${os.cpus().length}</p>
				</body>
			</html>`
			res.writeHead(200, {"Content-Type": "text/html"});
			res.end(html);
	} else {
		res.writeHead(404, {"Content-Type": "text/plain"});
		res.end('404 File Not Found at ${req.url}');
	}
}).listen(3000);

console.log("Server listening on port 3000");