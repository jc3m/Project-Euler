var cap = 1000;

for (var i = 1; i < cap; i++) {
	for (var j = 1; j < 1000 - i; j++) {
		var c = 1000 - i - j;
		if (Math.pow(i, 2) + Math.pow(j, 2) == Math.pow(c, 2)) {
			console.log(i * j * c);
		}
	}
}
