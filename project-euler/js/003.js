var num = 600851475143

var i = 2
while (i < num) {
	if (num % i == 0) {
		num = num / i
		i = 2
	}
	if (i == 2) {
		i += 1
	}
	else {
		i += 2
	}
}

console.log(num)