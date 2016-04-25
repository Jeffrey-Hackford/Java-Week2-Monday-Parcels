import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class Parcel {
  // start interface logic
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/parcel", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int length = Integer.parseInt(request.queryParams("length"));
      int width = Integer.parseInt(request.queryParams("width"));
      int height = Integer.parseInt(request.queryParams("height"));
      int weight = Integer.parseInt(request.queryParams("weight"));

      Parcel myParcel = new Parcel(length, width, height, weight);
      model.put("myParcel", myParcel);

      model.put("template", "templates/parcel.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
  // end interface logic
  // start business logic
  private int mLength;
  private int mWidth;
  private int mHeight;
  private int mWeight;

  public Parcel(int length, int width, int height, int weight) {
    mLength = length;
    mWidth = width;
    mHeight = height;
    mWeight = weight;
  }
  public int getLength() {
    return mLength;
  }

  public int getWidth() {
    return mWidth;
  }

  public int getHeight() {
    return mHeight;
  }

  public int getWeight() {
    return mWeight;
  }

  public int getVolume() {
    int volume = mLength * mWidth * mHeight;
    return volume;
  }

  public double costOfShipping() {
    double dimensionalWeight = (mLength * mWidth * mHeight) / 166.0;
    double intCost = mWeight - dimensionalWeight;
    return Math.round(intCost*100.0)/100.0;
  }
  // end business logic
}
