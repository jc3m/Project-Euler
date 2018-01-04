var fs = require('fs');
var file = fs.readFileSync('008.txt', 'utf-8');

var nums = file.split('\n').join('');

var prod, max = 0;
for (var i = 0; i < nums.length - 13; i++) {
	prod = 1;
	for (var j = 0; j < 13; j++) {
		prod *= +nums[i+j];
	}

	if (prod > max) {
		max = prod;
	}
}

console.log(max);
