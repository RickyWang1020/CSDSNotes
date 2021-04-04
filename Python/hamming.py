# A very basic implementation of Hamming Code
import numpy as np
from functools import reduce
import operator as op

arr = np.random.randint(0, 2, 16)
print("Original array: " + str(arr))
# Use xor operation to find the position of error
error_pos = reduce(op.xor, [i for i, bit in enumerate(arr) if bit])

if error_pos:
    print("Error occurred in position: " + str(error_pos))
    # flip the bit to correct the error
    arr[error_pos] = int(not arr[error_pos])

print("Corrected array: " + str(arr))
