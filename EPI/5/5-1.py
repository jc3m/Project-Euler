import unittest

def parity(word):
  """Brute force function to compute parity"""
  parity = 0
  while word != 0:
    word = word & (word-1)
    parity ^= 1
  return parity

class TestParity(unittest.TestCase):
  def test_basic(self):
    self.assertEqual(0, parity(0))
    self.assertEqual(1, parity(1))
    self.assertEqual(0, parity(0b01110001001010011))
    self.assertEqual(1, parity(0b01000010011010101))

if __name__ == '__main__':
  unittest.main()
