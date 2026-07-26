from PIL import Image
import math

size = 4000

image = Image.new("RGBA", (size, size), (255, 255, 255, 0))

def clamp(value, minimum, maximum):
    return max(minimum, min(value, maximum))

def value_at(x, y):
    pos_x = (x / size) * 2.0 - 1.0
    pos_y = (y / size) * 2.0 - 1.0

    distance = pos_x * pos_x + pos_y * pos_y
    return math.sqrt(clamp(distance * 0.4, 0.0, 1.0))

pixels = image.load()

for i in range(size):
    for j in range(size):
        value = int(value_at(i, j) * 255)

        pixels[i, j] = (255, 255, 255, value)

image.save("../resources/assets/healthvignette/textures/vignette.png")
input("Press Enter to exit...")