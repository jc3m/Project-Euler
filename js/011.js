var fs = require('fs');

function hMult(i, j, matrix) {
	if (j + 3 >= matrix[i].length)
		return 0;
	var res = 1;
	for (var k = 0; k < 4; k++) {
		res *= matrix[i][j+k];
	}
	return res;
}

function vMult(i, j, matrix) {
	if (i + 3 >= matrix.length)
		return 0;
	var res = 1;
	for (var k = 0; k < 4; k++) {
		res *= matrix[i+k][j];
	}
	return res;
}

function duMult(i, j, matrix) {
	if (j + 3 >= matrix[i].length || i - 3 <= 0)
		return 0;
	var res = 1;
	for (var k = 0; k < 4; k++) {
		res *= matrix[i-k][j+k];
	}
	return res;
}

function ddMult(i, j, matrix) {
	if (j + 3 >= matrix[i].length || i + 3 >= matrix[i].length)
		return 0;
	var res = 1;
	for (var k = 0; k < 4; k++) {
		res *= matrix[i+k][j+k];
	}
	return res;
}

var file = fs.readFileSync('011.txt', 'utf-8');
var rows = file.split('\n');
var matrix = [];
for (var i = 0; i < rows.length; i++) {
	matrix.push(rows[i].split(' '));
}

var max = 0;

for (var i = 0; i < matrix.length; i++) {
	for (var j = 0; j < matrix[i].length; j++) {
		var x = hMult(i, j, matrix);
		if (x > max)
			max = x;
		x = vMult(i, j, matrix);
		if (x > max)
			max = x;
		x = ddMult(i, j, matrix);
		if (x > max)
			max = x;
		x = duMult(i, j, matrix);
		if (x > max)
			max = x;
	}
}

console.log(max);
