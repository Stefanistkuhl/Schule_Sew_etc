from PIL import Image
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
import pandas as pd

anz = np.zeros(256)
bright = np.arange(0,256, dtype=int)

img = Image.open("test.jpg")
width, height = img.size
pixels = width * height
for x in range(width):
    for y in range(height):
        r, g, b = img.getpixel((x, y))
        brightnes = sum([r,g,b])//3
        anz[brightnes] += 1

df = pd.DataFrame({'bright':bright, 'anz':anz}, columns=['bright','anz'])
print(df)
sns.set_style("darkgrid")
dig = sns.lineplot(x='bright', y='anz', data=df)
dig_fig =dig.get_figure()
dig_fig.savefig('plot.png')

