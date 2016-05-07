var fs = require('fs');

var lines = fs.readFileSync('013.txt', 'utf-8').split('\n');
console.log(lines);
var res = 0;
for (var i = 0; i < lines.length; i++) {
	res += +lines[i];
}

res = res + "";
console.log(res.substring(0, 11).replace('.', ''));
