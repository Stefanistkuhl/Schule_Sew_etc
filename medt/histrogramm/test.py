from PIL import Image

img = Image.open("plot.png")
overlay = Image.open("legende.png")

img.paste(overlay, (1228,82))

img.show()

