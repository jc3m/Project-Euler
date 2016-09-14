function squareOfSum(upper) {
  var res = (upper)*(upper+1)/2
  return Math.pow(res, 2);
}

function sumOfSquares(upper) {
  return (upper)*(2*upper + 1)*(upper + 1)/6;
}

console.log((squareOfSum(100)-sumOfSquares(100)));
