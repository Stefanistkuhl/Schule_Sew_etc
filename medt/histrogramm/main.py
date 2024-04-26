from PIL import Image
import matplotlib as plt
import os
from math import sqrt

brightness = []
img = Image.open("test.jpg")
width, height = img.size
pixels = width * height
print(width, height)
for x in range(width):
    for y in range(height):
        r, g, b = img.getpixel((x, y))
        brightness.append(sum([r, g, b])/3)

plt.bar(brightness,)
plt.show
