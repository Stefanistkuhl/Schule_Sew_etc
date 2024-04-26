from PIL import Image
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
import pandas as pd

def oida():
    img = Image.open("plot.png")
    overlay = Image.open("legende.png")

    img.paste(overlay, (1228,82))

    img = img.save("plot.png")

anz = np.zeros(256)
anz_r = np.zeros(256)
anz_g = np.zeros(256)
anz_b = np.zeros(256)
bright = np.arange(0,256, dtype=int)

file = "test.jpg"
img = Image.open(file)
width, height = img.size
pixels = width * height
for x in range(width):
    for y in range(height):
        r, g, b = img.getpixel((x, y))
        anz_r[r] += 1
        anz_g[g] += 1
        anz_b[b] += 1
        brightnes = sum([r,g,b])//3
        anz[brightnes] += 1

df = pd.DataFrame({'bright':bright, 'anz':anz, 'anz_r': anz_r, 'anz_g':anz_g, 'anz_b':anz_b}, columns=['bright','anz'])
data_preproc = pd.DataFrame({
    'bright':bright,
    'Helligkeit':anz,
    'Rot':anz_r,
    'Grün':anz_g,
    'Blau':anz_b})

palette = {
    'Helligkeit': 'tab:gray',
    'Rot': 'tab:red',
    'Grün': 'tab:green',
    'Blau': 'tab:blue',
}

sns.set_style("darkgrid")
sns.set(rc={"figure.figsize":(15, 6)})
dig = sns.lineplot(x='bright', y='value',hue='variable', palette=palette,linewidth=3,alpha=0, data=pd.melt(data_preproc,['bright']))
dig.set(xlabel ="Helligkeit", ylabel = "Anzahl", title ='Histogramm von '+ file)
dig.fill_between(data_preproc.bright.values,data_preproc.Rot.values, color = 'r',alpha=0.7)
dig.fill_between(data_preproc.bright.values,data_preproc.Grün.values, color = 'g',alpha=0.7)
dig.fill_between(data_preproc.bright.values,data_preproc.Blau.values, color = 'b',alpha=0.7)
dig.fill_between(data_preproc.bright.values,data_preproc.Helligkeit.values, color = '#c7c7c7')
dig_fig =dig.get_figure()
dig_fig.savefig('plot.png')
oida()
