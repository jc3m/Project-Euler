function isPrime(num, primeList) {
  for (var i = 0; i < primeList.length; i++) {
    if (num % primeList[i] == 0)
      return false;
  }
  return true;
}

var primes = [2,3];
var temp = primes[primes.length-1];

while (primes.length < 10001) {
  if (isPrime(temp, primes))
    primes.push(temp);
  temp += 2;
}

console.log(primes[primes.length-1]);
