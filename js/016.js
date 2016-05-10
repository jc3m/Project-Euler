var x = Math.pow(2, 1000);

sum = 0;

while (x != 0) {
	sum += x % 10;
	x = Math.floor(x /  10);
}

console.log(sum);
