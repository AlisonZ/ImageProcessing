/**
 * Filter that creates a negative representation of the image.
 **/
public class NegativeFilter implements Filter
{
  public void filter(PixelImage pi)
  {
    Pixel[][] data = pi.getData();

    for (int row = 0; row < pi.getHeight(); row++)
    {
      for (int col = 0; col < pi.getWidth(); col++)
      {
        Pixel temp = data[row][col];
        int newBlueValue = 255 - temp.blue > 0 ? 255 - temp.blue : 0;
        int newRedValue = 255 - temp.red > 0 ? 255 - temp.red : 0;
        int newGreenValue = 255 - temp.green > 0 ? 255 - temp.green : 0;

        Pixel newNegativePixel = new Pixel(newRedValue, newGreenValue, newBlueValue);
        data[row][col] = newNegativePixel;   
      }
    }

    pi.setData(data);
  }
}
