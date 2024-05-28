import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.io.*;


import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

class zipCodeClient {
  static File file = new File("src/app.config");
  
  ZipCode zipCode;

  zipCodeClient(String zip) throws IOException {
    final Scanner FileScanner = new Scanner(file);
    String API_URL = FileScanner.nextLine();
    //System.out.println(API_URL);
    URL url = new URL(API_URL + zip);
    //System.out.println(url);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");

    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    String line;
    StringBuilder response = new StringBuilder();
    while ((line = reader.readLine()) != null) {
      response.append(line);
    }
    reader.close();
    FileScanner.close();

    Gson gson = new Gson();
    zipCode = gson.fromJson(response.toString(), ZipCode.class);

  }

  String GetState() {

    return zipCode.getPlaces()[0].getStateAbbreviation();

  }
  String GetCity(){
    return zipCode.getPlaces()[0].getPlaceName();
  }
}

class ZipCode implements Serializable {
  @SerializedName("post code")
  private String postCode;
  private String country;

  @SerializedName("country abbreviation")
  private String countryabbreviation;
  private Place[] places;

  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCountryAbbreviation() {
    return countryabbreviation;
  }

  public void setCountryAbbreviation(String countryAbbreviation) {
    this.countryabbreviation = countryAbbreviation;
  }

  public Place[] getPlaces() {
    return places;
  }

  public void setPlaces(Place[] places) {
    this.places = places;
  }

  public static class Place implements Serializable {

    @SerializedName("place name")
    private String placename;
    private String longitude;
    private String state;

    @SerializedName("state abbreviation")
    private String stateabbreviation;
    private String latitude;

    public String getPlaceName() {
      return placename;
    }

    public void setPlaceName(String placeName) {
      this.placename = placeName;
    }

    public String getLongitude() {
      return longitude;
    }

    public void setLongitude(String longitude) {
      this.longitude = longitude;
    }

    public String getState() {
      return state;
    }

    public void setState(String state) {
      this.state = state;
    }

    public String getStateAbbreviation() {
      return stateabbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
      this.stateabbreviation = stateAbbreviation;
    }

    public String getLatitude() {
      return latitude;
    }

    public void setLatitude(String latitude) {
      this.latitude = latitude;
    }
  }
}