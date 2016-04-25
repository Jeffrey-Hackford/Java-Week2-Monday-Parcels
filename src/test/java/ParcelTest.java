import org.junit.*;
import static org.junit.Assert.*;

public class ParcelTest {

  @Test
public void newParcel_instantiatesCorrectly() {
  Parcel testParcel = new Parcel(2, 4, 2, 5);
  assertEquals(true, testParcel instanceof Parcel);
}
  @Test
  public void getLength_getsParcelLength_2() {
    Parcel testParcel = new Parcel(2, 4, 2, 5);
    assertEquals(2, testParcel.getLength());
  }
  @Test
  public void getWidth_getsParcelWidth_4() {
    Parcel testParcel = new Parcel(2, 4, 2, 5);
    assertEquals(4, testParcel.getWidth());
  }
  @Test
  public void getHeight_getsParcelHeight_2() {
    Parcel testParcel = new Parcel(2, 4, 2, 5);
    assertEquals(2, testParcel.getHeight());
  }
  @Test
  public void getWeight_getsParcelWeight_5() {
    Parcel testParcel = new Parcel(2, 4, 2, 5);
    assertEquals(5, testParcel.getWeight());
  }
  @Test
  public void getVolume_getsParcelVolume_16() {
    Parcel testParcel = new Parcel(2, 4, 2, 5);
    assertEquals(16, testParcel.getVolume());
  }
  @Test
  public void getCostOfShipping_getsParcelShippingCost_float() {
    Parcel testParcel = new Parcel(12, 14, 12, 25);
    assertEquals(12.86, testParcel.costOfShipping(), 0.0);
  }

}
